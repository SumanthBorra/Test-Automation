package flipkart.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import flipkart.components.landingpage;
import flipkart.testcomponents.BaseTest;

public class landingPageTest extends BaseTest {

	@Test
	public  void signup() {
		landingpage.mousehoverOnSignin();
		System.out.println("working");
		
	}
}
