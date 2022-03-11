package com.ownProject.regression.testNG;

import com.ownProject.frontEnd.CreateAnAccount;
import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublicModule extends TestBase {
    TestUtility testUtility;
    CreateAnAccount createAnAccount;

    @BeforeClass
    public void setUp(){
        initialization("frontEndUrl");
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

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
