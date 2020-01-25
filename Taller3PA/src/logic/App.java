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
		StdOut.println (" 1.Create Installation\n 2.Create Department\n 3. Hire Scientist\n 4. Exit");
	}

	public static void CreateInstallation(SystemSusto System) {
		StdOut.println("Insert the name of the Installation:");
		String NameInstallation = StdIn.readString();
		if(System.existsOrNotInstallation(NameInstallation)){	
			StdOut.println ("Enter the number of departments the facility has");
			int QuantityDeptos = validateOption();
			
			String [] listDepto = new String[QuantityDeptos];
			int [] listCapacity = new int[QuantityDeptos];
			int [] listBudget = new int[QuantityDeptos];
			
			for(int i=0;i<QuantityDeptos;i++) {
				StdOut.println("Enter the name of the Department: ");
				listDepto[i]=StdIn.readString();
				StdOut.println("Enter the Capacity of the Department: ");
				listCapacity[i]=validateOption();
				StdOut.println("Enter the budget of the Department: ");
				listBudget[i]=validateOption();
				
			}
			
			boolean resp = System.CretateInstallation(NameInstallation, QuantityDeptos, listDepto, listCapacity, listBudget);
			if(resp== true) {
				StdOut.println("successful income!");
			}else {
				StdOut.println("erroneous income!");
			}
		}else {
			StdOut.println("The installation already exists "+NameInstallation+" !");
		}
	}

	
	public static void CreateDepartment (SystemSusto System)throws IOException {
		StdOut.println("Insert the name of the Department:");
		String NameDepartment = StdIn.readString();
		if(System.existsOrNotDepartment(NameDepartment)) {
			StdOut.println("Enter the capacity of the department: ");
			int capacity = validateOption();
			StdOut.println("Enter the budget of the department: ");
			int budget = validateOption();
			if(System.createDepartment(NameDepartment,capacity,budget)) {
				StdOut.println("Successful income!");
			}else {
				StdOut.println("Erroneous income!");
			}
		}else {
			StdOut.println("The department already exists "+NameDepartment+" !");
		}
	}
	public static void HireScientist (SystemSusto System)throws IOException {
		StdOut.println("Enter Rut of the Scientist (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean answer=validarRut(rut);
		while(answer != true) {
			StdOut.println("ERROR!: Enter Rut of the Scientist (XX.XXX.XXX-X):");
			rut = StdIn.readString();
			answer=validarRut(rut);
		}
		if(System.existsOrNotScientist(rut)) {
			StdOut.println("Enter the name of Scientist:");
			String name = StdIn.readString();
			
			StdOut.println("Enter the last Name of Siencitst ");
			String lastname = StdIn.readString();
			
			StdOut.println("Enter the mother last name  of Scientist ");
			String motherLastName = StdIn.readString();
			
			StdOut.println("Enter your area of expertise: ");
			String Area = StdIn.readString();
			
			while(System.existsOrArea(Area)){
				StdOut.println("Error! Enter your area of expertise: ");
				Area = StdIn.readString();
			}
			
			StdOut.println("Enter the associate cost: ");
			int AssociateCost = validateOption();
			
			StdOut.println("Enter the department that will be assigned  "+name+" "+lastname+" : ");
			String department = StdIn.readString();
			while(System.existsOrNotDepartment(department)){
				StdOut.println("Error! Enter the department that will be assigned  "+name+" "+lastname+" : ");
				department = StdIn.readString();
			}
			
			
			StdOut.println("Enter the Installation that will be assigned to "+name+" "+lastname+" : ");
			String installation = StdIn.readString();
			while(System.existsOrNotInstallation(installation)){
				StdOut.println("ERROR! Enter the Installation that will be assigned to "+name+" "+lastname+" : ");
				installation = StdIn.readString();
			}
			//Solicitar los proyectos a los cuáles se asignará:
			StdOut.println("Enter quantity of projects : ");
			int n = validateOption();	
			String [] listProjectScientist = new String[n];
			for(int i=0;i<n;i++) {
				int r = i+1;
				StdOut.println("Enter Code of the project Nº "+r+" :");
				listProjectScientist[i] = StdIn.readString();
				while(System.existsOrNotProject(listProjectScientist[i])){
					StdOut.println("Error! Enter Code of the project Nº \"+r+\" : ");
					listProjectScientist[i] = StdIn.readString();
				}	
				
			}
			if(System.HiringScientist(rut,name,lastname,motherLastName,Area , AssociateCost,department,installation,n,listProjectScientist )) {
				StdOut.println("Successful income!");
			}else {
					StdOut.println("Erroneous income!");
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
                	StdOut.println("Out!");
                break;

            }
            
            displayMenuCreateNewEntities();
            option = validateOption();
        }	
	}
	public static void  EnlistIncome(SystemSusto System) {
		StdOut.println("Enter the name of the installation ");
		String installation = StdIn.readString();
		while(System.existsOrNotInstallation(installation)){
			StdOut.println("Error! Enter a correct name of the installation ");
			installation = StdIn.readString();
		}
		
		StdOut.println("Enter the Rut of the Scientist: ");
		String Rut = StdIn.readString();
		while(System.existsOrNotScientist(Rut)){
			StdOut.println("Error! Enter the Rut of the Scientist: ");
			Rut = StdIn.readString();
		}			
		
		StdOut.println("Enter the Date (dd/MM/yyyy) : ");
		String dateIn = StdIn.readString();
		boolean result = validateDate2(System,dateIn);
		while(!result) {
			StdOut.println("Error! Enter the Date (dd/MM/yyyy) :");
			dateIn = StdIn.readString();
			result = validateDate2(System,dateIn);
		}
		
		
		StdOut.println("Enter the hour (hh:mm) : ");
		String timeIn = StdIn.readString();
		boolean ValidateTimeIN = validateTime(timeIn);
		while(!ValidateTimeIN) {
			StdOut.println("Error! Enter the correct hour (hh:mm)");
			timeIn = StdIn.readString();
			ValidateTimeIN = validateTime(timeIn);
		}
		if(System.EnlistIncome(installation,Rut,dateIn,timeIn,"0","0")) {
			StdOut.println("Successful income!");
		}else {
				StdOut.println("Erroneous income!");
		}
		
	}
	public static void  EnlistExit(SystemSusto System) {
		StdOut.println("Enter the name of the installation ");
		String installation = StdIn.readString();
		while(System.existsOrNotInstallation(installation)){
			StdOut.println("Error! Enter a correct name of the installation ");
			installation = StdIn.readString();
		}
		
		StdOut.println("Enter the Rut of the Scientist: ");
		String Rut = StdIn.readString();
		while(System.existsOrNotScientist(Rut)){
			StdOut.println("Error! Enter the Rut of the Scientist: ");
			Rut = StdIn.readString();
		}			
		
		StdOut.println("Enter the Date Out(dd/MM/yyyy) : ");
		String dateOut = StdIn.readString();
		boolean result = validateDate2(System,dateOut);
		while(!result) {
			StdOut.println("Error! Enter the Date Out (dd/MM/yyyy) :");
			dateOut = StdIn.readString();
			result = validateDate2(System,dateOut);
		}
		
		
		StdOut.println("Enter the hour Out (hh:mm) : ");
		String timeOut = StdIn.readString();
		boolean ValidateTimeIN = validateTime(timeOut);
		while(!ValidateTimeIN) {
			StdOut.println("Error! Enter the correct hour Out(hh:mm)");
			timeOut = StdIn.readString();
			ValidateTimeIN = validateTime(timeOut);
		}
		
		if(System.EnlistExit(installation,Rut,"0","0",dateOut,timeOut)) {
			StdOut.println("Successful income!");
		}else {
				StdOut.println("Erroneous income!");
		}
	}
	public static void menuInputOutput(SystemSusto System) {
		StdOut.println("1.Register Entry\n 2. Register Output\n 3. Go out ");
		StdOut.println("Enter an option: ");
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
    		StdOut.println("1.Register Entry\n 2. Register Output\n 3. Go out ");
    		StdOut.println("Enter an option: ");
            op = validateOption();
        }
		
	}
	public static void reallocateScientificProject(SystemSusto System) {
		StdOut.println("Enter the scientist's rut (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean answer=validarRut(rut);
		while(answer != true) {
			StdOut.println("Error! Enter the scientist's rut (XX.XXX.XXX-X) : ");
			rut = StdIn.readString();
			answer=validarRut(rut);
		}
		
		StdOut.println("Enter the code of the previous project:");
		String codProjOld = StdIn.readString();
		while(System.existsOrNotProject(codProjOld)){
			StdOut.println("Error! Enter the code of the previous project: ");
			codProjOld = StdIn.readString();
		}			
		
		
		StdOut.println("Enter the code of the new project:");
		String codprojNew= StdIn.readString();
		while(System.existsOrNotProject(codprojNew)){
			StdOut.println("Error! Enter the code of the new project: ");
			codprojNew = StdIn.readString();
		}	
		
		if( System.reallocateScientificProject(rut, codProjOld, codprojNew)   ) {
			StdOut.println("Successful income!");
		}else {
				StdOut.println("Erroneous income!");
		}
	}
	public static void reallocateScientificInstallation(SystemSusto System) {
		StdOut.println("Enter the scientist's rut (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean answer=validarRut(rut);
		while(answer != true) {
			StdOut.println("Error! Enter the scientist's rut (XX.XXX.XXX-X) : ");
			rut = StdIn.readString();
			answer=validarRut(rut);
		}
		
		StdOut.println("Enter the name of the previous Installation:");
		String instaOld = StdIn.readString();
		while(System.existsOrNotInstallation(instaOld)){
			StdOut.println("Error! Enter the name of the previous Installation: ");
			instaOld = StdIn.readString();
		}			
		
		
		StdOut.println("Enter the name of the new Installation:");
		String instaNew= StdIn.readString();
		while(System.existsOrNotInstallation(instaNew)){
			StdOut.println("Error! Enter the name of the new Installation: ");
			instaNew = StdIn.readString();
		}	
		
		if( System.reallocateScientificInstallation(rut, instaOld, instaNew)   ) {
			StdOut.println("Successful income!");
		}else {
				StdOut.println("Erroneous income!");
		}	
	}
	public static void ScientificReassignmenu(SystemSusto System) {
		StdOut.println("1.Reassign scientist by project\n 2. Reassign scientist by installation\n 3. Leave");
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
            		StdOut.println("successful exit!");
                break;
            }
            StdOut.println("1.Reassign scientist by project\n 2. Reassign scientist by installation\n 3. Leave");
            StdOut.println("Enter a option: ");
            op = validateOption();
        }
    }
	public static void toUpdateTXT(SystemSusto System)throws IOException{
		System.TXTInstallations();
		System.TXTProject();
		System.TXTScientist();
	}
	public static void displayMenuReports() {
		StdOut.println("1.Personnel list\n 2.Project list\n 3.Costs per project\n 4.Hours worked\n 5.Movements\n 6.Exit");
	}
	public static void displayListPersonal() {
		StdOut.println("1.for Installation\n 2.for Project\n  3.Exit");
	}
	public static void displayListPersonalInstallation(SystemSusto System) {
		StdOut.println(System.displayListPersonalInstallationPrint());
	}
	public static void displayListPersonalDepartment(SystemSusto System) {
		StdOut.println(System.displayListPersonalDepartmentPrint());
	}
	public static void PersonnelListing(SystemSusto System) {
		displayListPersonal();
        StdOut.println("Enter a option:  ");
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
                	StdOut.println("successful exit!");
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
		StdOut.println("Enter the code of the project:");
		String CodeProject= StdIn.readString();
		while(System.existsOrNotProject(CodeProject)){
			StdOut.println("Error! Enter the code of the project: ");
			CodeProject = StdIn.readString();
		}
		
		StdOut.println(System.CostPerProject(CodeProject));
	}
	
	
	  	
	public static void MenuReports(SystemSusto System)throws IOException, ParseException  {
		displayMenuReports();
        StdOut.println("Enter a option:  ");
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
                	StdOut.println("successful exit!");
                break;
            }
            displayMenuReports();
        	option = validateOption();
        }
	}
	public static void menu(SystemSusto System) throws IOException, ParseException {
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
	       
	                		//StdOut.println(System.toDeployListProject());
	                		//StdOut.println(System.toDeployListArea());
	                		//StdOut.println(System.toDeployListDepartment());
	                		//StdOut.println(System.toDeployListScientist());
	                		
	                		//StdOut.println(System.toDeployListInstallation());
	                		//StdOut.println(System.toDeployListRegistry());
	                	}else {
	                		StdOut.println("Check the TXT files folder");
	                	}
	                break;
	                case 2:
	                	if(loadsTXT == true) {
	                		CreateNewEntitiesMenu(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 3:
	                	if(loadsTXT == true) {
	                		menuInputOutput(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 4:
	                	if(loadsTXT == true) {
	                		ScientificReassignmenu(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 5:
	                	if(loadsTXT == true) {
	                		MenuReports(System);                		
	                	}else {
	                		StdOut.println("You must load the txt files!");
	                	}
	                break;
	                case 6:	                	
	                	StdOut.println("Thank you very much for occupying SUSTO system ");
	                break;
	            }
	            displayMenu();
	            StdOut.println("Insert a option:  ");
	            op = validateOption();
	            
        		/*StdOut.println(System.toDeployListProject());
        		StdOut.println(System.toDeployListArea());
        		StdOut.println(System.toDeployListDepartment());
        		StdOut.println(System.toDeployListScientist());
        		
        		StdOut.println(System.toDeployListInstallation());
        		StdOut.println(System.toDeployListRegistry());*/
	        }
	        toUpdateTXT(System);
	}
	public static void main(String []args) throws IOException, ParseException {
		StdOut.println("******** Welcome to the SUSTO system ********");
		SystemSusto System =  new SystemSustoImpl();
		/*StdOut.println("Insert the date: (dd/MM/yyyy) :");
		String dateStr = StdIn.readString();
		boolean result = validateDate(System,dateStr);
		while(!result) {
			StdOut.println("Enter current date!");
			dateStr = StdIn.readString();
			result = validateDate(System,dateStr);
		}*/
		menu(System);
	}
}