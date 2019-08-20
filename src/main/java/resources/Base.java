package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Base {

	public static WebDriver driver;
	public Properties prop; 

	public WebDriver initializeDriver() throws IOException {
	     prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Shahid\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
		
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Shahid\\MerlinDotNet\\Chromedriver.exe");
            
			 driver=new ChromeDriver();
			 driver.get(prop.getProperty("url"));
		}
		else if (browserName.equals("firefox")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Shahid\\MerlinDotNet\\Gecko.exe");
			 driver=new FirefoxDriver();
			 driver.get(prop.getProperty("url"));
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Shahid\\MerlinDotNet\\InternetExplorer.exe");
			 driver = new InternetExplorerDriver();
			 driver.get(prop.getProperty("url"));
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	  //For screenshot code to work we need to include apache commons io dependencies in pom.xml file
	      public void getScreenshot(String result) throws IOException {
	    	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 FileUtils.copyFile(src, new File("C:Users//Shahid//E2EProject//"+result+"screenshot.png"));
	      }
	}





