package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement Signin;
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement SearchBox;
	
	@FindBy(xpath = "//*[@id=\"nav-cart\"]")
	WebElement cartbutton;
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signin_click() {
		Signin.click();
	}
	
	public String get_signed_name() {
		return Signin.getText();
	}
	
	public void Data_entry_to_searchbox(String search_context) {
		SearchBox.sendKeys(search_context);
	}
	
	public void click_on_cart() {
		cartbutton.click();
	}

}
