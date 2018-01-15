package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.MailSender;
import utils.ZipFiler;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Context;

public class Common {
	
private Context context;
private MailSender mail;
	
	public Common (Context context) {
		this.context = context;
	
	}
	
	@Before
	public void InitializeTest() {
		  //driver.navigate().to("http://newtours.demoaut.com/");
		this.context.initializeDriver();
		this.context.getDriver().navigate().to("https://www.bookdepository.com/");
		this.context.getDriver().manage().window().maximize();
		
	}
	
	@After
	public void TearDownTest(Scenario scenario) {
		System.out.println("ID: "+ scenario.getId());
		System.out.println("Name : " + scenario.getName());
        System.out.println("Status : " + scenario.getStatus());
        scenario.write("--------------------------------------------------------------");
        scenario.write("ID: "+ scenario.getId());
        scenario.write("Name : " + scenario.getName());
        scenario.write("Status : " + scenario.getStatus());
        scenario.write("Price: " + this.context.getDriver().findElement(By.className("sale-price")).getText());
		final byte[] screenshot = ((TakesScreenshot) this.context.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
		scenario.write("--------------------------------------------------------------");
		this.context.getDriver().close();
		this.context.getDriver().quit();
		//Estas lineas se agregaron para que zipeen el reporte,estan dentro del paso de enviar el mail pero el mismo falla. 
		ZipFiler zipFile = new ZipFiler();
		zipFile.zipFile();
		//mail.sendMail();
	}
}
