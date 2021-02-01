package tests;

import static com.codeborne.selenide.Selenide.open;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.CompleteFormPage;
import pages.PracticeFormPage;

public class PracticeFormTests extends BaseTest {

  @BeforeAll
  static void beforeAll() {
    open("https://demoqa.com/automation-practice-form");

  }

  @Test
  void praticeFormTest() throws InterruptedException {
    // preparation
    // TODO add all these stuff into DataClass
    String
        firstName = "FirstName",
        lastName = "LastName",
        email = "test@test.com",
        gender = "Other",
        phoneNumber = "0000000000",
        day = "7",
        month = "April",
        year = "1985",
        filePath = "trying.jpg",
        address = "Test address",
        state = "NCR",
        city = "Delhi";

    List<String>
        subjects = List.of("Maths", "Hindi"),
        hobbies = List.of("Sports", "Reading");

    // action
    var practiceForm = new PracticeFormPage();

    practiceForm
        .checkFormTitile()
        .fillFirstName(firstName)
        .fillLastName(lastName)
        .fillEmail(email)
        .selectGender(gender)
        .fillUserNumber(phoneNumber)
        .selectBirthDay(day, month, year)
        .selectSubjects(subjects)
        .selectHobbies(hobbies)
        .uploadPicture("src/test/resources/" + filePath)
        .fillAddress(address)
        .fillState(state)
        .fillCity(city)
        .clickSubmitButton();
    Thread.sleep(10000);

    // assert
    var completeFormPage = new CompleteFormPage();
    String expectedTitle = "Thanks for submitting the form";

    completeFormPage
        .checkFormTitle(expectedTitle)
        .validateData(
            firstName,
            lastName,
            email,
            gender,
            phoneNumber,
            day,
            month,
            year,
            filePath,
            address,
            state,
            city,
            subjects,
            hobbies);

  }
}
