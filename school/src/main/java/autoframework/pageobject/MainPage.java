package autoframework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class MainPage extends PageBase{

    public MainPage(WebDriver driver){
        super(driver);
    }

    protected By textLocator= By.xpath("//*[text()='Welcome to the-internet']");
    protected By selectPageLinkLocator = By.xpath("//a[text()='Dropdown']");
    protected By loginPageLinkLocator = By.xpath("//a[text()='Form Authentication']");

    public void checkIfPageIsLoaded(){
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(1==2,"Initial page was not loaded");
        }
    }

    public void goToSelectPage(){
        webDriver.findElement(selectPageLinkLocator).click();
    }

    public void goToLoginPage(){
        webDriver.findElement(loginPageLinkLocator).click();
    }


}
