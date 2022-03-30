package com.ownProject.backEnd.storeModule;

import com.ownProject.backEnd.BackEndLogin;
import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerLogin {
    WebDriver driver;
    TestUtility testUtility;
    BackEndLogin backEndLogin;

    public StoreManagerLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void login(){
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.enterUserName(TestBase.properties.getProperty("storeManagerUserName"));
        backEndLogin.enterPassword(TestBase.properties.getProperty("backEndPassword"));
        backEndLogin.clickLoginButton();
    }

    public boolean verifyLoginSuccessfully(){
        return backEndLogin.verifyLoginSuccessfully();
    }
}
