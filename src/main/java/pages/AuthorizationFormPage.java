package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class AuthorizationFormPage extends AbsBasePage{

  private final By USER_NAME = By.xpath("//input[@class='form-control' and @type='text']");
  private final By PASSWORD = By.xpath("//input[@class='form-control' and @type='password']");
  private final By BUTTON_LOGIN = By.xpath("//button[@class='btn btn-primary']");
  private final By ERROR_MSG = By.xpath("//div[@class='fade alert alert-danger show']");
  private final By WISHLIST = By.xpath("//h2[text()='Мои списки желаний']");


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

//  public boolean isLoginSuccessful() {
//    return $(WISHLIST).isDisplayed();
//  }

//  boolean isDisplayed = $(WISHLIST).isDisplayed();
  //!wishlistElements.isEmpty() && wishlistElements.get(0).isDisplayed()
  public void verifyLoginStatus() {
    List<WebElement> wishlistElements = driver.findElements(WISHLIST);
    if (!wishlistElements.isEmpty() && wishlistElements.get(0).isDisplayed())  {
      logger.info("✅ Вход выполнен успешно!");
      Assertions.assertTrue(true, "Вход выполнен успешно");
    } else {
      try {
        String errorText = $(ERROR_MSG).getText();
        logger.info("❌ Ошибка входа: " + errorText);
        Assertions.fail("Вход не удался: " + errorText);
      } catch (NoSuchElementException e) {
        logger.error("❌ Ошибка входа: неизвестная ошибка");
        Assertions.fail("Вход не выполнен, ошибка неизвестна");
      }
    }
    }
  }



//  public void verifyLoginStatus() {
//    if (isLoginSuccessful()) {
//      logger.info("✅ Вход выполнен успешно!");
//      Assertions.assertTrue(true, "Вход выполнен успешно");
//    } else {
//        String errorText = $(ERROR_MSG).getText();
//        logger.info("❌ Ошибка входа: " + errorText);
//        Assertions.fail("Вход не удался: " + errorText);
//    }
//  }

