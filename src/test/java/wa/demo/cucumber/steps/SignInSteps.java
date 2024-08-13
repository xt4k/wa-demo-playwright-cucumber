package my.accelerator.atf.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.accelerator.atf.pages.EntranceBlockPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AllArgsConstructor
@Slf4j
public class SignInSteps {
    private final EntranceBlockPage loginPopupPage;

    @When("^user set email$")
    public void playerSetEmail() {
        loginPopupPage.setPlayerEmail();
    }

    @And("^user set password$")
    public void playerSetPassword() {
        loginPopupPage.setPlayerPassword();
    }

    @And("^user click `SING IN`$")
    public void playerClickSignIn() {
        loginPopupPage.clickSignIn();
    }

    @Then("^user successfully sign in$")
    public void player_should_be_logged_in() {
        assertTrue(loginPopupPage.isLoggedIn());
    }
}
