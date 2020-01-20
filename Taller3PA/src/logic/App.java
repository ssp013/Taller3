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
	public static boolean validateDate(SystemSusto System,String dateStr) {
		boolean result = System.isValid(dateStr);
		if(result) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean validateDate2(SystemSusto System,String dateStr) {
		boolean result = System.isValidDate(dateStr);
		if(result) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean validarRut(String rut) {
		boolean validacion = false;
		try {
		rut =  rut.toUpperCase();
		rut = rut.replace(".", "");
		rut = rut.replace("-", "");
		int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
		char dv = rut.charAt(rut.length() - 1);
		int m = 0, s = 1;
		for (; rutAux != 0; rutAux /= 10) {
		s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		}
		if (dv == (char) (s != 0 ? s + 47 : 75)) {
		validacion = true;
		}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
		}	
    public static boolean validarHora(String hora){
    	boolean valido = false;
        try{
            LocalTime.parse(hora);
            valido= true;
        }catch(DateTimeParseException|NullPointerException e){
          
        } 
        return valido;
    }	
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
		ArchivoEntrada txtInsta = new ArchivoEntrada("Installation.txt");
		while(!txtInsta.isEndFile()){
			Registro regEnt = txtInsta.getRegistro();
		
			String nameInstallation = regEnt.getString(); 
			int quantityDpto =  regEnt.getInt();
			
			String [] listDepto = new String[quantityDpto];
			int [] listCapacity = new int[quantityDpto];
			int [] listBudget = new int[quantityDpto];
			
			for(int i=0;i<quantityDpto;i++) {
				
				listDepto[i]=regEnt.getString();
				listCapacity[i]=regEnt.getInt();
				listBudget[i]=regEnt.getInt();	
			}
			resp= System.CretateInstallation(nameInstallation, quantityDpto, listDepto,listCapacity,listBudget);
		}
		txtInsta.close();
		return resp;
	}
	public static boolean loadTXTProjects(SystemSusto System) throws IOException {
		boolean resp = false;
		ArchivoEntrada archProjects = new ArchivoEntrada("Projects.txt");
		while(!archProjects.isEndFile()){
			Registro regEnt = archProjects.getRegistro();
			String codeProject = regEnt.getString();
			String nameProject = regEnt.getString();
			int budget = regEnt.getInt();
			String deptoResp = regEnt.getString();
			int  QuantityAreas = regEnt.getInt();
			String[] listAreas = new String[QuantityAreas];
			for(int i =0; i<QuantityAreas;i++) {
				listAreas[i] = regEnt.getString();				
			}
			resp = System.CreateProjects(codeProject,nameProject,budget,deptoResp,QuantityAreas,listAreas);
		}
		archProjects.close();
		return resp;
	}
	public static boolean loadTXTScientist(SystemSusto System) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoCientifico = new ArchivoEntrada("Cientificos.txt");
		while(!archivoCientifico.isEndFile()){
			Registro regEnt = archivoCientifico.getRegistro();
			String Rut = regEnt.getString();
			String Name = regEnt.getString();
			String LastName = regEnt.getString();
			String MotherLastName = regEnt.getString();
			String Area = regEnt.getString();
			int AssociatedCost =  regEnt.getInt();
			String CodProject = regEnt.getString();
			resp = System.CreateScientist(Rut, Name, LastName, MotherLastName, Area, AssociatedCost,CodProject);
		}
		archivoCientifico.close();
		return resp;
	}
	public static boolean RegistryScientist(SystemSusto System) throws IOException {
		boolean resp = false;
		ArchivoEntrada arch = new ArchivoEntrada("Ingresos.txt");
		while(!arch.isEndFile()){
			Registro regEnt = arch.getRegistro();
			String nameInstallation = regEnt.getString(); 
			String Rut =  regEnt.getString();
			String DateIn =  regEnt.getString();
			String DateOut =  regEnt.getString();
			String HourIn = regEnt.getString();
			String HourOut = regEnt.getString();
			resp = System.RegistryScientist(nameInstallation,Rut,DateIn,DateOut,HourIn,HourOut);
		}
		arch.close();
		return resp;
	}
	public static boolean loadTXT(SystemSusto System) throws IOException {
		boolean resp1,resp2,resp3,resp4;
		resp1=loadTXTInstallation(System);
		resp2=loadTXTProjects(System);
		resp3=loadTXTScientist(System);
		resp4 = RegistryScientist(System);
		if(resp1==true && resp2 ==true && resp3 == true && resp4 ==true) {
			return true;
		}else {
			return false;
		}
	}		
	public static void getTxtScientist(SystemSusto System)throws IOException{

	}
	public static void getTxtProjects(SystemSusto System)throws IOException{

	}
	public static void getTxtInstallation(SystemSusto System)throws IOException{
		
	}
	public static void toUpdateTXT(SystemSusto System)throws IOException{
		getTxtScientist(System);
		getTxtProjects(System);
		getTxtInstallation(System);
	}
	public static void menu(SystemSusto System) throws IOException {
			displayMenu(); 
	        StdOut.println("Enter a choice: ");
	        int op = validateOption();
	        boolean loadsTXT = false;
	        while(op!=6){  	
	            switch(op){
	                case 1:
	                	boolean respTXT = false;
	                	loadsTXT = true;
	                	respTXT=loadTXT(System);
	                	if(respTXT) {
	                		StdOut.println("Data loaded successfully");                		
	                	}else {
	                		StdOut.println("Check the TXT files folder");
	                	}
	                break;
	        /*        case 2:
	                	if(loadsTXT == true) {
	                		menuCrearNuevasEntidades(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 3:
	                	if(loadsTXT == true) {
	                		menuEntradaSalida(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 4:
	                	if(loadsTXT == true) {
	                		menuReasignarCientifico(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 5:
	                	if(loadsTXT == true) {
	                		menuReportesDePersonalYCostos(System);              		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	            */
	                case 6:
	                	StdOut.println("Thank you very much for occupying SUSTO system ");
	                	break;
	            }
	            displayMenu();
	            StdOut.println("Insert a option:  ");
	            op = validateOption();
	        }
	        toUpdateTXT(System);
	        
	}
	public static void main(String []args) throws IOException {
		StdOut.println("******** Welcome to the SUSTO system ********");
		SystemSusto System =  new SystemSustoImpl();
		StdOut.println("Insert the date: (dd/MM/yyyy) :");
		String dateStr = StdIn.readString();
		boolean result = validateDate(System,dateStr);
		while(!result) {
			StdOut.println("Enter current date!");
			dateStr = StdIn.readString();
			result = validateDate(System,dateStr);
		}
		menu(System);
	}
}