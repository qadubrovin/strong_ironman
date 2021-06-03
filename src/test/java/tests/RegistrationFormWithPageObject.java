package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static com.codeborne.selenide.Condition.text;


public class RegistrationFormWithPageObject {

    StudentRegistrationPage registrationPage = new StudentRegistrationPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender3 = "Other",
            mobile = faker.number().digits(10),
            subject = "English",
            hobby = "Sports",
            picturePath = "img/Screenshot_2.png",
            pictureName = "Screenshot_2.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Agra",
            monthOfBirth = "August",
            yearOfBirth = "1988";


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillStudentRegistrationForm() {

        //fill form
        registrationPage.openRegistrationForm();
        registrationPage.setFullName(firstName, lastName);
        registrationPage.setEmail(email);
        registrationPage.setGender();
        registrationPage.setMobile(mobile);
        registrationPage.setDate(monthOfBirth, yearOfBirth);
        registrationPage.setSubject(subject);
        registrationPage.scrollIntoSubmitView();
        registrationPage.sportsHobbyChoose();
        registrationPage.setUploadPicture(picturePath);
        registrationPage.setStateAndCity();
        registrationPage.setAddress(currentAddress);

        //submitting form
        registrationPage.clickSubmitButton();

        //check successful popup
        registrationPage.successHeader.shouldHave(text("Thanks for submitting the form"));
        registrationPage.nameColumn.shouldHave(text(firstName + ' ' + lastName));
        registrationPage.studentEmailColumn.shouldHave(text(email));
        registrationPage.studentGenderColumn.shouldHave(text(gender3));
        registrationPage.birthdateColumn.shouldHave(text("Date of Birth 15 August,1988"));
        registrationPage.mobileColumn.shouldHave(text(mobile));
        registrationPage.subjectsColumn.parent().shouldHave(text(subject));
        registrationPage.hobbyColumn.parent().shouldHave(text(hobby));
        registrationPage.pictureColumn.parent().shouldHave(text(pictureName));
        registrationPage.addressColumn.shouldHave(text(currentAddress));
        registrationPage.stateAndCityColumn.parent().shouldHave(text(state + ' ' + city));
        Selenide.sleep(3000);
    }
}
