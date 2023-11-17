package com.ecommerce.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.MonitorPage;
import com.ecommerce.pages.UserPage;

public class TC_Monitor_004 extends Base {
	
	protected UserPage up;
	protected MonitorPage mp;

	public TC_Monitor_004() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Navigate to Monitor Page and verify if we are landed successfully
	@Test
	public void navigateToMonitorsPage() throws IOException {
		up = lp.login(p.getProperty("username"), p.getProperty("password"));	
		mp = up.navigateToMonitor();
		Assert.assertEquals(mp.checkMonitorPage(),"Monitors");
		logger.info("navigateToMonitorsPage : Monitor page is loaded successfully");
	}
	
	//Verify that correct product count is displayed on Monitors product Page.
	@Test
	public void checkMonitorsCount() throws IOException {
		up = lp.login(p.getProperty("username"), p.getProperty("password"));	
		mp = up.navigateToMonitor();
		Assert.assertEquals(mp.checkMonitorsProduct(),2);
		logger.info("checkMonitorsCount : Monitor products count is correct");
	}
	
}
