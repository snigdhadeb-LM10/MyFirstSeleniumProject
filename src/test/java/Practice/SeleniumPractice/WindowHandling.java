package Practice.SeleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) {
		String currentpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentpath+"/src/main/java/Resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#button1")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		/*while(it.hasNext()) {
			System.out.println("Windows are:: "+it.next().toString());
		}*/
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		System.out.println("Child window title is:: "+driver.getTitle());
		
		driver.switchTo().window(parent);
		System.out.println("Parent window title is:: "+driver.getTitle());
		driver.close();
		driver.quit();
	}
}
