package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private WebElement emailField;
	private WebElement passwordField;
	private WebElement loginButton;
	
	public void callingLoginPage(String emailText,String passwordText)
	{
		enterLoginEmailAddress(emailText);
		enterLoginPassword(passwordText);
		clickOnLoginButton();
	}
	
	public void enterLoginEmailAddress(String emailText)
	{	
		emailField = driver.findElement(By.xpath("//input[@name='email']"));
		emailField.sendKeys(emailText);
	}
	public void enterLoginPassword(String passwordText)
	{
		passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys(passwordText);
	}
	public WebDriver clickOnLoginButton()
	{
		loginButton = driver.findElement(By.xpath("//span[@class='MuiButton-label']"));
		loginButton.click();
		return driver;
	}
	public String loggedInStatus()
	{
		WebElement dashboard = driver.findElement(By.xpath("//li[@class='MuiBreadcrumbs-li']//p"));
		String dashboardName =dashboard.getText();
		return dashboardName;
	}		
}

