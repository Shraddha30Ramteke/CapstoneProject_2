package BasePackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    public static WebDriver driver;
   
    
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
  
   
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
