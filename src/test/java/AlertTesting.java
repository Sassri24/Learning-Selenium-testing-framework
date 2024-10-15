import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertExample(){

        //Alert (Simple Dialog)

        WebElement dialogBox=driver.findElement(By.id("j_idt88:j_idt91"));
        dialogBox.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //Alert (Confirm Dialog)- cancel alert massage

        WebElement cancelDialog=driver.findElement(By.id("j_idt88:j_idt93"));
        cancelDialog.click();
        Alert alert2= driver.switchTo().alert();
        alert2.dismiss();

        //Alert (Prompt Dialog)

        driver.findElement(By.id("j_idt88:j_idt104")).click();
        Alert alert3= driver.switchTo().alert();
        String dialogBoxText= alert3.getText();
        System.out.println(dialogBoxText);
        alert3.sendKeys("Chamod");
        alert3.accept();


    }
}
