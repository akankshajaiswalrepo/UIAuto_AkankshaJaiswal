package stepDefs.common;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BrowserEvents;
import utils.ParameterUtil;

import static org.junit.Assert.assertEquals;


public class CommonSteps {


    public void navigateToRegistrationPage() {
        String applicationURL = CommonSteps.getApplicationURL();
        //openBrowser(browser, applicationURL);
        verifyPageTitle("New User");
    }

    public void verifyPageTitle(String title) {
        String actualTitle = BrowserEvents.getTitle();
        String expectedTitle = title;
        assertEquals("Page title is not matching", expectedTitle, actualTitle);
    }

    public void verifyErrorMessage(String actualError, String expectedError) {
        assertEquals("Error message is not correct", expectedError, actualError);
    }

    public static final String getApplicationURL() {
        StringBuffer urlApp = new StringBuffer();
        urlApp.append(ParameterUtil.readConfigValue("env", "applicationUrl"));

        return urlApp.toString();
    }

    //This method is created to clean user data
    public static Response sendDeleteRequest() {
        RestAssured.baseURI = ParameterUtil.readConfigValue("env", "baseUri");
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("/all");

        return response;
    }

}
