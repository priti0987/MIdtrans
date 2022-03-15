package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.buyPillow;
import Pages.homePage;
import Pages.paymentPage;
import io.cucumber.java.en.*;

public class midtStepd {
	
	
	
    
	WebDriver driver ;
 
	homePage homePage = new homePage(driver);
	
	private String URL  = "https://demo.midtrans.com";

    private By buyButtonXpath = By.xpath("//a[@class='btn buy']");
 	private By checkoutButtonXpath = By.xpath("//div[@class='cart-checkout']");
 	private By continueButton =By.xpath("//a[@class='button-main-content']");
 	private By creditCadrButtonXpath = By.xpath("//div[text()='Credit/Debit Card']");
 	private By cardNumberXpaath = By.xpath("//input[@name='cardnumber']");
 	private String cardNumber ="4811 1111 1111 1114";
 	private By expDateXpath = By.xpath("//input[@placeholder='MM / YY']");
 	private String expDate = "12/24";
 	private By cvvXpath = By.xpath("//input[@inputmode='numeric']");
 	private String cvv = "123";
 	private By payNowButtonXpath = By.xpath("//a[@class='button-main-content']");
 	private By otpXpath = By.xpath("//div[@class='form-group']//input");
	private String otp = "112233";
	private By buttonOKXpath = By.xpath("//button[@name='ok']");
	

		
	
@Given("User is on home page")
public void user_is_on_home_page() {
	System.out.println("userdir===="+System.getProperty("user.dir")+"\\geckodriver.exe");

	//System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
	
	//driver =new ChromeDriver();
	System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
	
	driver =new FirefoxDriver();
	
	driver.get(URL);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}

@When("User buy pillow")
public void user_buy_pillow() {
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	driver.findElement(buyButtonXpath).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(checkoutButtonXpath).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	 WebElement fswich = driver.findElement(By.tagName("iframe"));
     driver.switchTo().frame(fswich);
     driver.findElement(continueButton).click();
     driver.switchTo().defaultContent();
     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
 	
     WebElement fswich1 = driver.findElement(By.tagName("iframe"));
     driver.switchTo().frame(fswich1);
     driver.findElement(creditCadrButtonXpath).click();
     driver.switchTo().defaultContent();

		WebElement fswich2 = driver.findElement(By.tagName("iframe"));
	     driver.switchTo().frame(fswich2);
	     driver.findElement(cardNumberXpaath).sendKeys(cardNumber);
	     driver.findElement(expDateXpath).sendKeys(expDate);
	     driver.findElement(cvvXpath).sendKeys(cvv);
	     driver.findElement(payNowButtonXpath).click();
	     driver.switchTo().defaultContent();
	     driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
	  	
		
	
     
}

@Then("Successful payment done")
public void successful_payment_done() throws IOException {
	WebElement fswich3 = driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(fswich3);
    WebElement fswich4 = driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(fswich4);
    driver.findElement(otpXpath).sendKeys(otp);
    driver.findElement(buttonOKXpath).click();
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
 	String path = "target/ScreenShots/"+LocalDate.now()+".jpg";
    File filemids = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(filemids,new File(path));
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

	driver.quit();
}

}
