package Practice.SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePractice {
	public static void main(String[] args) {
		String currentpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentpath+"/src/main/java/Resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of frames present:: "+size);
		
		WebElement ele=driver.findElement(By.xpath("//p[text()='Use these frames to practice your skills']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",ele);
		
		driver.switchTo().frame("iframe1");
		String te=driver.findElement(By.xpath("//span[text()='Selenium in Java']")).getText();
		System.out.println(te);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe2");
		String text=driver.findElement(By.linkText("Droppable")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		driver.close();driver.quit();
		System.out.println("GIT Changes");
	}
}
