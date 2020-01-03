package domain;
import logic.ListProject;
/**Class Departament to the system
 * @author ssp013
 *d
 */
public class Department {
	/**
	 * Class to create Department.
	 * @params nameDepartament, budget,listDepartamentInstalation
	 */
	private String NameDepartament;
	private int DepartmentCapacity;
	private int Budget;
	private ListProject listProject;
	/**
	 * @param NameDepartament
	 * @param DepartmentCapacity
	 * @param Budget
	 * @param listProject
	 */
	public Department(String NameDepartament,int DepartmentCapacity, int Budget,ListProject listProject){
		this.NameDepartament = NameDepartament;
		this.DepartmentCapacity = DepartmentCapacity;
		this.Budget=Budget;
	}

	/**
	 * @return the nameDepartament
	 */
	public String getNameDepartament() {
		return NameDepartament;
	}

	/**
	 * @param nameDepartament the nameDepartament to set
	 */
	public void setNameDepartament(String nameDepartament) {
		NameDepartament = nameDepartament;
	}

	/**
	 * @return the departmentCapacity
	 */
	public int getDepartmentCapacity() {
		return DepartmentCapacity;
	}

	/**
	 * @param departmentCapacity the departmentCapacity to set
	 */
	public void setDepartmentCapacity(int departmentCapacity) {
		DepartmentCapacity = departmentCapacity;
	}

	/**
	 * @return the budget
	 */
	public int getBudget() {
		return Budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(int budget) {
		Budget = budget;
	}

	/**
	 * @return the listProject
	 */
	public ListProject getListProject() {
		return listProject;
	}

	/**
	 * @param listProject the listProject to set
	 */
	public void setListProject(ListProject listProject) {
		this.listProject = listProject;
	}
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Departament [NameDepartament=" + NameDepartament + ", DepartmentCapacity=" + DepartmentCapacity
				+ ", Budget=" + Budget + ", listProject=" + listProject + "]";
	}
	
	
	
}
