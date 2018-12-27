package QA.Test.cuentasPorPAgar;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Tablas {
	
	private  WebElement tablaWeb;
	
	
	public Tablas(WebElement tablaWeb) {
	
		set_tablaWeb(tablaWeb);
		
	}
	
	
	public void set_tablaWeb(WebElement tablaWeb) {
		// TODO Auto-generated method stub
		this.tablaWeb = tablaWeb;
	}
	
	
	 public WebElement get_tablaWeb() {
		 return tablaWeb;
	}
	
	 
	 public int retornaNumeroFilas( ) {
		 
		 List<WebElement> filas = tablaWeb.findElements(By.tagName("tr"));
		 return filas.size();
				 
	 }
	 
	 public int retornaNumeroColumnas( ) {
		 
		 List<WebElement> filas = tablaWeb.findElements(By.tagName("tr"));
		 WebElement cabecera = filas.get(0);
		 
		 List<WebElement> columnas = cabecera.findElements(By.tagName("th"));
		 
		 return columnas.size();
				 
	 }

	 
	 public String obtenerValorCelda(int fila, int columna) {
		 
		 List<WebElement> filas = tablaWeb.findElements(By.tagName("tr"));
		 WebElement filaActual = filas.get(fila-1);
		 List<WebElement> columnas =  filaActual.findElements(By.tagName("td"));
		 WebElement celda = columnas.get(columna-1);
		 List<WebElement> input =  celda.findElements(By.tagName("input"));

		 
		 if( input.size() == 0 ) {
			 
		  return celda.getText();
		 }
		 
		 else {
	      System.out.println(input.get(0).getAttribute("Value"));
		  return "Es campo";
		 }
		 
	 }
	 
	 
	 public WebElement recibirEditorCelda(int fila , int columna , int editor) throws NoSuchElementException {
		 try{ 
		 
			 List<WebElement> filas = tablaWeb.findElements(By.tagName("tr"));
			 WebElement filaActual = filas.get(fila-1);
			 List<WebElement> columnas =  filaActual.findElements(By.tagName("td"));
			 WebElement celda = columnas.get(columna-1);
			 
			 WebElement editorCelda = celda.findElements(By.tagName("input")).get(editor);
			 return editorCelda;
		 
		    } catch (NoSuchElementException e) { throw new NoSuchElementException("Fallo");
		 }
		 
	  }
	 

}
