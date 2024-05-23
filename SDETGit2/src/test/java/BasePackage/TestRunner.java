package BasePackage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		features="src/test/resources/features/HW_Onboarding.feature",
		glue={"StepDefinition","Hooks"}, 
		plugin= {"pretty","html:target/CucumberReport.html",
				"junit:target/CucumberReport.xml",
				"json:target/CucumberReport.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	public static int CreateTable(String tablename, String field[]) {
		
		
		String query = "Create table "+tablename+"(";
		for(int i =0; i<field.length-1;i++) {
           query += ""+field[i]+" varchar(255),"; 
		}
		
		query += ""+field[field.length-1]+" varchar(255));";
		
		System.out.print(query);
		Connection con = DbConnection.createconnection();
		try {
			PreparedStatement statement = con.prepareStatement(query);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public static void main(String[] args) {
		try {
			 String arr[] = new String[2];
			    
			    arr[0] = "Username";
			    arr[1] = "Password";
			    arr[2]="Mail_Id";
			    int val = TestRunner.CreateTable("RegisterUser", arr);
			    
			    System.out.print(val);
			    
			    
			    System.out.println("table is created");
			    
		}
		catch (Exception e) { 
		    e.printStackTrace(); 
		}
			}

	}



