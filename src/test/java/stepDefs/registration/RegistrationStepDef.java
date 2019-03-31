package stepDefs.registration;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegistrationPage;
import stepDefs.common.CommonSteps;

public class RegistrationStepDef {

    RegistrationPage registration = new RegistrationPage();
    CommonSteps steps = new CommonSteps();

    @Given("^User navigates to new user registration page using browser from env json$")
    public void user_navigate_to_user_page(){
        steps.navigateToRegistrationPage();
    }


    @When("^User enters unique name as ([^\"]*)$")
    public void User_enters_unique_name_for_registration(String name){
        registration.inputName(name);
    }


    @When("^User enters unique email as ([^\"]*)$")
    public void User_enters_unique_email_for_registration(String email){
        registration.inputEmail(email);
    }


    @And("^User enters password as ([^\"]*) for registration$")
    public void User_enters_password_for_registration(String password){
        registration.inputPassword(password);
        registration.inputConfPassword(password);
        registration.submit();
    }


    @When("^User enters name as ([^\"]*), email as ([^\"]*) and password as ([^\"]*)$")
    public void User_enters_name_email_for_registration(String name, String email, String password){
        registration.createNewUser(name, email, password, password);
    }

    @When("^User enters name as ([^\"]*), email as ([^\"]*) and not same password as ([^\"]*)$")
    public void User_enters_name_email_pass_for_registration(String name, String email, String password){
        registration.createNewUser(name, email, password, "notSame");
    }


    @Then("^User registration fails for name uniqueness with error '(.*)'$")
    public void User_registration_fails_name_uniqueness(String nameError){
        registration.verifyUniqueNameError(nameError);
    }


    @Then("^User registration fails for email uniqueness with error '(.*)'$")
    public void User_registration_fails_email_uniqueness(String emailError){
        registration.verifyUniqueEmailError(emailError);
    }


    @Then("^User registration fails for invalid email with error '(.*)'$")
    public void User_registration_fails_invalid_email(String emailError){
        registration.verifyUniqueEmailError(emailError);
    }


    @Then("^User registration fails for password minimum characters with error '(.*)'$")
    public void User_registration_fails_password_minimum(String passError){
        registration.verifyMinimumPassError(passError);
    }


    @Then("^User registration fails for password not same with error '(.*)'$")
    public void User_registration_fails_password_not_same(String passError){
        registration.verifySamePassError(passError);
    }

    @Then("^User remains on new user page '(.*)'$")
    public void User_registration_fails(String pageTitle){
        CommonSteps steps = new CommonSteps();
        steps.verifyPageTitle(pageTitle);
    }

}
