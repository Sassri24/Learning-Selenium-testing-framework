import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderTesting {

    WebDriver driver;

    //Open Chrome browser

    @BeforeMethod
    public void openWebSite(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    //Calender example 01

    @Test
    public void calenderExample01(){

        driver.get("https://jqueryui.com/datepicker/");

        //method 01

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));

        //to use send keys element input type must be text (input type="text")

        datePicker.sendKeys("24/12/2024");

        //method 02

    }
}
