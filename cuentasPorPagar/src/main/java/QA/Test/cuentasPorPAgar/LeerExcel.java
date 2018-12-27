package QA.Test.cuentasPorPAgar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**


 */


public class LeerExcel {
	

	private XSSFSheet sheet;
	private XSSFWorkbook workbook;
	private FileInputStream file;
	public static String url;
	public static String urlModelatos;
	public static String superuser;
	public static String passSuper;
	public static String userModelatos;
	public static String passModelatos;



	public LeerExcel() throws IOException
	{
	
	this.file = new FileInputStream(new File( "D:\\cuentasPorPAgar\\src\\main\\java\\QA\\Test\\cuentasPorPAgar\\Data.xlsx"));
	this.workbook = new XSSFWorkbook(file);
	this.sheet = workbook.getSheetAt(0);
    setURL(this.sheet);
    setURLModelatos(this.sheet);
    
    setSuperUser(this.sheet);
    setPassUsuario(this.sheet);
    setModelatosUser(this.sheet);
    setPassModelatos(this.sheet);

	}
	

	public  String getURL() {
		return url;
	}

	
	public static void setURL(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(0).getCell(1);
		LeerExcel.url = String.valueOf(resultCell);
	}
	
	public  String getURLModelatos() {
		return urlModelatos;
	}

	
	public static void setURLModelatos(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(0).getCell(2);
		LeerExcel.urlModelatos = String.valueOf(resultCell);
	}


	public String getSuper() {
		return superuser;
	}


	public void setSuperUser(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(1).getCell(1);
		LeerExcel.superuser = String.valueOf(resultCell);
	}


	public String getPassUsuario() {
		return passSuper;
	}


	public void setPassUsuario(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(2).getCell(1);
		LeerExcel.passSuper = String.valueOf(resultCell);
	}
	
	
	public String getUser() {
		return userModelatos;
	}


	public void setModelatosUser(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(3).getCell(1);
		LeerExcel.userModelatos = String.valueOf(resultCell);
	}
	
	
	public String getPassModelatos() {
		return passModelatos;
	}


	public void setPassModelatos(XSSFSheet sheet) throws IOException {
		Cell resultCell=(Cell) sheet.getRow(4).getCell(1);
		LeerExcel.passModelatos = String.valueOf(resultCell);
	}

	
}
