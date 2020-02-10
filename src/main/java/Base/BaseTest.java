package Base;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    static WebDriver driver;
    private static ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<WebDriver>();

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().version("2.38").setup();
    }

    @BeforeMethod
   public void setup(){

        ChromeOptions options = new ChromeOptions();

        options.setBinary("C:\\Users\\varich\\AppData\\Local\\Programs\\duefocus\\DueFocus.exe");

//        options.setBinary("C:\\Users\\varich\\AppData\\Local\\Programs\\duefocusDev\\DueFocusDev.exe");

        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().build();

        driver = new ChromeDriver(chromeDriverService, options);
        WEBDRIVER_CONTAINER.set(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver(){
        return WEBDRIVER_CONTAINER.get();
    }


    @AfterMethod
    public void quit(){

        if (driver !=null){
            driver.manage().deleteAllCookies();
            driver.close();
            driver.quit();

           WEBDRIVER_CONTAINER.remove();
        }
    }


}



