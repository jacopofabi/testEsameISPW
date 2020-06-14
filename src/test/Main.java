package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	//Jacopo Fabi 0243948
	public static void main(String[] args) {
		int speedM1 = 75;
		int speedM2 = 55;
		float speedK1;
		float speedK2;
		
		WebDriver webDriver = null;
		WebElement miles, km;
		
		try {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			webDriver = new ChromeDriver();
			webDriver.get("https://www.rapidtables.com/convert/length/mile-to-km.html");
			
			miles = webDriver.findElement(By.xpath("//*[@id=\"x\"]"));
			km = webDriver.findElement(By.xpath("//*[@id=\"doc\"]/form/table/tbody/tr[3]/td[2]/input"));
			
			miles.clear();
			miles.sendKeys(String.valueOf(speedM1));
			webDriver.findElement(By.xpath("//*[@id=\"calc\"]")).click();
			speedK1 = Float.parseFloat(km.getAttribute("value"));
			Thread.sleep(1000);
			
			miles.clear();
			miles.sendKeys(String.valueOf(speedM2));
			webDriver.findElement(By.xpath("//*[@id=\"calc\"]")).click();
			speedK2 = Float.parseFloat(km.getAttribute("value"));
			Thread.sleep(1000);
			

			System.out.println(speedK1);
			System.out.println(speedK2);
			
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "Test exception");
		}
		finally {
			if (webDriver != null) {
				webDriver.close();
			}
		}
	}
}
