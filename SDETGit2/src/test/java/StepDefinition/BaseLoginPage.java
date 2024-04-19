package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class BaseLoginPage {
 public static WebDriver driver;

 
	@Given("user is in the login page")
	public void user_is_in_the_login_page() throws InterruptedException {
	  
	   System.setProperty("WebDriver.chrome.driver","C:\\chromedriver_win32");
	  driver=new ChromeDriver();
	  driver.get("https://seller-devmssn.mobilitymarketplace.io/login");
	  driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
	  driver.findElement(By.xpath("//span[@class='MuiButton-label jss4']")).click();
	  driver.findElement(By.id("social-skid-stage")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user enter the valid username (.+)$")
	public void user_enter_the_valid_username(String username) throws InterruptedException {
		driver.findElement(By.id("UserIdentifierInput_EmailInput_StringValue")).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}

	@When("click on Continue button")
	public void click_on_continue_button() {
		WebElement ele=driver.findElement(By.tagName("button"));
		ele.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("enter the valid password (.+)$")
	public void enter_the_valid_password(String password) {
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@When("click on Continueo button")
	public void click_on_continueo_button() {
		WebElement ele1= driver.findElement(By.xpath("//button[@type='submit' and @data-testid='enter-password.submit']"));
		ele1.click();
		
	}
	@Then("user should lands on the Dashboard page")
	public void user_should_lands_on_the_dashboard_page() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='a-icon boschicon-bosch-ic-my-brand-frame -size-l']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='a-button -without-icon a-button--primary user-account-signout-button -size-m']")).click();
		driver.close();
		}
		
		 
	
}
