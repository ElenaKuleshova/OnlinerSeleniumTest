package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver;

    @Parameters({"url", "chromedriverPath"})
    @BeforeSuite
   public void initializeWebDriver(String url, String chromedriverPath) throws IOException{
        //set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        //create driver object for Chrome browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(url);
    }

    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }





}
