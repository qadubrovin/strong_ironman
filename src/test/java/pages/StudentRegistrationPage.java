package pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class StudentRegistrationPage {


    static Faker faker = new Faker();

    //variables
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender3 = "Other",
            mobile = faker.number().digits(10),
            monthOfBirth = "August",
            yearOfBirth = "1988",
            dayOfBirth = "15",
            subject = "English",
            hobby = "Sports",
            picturePath = "img/Screenshot_2.png",
            pictureName = "Screenshot_2.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Agra";

    //selectors for fill form
    public String otherGender = "//*[@id='genterWrapper']//*[@for='gender-radio-3']",
            name = "#firstName",
            familyName = "//*[@id='lastName']",
            userEmail = "#userEmail",
            userNumber = "#userNumber",
            subjectInput = "#subjectsInput",
            submitButton = "#submit",
            hobbySports = "//*[contains(text(),'Sports')]",
            uploadPicture = "#uploadPicture",
            usersAddress = "#currentAddress";

    //selectors for success form
    public String successHeader = "#example-modal-sizes-title-lg",
            nameColumn = "//*[contains(text(),'Student Name')]//..",
            studentEmailColumn = "//*[contains(text(),'Student Email')]//..",
            studentGenderColumn = "//*[@class='table-responsive']//td[contains(text(),'Gender')]//..",
            birthdateColumn = "//*[@class='table-responsive']//td[contains(text(),'Date of Birth')]//..",
            mobileColumn = "//*[@class='table-responsive']//td[contains(text(),'Mobile')]//..",
            subjectsColumn = "//td[text()='Subjects']",
            hobbyColumn = "//td[text()='Hobbies']",
            pictureColumn = "//td[text()='Picture']",
            addressColumn = "//*[@class='table-responsive']//td[contains(text(),'Address')]//..",
            stateAndCityColumn = "//td[text()='State and City']",
            closeModal = "#closeLargeModal";

    //methods
    public void setDate() {
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
