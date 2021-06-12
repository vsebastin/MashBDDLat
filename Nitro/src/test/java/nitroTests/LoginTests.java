package nitroTests;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import keywordsLibrary.UserAction;
import nitroPages.LoginPage;

public class LoginTests {
	
	LoginPage loginPage = new LoginPage();
	UserAction useraction = new UserAction(DriverFactory.getDriver());
	
	@Given("user in the login page")
	public void user_in_the_login_page() {
	   
		System.out.println("user logged in to the application - Login page");
	}

	@Given("user input valid credentials")
	public void user_input_valid_credentials() {
		
		System.out.println("user input the valid creadentials");
		useraction.input(loginPage.txt_login_username, "test");
		useraction.input(loginPage.txt_login_password, "test123");
		useraction.click(loginPage.btn_login);
	   
		
		
	}

	@Then("user sucessfully login into the application")
	public void user_sucessfully_login_into_the_application() {
		
		System.out.println("user successfully logged in and home page is displayed");
	   

	}
	
}
