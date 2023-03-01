package tests;

import org.testng.annotations.Test;
import pages.IFramePage;
import pages.TextPage;

public class TextPageTest extends BaseTest {

    @Test
    public void clearTextField() {
        TextPage textPage = new TextPage(driver);
        textPage.toIframe();
        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.clearTextField().clickTextbox().typeText("Text in first row!").pressEnter()
                .typeText("Text in second row!").toParentFrame();
        textPage.clickRightAlign().toIframe();
        iFramePage.pressEnter().typeText("Text in third row!").toParentFrame();
        textPage.clickCenterAlign().toIframe().checkCenterTextAlignment()
                .selectText("1").toParentFrame().clickBoldButton().toIframe();
        iFramePage.checkBoldedText();
        iFramePage.selectText("2").toParentFrame();
        textPage.clickFormatButton().hoverTextColor().changeTextColor().toIframe().checkTextColor().simpleClick();


    }
}
