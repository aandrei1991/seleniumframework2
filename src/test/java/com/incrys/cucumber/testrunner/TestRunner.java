// Author Leonardo D.
package com.incrys.cucumber.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //tags = "@comanda and @home and @huse",
        tags = "@huse",
        features = "src/test/java/com/incrys/cucumber/featurefile",
        glue = {"com.incrys.cucumber.stepfile"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

// https://cucumber.io/docs/cucumber/api/?lang=java#options