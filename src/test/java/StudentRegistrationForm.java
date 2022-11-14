import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $("#userEmail").setValue("marina.konovalchik@gmail.com");
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


    }
}

