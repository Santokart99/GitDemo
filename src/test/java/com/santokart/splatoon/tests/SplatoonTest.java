package com.santokart.splatoon.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SplatoonTest {
	
	private WebDriver driver;
	
	@DataProvider(name="getData")
	public String[] getData() {
		
		String[] arreglo = {"Callie","Marie","DJ Octavio", "Cap'n Cuttlefish","Agent 4","Marina"};
		return arreglo;
	}
	
	@BeforeMethod
	public void before() {
		driver = StartDriverClass.generateDriver();
	}
	
  @Test(dataProvider="getData")
  public void test(String splatoonName) throws InterruptedException {
	  driver.get("http://splatoonwiki.org");
	  WebElement search = driver.findElement(By.name("search"));
	  search.sendKeys(splatoonName);
	  search.sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  driver.findElement(By.linkText(splatoonName)).click();
	  
	  String title = driver.findElement(By.id("firstHeading")).getText();
	  
	  Assert.assertEquals(title, splatoonName);
  }
  
  @AfterMethod
  public void after() {
	  driver.quit();
  }
}
