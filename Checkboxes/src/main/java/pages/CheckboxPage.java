package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage extends BasePage{

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }
    private By firstCheckbox = By.xpath("//input[@type='checkbox'][1]");
    private By secondCheckbox = By.xpath("//input[@type='checkbox'][2]");

    public CheckboxPage checkStatusOfFirstCheckbox() {
        System.out.print("First ");
        checkStatusOfCheckbox(firstCheckbox);
        return this;
    }
    public CheckboxPage checkStatusOfSecondCheckbox() {
        System.out.print("Second ");
        checkStatusOfCheckbox(secondCheckbox);
        return this;
    }
    public CheckboxPage selectFirstCheckbox(){
        selectCheckbox(firstCheckbox);
        checkStatusOfFirstCheckbox();
        return this;
    }
    public CheckboxPage unselectSecondCheckbox(){
        unselectCheckbox(secondCheckbox);
        checkStatusOfSecondCheckbox();
        return this;
    }
}
