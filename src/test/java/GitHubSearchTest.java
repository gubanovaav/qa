
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearchTest {
    @Test
    void ShouldFindJunit5Code () {
        //Открываем главную страницу
        open("https://github.com/");
        // Кликаем на поле поиска, чтобы активировать его
        $(".header-search-button").click();
        // Ввод в поле поиска "selenide"
        $("input[id='query-builder-test']").setValue("selenide").pressEnter();
        //Открываем раздел selenide
        $("a[href='/selenide/selenide']").click();
        //Открываем раздел wiki
        $("[id='wiki-tab']").click();
        //Открывает SoftAssertions
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        //Проверка кода
        $$("h4.heading-element").findBy(text("JUnit5")).should(exist);
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) " +
                "class Tests { " +
                "  @Test " +
                "  void test() { " +
                "    Configuration.assertionMode = SOFT; " +
                "    open(\"page.html\"); " +
                "    $(\"#first\").should(visible).click(); " +
                "    $(\"#second\").should(visible).click(); " +
                "  } " +
                "}"));

    }
}
