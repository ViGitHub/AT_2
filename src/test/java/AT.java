import ZooSite.ExcelFileHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AT{
    WebDriver driver;
    ExcelFileHandler excelFileHandler;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src"+ File.separator+"main"+File.separator+"resources"+File.separator+"chromedriver");
        driver = new ChromeDriver();
        excelFileHandler = new ExcelFileHandler();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testRun(){
        List<List<String>> data = excelFileHandler.readFromFile("PageHeadings.xls");
        List<String> results = new ArrayList<String>();
        results.add("Results");
        for( int i = 1; i<data.size(); i++){
            for(int j = 0; j<data.get(i).size();j++){
                driver.navigate().to("http://www.thetestroom.com/webapp");
                driver.findElement(By.id(data.get(i).get(j).toLowerCase()+ "_link")).click();
                if(driver.getTitle().contains(data.get(i).get(++j))){
                    results.add("PASS");
                }else{
                    results.add("FAIL");
                }
                j++;
            }
        }
        excelFileHandler.writeToFile("PageHeadings.xls", results);
    }


}
