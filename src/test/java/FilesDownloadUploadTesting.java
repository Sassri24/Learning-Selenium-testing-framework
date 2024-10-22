import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilesDownloadUploadTesting {

    WebDriver driver;

    @BeforeMethod

    public void openFileTestPage(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/file.xhtml");
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();

        Thread.sleep(4000);

    }
}
