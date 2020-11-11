package eduit.com.pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import eduit.com.paginas.paginaInicio;
import eduit.com.paginas.paginaLogin;

public class Laboratorio3_E2 {
	 WebDriver driver;
	 String driverPath = "../Clase1/Drivers1/chromedriver.exe";
	 String urlTest ="http://automationpractice.com/index.php";
	 
	 @BeforeSuite
	  public void setup(){
	  	//Propiedades para Ejecutar el driver de Chrome
	  	System.setProperty("webdriver.chrome.driver",driverPath);
	  	//instanciar Driver de Chrome + importar libreria org.openqa.selenium.chrome.ChromeDriver
	  	driver= new ChromeDriver();
	  	System.out.println("Inicio de suite de pruebas"); 
        driver.get(urlTest);
     } 
	 
	 @Test (priority=0)
	 public void irRegistroLogin(){
		 paginaInicio objInicio=new paginaInicio(driver);
	 	 objInicio.clickLogin();
		 
		 paginaLogin objLogin=new paginaLogin(driver);
		 String titulo=objLogin.getTextTitleForm();
			  
		 //Assert.assertEquals(titulo,"AUTHENTICATION");		    
	 } 
	 
	 @Test
	 public void crearCuentaInvalida( ) throws IOException {
		 paginaLogin objLogin= new paginaLogin(driver);
		 objLogin.clickCreate();
		 
		 objLogin.sendKeysEmail("usuarioPrueba");
		 objLogin.clickCreate();
		 String titulo=objLogin.getTextTitleForm();
		  
		// Assert.assertEquals(titulo,"AUTHENTICATION");	
		 
		 File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screen, new File("..\\Clase1\\Evidencias\\Test.png"));
		 
	 }

}
