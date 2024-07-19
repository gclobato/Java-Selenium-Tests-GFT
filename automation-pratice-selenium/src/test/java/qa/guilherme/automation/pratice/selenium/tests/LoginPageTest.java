package qa.guilherme.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import qa.guilherme.automation.pratice.selenium.pages.LoginPage;

class LoginPageTest {
	private LoginPage loginPage;
	private final String URL = "https://automationexercise.com";

	@BeforeEach
	void init() throws Exception {
		this.loginPage = new LoginPage();
		this.loginPage.visit(this.URL);
	}

	@AfterEach
	void exit() throws Exception {
		this.loginPage.quitWebDriver();
	}

	@Test
	void loginValid() {
		//when
		this.loginPage.signin();
		
		//then
		assertTrue(this.loginPage.getMyAccountMessage().equals("Guilherme C. Lobato"));
	    assertFalse(this.loginPage.getCurrentUrl().equals(this.URL));
	}
	
	@Test
	void loginInvalid() {
		//when
		this.loginPage.signinInvalidd();
		
		//then
		assertEquals("Your email or password is incorrect!", this.loginPage.getMyLoginInvalidMessage());
	}

}
