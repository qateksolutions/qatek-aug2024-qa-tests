package automation_test.org.mortgage_calculator.parameterized;

import Data.DataStore;
import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateRealAprRateParameterized extends BaseClass {

    @Test(dataProvider = "RealAprRates", dataProviderClass = DataStore.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedApr){
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
