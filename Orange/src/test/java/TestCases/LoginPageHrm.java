package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BasePage;
import BaseClass.LoginPage;

public class LoginPageHrm extends BasePage{
	WebDriver driver;
	LoginPageHrm(WebDriver driver){
	this.driver= driver;
}
	@Test (priority=1)
	public void loginTest () {
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername("Admin");
		lp.enterPassword("admin123");
		lp.clickBtn();
		String title= driver.getTitle();
		System.out.println("Title of the page:"+ title);
		Assert.assertEquals(title, "OrangeHRM");
		}
	
	@Test (priority= 2)
	public void loginTest2() {
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername("Admin");
		lp.enterPassword("admin");
		lp.clickBtn();
		String title1= driver.getTitle();
		System.out.println("Title for invalid credentials: "+title1);
		Assert.assertEquals(title1,"OrangeHRM");
		}

}
