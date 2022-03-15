package Pages;

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
import java.io.File;

public class paymentPage {
	
	 WebDriver driver;
	public paymentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By otpXpath = By.xpath("//div[@class='form-group']//input");
	private String otp = "112233";
	private By buttonOKXpath = By.xpath("//button[@name='ok']");
	
	
	public void paymentPAGE() throws IOException {
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
	 			
	}
	public void closeDriver() {
		driver.quit();		
	}
	

}
