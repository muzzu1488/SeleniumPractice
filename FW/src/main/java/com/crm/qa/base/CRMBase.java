package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.utils.TestUtils;
import com.crm.qa.utils.WebEventListener;

public class CRMBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener event_listner;

	public CRMBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm" + "/qa/config/config.properties");
			prop.load(ip);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/FW/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		event_listner = new WebEventListener();
		e_driver.register(event_listner);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public static void explicitWaitElementPresent(WebElement Wait) {
		WebDriverWait wait = new WebDriverWait(driver, TestUtils.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(Wait));
	}

}
