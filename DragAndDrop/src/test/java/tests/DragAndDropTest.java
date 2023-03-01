package tests;

import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void squarePlaceChange() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragAndDropSqareA();
        dragAndDropPage.verifySquarePosition("B", "A");
    }
}
