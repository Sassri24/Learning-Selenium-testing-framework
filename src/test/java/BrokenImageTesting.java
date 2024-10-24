import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageTesting {

    WebDriver driver;

    //Open Chrome browser

    @BeforeMethod
    public void openWebSite(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    //broken Image example 01

    @Test
    public void brokenImageExample01(){

        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> brokenImages= driver.findElements(By.xpath("//div[@class='example']/img"));

        //naturalWidth is equal to 0 in default (In the broken Image)...

        int i = 1;
        for(WebElement image : brokenImages){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("image " + i +" is broken");
            }else{
                System.out.println("image " + i +" not broken");
            }
            i++;
        }
    }

    //broken Image example 01

    @Test
    public void brokenImageExample02(){

        driver.get("https://demoqa.com/broken");
        List<WebElement> brokenImages= driver.findElements(By.xpath("//img[2]"));

        //naturalWidth is equal to 0 in default (In the broken Image)...

        for(WebElement image : brokenImages){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("image is broken");
            }else{
                System.out.println("image not broken");
            }
        }
    }
}
