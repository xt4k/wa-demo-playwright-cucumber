package wa.demo.cucumber;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import wa.demo.playwright.PlaywrightConfiguration;

import java.nio.file.Paths;

@SuppressWarnings("unused")
@Slf4j
@PropertySource("classpath:application.properties")
public class CucumberHooks {
    @Value("${browser}")
    private static String browserType;

    PlaywrightConfiguration playwrightBrowser;

    CucumberHooks(PlaywrightConfiguration browser) {
        this.playwrightBrowser = browser;
    }

    @BeforeAll
    public static void beforeAll() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "browser")
                        .build(), System.getProperty("user.dir") + "/target/allure-results/");
    }

    @After
    public void afterScenario(Scenario scenario) {
        //Capturing screenshot irrespective of whether the test pass or fail
        //This approach will ensure there is always evidences for the tests outcome
        scenario.attach(playwrightBrowser.captureScreenshot(), "image/png", "screenshot");
        log.debug("Attaching full page screenshot, after the scenario");

        if (playwrightBrowser.isTracingOptionSet()) {
            playwrightBrowser.getBrowserContext().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/traces.zip")));
        }
    }
}