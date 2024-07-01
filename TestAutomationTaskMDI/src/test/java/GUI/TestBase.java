package GUI;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LoginPage;
import Utility.ElementMethods;
import config.PropertiesFile;

public class TestBase {
	
	

	public static WebDriver driver;
	protected Properties prop;	
	
	public TestBase() throws IOException {
		prop=PropertiesFile.getProperties();
	}
	@BeforeMethod
	public void SetUpDriver() throws InterruptedException
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		
	
		
	}
	
	

}

