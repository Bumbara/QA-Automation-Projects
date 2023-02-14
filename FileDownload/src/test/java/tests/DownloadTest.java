package tests;

import org.testng.annotations.Test;
import pages.DownloadPage;

public class DownloadTest extends BaseTest {

    @Test
    public void downloadFile() throws Exception {
        DownloadPage downloadPage = new DownloadPage(driver);
        downloadPage.clickSameple();
        Thread.sleep(3000);
        downloadPage.verifyFileDownload("sample");
        downloadPage.verifyFileContent("C:\\Users\\lukas\\Downloads\\sample.pdf");
        downloadPage.verifyFileDelete("C:\\Users\\lukas\\Downloads", "sample");
    }
}
