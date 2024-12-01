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
import PageObjects.CreatePatientPage;
import PageObjects.LoginPage;


public class CreatePatient_Test {
		
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
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
	}
	
	@Test(priority = 1)
	public void primaryInformation() throws InterruptedException
	{
		CreatePatientPage createPatient = new CreatePatientPage(driver);
		createPatient.clickOnTestButton();
		createPatient.name(prop.getProperty("name"));
		createPatient.emailId(prop.getProperty("emailId"));
		createPatient.mobileNo(prop.getProperty("mobileNo"));
		createPatient.clickOnGeneralDetailsButton();	
		
		createPatient.height(prop.getProperty("height"));
		createPatient.weight(prop.getProperty("height"));
		createPatient.gender(prop.getProperty("Female"));
		createPatient.age(prop.getProperty("age"));
		
		createPatient.systolic(prop.getProperty("systolic"));
		createPatient.diastolic(prop.getProperty("diastolic"));
		createPatient.clickOnAddTestButton();
		
		createPatient.addTestForPatient(prop.getProperty("testName"));
		createPatient.discount();
		createPatient.labSelection(prop.getProperty("labName"));
		createPatient.doctorSelection(prop.getProperty("doctorName"));
		createPatient.doctorCommission(prop.getProperty("doctorCommission"));
		
		createPatient.plusButton();
		createPatient.selectEquipmentName();
		createPatient.selectEquipmentQuantity(prop.getProperty("equipmentQuantity"));
		createPatient.saveEquipment();
		createPatient.clickOnAddPatientButton();
		
		Assert.assertEquals(createPatient.patientAddedSuccessfully(),"Patient added Successfully");
		}
}
