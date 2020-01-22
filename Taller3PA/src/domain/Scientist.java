/**
 * 
 */
package domain;
import logic.ListInstallation;
import logic.ListProject;
import logic.ListRegistry;


/**Class Scientist to the system
 * @author ssp013
 *
 */
public  class Scientist extends Staff {
	/**
	 * Class to create Scientist.
	 * @params Rut,Name,LastName,MotherLastName,Area,AssociatedCost
	 */

	private int AssociatedCost;
	private ListProject listScientificProject;
	private ListInstallation listInstallationScientist;
	private ListRegistry listRegistry;

	
	/**
	 * @param Rut
	 * @param Name
	 * @param LastName
	 * @param MotherLastName
	 * @param Area
	 * @param AssociatedCost
	 */
	public Scientist(String Rut, String Name, String LastName,String MotherLastName,String Area,int AssociatedCost){
		super(Rut,Name,LastName, MotherLastName,Area);
		this.AssociatedCost =AssociatedCost;
		listScientificProject = new ListProject(100);
		listRegistry = new ListRegistry(100);
		listInstallationScientist = new ListInstallation(100);
		
	}
	
	/**
	 * @return the associatedCost
	 */
	public int getAssociatedCost() {
		return AssociatedCost;
	}

	/**
	 * @param associatedCost the associatedCost to set
	 */
	public void setAssociatedCost(int associatedCost) {
		AssociatedCost = associatedCost;
	}

	/**
	 * @return the listScientificProject
	 */
	public ListProject getListScientificProject() {
		return listScientificProject;
	}

	/**
	 * @param listScientificProject the listScientificProject to set
	 */
	public void setListScientificProject(ListProject listScientificProject) {
		this.listScientificProject = listScientificProject;
	}
	/**
	 * @return the listRegistry
	 */
	public ListRegistry getListRegistry() {
		return listRegistry;
	}
	
	/**
	 * @param listRegistry the listRegistry to set
	 */
	public void setListRegistry(ListRegistry listRegistry) {
		this.listRegistry = listRegistry;
	}
	/**
	 * @return the listInstallationScientist
	 */
	public ListInstallation getlistInstallationScientist() {
		return listInstallationScientist;
	}
	
	/**
	 * @param listInstallationScientist the listInstallationScientist to set
	 */
	public void setlistInstallationScientist(ListInstallation listInstallationScientist) {
		this.listInstallationScientist = listInstallationScientist;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */

	@Override
	public String toString() {
		return "Scientist [Rut=" + getRut() + ", Name=" + getName() + ", LastName=" + getLastName() + ", MotherLastName="
				+ getMotherLastName() + ", Area=" + getArea() + ", AssociatedCost=" + getAssociatedCost();
	}

	
	
}