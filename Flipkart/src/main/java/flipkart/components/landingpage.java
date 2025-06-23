package flipkart.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {

	
	static WebDriver driver;

	public landingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement signin = driver.findElement(By.id("nav-link-accountList"));
	@FindBy(id = "nav-link-accountList")
	static  
    WebElement signinElement;
	
	public static void gotoUrl() {
		driver.get("https://www.amazon.in/");
	}
	
	public static void mousehoverOnSignin() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinElement).perform();
	}
}
