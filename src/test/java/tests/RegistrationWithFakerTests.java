package tests;

import org.junit.jupiter.api.Test;


public class RegistrationWithFakerTests extends TestBase {

    @Test
    void successfulRegistrationTest () {
        TestData testData = new TestData();

        registrationPage.openPage()
                .setFirstName(testData.username)
                .setLastName(testData.userLastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhone(testData.phoneNumber)
                .setBirthDate(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPhoto(testData.photo)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testData.username + " " + testData.userLastName)
                .verifyResult("Student Email", testData.email)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.phoneNumber)
                .verifyResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", testData.photo.replaceAll("src/test/resources/",""))
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", "Haryana Karnal");

        registrationPage.closeModal();
    }

}

