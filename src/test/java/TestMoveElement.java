import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestMoveElement {
    @BeforeAll
    static void beforeALL() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.pageLoadStrategy = "eager";
    }
     @Test
    void moveElemOnPageTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
         $("#column-a").shouldHave(text("A"));
         $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200,0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));




     }











}