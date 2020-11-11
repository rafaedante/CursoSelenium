package eduit.com.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory; 

public class paginaLogin {
	/* Todos los elementos se identifican con la anotación @FindBy  */

    WebDriver driver;

    @FindBy(id="email_create")
    WebElement txtUser;

    @FindBy(id="SubmitCreate")
    WebElement btnCreate;
    
    @FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
    WebElement titleForm;
    
    @FindBy(id="email")
    WebElement txtEmailLogin;
    
    @FindBy(id="passwd")
    WebElement txtClaveLogin;
    
    @FindBy(id="SubmitLogin")
    WebElement btnLogin;
    
    public paginaLogin(WebDriver driver){

        this.driver = driver;

        //Inicializa los elementos con una espera implicita

        PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);

    }
    
    public void sendKeysEmail(String user){
    	txtUser.clear();
    	txtUser.sendKeys(user);
    }
    
    public void clickCreate(){
    	btnCreate.click();
    }
    
    public String getTextTitleForm() {
    	return titleForm.getText();
    }
    
    public void inicioSesion(String usuario, String clave) {
    	txtEmailLogin.clear();
    	txtEmailLogin.sendKeys(usuario);
    	txtClaveLogin.clear();
    	txtClaveLogin.sendKeys(clave);
    	btnLogin.click();
    }

}

/*
 Dentro la clase ya creada: paginaLogin.java , localizar elementos de login: texto email,
contraseña y botón Login.
4. Crear un método para enviar texto a email, constraseña y clickear en botón Login. Este
deberá recibir como parámetros los String email y constraseña.
 * */
