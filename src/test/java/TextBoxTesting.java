import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void testingTextBoxes(){
        // 1.Type your name

        WebElement name= driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Chamod");

        // 2.Append country to this city

        WebElement append = driver.findElement(By.id("j_idt88:j_idt91"));
        append.sendKeys("India");

        // 3.Verify if text box is disable

        WebElement verify = driver.findElement(By.id("j_idt88:j_idt93"));
        boolean isDisable= verify.isEnabled();
        System.out.println(isDisable);

        // 4.Clear the typed text

        WebElement typedText= driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        typedText.clear();

        // 5.Retrieve the typed text

        WebElement typedTextPath = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt97\"]"));
        String retrieve= typedTextPath.getAttribute("value");
        System.out.println(retrieve);

        // 6.Type and email and press TAB key.Confirm control move to next element

        WebElement locateEmailBox = driver.findElement(By.id("j_idt88:j_idt99"));
        locateEmailBox.sendKeys("chamodganegoda@gmail.com"+ Keys.TAB +"Confirm control move to next element");

    }
}
