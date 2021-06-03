package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationPage {


    //selectors for fill form
    private SelenideElement otherGenderInput = $x("//*[@for='gender-radio-3']"),
            nameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            submitButton = $("#submit"),
            hobbySports = $(byText("Sports")),
            uploadPicture = $("#uploadPicture"),
            usersAddress = $("#currentAddress");

    //selectors for success form
    private SelenideElement successHeader = $("#example-modal-sizes-title-lg"),
            nameColumn = $x("//*[contains(text(),'Student Name')]//.."),
            studentEmailColumn = $x("//*[contains(text(),'Student Email')]//.."),
            studentGenderColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Gender')]//.."),
            birthdateColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Date of Birth')]//.."),
            mobileColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Mobile')]//.."),
            subjectsColumn = $x("//td[text()='Subjects']"),
            hobbyColumn = $x("//td[text()='Hobbies']"),
            pictureColumn = $x("//td[text()='Picture']"),
            addressColumn = $x("//*[@class='table-responsive']//td[contains(text(),'Address')]//.."),
            stateAndCityColumn = $x("//td[text()='State and City']");

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

    public void setFullName(String name, String lastName) {
        nameInput.setValue(name);
        lastNameInput.setValue(lastName);
    }

    public void setEmail(String email) {
        userEmailInput.setValue(email);
    }

    public void setGender() {
        otherGenderInput.click();
    }

    public void setMobile(String mobile) {
        userNumberInput.setValue(mobile);
    }

    public void setSubject(String subject) {
        subjectInput.val(subject).pressEnter();
        ;
    }

    public void scrollIntoSubmitView() {
        submitButton.scrollIntoView(true);
    }

    public void sportsHobbyChoose() {
        hobbySports.click();
    }

    public void setUploadPicture(String filepath) {
        uploadPicture.uploadFromClasspath(filepath);
    }

    public void setAddress(String address) {
        usersAddress.setValue(address);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkSuccessfulPopup(String firstName,
                                     String lastName,
                                     String email,
                                     String gender,
                                     String mobile,
                                     String subject,
                                     String hobby,
                                     String pictureName,
                                     String currentAddress,
                                     String state,
                                     String city) {
        successHeader.shouldHave(text("Thanks for submitting the form"));
        nameColumn.shouldHave(text(firstName + ' ' + lastName));
        studentEmailColumn.shouldHave(text(email));
        studentGenderColumn.shouldHave(text(gender));
        birthdateColumn.shouldHave(text("Date of Birth 15 August,1988"));
        mobileColumn.shouldHave(text(mobile));
        subjectsColumn.parent().shouldHave(text(subject));
        hobbyColumn.parent().shouldHave(text(hobby));
        pictureColumn.parent().shouldHave(text(pictureName));
        addressColumn.shouldHave(text(currentAddress));
        stateAndCityColumn.parent().shouldHave(text(state + ' ' + city));
    }


}
