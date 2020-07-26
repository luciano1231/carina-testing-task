package com.solvd.luciano.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.luciano.carina.gui.pages.CpuInfoPage;
import com.solvd.luciano.carina.gui.pages.CpuPage;

public class CpuItem extends AbstractUIObject {

	@FindBy(xpath = "//a[@class='OneLinkNoTx']")
	private ExtendedWebElement titleLink;

	public CpuItem(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}
	
	public String readTitle() {
		return titleLink.getElement().getText();
	}
	
	public CpuInfoPage openCpuInfoPage() {
		titleLink.click();
		return new CpuInfoPage(driver);
	}
	
}
