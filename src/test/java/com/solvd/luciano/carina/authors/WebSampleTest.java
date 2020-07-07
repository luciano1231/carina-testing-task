
package com.solvd.luciano.carina.authors;

import java.util.List;

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
import com.solvd.luciano.carina.gui.pages.HomePage;

public class WebSampleTest extends AbstractTest {

	@Test(dataProvider = "SingleDataProvider")
	@TestPriority(Priority.P1)
	@TestTag(name = "area test", value = "data provider")
	@TestTag(name = "specialization", value = "xlsx")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "benchmarks", dsUid = "TUID", dsArgs = "Model, Socket, TDP, score3DMark")
	public void testModelSpecs(String Model, String Socket, String TDP, String score3DMark) {
		// Open Cpus home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		homePage.getWeValuePrivacyAd().closeAdIfPresent();

		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
		Assert.assertTrue(cpuPage.isPageOpened(), "News page is not opened!");

		CpuInfoPage cpuInfoPage = cpuPage.openCpuInfoPage();

		Assert.assertEquals(cpuInfoPage.readSocket(), Socket, "Invalid Socket info!");
		Assert.assertEquals(cpuInfoPage.readTdp(), TDP, "Invalid TDP info!");
		Assert.assertEquals(cpuInfoPage.readScore(), score3DMark, "Invalid score3DMark info!");
	}

	@Test
	public void testNewsSearch() {
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

		CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
		Assert.assertTrue(cpuPage.isPageOpened(), "Cpus page is not opened!");

		final String searchQ = "ryzen";
		List<CpuItem> cpus = cpuPage.searchCpus(searchQ);
		Assert.assertTrue(CollectionUtils.isEmpty(cpus), "Cpus not found!");
		for (CpuItem c : cpus) {
			System.out.println(c.readTitle());
			Assert.assertTrue(StringUtils.containsIgnoreCase(c.readTitle(), searchQ), "Invalid search results!");
		}
	}

}
