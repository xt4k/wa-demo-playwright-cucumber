package wa.demo.pages.popups;

import com.microsoft.playwright.Page;
import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ScenarioScope
@PropertySource({
        "classpath:pages/signin-popups.properties",
        "classpath:application.properties"
})
public class SignInPopupPage {

    @Value("${player.email}")
    private String playerEmail;
    @Value("${player.pass}")
    private String playerPass;


    @Value("${username.locator}")
    private String usernameLocator;
    @Value("${password.locator}")
    private String passwordLocator;
    @Value("${signin.button}")
    private String signInButton;

    @Value("${signed.icon}")
    private String signedIcon;

    @Value("${signin.placeholder}")
    private String signInPlaceholder;
    @Value("${prematch.list}")
    private String prematchList;


    @Autowired
    private Page page;

    public void setPlayerEmail() {
        System.out.println("player Email " + playerEmail);
        page.locator(usernameLocator).fill(playerEmail);
    }

    public void setPlayerPassword() {
        page.locator(passwordLocator).fill(playerPass);
    }

    public void clickSignIn() {
        page.locator(signInButton).click();
    }

    public boolean isLoggedIn() {
        return page.locator(signedIcon)
                .locator("..")
                .isEnabled();
    }

}
