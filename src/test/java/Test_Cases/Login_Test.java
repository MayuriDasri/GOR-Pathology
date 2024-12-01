package Test_Cases;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Element_Utilities.ElementUtilities;
import PageObjects.LoginPage;

public class Login_Test {
		
	WebDriver driver = null;
	Properties prop;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		prop = new Properties();
		prop.load(new FileInputStream(new File("src\\test\\java\\Properties_File\\ProjectData.properties")));
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		ElementUtilities eleutil = new ElementUtilities();
		driver = eleutil.initdriver(browser, url);
		
		LoginPage homeLogin = new LoginPage(driver);
		driver = homeLogin.clickOnLoginButton();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
	}
	
	@Test(priority = 1)
	public void login()
	{
		LoginPage loginPageRef = new LoginPage(driver);
		
		loginPageRef.enterLoginEmailAddress(prop.getProperty("validEmailId"));
		loginPageRef.enterLoginPassword(prop.getProperty("validPassword"));
		driver = loginPageRef.clickOnLoginButton();
		String confirmMessage = loginPageRef.loggedInStatus();
		
		Assert.assertEquals( confirmMessage, "dashboard");
	}	
}
