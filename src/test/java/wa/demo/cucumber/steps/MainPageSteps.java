package wa.demo.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wa.demo.pages.HomePage;


@AllArgsConstructor
@Slf4j
public class MainPageSteps {
    private final HomePage homePage;

    @Given("^user navigated to homepage$")
    public void playerNavigatedToHomePage() {
        homePage.open();
    }

    @When("^user select tab \"([^\"]*)\"$")
    public void playerSelectTab(String string) {
        homePage.openTab(string);
    }

    @When("^user click `SIGN IN`$")
    public void playerSignIn() {
        homePage.signIn();
    }

    @When("^user click 'efbet chat'$")
    public void userClickButton() {
        homePage.openChat();
    }

}
