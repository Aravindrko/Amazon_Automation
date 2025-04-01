package Group_Package.My_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_Selectable {
	
	Driver_Options options = new Driver_Options();

	public WebDriver Select_The_Driver(String Browser_Name) {
		if(Browser_Name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}else if(Browser_Name.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			String downdriver = WebDriverManager.firefoxdriver().getDownloadedDriverVersion();
			System.out.println("version that is downloaded is: "+downdriver);
			return new FirefoxDriver();
		}else if(Browser_Name.equalsIgnoreCase("safari")){
			WebDriverManager.safaridriver().setup();
			return new SafariDriver();
		}else {
			System.out.println("No such driver found");
			return null;
		}
	}
}
