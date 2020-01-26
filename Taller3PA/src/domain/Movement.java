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
	 * @params Rut,NameDepartment
	 */
	private String Rut;
	private String NameDepartment;
	
	/**
	 * @param Rut
	 * @param NameDepartment
	 */
	public Movement(String Rut,String NameDepartment) {
		this.Rut = Rut;
		this.NameDepartment=NameDepartment;
		
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
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */

	@Override
	public String toString() {
		return "Movement [Rut=" + Rut 
				+ ", NameDepartment=" + NameDepartment + "]";
	}


	

}
