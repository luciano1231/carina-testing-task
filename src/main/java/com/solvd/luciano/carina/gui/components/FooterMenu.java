package com.solvd.luciano.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.luciano.carina.gui.pages.CpuPage;

public class FooterMenu extends AbstractUIObject {

	public FooterMenu(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);

	}

	@FindBy(linkText = "CPUs")
	private ExtendedWebElement cpusLink;
	@FindBy(linkText = "GPUs")
	private ExtendedWebElement gpusLink;
	@FindBy(linkText = "Smartphones")
	private ExtendedWebElement smartphonesLink;

	public CpuPage openCpuPage() {
		cpusLink.click();
		return new CpuPage(driver);
	}

	public CpuPage openGpuPage() {
		gpusLink.click();
		return new CpuPage(driver);
	}

	public CpuPage openSmartphonesPage() {
		smartphonesLink.click();
		return new CpuPage(driver);
	}

}
