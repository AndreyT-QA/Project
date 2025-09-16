package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.Waiter;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AuthorizationFormPage extends AbsBasePage{

  private final By USER_NAME = By.xpath("//input[@class='form-control' and @type='text']");
  private final By PASSWORD = By.xpath("//input[@class='form-control' and @type='password']");
  private final By BUTTON_LOGIN = By.xpath("//button[@class='btn btn-primary' ]");
  private final By ERROR_MSG = By.xpath("//div[@class='fade alert alert-danger show']");
  //private final By WISHLIST = By.xpath("//h2[text()='Мои списки желаний']");
  private Waiter waiter;


  public AuthorizationFormPage(WebDriver driver)
  {super(driver, "/login");
    this.waiter = new Waiter(driver);
  }
  public void loginAndVerify(String userName, String password) {
    $(USER_NAME).sendKeys(userName);
    $(PASSWORD).sendKeys(password);
    $(BUTTON_LOGIN).click();
    verifyLoginStatus();
  }

  public CreatingWishlistPage sendloginPage() {
    return new CreatingWishlistPage(driver);
  }

  public void verifyLoginStatus() {
    boolean hasError = waiter.waitForElementPresent(ERROR_MSG);

    if (hasError)
      {
      String errorText = $(ERROR_MSG).getText();
      logger.info("❌ Ошибка входа: " + errorText);
      Assertions.fail("Вход не удался: " + errorText);
    } else {
      logger.info("✅ Вход выполнен успешно!");
      Assertions.assertTrue(true, "Вход выполнен успешно");
    }
  }
  }