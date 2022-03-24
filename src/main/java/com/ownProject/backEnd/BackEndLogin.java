package com.ownProject.backEnd;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackEndLogin {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "login")
    WebElement passwordField;

    @FindBy(css = "input[class='form-button']")
    WebElement loginButton;

    @FindBy(css = ".link-logout")
    WebElement logoutButton;

    public BackEndLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void enterUserName(String userName){
        testUtility.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password){
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        testUtility.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public boolean verifyLoginSuccessfully(){
        testUtility.waitForElementPresent(logoutButton);
        return logoutButton.isDisplayed();
    }

    public void clickLogoutButton(){
        testUtility.waitForElementPresent(logoutButton);
        logoutButton.click();
    }

    public void backEndLogin(String userName,String password){
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
        verifyLoginSuccessfully();
    }
}
