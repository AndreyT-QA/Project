package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AuthorizationFormPage extends AbsBasePage{

  private final By USER_NAME = By.xpath("//input[@class='form-control' and @type='text']");
  private final By PASSWORD = By.xpath("//input[@class='form-control' and @type='password']");
  private final By BUTTON_LOGIN = By.xpath("//button[@class='btn btn-primary']");
  private final By ERROR_MSG = By.xpath("//div[@class='fade alert alert-danger show']");

  public AuthorizationFormPage(WebDriver driver)
  {super(driver, "/login");
  }

  public void fillForm(String userName, String password) {
    $(USER_NAME).sendKeys(userName);
    $(PASSWORD).sendKeys(password);
  }

  public void clickButtonLogin() {
    $(BUTTON_LOGIN).click();
  }

//  boolean isEmpty = $(ERROR_MSG).isEmpty();

  public boolean isLoginSuccessful() {
    return !$(ERROR_MSG).isDisplayed();
  }

  public void verifyLoginStatus() {
    if (isLoginSuccessful()) {
      logger.info("✅ Вход выполнен успешно!");
      Assertions.assertTrue(true, "Вход выполнен успешно");
    } else {
      String errorText = $(ERROR_MSG).getText();
      logger.info("❌ Ошибка входа: " + errorText);
      Assertions.fail("Вход не удался: " + errorText);
    }
  }
}
