package stepDefs.common;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ParameterUtil;
import utils.Report;

import java.io.File;
import java.io.IOException;

import static stepDefs.common.CommonSteps.sendDeleteRequest;

public class Hooks extends Report {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String applicationURL;

	static {
		Report.init();
		sendDeleteRequest();
		applicationURL = CommonSteps.getApplicationURL();
		launchBrowser();
	}

	public static void launchBrowser() {

		String browserType = ParameterUtil.readConfigValue("env", "browser" );


		if (browserType.equals("")) {
			browserType = determineEffectiveDriverType();

		}else if (browserType.toUpperCase().equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", getDriverPath() + "chromedriver");
			driver = new ChromeDriver();

		} else if (browserType.toUpperCase().equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", getDriverPath() + "geckodriver");
			driver = new FirefoxDriver();

		} else if (browserType.toUpperCase().equals("HTMLUNIT")) {
			driver = new HtmlUnitDriver(true);
		}
		wait = new WebDriverWait(driver, 60);
		driver.get(applicationURL);
	}

	@Before
	public static void openBrowser() {
		driver.navigate().to(applicationURL);
	}

	public static void closeBrowser() {
		if (null != driver) {
			driver.close();
		}
	}

	public static void quitBrowser() {
		if (null != driver) {
			driver.quit();
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				Reporter.addScreenCaptureFromPath(capture(screenshotName));
			}catch (IOException e) {
			}
		}

		if (null == driver) {
			launchBrowser();
		}
	}

	public static String capture(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "/screenshots/" + filename + System.currentTimeMillis()
				+ ".png";
		try {
			FileUtils.copyFile(screen, new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filepath;
	}


	private static String determineEffectiveDriverType() {
		String browser = "";

		if (System.getenv().get("BROWSERMODE") != null) {
			browser = System.getenv().get("BROWSERMODE").toUpperCase();
		}else {
			browser = "chrome";
		}

		return browser;
	}


	private static String getDriverPath() {
		String projectPath = System.getProperty("user.dir");

		String os = System.getProperty("os.name");

		if (os.toUpperCase().contains("MAC")) {
			return projectPath + "/src/test/resources/driver/mac/";

		}else if (os.toUpperCase().contains("WIN")) {
			return projectPath + "/src/test/resources/driver/windows/";

		}else if (os.toUpperCase().contains("NUX") ||
				os.toUpperCase().contains("NIX") ||
				os.toUpperCase().contains("SIX")) {
			return projectPath + "/src/test/resources/driver/linux/";

		}

		return null;
	}

}
