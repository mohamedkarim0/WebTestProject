package sumerge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	protected WebDriver driver;
	
	public void start() {
		String URL="https://www.saucedemo.com/";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public void shutdown() {
		if(driver !=null)
			driver.quit();
	}

}