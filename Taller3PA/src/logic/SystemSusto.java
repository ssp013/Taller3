package logic;

/**
 * @author ssp013
 *
 */

import java.io.IOException;
import java.text.ParseException;

import ucn.ArchivoEntrada;
public interface SystemSusto {
	public boolean CretateInstallation(String nameInstallation, int quantityDpto,String [] listDepto,int [] listCapacity,int [] listBudget);
	// Description: Create a new installation.
	// Preconditions: Installation to create must not exist in the general list of facilities.
	// PostConditions: Installation created.
	public boolean createDepartment(String nameDpto, int Capacity, int budget);
	// Description: Create a new Department.
	// Preconditions: Department to create must not exist in the general Department list.
	// PostConditions: Department created
	public boolean reallocateScientificProject(String rut, String codOld, String codNew);
	// Description: Reassignment of project (s) to a scientist.
	// Preconditions: The scientist must be in the general list of scientists. ProyectoA must be on the list of scientific projects. ProyectoN must be on the general list of projects.
	// PostConditions: Reassignment done.
	public boolean reallocateScientificInstallation(String rut, String nameInstallationOld, String nameInstallationNew);
	// Description: Reassignment of an installation to a scientist.
	// Precondition: The scientist must be in the general list of scientists. Nomination must be on the scientist's facilities list. Nomination must be on the general list of scientists.
	// PostConditions: Reassignment done.
	public boolean isValid(String dateStr);
	// Description: Verify that the date format is correct and that date exists, for example, rejects a February 32
	// Precondition:
	// PostConditions: Date validated.
	public boolean CreateProjects(String codeProyect,String nameProject,int budget,String DeptoResp,int quantityAreas,String[] listAreas );
	// Description: Create a project object, take out its area of ​​expertise and save it in your list of areas of expertise. Upload to general list of projects
	// Precondition:
	// PostConditions: loaded object
	public boolean CreateScientist(String Rut, String Nombre,String  ApellidoP, String ApellidoM, String Area, int CostoAsociado,String codProyecto);
	// Description: create a scientific object and upload it to the general list of scientists.
	// Precondition:
    // PostConditions: loaded object	
	public boolean isValidDate(String dateStr);
	// Description: Verify that the date format is correct and that date exists
	// Precondition:
	// PostConditions: Date validated.
	public boolean RegistryScientist(String nameInstallation,String Rut,String DateIn, String DateOut,String HourIn, String HourOut);
	// Description: Register a scientist and add it to the general list of scientists
	// Precondition:
	// PostConditions: scientist added to the general list of scientists
	public boolean CreateAreas(String nameAreas);
	// Description: create an area and add it to the general list of areas
	// Precondition:
	// Postcondition: area added to the general list of areas
	public boolean existsOrNotInstallation(String nameInstallation);
	//Description: Check if an installation exist(true) or not exist(false).
	//Precondition:
	//Postcondition:
	public boolean existsOrNotDepartment(String nameDepartment);
	//Description: Check if an department exist(true) or not exist(false)
	//Precondition:
	//Postcondition:
	public boolean existsOrNotScientist(String rut);
	//Description: Check if an scientist exist(true) or not exist(false)
	//Precondition:
	//Postcondition:
	public boolean existsOrNotProject(String code);
	//Description: Check if an project exist(true) or not exist(false)
	//Precondition:
	//Postcondition:
	public boolean existsOrArea(String nameArea);
	//Description: Check if an area exist(true) or not exist(false)
	//Precondition:
	//Postcondition:
	public boolean HiringScientist(String Rut,String name, String lastname, String MotherLastName, String Area ,int AssociateCost,String department,String installation,int n,String [] listProjectScientist );
	//Description: Hire a new scientist
	//Precondition: Scientist is not in the general list of scientists
	//Postcondition: Hired Scientist
	public boolean EnlistIncome(String installation,String Rut,String dateIn,String timeIn,String dateOut,String timeOut);
	//Description: Record the entrance to an installation
	//Precondition: Installation exist
	//Postcondition: Registered income
	public boolean EnlistExit(String installation,String Rut,String dateIn,String timeIn,String dateOut,String timeOut);
	//Description: Record the output of an installation
	//Precondition: Installation exist
	//Postcondition: Registered output
	public String displayListPersonalDepartmentPrint();
	//Description: Show the list of departament staff
	//Precondition:
	//Postcondition:
	public String displayListPersonalInstallationPrint();
	//Description: Show de list of installation staff
	//Precondition:
	//Postcondition:
	public String Movements();
	//Description: Register hiring and reassignments
	//Precondition:
	//Postcondition:
	public String displayprojectListing();
	//Description: Show the list of projects
	//Precondition:
	//Postcondition:
	public String CostPerProject(String CodeProject);
	//Description: Calculate project costs
	//Precondition:
	//Postcondition: Costs calculated
	public String  HoursWorked() throws ParseException;
	//Description: Calculate the hours worked by the staff
	//Precondition:
	//Postcondition: Hours calculated
	public void TXTScientist() throws IOException;
	//Description: Create an output file with a list of all scientists
	//Precondition:
	//Postcondition:
	public void TXTProject() throws IOException;
	//Description: Create an output file with a list of all projects 
	//Precondition:
	//Postcondition:
	public void TXTInstallations() throws IOException;
	//Description: Create an output file with a list of all installations
	//Precondition:
	//Postcondition:
	public void TXTRegistry() throws IOException;
	//Description: Create an output file with the income and exist of the installations  
	//Precondition:
	//Postcondition:
	public void TXTBackdoor1() throws IOException;
	//Description: Create an output file with the list of a names installations, code and names of projects  and the name and last name of the scientists
	//Precondition:
	//Postcondition:
	public void TXTBackdoor2() throws IOException;
	//Description: Create an output file with the list of a any movements in the system
	//Precondition:
	//Postcondition:
	
}
