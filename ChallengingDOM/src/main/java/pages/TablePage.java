package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TablePage extends DriverManager {

    private By tableRow6 = By.xpath("//table//tr[6]");

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }
    public String tableText() {


        List<WebElement> webElements = driver.findElements(tableRow6);
        String elementText = "";
        for (int i = 0; i < webElements.size(); i++) {
            elementText = webElements.get(i).getText();
            System.out.println(elementText);
        }
        return elementText;
    }

    public void  verifyTextInTable() {
        String expected = "Iuvaret5 Apeirian5 Adipisci5 Definiebas5 Consequuntur5 Phaedrum5 edit delete";
        String actual = tableText();
        Assert.assertEquals(tableText(), expected);
    }

}
