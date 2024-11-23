package playground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities_qatek.CsvConnector;
import utilities_qatek.ReadConfigFiles;
import utilities_qatek.SqlConnector;

import java.sql.ResultSet;

public class TestNgMavenExampleTest {

    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenExampleTest.class);

    @Test
    public void runCsv() throws Exception {
        String[] lines;
        lines = CsvConnector.readCsvData("src/test/resources/test_data.csv");
        for(String line: lines){
            System.out.println("Each line: " + line);
            String[] dataArr = line.split(",");
            System.out.println("First name: " + dataArr[0]);
            System.out.println("Last name: " + dataArr[1]);
            System.out.println("Designation: " + dataArr[2]);
            System.out.println("Phone: " + dataArr[3]);
            System.out.println("Zip Code: " + dataArr[4]);
            System.out.println("State: " + dataArr[5]);

        }
    }



































    public void run(){
        try{
            String value = ReadConfigFiles.getPropertyValues("DbPassword");
            LOGGER.info("Property value is: " + value);
        } catch(Exception e){
            LOGGER.error(e.getMessage());
        }
    }


    public void run1() throws Exception {
        ResultSet resultSet = SqlConnector.readData("select * from monthly_mortgage");
        while(resultSet.next()){
            String homeValue = resultSet.getString("homevalue");
            String downPayment = resultSet.getString("downpayment");
            String loanAmount = resultSet.getString("loanamount");
            LOGGER.info("Home Value is: " + homeValue);
            LOGGER.info("Down Payment is: " + downPayment);
            LOGGER.info("Loan Amount is: " + loanAmount);
        }

    }


    //@Test(dataProvider = "MultipleColumnValues", dataProviderClass = DataStore.class)
    public void run2(String name, String state, int zip){
        System.out.println("Name is: " + name);
        System.out.println("State is: " + state);
        System.out.println("Zip is: " + zip);
    }



}
