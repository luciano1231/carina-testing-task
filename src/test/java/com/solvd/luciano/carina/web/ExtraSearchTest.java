package com.solvd.luciano.carina.web;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExtraSearchTest {
	private WebDriver driver;
	

	
	@Test
	public void searchTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.ar");
		System.out.print("Serap done");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("java testing");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("java testing - Buscar con Google", driver.getTitle());	
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}
