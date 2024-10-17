package sumerge;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
	
	@BeforeMethod
	public void beforeMethod() {
		start();
	}
	
	
	@Test
	public void testFormIsVisiblle() {
		Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed(),"Username Field Not Displayed");
		Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(),"Username Field Not Displayed");
		Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(),"Login Button not displayed");
	}
	
	@Test
	public void testValidCredential() throws InterruptedException {
		login loginPage = new login(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clicklogin();
		
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Swag Labs']")).isDisplayed());	
	}
	
	
	@Test
	public void testWrongCredntials() {
		login loginPage = new login(driver);
		loginPage.enterUsername("mohamed");
		loginPage.enterPassword("m123");
		loginPage.clicklogin();
		
		String expectedMessage= "Epic sadface: Username and password do not match any user in this service" ;
		String acutalMessage = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
		Assert.assertEquals(acutalMessage,expectedMessage);
	}
	
	
	@Test
	public void testEmptyUsernameCredntials() {
		login loginPage = new login(driver);
		loginPage.enterUsername("");
		loginPage.enterPassword("secret_sauce");
		loginPage.clicklogin();
		
		String expectedMessage =  "Epic sadface: Username is required";
		String acutualMessage = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
		Assert.assertEquals(acutualMessage,expectedMessage);	
	}
	
	@Test
	public void testEmptyPasswordCredntials() {
		login loginPage = new login(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("");
		loginPage.clicklogin();
		
		String expectedMessage =  "Epic sadface: Password is required";
		String acutualMessage = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
		Assert.assertEquals(acutualMessage,expectedMessage);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		shutdown();
	}
}