package com.ownProject.backEnd.catalogModule;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement continueButton;

    public NewProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickContinueButton(){
        testUtility.waitForElementPresent(continueButton);
        continueButton.click();
    }
}
