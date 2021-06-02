package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationPage<nameColumn> {

    String monthOfBirth = "August",
            yearOfBirth = "1988";


    //selectors for fill form
    public SelenideElement otherGender = $x("//*[@for='gender-radio-3']"),
            name = $("#firstName"),
            familyName = $x("//*[@id='lastName']"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            submitButton = $("#submit"),
            hobbySports = $x("//*[contains(text(),'Sports')]"),
            uploadPicture = $("#uploadPicture"),
            usersAddress = $("#currentAddress");

    //selectors for success form
    public SelenideElement successHeader = $("#example-modal-sizes-title-lg"),
            nameColumn = $x("//*[contains(text(),'Student Name')]//.."),
            studentEmailColumn = $x("//*[contains(text(),'Student Email')]//.."),
            studentGenderColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Gender')]//.."),
            birthdateColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Date of Birth')]//.."),
            mobileColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Mobile')]//.."),
            subjectsColumn = $x("//td[text()='Subjects']"),
            hobbyColumn = $x("//td[text()='Hobbies']"),
            pictureColumn = $x("//td[text()='Picture']"),
            addressColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Address')]//.."),
            stateAndCityColumn = $x("//td[text()='State and City']"),
            closeModal = $("#closeLargeModal");

    //methods
    public void setDate(String monthOfBirth, String yearOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month").find(byText("15")).click();
    }

    public void setStateAndCity() {
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
    }

    public void openRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
    }


}
