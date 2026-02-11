package guru99.qa.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider
	public String[][] GetNewCustomerTestData_TC001() throws IOException {
		String[][] data=ReadDataFromExcel.getData("CustomerCreationData", "CreateNewCustomerDataTC001");
		return data;
	}
	
}
