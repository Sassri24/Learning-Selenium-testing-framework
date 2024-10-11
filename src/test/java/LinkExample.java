import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenGoogle(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest(){
        // 1.Take me to dashboard

        WebElement home= driver.findElement(By.linkText("Go to Dashboard"));
        home.click();
        driver.navigate().back();

        // 2.find my destination

        WebElement destination =driver.findElement(By.partialLinkText("Find the URL"));
        String websitename =destination.getAttribute("href");
        System.out.println("website link is"+ websitename);

        // 3.Am I broken

        WebElement brokenLink= driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String linkTitle=driver.getTitle();
        if(linkTitle.contains("404")){
            System.out.println("the link is broken");
        }else{
            System.out.println("the link is not broken");
        }
        driver.navigate().back();

        // 4.Duplicate link

        WebElement home1= driver.findElement(By.linkText("Go to Dashboard"));
        home1.click();
        driver.navigate().back();

        // 5.Count page links

        List<WebElement> tags= driver.findElements(By.tagName("a"));
        int linkCount= tags.size();
        System.out.println("link count of full page : "+ linkCount);

        // 6.Count layout links

        WebElement links =driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks= links.findElements(By.tagName("a"));
        System.out.println("link count of layout : "+ countOfLayoutLinks.size());
    }
}
