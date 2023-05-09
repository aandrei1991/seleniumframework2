package com.incrys.cucumber.pageobjectmodel;

import com.incrys.cucumber.librarybase.core.MetricsManager;
import com.incrys.cucumber.librarybase.core.UtilsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HusePOM {

    WebDriver driver;
    private final UtilsManager utilsManager;
    private final MetricsManager metricsManager;

    public HusePOM(WebDriver driver) {
        this.driver = driver;
        utilsManager = new UtilsManager(driver);
        metricsManager = new MetricsManager(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Huse']")
    WebElement huseMenu;
    @FindBy(xpath = "//img[@alt='Huse iPhone']")
    WebElement huseIphoneImage;
    @FindBy(xpath = "//img[@alt='Huse iPhone 11 Pro']")
    WebElement huseiPhone11ProImage;
    @FindAll({
            @FindBy(xpath = "//body/div[1]/main[1]/div[4]/div[1]/div[4]/div[2]/ol[1]/li[6]/div[1]/div[1]/a[1]/img[1]"),
            @FindBy(css = ".product-image-photo.default_image[src='https://www.shopgsm.ro/media/catalog/product/cache/6087606ee4046083530f7d1a114cd732/w/a/wallet_leather_case_iphone_11_pro_grey_2__1.jpg']")
    })
    WebElement husaiPhone11ProSennoTailorLeatherWalletGrey;


    public WebElement getHuseMenu() {
        metricsManager.consoleLogTestBiDi(driver);
        metricsManager.performanceMetricsCDP(driver);
        metricsManager.captureHttpTrafficTestCDP(driver);
        return huseMenu;
    }

    public WebElement getHuseIphoneImage() {
        return huseIphoneImage;
    }

    public WebElement getHuseiPhone11ProImage() {
        return huseiPhone11ProImage;
    }

    public WebElement getHusaiPhone11ProSennoTailorLeatherWalletGrey() {
        return husaiPhone11ProSennoTailorLeatherWalletGrey;
    }


}
