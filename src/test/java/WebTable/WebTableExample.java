package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void tableTesting(){

        //how many rows in the table

        int tableRowCount= driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("tableRowCount: "+tableRowCount);

        //how many columns in the table

        int tableColumnCount= driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("table column count: " + tableColumnCount);
    }
}
