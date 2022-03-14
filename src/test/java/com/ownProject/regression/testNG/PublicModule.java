package com.ownProject.regression.testNG;

import com.ownProject.frontEnd.CreateAnAccount;
import com.ownProject.frontEnd.LoginPage;
import com.ownProject.frontEnd.ViewOrders;
import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.*;

public class PublicModule extends TestBase {
    TestUtility testUtility;
    CreateAnAccount createAnAccount;
    LoginPage loginPage;
    ViewOrders viewOrders;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        initialization("frontEndUrl");
    }

    @BeforeMethod(alwaysRun = true)
    public void login(){
        loginPage = new LoginPage(driver);
        loginPage.publicModuleLogin(properties.getProperty("userName"),properties.getProperty("userPassword"));
    }

    @Test
    public void userShouldBeAbleToCreateAnAccount(){
        testUtility = new TestUtility(driver);
        createAnAccount = new CreateAnAccount(driver);
        testUtility.sleep(3);
        createAnAccount.createAnAccount(TestUtility.generateFakeFirstName(),TestUtility.generateFakeLastName(),
                TestUtility.randomEmailAddress(),TestUtility.generateRandomPassword());
        Assert.assertTrue(createAnAccount.verifyAccountCreated());
    }

    @Test
    public void userShouldBeAbleToViewHisOrder(){
        viewOrders = new ViewOrders(driver);
        viewOrders.clickOnMyOrderLink();
        Assert.assertTrue(viewOrders.verifySuccessMessage());
    }

    @AfterMethod(alwaysRun = true)
    public void logOut(){
        loginPage = new LoginPage(driver);
        loginPage.clickLogOutButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }
}
