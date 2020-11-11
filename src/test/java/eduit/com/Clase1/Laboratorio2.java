package eduit.com.Clase1;

import org.testng.annotations.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Laboratorio2 {
	
	@Test
	public void lab2_E1() {
		
		System.setProperty("webdriver.chrome.driver", "../Clase1/Drivers1/chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		
		d.get("http://automationpractice.com/index.php?controller=authentication#account-creation");
		
		@SuppressWarnings("deprecation")
		WebDriverWait myWait = new WebDriverWait(d, 15);
		
		// Elemento input Email por locator CSS SELECTOR
		WebElement inputMail = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_create")));
		inputMail.sendKeys("rafa@email.com");

		// Elemento botÃ³n para crear cuenta nueva por locator XPATH (herramientas de desarrollo)
		WebElement btnCrearCuenta = myWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SubmitCreate\"]")));
		btnCrearCuenta.click();

		//Elemento input Nombre por locator NAME
		WebElement inputNombre = myWait
				.until(ExpectedConditions.elementToBeClickable(By.name("customer_firstname")));
		inputNombre.sendKeys("Juan");
		
		//Elemento input Password por locator ID
		WebElement inputClave = myWait
				.until(ExpectedConditions.elementToBeClickable(By.id("passwd")));
		inputClave.sendKeys("12345");
		
		//Elemento Dropdowns Mes -> abril
		Select dropMes=new Select(myWait.until(ExpectedConditions.elementToBeClickable(By.id("months"))));
		dropMes.selectByVisibleText("April ");	
		
		
		//Elemento radio button Title utilizando locator XPATH y funciÃ³n contains()
		//WebElement radioTitulo = myWait
	//			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@type,'radio') and @value='1']")));
		//radioTitulo.click();
		
		//Elemento boton Registro utilizando locator XPATH y funciÃ³n text()
		WebElement btnRegistrar=myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Register']")));
		btnRegistrar.click();
		
		//Cierra Driver
		d.quit();
		
		
		
		
		
		
	}

}
