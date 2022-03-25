package com.ownProject.backEnd.catalogModule;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "description")
    WebElement descriptionFiled;
    @FindBy(id = "short_description")
    WebElement shortDescriptionField;
    @FindBy(id = "sku")
    WebElement skuField;
    @FindBy(id = "weight")
    WebElement weightField;
    @FindBy(id = "status")
    WebElement statusDropdownList;
    @FindBy(id = "visibility")
    WebElement visibilityDropdownList;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveButton;
    @FindBy(id = "price")
    WebElement price;
    @FindBy(id = "tax_class_id")
    WebElement taxClass;
    @FindBy(className = "success-msg")
    WebElement successMessage;


    public ProductInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void fillProductName(String productName){
        testUtility.waitForElementPresent(nameField);
        testUtility.sendKeysByJS(nameField,productName);
    }

    public void fillDescriptionArea(String description){
        testUtility.waitForElementPresent(descriptionFiled);
        testUtility.sendKeysByJS(descriptionFiled,description);
    }

    public void fillShortDescriptionField(String description){
        testUtility.waitForElementPresent(shortDescriptionField);
        testUtility.sendKeysByJS(shortDescriptionField,description);
    }

    public void fillSKUFiled(String sku){
        testUtility.waitForElementPresent(skuField);
        testUtility.sendKeysByJS(skuField,sku);
    }

    public void fillWeightField(String weight){
        testUtility.waitForElementPresent(weightField);
        testUtility.sendKeysByJS(weightField,weight);
    }

    public void selectVisibilityDropdownList(String value){
        testUtility.waitForElementPresent(visibilityDropdownList);
        TestUtility.selectDropdownValue(visibilityDropdownList,value);
    }

    public void selectStatusDropdownList(String value){
        testUtility.waitForElementPresent(statusDropdownList);
        TestUtility.selectDropdownValue(statusDropdownList,value);
    }

    public void clickSaveButton(){
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyProductAdded(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

    public void fillNewProductInfo(String productName,String description,String shortDescription,String weight,String SKU,
                                   String statusValue, String visibilityValue,String priceNumber,String taxValue){
        fillProductName(productName);
        fillDescriptionArea(description);
        fillShortDescriptionField(shortDescription);
        fillSKUFiled(SKU);
        fillWeightField(weight);
        selectVisibilityDropdownList(visibilityValue);
        selectStatusDropdownList(statusValue);
        clickSaveButton();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(price);
        testUtility.sendKeysByJS(price,priceNumber);
        TestUtility.selectDropdownValue(taxClass,taxValue);
        clickSaveButton();
    }
}
