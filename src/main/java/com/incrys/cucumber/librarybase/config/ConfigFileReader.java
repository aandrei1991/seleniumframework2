// author Leonardo D.
package com.incrys.cucumber.librarybase.config;

import com.incrys.cucumber.librarybase.core.DriverType;
import com.incrys.cucumber.librarybase.core.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/resources/configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverMacOSPath() {
        String driverPath = properties.getProperty("chromedriver_macos_path");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("chromedriver_macos_path not specified in the configuration.properties file.");
    }

    public String getChromeDriverWindowsPath() {
        String driverPath = properties.getProperty("chromedriver_windows_path");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("chromedriver_windows_path not specified in the configuration.properties file.");
    }

    public String getChromeAsWebDriver() {
        String driverChrome = properties.getProperty("chrome_as_webdriver");
        if (driverChrome != null) return driverChrome;
        else throw new RuntimeException("chromeAsWebDriver not specified in the configuration.properties file.");
    }

    public String getGeckoDriverMacOSPath() {
        String driverPath = properties.getProperty("geckodriver_macos_path");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("geckodriver_macos_path not specified in the configuration.properties file.");
    }

    public String getGeckoDriverWindowsPath() {
        String driverPath = properties.getProperty("geckodriver_windows_path");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("geckodriver_windows_path not specified in the configuration.properties file.");
    }

    public String getGeckoAsWebDriver() {
        String driverChrome = properties.getProperty("gecko_as_webdriver");
        if (driverChrome != null) return driverChrome;
        else throw new RuntimeException("geckoAsWebDriver not specified in the configuration.properties file.");
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local"))
            return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote"))
            return EnvironmentType.REMOTE;
        else
            throw new RuntimeException(
                    "Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else
            throw new RuntimeException(
                    "Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    public Duration getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Duration.ofSeconds(Long.parseLong(implicitlyWait));
        else throw new RuntimeException("implicitlyWait not specified in the configuration.properties file.");
    }

    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }


}
