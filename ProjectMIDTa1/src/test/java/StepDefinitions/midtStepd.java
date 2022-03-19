package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.buyPillow;
import Pages.homePage;
import Pages.paymentPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class midtStepd {
	WebDriver driver ;
 	homePage homePage ;
	buyPillow buypillow;	
	paymentPage paymentpage;
		
	
	@Before
	public void browserSetup()
	{
		//System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		//driver =new ChromeDriver();
		String pathFirefoxDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",pathFirefoxDriver);
		driver =new FirefoxDriver();
			
	}
@Given("User is on home page")
public void user_is_on_home_page() {
	homePage = new homePage(driver);
	homePage.navigateToHomePage();
}

@When("User buy pillow")
public void user_buy_pillow() {
	buypillow = new buyPillow(driver);
	buypillow.buyPillowPage();
	buypillow.enterCardDetails();     
}

@Then("Successful payment done")
public void successful_payment_done() throws IOException {

	paymentpage = new paymentPage(driver);
	paymentpage.paymentPAGE();
	}

@After
public void tearDown()
{
	paymentpage.closeDriver();
	
}
}
