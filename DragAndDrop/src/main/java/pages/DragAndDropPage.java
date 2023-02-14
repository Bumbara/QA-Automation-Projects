package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePage{

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }
    private By columnA = By.xpath("//div[@id='column-a']");
    private By columnB = By.xpath("//div[@id='column-b']");

    public DragAndDropPage dragAndDropSqareA() {
        dragAndDrop(columnA, columnB);
        return this;
    }

    public void verifySquarePosition(String textMessage1, String textMessage2) {
        matchExpectedText(columnA, textMessage1);
        matchExpectedText(columnB, textMessage2);
    }
}

