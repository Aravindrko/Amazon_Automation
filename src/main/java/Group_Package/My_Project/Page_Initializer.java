package Group_Package.My_Project;

import org.openqa.selenium.WebDriver;

import pages.Home_Page;
import pages.Product_Page;
import pages.Signin_Page;
import pages.product_view;

public class Page_Initializer {
	public Home_Page home_page;
	public Signin_Page signin_page;
	public Product_Page page;
	public product_view productview;
	//public Object home_page;
	
	public Page_Initializer(WebDriver driver) {
		System.out.println("driver info from page_Initializer method.."+driver);
		home_page = new Home_Page(driver);
		signin_page = new Signin_Page(driver);// TODO Auto-generated constructor stub
		page = new Product_Page(driver);
		productview = new product_view(driver);
	}

}
