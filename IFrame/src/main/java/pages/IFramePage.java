package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePage {

    private By textFieldBox = By.xpath("//body[@class='mce-content-body ']");
    private By centerAlignedText = By.xpath("//p[@style='text-align: center;' and text()='Text in third row!']");
    private By firstRowText = By.xpath("//p[text()='Text in first row!']");
    private By secondRowText = By.xpath("//p[text()='Text in second row!']");
    private By thirdRowText = By.xpath("//p[text()='Text in third row!']");
    private By boldedText = By.xpath("//p//strong[text()='Text in first row!']");
    private By coloredText = By.xpath("//span[@style='color: rgb(186, 55, 42);' and text()='Text in second row!']");
    private By simpleClick = By.xpath("//body[@id='tinymce']");



    public IFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public IFramePage checkCenterTextAlignment() {
        isAligned("center", centerAlignedText);
        return this;
    }

    public IFramePage selectText(String text) {
        if (text.equals("1")) {
            tripleClick(firstRowText);
        } else if (text.equals("2")) {
            tripleClick(secondRowText);
        } else if (text.equals("3")) {
            tripleClick(thirdRowText);
        }
        return this;
    }

    public IFramePage clearTextField() {
        clearText(textFieldBox);
        return this;
    }
    public IFramePage clickTextbox() {
        clickOnElement(textFieldBox);
        return this;
    }
    public IFramePage typeText(String exampleText) {
        typeIn(textFieldBox, exampleText);
        return this;
    }
    public IFramePage pressEnter() {
        pressEnterKey(textFieldBox);
        return this;
    }
    public TextPage toParentFrame() {
        switchToParentFrame();
        return new TextPage(driver);
    }

    public IFramePage checkBoldedText() {
        isBolded(boldedText);
        return this;
    }
    public IFramePage checkTextColor() {
        isDifferentColor(coloredText);
        return this;
    }
    public IFramePage simpleClick() {
        clickOnElement(simpleClick);
        return this;
    }


}
