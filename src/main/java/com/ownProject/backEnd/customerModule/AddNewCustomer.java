package com.ownProject.backEnd.customerModule;

import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer extends TestBase{
    WebDriver driver;
    TestUtility testUtility;
    CustomerDashboardPage customerDashboardPage;
    public static String customerName;

    @FindBy(id = "_accountwebsite_id")
    WebElement associateToWebsiteElement;
    @FindBy(id = "_accountgroup_id")
    WebElement groupElement;
    @FindBy(id = "_accountfirstname")
    WebElement firstNameField;
    @FindBy(id = "_accountlastname")
    WebElement lastNameElement;
    @FindBy(id = "_accountemail")
    WebElement emailField;
    @FindBy(id = "_accountpassword")
    WebElement passwordField;
    @FindBy(xpath = "//button[@title='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(xpath = "//span[contains(text(),'The customer has been saved.')]")
    WebElement addCustomerSuccessMessage;

    public AddNewCustomer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void openAddCustomerPage(){
        customerDashboardPage = new CustomerDashboardPage(driver);
        customerDashboardPage.clickAddNewCustomerButton();
    }

    public void selectAssociateToWebsite(String dropdownValue){
        testUtility.waitForElementPresent(associateToWebsiteElement);
        TestUtility.selectDropdownValue(associateToWebsiteElement,dropdownValue);
    }

    public void selectGroup(String dropdownValue){
        testUtility.waitForElementPresent(groupElement);
        TestUtility.selectDropdownValue(groupElement,dropdownValue);
    }

    public void fillFirstNameField(String firstName){
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void fillLastNameField(String lastName){
        testUtility.waitForElementPresent(lastNameElement);
        lastNameElement.sendKeys(lastName);
    }

    public void fillEmailField(String email){
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password){
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickOnSaveButton(){
        testUtility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
    }

    public boolean verifyAddNewCustomerSuccessfully(){
        testUtility.sleep(3);
        testUtility.waitForElementPresent(addCustomerSuccessMessage);
        return addCustomerSuccessMessage.isDisplayed();
    }

    public void addNewCustomer(){
        openAddCustomerPage();
        testUtility.sleep(3);
        selectAssociateToWebsite(properties.getProperty("associateToWebsiteValue"));
        selectGroup(properties.getProperty("groupValue"));
        customerName = TestUtility.generateFakeFirstName();
        fillFirstNameField(customerName);
        fillLastNameField(TestUtility.generateFakeLastName());
        fillEmailField(TestUtility.randomEmailAddress());
        fillPasswordField(TestUtility.generateRandomPassword());
        clickOnSaveButton();
    }
}
