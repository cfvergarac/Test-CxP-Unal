package QA.Test.cuentasPorPAgar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Navegador {
	
	private static WebDriver driver = new FirefoxDriver();
	
	public static WebDriver driver(){
		 return driver;
	}
	
	public static void abrirPagina(String url) {
		 driver.get(url);
		 driver.manage().window().maximize();
		 }
	
	public static void CerrarPagina() {
		 driver.quit();
		 }

}
