package tests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("tomsmith").setPassword("SuperSecretPassword!").clickLogin().verifyValidLoginText();
    }
    @Test
    public void validLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("tomsmith").setPassword("SuperSecretPassword!").clickLogin().verifyValidLoginText();

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        secureAreaPage.clickLogout().verifyValidLogoutText();
    }
    @Test
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("johnsmith").setPassword("SuperSecretPassword!").clickLoginAndStayOnLoginPage()
                .verifyInvalidLogin("Your username is invalid!");
        loginPage.clearInputField();
        loginPage.setUsername("tomsmith").setPassword("SuperSecretPassword").clickLoginAndStayOnLoginPage()
                .verifyInvalidLogin("Your password is invalid!");
    }

}
