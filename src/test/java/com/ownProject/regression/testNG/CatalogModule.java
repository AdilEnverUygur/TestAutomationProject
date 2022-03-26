package com.ownProject.regression.testNG;

import com.ownProject.backEnd.BackEndLogin;
import com.ownProject.backEnd.catalogModule.CatalogDashboardPage;
import com.ownProject.backEnd.catalogModule.ManageProductPage;
import com.ownProject.backEnd.catalogModule.NewProductPage;
import com.ownProject.backEnd.catalogModule.ProductInformationPage;
import com.ownProject.testUtility.TestBase;
import com.ownProject.testUtility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.*;


public class CatalogModule extends TestBase {
    TestUtility testUtility;
    BackEndLogin backEndLogin;
    CatalogDashboardPage catalogDashboardPage;
    ManageProductPage manageProductPage;
    NewProductPage newProductPage;
    ProductInformationPage productInformationPage;


    @BeforeClass(alwaysRun = true)
    public static void setUp(){
        initialization("backEndUrl");
    }

    @BeforeMethod(alwaysRun = true)
    public void login(){
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(properties.getProperty("catalogManagerUserName"), properties.getProperty("backEndPassword"));
    }

    //1.Catalog Manager can add products
    @Test
    public void catalogModuleCanAddProducts(){
        manageProductPage = new ManageProductPage(driver);
        manageProductPage.clickAddProductButton();
        newProductPage = new NewProductPage(driver);
        newProductPage.clickContinueButton();
        testUtility = new TestUtility(driver);
        productInformationPage = new ProductInformationPage(driver);
        productInformationPage.fillNewProductInfo(TestUtility.generateFakeName(),TestUtility.generateFakeTitle(),TestUtility.generateFakeTitle(),
                TestUtility.generateFakeSubscriberNumber(),TestUtility.generateFakeFirstName(),"2","3",TestUtility.generateFakeSubscriberNumber(),"4");
        Assert.assertTrue(productInformationPage.verifyProductAdded());

    }

    //2.Catalog Manager can edit products
    @Test
    public void catalogManagerCanEditProducts(){
        manageProductPage = new ManageProductPage(driver);
        manageProductPage.editProduct();
        Assert.assertTrue(manageProductPage.verifyEditingProductSuccessfully());
    }


    @AfterMethod(alwaysRun = true)
    public void logout(){
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.logOut();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown(){
        closeBrowser();
    }
}
