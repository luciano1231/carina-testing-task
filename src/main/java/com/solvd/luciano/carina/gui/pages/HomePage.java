package com.solvd.luciano.carina.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luciano.carina.gui.components.FooterMenu;
import com.solvd.luciano.carina.gui.components.compare.WeValuePrivacyAd;

public class HomePage extends AbstractPage {
    
    
    @FindBy(id = "footer")
    private FooterMenu footerMenu;

   
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

       
    public WeValuePrivacyAd getWeValuePrivacyAd() {
    	return new WeValuePrivacyAd(driver);
    }
}
