package com.santokart.splatoon.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartDriverClass {
	
	private static WebDriver driver;
	
	public static WebDriver generateDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		return driver;
	}
	
	public static void failedTest(String name) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\swage\\Pictures\\"+name+".png"));
	}
}
