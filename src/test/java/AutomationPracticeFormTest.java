import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Заполнение формы
        $("#firstName").setValue("Nastia");
        $("#lastName").setValue("Gubanova");
        $("#userEmail").setValue("test@nastia.ru");
        $("label[for=gender-radio-2]").click(); //Выбор пола
        $("#userNumber").setValue("1234567890"); // Номер телефона
        $("[id=dateOfBirthInput]").click(); // Выбор даты рождения
        $("[class=react-datepicker__year-select]>[value='1989']").click();
        $("[class=react-datepicker__month-select]>[value='4']").click();
        $(".react-datepicker__month .react-datepicker__day--020").click();
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("[id=uploadPicture]").uploadFromClasspath("egg.jpg"); //Загрузка картинки
        $("#currentAddress").setValue("Monkey 23"); // Текущий адрес
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        // Отправка формы
        $("#submit").click();

        // Проверка результатов
       // $("[class=table-responsive]").shouldHave(Condition.text("Nastia Gubanova"));
       // $("[class=table-responsive]").shouldHave(Condition.text("test@nastia.ru"));
      //  $("[class=table-responsive]").shouldHave(Condition.text("20 May,1989"));
//$("[class=table-responsive]").shouldHave(Condition.text("Female"));
//$("[class=table-responsive]").shouldHave(Condition.text("1234567890"));
//$("[class=table-responsive]").shouldHave(Condition.text("Maths"));
//$("[class=table-responsive]").shouldHave(Condition.text("Sports"));
//$("[class=table-responsive]").shouldHave(Condition.text("egg.jpg"));
//$("[class=table-responsive]").shouldHave(Condition.text("Monkey 23"));
//$("[class=table-responsive]").shouldHave(Condition.text("NCR Delhi"));
   //     $("#closeLargeModal").click();

        $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("Nastia Gubanova"));
        $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("test@nastia.ru"));
        $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Female"));
        $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("1234567890"));
        $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("20 May,1989"));
        $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("Maths"));
        $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Sports"));
        $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("egg.jpg"));
        $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("Monkey 23"));
        $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("NCR Delhi"));
    }
}