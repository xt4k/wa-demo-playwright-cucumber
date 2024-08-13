package wa.demo.listener;

import com.microsoft.playwright.Page;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.NoArgsConstructor;
import wa.demo.cucumber.StaticContextAccessor;

import java.io.ByteArrayInputStream;

@NoArgsConstructor
public class TestAllureListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::testRunStarted);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::testRunFinished);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::handleCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::handleCaseFinished);
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::handleStepStarted);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::handleStepFinished);
    }

    private void testRunFinished(final TestRunFinished event) {
    }

    private void testRunStarted(final TestRunStarted event) {
    }

    private void handleCaseStarted(TestCaseStarted t) {

    }

    private void handleCaseFinished(TestCaseFinished t) {

    }

    private void handleStepStarted(TestStepStarted t) {

    }

    private void handleStepFinished(TestStepFinished t) {
        if (Status.FAILED.equals(t.getResult().getStatus())) {
            Allure.addAttachment(t.getTestStep().getId().toString(), new ByteArrayInputStream(captureScreenshot()));
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreenshot() {

        return StaticContextAccessor.getBean(Page.class).screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }
}
