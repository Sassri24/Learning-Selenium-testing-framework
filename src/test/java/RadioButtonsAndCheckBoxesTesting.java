import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsAndCheckBoxesTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioButtonTesting(){

        //get link

        driver.get("https://www.leafground.com/radio.xhtml");

    }
}
