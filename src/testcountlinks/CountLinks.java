package testcountlinks;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinks {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		// List myList = driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement myFooter = driver.findElement(By.id("pageFooter"));
		System.out.println(myFooter.findElements(By.tagName("a")).size());

		WebElement lastFooter = driver.findElement(By.id("pageFooterChildren"));
		System.out.println(lastFooter.findElements(By.tagName("a")).size());

//		for (int i=0; i<lastFooter.findElements(By.tagName("a")).size();i++) {
//			
//lastFooter.findElements(By.tagName("a")).get(i).click();
//			Thread.sleep(2000);
//		}	

		for (int i = 0; i < lastFooter.findElements(By.tagName("a")).size(); i++) {

			Thread.sleep(300);
			String openLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			lastFooter.findElements(By.tagName("a")).get(i).sendKeys(openLinks);
		}

//		Set<String> opentab=driver.getWindowHandles();
//		Iterator<String> tabview=opentab.iterator();
//		
//		while (tabview.hasNext()) {
//			driver.switchTo().window(tabview.next());
//			System.out.println(driver.getTitle());
//			
//		}
		
		Set<String> opentab=driver.getWindowHandles();
		Iterator<String> tabview=opentab.iterator();
		
		while (tabview.hasNext()) {
			driver.switchTo().window(tabview.next());
			System.out.println(driver.getTitle());
			
		}
		
	}

}
