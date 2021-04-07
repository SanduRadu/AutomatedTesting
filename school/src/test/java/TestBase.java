import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver webDriver = null;

    @BeforeTest
    @Parameters({"browser"}) // numele din textNG.xml
    public void init(String browser){


        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
            webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeAll() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.quit();
    }
}
