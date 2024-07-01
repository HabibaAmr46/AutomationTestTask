package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.ElementMethods;

public class LoginPage {
	
	
	private WebDriver driver;
	private By email=By.id("ap_email_login");
	private By continueButton=By.id("continue");
	
	private By password=By.id("ap_password");
	private By signInButton=By.id("signInSubmit");
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Login(String emailText, String passwordText) throws InterruptedException
	{
		
		ElementMethods.type(driver, email,emailText);
		ElementMethods.clickElement(driver,continueButton);
		
		ElementMethods.type(driver, password,passwordText);
		ElementMethods.clickElement(driver, signInButton);
		
	}
	
	

}
