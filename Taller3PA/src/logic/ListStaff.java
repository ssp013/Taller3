/**
 * 
 */
package logic;

import java.util.Arrays;

import domain.*;

/**
 * @author ssp013
 *
 */
public class ListStaff {

	/**
	 * 
	 */
	private Staff [] listStaff;
	private int max;
	private int cant;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	
	public ListStaff(int max) {
		this.listStaff = new Staff[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param s ,The application parameter has an staff that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterStaff(Staff s) {
		if(cant<max) {
			listStaff[cant]=s;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param Rut ,The application parameter has an rut that is used to search a Staff
	 * @return Search for a Staff, in case you find it returns a Staff or otherwise, a null.
	 */
	public Staff searchStafft(String rut) {
		int k;
		for(k=0;k<cant;k++) {
			if( listStaff[k].getRut().equals(rut)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listStaff[k];
		}
	}
	/**
	 * @param i, The application of this parameter has an to search a Staff in the specific location of the list.
	 * @return a Staff returns, in the case that there is the position sought
	 */
	public Staff getStaffI(int i) {
		if(i<=0 && i<cant) {
			return listStaff[i];
		}else {
			return null;
		}
	}
	/**
	 * @param 
	 * @return returns the Staff quantity
	 */
	public int StaffQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		return "ListStaff [listStaff=" + Arrays.toString(listStaff) + ", max=" + max + ", cant=" + cant
				+ "]\n";
	}
	
}
