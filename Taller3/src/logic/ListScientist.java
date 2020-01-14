/**
 * 
 */
package logic;

import java.util.Arrays;

import domain.Scientist;

/**
 * @author ssp013
 *
 */
public class ListScientist {

	/**
	 * 
	 */
	private Scientist [] listScientist;
	private int max;
	private int cant;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	
	public ListScientist(int max) {
		this.listScientist = new Scientist[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param s ,The application parameter has an scientist that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterScientist(Scientist s) {
		if(cant<max) {
			listScientist[cant]=s;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param Rut ,The application parameter has an rut that is used to search a Scientist
	 * @return Search for a Scientist, in case you find it returns a scientist or otherwise, a null.
	 */
	public Scientist searchScientist(String rut) {
		int k;
		for(k=0;k<cant;k++) {
			if(listScientist[k].getRut().equals(rut)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listScientist[k];
		}
	}
	/**
	 * @param i, The application of this parameter has an to search a Scientist in the specific location of the list.
	 * @return a Scientist returns, in the case that there is the position sought
	 */
	public Scientist getScientI(int i) {
		if(i<=0 && i<cant) {
			return listScientist[i];
		}else {
			return null;
		}
	}
	/**
	 * @param 
	 * @return returns the Scientist quantity
	 */
	public int ScientistQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		return "ListScientist [listScientist=" + Arrays.toString(listScientist) + ", max=" + max + ", cant=" + cant
				+ "]";
	}
	
}
