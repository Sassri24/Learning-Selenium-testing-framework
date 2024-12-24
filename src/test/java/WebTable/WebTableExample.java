package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void tableTesting() throws InterruptedException {

        //how many rows in the table

        int tableRowCount= driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("tableRowCount: "+tableRowCount);

        //how many columns in the table

        int tableColumnCount= driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("table column count: " + tableColumnCount);

        //retrieve the specific row/column data

        String specificData=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[4]/td[2]")).getText();
        System.out.println(specificData);

        //retrieve all the data from table

        for(int i=1; i<=tableRowCount; i++){
            for(int j=1; j<tableColumnCount; j++){
                String tableData=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tableData+ " ");
            }
            System.out.println();
        }

        //print ID and name only

        for(int i=1; i <=tableRowCount; i++){
            String idData=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String nameData=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.print(idData+" "+nameData);
            System.out.println();
        }

        //find the product price which name related to id=3

        for(int i=1; i <=tableRowCount; i++){
            String productId=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();

            if(productId.equals("3")){
                String selectedProductPrice= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(selectedProductPrice);
                break;
            }
        }

        //select all the checkboxes

        int pageCount=driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages= driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for(int i=0; i<pageCount; i++){
            pages.get(i).click();
            Thread.sleep(1000);

            for(int j=1; j<=tableRowCount; j++){
                WebElement checkBox=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input"));
                boolean checkBoxCondition= checkBox.isSelected();
                if(!checkBoxCondition){
                    checkBox.click();
                }
            }
        }

        //select one checkbox

        int tbRowNumber= 2;
        WebElement checkBox=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tbRowNumber+"]/td[4]/input"));
        checkBox.click();

    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    //comment
    //comment
    //comment
    //comment
    //comment
    //comment
    
}
