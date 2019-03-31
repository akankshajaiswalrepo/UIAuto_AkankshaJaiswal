package stepDefs.allUsers;


import cucumber.api.java.en.Then;
import pageObjects.AllUsersListPage;
import stepDefs.common.CommonSteps;

import static pageObjects.RegistrationPage.uniqueEmail;
import static pageObjects.RegistrationPage.uniqueName;
import static pageObjects.RegistrationPage.uniquePassword;;

public class AllUsersListStepDef {

    @Then("^Verify user details on all users page$")
    public void verify_user_details_allUsers_page() throws InterruptedException {

        AllUsersListPage alluserTable = new AllUsersListPage();
        alluserTable.manageUserdata(uniqueName, uniqueEmail, uniquePassword);
    }

    @Then("^User registration is successful and user navigates to all users page '(.*)'$")
    public void User_registration_successful(String pageTitle){
        CommonSteps steps = new CommonSteps();
        steps.verifyPageTitle(pageTitle);
    }
}