package com.ecommerce.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.HeadersPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.PlaceOrderPage;
import com.ecommerce.pages.SearchPage;
import com.ecommerce.pages.UserPage;

public class TC_PlaceAnOrder_008 extends Base {
	
	UserPage up;
	HeadersPage hp; 
	SearchPage sp;
	CheckoutPage cp;
	PlaceOrderPage pop;
	
	public TC_PlaceAnOrder_008() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//To place an order for 02 records.
	@Test
	public void placeOrder() throws InterruptedException, IOException {
		up =lp.login(p.getProperty("username"), p.getProperty("password"));
		String productToSearch = "Mac";
		hp = new HeadersPage(driver);
		sp = hp.searchRecords(productToSearch);
		
		String[] dprod = {"MacBook","MacBook Air"};
		sp.addProductsToCart(dprod);	
		
		cp = hp.navigateToCheckout();
		pop = cp.confirmOrder();
		Assert.assertEquals(pop.confirmPlaceOrder(), "Your order has been placed!");		
		logger.info("placeOrder : 02 products are placed successfully");
		
	}
	
	
}
