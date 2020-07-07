package com.solvd.luciano.carina.gui.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luciano.carina.gui.components.CpuItem;

public class CpuPage extends AbstractPage {

	@FindBy(xpath = "//input[@id='search']")
	private ExtendedWebElement searchTextField;

	@FindBy(xpath = "//span[@class='icon-search_big search-icon']")
	private ExtendedWebElement searchButton;

	@FindBy(xpath = "//a[@class='OneLinkNoTx']")
	private List<CpuItem> cpus;

	public CpuPage(WebDriver driver) {
		super(driver);
		setPageURL("/compare/best-cpus");
	}

	public List<CpuItem> searchCpus(String s) {
		searchTextField.type(s);
		searchTextField.sendKeys(Keys.ENTER);

		pause(3);
		return cpus;
	}

}
