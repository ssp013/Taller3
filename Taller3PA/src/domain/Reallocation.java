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
	private String instaOld;
	private String instaNew;
	private String codeOld;
	private String codeNow;
	/**
	 * Class to create Hiring.
	 * @param Date
	 *  @param instaOld
	 *  @param instaNew
	 *  @param CodeOld
	 *  @param CodeNew
	 */
	public Reallocation(String Rut,String NameDepartment,String Date, String instaOld,String instaNew,String codeNow,String codeOld) {
		// TODO Auto-generated constructor stub
		super(Rut,NameDepartment);
		this.Date = Date;
		this.instaOld = instaOld;
		this.instaNew=instaNew;
		this.codeNow=codeNow;
		this.codeOld = codeOld;
		
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
	 * @return the instaOld
	 */
	public String getInstaOld() {
		return instaOld;
	}
	/**
	 * @param instaOld the instaOld to set
	 */
	public void setInstaOld(String instaOld) {
		this.instaOld = instaOld;
	}
	/**
	 * @return the instaNew
	 */
	public String getInstaNew() {
		return instaNew;
	}
	/**
	 * @param instaNew the instaNew to set
	 */
	public void setInstaNew(String instaNew) {
		this.instaNew = instaNew;
	}
	/**
	 * @return the codeOld
	 */
	public String getCodeOld() {
		return codeOld;
	}
	/**
	 * @param codeOld the codeOld to set
	 */
	public void setCodeOld(String codeOld) {
		this.codeOld = codeOld;
	}
	/**
	 * @return the codeNow
	 */
	public String getCodeNow() {
		return codeNow;
	}
	/**
	 * @param codeNow the codeNow to set
	 */
	public void setCodeNow(String codeNow) {
		this.codeNow = codeNow;
	}
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Reallocation [Date=" + Date + ", instaOld=" + instaOld + ", instaNew=" + instaNew + ", codeOld="
				+ codeOld + ", codeNow=" + codeNow + "]";
	}
	


	

	
}
