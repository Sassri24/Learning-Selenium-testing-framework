
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleTabsTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void tabsExample() {

        //click and confirm new windows opens

        String parentWindow = driver.getWindowHandle();
        System.out.println("this is parent window: " + parentWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();

        Set<String> setOfWindows = driver.getWindowHandles();
        System.out.println("count of windows : " + setOfWindows.size());

        for (String selectedWindow : setOfWindows) {
            System.out.println(selectedWindow);
            driver.switchTo().window(selectedWindow);
            System.out.println("Current page title is : " + driver.getTitle());
        }

        driver.close();

        driver.switchTo().window(parentWindow);

        WebElement openButton2 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openButtonVisibility = openButton2.isDisplayed();
        System.out.println("Open button visibility :" + openButtonVisibility);

        //finds the number of open tabs

        WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindow.click();

        Set<String> multiWindows = driver.getWindowHandles();
        System.out.println("window count: " + multiWindows.size());

        //close all windows except primary window

        WebElement doNotClosePrimary = driver.findElement(By.id("j_idt88:j_idt93"));
        doNotClosePrimary.click();

        Set<String> allOpenedWindows = driver.getWindowHandles();

        for (String selectedWindow : allOpenedWindows) {
            if (!(selectedWindow.equals(parentWindow))) {
                driver.switchTo().window(selectedWindow);
                driver.close();
            }
        }
        driver.quit();

        //driver.close(); --> close single browser window driver which on focus
        //driver.quit(); --> close all browser window
    }
}
