package pages;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;

public class CompleteFormPage {
  SelenideElement modalTitle = $x("//*[@class='modal-title h4']");

  ElementsCollection formDate = $$x("//tbody//tr//td");

  public CompleteFormPage checkFormTitle(String formTitle){
    modalTitle.shouldHave(Condition.text(formTitle));
    return this;
  }

  public CompleteFormPage validateData(
      String firstName,
      String lastName,
      String email,
      String gender,
      String phoneNumber,
      String day,
      String month,
      String year,
      String filePath,
      String address,
      String state,
      String city,
      List<String> subjects,
      List<String> hobbies)
  {
    formDate.get(0).shouldHave(Condition.text("Student Name"));
    formDate.get(1).shouldHave(Condition.text(firstName +" " +lastName));
    formDate.get(2).shouldHave(Condition.text("Student Email"));
    formDate.get(3).shouldHave(Condition.text(email));
    formDate.get(4).shouldHave(Condition.text("Gender"));
    formDate.get(5).shouldHave(Condition.text(gender));
    formDate.get(6).shouldHave(Condition.text("Mobile"));
    formDate.get(7).shouldHave(Condition.text(phoneNumber));
    formDate.get(8).shouldHave(Condition.text("Date of Birth"));
    formDate.get(9).shouldHave(Condition.text(day + " " + month + "," + year));
    formDate.get(10).shouldHave(Condition.text("Subjects"));
    formDate.get(11).shouldHave(Condition.text(subjects.get(0) +", "+ subjects.get(1)));
    formDate.get(12).shouldHave(Condition.text("Hobbies"));
    formDate.get(13).shouldHave(Condition.text(hobbies.get(0) +", "+ hobbies.get(1)));
    formDate.get(14).shouldHave(Condition.text("Picture"));
    formDate.get(15).shouldHave(Condition.text(filePath));
    formDate.get(16).shouldHave(Condition.text("Address"));
    formDate.get(17).shouldHave(Condition.text(address));
    formDate.get(18).shouldHave(Condition.text("State and City"));
    formDate.get(19).shouldHave(Condition.text(state + " " + city));

    return this;
  }


}
