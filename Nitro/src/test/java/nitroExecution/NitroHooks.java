package nitroExecution;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class NitroHooks {
	
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	
	@Before(order = 0)
	public void setPropertyFile(Scenario scenario) {
		System.out.println("set property executed for" + scenario.getName());
		configReader = new ConfigReader();
		prop = configReader.initPropertiesFile();
	}
	
	@Before(order=1)
	public void launchURL(Scenario scenario) {
		System.out.println("launch URL executed for" + scenario.getName());
		driverFactory = new DriverFactory();
		driver = driverFactory.setupDriver(prop.getProperty("browser"));
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@After(order=0)
	public void quitBrowser(Scenario scenario) {
		System.out.println("quit browser" + scenario.getName());
		driver.quit();
	}
	@After(order=1)
	public void teardown(Scenario scenario) {
		
		if (scenario.isFailed()) {
		System.out.println("teardown executed for" + scenario.getName());
		String screenshotName = scenario.getName().replace(" ", "_");
		//String sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "img/png", screenshotName);
		}
	}

}
