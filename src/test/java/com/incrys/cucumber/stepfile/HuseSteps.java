// Author Leonardo D.
package com.incrys.cucumber.stepfile;

import com.incrys.cucumber.librarybase.core.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HuseSteps {

    TestContext tctx;
    Scenario scenario;

    public HuseSteps(TestContext context) {
        tctx = context;
        this.scenario = tctx.getWebDriverManager().getScenario();
    }

    @Given("Click on Huse Menu - Error")
    public void click_on_huse_menu_error() {
        //tctx.getPageObjectManager().getHusePOM().getHuseMenu().sendKeys("EROARE");
        tctx.getPOM().getHusePOM().getHuseMenu().click();
        scenario.getStatus();
    }

    @Given("Click on Huse Menu")
    public void click_on_huse_menu() {
        tctx.getPOM().getHusePOM().getHuseMenu().click();
        scenario.log("Click Huse");
    }

    @And("Click on Huse iPhone Icon")
    public void click_on_huse_iphone_icon() {
        tctx.getPOM().getHusePOM().getHuseIphoneImage().click();
    }

    @And("Click on Huse iPhone 11 Pro Icon")
    public void click_on_huse_iphone_11_pro_icon() {
        tctx.getUtilsManager().scrollJS(
                tctx.getPOM().getHusePOM().getHuseiPhone11ProImage());
        tctx.getPOM().getHusePOM().getHuseiPhone11ProImage().click();
    }

    @Then("Go to Husa iPhone 11 Pro Senno Tailor Leather Wallet Grey")
    public void go_to_husa_iphone_11_pro_senno_tailor_leather_wallet_grey() {
        tctx.getUtilsManager().scrollJS(
                tctx.getPOM().getHusePOM().getHusaiPhone11ProSennoTailorLeatherWalletGrey()
        );
        tctx.getUtilsManager().getSoftAssert().assertEquals(
                tctx.getPOM().getHusePOM().getHusaiPhone11ProSennoTailorLeatherWalletGrey().getText(),
                "Husa originala iPhone 11 Pro \"Silicone Case\", Verde");
        tctx.getPOM().getHusePOM().getHusaiPhone11ProSennoTailorLeatherWalletGrey().click();
        tctx.getUtilsManager().waitUntilPresent(
                "//div[@class='product-info-main']//img[@title='Anti-Fingerprint']",
                5);
    }


}
