import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainClass extends MyStore{
	
	public static void main(String[] args) throws Throwable {
		
		launchChromeBrowser();
		loadUrl("https://www.lora-moi.ch/en/");
		driver.manage().window().maximize();
		screenShot(driver, "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\screenshot\\url.png");
		driver.findElement(By.xpath("(//a[@class='account login'])[2]")).click();
		Thread.sleep(1000);
		screenShot(driver, "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\screenshot\\Beforesigin.png");
        WebElement email = driver.findElement(By.id("email"));
		fill(email,getData(1,0));
		WebElement password = driver.findElement(By.id("passwd"));
		fill(password,getData(1,1));
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
 
	   screenShot(driver, "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\screenshot\\sigin.png");
	  
	  WebElement watch = driver.findElement(By.xpath("//a[text()='Watches ']"));
	  Action1(watch);
	  screenShot(driver, "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\screenshot\\watch.png");

	  WebElement women = driver.findElement(By.xpath("(//a[text()='Women Watches'])[2]"));
	  btnclick(women);
	  Thread.sleep(7000);
	  screenShot(driver, "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\screenshot\\women.png");
	  
	  WebElement product = driver.findElement(By.xpath("//a[text()=' LAiMER Wood Watch JULIA ']"));
	  btnclick(product);
	  
	  WebElement addtocart = driver.findElement(By.id("add_to_cart"));
	  btnclick(addtocart);
	  
	  
	  String parent = driver.getWindowHandle();
	  System.out.println(parent);
	  Set<String> allwindow = driver.getWindowHandles();
	  System.out.println(allwindow);
	  for(String x:allwindow) {
		  if(!parent.equals(x)) {
			  driver.switchTo().window(x);
		  }
			  Thread.sleep(8000);
			  screenShot(driver, "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\screenshot\\cart.png");
				
			
		  
	  }
	}
}
	 



























	 // JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("argument[0].scrollIntoview(true)", addtocart);
//List<String> li=new ArrayList();
//li.addAll(allwindow);
//String s = li.get(2);
//driver.switchTo().window(s);
//driver.findElement(By.id("product")).click();

	  
	  

	  
	
	

		

