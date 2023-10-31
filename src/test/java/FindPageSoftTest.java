import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class FindPageSoftTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void findPageTest() {
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("a[href='/selenide/selenide']").click();
        $("a[href='/selenide/selenide/wiki']").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $(".markdown-body").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").$(byText("3. Using JUnit5 extend test class:")).click();

        String t = String.join("\n" +
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}");
        $$("#user-content-3-using-junit5-extend-test-class").shouldHave(CollectionCondition.texts(t));


    }
    }

