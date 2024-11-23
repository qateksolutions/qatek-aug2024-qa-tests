package automation_test.org.mortgage_calculator;

import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateRealAprRate extends BaseClass {

    @Test
    public void calculateRealApr(){
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageLoad()
                .typeHomePrice("200000")
                .clickDownPaymentInDollar()
                .typeDownPayment("15000")
                .typeInterestRate("3")
                .clickCalculateRateButton()
                .validateRealAprRate("3.130%");
    }
}
