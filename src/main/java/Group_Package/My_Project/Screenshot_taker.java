package Group_Package.My_Project;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot_taker {
	
	public static void capture_screenshot(WebDriver driver) {
		
		TakesScreenshot shot = (TakesScreenshot)driver;
		File shots_file = shot.getScreenshotAs(OutputType.FILE);
		File dest_file = new File(Screenshot_taker.filename_generator());
		try {
			FileUtils.copyFile(shots_file, dest_file);
		} catch (IOException e) {
			
			System.out.println("Unable to take screenshot due to: "+e.getMessage());
		}
		
	}
	
	public static String filename_generator() {
		Calendar cal = Calendar.getInstance();
		//int date = cal.DATE;
		int date = cal.get(Calendar.DATE);
		String s_date = Integer.toString(date);
		int month = cal.get(Calendar.MONTH);
		String s_month = Integer.toString(month);
		int year = cal.get(Calendar.YEAR);
		String s_year = Integer.toString(year);
		int time = cal.get(Calendar.HOUR_OF_DAY);
		String s_time = Integer.toString(time);
		int minute = cal.get(Calendar.MINUTE);
		String s_minute = Integer.toString(minute);
		return System.getProperty("user.dir")+"/"+"Screenshots_captured"+"/"+s_date+"_"+s_month+"_"+s_year+"_"+s_time+"_"+s_minute+".png";
	}

}
