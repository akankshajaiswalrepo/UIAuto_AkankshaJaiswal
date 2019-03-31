package utils;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stepDefs.common.Hooks;

public class BrowserEvents extends Hooks {

	public static WebElement getElement(By locator){
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static List<WebElement> getSubElements(WebElement element, By locator){
		return element.findElements(locator);
	}

    public static void click(By locator){
        driver.findElement(locator).click();
    }

    public static void clear(By locator){
        driver.findElement(locator).clear();
    }

    public static void type(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static String getTitle(){
        return driver.getTitle();
    }

    public static void waitAndclick(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void waitAndClear(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
    }

    public static void waitAndType(By locator, String value){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(value);
    }

    public static String waitAndGetText(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public static void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForInVisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}