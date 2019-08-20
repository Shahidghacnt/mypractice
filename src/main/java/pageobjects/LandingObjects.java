package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingObjects {
	public WebDriver driver;
	public LandingObjects(WebDriver driver){
		
		this.driver=driver;
		
	}
	//By signin=By.xpath("//*[@href='http://qaclickacademy.usefedora.com/sign_in']");
   By signin=	By.xpath("//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a");
	//By signin=By.xpath("//*[contains(text(), 'sign_in')]");
	By title=By.xpath("//*[text()='Featured Courses']");
	By menuitem=By.xpath("//*[@href='contact.php']"); 
	public WebElement getsignIn() {
		return driver.findElement(signin);
	}

	public WebElement needTitle() {
		return driver.findElement(title);
	
	}
	public WebElement getmenuItem() {
		return driver.findElement(menuitem);
	
	}
	
}
