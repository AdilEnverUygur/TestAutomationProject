package com.ownProject.regression.testNG;

import com.ownProject.frontEnd.*;
import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.*;

public class PublicModule extends TestBase {
    TestUtility testUtility;
    CreateAnAccount createAnAccount;
    LoginPage loginPage;
    ViewOrders viewOrders;
    DownloadableProduct product;
    MyWishList myWishList;
    ChangePassword changePassword;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        initialization("frontEndUrl");
    }

    @BeforeMethod(alwaysRun = true)
    public void login(){
        loginPage = new LoginPage(driver);
        loginPage.publicModuleLogin(properties.getProperty("userName"),properties.getProperty("userPassword"));
    }

    // 1.A user should be able to create an account
    @Test
    public void userShouldBeAbleToCreateAnAccount(){
        testUtility = new TestUtility(driver);
        createAnAccount = new CreateAnAccount(driver);
        testUtility.sleep(3);
        createAnAccount.createAnAccount(TestUtility.generateFakeFirstName(),TestUtility.generateFakeLastName(),
                TestUtility.randomEmailAddress(),TestUtility.generateRandomPassword());
        Assert.assertTrue(createAnAccount.verifyAccountCreated());
    }

    // 2.A user should be able to view his/her orders
    @Test
    public void userShouldBeAbleToViewHisOrder(){
        viewOrders = new ViewOrders(driver);
        viewOrders.clickOnMyOrderLink();
        Assert.assertTrue(viewOrders.verifySuccessMessage());
    }

    // 3.A user should be able to view his/her downloadable products
    @Test
    public void userShouldBeAbleToViewDownloadableProduct(){
        product = new DownloadableProduct(driver);
        product.clickDownloadAbleProduct();
        Assert.assertTrue(product.verifySuccessMessage());
    }

    // 4.A user should be able to view My wish list
    @Test
    public void userShouldBeAbleToViewMyWishList(){
        myWishList = new MyWishList(driver);
        myWishList.clickMyWishListLink();
        Assert.assertTrue(myWishList.verifyMyWishListIsDisplayed());
    }

    //5. A user should be able to change password
    @Test
    public void userShouldBeAbleToChangePassword(){
        changePassword = new ChangePassword(driver);
        changePassword.changePassword(properties.getProperty("userPassword"),
                properties.getProperty("userNewPassword"),properties.getProperty("userNewPassword"));
        Assert.assertTrue(changePassword.verifyChangePassword());
    }

    @AfterMethod(alwaysRun = true)
    public void logOut(){
        loginPage = new LoginPage(driver);
        loginPage.clickLogOutButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }
}
