package java_selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class miniproj {
	
	static WebDriver driver;
	//Adding the url
	public static String baseUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	
	public static WebDriver DriverSelect(int num)
	{
		//Selecting the drivers, chrome or mozilla firefox
	
	if(num==1)
	{
		
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		return driver;
	}
	else if(num==2)
	{
		WebDriverManager.firefoxdriver().setup();
		
	driver= new FirefoxDriver();
	return driver;
	}
	else
	{
		System.out.println("Enter valid number");
		driver.close();
		return null;
	}
	
	}
	
	public static void maximize()
	{
		//maximize the window
		driver.manage().window().maximize();
	}
	
	public static void username()
	{
		//Enter user name
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}
	public static void password()
	{
		//Enter password
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	public static void login()
	{
		//Click on login button
		driver.findElement(By.id("btnLogin")).click();
	}
	public static void getAdminModule()
	{
		//click on menu
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	public static void qualifications()
	{
		//click on qualifications
		driver.findElement(By.id("menu_admin_Qualifications")).click();
	}
	public static void skills()
	{
		//click on skillos
		driver.findElement(By.id("menu_admin_viewSkills")).click();
	}
	public static void add()
	{
		//Add a skill
		driver.findElement(By.id("btnAdd")).click();
	}
	public static void skillName()
	{
		//Give the skill name as 'Testing Demo'
		driver.findElement(By.id("skill_name")).sendKeys("Testing Demo");
	}
	public static void save()
	{
		//save the skill
		driver.findElement(By.id("btnSave")).click();
	}
	

	public static void driverQuit()
	{
		//close the browser
		driver.quit();
	}
	public static void findElement()
	{
		//select the added skill
		driver.findElement(By.xpath("//a[contains(text(),'Testing Demo')]/parent::td//preceding-sibling::td//input[@name='chkListRecord[]']")).click();
	}
	public static void delete()
	{
		//delete the skill
		driver.findElement(By.id("btnDel")).click();
	}
	public static void check()
	{
		//check the message displayed after deletion
		WebElement txt=driver.findElement(By.xpath("//div[@class='message success fadable']"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg=txt.getText();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(msg.equals("Successfully Deleted"))
		{
			System.out.println("Skills set deleted successfully");
		}
		else
		{
			System.out.println("Skills set not deleted ");
		}
		
	}
	
	public static void ScrollUp()
	{
		//scrolls up the page
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400);");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		//implement the methods
		System.out.println("Enter 1 to test on chrome\nEnter 2 to test on firefox");
		int num;
		Scanner sc= new Scanner(System.in);
		num=sc.nextInt();
		DriverSelect(num);
		driver.get(baseUrl);
		sc.close();
		maximize();
		
		username();
		password();
		login();
		getAdminModule();
		qualifications();
		skills();
		add();
		skillName();
		save();
		ScrollUp();
		findElement();
		delete();
		check();
		driverQuit();
		
		
		
		}
}
