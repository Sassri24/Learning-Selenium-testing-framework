import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BrokenImageTesting {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

    }
}
