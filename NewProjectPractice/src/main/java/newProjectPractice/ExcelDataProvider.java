package newProjectPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	private static WebDriver driver;

	@DataProvider(name = "Test1")
	public Object[][] GetData() {
		String excelPath = "C:\\Users\\muzzu\\eclipse-workspace\\NewProjectPractice\\TestDataSheet\\testData.xlsx";

		Object[][] Data = testData(excelPath, 0);
		return Data;
	}

	public Object[][] testData(String excelPath, int sheetIndex) {
		ReadTestData excel = new ReadTestData(excelPath);
		int rowCount = excel.rowCount(sheetIndex);
		int colCount = excel.ColCount(sheetIndex);

		Object Data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellData(0, i, j);
				System.out.println("CellData is " + cellData);
				Data[i - 1][j] = cellData;
			}
		}
		return Data;
	}

	@Test(dataProvider = "Test1")
	public void LoginTest(String userName, String password) {
		try {

			System.setProperty("webdriver.chrome.driver", "E:\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'email')]")));
			driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys(userName);
			driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys(password);
			driver.findElement(By.xpath("//button[contains(@id,'u_0_b')]")).click();
			Thread.sleep(4000);
			System.out.println("This is the title of page: " + driver.getTitle());
			Assert.assertTrue(driver.getTitle().equals("Facebook"), "The user name or Password is incorrect");			
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
