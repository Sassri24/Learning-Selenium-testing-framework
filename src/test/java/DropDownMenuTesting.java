import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownMenuTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void dropDownExample() {

        //Open browser

        driver.get("https://www.leafground.com/select.xhtml");

        //  1.1. ways of select values in Basic dropdown

        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //  1.2. get the number of dropdown options

        List<WebElement> listOfOptions = select.getOptions();
        int size = listOfOptions.size();
        System.out.println("number of element in dropdown : " + size);

        for (WebElement element : listOfOptions) {
            System.out.println(element.getText());
        }

        //  1.3. using sendKeys select dropdown value

        dropdown.sendKeys("Puppeteer");

        //  1.4. selecting value in a boostrap dropdown

        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listOfDropDownValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listOfDropDownValues) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")) {
                element.click();
                break;
            }
        }
    }

        @Test
        public void googleSearchBar() throws InterruptedException {

        //Open browser

        driver.get("https://www.google.com/");

        // 2. Google search -pick a value from suggestions

        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(5000);
        List<WebElement> googleSearchList =driver.findElements(By.xpath("//ul[@jsname='bw4e9b']//li//div[@class='wM6W7d']"));
        System.out.println(googleSearchList.size());
        for (WebElement element:googleSearchList){
            System.out.println(element.getText());
        }


        }


        // 3. Handle Hidden Auto Suggestions Drop down and search using DOM debugger trick

}
