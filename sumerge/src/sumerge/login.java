package sumerge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	
	private WebDriver driver;

    public login(WebDriver driver) {
        this.driver = driver;
    }
	
	public void enterUsername(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public void clicklogin(){
		driver.findElement(By.id("login-button")).click();
	}
}
