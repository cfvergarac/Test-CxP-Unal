package pageObjetcs;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import  QA.Test.cuentasPorPAgar.LeerExcel;
import  QA.Test.cuentasPorPAgar.Navegador;



public class POLogin {
	
	
	private WebDriver  driver;
	
	@CacheLookup
	private WebElement auth_username;
	@CacheLookup
	private WebElement auth_password;
	@CacheLookup
	private WebElement btn_login;
	
	private LeerExcel excel;
	
	
	
    //constructor
	public POLogin(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			excel = new LeerExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//metodos
	
	public void AbrirPagina() {
	 Navegador.abrirPagina(excel.getURL());
	 
	 }


	 public void ingresar(){
		 btn_login.click();
		 new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
			 
			 public Boolean apply(WebDriver d) {
				 return d.findElement(By.id("nav-exit2")).isDisplayed();
				}});
	 }
	 
	 
		
	public void ingresarUsuarioSuper(){
		auth_username.sendKeys(excel.getSuper());
	
	}
	
	public void IngresarcontraseñaSuper(){
			
		 this.auth_password.sendKeys(excel.getPassUsuario());
	}
	
	
	public void ingresarSuper()
	{
		
		 
		 this.ingresarUsuarioSuper(); 
		 this.IngresarcontraseñaSuper();
		 this.ingresar();
		 
		 /*this.IngresarcontraseñaSuper();
		 this.ingresar();*/
		 
		 
		 /*Faker faker = new Faker(new Locale("es-MX"));
		 
		 for(int i=0; i<10; i++)
		 {	 
			 
		  String name = faker.lorem().word();
		  System.out.println(name+ " ");
		  
		 }*/
		
	}
	
		
}
