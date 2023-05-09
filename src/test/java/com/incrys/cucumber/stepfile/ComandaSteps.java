// Author Leonardo D.
package com.incrys.cucumber.stepfile;

import com.incrys.cucumber.librarybase.core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ComandaSteps {

    TestContext tctx;

    public ComandaSteps(TestContext context) {
        tctx = context;
    }

    @And("Checkout -  Adaugati in Cos")
    public void checkout_adaugati_in_cos() throws InterruptedException {
        tctx.getPOM().getComandaPOM().getAdaugatiInCosButton().click();
        Thread.sleep(2 * 1000);
        tctx.getPOM().getComandaPOM().getFinalizatiComandaButton().click();
    }

    @Given("Date livrare")
    public void date_livrare() throws InterruptedException {
        tctx.getPOM().getComandaPOM().getAdresaEmailField().sendKeys(
                tctx.getUtilsManager().getFaker().internet().emailAddress());
        tctx.getPOM().getComandaPOM().getPrenumeField().sendKeys(
                tctx.getUtilsManager().getFaker().name().firstName());
        tctx.getPOM().getComandaPOM().getNumeField().sendKeys(
                tctx.getUtilsManager().getFaker().name().lastName());
        tctx.getPOM().getComandaPOM().getTelefonField().sendKeys(
                tctx.getUtilsManager().getFaker().phoneNumber().phoneNumber());
        tctx.getPOM().getComandaPOM().getAdresaField().sendKeys(
                tctx.getUtilsManager().getFaker().address().streetAddress());
        tctx.getPOM().getComandaPOM().getOrasField().sendKeys(
                tctx.getUtilsManager().getFaker().address().cityName());
        tctx.getUtilsManager().setRandomSelectDropdown(
                tctx.getPOM().getComandaPOM().getLocalitateField());
        Thread.sleep(10 * 1000);
        tctx.getPOM().getComandaPOM().getPlataOnlineCuCardulRadioButton().click();

    }
}
