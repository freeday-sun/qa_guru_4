package tests;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
  protected Faker faker = new Faker();

  @BeforeAll
  static void beforeAll() {
    Configuration.startMaximized = true;
    open("https://demoqa.com/");
  }

  @BeforeEach
  void setUp() {
    clearBrowserCookies();
    clearBrowserLocalStorage();
  }

}
