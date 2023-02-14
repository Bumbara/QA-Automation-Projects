package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameTextField = By.xpath("//input[@id='username']");
    private By passwordTextField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@class='radius']");
    private By logoutVerificationText = By.xpath("//div[@class='flash success']");
    private By invalidLoginText = By.xpath("//div[@class='flash error']");

    public LoginPage(WebDriver driver) {
       this.driver = driver;
    }

    public LoginPage setUsername(String username) {
        typeIn(userNameTextField, username);
        return this;
    }
    public LoginPage setPassword(String password) {
        typeIn(passwordTextField, password);
        return this;
    }
    public SecureAreaPage clickLogin() {
        clickOnElement(loginButton);
        return new SecureAreaPage(driver);
    }

    public void verifyValidLogoutText() {
        matchExpectedText(logoutVerificationText, "You logged out of the secure area!");
    }

    public void verifyInvalidLogin(String textMessage) {
        matchExpectedText(invalidLoginText, textMessage);
    }

    public void clearInputField() {
        clearText(userNameTextField);
        clearText(passwordTextField);
    }
    public LoginPage clickLoginAndStayOnLoginPage() {
        clickOnElement(loginButton);
        return this;
    }

}
