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
		// System.out.println("Bhavani");

		File file = new File(".//ExcelFile/Amazon.xlsx");

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Test Script");

	

		for (int i = 0; i < 1; i++) {

			for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {

				searchAndBuyMobile = sheet.getRow(i + 2).getCell(k + 1).toString();
				// System.out.println(searchAndBuyMobile);

				String searchMobile = sheet.getRow(i + 2).getCell(k + 2).toString();
				// System.out.println(searchMobile);

				// String keyword1 = sheet.getRow(i+1).getCell(k+1).toString();
				// System.out.println(keyword1);
				//
				//// if (!locatorColvalue.equalsIgnoreCase("NA")) {
				//// locatorName = locatorColvalue.split("=")[0].trim();
				//// String locatorValue = locatorColvalue.split("=")[1].trim();
				//// System.out.println(locatorName + " " + locatorValue);
				//// System.out.println(locatorName);
				//
				// String keyword2= sheet.getRow(i + 1).getCell(k + 2).getStringCellValue();
				// String keyword3 = sheet.getRow(i + 1).getCell(k + 3).toString();
				// String keyword4 = sheet.getRow(i + 1).getCell(k + 4).toString();
				// System.out.println(keyword1);
				//

				String buy = sheet.getRow(i + 2).getCell(k + 6).toString();
				String reLogin = sheet.getRow(i + 3).getCell(k).toString();
				String selectHamburgerMenu = sheet.getRow(i + 3).getCell(k + 1).toString();
				String logout=sheet.getRow(i+4).getCell(k).toString();
				//System.out.println(logout);

				
			switch (searchAndBuyMobile) {
				case "Y":

					base = new BaseTest();
					prop = base.initProperty("url");
					base.initbrowser("chome");
					break;
				//.login();
				// System.out.println("Login skipped");
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

//				switch (reLogin) {
//				case "Y":
//					base = new BaseTest();
//			prop = base.initProperty("url");
//			base.initbrowser("chome");
//
//					break;
//				case "selectHamburgerMenu":
//					base.selectHamburgerMenu();
//					break;
//				case "navigateToLoginAndSecurity":
//					base.navigateToLoginAndSecurity();
//
	//			default:
		//			break;
				}
				
				

			}

//			 switch (logout) {
//			 case "N":
//			base.login();
//			break;
//			 case "logout":
//				 base.logout();
// 
//			break;
//			
//			
		//}
	}
	}

// public static void main(String[] args) throws IOException {
// Bhavani bh = new Bhavani();
// Bhavani.testNG("Test Script");
// base=new BaseTest();
// base.initbrowser("chrome");
// }

// }
