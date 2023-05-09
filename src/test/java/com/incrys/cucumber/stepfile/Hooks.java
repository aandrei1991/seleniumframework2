// Author Leonardo D.
package com.incrys.cucumber.stepfile;

import com.incrys.cucumber.librarybase.core.TestContext;
import com.incrys.cucumber.librarybase.logs.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before()
    public void before_steps(Scenario scenario) {
        testContext.getWebDriverManager().setScenario(scenario);
        Log.info("Testing is starting for: " + scenario.getName());
        testContext.getPOM().getHomePOM().getURLAccess();
    }

    @After
    public void after_steps(Scenario scenario) {
        testContext.getWebDriverManager().scenarioFailedScreenshot(scenario);
        Log.info("Testing is ending for: " + scenario.getName());
        testContext.getWebDriverManager().quitDriver();

    }

}
