package wa.demo.cucumber;

import io.cucumber.java.Before;
import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "wa.demo")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty," +
                                                            " html:target/CucumberReport.html," +
                                                            " io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm," +
                                                            " wa.demo.cucumber.listener.TestAllureListener")
@Slf4j
@ScenarioScope
@PropertySource("classpath:application.properties")
public class CucumberRunner {
    @Value("${browser}")
    private String browser;

    @Value("${tracing}")
    private String tracing;

    @Before
    public void setBrowser() {
        if (System.getProperties().containsKey("browser") && System.getProperties().containsKey("tracing")) {
            System.clearProperty("browser");
            System.clearProperty("tracing");
        }
        System.setProperty("browser", browser);
        System.setProperty("tracing", String.valueOf(true));
        log.info("Passing browser property to PlaywrightBrowser bean");
    }
}

