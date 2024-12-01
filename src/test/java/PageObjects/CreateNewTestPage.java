package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewTestPage {
	
	WebDriver driver;
	public CreateNewTestPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private WebElement testNameElement;
	private WebElement sampleTypeElement;
	private WebElement sampleVolumeElement;
	private WebElement sampleModeElement;
	private WebElement sampleAmountElement;
	
	
	public WebDriver manageTestButton()
	{
		driver.findElement(By.xpath("//div[@class='MuiContainer-root MuiContainer-maxWidthLg']//div//a//button[1]")).click();
		return driver;
	}
	
	public void testName(String testNameText)
	{
		testNameElement = driver.findElement(By.xpath("//input[@name='name']"));
		testNameElement.sendKeys(testNameText);
	}
	
	public void sampleType(String sampleTypeText)
	{
		sampleTypeElement = driver.findElement(By.xpath("//div[@id='mui-component-select-sample_type']"));
		sampleTypeElement.sendKeys(sampleTypeText);
	}
	
	public void sampleVolume(String sampleVolumeText)
	{
		sampleVolumeElement = driver.findElement(By.xpath("//div[@id='mui-component-select-sample_volume']"));
		sampleVolumeElement.sendKeys(sampleVolumeText);
	}

	public void sampleMode(String sampleModeText)
	{
		sampleModeElement = driver.findElement(By.xpath("//div[@id='mui-component-select-sample_mode']"));
		sampleModeElement.sendKeys(sampleModeText);
	}

	public void sampleAmount(String sampleAmountText)
	{
		sampleAmountElement = driver.findElement(By.xpath("//input[@name='amount']"));
		sampleAmountElement.sendKeys(sampleAmountText);
	}
	public void addTestButton()
	{
		driver.findElement(By.xpath("//div[@class='MuiBox-root jss269']//button[1]"));
	}
	public String confirmedMeesageofNewTestCreation()
	{
		WebElement dashboard = driver.findElement(By.xpath("//li[@class='MuiBreadcrumbs-li']//p"));
		String dashboardName =dashboard.getText();
		return dashboardName;
	}		
}


