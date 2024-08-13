package my.accelerator.atf.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.accelerator.atf.pages.HomePage;

@AllArgsConstructor
@Slf4j
public class MainPageSteps {
    private final HomePage homePage;

    @Given("^user navigated to homepage$")
    public void player_navigated_to_home_page() {
        homePage.open();
    }

    @When("^user select tab \"([^\"]*)\"$")
    public void player_select_to_home_page(String string) {
        homePage.openTab(string);
    }

    @When("^user click `SIGN IN`$")
    public void sign_in() {
        homePage.signIn();
    }

    @When("^user click 'efbet chat'$")
    public void userClickButton() {
        homePage.openChat();
    }


  //  @When("user click {string} button")
    public void userClickEfbetChatButton() {
    }
}
