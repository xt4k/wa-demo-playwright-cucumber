package wa.demo.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wa.demo.pages.popup.ChatPopupPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AllArgsConstructor
@Slf4j
public class ChatSteps {
    private final ChatPopupPage chatPopupPage;

    @And("^user click '([^\"]*)' button$")
    public void userClickStartConversationButton(String textButton) {
        chatPopupPage.clickButton(textButton);
    }

    @And("user set email '([^\"]*)'$")
    public void userSetEmailAaBbCc(String emailAddress) {
        chatPopupPage.setEmail(emailAddress);
    }

    @And("user set language {string}")
    public void userSetLanguage(String language) {
        chatPopupPage.selectLanguage(language);
    }

    @And("user send message {string}")
    public void userTypeMessage(String message) {
        chatPopupPage.send(message);
    }

    @Then("sent message in chat history has text \"([^\"]*)\"$")
    public void messageIsSentHasText(String sentMessage) {
        String actualSentMessage = chatPopupPage.getSentMessage();
        assertThat(actualSentMessage).isEqualTo(sentMessage);
    }
}
