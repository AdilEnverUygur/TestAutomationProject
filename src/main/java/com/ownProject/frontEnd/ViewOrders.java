package com.ownProject.frontEnd;

import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOrders{
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//a[contains(text(),'My Orders')]")
    WebElement myOrdersElement;

    @FindBy(xpath = "//h1[contains(text(),'My Orders')]")
    WebElement successMessage;

    public ViewOrders(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickOnMyOrderLink(){
        testUtility.sleep(3);
        testUtility.waitForElementPresent(myOrdersElement);
        myOrdersElement.click();
    }

    public boolean verifySuccessMessage(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
}
