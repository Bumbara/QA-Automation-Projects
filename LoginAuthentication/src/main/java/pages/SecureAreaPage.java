package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {


    private By verificationText = By.xpath("//div[@id='flash']");
    private By logoutButton = By.xpath("//a[@class='button secondary radius']");
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;

    }

    public void verifyValidLoginText() {
        matchExpectedText(verificationText, "You logged into a secure area!");
    }

    public LoginPage clickLogout() {
        clickOnElement(logoutButton);
        return new LoginPage(driver);
    }


}
