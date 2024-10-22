import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class FilesDownloadUploadTesting {

    WebDriver driver;

    @BeforeMethod

    public void openFileTestPage(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/file.xhtml");
    }
}
