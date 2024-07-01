package GUI;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;

public class E2ETEST extends TestBase{

	public E2ETEST() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testE2E() throws InterruptedException
	{
		
		new HomePage(driver).
			goToLoginPage();
		
		new LoginPage(driver).
			Login(prop.getProperty("Email"), prop.getProperty("Password"));
		
		
		//get number of products added to the list which is less than 15k
		int noOFProducts=new HomePage(driver).
								clickOnAll().
								clickOnAllVideoGames().
								clickOnFreeShipping().
								clickOnNewFilter().
								sortByPrice().
								addVideoGamesToCart();
			
		//get the number of products in the shopping carts
		int productsInCart=new CartPage(driver).
								goToCartPage().
								getNumOfProductsInCart();
		
		//Check if the products are added to the cart 
		Assert.assertEquals(noOFProducts, productsInCart);
		
		
		//Cannot automate the rest because of OTP
	}
	
	

}
