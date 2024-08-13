package wa.demo.pages;

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
@PropertySource("classpath:pages/home-page.properties")
public class HomePage {
    @Value("${bet.application.base.uri}")
    private String betHomePageUrl;

    @Value("${tab.name}")
    private String tabLocator;
    @Value("${chat.title}")
    private String chatTitle;
    @Value("${signin.title}")
    private String signInTitle;

    @Autowired
    private Page page;

    public void open() {
        page.navigate(betHomePageUrl, new Page.NavigateOptions().setTimeout(5_000));
    }

    public void signIn() {
        page.getByTitle(signInTitle).click();
    }

    public void openTab(String tabName) {
        page.locator(tabLocator.formatted(tabName)).click();
    }

    public void openChat() {
        page.getByTitle(chatTitle).click();
    }

}