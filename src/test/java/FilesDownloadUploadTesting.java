import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FilesDownloadUploadTesting {

    WebDriver driver;

    @BeforeMethod

    public void openFileTestPage(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void fileDownloadTest() throws InterruptedException {

        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(4000);

        File file= new File("C:\\Users\\Chamod Ganegoda\\Downloads");
        File[] totalFiles = file.listFiles();
        for(File findFile:totalFiles){
            if(findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }
    }

    @Test
    public void fileUploadTest() throws AWTException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st way (using robot class)

        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadButton.click();

        //windows control begin here
        String data= "C:\\Users\\Chamod Ganegoda\\Downloads\\TestLeaf Logo.png";
        StringSelection selection= new StringSelection(data);

        //copying path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        //2nd way (using send keys - applicable only for element type is file(find it through the inspect of website)-input type="file")

        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);

    }
}