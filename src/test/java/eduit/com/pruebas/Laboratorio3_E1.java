package eduit.com.pruebas;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3_E1 {
	
	WebDriver driver;
	String driverPath = "../Clase1/Drivers1/chromedriver.exe";
	String urlTest = "http://automationpractice.com/index.php?controller=authentication#account-creation";
	
	
	@BeforeSuite

	public void setUp() {
		// Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		System.out.println("Inicio de suite de pruebas");

	}

	@BeforeTest

	public void IrURL() {
		System.out.println("Ingresando a url:" + urlTest);
		driver.get(urlTest);
	}

	@BeforeClass

	public void maximizarNavegador() {

		driver.manage().window().maximize();
		System.out.println("Inicio de caso de prueba:");
	}

	@Test(enabled = false, description = "Prueba de link Descarga")
	public void verificarLink() {
		WebElement lnkDescarga = driver.findElement(By.linkText("Downloads"));
		lnkDescarga.getText();
		Assert.assertEquals("Downloads", lnkDescarga.getText());

	}

	@Test(description = "Prueba registro faceebook fail")
	public void registroUsuario() {

		// Defino variable para espera explicita antes de asignar Elemento
		WebDriverWait myWait = new WebDriverWait(driver, 20);

		// Elemento input Email por locator CSS SELECTOR
		WebElement inputMail = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_create")));
		inputMail.sendKeys("nadiasdada@email.com");

		// Elemento botón para crear cuenta nueva por locator XPATH (herramientas de
		// desarrollo)
		WebElement btnCrearCuenta = myWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SubmitCreate\"]")));
		btnCrearCuenta.click();

		// Elemento input Nombre por locator NAME
		WebElement inputNombre = myWait.until(ExpectedConditions.elementToBeClickable(By.name("customer_firstname")));
		inputNombre.sendKeys("Moni");

		// Elemento input Password por locator ID
		WebElement inputClave = myWait.until(ExpectedConditions.elementToBeClickable(By.id("passwd")));
		inputClave.sendKeys("1234");

		// Elemento Dropdowns Mes e instancia objeto Select para seleccionar elemento.
		Select dropMes = new Select(myWait.until(ExpectedConditions.presenceOfElementLocated(By.id("months"))));
		dropMes.selectByVisibleText("April ");

		// Elemento radio button Title utilizando locator XPATH y función contains()
		WebElement radioTitulo = myWait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[contains(@type,'radio') and @value='1']")));
		radioTitulo.click();

		// Elemento boton Registro utilizando locator XPATH y función text()
		WebElement btnRegistrar = myWait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Register']")));
		btnRegistrar.click();

		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
	}

	@AfterTest
	public void cerrarPagina() {

		driver.quit();
	}

	@AfterSuite
	public void finSuite() {
		System.out.println("Fin de suite de pruebas");
	}

}
