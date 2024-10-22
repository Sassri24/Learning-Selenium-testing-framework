import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionKeyboardOperationTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void KeyBoardExample1(){
        driver.get("https://www.google.com/");
         WebElement googleSearchTextBox= driver.findElement(By.name("q"));
         googleSearchTextBox.sendKeys("apple");

         //select typed word (apple)

        Actions actions = new Actions(driver);
        Action storingBuildOperation =actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        storingBuildOperation.perform();

    }
}
