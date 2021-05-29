package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormWithPageObject {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    StudentRegistrationPage registrationPage = new StudentRegistrationPage();

    @Test
    void fillStudentRegistrationForm() {

        //fill form
        registrationPage.openRegistrationForm();
        $(registrationPage.name).setValue(registrationPage.firstName);
        $x(registrationPage.familyName).setValue(registrationPage.lastName);
        $(registrationPage.userEmail).setValue(registrationPage.email);
        $x(registrationPage.otherGender).click();
        $(registrationPage.userNumber).setValue(registrationPage.mobile);
        registrationPage.setDate();
        $(registrationPage.subjectInput).val(registrationPage.subject).pressEnter();
        $(registrationPage.submitButton).scrollIntoView(true);
        $x(registrationPage.hobbySports).click();
        $(registrationPage.uploadPicture).uploadFromClasspath(registrationPage.picturePath);
        registrationPage.setStateAndCity();
        $(registrationPage.usersAddress).setValue(registrationPage.currentAddress);
        $(registrationPage.submitButton).click();

        //check successful popup
        $(registrationPage.successHeader).shouldHave(text("Thanks for submitting the form"));
        $x(registrationPage.nameColumn).shouldHave(text(registrationPage.firstName + ' ' + registrationPage.lastName));
        $x(registrationPage.studentEmailColumn).shouldHave(text(registrationPage.email));
        $x(registrationPage.studentGenderColumn).shouldHave(text(registrationPage.gender3));
        $x(registrationPage.birthdateColumn).shouldHave(text("Date of Birth 15 August,1988"));
        $x(registrationPage.mobileColumn).shouldHave(text(registrationPage.mobile));
        $x(registrationPage.subjectsColumn).parent().shouldHave(text(registrationPage.subject));
        $x(registrationPage.hobbyColumn).parent().shouldHave(text(registrationPage.hobby));
        $x(registrationPage.pictureColumn).parent().shouldHave(text(registrationPage.pictureName));
        $x(registrationPage.addressColumn).shouldHave(text(registrationPage.currentAddress));
        $x(registrationPage.stateAndCityColumn).parent().shouldHave(text(registrationPage.state + ' ' + registrationPage.city));
        $(registrationPage.closeModal).click();

    }
}
