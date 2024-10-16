import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();;
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void framesExample(){

        // 1. Click me (inside frame)

        driver.switchTo().frame(0);

        WebElement button1= driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText= button1.getText();
        System.out.println("after click inside frame button text "+ afterClickButtonText);


        // 2. Click mr inside nested frame
        // 3. How many frames in this page
    }
}
