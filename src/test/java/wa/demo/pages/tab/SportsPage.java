package wa.demo.pages.tabs;

import com.microsoft.playwright.Page;
import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@ScenarioScope
@PropertySource("classpath:pages/sports-page.properties")
public class SportsPage {

    @Autowired
    private Page page;

    @Value("${special.list}")
    private String specialList;
    @Value("${competition.block}")
    private String competitionBlock;
    @Value("${game.result.block}")
    private String gameResultBlock;

    @Value("${game.result.list}")
    private String gameResultList;
    @Value("${prematch.list}")
    private String prematchList;
    @Value("${warning.messages}")
    private String warningMessages;


    public List<String> getBetSlipWarningsMessage() {
        List<String> messages = page.locator(warningMessages).allInnerTexts();
        log.info("messages: " + messages.toString());
        return messages;
    }

    public void selectLeftMenuItem(String string) {
        page.getByTitle(string).hover();
        page.getByTitle(string).click();
    }

    public void selectTopRowFromList() {
        page.locator(specialList).first().click();
    }

    public void selectTopRowInPrematchTable() {
        page.locator(competitionBlock).locator(prematchList).first().click();
    }

    public void selectTopRowInGameResultTable() {
        page.locator(gameResultBlock).locator(gameResultList).first().click();
    }

}
