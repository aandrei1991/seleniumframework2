// author Leonardo D.
package com.incrys.cucumber.librarybase.core;

import com.incrys.cucumber.pageobjectmodel.ComandaPOM;
import com.incrys.cucumber.pageobjectmodel.HomePOM;
import com.incrys.cucumber.pageobjectmodel.HusePOM;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    private HomePOM homePOM;

    private ComandaPOM comandaPOM;

    private HusePOM husePOM;

    public HusePOM getHusePOM() {
        return (husePOM == null) ? husePOM = new HusePOM(driver) : husePOM;
    }

    public HomePOM getHomePOM() {
        return (homePOM == null) ? homePOM = new HomePOM(driver) : homePOM;
    }

    public ComandaPOM getComandaPOM() {
        return (comandaPOM == null) ? comandaPOM = new ComandaPOM(driver) : comandaPOM;
    }


}
