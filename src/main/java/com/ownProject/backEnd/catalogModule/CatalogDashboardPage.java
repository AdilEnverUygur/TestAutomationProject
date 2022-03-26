package com.ownProject.backEnd.catalogModule;

import com.ownProject.testUtility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CatalogDashboardPage {
    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

    @FindBy(id = "nav")
    WebElement catalogDropdownList;
    @FindBy(xpath = "//span[contains(text(),'Manage Products')]")
    WebElement manageProductsLink;
    @FindBy(css = ".link-logout")
    WebElement logoutButton;

    public CatalogDashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility = new TestUtility(driver);
    }

    public void moveMouseOverCatalogLink(){
        testUtility.waitForElementPresent(catalogDropdownList);
        actions = new Actions(driver);
        actions.moveToElement(catalogDropdownList).build().perform();
    }

    public boolean verifyLogin(){
        testUtility.waitForElementPresent(logoutButton);
        System.out.println("Login Successful");
        return logoutButton.isDisplayed();
    }

    public void logOut(){
        testUtility.waitForElementPresent(logoutButton);
        testUtility.sleep(3);
        testUtility.retryingFindClick(logoutButton);
        System.out.println("Logged Out");
    }
}
