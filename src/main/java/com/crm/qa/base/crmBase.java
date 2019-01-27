package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class crmBase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public crmBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\Vimal\\WebDriver\\workspace\\FreeCRMTest\\src"
					+ "\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialization() {
		// String browserName = prop.getProperty("browser");

		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Vimal\\WebDriver\\workspace\\FreeCRMTest\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Vimal\\WebDriver\\workspace\\FreeCRMTest\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
