/**
 * 
 */
package domain;
import logic.ListProject;
import logic.ListRegistry;

/**Class Scientist to the system
 * @author ssp013
 *
 */
/**
 * @author ssp013
 *
 */
public class Scientist {
	/**
	 * Class to create Scientist.
	 * @params 
	 */
	private String Rut;
	private String Name;
	private String LastName;
	private String MotherLastName;
	private String Area;
	private int AssociatedCost;
	private ListProject listScientificProject;
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
		this.Rut = Rut;
		this.Name = Name;
		this.LastName = LastName;
		this.MotherLastName = MotherLastName;
		this.Area = Area;
		this.AssociatedCost =AssociatedCost;
	}

	/**
	 * @return the rut
	 */
	public String getRut() {
		return Rut;
	}

	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		Rut = rut;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the motherLastName
	 */
	public String getMotherLastName() {
		return MotherLastName;
	}

	/**
	 * @param motherLastName the motherLastName to set
	 */
	public void setMotherLastName(String motherLastName) {
		MotherLastName = motherLastName;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return Area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		Area = area;
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
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */

	@Override
	public String toString() {
		return "Scientist [Rut=" + Rut + ", Name=" + Name + ", LastName=" + LastName + ", MotherLastName="
				+ MotherLastName + ", Area=" + Area + ", AssociatedCost=" + AssociatedCost + ", listScientificProject="
				+ listScientificProject + "]";
	}

	
	
}