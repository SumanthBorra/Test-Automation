package flipkart.testcomponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

//import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import flipkart.components.landingpage;

public class BaseTest {

	WebDriver driver;
	landingpage Flandingpage ;
	
	public  WebDriver initialization() throws IOException {
		Properties prop = new Properties();
		FileInputStream FIS = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Globalproperties");
		prop.load(FIS);
		String BrowserName=prop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod
	public void precondition() throws IOException {
		driver = initialization();
		Flandingpage = new landingpage(driver);
		Flandingpage.gotoUrl();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
