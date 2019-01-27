package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.crmBase;


public class TestUtil extends crmBase {

	

	public static long page_load = 50;
	public static long implicit_wait = 50;
	public static String testDataPath = "E:\\Vimal\\WebDriver\\workspace\\FreeCRMTest"
			+ "\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/CRMscreenshots/" + System.currentTimeMillis() + "ss.png"));
	}

	
	
	/*public static String getScreenshot(WebDriver driver, String screenShotName) throws IOException {
		String dataName = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + dataName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static void addScreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed is : " + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed is : " + result.getThrowable());
			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is : " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed is : " + result.getName());
		}
		extent.endTest(extentTest);
	}*/

}
