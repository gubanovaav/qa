import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void FormTest() {
        open("/automation-practice-form");

        // Заполнение формы
        $("#firstName").setValue("Nastia");
        $("#lastName").setValue("Gubanova");
        $("#userEmail").setValue("test@nastia.ru"); //Выбор пола
        $("label[class=custom-control-label]").click();
        $("#userNumber").setValue("1234567890"); // Номер телефона
        $("[id=dateOfBirthInput]").click(); // Выбор даты рождения
        $("[class=react-datepicker__year-select]>[value='2000']").click();
        $("[class=react-datepicker__month-select]>[value='3']").click();
        $(".react-datepicker__month .react-datepicker__day--024").click();
        $("[id=subjectsContainer]").click();
        $("#dateOfBirthInput").setValue("20 May 1989"); // Дата рождения
        $("#hobbies-checkbox-1").click(); // Выбор хобби
        $("#currentAddress").setValue("Some street 1"); // Текущий адрес

        // Отправка формы
        $("#submit").click();

        // Проверка результатов
        $("#output #name").shouldHave(text("Nastia Gubanova"));
        $("#output #email").shouldHave(text("test@nastia.ru"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
    }
}