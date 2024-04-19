package Hooks;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;

public class Myhooks {
 
	@Before
	public void setup(Scenario scenario) {
		System.out.println("This begining Scenario"+scenario.getName());
	}
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("This Ending Scenario"+scenario.getName());
	}
}
