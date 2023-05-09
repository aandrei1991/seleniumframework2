// Author Leonardo D.
package com.incrys.cucumber.librarybase.core;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UtilsManager {
    WebDriver driver;

    public UtilsManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    LocalDateTime localDateTime = LocalDateTime.now();

    public String getDateTimeFormatter() {
        return dateTimeFormatter.format(localDateTime);
    }

    public String getDtf() {
        return dtf.format(localDateTime);
    }

    public static Select getSelect(WebElement element) {
        return new Select(element);
    }

    public Robot getRobot() throws AWTException {
        return new Robot();
    }

    public SoftAssert getSoftAssert() {
        return new SoftAssert();
    }

    public Random getRandom() {
        return new Random();
    }

    public Faker getFaker() {
        return new Faker();
    }

    public JavascriptExecutor getJS() {
        return (JavascriptExecutor) driver;
    }

    public void scrollJS(WebElement scrollUntilWebElement) {
        getJS().executeScript("arguments[0].scrollIntoView();", scrollUntilWebElement);
    }

    public void waitUntilPresent(String elementToBePresent, Integer timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementToBePresent)));
    }

    public void waitUntilVisible(String elementToBeVisible, Integer timeoutInSeconds)   {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementToBeVisible)));
    }

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchBackTab(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void setRandomSelectDropdown(WebElement getSelectedDropdown) {
        getSelect(getSelectedDropdown).selectByIndex(getRandomInteger(0, getOptionsList(getSelectedDropdown).size()));
    }

    public static int getRandomInteger(int min, int sizeList) {
        return (int) ((Math.random() * (sizeList - min)) + min);
    }

    public static List<WebElement> getOptionsList(WebElement optionsListDropdown) {
        return getSelect(optionsListDropdown).getOptions();
    }

    public WebElement getRandomFromList(List<WebElement> list) {
        return list.get(getRandomInteger(0, list.size()));
    }

    public static String getRandomLetters(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = (int) (chars.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static String getCurrentTimestamp() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return date.format(new Date());
    }

}
