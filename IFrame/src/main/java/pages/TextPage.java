package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextPage extends BasePage {


    private By alignCenterButton = By.xpath("//button[@title='Align center']");
    private By alignRightButton = By.xpath("//button[@title='Align right']");
    private By boldButton = By.xpath("//button[@title='Bold']");
    private By formatButton = By.xpath("//span[text()='Format']/ancestor::button");
    private By textColorField = By.xpath("//div[@title='Text color']");
    private By textColor = By.xpath("//div[@style='background-color: rgb(186, 55, 42);']");


    public TextPage(WebDriver driver) {
        this.driver = driver;
    }

    public IFramePage toIframe() {
        switchToIframe("mce_0_ifr");
        return new IFramePage(driver);
    }

    public TextPage clickCenterAlign() {
        clickOnElement(alignCenterButton);
        return this;
    }
    public TextPage clickRightAlign() {
        clickOnElement(alignRightButton);
        return this;
    }
    public TextPage clickBoldButton() {
        tripleClick(boldButton);
        return this;
    }
    public TextPage clickFormatButton() {
        clickOnElement(formatButton);
        return this;
    }
    public TextPage hoverTextColor() {
        hover(textColorField);
        return this;
    }
    public TextPage changeTextColor() {
        clickOnElement(textColor);
        return this;
    }
}
