package com.Test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.readExcel.KeyWordEngine;

public class Login {

	@Test
	public void loginTest() throws InterruptedException {

		try {

			KeyWordEngine.testNG("Test Script");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
