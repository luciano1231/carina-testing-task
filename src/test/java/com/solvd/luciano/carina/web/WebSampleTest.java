
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

	@Test(dataProvider = "SingleDataProvider")
	@TestPriority(Priority.P1)
	@TestTag(name = "area test", value = "data provider")
	@TestTag(name = "specialization", value = "xlsx")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "benchmarks", dsUid = "TUID", dsArgs = "Model, Socket, TDP, score3DMark")
	public void testModelSpecs(String Model, String Socket, String TDP, String score3DMark) {


		
		CpuInfoPage cpuInfoPage = login(getDriver());

		Assert.assertEquals(cpuInfoPage.readSocket(), Socket, "Invalid Socket info!");
		Assert.assertEquals(cpuInfoPage.readTdp(), TDP, "Invalid TDP info!");
		Assert.assertEquals(cpuInfoPage.readScore(), score3DMark, "Invalid score3DMark info!");
	}

//	@Test(dataProvider = "SingleDataProvider", description = "LUC")
//	@MethodOwner(owner = "Luciano")
//	@TestPriority(Priority.P2)
//	@TestTag(name = "area test", value = "data provider")
//	@TestTag(name = "specialization", value = "xlsx")
//	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "2ndTest", dsUid = "TUID", dsArgs = "search")
//	public void testNewsSearch(String search) throws Throwable {
//		HomePageBenchmarks homePage = new HomePageBenchmarks(getDriver());
//		homePage.open();
//		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
//
//		System.out.println("HOME OPENED");
//		
//		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
//		System.out.println("CPUS OPENED");
//		Assert.assertTrue(cpuPage.isPageOpened(), "Cpus page is not opened!");
//
//		
//		List<CpuItem> cpus = cpuPage.searchCpus(search);
//		Assert.assertTrue(CollectionUtils.isEmpty(cpus), "Cpus not found!");
//		for (CpuItem c : cpus) {
//			System.out.println(c.readTitle());
//			Assert.assertTrue(StringUtils.containsIgnoreCase(c.readTitle(), search), "Invalid search results!");
//		}
//	}

}
