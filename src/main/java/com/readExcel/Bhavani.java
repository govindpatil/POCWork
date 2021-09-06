package com.readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class Bhavani {

	public static WebDriver driver;
	public static String prop;
	public static BaseTest base;
	static String searchAndBuyMobile;
	static String buy;
	static String logout;
	static String keyword4 = null;

	public static WebElement element;

	public static void testNG(String sheetName) throws IOException, InterruptedException {

		File file = new File(".//ExcelFile/Amazon.xlsx");

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Test Script");

		for (int i = 0; i < 1; i++) {

			for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {

				searchAndBuyMobile = sheet.getRow(i + 2).getCell(k + 1).toString();

				String searchMobile = sheet.getRow(i + 2).getCell(k + 2).toString();

				String buy = sheet.getRow(i + 2).getCell(k + 6).toString();
				String reLogin = sheet.getRow(i + 3).getCell(k).toString();
				String selectHamburgerMenu = sheet.getRow(i + 3).getCell(k + 1).toString();
				String logout = sheet.getRow(i + 4).getCell(k).toString();

				switch (searchAndBuyMobile) {
				case "Y":

					base = new BaseTest();
					prop = base.initProperty("url");
					base.initbrowser("chome");
					break;
					// .login();

					// break;

				case "searchMobile":

					base.searchMobile();
					break;

				case "selectExchange":
					base.selectExchange();
					break;

				case "selectBrandAndModel":
					base.selectBrandAndModel();
					break;

				case "buy":
					base.buy();
					break;
				default:
					break;
				}

			}

		}

	}
}
