package logic;
import java.util.Arrays;

import domain.Department;

public class ListDepartment {
	/**
	 * @author ssp013
	 *this class is an department container
	 */
	private Department [] listDepto;
	private int cant;
	private int max;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	public ListDepartment(int max) {
		// TODO Auto-generated constructor stub
		this.listDepto = new Department[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param D ,The application parameter has an Department that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterDepartment(Department d) {
		if(cant<max) {
			listDepto[cant]=d;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param NameDepartment ,The application parameter has an NameDepartment that is used to search a Department
	 * @return Search for a department, in case you find it returns a department or otherwise, a null.
	 */
	public Department searchDepartment(String NameDepartment) {
		int k;
		for(k=0;k<cant;k++) {
			if(listDepto[k].getNameDepartament().equals(NameDepartment)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listDepto[k];
		}
	}
	/**
	 * @param i, The application of this parameter has an to search a Department in the specific location of the list.
	 * @return a department returns, in the case that there is the position sought
	 */
	public Department getDepartmentI(int i) {
		if(i>=0 && i<cant) {
			return listDepto[i];
		}else {
			return null;
		}
	}
	/**
	 * @param 
	 * @return returns the department quantity
	 */
	public int DepartmentQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		String r="";
		for(int i=0; i<cant;i++) {
			r=r+"Name Department:  "+getDepartmentI(i).getNameDepartament() +" - Budget: "+getDepartmentI(i).getBudget()
					+ "Capacity: "+getDepartmentI(i).getDepartmentCapacity()+
					"List Projects: "+getDepartmentI(i).getListProject().toString()
					+"\n";
			
		}
		return r;
	}
}
