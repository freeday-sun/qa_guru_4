package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.util.List;

public class PracticeFormPage {
  private SelenideElement
      mainHeader = $(".main-header"),
      firstName = $("#firstName"),
      lastName = $("#lastName"),
      email = $("#userEmail"),
      userNumber = $("#userNumber"),
      dataOfBirthWrapper = $(".react-datepicker-wrapper"),
      mountSelector = $(".react-datepicker__month-select"),
      yearSelector = $(".react-datepicker__year-select"),
      uploadButton = $("#uploadPicture"),
      currentAddress = $("#currentAddress"),
      stateSelector = $("#state input"),
      citySelector = $("#city input"),
      submitButton = $("#submit");

  private ElementsCollection
      daysSelectors = $$x("//*[contains(@class, \"react-datepicker__day--\")]"),
      subjectsInput = $$("#subjectsContainer input");

  public PracticeFormPage checkFormTitile(){
    mainHeader.shouldBe(Condition.visible);
    return this;
  }

  public PracticeFormPage fillFirstName(String firstNameValue){
    firstName.setValue(firstNameValue);
    return this;
  }

  public PracticeFormPage fillLastName(String lastNameValue){
    lastName.setValue(lastNameValue);
    return this;
  }

  public PracticeFormPage fillEmail(String emailValue){
    email.setValue(emailValue);
    return this;
  }

  public PracticeFormPage fillUserNumber(String userNumberValue){
    userNumber.setValue(userNumberValue);
    return this;
  }

  public PracticeFormPage selectGender(String gender) {
    $(byText(gender)).click();
    return this;
  }

  public PracticeFormPage selectBirthDay(String day, String month, String year) {
    dataOfBirthWrapper.click();
    mountSelector.selectOption(month);
    yearSelector.selectOption(year);
    daysSelectors.findBy(Condition.text(day)).click();
    return this;
  }

  public PracticeFormPage selectSubjects(List<String> subjects){
    for(String subject : subjects)
    {
      subjectsInput.get(0).setValue(subject).pressEnter();
    }
    return this;
  }

  public PracticeFormPage selectHobbies(List<String> hobbies){
    for (String hobby : hobbies){
      $(Selectors.withText(hobby)).click();
    }
    return this;
  }

  public PracticeFormPage uploadPicture(String imagePath){
    uploadButton.uploadFile(new File(imagePath));
    return this;
  }

  public PracticeFormPage fillAddress(String address){
    currentAddress.setValue(address);
    return this;
  }

  public PracticeFormPage fillState(String state){
    stateSelector.setValue(state).pressEnter();
    return this;
  }

  public PracticeFormPage fillCity(String city){
    citySelector.setValue(city).pressEnter();
    return this;
  }

  public PracticeFormPage clickSubmitButton(){
    submitButton.click();
    return this;
  }

}
