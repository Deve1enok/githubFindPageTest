import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestLoadPage {
    @BeforeAll
    static void beforeALL() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void testPageGitHTest() {
        open("https://github.com/");
        $("ul.d-lg-flex.list-style-none").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI Powered Developer Platform."));




}
}