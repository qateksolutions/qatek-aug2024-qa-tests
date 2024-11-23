package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumGrid_Chrome1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Chrome1.class);
    URL gridUrl;

    @Test
    public void executeInAwsDocker() {
        ChromeOptions chromeOptions = new ChromeOptions();

        try {
            gridUrl = new URL("http://44.204.83.0:4444/wd/hub");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new RemoteWebDriver(gridUrl, chromeOptions);
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        LOGGER.info(driver.getTitle());
        driver.quit();
    }
}
