package WaitHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waiter {
    public void wait(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement waitForPageUntilElementIsVisible(WebDriver driver, By locator, int maxSeconds){
        return (new WebDriverWait(driver, maxSeconds*1000)).until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}
