package com.ownProject.backEnd.customerModule;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = "#nav>li>a>span")
    WebElement customersButton;
    @FindBy(xpath = "//span[contains(text(),'Manage Customers')]")
    WebElement manageCustomersLink;
    @FindBy(css = "button.scalable.add")
    WebElement addNewCustomerButton;




    public CustomerDashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickAddNewCustomerButton(){
        testUtility.waitForElementPresent(addNewCustomerButton);
        addNewCustomerButton.click();
    }

}
