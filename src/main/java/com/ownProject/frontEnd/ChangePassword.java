package com.ownProject.frontEnd;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//a[contains(text(),'Change Password')]")
    WebElement changePasswordLink;

    @FindBy(id = "current_password")
    WebElement currentPasswordField;

    @FindBy(id = "password")
    WebElement newPasswordField;

    @FindBy(id = "confirmation")
    WebElement passwordConfirmationField;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),'The account information has been saved.')]")
    WebElement successMessage;

    public ChangePassword(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickChangePasswordLink(){
        testUtility.waitForElementPresent(changePasswordLink);
        changePasswordLink.click();
    }

    public void fillCurrentPassword(String password){
        testUtility.waitForElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(password);
    }

    public void fillNewPassword(String password){
        testUtility.waitForElementPresent(newPasswordField);
        newPasswordField.sendKeys(password);
    }

    public void fillPasswordConfirmation(String password){
        testUtility.waitForElementPresent(passwordConfirmationField);
        passwordConfirmationField.sendKeys(password);
    }

    public void clickSaveButton(){
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyChangePassword(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

    public void changePassword(String currentPassword,String newPassword,String newPasswordConfirmation){
        clickChangePasswordLink();
        fillCurrentPassword(currentPassword);
        fillNewPassword(newPassword);
        fillPasswordConfirmation(newPasswordConfirmation);
        clickSaveButton();
    }
}
