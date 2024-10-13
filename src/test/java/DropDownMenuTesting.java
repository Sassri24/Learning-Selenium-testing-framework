import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownMenuTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void dropDownExample(){

        //  1.1. ways of select values in Basic dropdown
        //  1.2. get the number of dropdown options
        //  1.3. using sendKeys select dropdown value
        //  1.4. selecting value in a boostrap dropdown

        // 2. Google search -pick a value from suggestions
        // 3. Handle Hidden Auto Suggestions Drop down and search using DOM debugger trick
    }
}
