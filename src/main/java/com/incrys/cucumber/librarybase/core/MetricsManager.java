// Author Leonardo D.
package com.incrys.cucumber.librarybase.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.Response;
import org.openqa.selenium.devtools.v106.performance.Performance;
import org.openqa.selenium.devtools.v106.performance.model.Metric;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MetricsManager {

    private final UtilsManager utilsManager;
    WebDriver driver;

    public MetricsManager(WebDriver driver) {
        this.driver = driver;
        utilsManager = new UtilsManager(driver);
        PageFactory.initElements(driver, this);
    }

    // Selenium 4 - Performance Metrics
    // https://saucelabs.com/resources/articles/bidirectional-apis
    public void consoleLogTestBiDi(WebDriver driver) {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(org.openqa.selenium.devtools.v106.log.Log.enable());

        devTools.addListener(org.openqa.selenium.devtools.v106.log.Log.entryAdded(), logEntry ->
        {
            System.out.println("log: " + logEntry.getText());
            System.out.println("level: " + logEntry.getLevel());
        });
    }

    public void performanceMetricsCDP(WebDriver driver) {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
        for (Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }

    public void captureHttpTrafficTestCDP(WebDriver driver) {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // capture HTTP traffic
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        List<Response> capturedResponses = Collections.synchronizedList(new ArrayList<>());
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            capturedResponses.add(responseReceived.getResponse());
        });

        System.out.println(capturedResponses);
        assertNoErrorCodes(capturedResponses);
    }

    public void assertNoErrorCodes(List<Response> capturedResponses) {
        boolean areThereErrorCodes = capturedResponses.stream().anyMatch(r -> r.getStatus() > 400 && r.getStatus() < 599);
        AssertJUnit.assertFalse("Error codes detected on the page: ", areThereErrorCodes);
    }
    // Selenium 4 - Performance Metrics

    public String getTimesTest() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0];"));
    }

    public String getNavigationDuration() {
        return ((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].duration;").toString();
    }

    public String getRedirectStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].redirectStart;"));
    }

    public String getRedirectEnd() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].redirectEnd;"));
    }

    public Double getRedirectTiming() {
        return Double.parseDouble(getRedirectEnd()) - Double.parseDouble(getRedirectStart());
    }

    public String getDomainLookupStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].domainLookupStart;"));
    }

    public String getDomainLookupEnd() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].domainLookupEnd;"));
    }

    public Double getDNSTiming() {
        return Double.parseDouble(getDomainLookupEnd()) - Double.parseDouble(getDomainLookupStart());
    }

    public String getConnectEnd() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].connectEnd;"));
    }

    public String getConnectStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].connectStart;"));
    }

    public Double getConnectTiming() {
        return Double.parseDouble(getConnectEnd()) - Double.parseDouble(getConnectStart());
    }

    public String getSecureConnectionStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].secureConnectionStart;"));
    }

    public Double getSSLTiming() {
        return Double.parseDouble(getConnectEnd()) - Double.parseDouble(getSecureConnectionStart());
    }

    public String getRequestStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].requestStart;"));
    }

    public String getResponseStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].responseStart;"));
    }

    public Double getRequestTiming() {
        return Double.parseDouble(getResponseStart()) - Double.parseDouble(getRequestStart());
    }

    public String getResponseEnd() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].responseEnd;"));
    }

    public Double getResponseTiming() {
        return Double.parseDouble(getResponseEnd()) - Double.parseDouble(getResponseStart());
    }

    public String getLoadEventStart() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].loadEventStart;"));
    }

    public Double getDOMTiming() {
        return Double.parseDouble(getLoadEventStart()) - Double.parseDouble(getResponseEnd());
    }

    public String getDOMComplete() {
        return String.valueOf(((JavascriptExecutor) driver).executeScript(
                "return window.performance.getEntriesByType('navigation')[0].domComplete;"));
    }

    public Double getFrontendPerformanceTiming() {
        return Double.parseDouble(getDOMComplete()) - Double.parseDouble(getResponseStart());
    }


}
