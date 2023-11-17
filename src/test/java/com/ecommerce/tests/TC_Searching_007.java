package com.ecommerce.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HeadersPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.SearchPage;
import com.ecommerce.pages.UserPage;

public class TC_Searching_007 extends Base {

	UserPage up;
	HeadersPage hp;
	SearchPage sp;
	
	public TC_Searching_007() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Test to check if correct products are displayed on searching a product
	@Test
	public void validateSearchedProductsName() throws IOException {
		//Passed static value to search  a product. We can pass via dataloader sheet as well.
		up = lp.login(p.getProperty("username"), p.getProperty("password"));
		String productToSearch = "Mac";
		hp = new HeadersPage(driver);
		sp = hp.searchRecords(productToSearch);
		boolean bl = sp.checkSearchProductsName(productToSearch);
		Assert.assertEquals(bl, true);
		logger.info("validateSearchedProductsName : search functionality is working fine.");
	}
	
	

}
