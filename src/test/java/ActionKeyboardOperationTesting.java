import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ActionKeyboardOperationTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

    }
}
