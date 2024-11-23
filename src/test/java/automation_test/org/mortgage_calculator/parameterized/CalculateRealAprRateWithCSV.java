package automation_test.org.mortgage_calculator.parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities_qatek.CsvConnector;
import utilities_qatek.ReadConfigFiles;

public class CalculateRealAprRateWithCSV {

    private static final Logger LOGGER = LogManager.getLogger(CalculateRealAprRateWithCSV.class);

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        LOGGER.info("---Test Name: Calculate Real APR with CSV---");
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void calculateRealApr() throws Exception {
        String[] lines;
        lines = CsvConnector.readCsvData("src/test/resources/mortgage_calculator.csv");
        for(String line: lines){
            String[] dataArr = line.split(",");
            String homePrice = dataArr[0];
            String downPayment = dataArr[1];
            String interestRate = dataArr[2];
            String expectedApr = dataArr[3];

            new NavigationBar(driver)
                    .mouseHoverToRates()
                    .navigateToRealApr()
                    .waitForPageLoad()
                    .typeHomePrice(homePrice)
                    .clickDownPaymentInDollar()
                    .typeDownPayment(downPayment)
                    .typeInterestRate(interestRate)
                    .clickCalculateRateButton()
                    .validateRealAprRate(expectedApr);
        }



    }

    @AfterMethod
    public void browserCleanup(){
        ActOn.browser(driver).closeBrowser();
    }
}
