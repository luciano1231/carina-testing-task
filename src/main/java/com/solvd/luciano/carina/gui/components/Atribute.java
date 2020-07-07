package com.solvd.luciano.carina.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Atribute extends AbstractUIObject {

	@FindBy(xpath = "./a")
	private ExtendedWebElement atribute;

	public Atribute(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public String readAtribute() {
		return atribute.getElement().getText();
	}

}
