package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BasePage;

public class Dependant extends BasePage {
  @Test(priority=1)
  public void addDependant() throws InterruptedException {
	  PersonalDetails pd= new PersonalDetails(driver);
	  pd.myInfo();
	  driver.findElement(By.xpath("//a[text()='Dependents']")).click();
	  driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text']/i")).click();
	  driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[@class='oxd-grid-item oxd-grid-item--gutters']/div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[1]")).sendKeys("John");
	 
	  driver.findElement(By.xpath("//input[@placeholder='yyyy-dd-mm']")).sendKeys("1998-09-10");
	  driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")).click();
	  // child option is not visible on DOM, select it manually while script is running...
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	  String title= driver.findElement(By.xpath("//span[text()='(1) Record Found']")).getText();
	  Assert.assertEquals(title,"(1) Record Found") ;}
  
  
@Test(priority=2, dependsOnMethods="addDependant")  
  public void deleteDepandant() {
	  driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
	  driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
	  Assert.assertTrue(true);
  }
}
