package flipkart.components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class landingpage {

	
	static WebDriver driver;

	//static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public landingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement signin = driver.findElement(By.id("nav-link-accountList"));
	@FindBy(id = "nav-link-accountList")
	static  WebElement signinElement;
	
	
	@FindBy(css = "span.nav-action-inner")
	static WebElement signInButton;
	
	@FindBy(xpath = "//h1[normalize-space(text())='Sign in or create account']")
	static WebElement signInOrCreateTitle;
	
	@FindBy(xpath = "//p[normalize-space(text())='Enter mobile number or email']")
	static WebElement emailOrMobileTitle;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailInputfield; 
	
	@FindBy(xpath ="//input[@type='submit']")
	static WebElement continueButton;
	
	@FindBy(xpath = "/h1[@class='a-spacing-small']")
	static WebElement signInTitle;
	
	@FindBy(xpath ="//span[@id='auth-email-claim']")
	static WebElement emailText;
	
	@FindBy(xpath = "//input[@type='password']")
	static WebElement passwordfield;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	static WebElement signInbuttonatpasswordpage;
	
	@FindBy (xpath = "//span[contains(text(), 'Hello')]")
	static WebElement signInTextafterlogin;
	
	@FindBy (xpath ="//a[@id='nav-hamburger-menu']")
	static WebElement LeftMenu;
	
	@FindBy (css = "#hmenu-customer-name b")
	static WebElement LeftMenuuserName;
	
	
	public void gotoUrl() {
		driver.get("https://www.amazon.in/");
	}
	
	public static void mousehoverOnSignin() {
		Actions actions = new Actions(driver);
		actions.moveToElement(signinElement).perform();
	}
	
	public void doSignIn() throws InterruptedException {
		Thread.sleep(3000);
		signInButton.click();
		boolean signInText = signInOrCreateTitle.isDisplayed();
		Assert.assertEquals(signInText, true);
		boolean emailOrMobileText = emailOrMobileTitle.isDisplayed();
		Assert.assertEquals(emailOrMobileText, true);
		Thread.sleep(2000);
		emailInputfield.sendKeys("sumanthborra299@gmail.com");
		continueButton.click();
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.visibilityOf(signInTitle));
		String emailoutput = emailText.getText();
		Assert.assertEquals("sumanthborra299@gmail.com", emailoutput);
		passwordfield.sendKeys("Sumanth@123");
		signInbuttonatpasswordpage.click();
		Thread.sleep(4000);
		String usernameText = signInTextafterlogin.getText();
		Assert.assertEquals(usernameText, "Hello, sumanth");
		LeftMenu.click();
		Thread.sleep(3000);
		String usernameLeft= LeftMenuuserName.getText();
		Assert.assertEquals(usernameLeft, "Hello, sumanth");
		
	}
}
