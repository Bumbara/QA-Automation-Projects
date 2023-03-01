package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends DriverManager {

    protected WebElement getElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        return element;
    }

    protected void clickOnElement(By locator) {
        getElement(locator).click();
    }

    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.sendKeys(text);
    }

    protected void clearText(By locator) {
        WebElement element = getElement(locator);
        element.clear();
    }

    protected void switchToIframe(String iFrameId) {
        driver.switchTo().frame(iFrameId);
    }

    protected void switchToParentFrame () {
        driver.switchTo().parentFrame();
    }

    protected void pressEnterKey (By locator) {
        WebElement element = getElement(locator);
        element.sendKeys(Keys.ENTER);
    }
    protected boolean isAligned(String text, By locator) {
        WebElement element = getElement(locator);
        if (element.isDisplayed()) {
            System.out.println("Text is aligned in " + text + "!");
            return true;
        } else {
            System.out.println("Text is not aligned correctly!");
        }
        return false;
    }
    protected boolean isDifferentColor(By locator) {
        WebElement element = getElement(locator);
        if (element.isDisplayed()) {
            System.out.println("Color of text is changed!");
            return true;
        } else {
            System.out.println("Color of text is NOT changed!");
        }
        return false;
    }

//    protected void selectText(By locator) {
//        WebElement element = getElement(locator);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element, 10, 5)
//                .clickAndHold()
//                .moveByOffset(0, 0)
//                .release()
//                .perform();
//    }

    protected void tripleClick(By locator) {
        WebElement element = getElement(locator);
        Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions = action.moveToElement(element).doubleClick();
        actions.click().build().perform();
    }

//    protected void selectText(By locator) {
//        WebElement element = getElement(locator);
//        Actions action = new Actions(driver);
//        action.moveToElement(element, 3, 3).click().keyDown(Keys.SHIFT)
//                .moveToElement(element, 200, 0).click().keyUp(Keys.SHIFT).build().perform();
//    }


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

    protected boolean isBolded(By locator) {
        WebElement element = getElement(locator);
        if (element.isDisplayed()) {
            System.out.println("Text is BOLDED!");
            return true;
        } else {
            System.out.println("Text is NOT bolded!");
        }
        return false;
    }

    protected void hover(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = getElement(locator);
        actions.moveToElement(element).perform();
    }
}
