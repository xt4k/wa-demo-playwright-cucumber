package my.accelerator.atf.cucumber.steps;

import com.microsoft.playwright.ElementHandle;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.accelerator.atf.pages.tab.LiveCasinoPage;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AllArgsConstructor
@Slf4j
public class LiveCasinoTabSteps {
    private final LiveCasinoPage liveCasinoPage;

    @And("^user search \"([^\"]*)\"$")
    public void playerTypeInSearchField(String casinoName) {
        liveCasinoPage.searchCasino(casinoName);
    }

    @And("^user click `Games search` button$")
    public void playerClickGamesSearchButton() {
        liveCasinoPage.searchGame();
    }

    @Then("defined casino\\(s) is shown")
    public void definedCasinoSIsShown() {
        List<ElementHandle> casinoList = liveCasinoPage.getCasinoList();
        Assertions.assertThat(casinoList).hasSizeGreaterThanOrEqualTo(1);
    }

    @And("^user may play in this casino$")
    public void playerMayPlayInThisCasino() {

        boolean isPlayable = liveCasinoPage.isCasinoHasPlayButton();
        assertTrue(isPlayable);
    }

}
