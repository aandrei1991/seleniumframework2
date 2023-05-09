// author Leonardo D.
package com.incrys.cucumber.librarybase.core;

import com.incrys.cucumber.librarybase.config.FileReaderManager;
import com.incrys.cucumber.librarybase.logs.Log;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class WebDriverManager {

    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private WebDriver driver;
    private Scenario scenario;
    final static Logger logger = LoggerFactory.getLogger(WebDriverManager.class);

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    private WebDriver createDriver() throws MalformedURLException {
        switch (environmentType) {
            case LOCAL -> driver = createLocalDriver();
        }
        return driver;
    }

    public WebDriver getDriver() throws MalformedURLException {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX -> {
                System.setProperty(
                        FileReaderManager.getInstance().getConfigReader().getGeckoAsWebDriver(),
                        FileReaderManager.getInstance().getConfigReader().getGeckoDriverMacOSPath());
                        //FileReaderManager.getInstance().getConfigReader().getGeckoDriverWindowsPath());
                driver = new FirefoxDriver(setFirefoxOptions());
            }
            case CHROME -> {
                System.setProperty(
                        FileReaderManager.getInstance().getConfigReader().getChromeAsWebDriver(),
                        FileReaderManager.getInstance().getConfigReader().getChromeDriverMacOSPath());
                        //FileReaderManager.getInstance().getConfigReader().getChromeDriverWindowsPath());
                driver = new ChromeDriver(setChromeOptions());

            }
        }
        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
        return driver;
    }

    public void scenarioFailedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", "FailedScreenshot-" + scenario.getName());
            Log.error(scenario.getName() + " - " + scenario.getStatus().toString());
        } else {
            Log.info(scenario.getName() + " - " + scenario.getStatus().toString());
        }
    }

    public void quitDriver() {
        deleteAllCookies();
        //driver.close();
        driver.quit();
    }

    public void deleteAllCookies() {
        ((JavascriptExecutor) (driver)).executeScript("window.localStorage.clear();");
        driver.manage().deleteAllCookies();
    }

    public ChromeOptions setChromeOptions() {
        //https://www.h2kinfosys.com/blog/chrome-options-desired-capabilities/
        //https://stackoverflow.com/questions/18106588/how-to-disable-cookies-using-webdriver-for-chrome-and-firefox-java
        Map<String, Object> prefs = new HashMap<>();
        // https://learn-automation.com/disable-chrome-notifications-selenium-webdriver/
        prefs.put("profile.default_content_settings.cookies", 2);

        //prefs.put("performance", true);
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-arguments");
        options.addArguments("--test-type");
        options.addArguments("test");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        // Disable Developer Mode Extension (might get one additional popup)
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        //options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--disable-web-security");
        //options.addArguments("--ignore-urlfetcher-cert-requests");
        options.addArguments("--ignore-certificate-errors");
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }

    public FirefoxOptions setFirefoxOptions() {
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default");
        profile.setPreference("network.cookie.cookieBehavior", 2);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        //options.setBinary("insert_path");
        //options.setProxy(new Proxy().setProxyAutoconfigUrl("insert_url"));
        //options.setProxy(new Proxy().setProxyType(Proxy.ProxyType.AUTODETECT));
        //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //options.setHeadless(true);
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size").addArguments("1920,1080");
        return options;
    }


}
