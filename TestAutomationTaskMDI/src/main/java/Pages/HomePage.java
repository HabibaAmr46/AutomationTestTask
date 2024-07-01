package Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.ElementMethods;

public class HomePage {

	private WebDriver driver;
	private By Account_Lists = By.id("nav-link-accountList");
	private By All_Button = By.id("nav-hamburger-menu");
	private By Video_Games = By.cssSelector(".hmenu-item.hmenu-compressed-btn");
	private By All_Videos = By.xpath("//div[text()='Video Games']/parent::a");
	private By Video_Games_in = By.xpath("(//a[text()='All Video Games'])[1]");
	private By Shipping_Free=By.xpath("//span[text()='Free Shipping']/parent::a");
	private By New_Filter = By.xpath("//span[text()='New']/parent::a");
	private By Price_Select = By.id("a-autoid-0-announce");
	private By high_to_low_option = By.id("s-result-sort-select_2");
	private By searchResults = By.xpath("//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]");
	private By priceOfVideo = By.xpath(".//*[@class='a-price-whole']");
	private By addToCartButton = By.xpath(".//button[text()='Add to cart']");
	private By nextButton = By.xpath("//a[text()='Next']");
	
	private By language_link=By.xpath("//*[@id='icp-nav-flyout']");
	private By englishLink=By.xpath("//a[@href='#switch-lang=en_AE']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToLoginPage() throws InterruptedException {
		Thread.sleep(1000);
		ElementMethods.clickElement(driver, Account_Lists);
	}
	
	public HomePage changeLanguageToEnglish() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(language_link)).build().perform();
		ElementMethods.clickElement(driver, englishLink);
		
		return this;
	}

	public HomePage clickOnAll() throws InterruptedException {
		ElementMethods.clickElement(driver, All_Button);
		return this;
	}

	public HomePage clickOnAllVideoGames() throws InterruptedException {
		ElementMethods.clickElement(driver, Video_Games);
		ElementMethods.clickElement(driver, All_Videos);
		ElementMethods.clickElement(driver, Video_Games_in);
		return this;
	}

	public HomePage clickOnFreeShipping() throws InterruptedException
	{
		ElementMethods.clickElement(driver, Shipping_Free);
		return this;	
	}
	public HomePage clickOnNewFilter() throws InterruptedException {
		ElementMethods.clickElement(driver, New_Filter);
		return this;
	}

	public HomePage sortByPrice() throws InterruptedException {
		ElementMethods.clickElement(driver, Price_Select);
		ElementMethods.clickElement(driver, high_to_low_option);
		return this;

	}

	public int addVideoGamesToCart() throws InterruptedException {

		String price;
		//get all search results elements
		List<WebElement> results =null;
		
		int itemsWithPriceLessThan15 = 0;

		do {
			results= driver.findElements(searchResults);
			
			for (WebElement result : results) {

				if (ElementMethods.checkIfElementExistsInSpecialContext(result, priceOfVideo)) {
					price = ElementMethods.getText(driver, result.findElement(priceOfVideo));
					if (getPrice(price) < 15000.0
							&& ElementMethods.checkIfElementExistsInSpecialContext(result, addToCartButton)) {

						result.findElement(addToCartButton).click();
						itemsWithPriceLessThan15++;
						Thread.sleep(2000);
					}

				}
			}
			
			if(itemsWithPriceLessThan15==0) {
				ElementMethods.clickElement(driver, nextButton);
				Thread.sleep(2000);
			}
			
		} while (itemsWithPriceLessThan15 == 0);
		
		return itemsWithPriceLessThan15;
	}

	private Double getPrice(String text) {
		return Double.parseDouble(text.replaceAll("[^\\d.]", ""));
	}
}
