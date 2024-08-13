package wa.demo.configuration;

import com.microsoft.playwright.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PlaywrightConfiguration {

    @Bean
    public Playwright playwright() {
        return Playwright.create();
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public Browser chromeBrowser(Playwright playwright) {
        return playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setTimeout(30000)
                        .setHeadless(false)
                        .setSlowMo(100)
                );
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public Browser firefoxBrowser(Playwright playwright) {
        return playwright.firefox()
                .launch(new BrowserType.LaunchOptions()
                        .setTimeout(30000)
                        .setHeadless(false)
                        .setSlowMo(100)
                );
    }

    @Bean
    public BrowserContext browserContext(Browser browser) {
        return browser.newContext();
    }

    @Bean
    public Page page(Browser browser) {
        Page page =  browser.newPage();
        page.setDefaultTimeout(60000);
        page.setDefaultNavigationTimeout(120000);
        return page;
    }
}
