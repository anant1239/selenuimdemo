package sel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WindowType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testdemo 
{
	WebDriver driver;
	
	  @BeforeTest
	  public void beforeTest()
	  {
		  //Automatically downloads the requires driver for the browser and helps you run the program
		  WebDriverManager.chromedriver().setup();
			//Web driver is an interface 
			//Interface is a class which contains all the browser implementation.
			 driver= new ChromeDriver();
		//	driver.get("https://opensource-demo.orangehrmlive.com");
		//	driver.get("https://demoqa.com/upload-download");
		//	driver.get("https://demoqa.com/alerts");
		//	driver.get("https://demoqa.com/webtables");
			 driver.get("https://demoqa.com/browser-windows");
		//	driver.get("https://formula1.com"); 
			driver.manage().window().maximize();
			
		//	driver.get("https://demo.guru99.com/test/newtours/");
			//Get title is to fetch the title of the webpage, and store it in a string variable called title
		//	String Title= driver.getTitle();
			//String Url=driver.getCurrentUrl();
		//	System.out.println(Title +"  "+  Url);
		//	Assert.assertEquals(Title, "OrangeHRM");
		//	Assert.assertEquals(Url,"https://opensource-demo.orangehrmlive.com/");
		
	  }
	  
@Test(enabled=false)
public void f() throws InterruptedException {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	  //if I want to fetch the data  (value, what is stored) from the application. Value is an attribute, and the value of a value is the username
	  String Username=driver.findElement(By.name("txtUsername")).getAttribute("value");
	  System.out.println(Username);
	  Assert.assertEquals(Username, "Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  String Password=driver.findElement(By.id("txtPassword")).getAttribute("value");
	  System.out.println(Password);
	   Assert.assertEquals(Password, "admin123");
	   String Login=driver.findElement(By.id("btnLogin")).getAttribute("value");
		System.out.println(Login);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertEquals(Login, "LOGIN");
		Thread.sleep(3000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();	
		System.out.println("My mic is on");
		System.out.println("My mic is on");
		
		
		
	  
}

@Test(enabled=false)

	public void testcase1  () throws InterruptedException
	{
		
	driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("anant");
	driver.findElement(By.xpath("//*[@name='password']")).sendKeys("anant123");
	driver.findElement(By.xpath("//*[@name='submit']")).click();
	Thread.sleep(3000);
	
	String hd=driver.findElement(By.xpath("//tbody/tr/td/h3")).getText();
	Assert.assertEquals(hd,"Login Successfully");
	
	driver.findElement(By.linkText("Flights")).click();
	//driver.findElement(By.partialLinkText("Car")).click();
	Thread.sleep(3000);
	
	//WebElement radio = driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']"));
	driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();
	//radio.click();
	
	WebElement dd = driver.findElement(By.name("passCount"));
	Select sel1 = new Select(dd);
	sel1.selectByVisibleText("1");
	Thread.sleep(3000);
	
	sel1.selectByVisibleText("4");
	Thread.sleep(3000);
	
	sel1.selectByVisibleText("2");
	
	//fromPort
	WebElement dd1 = driver.findElement(By.name("fromPort"));
	Select sel2 = new Select(dd1);
	List<WebElement> values = sel2.getOptions();
	System.out.println(values.size());
	for(int i=0;i<values.size();i++)
	{
		System.out.println(values.get(i).getText());
	}
	sel2.selectByIndex(6);
	//sel2.selectByValue("London");
	WebElement First = sel2.getFirstSelectedOption();
	System.out.println(First.getAttribute("value"));




	}

@Test(enabled=false)

public void testcase4() throws InterruptedException
{
	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(3000);
		//There is a test case how many visible links are present after login fetch there names and print it
		//tagname called a this means a link
		//am I looking for one link or multiple link
		//findElement= this will find one element
		//findelements=this will automatically find all the element	
		//when you have two or more elements with same attribute we use findelements
		List<WebElement> link = driver.findElements(By.tagName("a"));
		//Total number of links
		System.out.println("Total number of Links are "+ link.size());	
		//I want you guys to print all the visible links using for loop
		
	//	for(int i=0;i<link.size();i++)
		//{
			//	System.out.println(link.get(i).getText());
		//}
		//for Enchanced Loop
	//	for(WebElement e:link)
	//	{
	//		String eachlink=e.getText();
	//		System.out.println(eachlink);
	//	}
// I want to logout //tell me what sort of program
		
//		driver.findElement(By:)
		
		//I want you to click on the PIM link
		driver.findElement(By.linkText("PIM")).click();
		//I want to go back to the previous page
		//there is a method called navigate
		driver.navigate().back();
		//now I want to move forward
		driver.navigate().forward();
		//to refresh page
		driver.navigate().refresh();
		
		//I want to navigate to a diff URL
		
		driver.navigate().to("https://www.google.com");
		
}


@Test(enabled=false)

public void testcase5() throws InterruptedException, AWTException {
	
	WebElement link = driver.findElement(By.linkText("Gmail"));
	  Thread.sleep(1000);
	  Actions act=new Actions(driver);
	  //context click is a selenium method to right click on any elemnt
	  act.contextClick(link).build().perform();
	 
/*  when i right click and i get features from the browser if i want to automate i use somethinhg cslled ROBOT CLASS	 
*/
  Robot rbt = new Robot();
	rbt.keyPress(KeyEvent.VK_DOWN);
	rbt.keyPress(KeyEvent.VK_DOWN);
	rbt.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
//here  i want to cliclk on enter	using robot
	rbt.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	String Title = driver.getTitle();
	  System.out.println(Title);
	
	rbt.keyPress(KeyEvent.VK_CONTROL);
	rbt.keyPress(KeyEvent.VK_TAB);
	String Title1 = driver.getTitle();
	  System.out.println(Title1);
//--------------using actions switching tabs	
	 // rbt.sendKeys(Keys.CONTROL).build().perform();
	 // rbt.sendKeys(Keys.TAB).build().perform();
	  //rbt.sendKeys(Keys.ENTER).build().perform();
	///act.sendKeys(Keys.CONTROL,Keys.TAB);
/*	 act.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	  String Title = driver.getTitle();
	  System.out.println(Title);
	  act.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	  String Title1 = driver.getTitle();
	  System.oWebElement link = driver.findElement(By.linkText("Gmail"));
	  Thread.sleep(1000);
	  Actions act=new Actions(driver);
	  //context click is a selenium method to right click on any elemnt
	  act.contextClick(link).build().perform();
	 
/*  when i right click and i get features from the browser if i want to automate i use somethinhg cslled ROBOT CLASS	 
*/
  Robot rbt1 = new Robot();
	rbt1.keyPress(KeyEvent.VK_DOWN);
	rbt1.keyPress(KeyEvent.VK_DOWN);
	rbt1.keyPress(KeyEvent.VK_DOWN);
	Thread.sleep(1000);
//here  i want to cliclk on enter	using robot
	rbt1.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	String Title12 = driver.getTitle();
	  System.out.println(Title12);
	
	rbt1.keyPress(KeyEvent.VK_CONTROL);
	rbt1.keyPress(KeyEvent.VK_TAB);
	String Title2 = driver.getTitle();
	  System.out.println(Title2);
//--------------using actions switching tabs	
	 // rbt.sendKeys(Keys.CONTROL).build().perform();
	 // rbt.sendKeys(Keys.TAB).build().perform();
	  //rbt.sendKeys(Keys.ENTER).build().perform();
	///act.sendKeys(Keys.CONTROL,Keys.TAB);
/*	 act.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	  String Title = driver.getTitle();
	  System.out.println(Title);
	  act.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	  String Title1 = driver.getTitle();
	  System.out.println(Title1);ut.println(Title1); */
	  
	  
	
	
}

@Test(enabled=false)

public void testcase7() throws InterruptedException 

{
	
	//driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Admin\\Desktop\\dummy.docx");
	driver.findElement(By.id("alertButton")).click();
	//the alert pops up// to handle the alert//we use alert method in selenuim
	//I am on a webpage  and some pop up appears then I want to switch myself to the pop that I want to switch to
	Alert alt =driver.switchTo().alert();
	System.out.println(alt.getText());
	Thread.sleep(3000);
	//This is basically to click on ok button
	alt.accept();
	//if I want to click on cancel
	//alt.dismiss();
	
	//This is a confirm button which means it is a ok button as well as a cancel method
	//so that means i can either click on the ok button or on the cancel button
	driver.findElement(By.id("confirmButton")).click();
	Thread.sleep(3000);
	alt.dismiss();
	
	//prompt is basically to accept some data 
	Thread.sleep(3000);
	driver.findElement(By.id("promtButton")).click();
	Thread.sleep(3000);
	
	alt.sendKeys("Anant");
	Thread.sleep(3000);
	System.out.println(alt.getText());
	alt.accept();
	
	//when I work with alert I can use some different methods
	//sendKeys --> to pass the value
	//getText --> to fetch the alert name
	//accept --> click on ok button
	//dismiss --> click on the cancel button
	
	
	
	
	
}

@Test(enabled=false)

public void testcase8() 
{
	String pv=driver.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']")).getText();
	System.out.println(pv);
}


@Test(enabled=false)

public void testcase9() throws InterruptedException
{
	String parentwindow = driver.getWindowHandle();
	  System.out.println(parentwindow);
	  
	  WebElement windbtn = driver.findElement(By.id("windowButton"));
	  for (int i=0;i<3;i++)
	  {
		  windbtn.click();
	  }
	  
	  Set<String> allwindow = driver.getWindowHandles();
	  System.out.println(allwindow.size());
	  String lastwindow = "";
	  //I want to open google 
	  for(String handel : allwindow)
	  {
		  System.out.println("I want to open google in all window");
		  driver.switchTo().window(handel);
		  driver.get("https://twitter.com");
		  lastwindow=handel;
	  }
	  Thread.sleep(3000);
	  driver.switchTo().window(parentwindow);
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  //will close only active window
	  driver.close();
	  // quit will quit all of the windows
	  driver.quit();
	  
	  //Can I use the index to navigate multiple windows
	  
}
@Test(enabled=false)

public void testcase10() throws InterruptedException 
{
	JavascriptExecutor js=( JavascriptExecutor)driver;
	 String title=js.executeScript("return document.title").toString();
	 System.out.println(title);	 
	 String url=js.executeScript("return document.URL").toString();
	 System.out.println(url);	 
	 String domain=js.executeScript("return document.domain").toString();
	 System.out.println(domain); 
	 String alltext=js.executeScript("return document.documentElement.innerText").toString();
	 System.out.println(alltext);
	 String parenttab=driver.getWindowHandle();
	  System.out.println(parenttab);
	 WebDriver newtab = driver.switchTo().newWindow(WindowType.TAB);
	 newtab.get("https://f1.com");
	  Thread.sleep(3000);
	//  driver.navigate().back();
	  ///declare parent tab
	  Set<String> alltab = driver.getWindowHandles();
	  Object [] altab= alltab.toArray();
	  
	  System.out.println(alltab.size());
	//  driver.switchTo().window(parenttab);  
	// driver.get("https://google.com");
	  driver.switchTo().window((String) altab[0]);
	  driver.close();
	  driver.switchTo().window((String)altab[1]);
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  Thread.sleep(3000);
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText ("PIM")).click();

		driver.findElement(By.linkText ("Employee List")).click();
		
		
		

		//scrollIntoView()

		// this method will help me to scroll a specific element 
		js.executeScript ("document.getElementById('ohrmList_chkSelectRecord_29').scrollintoView()");
		
		
		
		
	  
	  
	 // driver.get("https://google.com");
	 // Thread.sleep(3000);
	//  driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Moolya",Keys.ENTER);
	//  Actions alt= new Actions(driver);
	 // alt.sendKeys(Keys.PAGE_DOWN).build().perform();
//	  js.executeScript("window.scrollBy(0,600)");
	  //if you want to scroll to the end of the page, then you can use document.body.scrollHeight
	  
	//  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	//  Thread.sleep(3000);
	  //I want to scroll up, if I want to scroll all the way up then I use -
	//  js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	//  Thread.sleep(3000);
	//  js.executeScript(document.)



	  
	  
	  
			  //  driver.quit();

	// for(String handel : alltab)
	// {
		// driver.switchTo().window(handel);
		// driver.get("https://espncricinfo.com");
		// lasttab = handel;
	//	 System.out.println(handel);
		//	driver.switchTo().window(handel[0]);

	// } 
}

@Test

public void testcase11() {
	JavascriptExecutor	js=( JavascriptExecutor)driver;
	 
	 driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cricinfo",Keys.ENTER);
	 Thread.sleep(3000);
	 driver.findElement(By.partialLinkText("Live cricket scores, match schedules, latest cricket news ...")).click();
	 driver.findElement(By.partialLinkText("Teams")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.linkText("India")).click();
	 Thread.sleep(2000);
	 js.executeScript("document.getElementsByClassName('ds-flex ds-flex-row ds-space-x-4')[0].scrollIntoView()");
	 Thread.sleep(4000);
	 driver.findElement(By.partialLinkText("Ganguly, Morgan, Muralidaran, Misbah, Johnson among 53 players in Legends League Cricket")).click();
	
}





public void afterTest() 
{
	//  driver.close();
}
	
}
