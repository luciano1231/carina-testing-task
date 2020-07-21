package com.solvd.luciano.carina.authors;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.luciano.carina.gui.pages.CpuPage;
import com.solvd.luciano.carina.gui.pages.HomePageBenchmarks;

public class AnotherTest extends AbstractTest {

	
	@Test
	public void test() {
		
		HomePageBenchmarks homePage = new HomePageBenchmarks(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");		
		
		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
		Assert.assertTrue(cpuPage.isPageOpened(), "CPU Page is not opened");

		
		

	}

}
