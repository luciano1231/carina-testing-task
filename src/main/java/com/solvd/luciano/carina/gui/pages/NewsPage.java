package com.solvd.luciano.carina.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.luciano.carina.gui.components.NewsItem;

public class NewsPage extends AbstractPage{
	
	@FindBy(xpath="//input[@class='searchFor]")
	private ExtendedWebElement searchTextField;
	
	@FindBy(xpath="//input[@value='Search']")
	private ExtendedWebElement searchButton;

	@FindBy(xpath="//div[@class='news-item']")
	private List<NewsItem> news;
	
	public NewsPage(WebDriver driver) {
		super(driver);
		setPageURL("/news.php");
 	}
	
	public List<NewsItem> searchNews(String q){
		searchTextField.type(q);
		searchButton.click();
		pause(3);
		return news;
	}
}
