
package com.solvd.luciano.carina.web;

import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;

import com.solvd.luciano.carina.gui.components.CpuItem;

import com.solvd.luciano.carina.gui.pages.CpuInfoPage;
import com.solvd.luciano.carina.gui.pages.CpuPage;
import com.solvd.luciano.carina.gui.pages.HomePageBenchmarks;
import com.solvd.luciano.carina.service.Isearch;

public class WebSampleTest extends AbstractTest implements Isearch {

//	@Test	
//	public void testModelSpecs() {
//		//Just a simple test with service
//		CpuInfoPage cpuInfoPage = login(getDriver());		
//	}
//	

//	@Test(dataProvider = "SingleDataProvider", description = "LUC")
//	@MethodOwner(owner = "Luciano")
//	@TestPriority(Priority.P1)
//	@TestTag(name = "area test", value = "data provider")
//	@TestTag(name = "specialization", value = "xlsx")
//	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "2ndTest", dsUid = "TUID", dsArgs = "search")
//	public void testNewsSearch(String search) throws Throwable {
//		HomePageBenchmarks homePage = new HomePageBenchmarks(getDriver());
//		homePage.open();
//		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
//		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
//
//		Assert.assertTrue(cpuPage.isPageOpened(), "Cpus page is not opened!");
//
//		List<CpuItem> cpus = cpuPage.searchCpus(search);//
//		Assert.assertTrue(CollectionUtils.isNotEmpty(cpus), "Cpus not found!");
//		for (CpuItem c : cpus) {			
//			Assert.assertTrue(StringUtils.containsIgnoreCase(c.readTitle(), search), "Invalid search results!");
//		}
//	}

	@Test(dataProvider = "SingleDataProvider", description = "LUC")
	@MethodOwner(owner = "Luciano")
	@TestPriority(Priority.P3)
	@TestTag(name = "area test", value = "data provider")
	@TestTag(name = "specialization", value = "xlsx")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "benchmarks", dsUid = "TUID", dsArgs = "search, socket, score")
	public void testCompare(String search,String score, String socket) throws Throwable {
		HomePageBenchmarks homePage = new HomePageBenchmarks(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
		Assert.assertTrue(cpuPage.isPageOpened(), "Cpus page is not opened!");

		List<CpuItem> cpus = cpuPage.searchCpus(search);
		Assert.assertTrue(CollectionUtils.isNotEmpty(cpus), "Cpus not found!");
		CpuInfoPage cpuInfo = cpus.get(0).openCpuInfoPage();
		
		Assert.assertEquals(cpuInfo.readScore(), socket, "Invalid Socket info! or has changed");
		Assert.assertEquals(cpuInfo.readSocket(), score, "Invalid Score info! or has changed");
	}

}
