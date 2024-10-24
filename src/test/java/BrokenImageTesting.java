import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BrokenImageTesting {

    WebDriver driver;

    //open browser and go to website using before method

    @BeforeMethod
    public void openWebSite(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");
    }

    //broken Image example 01
}
