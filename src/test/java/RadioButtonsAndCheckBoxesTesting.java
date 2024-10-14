import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsAndCheckBoxesTesting {

    WebDriver driver;

    @BeforeMethod
    public void openGoogle(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioButtonTesting(){

        //get link

        driver.get("https://www.leafground.com/radio.xhtml");

        //find the default select radio button

        boolean chrome= driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefox= driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safari= driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edge= driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chrome){
            String chromeText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is : "+ chromeText);
        } else if (firefox) {
            String firefoxText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is : "+ firefoxText);
        } else if (safari) {
            String safariText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is : "+ safariText);
        } else if (edge) {
            String edgeText= driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is : "+ edgeText);
        }

        //Select the age group (only if not selected)

        WebElement myAgeGroup=driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }



    }
}
