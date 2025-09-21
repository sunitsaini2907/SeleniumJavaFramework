package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
 WebDriver driver;
 public LoginPage(WebDriver driver){
	this.driver=driver;
	
}

By username= By.xpath("//input[@placeholder='Username']");
By password= By.xpath("//input[@placeholder='Password']");
By loginButton = By.xpath("//button[@type='submit']");

public void enterUsername(String user) {
	driver.findElement(username).sendKeys(user);
	
	
}

public void enterPassword( String pass)
{
	driver.findElement(password).sendKeys(pass);
	
}
public void clickBtn() {
	driver.findElement(loginButton).click();
}

}
