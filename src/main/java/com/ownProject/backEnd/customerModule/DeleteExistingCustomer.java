package com.ownProject.backEnd.customerModule;

import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteExistingCustomer extends TestBase {
    WebDriver driver;
    TestUtility testUtility;
    AddNewCustomer addNewCustomer;

    @FindBy(css = "button[class='scalable delete']")
    WebElement deleteCustomerIcon;

    @FindBy(css = "li[class='success-msg']")
    WebElement deleteSuccessMessage;

    public DeleteExistingCustomer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void enterDeleteCustomerPage(){
        addNewCustomer = new AddNewCustomer(driver);
        addNewCustomer.addNewCustomer();
        addNewCustomer.clickOnFilteredCustomer();
    }

    public void clickDeleteCustomerIcon(){
        testUtility.waitForElementPresent(deleteCustomerIcon);
        deleteCustomerIcon.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyDeleteCustomer(){
        testUtility.waitForElementPresent(deleteSuccessMessage);
        return deleteSuccessMessage.isDisplayed();
    }

}
