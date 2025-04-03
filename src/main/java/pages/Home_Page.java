package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement Signin;
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement SearchBox;
	
	@FindBy(xpath = "//*[@id=\"nav-cart\"]")
	WebElement cartbutton;
	
	@FindBy(xpath = "//*[@id=\"nav-search-dropdown-card\"]/div")
	WebElement Category_Selection_dropdown;
	
	@FindBy(xpath = "//*[@id=\"searchDropdownBox\"]/option")
	List <WebElement> Category_list_Elements;
	
	By Category_list_Elements_to_select = By.xpath("//*[@id=\"searchDropdownBox\"]/option");
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	
	public void to_Select_Category() {
		Category_Selection_dropdown.click();
	}
	
	public void select_category(String to_select) {
		for(int i = 0; i<Category_list_Elements.size(); i++) {
			String compare = wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(Category_list_Elements_to_select).get(i))).getText();
			if(to_select.equalsIgnoreCase(compare)) {
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(Category_list_Elements_to_select).get(i))).click();
			}
		}
		
	}

}
