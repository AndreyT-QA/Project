package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AbsBasePage;
import pages.AddingGiftPage;
import pages.AuthorizationFormPage;
import pages.CreatingWishlistPage;

public class TestAddingGiftPage extends AbsBaseTestSuite {
  private static final Logger logger = LogManager.getLogger(TestCreateWishlist.class);

  @Test
  @DisplayName("Добавление подарка при заполнении всех полей")
  public void AddGift (){
    String wishlistName = "Желаемые подарки";
    String description = "Подарочки";
    String nameGift = "Пикап РУ";
    String descriptionGift = "Радиоуправляемый пикап";
    String storeLink = "https://www.detmir.ru/product/index/id/6750768/";
    String price = "10 884";
    String imgLink = "https://img.detmir.st/FON-Rr_j2J9DttoXhYMfmA_mv1WQxFYBgd-74k6QQd0/rs:fit:2448:2448/g:sm/aHR0cHM6Ly9jYXRhbG9nLWNkbi5kZXRtaXIuc3QvbWVkaWEvZGlVM2ludlkxbXlmeWhRQUlBN18wakw1eW1sVmota1lRU2ZjbFctVEpYOD0uanBlZw.webp";

    AuthorizationFormPage loginPage = new AuthorizationFormPage(driver);
    loginPage.open();
    loginPage.loginAndVerify("AndreyT", "012345");

    CreatingWishlistPage createPage = loginPage.sendloginPage();
    logger.info("Создание списка желаний");
    createPage.createWishlist(wishlistName, description);

    AddingGiftPage addingGift = createPage.sendWishlistPage();
    logger.info("Добавление подарка в список желаний");
    addingGift.clickBtnView(wishlistName);
    addingGift.addGift(nameGift, descriptionGift, storeLink, price, imgLink);
    addingGift.isAddGift(nameGift);
  }

  @Test
  @DisplayName("Добавление подарка при заполнении только обязательных полей")
  public void AddGiftOnlyRequiredFields (){
    String wishlistName = "Список подарков";
    String description = "Только обязательные поля";
    String nameGift = "Пикап РУ-red";
    String descriptionGift = "Радиоуправляемый красный пикап";
    String storeLink = "";
    String price = "";
    String imgLink = "";

    AuthorizationFormPage loginPage = new AuthorizationFormPage(driver);
    loginPage.open();
    loginPage.loginAndVerify("AndreyT", "012345");

    CreatingWishlistPage createPage = loginPage.sendloginPage();
    logger.info("Создание списка желаний");
    createPage.createWishlist(wishlistName, description);

    AddingGiftPage addingGift = createPage.sendWishlistPage();
    logger.info("Добавление подарка в список желаний");
    addingGift.clickBtnView(wishlistName);
    addingGift.addGift(nameGift, descriptionGift, storeLink, price, imgLink);
    addingGift.isAddGift(nameGift);
  }

}
