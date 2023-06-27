package com.qafox.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	WebDriver driver;

	public static long Page_Load_TimeOut = 20;
	public static long Implicit_Wait = 10;

	static XSSFWorkbook wbook;
	static XSSFSheet sheet;

	static String path = "F:\\workspace\\qafox\\src\\main\\java\\com\\qafox\\testdata\\testdata.xlsx";

	// Read the Excel Data
	public static Object[][] readExcel(String sheetname) {

		try {
			wbook = new XSSFWorkbook(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = wbook.getSheet(sheetname);

		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		short lastcellNumber = sheet.getRow(0).getLastCellNum();
		System.out.println(lastcellNumber);

		String[][] data = new String[lastRow][lastcellNumber];

		for (int i = 1; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < lastcellNumber; j++) {
				XSSFCell cell = row.getCell(j);

				DataFormatter dff = new DataFormatter();

				String value = dff.formatCellValue(cell);
				data[i - 1][j] = value;

			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) {
		String dataName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destionation = System.getProperty(("user.dir") + "./screenshot/" + screenshotName + dataName + ".png");
		File finalDestination = new File(destionation);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destionation;
	}

}
