package Group_Package.My_Project;

import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_Options {
	
	public ChromeOptions Chrome_driver_options() {
		ChromeOptions options = new ChromeOptions();

        // Run Chrome in headless mode (without UI)
        //options.addArguments("--headless");
		
		// To Open Chrome in Incognito Mode
		options.addArguments("--incognito");

        // Disable GPU hardware acceleration
        options.addArguments("--disable-gpu");

        // Disable the "Save password" prompt
        options.addArguments("--disable-save-password-bubble");

        // Disable Chrome's automation info bar (useful for avoiding "Chrome is being controlled by automated test software" message)
        options.addArguments("--disable-infobars");

        // Set a custom user agent
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        // Disable notifications
        options.addArguments("--disable-notifications");

        // Set the default download directory
        options.addArguments("download.default_directory=/path/to/download");

        // Start Chrome with a specified window size
        options.addArguments("window-size=1920x1080");
        
        return options;
	}

}
