import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillRegistrationFormTest () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Marina");
        $("#lastName").setValue("Konovalchik");
        $("#userEmail").setValue("maria.konovalchik@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("English");
        $(".subjects-auto-complete__menu").$(byText("English")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/avatar.png"));
        $("#currentAddress").setValue("Minsk, Belarus");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Marina"),
                text("Konovalchik"),
                text("marina.konovalchik@gmail.com"),
                text("Female"),
                text("1234567890"),
                text("26 January,1995"),
                text("English"),
                text("Reading"),
                text("avatar.png"),
                text("Minsk, Belarus"),
                text("Haryana"),
                text("Karnal"));

        $("#closeLargeModal").click();
    }
}

