package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserService {
    private static WebDriver driver;
    public static ReadProperties readProperties;
    protected static BrowserService browserService;

    public BrowserService(){
        ReadProperties readProperties = new ReadProperties();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( readProperties.getTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){ return driver;}


    public static void navigateByUrl(String url){
        driver.get(url);
    }


    public static void quitDriver(){
        driver.quit();
    }
}
