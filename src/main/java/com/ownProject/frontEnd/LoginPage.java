package com.ownProject.frontEnd;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = ".account-cart-wrapper>a")
    WebElement accountLink;

    @FindBy(xpath = "//a[contains(text(),'Log In')]")
    WebElement loginLink;

    @FindBy(id = "email")
    WebElement emailAddress;

    @FindBy(id = "pass")
    WebElement passwordElement;

    @FindBy(id = "send2")
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logOutButton;

    @FindBy(xpath = "//h1[contains(text(),'You are now logged out')]")
    WebElement logOutSuccessMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickAccountLink(){
        testUtility.waitForElementPresent(accountLink);
        accountLink.click();
    }

    public void clickLoginLink(){
        testUtility.waitForElementPresent(loginLink);
        loginLink.click();
    }

    public void enterEmail(String email){
        testUtility.waitForElementPresent(emailAddress);
        emailAddress.sendKeys(email);
    }

    public void enterPassword(String password){
        testUtility.waitForElementPresent(passwordElement);
        passwordElement.sendKeys(password);
    }

    public void clickOnLoginButton(){
        testUtility.waitForElementPresent(loginButton);
        loginButton.click();
    }


    public void publicModuleLogin(String email,String password){
        clickAccountLink();
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

    public void accountLink(){
        testUtility.waitForElementPresent(accountLink);
        accountLink.click();
    }

    public void logOutButton(){
        testUtility.waitForElementPresent(logOutButton);
        logOutButton.click();
    }

    public boolean verifyLogOut(){
        testUtility.waitForElementPresent(logOutSuccessMessage);
        return logOutSuccessMessage.isDisplayed();
    }

    public void clickLogOutButton(){
        accountLink();
        logOutButton();
        verifyLogOut();
    }



}
