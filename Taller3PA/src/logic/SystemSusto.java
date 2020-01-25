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
    //Descripcion: Crea una nueva instalacion.
    //PreCondiciones: Instalacion a crear no debe existir en la lista general de instalaciones.
    //PostCondiciones: Instalacion creada. 	
	public boolean createDepartment(String nameDpto, int Capacity, int budget);
    //Descripcion: Crea un nuevo Departamento.
    //PreCondiciones: Departamento a crear no debe existir en la lista general de Departamento.
    //PostCondiciones: Departamento creado.
	
	public boolean reallocateScientificProject(String rut, String codOld, String codNew);
    //Descripcion: Reasignacion de proyecto(s) a un cientifico.
    //PreCondiciones: El cientifico debe estar en la lista  general de cientificos. ProyectoA debe estar en la lista de proyectos del cientifico. ProyectoN debe estar en la lista general de proyectos.
    //PostCondiciones: Reasignacion hecha.
	public boolean reallocateScientificInstallation(String rut, String nameInstallationOld, String nameInstallationNew);
    //Descripcion: Reasignacion de una instalacion a un cientifico.
    //PreCondicion: El cientifico debe estar en la lista general de cientificos. nomInstalacionA debe estar en la lista de instalaciones del cientifico. nomInstalacionN debe estar en la lista general de cientificos.
    //PostCondiciones: Reasignacion hecha.
	public boolean isValid(String dateStr);
    //Descripcion: Verifica que el formato de la fecha sea el correcto y que fecha exista, por ejemplo, rechaza un 32 de febrero
    //PreCondicion:
    //PostCondiciones: Fecha validada.

	public boolean CreateProjects(String codeProyect,String nameProject,int budget,String DeptoResp,int quantityAreas,String[] listAreas );
    //Descripcion: Crea un objeto proyecto, le saca su area de especializacion y lo guarda en su lista de areas de especializacion. Se carga a lista general de proyectos
    //PreCondicion:
    //PostCondiciones: objeto cargado
	public boolean CreateScientist(String Rut, String Nombre,String  ApellidoP, String ApellidoM, String Area, int CostoAsociado,String codProyecto);
    //Descripcion: crea un objeto cientifico y lo carga a la lista general de cientificos.
    //PreCondicion:
    //PostCondiciones: objeto cargado	
	public boolean isValidDate(String dateStr);
    //Descripcion: Verifica que el formato de la fecha sea el correcto y que fecha exista, por ejemplo, rechaza un 32 de febrero
    //PreCondicion:
    //PostCondiciones: Fecha validada.
	public boolean RegistryScientist(String nameInstallation,String Rut,String DateIn, String DateOut,String HourIn, String HourOut);
	public boolean CreateAreas(String nameAreas);
	
	public boolean existsOrNotInstallation(String nameInstallation);
	public boolean existsOrNotDepartment(String nameDepartment);
	public boolean existsOrNotScientist(String rut);
	public boolean existsOrNotProject(String code);
	public boolean existsOrArea(String nameArea);
	
	public boolean HiringScientist(String Rut,String name, String lastname, String MotherLastName, String Area ,int AssociateCost,String department,String installation,int n,String [] listProjectScientist );
	
	
	public boolean EnlistIncome(String installation,String Rut,String dateIn,String timeIn,String dateOut,String timeOut);
	public boolean EnlistExit(String installation,String Rut,String dateIn,String timeIn,String dateOut,String timeOut);
	
	public String displayListPersonalDepartmentPrint();
	public String displayListPersonalInstallationPrint();
	public String Movements();
	
	public String displayprojectListing();
	public String CostPerProject(String CodeProject);
	public String  HoursWorked() throws ParseException;
	
	public String toDeployListProject();
	public String toDeployListDepartment();
	public String toDeployListScientist();
	public String toDeployListInstallation();
	public String toDeployListArea();
	public String toDeployListRegistry();
	
	public void TXTInstallations() throws IOException ;
	
	public void TXTProject() throws IOException;
	public void TXTScientist() throws IOException;
	public void TXTRegistry() throws IOException;
	
	
	public void TXTBackdoor1() throws IOException;
}
