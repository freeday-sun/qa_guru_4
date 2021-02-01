package tests;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

  @BeforeAll
  static void beforeAll() {
    open("https://demoqa.com/");
  }

  @BeforeEach
  void setUp() {
    clearBrowserCookies();
    clearBrowserLocalStorage();
  }

}
