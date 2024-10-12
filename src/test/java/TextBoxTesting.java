import org.openqa.selenium.WebDriver;
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
        // 2.Append country to this city
        // 3.Verify if text box is disable
        // 4.Clear the typed text
        // 5.Retrieve the typed text
        // 6.Type and email and press TAB key.Confirm control move to next element

    }
}
