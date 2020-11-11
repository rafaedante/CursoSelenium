package eduit.com.pruebas;

import org.testng.Assert;
import org.testng.annotations.*;

import eduit.com.paginas.paginaInicio;
import eduit.com.paginas.paginaLogin;
import eduit.com.utilidades.DatosExcel;
import eduit.com.utilidades.Screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;



public class Laboratorio4_E1 {
	
	WebDriver driver;
	String driverPath = "../Clase1/Drivers1/chromedriver.exe";
	String urlTest ="http://automationpractice.com/index.php";
	String rutaEvidencia = "..\\Clase1\\Evidencias";
	
	@BeforeSuite
	  public void setup(){
	  	//Propiedades para Ejecutar el driver de Chrome
	  	System.setProperty("webdriver.chrome.driver",driverPath);
	  	//instanciar Driver de Chrome + importar libreria org.openqa.selenium.chrome.ChromeDriver
	  	driver= new ChromeDriver();
	  	System.out.println("Inicio de suite de pruebas"); 
        driver.get(urlTest);
     }
	
	@Test
	 public void crearCuentaInvalida( ) throws IOException {
		 paginaLogin objLogin= new paginaLogin(driver);
		 objLogin.clickCreate();
		 
		 objLogin.sendKeysEmail("usuarioPrueba");
		 objLogin.clickCreate();
		 String titulo=objLogin.getTextTitleForm();
		  
		// Assert.assertEquals(titulo,"AUTHENTICATION");	
		 Screenshots.screenshot(rutaEvidencia, "TestRegistroInvalido", driver);		 
	 }
	
	@Test(priority=0, description="Prueba de registro", dataProvider="datos login invalido")
	 public void irRegistroLogin(String usuario, String clave ) throws IOException {
		 
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clickLogin();
		
		paginaLogin objLogin= new paginaLogin(driver);
		objLogin.inicioSesion(usuario, clave);		
		
		 String titulo=objLogin.getTextTitleForm();		  
		 Assert.assertEquals(titulo,"AUTHENTICATION");	
		 Screenshots.screenshot(rutaEvidencia, "TestRegistroInvalido", driver);		 
	 }
	
	@DataProvider(name="datos login invalido")
	public static Object[][] datos() throws Exception {
		String rutaRecurso = "..\\Clase1\\Recursos\\Datos.xlsx";
		String nombreHoja = "Hoja1";
		
		Object datosExcel[][] = DatosExcel.leerExcel(rutaRecurso, nombreHoja);
				
	    return datosExcel;
	}
	
	@AfterSuite
	public void cerrarPagina() {

		driver.quit();
	}
  
}
