package com.ownProject.regression.testNG;

import com.ownProject.backEnd.BackEndLogin;
import com.ownProject.backEnd.customerModule.AddNewCustomer;
import com.ownProject.backEnd.customerModule.CustomerDashboardPage;
import com.ownProject.backEnd.customerModule.DeleteExistingCustomer;
import com.ownProject.backEnd.customerModule.UpdateExistingCustomer;
import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerModule extends TestBase {
    BackEndLogin backEndLogin;
    CustomerDashboardPage customerDashboardPage;
    TestUtility testUtility;
    AddNewCustomer addNewCustomer;
    UpdateExistingCustomer updateExistingCustomer;
    DeleteExistingCustomer deleteExistingCustomer;


    @BeforeClass(alwaysRun = true)
    public static void setUp(){
        initialization("backEndUrl");
    }

    @BeforeMethod(alwaysRun = true)
    public void login(){
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(properties.getProperty("customerManagerUserName"), properties.getProperty("backEndPassword"));
    }

    //1.Customer Manager can add a new customer
    @Test
    public void customerManagerCanAddNewCustomer(){
        customerDashboardPage = new CustomerDashboardPage(driver);
        addNewCustomer = new AddNewCustomer(driver);
        addNewCustomer.addNewCustomer();
        Assert.assertTrue(addNewCustomer.verifyAddNewCustomerSuccessfully());
    }

    //2.Customer Manager can update an existing customer
    @Test(dependsOnMethods = "customerManagerCanAddNewCustomer")
    public void customerManagerCanUpdateExistingCustomer(){
        addNewCustomer = new AddNewCustomer(driver);
        addNewCustomer.clickOnFilteredCustomer();
        updateExistingCustomer = new UpdateExistingCustomer(driver);
        updateExistingCustomer.updateCustomerInfo();
        Assert.assertTrue(updateExistingCustomer.verifyUpdateCustomerSuccessfully());
    }

    //3.Customer Manager can delete an existing customer
    @Test
    public void customerManagerCanDeleteAnExistingCustomer(){
        deleteExistingCustomer = new DeleteExistingCustomer(driver);
        deleteExistingCustomer.enterDeleteCustomerPage();
        deleteExistingCustomer.clickDeleteCustomerIcon();
        Assert.assertTrue(deleteExistingCustomer.verifyDeleteCustomer());
    }

    @AfterMethod(alwaysRun = true)
    public void logout(){
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.clickLogoutButton();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown(){
        closeBrowser();
    }
}
