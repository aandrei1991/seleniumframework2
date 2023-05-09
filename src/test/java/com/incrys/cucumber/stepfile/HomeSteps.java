// Author Leonardo D.
package com.incrys.cucumber.stepfile;

import com.incrys.cucumber.librarybase.core.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps {

    TestContext tctx;

    public HomeSteps(TestContext context) {
        tctx = context;
    }

    @Given("Get Main Links from Page")
    public void get_main_links_from_page()  {
        tctx.getPOM().getHomePOM().getMainLinksFromHomepage();
    }

    @When("Check Main Link Buttons")
    public void check_main_link_buttons()   {
        tctx.getPOM().getHomePOM().checkMainLinkButtons();
    }
}
