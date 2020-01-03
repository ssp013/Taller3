/**
 * 
 */
package logic;
import java.util.Arrays;

import domain.Area;
/**
 * @author ssp013
 * this class is an area container
 */
public class ListArea {
	private Area [] listArea;
	private int cant;
	private int max;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	public ListArea(int max) {
		// TODO Auto-generated constructor stub
		this.listArea = new Area[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param I ,The application parameter has an installation that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterArea(Area a) {
		if(cant<max) {
			listArea[cant]=a;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param nameArea ,The application parameter has an nameArea that is used to search a Area
	 * @return Search for a Area, in case you find it returns a Area or otherwise, a null.
	 */
	public Area searchArea(String nameArea) {
		int k;
		for(k=0;k<cant;k++) {
			if(listArea[k].getNameArea().equals(nameArea)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listArea[k];
		}
	}
	/**
	 * @param i, The application of this parameter has an to search a Area in the specific location of the list.
	 * @return a Area returns, in the case that there is the position sought.
	 */
	public Area getAreaI(int i) {
		if(i>=0 && i<cant) {
			return listArea[i];
		}else {
			return null;
		}
	}
	/**
	 * @param 
	 * @return returns the area quantity
	 */
	public int areaQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		return "ListArea [listArea=" + Arrays.toString(listArea) + ", cant=" + cant + ", max=" + max
				+ ", areaQuantity()=" + areaQuantity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
