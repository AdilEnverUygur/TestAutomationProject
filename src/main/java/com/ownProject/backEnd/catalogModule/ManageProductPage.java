package com.ownProject.backEnd.catalogModule;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//span[text()='Add Product']")
    WebElement addProductButton;
    @FindBy(id = "productGrid_product_filter_name")
    WebElement filterName;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(id = "productGrid_massaction-select")
    WebElement actionsDropdownList;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr/td[1]")
    WebElement firstProductInTable;
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]")
    WebElement firstProductRow;
    @FindBy(id = "description")
    WebElement descriptionArea;
    @FindBy(id = "sku")
    WebElement skuTextBox;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveButton;
    @FindBy(id = "messages")
    WebElement editingSuccessMessage;

    public ManageProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickAddProductButton(){
        testUtility.waitForElementPresent(addProductButton);
        addProductButton.click();
    }

    public void fillNameField(String productName){
        testUtility.waitForElementPresent(filterName);
        filterName.sendKeys(productName);
    }

    public void clickSearchButton(){
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }

    public void selectActionDropdownList(String actionValue){
        testUtility.waitForElementPresent(actionsDropdownList);
        TestUtility.selectDropdownValue(actionsDropdownList,actionValue);
    }

    public void clickOnSubmitButton(){
        testUtility.waitForElementPresent(submitButton);
        submitButton.click();
    }


}
