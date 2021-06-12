package keywordsLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAction {
	
	
private WebDriver driver;
	
	
	public UserAction(WebDriver driver ) {
		this.driver = driver;
		
	}
	
	public WebElement getElement(By locator) {
		
		
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
		
		
		WebElement webElement = driver.findElement(locator);  
		return webElement;
	}
	
	public void input(By locator, String userData) {
		WebElement webElement = getElement(locator);
		webElement.clear();
		webElement.sendKeys(userData);
		
	}
	public void click(By locator)
	{
		getElement(locator).click();
	}


}
