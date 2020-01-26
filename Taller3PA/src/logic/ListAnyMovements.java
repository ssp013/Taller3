/**
 * 
 */
package logic;

import java.util.Arrays;

import domain.AnyMovements;

/**
 * @author sebastiansanchez
 *
 */
public class ListAnyMovements {

	/**
	 * 
	 */
	private AnyMovements []listAnyMovements;
	private int cant;
	private int max;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	public ListAnyMovements(int max) {
		this.listAnyMovements = new AnyMovements[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param M ,The application parameter has an Movement that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterMovementAny(AnyMovements M) {
		if(cant < max) {
			listAnyMovements[cant]=M;
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
	public AnyMovements getAnyMovementI(int i) {
		if (i<=0 && i<cant) {
			return listAnyMovements[i];
		}else {
			return null;
		}
	}
	/**
	 * @param rut ,The application parameter has an rut that is used to search a Movement
	 * @return Search for a Movement, in case you find it returns a movement or otherwise, a null.
	 */
	public AnyMovements searchAnyMovement(String MovementName,String data_of_the_movement) {
		int k;
		for(k=0;k<cant;k++) {
			if(listAnyMovements[k].getData_of_the_movement().equals(data_of_the_movement)
					&& listAnyMovements[k].getMovementName().equals(MovementName)
					){
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listAnyMovements[k];
		}
	}
	/**
	 * @param 
	 * @return returns the movements quantity
	 */
	public int AnyMovementQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		return "ListAnyMovements [listAnyMovements=" + Arrays.toString(listAnyMovements) + ", cant=" + cant + ", max="
				+ max + "]";
	}
	
	
}