package automation_test.org.mortgage_calculator;

import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;

public class CalculateMortgageRate extends BaseClass {

    @Test
    public void calculateMonthlyPayment() throws Exception {
        String[] date = DateUtils.returnNextMonth();

        new Home(driver)
                .typeHomePrice("300000")
                .clickDownPaymentInDollar()
                .typeDownPayment("60000")
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectMonth(date[0])
                .typeYear(date[1])
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMonthlyHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefi("Buy")
                .clickCalculateButton()
                .validateTotalMonthlyPayment("1,611.85");
    }
}
