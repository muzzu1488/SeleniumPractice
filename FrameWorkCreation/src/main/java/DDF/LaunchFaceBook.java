package DDF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LaunchFaceBook {

	WebDriver driver;

	@Test(dataProvider = "TestDataReader")
	public void LoginTest(String userName,String Password) {
		try {
			
			System.setProperty("webdriver.chrome.driver", "E:\\Chrome Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'email')]")));
			driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys(userName);
			driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys(Password);
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

	@DataProvider(name = "TestDataReader")
	public Object[][] passData() {

		ReadDataFromExcel RDE = new ReadDataFromExcel();

		RDE.Config("C:\\Users\\muzzu\\eclipse-workspace\\FrameWorkCreation\\TestDataSheet\\TestData.xlsx");
		int rowCount = RDE.rowCount(0);
		Object[][] Data = new Object[rowCount][2];

		for (int i = 1; i <= rowCount; i++) {

			Data[i][0] = RDE.GetTestData(0, i, 0);
			Data[i][1] = RDE.GetTestData(0, i, 1);
		}
		return Data;
	}

}
