/**
 * 
 */
package logic;
import ucn.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import domain.*;
/**
 * @author ssp013
 *
 */
public class SystemSustoImpl implements SystemSusto{

	/**
	 * 
	 */
	private ListInstallation listInstallation;
	private ListDepartment listDepartment;
	private ListStaff listStaff;
	private ListProject listProject;
	private ListArea listArea;
	private ListMovement listMovement;
	private ListRegistry listRegistry;
	
	
	public SystemSustoImpl() {
		// TODO Auto-generated constructor stub
		 listInstallation = new ListInstallation(100);
		 listDepartment= new ListDepartment(100);
		 listStaff = new ListStaff(100);
		 listProject = new ListProject(100);
		 listArea = new ListArea(100);
		 listMovement= new ListMovement(100);
		 listRegistry= new ListRegistry(100);
	}

	@Override
	public boolean isValidDate(String dateStr) {
		try {//"dd/MM/yyyy")
			String[] partes = dateStr.split("/");
			int year = Integer.parseInt(partes[2]);                
			int month =Integer.parseInt(partes[1]);                      
			int dayOfMonth = Integer.parseInt(partes[0]);       
			
			
			if (year < 1900) {
				return false;//año invalido.
			}
			else {
				LocalDate today = LocalDate.of(year, month, dayOfMonth);//tira un false..
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					return true;
		

				
			}
		}
		catch(java.time.DateTimeException e) {
			return false;
		}
		
	}
	@Override
	public boolean isValid(String dateStr) {
		try {//"dd/MM/yyyy")
			String[] partes = dateStr.split("/");
			int year = Integer.parseInt(partes[2]);                
			int month =Integer.parseInt(partes[1]);                      
			int dayOfMonth = Integer.parseInt(partes[0]);       
			
			if (year < 1900) {
				return false;//año invalido.
			}
			else {
				LocalDate today = LocalDate.of(year, month, dayOfMonth);//tira un false..
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String ingresada = formatter.format(today);
				LocalDateTime now = LocalDateTime.now(); 
				String fecha = formatter.format(now);
				if(fecha.equals(ingresada)) {
					return true;
				}else {
					return false;
				}

				
			}
		}
		catch(java.time.DateTimeException e) {
			return false;
		}
		
	}
	@Override
	public boolean existsOrNotInstallation(String nameInstallation) {
		boolean resp = false;
		Installation i = listInstallation.searchInstallation(nameInstallation);
		if(i==null) {
			resp=true;
		}
		return resp;
	}
	@Override
	public boolean CretateInstallation(String nameInstallation, int quantityDpto,String [] listDepto,int [] listCapacity,int [] listBudget) {
		// TODO Auto-generated method stub
		boolean resp = false;
		//Check if in the List general exist or not.
		Installation installation = listInstallation.searchInstallation(nameInstallation);
		if(installation!=null) {//YESSSS in the list!
			for(int i=0;i<quantityDpto;i++) {	
				String department = listDepto[i];
				int capacity= listCapacity[i];
				int budget = listBudget[i];	
				//Creamos el departemanto en la genetal
				createDepartment(department,capacity,budget);
				//Verificar si existe en el depto general...
				Department d = listDepartment.searchDepartment(department);
				if(d!=null) {
					ListDepartment listDetpto = installation.getlistDepartamentInstalation();
					Department d1 = listDetpto.searchDepartment(department);
					if(d1!=null) {
						int b = d1.getBudget() +budget;
						d1.setBudget(b);
						int c = d1.getDepartmentCapacity() + capacity;
						d1.setDepartmentCapacity(c);
						resp=true;
					}else {
						Department d3 = new Department(department,capacity,budget);
						listDetpto.enterDepartment(d3);
						resp = true;
					}
				}
			}
		}else {
			Installation insta = new Installation(nameInstallation);
			listInstallation.enterInstallation(insta);
			resp=true;
		}
		
		return resp;
	}
	@Override
	public boolean existsOrNotDepartment(String nameDepartment) {
		boolean resp = false;
		Department d = listDepartment.searchDepartment(nameDepartment);
		if(d==null) {
			resp=true;
		}
		return resp;
	}
	@Override
	public boolean existsOrNotScientist(String rut) {
		boolean resp = false;
		Staff s = listStaff.searchStafft(rut);
		if(s== null) {
			resp=true;
		}
		return resp;
	}
	@Override
	public boolean createDepartment(String nameDpto, int Capacity, int budget) {
		// TODO Auto-generated method stub
		boolean resp = false;
		Department d3 = listDepartment.searchDepartment(nameDpto);
		if(d3!=null) {
			int total = d3.getBudget() +budget;
			d3.setBudget(total);
			int C = d3.getDepartmentCapacity() +Capacity;
			d3.setBudget(C);
			resp=true;
		}else {
			Department newDepto = new Department(nameDpto,Capacity,budget);
			if(listDepartment.enterDepartment(newDepto)) {
				resp=true;
			}
		}
		return resp;
	}
	@Override
	public boolean CreateProjects(String ProjectCode,String nameProject,int budget,String DeptoResp,int quantityAreas,String[] listAreas ) {
		// TODO Auto-generated method stub
		boolean resp = false;
		for(int i=0;i<quantityAreas;i++) {//Create AREAS..
			CreateAreas(listAreas[i]);
			
		}
		Project proj = listProject.searchProyect(ProjectCode);
		if(proj!=null) {
			int t = proj.getTotalBudget()+budget;
			proj.setTotalBudget(t);
			ListArea lA = proj.getListArea();
			for(int i=0;i<quantityAreas;i++) {
				String ar = listAreas[i];
				Area a = lA.searchArea(ar);
				if(a!=null) {
					Area area = listArea.searchArea(ar);
					if(area!=null) {
						Area nueva = new Area(ar);
						lA.enterArea(nueva);
						resp = true;
					}
				}
			}
		}else {
			Project p = new Project(ProjectCode,nameProject,budget,DeptoResp,quantityAreas);
			listProject.enterProject(p);
			resp = true;
			
			ListDepartment lD = p.getListDepartment();
			Department d = listDepartment.searchDepartment(DeptoResp);
			if(d!=null) {
				lD.enterDepartment(d);				
			}
			ListArea lA = p.getListArea();
			for(int i=0;i<quantityAreas;i++) {
				String ar = listAreas[i];
				Area a = lA.searchArea(ar);
				if(a!=null) {
					Area area = listArea.searchArea(ar);
					if(area!=null) {
						Area nueva = new Area(ar);
						lA.enterArea(nueva);
						resp = true;
					}
				}
			}
		}
		return resp;
		
	}

	@Override
	public boolean CreateAreas(String nameArea) {
		// TODO Auto-generated method stub
		boolean resp = false;
		Area area = listArea.searchArea(nameArea);
		if(area==null) {
			Area area1 = new Area(nameArea);
			if(listArea.enterArea(area1)) {
				resp=true;
			}
		}
		return resp;
	}
	@Override
	public boolean CreateScientist(String Rut, String Name, String LastName, String MotherLastName, String Area,
			int AssociatedCost, String CodProject) {
		// TODO Auto-generated method stub
		boolean resp = false;
		
		//exists???
		Staff s = listStaff.searchStafft(Rut);
		if(s==null) {
			Staff SN = new Scientist(Rut, Name, LastName, MotherLastName, Area,AssociatedCost);
			listStaff.enterStaff(SN);
			if(SN instanceof Scientist) {
				ListProject lP = ((Scientist) SN).getListScientificProject();
				Project p = listProject.searchProyect(CodProject);
				if(p!=null) {
					lP.enterProject(p);				
					resp=true;
				}
			}
			resp= true;
		}else {
			if(s instanceof Scientist) {
				ListProject lP = ((Scientist) s).getListScientificProject();
				Project p = listProject.searchProyect(CodProject);
				if(p!=null) {
					lP.enterProject(p);				
					resp=true;
				}
			}
		}
		return resp;
	}
	
	@Override
	public boolean RegistryScientist(String nameInstallation,String Rut,String DateIn, String DateOut,String HourIn, String HourOut) {
		Registry R = new Registry(nameInstallation, Rut, DateIn, DateOut, HourIn, HourOut);
		listRegistry.enterRegistry(R);
		return true;
	}
	public boolean HiringScientist(String Rut, String lastname, String MotherLastName,
			String Area ,int AssociateCost,String department,String installation,
			String [] listProjectScientist ) {
		boolean resp=false;
		Staff S = new Scientist(Rut,lastname,MotherLastName, Area,installation, AssociateCost);
		listStaff.enterStaff(S);
		//Verificamos el area.
		for(int k=0;k<listProjectScientist.length;k++) {
			String codeProjecto = listProjectScientist[k];
			Project p = listProject.searchProyect(codeProjecto);
			if(p!=null && p.getTotalBudget()>=AssociateCost && p.getListArea().searchArea(Area)!=null) {//descontar!!
				Installation i = listInstallation.searchInstallation(installation);
				if(i!=null) {
					ListDepartment LD = i.getlistDepartamentInstalation();
					Department D = LD.searchDepartment(department);
					if(D!=null && D.getBudget()>=AssociateCost && D.getDepartmentCapacity()>0) {
						//REstamos:
						D.setBudget(D.getBudget()-AssociateCost);
						D.setDepartmentCapacity(D.getDepartmentCapacity()-1);
						p.setTotalBudget(p.getTotalBudget()-AssociateCost);
						resp=true;
					}
				}	
			}
		}
		return resp;
	}
	@Override
	public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reasignarCientificoInstalacion(String rutCientifico, String nomInstalacionA,
			String nomInstalacionN) {
		// TODO Auto-generated method stub
		return false;
	}
}
