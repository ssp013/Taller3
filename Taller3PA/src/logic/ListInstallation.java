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
	public Installation searchInstallation(String nameInstalation) {
		int k;
		for(k=0;k<cant;k++) {
			if(listInstallation[k].getNameInstalation().equals(nameInstalation)) {
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
	public Installation getInstallationI(int i) {
		if(i>=0 && i<cant) {
			return listInstallation[i];
		}else {
			return null;
		}
	}
	public boolean deleateInstallation(String nameInstalation) {
		boolean resp =false;
		int k;
		for(k=0;k<cant;k++) {
			if(listInstallation[k].getNameInstalation().equals(nameInstalation)) {
				break;
			}
		}
		if(k==cant) {
			resp=false;
		}else {
			for(int l=k;l<cant-1;l++) {
				listInstallation[l] = listInstallation[l+1];
			}
			resp=true;
		}
		return resp;
	}
	
}