package automation_test.org.mortgage_calculator.parameterized;

import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;
import utilities_qatek.SqlConnector;
import java.sql.ResultSet;

public class CalculateMortgageRateParameterized extends BaseClass {
    @Test
    public void calculateMonthlyPayment() throws Exception {
        String[] date = DateUtils.returnNextMonth();

        ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
        while(rs.next()) {
            new Home(driver)
                    .typeHomePrice(rs.getString("homevalue"))
                    .clickDownPaymentInDollar()
                    .typeDownPayment(rs.getString("downpayment"))
                    .typeLoanAmount(rs.getString("loanamount"))
                    .typeInterestRate(rs.getString("interestrate"))
                    .typeLoanTermYears(rs.getString("loanterm"))
                    .selectMonth(date[0])
                    .typeYear(date[1])
                    .typePropertyTax(rs.getString("propertytax"))
                    .typePmi(rs.getString("pmi"))
                    .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                    .typeMonthlyHoa(rs.getString("monthlyhoa"))
                    .selectLoanType(rs.getString("loantype"))
                    .selectBuyOrRefi(rs.getString("buyorrefi"))
                    .clickCalculateButton()
                    .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
        }
    }
}
