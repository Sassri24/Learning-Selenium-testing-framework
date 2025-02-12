import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardOperationTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void KeyBoardExample1() throws InterruptedException {
        driver.get("https://www.google.com/");
         WebElement googleSearchTextBox= driver.findElement(By.name("q"));
         googleSearchTextBox.sendKeys("apple");

         //select typed word (apple)

        Actions actions = new Actions(driver);
        Action storingBuildOperation =actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        storingBuildOperation.perform();

        Thread.sleep(2000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital letters")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .build().perform();

        //to write capital in textbox

        actions.keyDown(googleSearchTextBox, Keys.SHIFT)
                .sendKeys("sassri chamod ganegoda")
                .build().perform();

    }

    @Test
    public void KeyBoardExample2(){
        driver.get("https://www.leafground.com/list.xhtml");
        List<WebElement> selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int listSize=selectable.size();
        System.out.println("list size: " +listSize);

        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .build().perform();

    }
}
