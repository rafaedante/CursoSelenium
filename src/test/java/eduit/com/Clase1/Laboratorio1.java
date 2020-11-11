package eduit.com.Clase1;

import org.testng.annotations.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.*;

public class Laboratorio1 {
	
	@Test
	public void lab1_E1() {
		
		System.setProperty("webdriver.chrome.driver", "../Clase1/Drivers1/chromedriver.exe");
		
		WebDriver d= new ChromeDriver();
		
		d.get("https://selenium.dev/");
		
		d.quit();
		
	}
	
	@Test
	public void lab1_E2() {
		
		System.setProperty("webdriver.gecko.driver", "../Clase1/Drivers1/geckodriver.exe");
		
		WebDriver d= new FirefoxDriver();
		
		d.get("https://selenium.dev/");
		
		//d.quit();
		
	}
	
	@Test
	public void lab1_E3() {
		
		System.setProperty("webdriver.chrome.driver", "../Clase1/Drivers1/chromedriver.exe");
		
		WebDriver d= new ChromeDriver();
		
		d.get("https://selenium.dev/");
		
		WebElement txtBuscador = d.findElement(By.id("gsc-i-id1"));
		
		txtBuscador.sendKeys("Maven");
		txtBuscador.sendKeys(Keys.ENTER);
		
		d.quit();
		
	}
	


}
