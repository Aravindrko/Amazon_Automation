package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin_Page {
	WebDriver driver;
	
	//@FindBy(xpath = "//*[@id=\"ap_email\"]") //*[@id="ap_email_login"]
	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	WebElement Email_Field;
	
	@FindBy(xpath = "//*[@id=\"ap_email_login\"]")
	WebElement Email_Field_2;
	
	@FindBy(xpath = "//*[@id=\"continue\"]/span/input")
	WebElement Signin_Button;
	
	@FindBy(xpath = "//*[@id=\"auth-error-message-box\"]/div/div")
	WebElement We_cannot_Find_an_account_with_email;
	
	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement Password_Field;
	
	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	WebElement Password_button;
	
	public Signin_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_email_address(String email) {
		Email_Field.sendKeys(email);
	}
	
	public void Enter_email_address_2(String email) {
		Email_Field_2.sendKeys(email);
	}
	
	public void Click_on_Signin() {
		Signin_Button.click();
	}
	
	public String Read_the_Error() {
		return We_cannot_Find_an_account_with_email.getText();
	}
	
	public String check_element_of_email() {
		return Email_Field.getAttribute("id");
	}
	
	public void enter_password(String password) {
		Password_Field.sendKeys(password);
	}
	
	public void clickon_password_signin() {
		Password_button.click();
	}
	
	

}
