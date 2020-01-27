 /**
  * General App 
  * @author  Sebatián Sánchez - Tomás Sandoval
  * @param App.java
  * @throws IllegalArgumentException
  */
package logic;

import ucn.*;

import java.io.File;
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
    public static boolean validateTime(String hora){
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
			    System.out.print("Error ingrese una opción!");
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
		StdOut.print("1. Cargar archivos\n2. Crear nuevas entidades\n3. Registrar entrada y salida\n4.Reasignar científico\n5.Informes de personal y costos\n6. Cierre del sistema\n");
		StdOut.println("The program admit writing the following commands: save, clean, print, exploit");
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
				System.createDepartment(listDepto[i], listCapacity[i], listBudget[i]);
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
				System.CreateAreas(listAreas[i]);
			}
			resp = System.CreateProjects(codeProject,nameProject,budget,deptoResp,QuantityAreas,listAreas);
		}
		archProjects.close();

		return resp;
	}
	public static boolean loadTXTScientist(SystemSusto System) throws IOException {
		boolean resp = false;
		ArchivoEntrada archScientist = new ArchivoEntrada("Scientist.txt");
		
		while(!archScientist.isEndFile()){
			
			Registro regEnt = archScientist.getRegistro();
			String Rut = regEnt.getString();
			String Name = regEnt.getString();
			String LastName = regEnt.getString();
			String MotherLastName = regEnt.getString();
			String Area = regEnt.getString();
			int AssociatedCost =  regEnt.getInt();
			String CodProject = regEnt.getString();
			resp = System.CreateScientist(Rut, Name, LastName, MotherLastName, Area, AssociatedCost,CodProject);

		}
		
		archScientist.close();
		return resp;
	}
	public static boolean RegistryScientist(SystemSusto System) throws IOException {
		boolean resp = false;
		ArchivoEntrada arch = new ArchivoEntrada("Registry.txt");
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
		
		if(resp1==true && resp2 ==true && resp3 == true &&  resp4 ==true) {
			return true;
		}else {
			return false;
		}
	}		
	public static void displayMenuCreateNewEntities() {
		StdOut.println (" 1.Crear instalación\n 2.Crear Departamento\n 3. Contratar Cientifico\n 4. salir");
	}

	public static void CreateInstallation(SystemSusto System) {
		StdOut.println("Ingrese el nombre de la instalación: ");
		String NameInstallation = StdIn.readString();
		if(System.existsOrNotInstallation(NameInstallation)){	
			StdOut.println ("Ingrese la cantidad de departamentos: ");
			int QuantityDeptos = validateOption();
			
			String [] listDepto = new String[QuantityDeptos];
			int [] listCapacity = new int[QuantityDeptos];
			int [] listBudget = new int[QuantityDeptos];
			
			for(int i=0;i<QuantityDeptos;i++) {
				StdOut.println("Ingrese el nombre del departamento: ");
				listDepto[i]=StdIn.readString();
				StdOut.println("Ingrese la capacidad del departamento: ");
				listCapacity[i]=validateOption();
				StdOut.println("Ingrese el presupuesto del departamento:  ");
				listBudget[i]=validateOption();
				
			}
			
			boolean resp = System.CretateInstallation(NameInstallation, QuantityDeptos, listDepto, listCapacity, listBudget);
			if(resp== true) {
				StdOut.println("ingreso correcto!");
			}else {
				StdOut.println("ingreso incorrecto!");
			}
		}else {
			StdOut.println("La instalación ya existe "+NameInstallation+" !");
		}
	}

	
	public static void CreateDepartment (SystemSusto System)throws IOException {
		StdOut.println("Ingrese el nombre del departamento: ");
		String NameDepartment = StdIn.readString();
		if(System.existsOrNotDepartment(NameDepartment)) {
			StdOut.println("EIngrese la capacidad del departamento: ");
			int capacity = validateOption();
			StdOut.println("Ingrese el presupuesto del departamento: ");
			int budget = validateOption();
			if(System.createDepartment(NameDepartment,capacity,budget)) {
				StdOut.println("ingreso correcto!");
			}else {
				StdOut.println("ingreso incorrecto!");
			}
		}else {
			StdOut.println("El Departamento ya existe "+NameDepartment+" !");
		}
	}
	public static void HireScientist (SystemSusto System)throws IOException {
		StdOut.println("Ingrese el rut del cientifico (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean answer=validarRut(rut);
		while(answer != true) {
			StdOut.println("ERROR!: Ingrese el rut del cientifico (XX.XXX.XXX-X):");
			rut = StdIn.readString();
			answer=validarRut(rut);
		}
		if(System.existsOrNotScientist(rut)) {
			StdOut.println("Ingrese el nombre del cientifico: ");
			String name = StdIn.readString();
			
			StdOut.println("Ingrese el primero apellido:  ");
			String lastname = StdIn.readString();
			
			StdOut.println("Ingrese el segundo apellido: ");
			String motherLastName = StdIn.readString();
			
			StdOut.println("Ingrese su area de especialización: ");
			String Area = StdIn.readString();
			
			while(System.existsOrArea(Area)){
				StdOut.println("Error! Ingrese su area de especialización: ");
				Area = StdIn.readString();
			}
			
			StdOut.println("Ingrese el costo asosciado: ");
			int AssociateCost = validateOption();
			
			StdOut.println("Ingrese el departamento que será asignado  "+name+" "+lastname+" : ");
			String department = StdIn.readString();
			while(System.existsOrNotDepartment(department)){
				StdOut.println("Error! Ingrese el departamento que será asignado  "+name+" "+lastname+" : ");
				department = StdIn.readString();
			}
			
			
			StdOut.println("Ingrese la instalación que será asginado  "+name+" "+lastname+" : ");
			String installation = StdIn.readString();
			while(System.existsOrNotInstallation(installation)){
				StdOut.println("ERROR! Ingrese la instalación que será asginado "+name+" "+lastname+" : ");
				installation = StdIn.readString();
			}
			//Solicitar los proyectos a los cuáles se asignará:
			StdOut.println("Ingrese la cantidad de proyectos : ");
			int n = validateOption();	
			String [] listProjectScientist = new String[n];
			for(int i=0;i<n;i++) {
				int r = i+1;
				StdOut.println("Ingrese el código del proyecto Nº "+r+" :");
				listProjectScientist[i] = StdIn.readString();
				while(System.existsOrNotProject(listProjectScientist[i])){
					StdOut.println("Error! Ingrese el código del proyecto Nº "+r+" : ");
					listProjectScientist[i] = StdIn.readString();
				}	
				
			}
			if(System.HiringScientist(rut,name,lastname,motherLastName,Area , AssociateCost,department,installation,n,listProjectScientist )) {
				StdOut.println("ingreso correcto!");
			}else {
					StdOut.println("ingreso incorrecto!");
			}
			
		}else {
			StdOut.println("This scientist already exists! Watch out!");
		}
	}
	public static void CreateNewEntitiesMenu(SystemSusto System)throws IOException {
		displayMenuCreateNewEntities();
        StdOut.println("Insert an Option: ");
        int option = validateOption();
        while(option!=4){
            switch(option){
                case 1:
                	CreateInstallation(System);
                break;
                case 2:
                	CreateDepartment(System);
                break;
                case 3:
                	HireScientist(System);
            
                	
                break;
                case 4:
                	StdOut.println("Salir!");
                break;

            }
            
            displayMenuCreateNewEntities();
            option = validateOption();
        }	
	}
	public static void  EnlistIncome(SystemSusto System) {
		StdOut.println("Ingrese el nombre de la isntalación: ");
		String installation = StdIn.readString();
		while(System.existsOrNotInstallation(installation)){
			StdOut.println("Error!Ingrese el nombre de la isntalación: ");
			installation = StdIn.readString();
		}
		
		StdOut.println("Ingrese el rut del cientifico: ");
		String Rut = StdIn.readString();
		while(System.existsOrNotScientist(Rut)){
			StdOut.println("Error! Ingrese el rut del cientifico:  ");
			Rut = StdIn.readString();
		}			
		
		StdOut.println("Ingrese la fecha (dd/MM/yyyy) : ");
		String dateIn = StdIn.readString();
		boolean result = validateDate2(System,dateIn);
		while(!result) {
			StdOut.println("Error! Ingrese la fecha(dd/MM/yyyy) :");
			dateIn = StdIn.readString();
			result = validateDate2(System,dateIn);
		}
		
		
		StdOut.println("Ingrese la hora (hh:mm) : ");
		String timeIn = StdIn.readString();
		boolean ValidateTimeIN = validateTime(timeIn);
		while(!ValidateTimeIN) {
			StdOut.println("Error! Ingrese la hora correcta (hh:mm)");
			timeIn = StdIn.readString();
			ValidateTimeIN = validateTime(timeIn);
		}
		if(System.EnlistIncome(installation,Rut,dateIn,timeIn,"0","0")) {
			StdOut.println("ingreso correcto!");
		}else {
				StdOut.println("ingreso incorrecto!");
		}
		
	}
	public static void  EnlistExit(SystemSusto System) {
		StdOut.println("Ingrese el nombre de la instalación ");
		String installation = StdIn.readString();
		while(System.existsOrNotInstallation(installation)){
			StdOut.println("Error!Ingrese el nombre correcto de la instalación ");
			installation = StdIn.readString();
		}
		
		StdOut.println("Ingrese el rut del científico ");
		String Rut = StdIn.readString();
		while(System.existsOrNotScientist(Rut)){
			StdOut.println("Error! Ingrese el rut del científico: ");
			Rut = StdIn.readString();
		}			
		
		StdOut.println("Ingrese la fecha de salida (dd/MM/yyyy) : ");
		String dateOut = StdIn.readString();
		boolean result = validateDate2(System,dateOut);
		while(!result) {
			StdOut.println("Error! Ingrese la fecha de salida (dd/MM/yyyy) :");
			dateOut = StdIn.readString();
			result = validateDate2(System,dateOut);
		}
		
		
		StdOut.println("Ingrese la hora de salida (hh:mm) : ");
		String timeOut = StdIn.readString();
		boolean ValidateTimeIN = validateTime(timeOut);
		while(!ValidateTimeIN) {
			StdOut.println("Error! ingresar hora de salida correcta(hh:mm)");
			timeOut = StdIn.readString();
			ValidateTimeIN = validateTime(timeOut);
		}
		
		if(System.EnlistExit(installation,Rut,"0","0",dateOut,timeOut)) {
			StdOut.println("ingreso correcto!");
		}else {
				StdOut.println("ingreso incorrecto!");
		}
	}
	public static void menuInputOutput(SystemSusto System) {
		StdOut.println("1.registrar entrada\n 2. registrar salida\n 3. salir ");
		StdOut.println("ingresar opcion: ");
        int op = validateOption();
        while(op!=3){  	
            switch(op){
                case 1:
                	EnlistIncome(System);
                break;
                case 2:
                	EnlistExit(System);
                break;
                case 3:
                break;
            }
    		StdOut.println("1.registrar entrada\n 2. registrar salida\n 3. salir ");
    		StdOut.println("ingresar opcion: ");
            op = validateOption();
        }
		
	}
	public static void reallocateScientificProject(SystemSusto System) {
		StdOut.println("ingrese el rut del cientifico (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean answer=validarRut(rut);
		while(answer != true) {
			StdOut.println("Error! ingrese el rut del cientifico (XX.XXX.XXX-X) : ");
			rut = StdIn.readString();
			answer=validarRut(rut);
		}
		
		StdOut.println("ingrese el codigo del proyecto previo: ");
		String codProjOld = StdIn.readString();
		while(System.existsOrNotProject(codProjOld)){
			StdOut.println("Error! ingrese el codigo del proyecto previo: ");
			codProjOld = StdIn.readString();
		}			
		
		
		StdOut.println("ingrese el codigo del nuevo proyecto: ");
		String codprojNew= StdIn.readString();
		while(System.existsOrNotProject(codprojNew)){
			StdOut.println("Error! ingrese el codigo del nuevo proyecto ");
			codprojNew = StdIn.readString();
		}	
		
		if( System.reallocateScientificProject(rut, codProjOld, codprojNew)   ) {
			StdOut.println("ingreso correcto!");
		}else {
				StdOut.println("ingreso incorrecto!");
		}
	}
	public static void reallocateScientificInstallation(SystemSusto System) {
		StdOut.println("ingrese el rut del cientifico (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean answer=validarRut(rut);
		while(answer != true) {
			StdOut.println("Error! ingrese el rut del cientifico (XX.XXX.XXX-X) : ");
			rut = StdIn.readString();
			answer=validarRut(rut);
		}
		
		StdOut.println("ingrese el nombre de la instalacion previa: ");
		String instaOld = StdIn.readString();
		while(System.existsOrNotInstallation(instaOld)){
			StdOut.println("Error! ingrese el nombre de la instalacion previa: ");
			instaOld = StdIn.readString();
		}			
		
		
		StdOut.println("ingrese el nombre de la nueva instalacion: ");
		String instaNew= StdIn.readString();
		while(System.existsOrNotInstallation(instaNew)){
			StdOut.println("Error! ingrese el nombre de la nueva instalacion: ");
			instaNew = StdIn.readString();
		}	
		
		if( System.reallocateScientificInstallation(rut, instaOld, instaNew)   ) {
			StdOut.println("ingreso correcto!");
		}else {
				StdOut.println("ingreso erroneo!");
		}	
	}
	public static void ScientificReassignmenu(SystemSusto System) {
		StdOut.println("1.reasignar cientifico por proyecto\\n 2. reasignar cientifico por instalacion\\n 3. salir\n");
		int op = validateOption();
        while(op!=3){  	
            switch(op){
            	case 1:
            		reallocateScientificProject(System);
            	break;
            	case 2: 
            		reallocateScientificInstallation(System);
                break;
            	case 3:
            		StdOut.println("salida exitosa!");
                break;
            }
            StdOut.println("1.reasignar cientifico por proyecto\n 2. reasignar cientifico por instalacion\n 3. salir\n");
            StdOut.println("ingrese opcion");
            op = validateOption();
        }
    }
	public static void toUpdateTXT(SystemSusto System)throws IOException{
		System.TXTInstallations();
		System.TXTProject();
		System.TXTScientist();
		System.TXTRegistry();
	}
	public static void displayMenuReports() {
		StdOut.println("1.listado de personal\n 2.listado de proyectos\n 3.costos por proyecto\n 4.horas trabajadas\n 5.movimientos\n 6.salir");
	}
	public static void displayListPersonal() {
		StdOut.println("1.por instalacion\n 2.por proyecto\n  3.salir");
	}
	public static void displayListPersonalInstallation(SystemSusto System) {
		StdOut.println(System.displayListPersonalInstallationPrint());
	}
	public static void displayListPersonalDepartment(SystemSusto System) {
		StdOut.println(System.displayListPersonalDepartmentPrint());
	}
	public static void PersonnelListing(SystemSusto System) {
		displayListPersonal();
        StdOut.println("Ingrese opcion: ");
        int option = validateOption();
        while(option!=3){
            switch(option){
                case 1:
                	displayListPersonalInstallation(System);
                break;
                case 2:
                	displayListPersonalDepartment(System);
                break;
                case 3:
                	StdOut.println("salida exitosa!");
                break;
            }
            displayListPersonal();
        	option = validateOption();
        }
	}
	public static void projectlisting(SystemSusto System) {
		StdOut.println(System.displayprojectListing());
	}
	
	public static void DisCostPerProject(SystemSusto System) {
		StdOut.println("Ingrese el código del proyecto");
		String CodeProject= StdIn.readString();
		while(System.existsOrNotProject(CodeProject)){
			StdOut.println("Error! Ingrese el código del proyecto: ");
			CodeProject = StdIn.readString();
		}
		
		StdOut.println(System.CostPerProject(CodeProject));
	} 	
	public static void MenuReports(SystemSusto System)throws IOException, ParseException  {
		displayMenuReports();
        StdOut.println("Ingres una opción:  ");
        int option = validateOption();
        while(option!=6){
            switch(option){
                case 1:
                	PersonnelListing(System);
                	
                break;
                case 2:
                	projectlisting(System);
                break;
                case 3:
                	DisCostPerProject(System);
                break;
                case 4:
                	StdOut.println( System.HoursWorked() );
                break;
                
                case 5:
                	StdOut.println(System.Movements());
                break;
                case 6:
                	StdOut.println("Salida exitosa!");
                break;
            }
            displayMenuReports();
        	option = validateOption();
        	StdOut.println("Salida exitosa!");
        }
	}
	public static void menu(SystemSusto System) throws IOException, ParseException {
			displayMenu(); 
	        StdOut.println("Ingrese una opción ");
	        String op = StdIn.readString();
	        boolean loadsTXT = false;
	        while(!op.equals("6")) {
	        	if(op.equals("1")){
	        		boolean respTXT = false;
                	loadsTXT = true;
                	respTXT=loadTXT(System);
                	if(respTXT) {
                		StdOut.println("Datos cargados correctamente!");
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}
	        	}else if(op.equals("2")) {
                	if(loadsTXT == true) {
                		CreateNewEntitiesMenu(System);                		
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}
	        	}else if(op.equals("3")) {
                	if(loadsTXT == true) {
                		menuInputOutput(System);                		
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}
	        		
	        	}else if(op.equals("4")) {
                	if(loadsTXT == true) {
                		ScientificReassignmenu(System);                		
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}
	        	}else if(op.equals("5")) {
    
                	if(loadsTXT == true) {
                		MenuReports(System);                		
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}
           
	        	
	        	}else if(op.equals("save")) {
                	if(loadsTXT == true) {
                		StdOut.println("Saved!");
                		System.TXTBackdoor1();
                		System.TXTBackdoor2();
	              		
                	}else {
                		StdOut.println("You must load the txt files!");
                	}
                	
	        	}else if(op.equals("clean")) {
                	if(loadsTXT == true) {
                		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
                		LocalDateTime now = LocalDateTime.now(); 
                		String day = formatter.format(now);	
                		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM");
                		String month = formatter2.format(now);
                		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy");
                		String year = formatter3.format(now);
                		String dateNow = day+"-"+month+"-"+year ;
                		
                		File file = new File("Not_Suspicious_Folder/Not_Suspicious_register_["+dateNow+"].log");
                		File file2 = new File("Not_Suspicious_Folder/Not_Suspicious_file["+dateNow+"].log");
                		boolean del = file.delete();
                		boolean del2 = file2.delete();
                		if(del) {
                			StdOut.println("Not_Suspicious_Folder/Not_Suspicious_register_["+dateNow+"].log Deleted!");
                		}else {
                			StdOut.println("Not deleted!");}
                 		if(del2) {
                			StdOut.println("Not_Suspicious_Folder/Not_Suspicious_file["+dateNow+"].log Deleted!");
                		}else {
                			StdOut.println("Not deleted!");
                		}
	              		
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}
	        	}else if(op.equals("print")) {
	        		if(loadsTXT == true) {        			
	        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	        			LocalDateTime now = LocalDateTime.now(); 
	        			String day = formatter.format(now);	
	        			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM");
	        			String month = formatter2.format(now);
	        			DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy");
	        			String year = formatter3.format(now);
	        			String dateNow = day+"-"+month+"-"+year ;
	        			StdOut.println("***************************************************************************************************************************************");
	        			try {
	                		
	                		String file = "Not_Suspicious_Folder/Not_Suspicious_register_["+dateNow+"].log";
	                		
	                		Scanner input = new Scanner (new File(file));
	                		while(input.hasNextLine()) {
	                			String line = input.nextLine();
	                			StdOut.println(line);
	                		}
	                		input.close();
	                		
	        			}catch(Exception ex) {
	        				ex.printStackTrace();
	        			}
	        			StdOut.println("***************************************************************************************************************************************");
						try {
	                		
	                		String file = "Not_Suspicious_Folder/Not_Suspicious_file["+dateNow+"].log";
	                		Scanner input = new Scanner (new File(file));
	                		while(input.hasNextLine()) {
	                			String line = input.nextLine();
	                			StdOut.println(line);
	                		}
	                		input.close();
	                		
	        			}catch(Exception ex) {
	        				ex.printStackTrace();
	        			}
	        			StdOut.println("***************************************************************************************************************************************");
	        		}else {
	        			StdOut.println("Debes cargar los txt!!");
	        		}
	        	}else if(op.equals("exploit")) {
                	if(loadsTXT == true) {     
                		String red = "\u001B[32m";
                		String reset = "\u001B[0m";
                		Timer obRunTime = new Timer();
                        obRunTime.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            StdOut.println(red+"SYSTEM ERROR"+reset);
                        }
                        },10,10);	
                	}else {
                		StdOut.println("Debes cargar los txt!!");
                	}	        		
	        	
	       
	        	}else if(op.equals("6")) {
	        		
	        		
	        }
	            displayMenu();
	            StdOut.println("Ingrese una opción:   ");
	            op = StdIn.readString();
	        }
	        toUpdateTXT(System);
	        StdOut.println("Gracias por ocupar el sistema ");
	        System.TXTBackdoor1();
	}
	public static void main(String []args) throws IOException, ParseException {
		
		StdOut.println("******** Bienvenido al sistema Susto ********");
		SystemSusto System =  new SystemSustoImpl();
		
		StdOut.println("Ingrese la fecha de hoy : (dd/MM/yyyy) :");
		String dateStr = StdIn.readString();
		boolean result = validateDate(System,dateStr);
		while(!result) {
			StdOut.println("Ingrese la fecha de hoy!");
			dateStr = StdIn.readString();
			result = validateDate(System,dateStr);
		}
		menu(System);
	}
}