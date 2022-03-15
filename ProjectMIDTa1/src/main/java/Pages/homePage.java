package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class homePage {
	private String URL  = "https://demo.midtrans.com";
	private WebDriver homePagedriver;
	
	public homePage(WebDriver driver2) {
		this.homePagedriver = driver2;
	}
	
	@SuppressWarnings("deprecation")
	public void navigateToHomePage()
	{
		homePagedriver.get(URL);
		homePagedriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		homePagedriver.manage().window().maximize();
		return;

	}

}
