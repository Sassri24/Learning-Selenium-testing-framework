import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver= new ChromeDriver();
        Dimension newSize=new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonExample(){

        //  1.Click and Confirm title

        WebElement clickButton= driver.findElement(By.id("j_idt88:j_idt90"));
        clickButton.click();
        String savedTitle= driver.getTitle();
        String actualTitle="Dashboard";
        Assert.assertEquals(actualTitle,savedTitle,"Title is not mached");
        driver.navigate().back();

        //  2.Find the position of the Submit button

        WebElement submitButton= driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPosition = submitButton.getLocation();
        int x = xyPosition.getX();
        int y = xyPosition.getY();
        System.out.println( "x position is: "+ x +" | y position is: "+ y );

        //  3.Find the Save button color

        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color= buttonColor.getCssValue("background-color");
        System.out.println(color);

        //  4.Find the height and width of this button

        WebElement size= driver.findElement(By.id("j_idt88:j_idt98"));
        int height= size.getSize().getHeight();
        int width= size.getSize().getWidth();
        System.out.println("button height is: "+height+" | button width is: "+width);
    }
}
