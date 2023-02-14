package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DownloadPage extends BasePage {

    By downloadLink = By.xpath("//a[text()='sample.pdf']");

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public DownloadPage clickSameple() {
       clickOnElement(downloadLink);
       return this;
    }

    public void verifyFileDownload(String fileName) {
        isFileDownloaded(fileName);
    }

    public void verifyFileDelete(String filePath, String fileName) {
        deleteFile(filePath, fileName);
    }

    public void verifyFileContent(String pdfPath) throws Exception {
        pdfContent(pdfPath);
    }


}
