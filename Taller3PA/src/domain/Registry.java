/**
 * 
 */
package domain;

/**System Registry class
 * @author ssp013
 *
 */
public class Registry {
	/**
	 * 
	 */
	private String NameInstallation;
	private String Rut;
	private String DateIn;
	private String DateOut;
	private String HourIn;
	private String HourOut;
	
	/**
	 * @param NameInstallation
	 * @param Rut
	 * @param DateIn
	 * @param DateOut
	 * @param HourIn
	 * @param HourOut
	 */
	public Registry(String NameInstallation, String Rut, String DateIn,String DateOut,String HourIn, String HourOut){
		// TODO Auto-generated constructor stub
		this.NameInstallation = NameInstallation;
		this.Rut = Rut;
		this.DateIn = DateIn;
		this.DateOut = DateOut;
		this.HourIn = HourIn;
		this.HourOut = HourOut;
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
		return "Registry [NameInstallation=" + NameInstallation + ", Rut=" + Rut + ", DateIn=" + DateIn + ", DateOut="
				+ DateOut + ", HourIn=" + HourIn + ", HourOut=" + HourOut + ", getNameInstallation()="
				+ getNameInstallation() + ", getRut()=" + getRut() + ", getDateIn()=" + getDateIn() + ", getDateOut()="
				+ getDateOut() + ", getHourIn()=" + getHourIn() + ", getHourOut()=" + getHourOut() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
