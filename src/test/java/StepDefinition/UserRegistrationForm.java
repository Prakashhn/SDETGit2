package StepDefinition;

import java.util.Map;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class UserRegistrationForm {
@When("user enter the all valid data to the respective fields")
	public void user_enter_the_all_valid_data_to_the_respective_field(DataTable dataTable) {
      Map<String, String> map = dataTable.asMap(String.class, String.class);
      System.out.println(map.get("FirstName"));
      System.out.println(map.get("LastName"));
      System.out.println(map.get("PhoneNumber"));
      System.out.println(map.get("Mail Id"));
}

 @And("user click on the continue button")
 public void user_click_on_the_continue_button() {
	 System.out.println("User clicked Continue button");
 }
 
 @Then("user should registered basic details successfully")
 public void user_should_login_successfully() {
	 System.out.println("User registered successfully basic details page");
 }
 
 
 
 
 
}