package pages;

import core.DriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;

public class BasePage extends DriverManager {

    protected WebElement getElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        return element;
    }

    protected void clickOnElement(By locator) {
        getElement(locator).click();
    }


    public static Boolean isFileDownloaded(String fileName) {
        boolean flag = false;
        String dirPath = "C:\\\\Users\\\\lukas\\\\Downloads";
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println("'" + fileName + "'" + " file is present");
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }

    public boolean deleteFile(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                dirContents[i].delete();
                System.out.println("'"+fileName+"'" + " is deleted");
                return true;
            }
        }
        return false;
    }

    public void pdfContent(String fullPdfPath) throws Exception {
        File file = new File(fullPdfPath);
        FileInputStream fis = new FileInputStream(file);

        System.out.println("Contet of file 'sample.pdf' is: ");
        PDDocument pdfDocument = PDDocument.load(fis);
        System.out.println(pdfDocument.getPages().getCount());
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String docText = pdfTextStripper.getText(pdfDocument);
        System.out.println(docText);
        pdfDocument.close();
        fis.close();
    }
}
