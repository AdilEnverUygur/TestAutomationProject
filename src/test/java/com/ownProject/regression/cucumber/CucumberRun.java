package com.ownProject.regression.cucumber;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty","html:target/cucumber-run","json:target/magento.json"},
        features = "src/test/resources",
        tags = "@StoreManagerTest"
)


public class CucumberRun{
}
