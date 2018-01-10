package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookPage {
	
	private WebDriver driver;
	
	public BookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyDescriptionBook () {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div[1]/div[2]/h2")).getAttribute("innerText").equals("Description"));
	}

}
