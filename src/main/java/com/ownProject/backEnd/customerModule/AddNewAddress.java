package com.ownProject.backEnd.customerModule;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddress  {
    WebDriver driver;
    TestUtility testUtility;
    CustomerDashboardPage customerDashboardPage;
    AddNewAddress addNewAddress;


    @FindBy(id = "_accountwebsite_id")
    WebElement associateToWebsite;
    @FindBy(id = "_accountgroup_id")
    WebElement groupDropdownList;
    @FindBy(id = "_accountfirstname")
    WebElement firstNameField;
    @FindBy(id = "_accountlastname")
    WebElement lastNameField;
    @FindBy(id = "_accountemail")
    WebElement emailField;
    @FindBy(id = "_accountpassword")
    WebElement passwordField;
    @FindBy(xpath = "//span[text()='Save and Continue Edit']")
    WebElement saveAndContinueEditButton;

    @FindBy(id = "customer_info_tabs_addresses")
    WebElement addressesLink;
    @FindBy(id = "add_address_button")
    WebElement addNewAddressButton;
    @FindBy(id = "_item1street0")
    WebElement streetAddressField;
    @FindBy(id = "_item1city")
    WebElement cityField;
    @FindBy(xpath = "//*[@id=\"_item1country_id\"]/option[6]")
    WebElement countyDropdownList;
    @FindBy(id = "_item1postcode")
    WebElement zipcodeField;
    @FindBy(id = "_item1telephone")
    WebElement telNumberField;
    @FindBy(xpath = "//span[text()='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(xpath = "//span[contains(text(),'The customer has been saved.')]")
    WebElement successMessage;


    public AddNewAddress(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void selectAssociateToWebsite(String dropdownValue){
        TestUtility.selectDropdownValue(associateToWebsite,dropdownValue);
    }

    public void selectGroup(String dropdownValue){
        TestUtility.selectDropdownValue(groupDropdownList,dropdownValue);
    }

    public void fillFirstName(String customerFirstName){
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(customerFirstName);
    }

    public void fillLastName(String customerLastName){
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(customerLastName);
    }

    public void fillEmail(String customerEmail){
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(customerEmail);
    }

    public void fillPassword(String customerPassword){
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(customerPassword);
    }
    public void clickSaveAndContinueEditButton(){
        testUtility.waitForElementPresent(saveAndContinueEditButton);
        saveAndContinueEditButton.click();
    }

    public void fillCustomerInfo(String associateVale,String groupValue,String customerFistName,String customerLastName,
                                               String customerEmail,String customerPassword){
        selectAssociateToWebsite(associateVale);
        selectGroup(groupValue);
        testUtility.sleep(3);
        fillFirstName(customerFistName);
        fillLastName(customerLastName);
        fillEmail(customerEmail);
        fillPassword(customerPassword);
        testUtility.sleep(3);
    }



    public void clickOnAddressesButton(){
        testUtility.waitForElementPresent(addressesLink);
        addressesLink.click();
    }

    public void clickOnAddNewAddressButton(){
        testUtility.waitForElementPresent(addNewAddressButton);
        addNewAddressButton.click();
    }

    public void fillStreetAddress(String streetAddress){
        testUtility.waitForElementPresent(streetAddressField);
        streetAddressField.sendKeys(streetAddress);
    }

    public void fillCityName(String cityName){
        testUtility.waitForElementPresent(cityField);
        cityField.sendKeys(cityName);
    }

    public void selectCountry(){
        testUtility.waitForElementPresent(countyDropdownList);
        countyDropdownList.click();
    }


    public void fillZipCode(String zipCode){
        testUtility.waitForElementPresent(zipcodeField);
        zipcodeField.sendKeys(zipCode);
    }

    public void fillPhoneNumber(String phoneNumber){
        testUtility.waitForElementPresent(telNumberField);
        telNumberField.sendKeys(phoneNumber);
    }

    public void clickSaveButton(){
        testUtility.waitForElementPresent(saveCustomerButton);
        testUtility.retryingFindClick(saveCustomerButton);
    }

    public boolean verifySaveCustomerIsSuccess(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

    public void addNewAddressFunction(){
        customerDashboardPage = new CustomerDashboardPage(driver);
        customerDashboardPage.clickAddNewCustomerButton();
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.fillCustomerInfo("140","3",TestUtility.generateFakeFirstName(),
                TestUtility.generateFakeLastName(),TestUtility.randomEmailAddress(),TestUtility.generateRandomPassword());
        addNewAddress.clickSaveAndContinueEditButton();
        testUtility.sleep(3);
        addNewAddress.clickOnAddressesButton();
        testUtility.sleep(3);
        addNewAddress.clickOnAddNewAddressButton();
        testUtility.sleep(3);
        addNewAddress.fillStreetAddress(TestUtility.generateFakeTitle());
        testUtility.sleep(3);
        addNewAddress.fillCityName(TestUtility.generateFakeTitle());
        testUtility.sleep(3);
        addNewAddress.selectCountry();
        testUtility.sleep(3);
        addNewAddress.fillZipCode(TestUtility.generateRandomPassword());
        testUtility.sleep(3);
        addNewAddress.fillPhoneNumber(TestUtility.generateFakeNumber());
        testUtility.sleep(3);
        addNewAddress.clickSaveButton();
    }
}
