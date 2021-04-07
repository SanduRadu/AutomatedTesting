import autoframework.pageobject.LoginPage;
import autoframework.pageobject.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;


public class TestDemo extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;


    @Test
    @Parameters
    public void Test() throws InterruptedException {

        mainPage = new MainPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        //wait for the page to load
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        /*try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Welcome to the-internet']")));
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(1==2,"Initial page was not loaded");
        }*/

        mainPage.goToSelectPage();
        //webDriver.findElement(By.xpath("//a[text()='Dropdown']")).click();

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dropdown List']")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Dropdown page was not loaded");
        }


        ////label/span[text()='Ordoneaza:']/../select

        Select select = new Select(webDriver.findElement(By.id("dropdown")));

        System.out.println("Selecting by visible text");
        select.selectByVisibleText("Option 1");

        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), "Option 1");

        System.out.println("Selecting by index");
        select.selectByIndex(2);

        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), "Option 2");

        System.out.println("Selecting by value");
        select.selectByValue("1");

        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), "Option 1");


        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10000);

        //go back to the main page
        webDriver.navigate().back();
        mainPage.checkIfPageIsLoaded();
        /*try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Welcome to the-internet']")));
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(1==2,"Initial page was not loaded");
        }*/

        mainPage.goToLoginPage();
        //webDriver.findElement(By.xpath("//a[text()='Form Authentication']")).click();

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Login Page']")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Login Page page was not loaded");
        }

        webDriver.findElement(By.id("username")).sendKeys("tomsmith");

        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        webDriver.findElement(By.xpath("//button")).click();

        //check login successfull
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Secure Area')]")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Secure Area page was not loaded");
        }

        ////a[contains(@class, 'button')]
        //check login error
        webDriver.findElement(By.xpath("//a[contains(@class, 'button')]")).click();


        webDriver.findElement(By.id("username")).sendKeys("tomsmith");

        webDriver.findElement(By.id("password")).sendKeys("tralala");

        webDriver.findElement(By.xpath("//button")).click();

        /*try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Secure Area')]")));
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(1==2,"Secure Area page was not loaded");
        }*/

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='flash error']")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Error is not present");
        }


    }

    @Test
    public void selectTest() throws InterruptedException {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);

        webDriver.get("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        //wait for the page to load
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        /*try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Welcome to the-internet']")));
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(1==2,"Initial page was not loaded");
        }*/

        mainPage.goToSelectPage();
        //webDriver.findElement(By.xpath("//a[text()='Dropdown']")).click();

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dropdown List']")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Dropdown page was not loaded");
        }

        ////label/span[text()='Ordoneaza:']/../select

        Select select = new Select(webDriver.findElement(By.id("dropdown")));

        System.out.println("Selecting by visible text");
        select.selectByVisibleText("Option 1");

        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), "Option 1");

        System.out.println("Selecting by index");
        select.selectByIndex(2);

        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), "Option 2");

        System.out.println("Selecting by value");
        select.selectByValue("1");

        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), "Option 1");

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Test
    @Parameters({"username","password"})
    public void loginSuccessfulTest(String username, String password) {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        //wait for the page to load
        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        mainPage.goToLoginPage();
        //webDriver.findElement(By.xpath("//a[text()='Form Authentication']")).click();

        loginPage.checkIfPageIsLoaded(By.xpath("//*[text()='Login Page']"), "Login Page page was not loaded");
       /* try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Login Page']")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Login Page page was not loaded");
        }*/

        webDriver.findElement(By.id("username")).sendKeys(username);

        webDriver.findElement(By.id("password")).sendKeys(password);

        webDriver.findElement(By.xpath("//button")).click();

        //check login successfull
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Secure Area')]")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(1 == 2, "Secure Area page was not loaded");
        }

    }

    @Test
    @Parameters({"username","password"})
    public void loginFailedTest(String username, String password) {

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        //wait for the page to load
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        mainPage.goToLoginPage();

        ////a[contains(@class, 'button')]
        //check login error
      // webDriver.findElement(By.xpath("//a[contains(@class, 'button')]")).click();


        webDriver.findElement(By.id("username")).sendKeys(username);

        webDriver.findElement(By.id("password")).sendKeys(password);

        webDriver.findElement(By.xpath("//button")).click();

        /*try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Secure Area')]")));
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(1==2,"Secure Area page was not loaded");
        }*/

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='flash error']")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(false, "Error is not present");
        }

    }

}
