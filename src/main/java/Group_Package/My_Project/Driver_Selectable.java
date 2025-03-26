package Group_Package.My_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_Selectable {
	
	Driver_Options options = new Driver_Options();

	public WebDriver Select_The_Driver(String Browser_Name) {
		if(Browser_Name.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(options.Chrome_driver_options());
		}else if(Browser_Name.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		}else {
			return null;
		}
	}
}
