/**
 * 
 */
package logic;

import java.util.Arrays;

import domain.Movement;

/**
 * @author ssp013
 *
 */
public class ListMovement {
	/**
	 * 
	 */
	private Movement []listMovement;
	private int cant;
	private int max;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	public ListMovement(int max) {
		this.listMovement = new Movement[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param M ,The application parameter has an Movement that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterMovement(Movement M) {
		if(cant < max) {
			listMovement[cant]=M;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param i, The application of this parameter has an to search a Movement in the specific location of the list.
	 * @return a Movement returns, in the case that there is the position sought
	 */
	public Movement getMovementI(int i) {
		if (i<=0 && i<cant) {
			return listMovement[i];
		}else {
			return null;
		}
	}
	/**
	 * @param rut ,The application parameter has an rut that is used to search a Movement
	 * @return Search for a Movement, in case you find it returns a movement or otherwise, a null.
	 */
	public Movement searchMovement(String rut, String NameInstallation, String ProjectCode) {
		int k;
		for(k=0;k<cant;k++) {
			if(listMovement[k].getRut().contentEquals(rut)&&listMovement[k].getNameInstallation().equals(NameInstallation)&&listMovement[k].getProjectCode().equals(ProjectCode)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listMovement[k];
		}
	}
	/**
	 * @param 
	 * @return returns the movements quantity
	 */
	public int movementQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		return "ListMovement [listMovement=" + Arrays.toString(listMovement) + ", cant=" + cant + ", max=" + max
				+ ", movementQuantity()=" + movementQuantity() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
