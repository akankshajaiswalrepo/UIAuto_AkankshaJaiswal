package pageObjects;

import org.openqa.selenium.By;
import utils.BrowserEvents;
import stepDefs.common.CommonSteps;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistrationPage {

    public static String uniqueName = "";
    public static String uniqueEmail = "";
    public static String uniquePassword = "";

    private By nameTextBox = By.id("name");
    private By emailTextBox = By.id("email");
    private By passwordTextBox = By.id("password");
    private By confirmPasswordTextBox = By.id("confirmationPassword");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By allUsersButton = By.xpath("//a[@href='/users/all']");

    private By nameFieldError = By.id("user.name.error");
    private By emailFieldError = By.id("user.email.error");
    private By passwordFieldError = By.id("user.password.error");
    private By confrimPassFieldError = By.id("user.confirmationPassword.error");

    CommonSteps steps = new CommonSteps();


    public void inputName(String name){

        BrowserEvents.click(nameTextBox);
        BrowserEvents.clear(nameTextBox);
        uniqueName = name.concat(getTimeStamp());
        BrowserEvents.type(nameTextBox, uniqueName);
    }

    public void inputEmail(String email){
        BrowserEvents.click(emailTextBox);
        BrowserEvents.clear(emailTextBox);
        uniqueEmail = email.concat(getTimeStamp()).concat("@abc.com");
        BrowserEvents.type(emailTextBox, uniqueEmail);
    }

    public void inputPassword(String password){
        BrowserEvents.click(passwordTextBox);
        BrowserEvents.clear(passwordTextBox);
        BrowserEvents.type(passwordTextBox, password);
        uniquePassword = password; 
    }

    public void inputConfPassword(String password){
        BrowserEvents.click(confirmPasswordTextBox);
        BrowserEvents.clear(confirmPasswordTextBox);
        BrowserEvents.type(confirmPasswordTextBox, password);
    }

    public void submit(){
        BrowserEvents.click(submitButton);
    }

    public void viewAllUser(){
        BrowserEvents.click(allUsersButton);
    }

    public void createNewUser(String name, String email, String password, String cnfpassword){
        BrowserEvents.type(nameTextBox, name);
        BrowserEvents.type(emailTextBox, email);
        BrowserEvents.type(passwordTextBox, password);
        BrowserEvents.type(confirmPasswordTextBox, cnfpassword);
        BrowserEvents.click(submitButton);
    }

    public void verifyUniqueNameError(String nameError){
        String actualError = BrowserEvents.getText(nameFieldError);
        steps.verifyErrorMessage(actualError, nameError);
    }

    public void verifyUniqueEmailError(String emailError){
        String actualError = BrowserEvents.getText(emailFieldError);
        steps.verifyErrorMessage(actualError, emailError);
    }

    public void verifyMinimumPassError(String passError){
        String actualError = BrowserEvents.getText(passwordFieldError);
        steps.verifyErrorMessage(actualError, passError);
    }

    public void verifySamePassError(String passError){
        String actualError = BrowserEvents.getText(confrimPassFieldError);
        steps.verifyErrorMessage(actualError, passError);
    }

    private String getTimeStamp(){
        String timeStamp = new SimpleDateFormat("MMdd_HHmmss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

}