package pageObjetcs;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  QA.Test.cuentasPorPAgar.LeerExcel;


public class POInicioSuper {
	
	
	private WebDriver  driver;
	
	@CacheLookup
	@FindBy(tagName = "body")
	private WebElement bodyContent;
	
	/*@CacheLookup
	@FindBy(linkText = "Servicios")
	private WebElement servicios;*/
	
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Servicios')]")
	private WebElement linkServicios;
	
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Categorías para Liquidación de Órdenes de pago')]")
	private WebElement linkcategorias;
	
	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Agregar Categoría')]")
	private WebElement btnAgregarcategoria;

	
	private LeerExcel excel;
	
	
	
    //constructor
	public POInicioSuper(WebDriver driver) {
		
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
	
	public void verificaTextoPágina(String texto) {

		
		bodyContent.getText().contains("Categorías Para Liquidación De Órdenes De Pago");
	 }

	public void ingresarRutaCrearCategorias() {

		linkServicios.click();
		linkcategorias.click();
		
	 }
	
		
}
