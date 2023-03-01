package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = DriverManager.instance.setDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
//    @AfterTest
//    public void quit() {
//        driver.quit();
//    }
}
