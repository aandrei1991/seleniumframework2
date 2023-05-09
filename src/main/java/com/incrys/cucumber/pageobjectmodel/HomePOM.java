// Author Leonardo D.
package com.incrys.cucumber.pageobjectmodel;

import com.incrys.cucumber.librarybase.config.FileReaderManager;
import com.incrys.cucumber.librarybase.core.UtilsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePOM {

    private final UtilsManager utilsManager;
    WebDriver driver;

    public HomePOM(WebDriver driver) {
        this.driver = driver;
        utilsManager = new UtilsManager(driver);
        PageFactory.initElements(driver, this);
    }

    public void getURLAccess() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public List<String> getMainLinksFromHomepage() {
        List<WebElement> mainLinks = driver.findElements(By.xpath("//*[@id='store.menu']/nav/ul/li"));
        List<String> links = new ArrayList<>();
        for (WebElement link : mainLinks) {
            links.add(link.getText());
        }
        return links;
    }

    public void checkMainLinkButtons() {
        List<String> listMainLinks = new ArrayList<>(
                Arrays.asList("HUSE", "FOLII", "CABLURI", "MASTI DE PROTECTIE", "INCARCATOARE",
                        "AUDIO", "SUPORTURI", "STOCARE", "TELEFOANE", "TABLETE", "TV"));
        for (int i = 0; i < listMainLinks.size(); i++) {
            utilsManager.getSoftAssert().assertEquals(getMainLinksFromHomepage().get(i), listMainLinks.get(i),
                    "THE MAIN LINKS ARE NOT CORRECT");
        }
    }

    public WebElement getStoreMenu() {
        return storeMenu;
    }
    @FindBy(xpath = "//*[@id='store.menu']/nav/ul/li")
    WebElement storeMenu;


}
