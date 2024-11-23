package automation_test.com.php_travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities_qatek.ScreenCapture;

public class PhpTravel {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://phptravels.com/demo");
    }

    @Test
    public void verifyHomepageTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Book Your Free Demo Now - Phptravels";
        Assert.assertEquals(actualTitle, expectedTitle);
        ScreenCapture.getScreenshot(driver);
    }

    @AfterMethod
    public void browserCleanup(){
        driver.quit();
    }

}
