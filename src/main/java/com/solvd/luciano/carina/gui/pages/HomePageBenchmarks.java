package com.solvd.luciano.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luciano.carina.gui.components.FooterMenuBenchmarks;
import com.solvd.luciano.carina.gui.components.compare.WeValuePrivacyAd;

public class HomePageBenchmarks extends AbstractPage {

	@FindBy(id = "footer")
	private FooterMenuBenchmarks footerMenu;

	public HomePageBenchmarks(WebDriver driver) {
		super(driver);
	}

	public FooterMenuBenchmarks getFooterMenu() {
		return footerMenu;
	}

	public WeValuePrivacyAd getWeValuePrivacyAd() {
		return new WeValuePrivacyAd(driver);
	}
}