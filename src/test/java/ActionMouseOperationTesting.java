import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ActionMouseExample() throws InterruptedException {

        // 1. Move to an element operation

          driver.get("https://www.leafground.com/drag.xhtml");
          Actions actions= new Actions(driver);


//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
//        Thread.sleep(4000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
//        Thread.sleep(4000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
//        Thread.sleep(4000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();
//        Thread.sleep(4000);

        //second way

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt39")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();

        // 2. Drag and drop operation

        WebElement clickedItem = driver.findElement(By.id("form:drag"));
        WebElement dragHere = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(clickedItem).moveToElement(dragHere).release(dragHere).perform();  //first way
        actions.dragAndDrop(clickedItem,dragHere).perform();                                      // second way


        // 3. Slider operation

        WebElement slider= driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println("slider location before moving: "+ slider.getLocation());

        actions.dragAndDropBy(slider,50,0).perform();
        System.out.println("slider location after moving: "+ slider.getLocation());

    }

    @Test
    public void rightClickAction(){

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClick =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions1= new Actions(driver);
        actions1.contextClick(rightClick).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertPop= driver.switchTo().alert();
        System.out.println("Alert shows the text as: "+ alertPop.getText());
        alertPop.accept();


    }
}
