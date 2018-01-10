package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Context;

public class Common {
	
private Context context;
	
	public Common (Context context) {
		this.context = context;
	
	}
	
	@Before
	public void InitializeTest() {
		  //driver.navigate().to("http://newtours.demoaut.com/");
		this.context.initializeDriver();
		this.context.getDriver().navigate().to("https://www.bookdepository.com/");
		//this.context.getDriver().manage().window().maximize();
		
	}
	
	@After
	public void TearDownTest(Scenario scenario) {
		this.context.getDriver().close();
		this.context.getDriver().quit();
	}
}
