package steps;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import utils.Context;

public class SearchBook {
	
	private HomePage home;
	private Context context;
	private WebDriver driver;
	
	public SearchBook (Context context) {
		this.context = context;
		driver = context.getDriver();
		home =  new HomePage(driver);
		
	}
	
	@Given("I enter a (.*)")
	public void i_enter_a (String book) {
		home.enterSearchWord(book);
	}
	
	@When("I press Search button")
	public void i_press_search_button() {
		home.executeSearch();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement
				(By.xpath("/html/body/div[3]/div[5]/div[2]/div[3]/div/div/div/div/div[1]/div[2]/h3")).
				getAttribute("innerText").equals("Sailor Moon Vol. 7"));
	}
}
