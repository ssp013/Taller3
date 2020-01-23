/**
 * 
 */
package logic;
import ucn.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
	public boolean existsOrArea(String nameArea) {
		boolean resp = false;
		Area i = listArea.searchArea(nameArea);
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
				//Verificar si existe en el depto general...
				Department d1 = listDepartment.searchDepartment(department);
				if(d1!=null) {
					int b = d1.getBudget() +budget;
					d1.setBudget(b);
					int c = d1.getDepartmentCapacity() + capacity;
					d1.setDepartmentCapacity(c);
					resp=true;
				}
			}
		}else {
			Installation insta = new Installation(nameInstallation);
			listInstallation.enterInstallation(insta);
			for(int i=0;i<quantityDpto;i++) {	
				String department = listDepto[i];
				int capacity= listCapacity[i];
				int budget = listBudget[i];
				ListDepartment listDetpto = insta.getlistDepartamentInstalation();
				Department d3 = listDepartment.searchDepartment(department);
				if(d3!=null) {
					Department d4 = new Department(department,capacity,budget);
					listDetpto.enterDepartment(d4);
				}
				resp=true;
			}
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
	public boolean existsOrNotProject(String code) {
		boolean resp = false;
		Project p = listProject.searchProyect(code);
		if(p== null) {
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
		Project proj = listProject.searchProyect(ProjectCode);
		if(proj!=null) {
			int t = proj.getTotalBudget()+budget;
			proj.setTotalBudget(t);
			ListDepartment LD = proj.getListDepartment();
			Department d = listDepartment.searchDepartment(DeptoResp);
			if(d!=null) {
				LD.enterDepartment(d);
				ListProject lp = d.getListProject();
				Project p22= lp.searchProyect(proj.getProjectCode());
				if(p22==null) {
					lp.enterProject(proj);	
					d.setBudget(d.getBudget()-budget);
				}
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
			}
		}else {
			Project p = new Project(ProjectCode,nameProject,budget,DeptoResp,quantityAreas);
			listProject.enterProject(p);
			ListDepartment lD = p.getListDepartment();
			Department d = listDepartment.searchDepartment(DeptoResp);
			if(d!=null) {
				lD.enterDepartment(d);
				ListProject lp = d.getListProject();
				Project p22= lp.searchProyect(p.getProjectCode());
				if(p22==null) {
					lp.enterProject(p);	
					d.setBudget(d.getBudget()-budget);
					
				}
				ListArea lA = p.getListArea();
				for(int i=0;i<quantityAreas;i++) {
					String ar = listAreas[i];
					Area a = lA.searchArea(ar);
					if(a==null) {
						Area area = listArea.searchArea(ar);
						if(area!=null) {
							Area nueva = new Area(ar);
							lA.enterArea(nueva);
							resp = true;
						}
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
			
			if(SN instanceof Scientist) {
				ListProject lP = ((Scientist) SN).getListScientificProject();
				ListInstallation LI = ((Scientist) SN).getlistInstallationScientist();
				for(int x=0;x<listInstallation.getCantInstallation();x++) {
					Installation IGlobal = listInstallation.getInstallationI(x);
					ListDepartment lDInstallation =IGlobal.getlistDepartamentInstalation();
					Project p = listProject.searchProyect(CodProject);
					if(p!=null) {
						
						for(int i=0;i<listDepartment.DepartmentQuantity();i++) {
							ListProject LPD = listDepartment.getDepartmentI(i).getListProject();
							Project pD = LPD.searchProyect(p.getProjectCode());
							if(pD!=null) {
								Department DSearchInstallation = lDInstallation.searchDepartment(listDepartment.getDepartmentI(i).getNameDepartament());
								if(DSearchInstallation!=null) {
									if(listDepartment.getDepartmentI(i).getBudget()>AssociatedCost ) {
										if(listDepartment.getDepartmentI(i).getDepartmentCapacity()> 0) {
											listDepartment.getDepartmentI(i).setBudget(	 listDepartment.getDepartmentI(i).getBudget()-AssociatedCost);
											listDepartment.getDepartmentI(i).setDepartmentCapacity(listDepartment.getDepartmentI(i).getDepartmentCapacity()-1);
											listStaff.enterStaff(SN);
											LI.enterInstallation(IGlobal);
											lP.enterProject(p);
											resp=true;
										}
									}
									
								}
								

							}
						}
					}
					
				}
			}
			
		}else {
			if(s instanceof Scientist) {
				
				ListProject lP = ((Scientist) s).getListScientificProject();
				ListInstallation LI = ((Scientist) s).getlistInstallationScientist();
				for(int x=0;x<listInstallation.getCantInstallation();x++) {
					Installation IGlobal = listInstallation.getInstallationI(x);
					ListDepartment lDInstallation =IGlobal.getlistDepartamentInstalation();
					Project p = listProject.searchProyect(CodProject);
					if(p!=null) {
						for(int i=0;i<listDepartment.DepartmentQuantity();i++) {
							ListProject LPD = listDepartment.getDepartmentI(i).getListProject();
							Project pD = LPD.searchProyect(p.getProjectCode());
							if(pD!=null) {
								Department DSearchInstallation = lDInstallation.searchDepartment(listDepartment.getDepartmentI(i).getNameDepartament());
								if(DSearchInstallation!=null) {
									if(listDepartment.getDepartmentI(i).getBudget()>AssociatedCost) {
										if(listDepartment.getDepartmentI(i).getDepartmentCapacity()> 0) {
											listDepartment.getDepartmentI(i).setBudget(	 listDepartment.getDepartmentI(i).getBudget()-AssociatedCost);
											listDepartment.getDepartmentI(i).setDepartmentCapacity(listDepartment.getDepartmentI(i).getDepartmentCapacity()-1);
											LI.enterInstallation(IGlobal);
											lP.enterProject(p);
											resp=true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return resp;
	}
	
	@Override
	public boolean RegistryScientist(String nameInstallation,String Rut,String DateIn, String DateOut,String HourIn, String HourOut) {
		Registry R = new Registry(nameInstallation, Rut, DateIn, DateOut, HourIn, HourOut);
		listRegistry.enterRegistry(R);
		Staff SC = listStaff.searchStafft(Rut);
		if(SC != null && SC instanceof Scientist) {
			ListRegistry LR = ((Scientist) SC).getListRegistry();
			LR.enterRegistry(R);
		}
		return true;
	}
	public boolean EnlistIncome(String installation,String Rut,String dateIn,String timeIn,String dateOut,String timeOut) {
		boolean resp = false;
		Staff sc = listStaff.searchStafft(Rut);
		if(sc instanceof Scientist) {
			//StdOut.println("Dale\n");
			ListProject proj = ((Scientist) sc).getListScientificProject();
			for(int k=0;k<proj.projectQuantity();k++) {
				Project p = proj.getProject(k);
				for(int j=0;j< p.getListDepartment().DepartmentQuantity();j++) {
					ListDepartment Ld = p.getListDepartment();
					for(int l=0;l<Ld.DepartmentQuantity();l++) {
						Department d = Ld.getDepartmentI(l);
						for(int a=0;a<listInstallation.getCantInstallation();a++) {
							Installation insta = listInstallation.getInstallationI(a);
							Department d2= insta.getlistDepartamentInstalation().searchDepartment(d.getNameDepartament());
							if(d2!=null  ) {
								//StdOut.println("Dale\n");
								//Esta en la installation ese departamento..
								//Ese proyecto pertenece a ese insta, depto, !
								if(installation.equals(insta.getNameInstalation())) {
									//StdOut.println("Dale\n");
									//¿Comprobamos si existe un registro?
									ListRegistry LR = ((Scientist) sc).getListRegistry();
									for(int i=0;i<LR.RegistrytQuantity();i++) {
										String nombreInsta = LR.getRegistryI(i).getNameInstallation() ;
										if(nombreInsta.equals(insta.getNameInstalation())   
										&& !dateIn.equals(LR.getRegistryI(i).getDateIn())  
										&& !timeIn.equals(LR.getRegistryI(i).getHourIn())) {
											//StdOut.println("Dale\n");
											//Si es la misma instalación, distitno fecha y hora.. lo agrego el nuevo registro.
											Registry re = new Registry(installation,Rut,dateIn,timeIn,dateOut,timeOut);
											listRegistry.enterRegistry(re);
											resp=true;
											
										}
									}
							}
					
								
								
								
							}
							
							
						}
						
					}
				}
			}	
		}
		return resp;
	}
	public boolean EnlistExit(String installation,String Rut,String dateIn,String timeIn,String dateOut,String timeOut) {
		boolean resp = false;
		Staff sc = listStaff.searchStafft(Rut);
		if(sc instanceof Scientist) {
			//StdOut.println("Dale\n");
			ListProject proj = ((Scientist) sc).getListScientificProject();
			for(int k=0;k<proj.projectQuantity();k++) {
				Project p = proj.getProject(k);
				for(int j=0;j< p.getListDepartment().DepartmentQuantity();j++) {
					ListDepartment Ld = p.getListDepartment();
					for(int l=0;l<Ld.DepartmentQuantity();l++) {
						Department d = Ld.getDepartmentI(l);
						for(int a=0;a<listInstallation.getCantInstallation();a++) {
							Installation insta = listInstallation.getInstallationI(a);
							Department d2= insta.getlistDepartamentInstalation().searchDepartment(d.getNameDepartament());
							if(d2!=null  ) {
								//StdOut.println("Dale\n");
								//Esta en la installation ese departamento..
								//Ese proyecto pertenece a ese insta, depto, !
								if(installation.equals(insta.getNameInstalation())) {
									//StdOut.println("Dale\n");
									//¿Comprobamos si existe un registro?
									ListRegistry LR = ((Scientist) sc).getListRegistry();
									for(int i=0;i<LR.RegistrytQuantity();i++) {
										
										String nombreInsta = LR.getRegistryI(i).getNameInstallation() ;
										String dOut =  LR.getRegistryI(i).getDateOut() ;// "0"
										String tOut =  LR.getRegistryI(i).getHourOut() ;// "0"
										String Date2 = LR.getRegistryI(i).getDateIn() ;
										
										if(nombreInsta.equals(insta.getNameInstalation()) &&  
											dOut.equals("0") && tOut.equals("0") 
										&&     Date2.equals(dateOut)) {
											//StdOut.println("Dale\n");
											LR.getRegistryI(i).setDateOut(dateOut);
											LR.getRegistryI(i).setHourOut(timeOut);;
											resp=true;
											
										}
									}
							}
					
								
								
								
							}
							
							
						}
						
					}
				}
			}	
		}
		return resp;
	}
	public boolean HiringScientist(String Rut, String name,String lastname, String MotherLastName,
			String Area ,int AssociateCost,String department,String installation,int n,
			String [] listProjectScientist ) {
		boolean resp=false;
		Staff S = new Scientist(Rut,name,lastname,MotherLastName, Area, AssociateCost);
		
		
		//Verificamos el area.
		for(int k=0;k<n;k++) {
			
			String codeProjecto = listProjectScientist[k];

			
			Project p = listProject.searchProyect(codeProjecto);
			if(p!=null) {
					if(p.getTotalBudget()>=AssociateCost && p.getListArea().searchArea(Area)!=null) {//descontar!!
						
						

						Installation i = listInstallation.searchInstallation(installation);
							if(i!=null) {
								
								
								ListDepartment LD = i.getlistDepartamentInstalation();
								Department D = LD.searchDepartment(department);
								if(D!=null && D.getBudget()>=AssociateCost && D.getDepartmentCapacity()>0) {
								
									if(S instanceof Scientist) {
										
							
										ListInstallation LI = ((Scientist) S).getlistInstallationScientist();	
										//REstamos:
										D.setBudget(D.getBudget()-AssociateCost);
										D.setDepartmentCapacity(D.getDepartmentCapacity()-1);
										p.setTotalBudget(p.getTotalBudget()-AssociateCost);	
										
						
										
										listStaff.enterStaff(S);
										//New movement:
					
									
										DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
										LocalDateTime now = LocalDateTime.now(); 
										String dateNow = formatter.format(now);						
									
										
										Movement M = new Hiring(Rut,department,dateNow,installation);
										listMovement.enterMovement(M);
										Installation ins = new Installation(installation);
										
										resp=true;
										if(LI.searchInstallation(installation)==null) {
											LI.enterInstallation(ins);
										}
									}
									
								}
							}	
					}

			}
		}
		return resp;
	}
	
	public String toDeployListProject() {
		String r ="";
		for(int i=0;i<listProject.projectQuantity();i++) {
			Project p = listProject.getProject(i);
			r=r+"Name: "+p.getProjectName()+"\n";
			r=r+"List Department:\n";
			ListDepartment ld = p.getListDepartment();
			for(int j=0;j<ld.DepartmentQuantity();j++) {
				r=r+"   - "+ld.getDepartmentI(j).getNameDepartament()+"\n";
				ListProject lPE =ld.getDepartmentI(j).getListProject();
				for(int m=0;m<lPE.projectQuantity();m++) {
					Project p1= lPE.getProject(m);
					Project p3 = listProject.searchProyect(p1.getProjectCode());
					if(p3!=null) {
						r=r+"        * "+ld.getDepartmentI(j).getNameDepartament()+"\n";
					}
				}
			}
		}
		return r;
	}
	public String toDeployListDepartment() {
		String r ="";
		for(int i=0;i<listDepartment.DepartmentQuantity();i++) {
			
			
			Department d=  listDepartment.getDepartmentI(i);
			r=r+"Name Department: "+d.getNameDepartament()+", Department Capacity: "+d.getDepartmentCapacity()+", Budget: "+d.getBudget()+"\n ListProject:\n";
			ListProject LP = d.getListProject();
			for(int j=0;j<LP.projectQuantity();j++) {
				r=r+LP.getProject(j).getProjectCode()+"\n";
			}
		}
			return r;
	}
	public String toDeployListScientist() {
		String r ="";	

		
		
		for(int i=0;i<listStaff.StaffQuantity();i++) {
			
			if(listStaff.getStaffI(i) instanceof Scientist) {
				Scientist s = (Scientist) listStaff.getStaffI(i);
				r=r+"Scientist [Rut=" + s.getRut() + ", Name=" + s.getName() + ", LastName=" + s.getLastName() + ", MotherLastName="
						+ s.getMotherLastName() + ", Area=" + s.getArea() + ", AssociatedCost=" + s.getAssociatedCost()+"\n ListProject:\n";
				ListProject lp= s.getListScientificProject();
				for(int k=0;k<lp.projectQuantity();k++) {
					Project p =lp.getProject(k);
					r=r+"Code"+p.getProjectCode()+"\n" ;
					
				}
				ListInstallation lInsta= s.getlistInstallationScientist();
				r=r+"List Installation:\n";
				for(int k=0;k<lInsta.getCantInstallation();k++) {
					 lInsta.getInstallationI(k).getNameInstalation();
					r=r+"Name Installation: "+lInsta.getInstallationI(k).getNameInstalation()+"\n" ;
					
				}
			}
				
			}	
		return r;
		}
	public String toDeployListRegistry() {
		String r ="";		
		for(int k=0;k<listRegistry.RegistrytQuantity();k++) {
			r=r+listRegistry.getRegistryI(k).toString()+"\n";
		}
		return r;
	}
	public String toDeployListInstallation() {
		String r ="";
		for(int i=0;i<listInstallation.getCantInstallation();i++) {
			r=r+listInstallation.getInstallationI(i).getNameInstalation()+"\n";
			
			ListDepartment ld = listInstallation.getInstallationI(i).getlistDepartamentInstalation();
			r=r+" List Department:\n ";
			for(int k=0;k<ld.DepartmentQuantity();k++) {
				r=r+ld.getDepartmentI(k).getNameDepartament()+"\n";
			}
			
		}
		return r;
	}
	public String toDeployListArea() {
		String r ="";
		for(int i=0;i<listArea.areaQuantity();i++) {
			r=r+listArea.getAreaI(i).toString()+"\n";
		}
		return r;
	}
	@Override
	public boolean reallocateScientificProject(String rut, String codOld, String codNew) {
		// TODO Auto-generated method stub
		boolean answer= false;
		Staff S = listStaff.searchStafft(rut);
		if(S instanceof Scientist) {
			ListProject lp = ((Scientist) S).getListScientificProject();
			Project ProjectOld = lp.searchProyect(codOld);
			
			Project projectNew = listProject.searchProyect(codNew);
			//Verificar Presupuesto..
			ListDepartment listDep = projectNew.getListDepartment();
			
			for(int i=0;i<listDep.DepartmentQuantity();i++) {
				Department dep = listDep.getDepartmentI(i);
				ListProject Lp2 = dep.getListProject();
				for(int k=0;k<Lp2.projectQuantity();k++) {
					
					if(Lp2.getProject(k).getProjectCode().equals(projectNew.getProjectCode())) {
						
						if(dep.getBudget()>((Scientist) S).getAssociatedCost() &&  dep.getDepartmentCapacity()>0){
							
							dep.setBudget(dep.getBudget()-((Scientist) S).getAssociatedCost());
							dep.setDepartmentCapacity(dep.getDepartmentCapacity()-1);
							lp.deleteProject(ProjectOld);
							lp.enterProject(projectNew);
							
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDateTime now = LocalDateTime.now(); 
							String dateNow = formatter.format(now);						
						
							
							Movement M = new Reallocation(rut,dep.getNameDepartament(),dateNow,"","",codOld,codNew);
							listMovement.enterMovement(M);

							
							
							answer=true;
							
						}
					}
				}
			}
		}
		
		return answer;
	}
	@Override
	public String displayListPersonalInstallationPrint() {
		String r="";
		r=r+"********** List of personnel by installation *********\n";
		for(int i=0;i<listInstallation.getCantInstallation();i++) {
			r=r+"Name: "+listInstallation.getInstallationI(i).getNameInstalation()+"\n";
			r=r+"List departments: \n";
			ListDepartment lDepart= listInstallation.getInstallationI(i).getlistDepartamentInstalation();
			for(int j=0;j<lDepart.DepartmentQuantity();j++) {
					Department deptoSearch = listDepartment.searchDepartment(lDepart.getDepartmentI(j).getNameDepartament());
					if(deptoSearch!=null) {
						r=r+"- "+deptoSearch.getNameDepartament()+"\n";
						ListProject LP = deptoSearch.getListProject();
						
						for(int a=0;a<LP.projectQuantity();a++) {
							
							r=r+"  * "+LP.getProject(a).getProjectName()+"\n";
							
							for(int m=0;m<listStaff.StaffQuantity();m++) {
								Staff St=listStaff.getStaffI(m);
								if(St instanceof Scientist) {
									ListProject lP2=((Scientist) St).getListScientificProject();
									for(int g=0;g<lP2.projectQuantity();g++) {
										Project p2 = lP2.getProject(g);
										Project psearch = LP.searchProyect(p2.getProjectCode());
										if(psearch!=null) {
											r=r+"      - "+St.getName()+"\n"; 
										}
										
									}
									
								}
							}
							
						}
						
						
					}
			}	
		}
		return r;
		
	}
	@Override
	public String displayListPersonalDepartmentPrint() {
		String r="";
		r=r+"********** List of personnel by department *********\n";		
			for(int j=0;j<listDepartment.DepartmentQuantity();j++) {
					Department deptoSearch = listDepartment.searchDepartment(listDepartment.getDepartmentI(j).getNameDepartament());
					if(deptoSearch!=null) {
						r=r+"Name Department: "+deptoSearch.getNameDepartament()+"\n";
						ListProject LP = deptoSearch.getListProject();
						
						for(int a=0;a<LP.projectQuantity();a++) {
							
							r=r+"  * "+LP.getProject(a).getProjectName()+"\n";
							
							for(int m=0;m<listStaff.StaffQuantity();m++) {
								Staff St=listStaff.getStaffI(m);
								if(St instanceof Scientist) {
									ListProject lP2=((Scientist) St).getListScientificProject();
									for(int g=0;g<lP2.projectQuantity();g++) {
										Project p2 = lP2.getProject(g);
										Project psearch = LP.searchProyect(p2.getProjectCode());
										if(psearch!=null) {
											r=r+"      - "+St.getName()+"\n"; 
										}
										
									}
									
								}
							}
							
						}
						
					
					}
			}	
		
		return r;	
	}
	@Override 
	public String displayprojectListing() {
		String r="";
		r=r+"********** Listining Project *********\n";	
		for(int l=0;l<listProject.projectQuantity();l++) {
			r=r+" *"+listProject.getProject(l).getProjectName()+"\n";
			for(int i=0;i<listStaff.StaffQuantity();i++) {
				
				Staff s= listStaff.getStaffI(i);
				if(s instanceof Scientist) {
					ListProject lp= ((Scientist) s).getListScientificProject();
					for(int k=0;k<lp.projectQuantity();k++) {
						Project p = lp.getProject(k);
							if(listProject.getProject(l).getProjectCode().equals(p.getProjectCode())) {
								
							r=r+" -"+s.getName() + " "+s.getLastName()+"\n";
						}
					}
				}
			}
			
		}
		return r;
	}
	@Override
	public String CostPerProject(String CodeProject) {
		String r="";
		Project p= listProject.searchProyect(CodeProject);
		if(p!=null) {
			r=r+"Name: "+p.getProjectName()+", Budget: $"+p.getTotalBudget()+"\n";
			
			r=r+"List Scientist:\n";
			for(int i=0;i<listStaff.StaffQuantity();i++) {
				Staff s=listStaff.getStaffI(i);
				if(s instanceof Scientist) {
					ListProject ListScintistProject = ((Scientist) s).getListScientificProject();
					Project p2 = ListScintistProject.searchProyect(CodeProject);
					if(p2!=null) {
						r=r+"Name: "+s.getName()+", Cost Associate: $"+((Scientist) s).getAssociatedCost()+"\n";
					}
				}
			}
		}
		
		return r;
		
	}
	@Override
	public boolean reallocateScientificInstallation(
			String rut, String nameInstallationOld, String nameInstallationNew) {
		// TODO Auto-generated method stub
		boolean answer= false;
		Staff S = listStaff.searchStafft(rut);
		if(S instanceof Scientist) {
			ListInstallation ListInstaScientist = ((Scientist) S).getlistInstallationScientist();
			Installation ISearch = ListInstaScientist.searchInstallation(nameInstallationOld);
			if(ISearch!=null) {
				ListInstaScientist.deleteInstallation(ISearch);
				Installation NeWInsta = new Installation(nameInstallationNew);
				if(ListInstaScientist.enterInstallation(NeWInsta)) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now = LocalDateTime.now(); 
					String dateNow = formatter.format(now);						
					Movement M = new Reallocation(rut,"",dateNow,nameInstallationOld,nameInstallationNew,"","");
					listMovement.enterMovement(M);
					answer=true;					
				}
			}
		}
		
		return answer;
	}
	@Override
	public String  HoursWorked() throws ParseException{  
		String r="";
		for(int i=0;i<listProject.projectQuantity();i++) {
			
			Project p = listProject.getProject(i);
			r=r+"Name Project: "+p.getProjectName()+"\n";
			
			 for(int m=0;m<listRegistry.RegistrytQuantity();m++) {
				 
				 Registry reg = listRegistry.getRegistryI(m);
				 String rut = reg.getRut();
				 Staff se = listStaff.searchStafft(rut);
				 
				 if(se instanceof Scientist) {
					ListProject lSP =  ((Scientist) se).getListScientificProject();
					Project ps = lSP.searchProyect(p.getProjectCode());
					if(ps!=null ) {
						
						r=r+"  - "+se.getName()+"\n";	
						String HourIn =  reg.getHourIn();
						String HourOut =  reg.getHourOut();
    					boolean horaIng = false;
    					boolean horaSal = false;
						
						try{
    						LocalTime.parse(HourIn);
    						LocalTime.parse(HourOut);
    						horaIng = true;
    						horaSal = true;
    					}catch(DateTimeParseException|NullPointerException e){
    						//ERROR.
    					}
    					if(horaIng == true && horaSal == true){
    						String dateStart = HourIn;
    						String dateStop = HourOut;
    						SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    						Date d1 = null;
    						Date d2 = null;
    						try{
    							d1 = format.parse(dateStart);
    							d2 = format.parse(dateStop);
    							long diff = d2.getTime()-d1.getTime();
    							long diffMinutes = diff/(60*1000)%60;
    							long diffHours = diff/(60*60*60)%24;
    							r=r+"           Time to Work:  "+diffHours+" Hours "+diffMinutes+" minutes\n";
    							
    						}catch(Exception e){
    							e.printStackTrace();
    						}
    					}
						
						
					}
				 }
			 }
		}
		
		return r;    
    }  	
	
	@Override
	public String Movements() {
		String r="";
		for(int i=0;i<listMovement.movementQuantity();i++) {
			Movement m=listMovement.getMovementI(i);
			if(m instanceof Reallocation) {
				String Date = ((Reallocation) m).getDate();
				r=r+"- Date: "+Date +" , Movement type = Reallocation, Rut:"+m.getRut()+"\n    List Projects: \n";
				Staff se = listStaff.searchStafft(m.getRut());
				if(se instanceof Scientist) {
					ListProject lp=((Scientist) se).getListScientificProject();
					for(int k=0;k<lp.projectQuantity();k++) {
						Project p2 = lp.getProject(k);
						Project p1= listProject.searchProyect(p2.getProjectCode());
						if(p1!=null) {
							r=r+"       * "+p1.getProjectName()+"\n";
						}
					}//OJOOOOOOOOOOOOOOO
					
				}
				
			}else if(m instanceof Hiring) {
				String Date = ((Hiring) m).getDate();
			
				r=r+"- Date: "+Date +" , Movement type = Hiring, Rut:"+m.getRut()+"\n    List Projects: \n";
				Staff se = listStaff.searchStafft(m.getRut());
				if(se instanceof Scientist) {
					ListProject lp=((Scientist) se).getListScientificProject();
					for(int k=0;k<lp.projectQuantity();k++) {
						Project p2 = lp.getProject(k);
						Project p1= listProject.searchProyect(p2.getProjectCode());
						if(p1!=null) {
							r=r+"       * "+p1.getProjectName()+"\n";
						}
					}
					
				}
			}
		}
		return r;
	}
	
}
