package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ResultPage {
	
	private WebDriver driver;
	private By sortBy = By.name("searchSortBy");
	
	@FindBy(className="item-img")
	WebElement firstItem;
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void orderBy (String sortOrderBy) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select select = new Select (driver.findElements(sortBy).get(1));
		select.selectByValue(sortOrderBy);
		TimeUnit.SECONDS.sleep(2);
	}
	
	public void clickOnTheFirstElement() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		firstItem.click();
	}
	
	public void verifySearch(String sortOrderBy) {
		Select select = new Select (driver.findElements(sortBy).get(1));
		Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), sortOrderBy);
	}
}
