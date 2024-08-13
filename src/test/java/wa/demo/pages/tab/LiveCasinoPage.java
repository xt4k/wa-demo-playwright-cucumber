package wa.demo.pages.tab;

import com.microsoft.playwright.ElementHandle;
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
@PropertySource("classpath:pages/live-casino.properties")
public class LiveCasinoPage {
    @Value("${search.game.block}")
    private String searchGameBlock;
    @Value("${search.game.input}")
    private String searchGameInput;
    @Value("${casino.list}")
    private String casinoList;
    @Value("${play.button}")
    private String playButton;

    @Autowired
    private Page page;

    public void searchGame() {
        page.reload();
        page.locator(searchGameBlock).click();
    }

    public void searchCasino(String casinoName) {
        page.locator(searchGameInput).fill(casinoName);
        page.waitForTimeout(1000);
        page.getByTitle(casinoName).all().getFirst().scrollIntoViewIfNeeded();
    }

    public List<ElementHandle> getCasinoList() {
        return page.querySelectorAll(casinoList);
    }

    public boolean isCasinoHasPlayButton() {
        page.querySelectorAll(casinoList).getFirst().hover();
        return page.locator(playButton).isVisible();
    }
}