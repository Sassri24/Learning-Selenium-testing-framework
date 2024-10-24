import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageTesting {

    WebDriver driver;

    //open browser and go to website using before method

    @BeforeMethod
    public void openWebSite(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }

    //broken Image example 01

    @Test
    public void brokenImageExample(){
        List<WebElement> brokenImages= driver.findElements(By.xpath("//div[@class='example']/img"));

        //naturalWidth is equal to 0 in default (In the broken Image)...

        for(WebElement image : brokenImages){
            if(image.getAttribute("naturalWidth").equals(0)){
                System.out.println();
            }
        }
    }
}
