package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

public class CreatingWishlistPage extends AbsBasePage {
private final By BTN_CREATE_WSHL = By.xpath("//button[@class='btn btn-primary' and text()='Создать новый список']");
private final By NAME_WSHL = By.xpath("//input[@class='form-control' and @type='text']");
private final By DESCRIPTION = By.xpath("//textarea[@class='form-control']");
private final By CREATE_WSHL = By.xpath("//button[@class='btn btn-primary' and text()='Создать']");
private Waiter waiter;

public CreatingWishlistPage (WebDriver driver)
{super(driver, "/wishlists");
  this.waiter = new Waiter(driver);
}

  public void createWishlist (String wishlistName, String description){
  $(BTN_CREATE_WSHL).click();
  $(NAME_WSHL).sendKeys(wishlistName);
  $(DESCRIPTION).sendKeys(description);
  $(CREATE_WSHL).click();
  }
  public boolean isWishlistCreate(String wishlistName) {
  By wishlistLocator = By.xpath("//div[@class='card-title h5' and text()='" + wishlistName + "']");
    return waiter.waitForElementPresent(wishlistLocator);
  }



}
