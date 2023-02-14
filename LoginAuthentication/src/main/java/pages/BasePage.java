package pages;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends DriverManager {

    protected WebElement getElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        return element;
    }

    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clearText(By locator) {
        WebElement element = getElement(locator);
        element.clear();
    }

    protected void clickOnElement(By locator) {
        getElement(locator).click();
    }

    protected  boolean matchExpectedText(By locator, String expectedText) {
        WebElement element = getElement(locator);
        if (element.getText().trim().contains(expectedText)) {
            System.out.println("Passed!");
            return true;
        } else {
            System.out.println("Failed!");
        }
        return false;
    }
}