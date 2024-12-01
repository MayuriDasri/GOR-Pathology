package PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreatePatientPage {
	
	private WebDriver driver;
	private WebElement testPage;
	private WebElement addPatientTest;
	Actions actions;
	JavascriptExecutor jse; 

	
	public CreatePatientPage(WebDriver driver)
	{
		this.driver = driver;
		LoginPage homeLogin = new LoginPage(driver);
		driver = homeLogin.clickOnLoginButton();
	}
	
	public void clickOnTestButton()
	{
		testPage = driver.findElement(By.xpath("//span[normalize-space()='Tests']"));
		testPage.click();
		addPatientTest = driver.findElement(By.xpath("//button[@type='submit']"));
		addPatientTest.click();
	}
	
	//Primary Information
	public void name(String nameText)
	{
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nameText");
	}
	public void emailId(String emailIdText)
	{
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailIdText);
	}
	public void mobileNo(String mobileNoText) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(mobileNoText);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight-100)");
		Thread.sleep(300);
	}
	public void clickOnGeneralDetailsButton()
	{
		actions.pause(200)
		.sendKeys(Keys.TAB) //mouse pointer move to password input box 
		.pause(200)
		.sendKeys(Keys.TAB) //12345 got entered into password field
		.pause(200)
		.sendKeys(Keys.ENTER)
		.build().perform();
	}

	//Secondary Information
	public void height(String heightText)
	{
		driver.findElement(By.xpath("//input[@name='height']")).sendKeys(heightText);
	}
	public void weight(String weightText)
	{
		driver.findElement(By.xpath("//input[@name='weight']")).sendKeys(weightText);
	}
	public void gender(String genderText)
	{
		actions.pause(200)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.sendKeys("Female")
		.sendKeys(Keys.ENTER)
		.build().perform();
	}
	public void age(String ageText)
	{
		driver.findElement(By.xpath("//input[@name='age']")).sendKeys(ageText);
	}
	public void systolic(String systolicText)
	{
		driver.findElement(By.xpath("//input[@name='systolic']")).sendKeys(systolicText);
	}
	public void diastolic(String diastolicText)
	{
		driver.findElement(By.xpath("//input[@name='diastolic']")).sendKeys(diastolicText);
	}
	public void clickOnAddTestButton() throws InterruptedException
	{
		actions.pause(200)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.sendKeys(Keys.ENTER)
		.build().perform();
		Thread.sleep(2000);
	}
	
	//Test Cost Calculator
	public void addTestForPatient(String testNameText)
	{
		actions.pause(200)
		.sendKeys(Keys.ENTER)
		.sendKeys(testNameText)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER).build().perform();
	}
	public void discount()
	{
		actions.sendKeys(Keys.TAB) //discount input
		.sendKeys(Keys.ENTER)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.pause(1000).build().perform();
	}
	public void labSelection(String labNameText)
	{
		actions.sendKeys(Keys.TAB)	//lab selection input
		.sendKeys(labNameText)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.pause(1000)
		.build().perform();
	}
	public void doctorSelection(String doctorNameText)
	{
		actions.sendKeys(Keys.TAB)	//doctor name input
		.sendKeys("doctorNameText")
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.pause(1000).build().perform();
		
	}
	public void doctorCommission(String doctorCommissionText) throws InterruptedException
	{
		actions.sendKeys(Keys.TAB)	//doctor Commision input
		.sendKeys(Keys.ENTER)
		.sendKeys(doctorCommissionText)
		.sendKeys(Keys.ENTER)
		.build().perform();
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight-100)");
		Thread.sleep(300); 
	}
	
	//add equipment
	public void plusButton()
	{
		actions.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.build().perform();
	}
	
	public void selectEquipmentName()
	{
		driver.findElement(By.xpath("//div[@aria-label='Eqipment Name']")).click();
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void selectEquipmentQuantity(String equipmentQualtityText)
	{
		driver.findElement(By.xpath("//input[@placeholder='Required']")).sendKeys(equipmentQualtityText);
		//equipmentQuantity.sendKeys(Keys.CONTROL + "a");
		//equipmentQuantity.sendKeys(Keys.DELETE);
		//equipmentQuantity.sendKeys("2");
	}
	
	public void saveEquipment()
	{
		driver.findElement(By.xpath("//span[contains(text(),'check')]")).click();
	}
	
	public WebDriver clickOnAddPatientButton() throws InterruptedException
	{
		for(int i=0;i<=10;i++)
			actions.sendKeys(Keys.TAB).build().perform();
		
		actions.sendKeys(Keys.ENTER).build().perform();
		 return driver;
	}
	public String patientAddedSuccessfully()
	{
		WebElement dashboard = driver.findElement(By.xpath("//li[@class='MuiBreadcrumbs-li']//p"));
		String dashboardName =dashboard.getText();
		return dashboardName;
	}		
	
	
	
	
}
