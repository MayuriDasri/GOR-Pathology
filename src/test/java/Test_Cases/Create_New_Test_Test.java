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
import PageObjects.CreateNewTestPage;
import PageObjects.LoginPage;

public class Create_New_Test_Test {
		
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
		homeLogin.callingLoginPage(prop.getProperty("validEmailId"),prop.getProperty("validPassword"));
		driver = homeLogin.clickOnLoginButton();
		
		CreateNewTestPage CreateNewTestref = new CreateNewTestPage(driver);
		driver = CreateNewTestref.manageTestButton();
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
	}
	
	@Test(priority = 1)
	public void createNewTest()
	{
		CreateNewTestPage createNewTestRef = new CreateNewTestPage(driver);
		createNewTestRef.testName(prop.getProperty("newTestName"));
		createNewTestRef.sampleType(prop.getProperty("sampleType"));
		createNewTestRef.sampleVolume(prop.getProperty("sampleVolume"));
		createNewTestRef.sampleMode(prop.getProperty("sampleMode"));
		createNewTestRef.sampleAmount(prop.getProperty("sampleAmount"));
		
		String confirmMessage = createNewTestRef.confirmedMeesageofNewTestCreation();
		
		Assert.assertEquals( confirmMessage, "dashboard");
		}
	
}
