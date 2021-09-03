package bhavani.test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.readExcel.Bhavani;


public class Login {
	

	//Bhavani bhavani = new Bhavani();

	@Test
	public void loginTest() throws InterruptedException {
	//	System.out.println("Hanuman, Bhavani, Krishna");

		try {
			
			Bhavani.testNG("Test Script");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
