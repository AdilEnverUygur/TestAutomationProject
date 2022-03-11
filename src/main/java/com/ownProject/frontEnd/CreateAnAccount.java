package com.ownProject.frontEnd;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccount {
    WebDriver driver;
    TestUtility testUtility;

    //Test Data
    @FindBy(xpath = "//span[contains(text(),'Create an Account')]")
    WebElement accountLinkElement;

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email_address")
    WebElement emailAddressField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "confirmation")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//span[contains(text(),'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//span[contains(text(),'Thank you for registering with Magento Test Store.')]")
    WebElement successMessage;


    public CreateAnAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickCreateAccountLink(){
        testUtility.waitForElementPresent(accountLinkElement);
        accountLinkElement.click();
    }

    public void fillFirstName(String firstName){
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
    }

    public void fillEmail(String email){
        testUtility.waitForElementPresent(emailAddressField);
        emailAddressField.sendKeys(email);
    }

    public void fillPassword(String password){
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void fillConfirmPassword(String confirmPassword){
        testUtility.waitForElementPresent(confirmPasswordField);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickRegisterButton(){
        testUtility.waitForElementPresent(registerButton);
        registerButton.click();
    }

    public void createAnAccount(String firstName,String lastName,String email,String password){
        CreateAnAccount createAnAccount = new CreateAnAccount(driver);
        createAnAccount.clickCreateAccountLink();
        createAnAccount.fillFirstName(firstName);
        createAnAccount.fillLastName(lastName);
        createAnAccount.fillEmail(email);
        createAnAccount.fillPassword(password);
        createAnAccount.fillConfirmPassword(password);
        createAnAccount.clickRegisterButton();
    }

    public boolean verifyAccountCreated(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

}
