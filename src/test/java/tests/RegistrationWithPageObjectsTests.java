package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void fillRegistrationFormTest () {
        String username = "Marina",
               userLastName = "Konovalchik",
               email = "marina.konovalchik@gmail.com",
               gender = "Female",
               phoneNumber = "1234567890",
               subject = "English",
               hobby = "Reading",
               photo = "avatar.png",
               address = "Minsk, Belarus",
               state = "Haryana",
               city = "Karnal";

        registrationPage.openPage()
                .setFirstName(username)
                .setLastName(userLastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setBirthDate ("01", "1995", "26")
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPhoto(photo)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", username + "" + userLastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", "26 January,1995")
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", photo)
                .verifyResult("Address", address)
                .verifyResult("State and City", "Haryana Karnal");

        registrationPage.closeModal();
    }
}

