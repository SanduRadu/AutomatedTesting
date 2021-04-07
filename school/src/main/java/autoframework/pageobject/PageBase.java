package autoframework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageBase {

    WebDriver webDriver = null;

    public PageBase(WebDriver driver){
        this.webDriver = driver;
    }

    public void checkIfPageIsLoaded(By locator, String errorMessage){

        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, errorMessage);
        }
    }

}
