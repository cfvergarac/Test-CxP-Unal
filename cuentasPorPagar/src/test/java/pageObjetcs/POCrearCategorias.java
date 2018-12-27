package pageObjetcs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  QA.Test.cuentasPorPAgar.LeerExcel;
import  QA.Test.cuentasPorPAgar.Navegador;
import  QA.Test.cuentasPorPAgar.Tablas;


public class POCrearCategorias {
	
	
	private WebDriver  driver;
	
	@CacheLookup
	@FindBy(tagName = "body")
	private WebElement bodyContent;
	
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Agregar Categoría')]")
	private WebElement btnAgregarcategoria;
	
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Guardar Todo')]")
	private WebElement btnGuardarTodo;
	
	@CacheLookup
	@FindBy(id = "mensaje_sin_resultados")
	private WebElement MensajeNoHayCategorias;

	@CacheLookup
	@FindBy(id = "tabla_creacion_categorias")
	private WebElement tablaCreacionCategorias;
	Tablas tabla;
	
	@CacheLookup
	@FindBy(tagName = "table")
	private WebElement tablaCreacion;
	
	private Tablas tablaCreadas;
	private LeerExcel excel;
	
	
	
    //constructor
	public POCrearCategorias(WebDriver driver) {
		
		this.driver = driver;
		tablaCreadas =  new Tablas(tablaCreacion);
		PageFactory.initElements(driver, this);
		try {
			excel = new LeerExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//metodos
	
	public void verificaTextoPágina(String texto) {

		
		bodyContent.getText().contains("Categorías Para Liquidación De Órdenes De Pago");
	 }
	
	
	
	private boolean estaPresente(By by) {
		
		try {
			Navegador.driver().findElement(by);
			 return true;
			 } catch (NoSuchElementException e) {
			 return false;
			 }
		
	}
	

	public boolean verificaBtnAgregarCategoria() {
		
		
		 if(estaPresente(By.xpath("//a[contains(text(),'Agregar Categoría')]"))){
			 return true;
		 }
		 
			 return false;
	}
	
	
	public boolean verificaBtnGuardarTodo() {
		
		
		 if(estaPresente(By.xpath("//a[contains(text(),'Guardar Todo')]"))){
			 return true;
		 }
		 
			 return false;
	}
	
	
	public boolean verificaTabla() {
		
		
		 if(estaPresente(By.id("tabla_creacion_categorias")) && estaPresente(By.id("cuerpo_tabla")) && estaPresente(By.id("id_fila_1"))  &&  estaPresente(By.className("tabla_encabezado")) ){
			 return true;
		 }
		 
			 return false;
	}
	
	
	
	public boolean verificaFilaInsertada() {
		
		tablaCreacion.isDisplayed();
		//int filas = tabla.retornaNumeroFilas();
		System.out.println("Filas:"+ tablaCreadas.retornaNumeroFilas());
		
		
		
		 if( estaPresente(By.id("nombre_categoria_1")) &&  estaPresente(By.id("formula_1")) &&  estaPresente(By.id("concepto_1")) &&  estaPresente(By.id("tipoCuenta_1"))  &&  estaPresente(By.id("boton_eliminar_1"))  ){
			 return true;
		 }
		 
			 return false;
	}
	
	
	
	
	public boolean NohayCategorias() {
		
		
		 if(estaPresente(By.id("mensaje_sin_resultados"))){
			 return true;
		 }
		 
			 return false;
	}
	

	
	public void clicBtnAgregarCategoria() {

		btnAgregarcategoria.click();
		
	 }
	
	
	
	public void clicBtnGuardarTodo() {

		btnGuardarTodo.click();
	 }
	
		
}