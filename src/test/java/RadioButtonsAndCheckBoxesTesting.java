import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test
    public void checkBoxTesting(){

        //get link

        driver.get("https://www.leafground.com/checkbox.xhtml");

        // select wanted checkboxes and verifying those checkboxes selected status

        List<WebElement> checkBoxList= driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element:checkBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=checkBoxList.size(); i++){
            boolean checkBoxStatus=driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" +i+ "]")).isSelected();
            System.out.println("check Box "+i+" selected status is: " +checkBoxStatus);
        }
    }
}
