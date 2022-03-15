package com.ownProject.frontEnd;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishList {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//div[@class=\"block-content\"]//a[contains(text(),'My Wishlist')]")
    WebElement myWishListLink;

    @FindBy(xpath = "//h1[contains(text(),'My Wishlist')]")
    WebElement successMessage;

    public MyWishList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void clickMyWishListLink(){
        testUtility.waitForElementPresent(myWishListLink);
        myWishListLink.click();
    }

    public boolean verifyMyWishListIsDisplayed(){
        testUtility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

}
