package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationFormPage;
import pages.CreatingWishlistPage;

public class TestCreateWishlist extends AbsBaseTestSuite{

  private static final Logger logger = LogManager.getLogger(TestCreateWishlist.class);

  @Test
  @DisplayName("Создание списка желаний при заполнении всех полей")
  public void createForm (){
    String wishlistName = "Список желаний";
    String description = "Мой список желаний на какой нибудь праздник";

    AuthorizationFormPage loginPage = new AuthorizationFormPage(driver);
    loginPage.open();
    loginPage.loginAndVerify("AndreyT", "012345");

    CreatingWishlistPage createPage = loginPage.sendloginPage();
    logger.info("Создание списка желаний");
    createPage.createWishlist(wishlistName, description);

    boolean isCreated = createPage.isWishlistCreate(wishlistName);
    Assertions.assertTrue(isCreated, "Список желаний не был создан");
    logger.info("Список желаний успешно создан!");
  }

  @Test
  @DisplayName("Создание списка желаний при заполнении только названия списка")
  public void createFormOnlyName (){
    String wishlistName = "Список желаний без описания";
    String description = "";

    AuthorizationFormPage loginPage = new AuthorizationFormPage(driver);
    loginPage.open();
    loginPage.loginAndVerify("AndreyT", "012345");

    CreatingWishlistPage createPage = loginPage.sendloginPage();
    logger.info("Создание списка желаний без описания");
    createPage.createWishlist(wishlistName, description);
    boolean isCreated = createPage.isWishlistCreate(wishlistName);
    Assertions.assertTrue(isCreated, "Список желаний не был создан");
    logger.info("✅ Список желаний успешно создан!");
  }
}