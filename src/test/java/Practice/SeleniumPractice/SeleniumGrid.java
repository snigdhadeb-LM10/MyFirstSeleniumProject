package Practice.SeleniumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		
		
		
		ChromeOptions option=new ChromeOptions();
		option.merge(cap);
		String hub="http://192.168.137.1:4444/wd/hub";
		WebDriver driver=new RemoteWebDriver(new URL(hub),option);
		driver.get("https://selenium.dev/documentation/en/grid/setting_up_your_own_grid/");
		driver.quit();
	}
}
