package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    
    private static WebDriver driver;
    
    public static WebDriver getDriver() {
        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\khaleel safin shaik\\eclipse-workspace\\JenkinsNightlyRunTestProject\\src\\test\\resources\\drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
        	 WebDriverManager.chromedriver().setup();
             ChromeOptions options = new ChromeOptions();
             options.addArguments("--headless");
             options.addArguments("--disable-gpu");
             options.addArguments("--window-size=1920,1080");
             driver = new ChromeDriver(options);
        }
        return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}