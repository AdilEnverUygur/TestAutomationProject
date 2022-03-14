package com.ownProject.frontEnd;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadableProduct {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//a[contains(text(),'My Downloadable Products')]")
    WebElement downloadableProduct;

    @FindBy(xpath = "//h1[contains(text(),'My Downloadable Products')]")
    WebElement successMessage;

    public DownloadableProduct(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickDownloadAbleProduct(){
        testUtility.waitForElementPresent(downloadableProduct);
        downloadableProduct.click();
    }

    public boolean verifySuccessMessage(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

}
