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
	private String Date;
	private String NameInstallation;
	/**
	 * Class to create Hiring.
	 * @param Date
	 *  @param NameInstallation
	 */
	public Hiring(String Rut
			,String NameDepartment,String Date,String NameInstallation) {
		// TODO Auto-generated constructor stub
		super(Rut,NameDepartment);
		this.Date = Date;
		this.NameInstallation = NameInstallation;
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
	 * @return the nameInstallation
	 */
	public String getNameInstallation() {
		return NameInstallation;
	}

	/**
	 * @param nameInstallation the nameInstallation to set
	 */
	public void setNameInstallation(String nameInstallation) {
		NameInstallation = nameInstallation;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
}