import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogleTest {


    public void googleTest(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");

    }
}
