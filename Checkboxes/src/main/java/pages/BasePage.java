package pages;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends DriverManager {

    protected WebElement getElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        return element;
    }

    protected void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public boolean isSelected(By locator){
        WebElement checkbox = getElement(locator);
        return checkbox.isSelected();
    }
    public void checkStatusOfCheckbox(By locator){
        if(isSelected(locator)){
            System.out.println("checkbox is selected.");
        }else{
            System.out.println("checkbox is not selected.");
        }
    }
    public void selectCheckbox(By locator){
        if (!getElement(locator).isSelected()){
            clickOnElement(locator);
        }else{
            System.out.println("Checkbox is already selected!");
        }
    }
    public void unselectCheckbox(By locator){
        if (getElement(locator).isSelected()){
            clickOnElement(locator);
        }else{
            System.out.println("Checkbox is not selected!.");
        }
    }
}