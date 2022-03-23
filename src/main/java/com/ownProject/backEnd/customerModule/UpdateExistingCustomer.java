package com.ownProject.backEnd.customerModule;


import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateExistingCustomer extends TestBase {
    WebDriver driver;
    TestUtility testUtility;
    AddNewCustomer addNewCustomer;

    @FindBy(id = "customer_info_tabs_account")
    WebElement accountInformationLink;
    @FindBy(id = "_accountnew_password")
    WebElement newPasswordField;

    public UpdateExistingCustomer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickOnAccountInformationLink(){
        testUtility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
    }

    public void changeEmailAddress(String newEmail){
        addNewCustomer = new AddNewCustomer(driver);
        testUtility.waitForElementPresent(addNewCustomer.emailField);
        addNewCustomer.emailField.clear();
        addNewCustomer.emailField.sendKeys(newEmail);
    }

    public void clickOnSaveCustomerButton(){
        addNewCustomer = new AddNewCustomer(driver);
        testUtility.waitForElementPresent(addNewCustomer.saveCustomerButton);
        testUtility.retryingFindClick(addNewCustomer.saveCustomerButton);
    }

    public boolean verifyUpdateCustomerSuccessfully(){
        addNewCustomer = new AddNewCustomer(driver);
        testUtility.waitForElementPresent(addNewCustomer.addCustomerSuccessMessage);
        return addNewCustomer.addCustomerSuccessMessage.isDisplayed();
    }

    public void updateCustomerInfo(){
        clickOnAccountInformationLink();
        changeEmailAddress(TestUtility.randomEmailAddress());
        testUtility.scrollDown();
        clickOnSaveCustomerButton();
    }
    
}
