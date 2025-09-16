package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

public class AddingGiftPage extends AbsBasePage{
  private final By BUTTON_VIEWING = By.xpath("//button[@class='btn btn-primary' and text()='Просмотр']");
  private final By ADD_GIFT_BTN = By.xpath("//button[@class='mb-4 btn btn-primary' and text()='Добавить подарок']");
  private final By NAME_GIFT = By.xpath("//input[@class='form-control' and @type='text']");
  private final By DESCRIPTION_GIFT = By.xpath("//textarea[@class='form-control']");
  private final By STORE_LINK = By.xpath("//label[text()='Ссылка на магазин (необязательно)']/following-sibling::input[@class='form-control' and @type='url']");
  private final By PRICE = By.xpath("//input[@class='form-control' and @type='number']");
  private final By IMG_LINK = By.xpath("//label[text()='Ссылка на изображение (необязательно)']/following-sibling::input[@class='form-control' and @type='url']");
  private final By BTN_ADD = By.xpath("//button[@class='btn btn-primary' and @type='submit']");
  private final By NAME_WSHL = By.xpath("//input[@class='form-control' and @type='text']");
  private Waiter waiter;

  public AddingGiftPage (WebDriver driver)
  {super(driver, "/wishlists");
    this.waiter = new Waiter(driver);
  }

  public void clickBtnView (String wishlistName) {
    By btnView = By.xpath("//div[@class='card-title h5' and text()='" + wishlistName + "']/ancestor::div[@class='card']//button[text()='Просмотр']");
    $(btnView).click();
  }

  public void addGift(String nameGift, String descriptionGift, String storeLink,
                      String price, String imgLink){
   // $(BUTTON_VIEWING).click();
    $(ADD_GIFT_BTN).click();
    $(NAME_GIFT).sendKeys(nameGift);
    $(DESCRIPTION_GIFT).sendKeys(descriptionGift);
    $(STORE_LINK).sendKeys(storeLink);
    $(PRICE).sendKeys(price);
    $(IMG_LINK).sendKeys(imgLink);
    $(BTN_ADD).click();
  }

  public boolean isAddGift(String nameGift) {
    By errorMsg = By.xpath("//div[@class='mt-5 container' and text()='Не удалось добавить подарок']");
    if(waiter.waitForElementPresent(errorMsg)) {
      String errorTxt = $(errorMsg).getText();
      logger.error("❌Подарок не добавлен. " + errorTxt);
      return false;
    }
    By giftLocator = By.xpath("//div[@class='card-title h5' and text()='" + nameGift + "']");
    logger.info("✅Подарок добавлен успешно");
    return waiter.waitForElementPresent(giftLocator);
  }

}
