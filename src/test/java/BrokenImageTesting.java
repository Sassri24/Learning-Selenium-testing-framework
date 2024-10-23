import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BrokenImageTesting {

    WebDriver driver;

    //before method

    @BeforeMethod
    public void openWebSite(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

    }
}
