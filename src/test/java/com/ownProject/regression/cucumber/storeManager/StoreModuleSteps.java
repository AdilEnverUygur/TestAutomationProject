package com.ownProject.regression.cucumber.storeManager;

import com.ownProject.backEnd.storeModule.*;
import com.ownProject.testUtility.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreModuleSteps extends TestBase {
    static StoreManagerLogin storeManagerLogin;

    //Background
    @Given("manager is on Login page")
    public void managerIsOnLoginPage() {
        storeManagerLogin = new StoreManagerLogin(driver);
    }


    @When("manager enter username and password then click on login button")
    public void managerEnterUsernameAndPasswordThenClickOnLoginButton() {
        storeManagerLogin.login();
    }


    @Then("manager successfully login to the dashboard page")
    public void managerSuccessfullyLoginToTheDashboardPage() {
        storeManagerLogin.verifyLoginSuccessfully();
    }
}
