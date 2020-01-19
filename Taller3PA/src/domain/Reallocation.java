/**
 * 
 */
package domain;

/**
 * @author ssp013
 *
 */
public class Reallocation extends Movement{
	/**
	 * 
	 */
	private String Date;
	/**
	 * Class to create Reallocation.
	 * @param Date
	 */
	public Reallocation(String Rut,String NameInstallation,String DateIn,String DateOut,String HourIn,String HourOut,String projectCode,String Date) {
		// TODO Auto-generated constructor stub
		super(Rut,NameInstallation,DateIn,DateOut,HourIn,HourOut,projectCode);
		this.Date = Date;
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
		return "Reallocation [Date=" + Date + ", getDate()=" + getDate() + ", getRut()=" + getRut()
				+ ", getNameInstallation()=" + getNameInstallation() + ", getDateIn()=" + getDateIn()
				+ ", getDateOut()=" + getDateOut() + ", getHourIn()=" + getHourIn() + ", getHourOut()=" + getHourOut()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
