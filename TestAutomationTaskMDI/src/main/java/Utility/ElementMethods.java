package Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethods {
	
	private static WebDriverWait wait;
	
	
	public static void clickElement(WebDriver driver, By elementLocator) throws InterruptedException
	{
		
		try {
		commonWait(driver,elementLocator);
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
		driver.findElement(elementLocator).click();
		}catch(ElementClickInterceptedException e)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(elementLocator));
		}
	}
	
	public static void type(WebDriver driver, By elementLocator, String text)
	{
		commonWait(driver, elementLocator);
		driver.findElement(elementLocator).sendKeys(text);	
	}
	
	public static String getText(WebDriver driver, WebElement element)
	{
		wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
	
		return element.getText();
	
	}
	
	public static boolean checkIfElementExistsInSpecialContext(WebElement context,By elementLocator)
	{
		
		return context.findElements(elementLocator).size()>0;
	}
	
	private static void commonWait(WebDriver driver, By elementLocator)
	{
		wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementLocator));
		
	}

}
