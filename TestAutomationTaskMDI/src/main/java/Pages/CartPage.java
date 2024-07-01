package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.ElementMethods;

public class CartPage {
	
	
	private WebDriver driver;
	private By cartButton=By.cssSelector("#nav-cart");
	private By productsInCart=By.cssSelector(".sc-list-item-content");
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CartPage goToCartPage() throws InterruptedException
	{
		ElementMethods.clickElement(driver, cartButton);
		return this;
		
	}
	
	public int getNumOfProductsInCart()
	{
		return driver.findElements(productsInCart).size();
	}

	
	

}
