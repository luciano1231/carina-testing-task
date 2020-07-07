package com.solvd.luciano.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class CpuInfoPage extends AbstractPage {
	@FindBy(xpath = "//span[@class='score-large']")
	private ExtendedWebElement score;

	@FindBy(xpath = "//span[@class='score-large OneLinkNoTx']")
	private ExtendedWebElement tdp;

	@FindBy(css = ".help-expansion strong")
	private ExtendedWebElement socket;

	public CpuInfoPage(WebDriver driver) {
		super(driver);
	}

	public String readScore() {
		assertElementPresent(score);
		return score.getText();
	}

	public String readTdp() {
		assertElementPresent(tdp);
		return tdp.getText();
	}

	public String readSocket() {
		assertElementPresent(socket);
		return socket.getText();
	}

}
