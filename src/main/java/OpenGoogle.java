import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

    public static void main(String[] arg){
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Chamod Ganegoda\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        //WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
    }
}
