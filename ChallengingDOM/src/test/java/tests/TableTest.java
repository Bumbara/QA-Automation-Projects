package tests;


import org.testng.annotations.Test;
import pages.TablePage;

public class TableTest extends BaseTest {

    @Test
    public void proba() {
        TablePage tablePage = new TablePage(driver);
        tablePage.verifyTextInTable();
    }
}
