package sel;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class yt {
	
WebDriver driver;
	
	@BeforeTest
	public void BT() {
		WebDriverManager.chromedriver().setup();
		//This line will open the new instance of browsers
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		
	}
	
	
	@Test
	public void tc1() throws InterruptedException
	{
		//we have two window to work with i use window handels
		//when I use get window handel it will capture only the first window
		String parentwindow = driver.getWindowHandle();
		//This line will open another window only once
		driver.findElement(By.id("windowButton")).click();
		//if we have multiple windows then we go for window handels
	Set<String> allwindow = driver.getWindowHandles();
//		System.out.println(allwindow.size());
		//i want to switch to my second window
//		driver.switchTo().window(new ArrayList<String> (driver.getWindowHandles()).get(driver.getWindowHandles().size()-1));
//		driver.get("https://www.google.com");
	//here he is converting the variable in to an array
		Object[] winhandels = allwindow.toArray();
		//here i can choose which windows i want to go and performa the actions based on the index
		driver.switchTo().window((String) winhandels[1]);
		driver.get("http://www.google.com");
		driver.close();
		driver.switchTo().window((String) winhandels[0]);
		driver.get("http://www.youtube.com");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("kothu onee");
		//driver.findElement(By.className("style-scope ytd-searchbox")).click();
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
		WebElement link = driver.findElement(By.partialLinkText("iraj mata kothu onnee));
		act.moveToElement(link).click().build().perform();
}
}
