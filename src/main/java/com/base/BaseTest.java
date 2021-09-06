package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;
import javax.sql.rowset.WebRowSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initbrowser(String browserName) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\RamRaksha\\Downloads\\chromedriver921\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

		return driver;

	}

	public String initProperty(String key) {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\RamRaksha\\eclipse-workspace\\bhavani\\src\\main\\java\\properties\\config.properties");
			try {
				prop.load(fis);
				prop.get(key);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return key;

	}

	public void login() throws IOException {

		File fl = new File(".//ExcelFile/Amazon.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Login");

		for (int i = 0; i < 1; i++) {

			for (int k = 0; k < sheet.getRow(i).getLastCellNum(); k++) {
				String username = sheet.getRow(i + 2).getCell(k).toString();
				String password = sheet.getRow(i + 2).getCell(k + 1).toString();

				// System.out.println(username);
				// System.out.println(password);
				driver.navigate().refresh();
				driver.findElement(
						By.xpath("//span[@id='nav-link-accountList-nav-line-1' and contains(text(),'Hello, Sign in')]"))
				.click();
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
				driver.findElement(By.id("continue")).click();
				driver.findElement(By.id("ap_password")).sendKeys(password);
				driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

			}
		}

	}

	public void searchMobile() throws IOException {

		File fl = new File(".//ExcelFile/Amazon.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Test Data");
		int k = 0;

		for (int i = 0; i < 1; i++) {

			String DeviceName = sheet.getRow(i + 2).getCell(k).toString();

			System.out.println(DeviceName);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(DeviceName);
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			driver.findElement(By.xpath(
					"//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'OnePlus 9R')]"))
			.click();

		}
	}

	public void selectExchange() throws IOException, InterruptedException {

		ArrayList<String> nextTab = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(nextTab.get(1));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[@class='a-text-bold' and contains(text(),'With Exchange')]")).click();

		WebElement exchnageButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[@id='chooseButton-announce' and contains(text(),'Choose phone to exchange')]")));
		Actions action = new Actions(driver);
		action.moveToElement(exchnageButton).click().build().perform();

	}

	public void selectBrandAndModel() throws IOException {

		String Brand = "brand";
		String Model = "Model";
		String IMEI = "IMEI";

		System.out.println("Guru Datta");
		File fl = new File(".//ExcelFile/Amazon.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Test Data");
		int k = 0;

		for (int i = 0; i < 1; i++) {

			Brand = sheet.getRow(i + 2).getCell(k + 1).toString();
			Model = sheet.getRow(i + 2).getCell(k + 2).toString();
			IMEI = sheet.getRow(i + 2).getCell(k + 3).toString();
		}

		WebElement selectBrand = driver.findElement(By.xpath("//select[@name='buyBackDropDown1']"));
		Select brselect = new Select(selectBrand);
		brselect.selectByVisibleText(Brand);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

		WebElement selectModel = driver.findElement(By.id(Brand));
		Select mdselect = new Select(selectModel);
		mdselect.selectByVisibleText(Model);
		Actions act1 = new Actions(driver);
		act1.sendKeys(Keys.ENTER).perform();

		WebElement exchnageSuccess = new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOfElementLocated((By.xpath("//span[@id='buyBackOfferAppliedSuccessText']"))));

		driver.findElement(By.xpath("//input[@type='number' and @placeholder='Enter IMEI number']")).sendKeys(IMEI);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[@id='buyBackApplyButton-announce' and contains(text(),'Verify')]")).click();

		driver.findElement(By.xpath("//span[@id='applyBuyBack-announce' and contains(text(),'Apply Exchange')]"))
		.click();

	}

	public void buy() {

		driver.findElement(By.xpath("//span[@id='buyBackBuyNowButton-announce' and contains(text(),'Buy Now with')]"))
		.click();
		String testText = driver
				.findElement(By.xpath("//span[@id='buyBackBuyNowButton-announce' and contains(text(),'Buy Now with')]"))
				.getText();
		System.out.println(testText);
		driver.quit();
	}

	public void selectHamburgerMenu() {
		driver.findElement(By.xpath("//span[@class='hm-icon-label' and contains(text(),'All')]")).click();
	}

	public void navigateToLoginAndSecurity() {

		driver.findElement(By.linkText("Your Account")).click();

		String url = driver.getCurrentUrl();
		System.out.println(url);

		driver.navigate().back();
		driver.navigate().forward();
		//

		driver.findElement(By.xpath(
				"//*[@class='a-spacing-none ya-card__heading--rich a-text-normal' and contains(text(),'Login & security')]"))
		.click();

	}

	public void logout() {
		System.out.println("logout code yet to write");
	}
}
