package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {
	public WebDriver driver;
	
	public LoginObjects(WebDriver driver) {
		this.driver=driver;
		
	}
	By email=By.xpath("//*[@id='user_email']");
	By password=By.xpath("//*[@id='user_password']");
	By button=By.xpath("//*[@value='Log In']");
	
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassowrd() {
		return driver.findElement(password);
	}
	public WebElement getButton() {
		return driver.findElement(button);
	}

}
