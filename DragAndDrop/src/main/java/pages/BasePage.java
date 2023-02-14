package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage extends DriverManager {

    protected WebElement getElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        return element;
    }

    protected void dragAndDrop(By locator1, By locator2) {
        WebElement drag = getElement(locator1);
        WebElement drop = getElement(locator2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n"
                +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n"
                + "setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n"
                +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n"
                + "function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n"
                + "event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n"
                + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n"
                +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n"
                +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n"
                +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n"
                +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n"
                +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",drag, drop);

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

