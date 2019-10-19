package domain;
import logic.ListDepartment;
/**Class instalation to the system
 * @author ssp013
 *
 */
public class Installation {
	/**
	 * Class to create Instalation.
	 * @params nameInstalation, listDepartamentInstalation
	 */
	private String nameInstalation;//it's not necesary past to quantity to the list.
	private ListDepartment listDepartamentInstalation;
	
	/**
	 * @param nameInstalation
	 * @param listDepartamentInstalation
	 */
	public Installation(String nameInstalation,ListDepartment listDepartamentInstalation) {
		this.nameInstalation = nameInstalation;
		this.listDepartamentInstalation = listDepartamentInstalation;
	}
	/**
	 * @return nameInstalation
	 */
	public String getNameInstalation() {
		return nameInstalation;
	}
	/**
	 * @param nameInstalation
	 */
	public void setNameInstalation(String nameInstalation) {
		this.nameInstalation = nameInstalation;
	}
	/**
	 * @return ListDepartament
	 */
	public ListDepartment getlistDepartamentInstalation() {
		return listDepartamentInstalation;
	}
	/**
	 * @param listDepartamentInstalation
	 */
	public void setlistDepartamentInstalation(ListDepartment listDepartamentInstalation) {
		this.listDepartamentInstalation = listDepartamentInstalation;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Instalation [nameInstalation=" + nameInstalation + ", listDepartamentInstalation="
				+ listDepartamentInstalation + "]";
	}
}
