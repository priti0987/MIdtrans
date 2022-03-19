package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class buyPillow {
	 WebDriver driver;	 
	
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

	
	public buyPillow(WebDriver driver2) {
		this.driver = driver2;	}

	@SuppressWarnings("deprecation")
	public void buyPillowPage() {
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buyButtonXpath));
		
		driver.findElement(buyButtonXpath).click();
		driver.findElement(checkoutButtonXpath).click();
		
		 WebElement fswich = driver.findElement(By.tagName("iframe"));
	     driver.switchTo().frame(fswich);
	     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
			
	     driver.findElement(continueButton).click();
	     driver.switchTo().defaultContent();
	 	
	     WebElement fswich1 = driver.findElement(By.tagName("iframe"));
	     driver.switchTo().frame(fswich1);
	     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(creditCadrButtonXpath));
			
	     driver.findElement(creditCadrButtonXpath).click();
	     driver.switchTo().defaultContent();

	}

	public void enterCardDetails() {
		WebElement fswich2 = driver.findElement(By.tagName("iframe"));
	     driver.switchTo().frame(fswich2);
	     driver.findElement(cardNumberXpaath).sendKeys(cardNumber);
	     driver.findElement(expDateXpath).sendKeys(expDate);
	     driver.findElement(cvvXpath).sendKeys(cvv);
	     driver.findElement(payNowButtonXpath).click();
	     driver.switchTo().defaultContent();
	  	
		
	}

}
