package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import pages.AuthorizationFormPage;


public class TestAuthorizationFormPage extends AbsBaseTestSuite{
  private static final Logger logger = LogManager.getLogger(TestRegisterFormPage.class);

  @Test
  @DisplayName("Авторизация пользователя")
  public void formAuthorization (){
    String userName = "AndreyT";
    String password = "012345";

    AuthorizationFormPage mainPage = new AuthorizationFormPage(driver);
    logger.info("Авторизация пользователя");
    mainPage.fillForm(userName, password);
    mainPage.clickButtonLogin();
    mainPage.verifyLoginStatus();
  }








}
