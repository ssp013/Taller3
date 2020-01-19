 /**
  * General App 
  * @author  Sebatián Sánchez - Tomás Sandoval
  * @param App.java
  * @throws IllegalArgumentException
  */
package logic;
import ucn.*;
import java.io.IOException;
import java.util.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
public class App {
	static Scanner sc = new Scanner(System.in);
	public static int validateOption(){
		while (true){
			try{
			    return sc.nextInt();
			   }
			catch (InputMismatchException e)
			   {
			    sc.next();
			    System.out.print("Error: Enter again : ");
			   }
		}
	}
	public static String validarOpcionString(){
		while (true){
			try{
			    return sc.nextLine();
			   }
			catch (InputMismatchException e){
			    sc.next();
			    System.out.print("Error ingrese una opción! ");
			    }
			}
	}
	public static void displayMenu() {
		StdOut.print("1.Upload Files\n 2.Create New Entities\n 3. Register Entry and Exit\n 4.Reassign Scientist\n 5. Personnel and Cost Reports\n 6. System Closure");
	}
	public static boolean loadTXTInstallation(SystemSusto System) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Installation.txt");
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			int cantDepartamentos =  regEnt.getInt();
			ListaDepartamentoInstalacion listaNuevaDI = new ListaDepartamentoInstalacion(cantDepartamentos);
			for(int i=0;i<cantDepartamentos;i++) {
				String depto1 = regEnt.getString();
				int capacidad = regEnt.getInt();
				int presupuesto = regEnt.getInt();
				Departamento NuevoDepartamento = new Departamento(depto1, capacidad, presupuesto);
				listaNuevaDI.ingesarDptoInstalacion(NuevoDepartamento);
				sistema.crearDpto(depto1, capacidad, presupuesto);	
			}
			resp = sistema.CargarInstalaciones(nombreInstalacion,cantDepartamentos,listaNuevaDI);
		}
		archivoInstalaciones.close();
		return resp;
	}
	public static boolean cargarTXTIngresos(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Ingresos.txt");
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			String rut =  regEnt.getString();
			String fecha =  regEnt.getString();
			String hora = regEnt.getString();
			resp = sistema.CargarIngresos(nombreInstalacion,rut,fecha,hora);
		}
		archivoInstalaciones.close();
		return resp;
	}
	public static boolean cargarTXTEgresos(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Salidas.txt");
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			String rut =  regEnt.getString();
			String fecha =  regEnt.getString();
			String hora = regEnt.getString();
			resp = sistema.CargarSalidas(nombreInstalacion,rut,fecha,hora);
		}
		archivoInstalaciones.close();
		return resp;
	}
	public static boolean cargarTXTProyectos(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoProyecto = new ArchivoEntrada("Proyectos.txt");
		while(!archivoProyecto.isEndFile()){
			Registro regEnt = archivoProyecto.getRegistro();
			String CodigoProyecto = regEnt.getString();
			String NombreProyecto = regEnt.getString();
			int PresupuestoTotal = regEnt.getInt();
			String DptoResponsable = regEnt.getString();
			int  CantAreasEspecializacion = regEnt.getInt();
			ListaAreaEspecializacion  listaEspecializacion = new ListaAreaEspecializacion(CantAreasEspecializacion);
			for(int i =0; i<CantAreasEspecializacion;i++) {
				String areas = regEnt.getString();
				AreaEspecializacion ObjetoArea = new AreaEspecializacion(areas);				
				boolean realizado = listaEspecializacion.ingresarEspecializacion(ObjetoArea);
			}
			resp = sistema.CargarProyectos(CodigoProyecto,NombreProyecto,PresupuestoTotal,DptoResponsable,CantAreasEspecializacion,listaEspecializacion);
		}
		archivoProyecto.close();
		return resp;
	}
	public static boolean cargarTXTCientifico(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoCientifico = new ArchivoEntrada("Cientificos.txt");
		while(!archivoCientifico.isEndFile()){
			Registro regEnt = archivoCientifico.getRegistro();
			String Rut = regEnt.getString();
			String Nombre = regEnt.getString();
			String ApellidoP = regEnt.getString();
			String ApellidoM = regEnt.getString();
			String Area = regEnt.getString();
			int CostoAsociado =  regEnt.getInt();
			String codProyecto = regEnt.getString();
			resp = sistema.CargarCientifico(Rut, Nombre, ApellidoP, ApellidoM, Area, CostoAsociado,codProyecto);
		}
		archivoCientifico.close();
		return resp;
	}	
	public static boolean loadTXT(SystemSusto System) throws IOException {
		boolean resp1,resp2,resp3,resp4,resp5;
		resp1=cargarTXTInstalaciones(sistema);
		resp2=cargarTXTProyectos(sistema);
		resp3=cargarTXTCientifico(sistema);
		resp4 = cargarTXTIngresos(sistema);
		resp5 = cargarTXTEgresos(sistema);
		if(resp1==true && resp2 ==true && resp3 == true && resp4 ==true && resp5 == true) {
			return true;
		}else {
			return false;
		}
	}	
	public static void menu(SystemSusto System) {
		displayMenu(); 
	        StdOut.println("Enter a choice: ");
	        int op = validateOption();
	        boolean cargoTXT = false;
	        while(op!=6){  	
	            switch(op){
	                case 1:
	                	boolean respTXT = false;
	                	cargoTXT = true;
	                	respTXT=cargarTXT(sistema);
	                	if(respTXT) {
	                		StdOut.println("Datos cargados exitosamente");                		
	                	}else {
	                		StdOut.println("Revise la carpeta de los archivos TXT");
	                	}
	                break;
	                case 2:
	                	if(cargoTXT == true) {
	                		menuCrearNuevasEntidades(sistema);                		
	                	}else {
	                		StdOut.println("Debe cargar los arhivos txt!");
	                	}
	                break;
	                case 3:
	                	if(cargoTXT == true) {
	                		menuEntradaSalida(sistema);                		
	                	}else {
	                		StdOut.println("Debe cargar los arhivos txt!");
	                	}
	                break;
	                case 4:
	                	if(cargoTXT == true) {
	                		menuReasignarCientifico(sistema);                		
	                	}else {
	                		StdOut.println("Debe cargar los arhivos txt!");
	                	}
	                break;
	                case 5:
	                	if(cargoTXT == true) {
	                		menuReportesDePersonalYCostos(sistema);              		
	                	}else {
	                		StdOut.println("Debe cargar los arhivos txt!");
	                	}
	                break;
	                case 6:
	                	
	                	StdOut.println("Muchas gracias por ocupar sistema SUSTO ");
	                break;
	            }
	            desplegarMenu();
	            StdOut.println("Ingrese una opción ");
	            op = validarOpcion();
	        }
	        ActualizarTXT(sistema);
		
	}
	
	public static void main(String []args) {
		SystemSusto System =  new SystemSustoImpl();
		displayMenu();
		StdOut.println("Insert the date: (dd/MM/yyyy) :");
		String dateStr = StdIn.readString();
		boolean resultado = validarFecha(sistema,dateStr);

		while(!resultado) {
			StdOut.println("Ingrese fecha actual!");
			dateStr = StdIn.readString();
			resultado = validarFecha(sistema,dateStr);

		}
		menu(System);
	}
}