package wa.demo.playwright;

import com.microsoft.playwright.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Configuration
@Data
public class PlaywrightConfiguration {
    Page page;
    BrowserContext browserContext;

    Boolean isTracingSet = false;

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
        browserContext = browser.newContext();
        return browserContext;
    }

    @Bean
    public Page page(Browser browser) {
        page = browser.newPage();
        page.setDefaultTimeout(60000);
        page.setDefaultNavigationTimeout(120000);
        return page;
    }


    /**
     * This method will be called from Hooks class, from cucumber After hook
     *
     * @return byte array which holds the screenshot
     */
    public byte[] captureScreenshot() {
        Path objPath = Paths.get("target/screenshots/Screenshot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyy_hhmmss")) + ".png");
        return page.screenshot(new Page.ScreenshotOptions().setPath(objPath).setFullPage(true));
    }

    /**
     * This method will be called from Constructor to set the Playwright browser tracing on
     * this method returns byte array which holds the screenshot
     */
    public void setTracing(Boolean option) {
        if (option && !Objects.isNull(browserContext)) {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setSnapshots(true));
            isTracingSet = true;
        }
    }

    /**
     * This method will be called from Hooks class's After annotation to decide if Playwright browser tracing needs to be turned off
     *
     * @return boolean that show is tracing set
     */

    public boolean isTracingOptionSet() {
        return isTracingSet;
    }

    public void close() {
        page.close();
        browserContext.close();
        playwright().close();
        System.clearProperty("browser");
        System.clearProperty("tracing");
    }

}
