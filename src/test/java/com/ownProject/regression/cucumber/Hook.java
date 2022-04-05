package com.ownProject.regression.cucumber;

import com.ownProject.testUtility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends TestBase {

    @Before
    public void setUp(){
        System.out.println("Hook Set up");
        initialization("backEndUrl");
    }

    @After
    public void tearDown(){
       closeBrowser();
    }
}
