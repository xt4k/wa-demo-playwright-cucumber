package wa.demo.pages.popup;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
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
@PropertySource("classpath:pages/chat-popup.properties")
public class ChatPopupPage {

    @Value("${language.placeholder}")
    private String languagePlaceholder;
    @Value("${email.placeholder}")
    private String emailPlaceholder;

    @Value("${button.with.text}")
    private String buttonWithText;
    @Value("${frame.locator}")
    private String frameLocator;

    @Value("${select.options}")
    private String selectOptions;

    @Value("${select.language}")
    private String selectLanguage;

    @Value("${message.placeholder}")
    private String messagePlaceholder;

    @Value("${conversation.title}")
    private String conversationTitle;

    @Value("${sent.message}")
    private String sentMessage;

    @Autowired
    private Page page;

    public void clickButton(String textButton) {
        String buttonLocator = buttonWithText.formatted(textButton);
        getFrame().locator(buttonLocator).click();
    }

    private FrameLocator getFrame() {
        return page.frameLocator(frameLocator);
    }

    public void setEmail(String emailAddress) {
        getFrame().getByPlaceholder(emailPlaceholder).fill(emailAddress);
    }

    public void selectLanguage(String language) {

        getFrame().getByPlaceholder(languagePlaceholder).click();
        List<ElementHandle> elements = getFrame().locator(selectOptions).elementHandles();
        for (ElementHandle element : elements) {
            if (element.innerText().trim().equalsIgnoreCase(language)) {
                getFrame().locator(selectLanguage).selectOption(new SelectOption().setLabel(language));
                break;
            }
        }
        getFrame().getByPlaceholder(languagePlaceholder).click();
    }

    public void send(String message) {
        getFrame().getByPlaceholder(messagePlaceholder).fill(message);
        getFrame().locator(buttonWithText.formatted(conversationTitle)).click();

    }

    public String getSentMessage() {
        return getFrame().locator(sentMessage).innerText();
    }

    public void reLoad() {
        page.reload();
    }
}
