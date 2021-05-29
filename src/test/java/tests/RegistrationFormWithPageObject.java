package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObject {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillStudentRegistrationForm() {

        //open page
        open("https://demoqa.com/automation-practice-form");

        //fill name
        $("#firstName").setValue("Tony");

        //fill last name
        $x("//*[@id='lastName']").setValue("Stark");

        //fill email
        $("#userEmail").setValue("TonyStark@gmail.com");

        //choose gender
        $x("//*[@id='genterWrapper']//*[@for='gender-radio-3']").click();

        //fill mobile number
        $("#userNumber").setValue("8800555353");

        //fill birthdate
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__month").find(byText("15")).click();

        //fill subject
        $("#subjectsInput").val("English").pressEnter();

        //scroll into view submit button
        $("#submit").scrollIntoView(true);

        //check hobby
        $x("//*[contains(text(),'Sports')]").click();

        //attach file
        $("#uploadPicture").uploadFromClasspath("img/Screenshot_2.png");

        //fill state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        //fill address
        $("#currentAddress").setValue("Pushkina street, Kolotushkina fleet");

        //click submit
        $("#submit").click();


        //check successful popup header
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //check submitting form name
        $x("//*[contains(text(),'Student Name')]//..").shouldHave(text("Tony Stark"));

        //check submitting form email
        $x("//*[contains(text(),'Student Email')]//..").shouldHave(text("TonyStark@gmail.com"));

        //check submitting form gender
        $x("//*[@class='table-responsive']//td[contains(text(),'Gender')]//..")
                .shouldHave(text("Other"));

        //check submitting form birthday
        $x("//*[@class='table-responsive']//td[contains(text(),'Date of Birth')]//..")
                .shouldHave(text("Date of Birth 15 August,1988"));

        //check submitting form mobile
        $x("//*[@class='table-responsive']//td[contains(text(),'Mobile')]//..")
                .shouldHave(text("8800555353"));

        //check submitting form subject
        $x("//td[text()='Subjects']").parent().shouldHave(text("English"));

        //check submitting form hobbies
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports"));

        //check submitting form photo
        $x("//td[text()='Picture']").parent().shouldHave(text("Screenshot_2.png"));

        //check submitting form address
        $x("//*[@class='table-responsive']//td[contains(text(),'Address')]//..")
                .shouldHave(text("Pushkina street, Kolotushkina fleet"));

        //check submitting form state and city
        $x("//td[text()='State and City']").parent().shouldHave(text("Uttar Pradesh Agra"));

        //close submitting form
        $("#closeLargeModal").click();


    }
}
