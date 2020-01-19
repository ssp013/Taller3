/**
 * 
 */
package domain;

/**System movement class
 * @author ssp013
 *
 */
public abstract class Movement {
	/**
	 * Class to create Movement.
	 * @params Rut, NameInstallation,DateIn,DateOut,HourIn,HourOut
	 */
	private String Rut;
	private String NameInstallation;
	private String DateIn;
	private String DateOut;
	private String HourIn;
	private String HourOut;
	private String ProjectCode;
	

	/**
	 * @param rut
	 * @param nameInstallation
	 * @param dateIn
	 * @param dateOut
	 * @param hourIn
	 * @param hourOut
	 * @param projectCode
	 */
	public Movement(String rut, String nameInstallation, String dateIn, String dateOut, String hourIn, String hourOut,String projectCode) {
		Rut = rut;
		NameInstallation = nameInstallation;
		DateIn = dateIn;
		DateOut = dateOut;
		HourIn = hourIn;
		HourOut = hourOut;
		ProjectCode = projectCode;
	}

	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		Rut = rut;
	}
	
	/**
	 * @return the rut
	 */
	public String getRut() {
		return Rut;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return ProjectCode;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		ProjectCode = projectCode;
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
	 * @return the dateIn
	 */
	public String getDateIn() {
		return DateIn;
	}

	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateIn(String dateIn) {
		DateIn = dateIn;
	}

	/**
	 * @return the dateOut
	 */
	public String getDateOut() {
		return DateOut;
	}

	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateOut(String dateOut) {
		DateOut = dateOut;
	}

	/**
	 * @return the hourIn
	 */
	public String getHourIn() {
		return HourIn;
	}

	/**
	 * @param hourIn the hourIn to set
	 */
	public void setHourIn(String hourIn) {
		HourIn = hourIn;
	}

	/**
	 * @return the hourOut
	 */
	public String getHourOut() {
		return HourOut;
	}

	/**
	 * @param hourOut the hourOut to set
	 */
	public void setHourOut(String hourOut) {
		HourOut = hourOut;
	}
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Movement [Rut=" + Rut + ", NameInstallation=" + NameInstallation + ", DateIn=" + DateIn + ", DateOut="
				+ DateOut + ", HourIn=" + HourIn + ", HourOut=" + HourOut + "]";
	}
	

}
