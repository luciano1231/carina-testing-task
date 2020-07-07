
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
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.luciano.carina.gui.components.CpuItem;
import com.solvd.luciano.carina.gui.components.FooterMenu;
import com.solvd.luciano.carina.gui.pages.CpuPage;
import com.solvd.luciano.carina.gui.pages.HomePage;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest extends AbstractTest {

	@Test(dataProvider = "SingleDataProvider")
	@TestPriority(Priority.P1)
	@TestTag(name = "area test", value = "data provider")
	@TestTag(name = "specialization", value = "xlsx")
	@XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "benchmarks", dsUid = "TUID", dsArgs = "Model, Socket, TDP, score3DMark")
	public void testModelSpecs(String Model, String Socket, String TDP, String score3DMark) {
		// Open benchmarks home page and verify page is opened
		HomePage homePage = new HomePage(getDriver());
		homePage.open();
		Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

		homePage.getWeValuePrivacyAd().closeAdIfPresent();

		//homePage = new HomePage(getDriver());
//        BrandModelsPage productsPage = homePage.selectBrand(brand);
//
//        ModelInfoPage productInfoPage = productsPage.selectModel(model);
//
//        Assert.assertEquals(productInfoPage.readDisplay(), display, "Invalid display info!");
//        Assert.assertEquals(productInfoPage.readCamera(), camera, "Invalid camera info!");
//        Assert.assertEquals(productInfoPage.readRam(), ram, "Invalid ram info!");
//        Assert.assertEquals(productInfoPage.readBattery(), battery, "Invalid battery info!");
	}

//    @Test(description = "JIRA#AUTO-0009")
//    @MethodOwner(owner = "qpsdemo")
//    @TestPriority(Priority.P1)
//    @TestTag(name = "area test", value = "web")
//    public void testCompareModels() {
//        // Open GSM Arena home page and verify page is opened
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
//        // Open model compare page
//        FooterMenu footerMenu = homePage.getFooterMenu();
//        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
//        CompareModelsPage comparePage = footerMenu.openComparePage();
//        // Compare 3 models
//        List<ModelSpecs> specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
//        // Verify model announced dates
//        Assert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2015, November");
//        Assert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2015, June");
//        Assert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
//    }

//    @Test    
//    public void testNewsSearch() {
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
//
//        CpuPage cpuPage = homePage.getFooterMenu().openCpuPage();
//        Assert.assertTrue(cpuPage.isPageOpened(), "News page is not opened!");
//
//        final String searchQ = "ryzen";
//        List<CpuItem> cpus = cpuPage.searchCpus(searchQ);
//        Assert.assertTrue(CollectionUtils.isEmpty(cpus), "Cpus not found!");
//        for(CpuItem c : cpus) {
//            System.out.println(c.readTitle());
//            Assert.assertTrue(StringUtils.containsIgnoreCase(c.readTitle(), searchQ), "Invalid search results!");
//        }
//    }

}
