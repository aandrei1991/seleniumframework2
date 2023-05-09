package com.incrys.cucumber.pageobjectmodel;

import com.incrys.cucumber.librarybase.core.UtilsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComandaPOM {

    WebDriver driver;
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    WebElement adaugatiInCosButton;
    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    WebElement finalizatiComandaButton;
    @FindAll({
            @FindBy(xpath = "//div[@class='amcheckout-wrapper']//input[@id='customer-email']"),
            @FindBy(css = "body > div:nth-child(4) > main:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(5) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > li:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > fieldset:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    })
    WebElement adresaEmailField;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/li[1]/div[1]/div[1]/form[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement prenumeField;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/li[1]/div[1]/div[1]/form[2]/div[1]/div[2]/div[1]/input[1]")
    WebElement numeField;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/li[1]/div[1]/div[1]/form[2]/div[1]/div[3]/div[1]/input[1]")
    WebElement telefonField;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/li[1]/div[1]/div[1]/form[2]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement adresaField;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/li[1]/div[1]/div[1]/form[2]/div[1]/div[4]/div[1]/input[1]")
    WebElement orasField;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/li[1]/div[1]/div[1]/form[2]/div[1]/div[6]/div[1]/select[1]")
    WebElement localitateField;
    @FindAll({
            @FindBy(xpath = "//input[@id='cashondelivery']"),
            @FindBy(css = "#cashondelivery")
    })
    WebElement plataLaLivrareRadioButton;
    @FindAll({
            @FindBy(xpath = "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[4]/div[2]/div[2]/li[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]"),
            @FindBy(css = "#cardcc")
    })
    WebElement plataOnlineCuCardulRadioButton;

    public ComandaPOM(WebDriver driver) {
        this.driver = driver;
        UtilsManager utilsManager = new UtilsManager(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAdaugatiInCosButton() {
        return adaugatiInCosButton;
    }

    public WebElement getFinalizatiComandaButton() {
        return finalizatiComandaButton;
    }

    public WebElement getAdresaEmailField() {
        return adresaEmailField;
    }

    public WebElement getPrenumeField() {
        return prenumeField;
    }

    public WebElement getNumeField() {
        return numeField;
    }

    public WebElement getTelefonField() {
        return telefonField;
    }

    public WebElement getAdresaField() {
        return adresaField;
    }

    public WebElement getOrasField() {
        return orasField;
    }

    public WebElement getLocalitateField() {
        return localitateField;
    }

    public WebElement getPlataOnlineCuCardulRadioButton() {
        return plataOnlineCuCardulRadioButton;
    }

    public WebElement getPlataLaLivrareRadioButton() {
        return plataLaLivrareRadioButton;
    }

}
