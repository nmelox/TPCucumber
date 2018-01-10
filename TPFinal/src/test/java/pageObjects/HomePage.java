package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	@FindBy(name="searchTerm")
	WebElement searchBar;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchWord (String word) {
		searchBar.sendKeys(word);
	}
	
	public void executeSearch () {
		searchBar.sendKeys(Keys.RETURN);
	}
}
