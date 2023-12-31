package com.ecommerce.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.utility.UtilTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public Properties p;
	ChromeOptions op;
	EdgeOptions ep;
	public static WebDriver driver;
	public Logger logger;
	public LoginPage lp;
	
	
	
	public Base() throws IOException{
		FileInputStream f = new FileInputStream("../JavaFramework/src/main/java/com/ecommerce/config/config.properties");
		p = new Properties();
		p.load(f);
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br) throws IOException {		
		initialize(br);
		lp = new LoginPage(driver);
	}

	public void initialize(String bw) {
//		String browser = p.getProperty("browser");
		
		
		if(bw.equals("chrome")) {
			
//			WebDriverManager.chromedriver().setup();
			
			System.setProperty("webdriver.chrome.driver","../JavaFramework/drivers/chromedriver.exe");
			op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);			
		}
		else {
			System.setProperty("webdriver.edge.driver", "../JavaFramework/drivers/msedgedriver.exe");
			ep = new EdgeOptions();
			ep.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(ep);
		}
		
		logger = Logger.getLogger("SeleniumJava");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilTest.implicit_wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilTest.pageLoadTime));
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));		
		
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	


}
