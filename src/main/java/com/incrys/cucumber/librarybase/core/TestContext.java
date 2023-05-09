// Author Leonardo D.
package com.incrys.cucumber.librarybase.core;

import java.net.MalformedURLException;

public class TestContext {

    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    private final UtilsManager utilsManager;
    private final MetricsManager metricsManager;

    public TestContext() throws MalformedURLException {
        webDriverManager    = new WebDriverManager();
        pageObjectManager   = new PageObjectManager(webDriverManager.getDriver());
        utilsManager = new UtilsManager(webDriverManager.getDriver());
        metricsManager = new MetricsManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPOM() {
        return pageObjectManager;
    }

    public UtilsManager getUtilsManager() {
        return utilsManager;
    }

    public MetricsManager getMetricsManager() {
        return metricsManager;
    }
}
