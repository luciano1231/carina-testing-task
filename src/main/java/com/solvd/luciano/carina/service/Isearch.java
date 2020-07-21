package com.solvd.luciano.carina.service;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.solvd.luciano.carina.gui.pages.CpuInfoPage;
import com.solvd.luciano.carina.gui.pages.CpuPage;
import com.solvd.luciano.carina.gui.pages.HomePageBenchmarks;

public interface Isearch {
	public default CpuInfoPage login(WebDriver driver) {
		HomePageBenchmarks homePage = new HomePageBenchmarks(driver);
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		homePage.getWeValuePrivacyAd().closeAdIfPresent();
		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
		Assert.assertTrue(cpuPage.isPageOpened(), "News page is not opened!");
		CpuInfoPage cpuInfoPage = cpuPage.openCpuInfoPage();
		return cpuInfoPage ;
	}

}
