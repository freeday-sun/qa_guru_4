package tests;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
  protected Faker faker = new Faker();

  @BeforeEach
  void setUp() {
    clearBrowserCookies();
    clearBrowserLocalStorage();
  }

}
