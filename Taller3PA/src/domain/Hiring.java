/**
 * 
 */
package domain;

/**Class Hiring to the system
 * @author ssp013
 *
 */
public class Hiring extends Movement {
	/**
	 * 
	 */
	private String NameDepartment;
	private String Date;
	/**
	 * Class to create Hiring.
	 * @param NameDepartment
	 * @param Date
	 */
	public Hiring(String Rut,String NameInstallation,String DateIn,String DateOut,String HourIn,String HourOut,String projectCode,String  NameDepartment,String Date) {
		// TODO Auto-generated constructor stub
		super(Rut,NameInstallation,DateIn,DateOut,HourIn,HourOut, projectCode);
		this.NameDepartment=NameDepartment;
		this.Date = Date;
	}
	/**
	 * @return the nameDepartment
	 */
	public String getNameDepartment() {
		return NameDepartment;
	}
	/**
	 * @param nameDepartment the nameDepartment to set
	 */
	public void setNameDepartment(String nameDepartment) {
		NameDepartment = nameDepartment;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Hiring [NameDepartment=" + NameDepartment + ", Date=" + Date + ", getNameDepartment()="
				+ getNameDepartment() + ", getDate()=" + getDate() + ", getRut()=" + getRut()
				+ ", getNameInstallation()=" + getNameInstallation() + ", getDateIn()=" + getDateIn()
				+ ", getDateOut()=" + getDateOut() + ", getHourIn()=" + getHourIn() + ", getHourOut()=" + getHourOut()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	

}