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
    @FindBy(css = "li.success-msg")
    WebElement deleteSuccessMessage;

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

    public void editProduct(){
        testUtility.waitForElementPresent(firstProductRow);
        firstProductRow.click();
        testUtility.waitForElementPresent(descriptionArea);
        descriptionArea.clear();
        String description = "The product is very good";
        descriptionArea.sendKeys(description);
        testUtility.waitForElementPresent(skuTextBox);
        skuTextBox.clear();
        skuTextBox.sendKeys(TestUtility.generateLowerAlphaNumericCode(8));
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyEditingProductSuccessfully(){
        testUtility.waitForElementPresent(editingSuccessMessage);
        String editingMS = "The product has been saved.";
        if (editingSuccessMessage.getText().equalsIgnoreCase(editingMS)){
            System.out.println(editingMS);
            return true;
        }else {
            return false;
        }
    }

    public void deleteExistingProduct(String existingProductName){
        fillNameField(existingProductName);
        clickSearchButton();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(firstProductInTable);
        firstProductInTable.click();
        selectActionDropdownList("delete");
        clickOnSubmitButton();
        testUtility.waitForAlertPresent();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public boolean verifyDeleteSuccessMessage(){
        testUtility.waitForElementPresent(deleteSuccessMessage);
        return deleteSuccessMessage.isDisplayed();
    }
}
