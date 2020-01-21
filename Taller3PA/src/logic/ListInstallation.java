package logic;
import domain.Installation;

/**
 * @author ssp013
 *this class is an installation container
 */
public class ListInstallation {
	private Installation [] listInstallation;
	private int cant;
	private int max;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	public ListInstallation(int max) {
		this.listInstallation = new Installation[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param I ,The application parameter has an installation that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterInstallation(Installation I) {
		if(cant<max) {
			listInstallation[cant]=I;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param nameInstallation ,The application parameter has an NameInstallation that is used to search a Installation
	 * @return Search for a Installation, in case you find it returns a installation or otherwise, a null.
	 */
	public Installation searchInstallation(String nameInstallation) {
		int k;
		for(k=0;k<cant;k++) {
			if(listInstallation[k].getNameInstalation().equals(nameInstallation)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listInstallation[k];
		}
	}
	
	
	public int getCantInstallation() {
		return cant;
	}
	
	/**
	 * @param i, The application of this parameter has an to search a Installation in the specific location of the list.
	 * @return a Installation returns, in the case that there is the position sought
	 */
	public Installation getInstallationI(int i) {
		if(i>=0 && i<cant) {
			return listInstallation[i];
		}else {
			return null;
		}
	}
	@Override
	public String toString() {
		String r="";
		for(int i=0; i<cant;i++) {
			r=r+"Name Installation:  "+getInstallationI(i).getNameInstalation()+
				"ListDepartment: "+ getInstallationI(i).getlistDepartamentInstalation().toString()
				+"\n";
		}
		return r;
	}
}