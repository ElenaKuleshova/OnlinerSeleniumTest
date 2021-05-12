package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver;


    @BeforeSuite
   public void initializeWebDriver() {
        ReadProperties readProperties = new ReadProperties();

        BrowserService browserService = new BrowserService();
        browserService.navigateByUrl(readProperties.properties.getProperty("url"));
        driver = BrowserService.getDriver();
    }

    @AfterSuite
   public static void tearDown(){
       BrowserService.quitDriver();
    }









}
