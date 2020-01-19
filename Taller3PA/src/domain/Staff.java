/**
 * 
 */
package domain;


/**Class Scientist to the system
 * @author ssp013
 *
 */
public  abstract class Staff {
	/**
	 * Class to create Staff.
	 * @params Rut,Name,LastName,MotherLastName,Area
	 */
	private String Rut;
	private String Name;
	private String LastName;
	private String MotherLastName;
	private String Area;
	/**
	 * @param Rut
	 * @param Name
	 * @param LastName
	 * @param MotherLastName
	 * @param Area
	 */
	public Staff(String Rut, String Name, String LastName,String MotherLastName,String Area){
		this.Rut = Rut;
		this.Name = Name;
		this.LastName = LastName;
		this.MotherLastName = MotherLastName;
		this.Area = Area;
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
	
	
}
