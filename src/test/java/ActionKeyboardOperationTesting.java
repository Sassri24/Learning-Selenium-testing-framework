import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class ActionKeyboardOperationTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

    }
}
