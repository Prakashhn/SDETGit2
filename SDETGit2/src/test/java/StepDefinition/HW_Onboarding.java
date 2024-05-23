package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class HW_Onboarding {
	WebDriver driver;
	WebDriverWait wait;

	@Given("seller is on the Product description page of Hardware onboarding")
	public void seller_is_on_the_product_description_page_of_hardware_onboarding() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080");
		System.setProperty("WebDriver.chrome.driver","C:\\chromedriver_win32");
		  driver=new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.get("https://seller-devmssn.mobilitymarketplace.io/login");
		System.out.println(  driver.getTitle());
		  driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
		  driver.findElement(By.xpath("//span[@class='MuiButton-label jss4']")).click();
		  driver.findElement(By.id("social-skid-stage")).click();
		   wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("UserIdentifierInput_EmailInput_StringValue")).sendKeys("swathi@divum.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		WebElement ele=driver.findElement(By.tagName("button"));
		ele.click();
		driver.findElement(By.id("Password")).sendKeys("Test@12345");
		WebElement ele1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and @data-testid='enter-password.submit']")));
        ele1.click();

        // Navigate to the desired page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='a-icon arrow boschicon-bosch-ic-down']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='m-side-navigation__menuItem -sub-menu'][5]"))).click();

        // Wait for any potential overlay to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

        // Scroll to the element before clicking
        WebElement primaryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='a-button -without-icon a-button--primary']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", primaryButton);
        primaryButton.click();
    }
	   
	

	@When("seller enter the valid details")
	public void seller_enter_the_valid_details() {
	  driver.findElement(By.xpath("//input[@data-testid='productName']")).sendKeys("Automation");
	  WebElement elements=driver.findElement(By.xpath("//textarea[@attributeid='8cdabbe3-8e5b-4849-a703-67aabab792c1']"));
	  Actions actions= new Actions(driver);
	  actions.moveToElement(elements).perform();
      WebElement ele1=driver.findElement(By.xpath("//textarea[@attributeid='8cdabbe3-8e5b-4849-a703-67aabab792c1']"));
      ele1.click();
	  driver.findElement(By.xpath("//textarea[@attributeid='8cdabbe3-8e5b-4849-a703-67aabab792c1']")).sendKeys("short description");
	  driver.findElement(By.xpath("//div[@class='notranslate public-DraftEditor-content']")).sendKeys("Long description"); 
	  WebElement dropdown= driver.findElement(By.xpath("//button[@class='a-text-field__icon-search']"));
	  dropdown.click();
	  String[] optionsToSelect = {"Automation", "Automotive Aftermarket", "Code Evaluation/Quality"}; // Replace with actual option texts
	  wait=new WebDriverWait(driver, Duration.ofSeconds(12));
      for (String optionText : optionsToSelect) {
          // Wait for the options to be visible
          List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='multi-select__option']")));
          // Loop through the options to find and click the desired one
          for (WebElement option : options) {
              if (option.getText().equals(optionText))
                 {
                  option.click();
                  break;
                  }
                  }
          // If the drop down closes after selecting an option, reopen it
          dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='a-text-field__icon-search']")));
          dropdown.click();
      }
     WebElement elements1= driver.findElement(By.xpath("//button[@class='a-button -without-icon a-button--secondary']"));
//     elements1.click();
    
     
     elements1.sendKeys("C:Downloads\\application.pdf");
	}

	@When("seller click on the Submit button")
	public void seller_click_on_the_submit_button() {
	    System.out.println("test");
	}

	@Then("seller should get the product in the hardware product list")
	public void seller_should_get_the_product_in_the_hardware_product_list() {
		 System.out.println("test");
	}

	@Then("status of product is Submit is displayed.")
	public void status_of_product_is_submit_is_displayed() {
		 System.out.println("test");
	}	
}
