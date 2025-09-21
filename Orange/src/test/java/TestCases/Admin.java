package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BasePage;
import BaseClass.LoginPage;

public class Admin extends BasePage {
  @Test(priority =1)
  public void openAdmin() {
	  LoginPageHrm lp= new LoginPageHrm (driver);
	  lp.loginTest();
	  driver.findElement(By.xpath("//span[text()='Admin']")).click();
	 driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).sendKeys("John");
	 driver.findElement(By.xpath("//body[1]/div[1]/di07v[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
	  driver.findElement(By.xpath("//div[@class='oxd-select-text-input'][normalize-space()='Admin']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Name");
	  driver.findElement(By.xpath("//div[text()='Enabled'][@tabindex='0']")).click();
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  String pageTitle= driver.findElement(By.xpath("//h5[text()='System Users']")).getText();
	  Assert.assertEquals(pageTitle, "System Users");
  }
}
