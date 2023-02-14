package tests;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxesStatusTest extends BaseTest{

    @Test
    public void checkCheckboxesStatuses() {
        CheckboxPage checkbox = new CheckboxPage(driver);
        checkbox.checkStatusOfFirstCheckbox().checkStatusOfSecondCheckbox();
    }
    @Test
    public void checkFirstCheckbox() {
        CheckboxPage checkbox = new CheckboxPage(driver);
        checkbox.selectFirstCheckbox();
    }
    @Test
    public void uncheckSecondCheckbox() {
        CheckboxPage checkbox = new CheckboxPage(driver);
        checkbox.unselectSecondCheckbox();
    }
}