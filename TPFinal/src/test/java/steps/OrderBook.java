package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.BookPage;
import pageObjects.HomePage;
import pageObjects.ResultPage;
import steps.SearchBook;
import utils.Context;

public class OrderBook {
	
	private ResultPage resultPage;
	private HomePage homePage;
	private BookPage bookPage;
	private Context context;
	private WebDriver driver;
	private SearchBook searchBook;
	
	public OrderBook (Context context) {
		this.context = context;
		driver = context.getDriver();
		resultPage = new ResultPage(driver);
		bookPage = new BookPage(driver);
		homePage = new HomePage(driver);
	}
	
	@And("I sort result by (.*)")
	public void i_sort_result_by(String orderBy) {
		try {
			resultPage.orderBy(orderBy);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@And("I click on first element")
	public void i_click_on_first_element() {
		resultPage.clickOnTheFirstElement();
	}
	
	@Then("Book page must be shown")
	public void book_page_on_first_element() {
		bookPage.verifyDescriptionBook();
	}
}
