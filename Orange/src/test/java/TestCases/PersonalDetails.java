package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BasePage;
import BaseClass.LoginPage;

public class PersonalDetails extends BasePage {
	WebDriver driver;
	
	PersonalDetails(WebDriver driver){
		this.driver=driver;
	}
  @Test(priority= 1)
  public void myInfo() {
	  LoginPageHrm hrm= new LoginPageHrm(driver);
	  hrm.loginTest();
	
	  WebElement info= driver.findElement(By.xpath("//span[normalize-space()='My Info']"));
	  info.click();
	  
	  String personalDetails= driver.findElement(By.xpath("//h6[text()='Personal Details']")).getText();
	  Assert.assertEquals(personalDetails,"Personal Details");
  }
  
  @Test(priority=2)
  void editInfo(){
	  WebElement name= driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	  name.click();
	  name.clear();
	  name.sendKeys("John");
	  if(name.isEnabled()) {
		  Assert.assertTrue(true);
		  
	  }
  }
  @Test(priority= 3)
  void contactInfo() //checking user is able to click contact detail page
  {
	  driver.findElement(By.xpath("//a[text()='Contact Details']")).click(); // click on Contact page
	  String pageDesc= driver.findElement(By.xpath("//h6[normalize-space()='Contact Details']")).getText();
	  Assert.assertEquals(pageDesc, "Contact Details");
  }
  
  @Test(priority= 4)
  void emergencyContact() {
	  driver.findElement(By.xpath("//a[text()='Emergency Contacts']")).click();
	  driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/div[@class='orangehrm-action-header']/button[1]")).click();
	  String title= driver.findElement(By.xpath("//h6[text()='Save Emergency Contact']")).getText();
	  Assert.assertEquals(title,"Save Emergency Contact");
	  }
}
