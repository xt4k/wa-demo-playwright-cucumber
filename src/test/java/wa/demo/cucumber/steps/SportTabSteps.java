package my.accelerator.atf.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.accelerator.atf.pages.tab.SportsPage;
import org.assertj.core.api.Assertions;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class SportTabSteps {
    private final SportsPage sportTabPage;

    @And("^user select \"([^\"]*)\" list item in left menu$")
    public void selectLeftMenuItem(String string) {
        sportTabPage.selectLeftMenuItem(string);
    }

    @And("^user select top row from list$")
    public void selectTopRowFromList() {
        sportTabPage.selectTopRowFromList();
    }

    @And("^user select first match from prematch page block$")
    public void selectTopRowInPrematchTable() {
        sportTabPage.selectTopRowInPrematchTable();
    }

    @Then("^in betslip block present notification \"([^\"]*)\"$")
    public void inBetslipBlockPresentNotification(String warningMessage) {
        List<String> actualMessages = sportTabPage.getBetSlipWarningsMessage();
        Assertions.assertThat(actualMessages).contains(warningMessage);
    }

}
