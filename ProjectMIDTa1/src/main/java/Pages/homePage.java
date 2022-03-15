package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homePage {
	private String URL  = "https://demo.midtrans.com";
	
	private WebDriver homePagedriver;
	public homePage(WebDriver driver)
	{
		this.homePagedriver = driver;
	}
	public void navigateToHomePage()
	{

		homePagedriver =new ChromeDriver();
		
		homePagedriver.get(URL);
		homePagedriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		homePagedriver.manage().window().maximize();
		

	}

}