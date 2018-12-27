package QA.Test.cuentasPorPAgar;

import org.testng.annotations.Test;

import pageObjetcs.POCrearCategorias;
import pageObjetcs.POInicioSuper;
import pageObjetcs.POLogin;
import pageObjetcs.POModelatos;
import QA.Test.cuentasPorPAgar.Navegador;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class CU_006 {
	
	private POLogin poLogin = new POLogin(Navegador.driver());
	private POInicioSuper poinicioSuper =  new POInicioSuper(Navegador.driver());
	private POCrearCategorias poCrearCategorias =  new POCrearCategorias(Navegador.driver());
	private POModelatos poModelatos = new POModelatos(Navegador.driver());
	
	
	  @BeforeTest
	  public void beforeTest() {
		  poLogin.AbrirPagina();
		  poLogin.ingresarSuper();
		  poinicioSuper.verificaTextoPágina("Bienvenido, usted se encuentra en la Central de Pagos de la Universidad Nacional de Colombia");
		  poinicioSuper.ingresarRutaCrearCategorias();
		  poCrearCategorias.verificaTextoPágina("Categorías Para Liquidación De Órdenes De Pago");
	  }
	
	
	  @Test 
	  /*Verifica la existencia de 2 botones: crear categoria y guardar todo*/
	  
	  public void CP_001() {
		
		  Assert.assertEquals(true, poCrearCategorias.verificaBtnAgregarCategoria());
		  Assert.assertEquals(true, poCrearCategorias.verificaBtnGuardarTodo());
		  
      }
	  
	  @Test 
	  /*Verifica la creacion de un nuevo registro para agregar una categoria al hacer click en el boton de agregar*/
	  
	  public void CP_002() {
		   
		  //si no hay categorias creadas
		  if(poCrearCategorias.NohayCategorias()) {
			
			  poCrearCategorias.clicBtnAgregarCategoria();
			  Assert.assertEquals(true, poCrearCategorias.verificaTabla());
			  Assert.assertEquals(true, poCrearCategorias.verificaFilaInsertada());
			  
		  }
		  
		  
      }
	  
	  
	  @AfterTest
      public void afterTest() {
	
		  
      }

}
