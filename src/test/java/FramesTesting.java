import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
        System.out.println("after click inside frame button text: "+ afterClickButtonText);


        // 2. Click mr inside nested frame

        driver.switchTo().defaultContent(); // switch to home page
        driver.switchTo().frame(2); // switch to nested frame
        driver.switchTo().frame(0); // switch to child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();
        System.out.println("after click nested button frame text: "+button3.getText());

        // 3. How many frames in this page

        driver.switchTo().defaultContent();
        List<WebElement> iframes= driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());
    }
}
