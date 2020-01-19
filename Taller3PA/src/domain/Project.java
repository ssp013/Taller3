package domain;
import logic.ListArea;
import logic.ListDepartment;
/**
 * Class Project to the system
 * @author ssp013
 *
 */
public class Project{
	/**
	 * Class to create Project.
	 * @params ProjectCode,ProjectName,TotalBudget,ResponsibleDepartment,NumberOfAreasOfExpertise
	 */
	private String ProjectCode;
	private String ProjectName;
	private int TotalBudget;
	private String ResponsibleDepartment;
	private int NumberOfAreasOfExpertise;
	private ListArea listArea;
	private ListDepartment listDepartment;
	/**
	 * @param ProjectCode
	 * @param ProjectName
	 * @param TotalBudget
	 * @param ResponsibleDepartment
	 * @param NumberOfAreasOfExpertise
	 */
	public Project(String ProjectCode,String ProjectName,int TotalBudget,String ResponsibleDepartment,int NumberOfAreasOfExpertise) {
		this.ProjectCode = ProjectCode;
		this.ProjectName = ProjectName;
		this.TotalBudget = TotalBudget;
		this.ResponsibleDepartment = ResponsibleDepartment;
		this.NumberOfAreasOfExpertise = NumberOfAreasOfExpertise;
		listArea = new ListArea(100);
		listDepartment = new ListDepartment(100);
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
	 * @return the projectName
	 */
	public String getProjectName() {
		return ProjectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	/**
	 * @return the totalBudget
	 */
	public int getTotalBudget() {
		return TotalBudget;
	}
	/**
	 * @param totalBudget the totalBudget to set
	 */
	public void setTotalBudget(int totalBudget) {
		TotalBudget = totalBudget;
	}
	/**
	 * @return the responsibleDepartment
	 */
	public String getResponsibleDepartment() {
		return ResponsibleDepartment;
	}
	/**
	 * @param responsibleDepartment the responsibleDepartment to set
	 */
	public void setResponsibleDepartment(String responsibleDepartment) {
		ResponsibleDepartment = responsibleDepartment;
	}
	/**
	 * @return the numberOfAreasOfExpertise
	 */
	public int getNumberOfAreasOfExpertise() {
		return NumberOfAreasOfExpertise;
	}
	/**
	 * @param numberOfAreasOfExpertise the numberOfAreasOfExpertise to set
	 */
	public void setNumberOfAreasOfExpertise(int numberOfAreasOfExpertise) {
		NumberOfAreasOfExpertise = numberOfAreasOfExpertise;
	}
	/**
	 * @return the listArea
	 */
	public ListArea getListArea() {
		return listArea;
	}
	/**
	 * @param listArea the listArea to set
	 */
	public void setListArea(ListArea listArea) {
		this.listArea = listArea;
	}
	/**
	 * @return the listDepartment
	 */
	public ListDepartment getListDepartment() {
		return listDepartment;
	}
	/**
	 * @param listDepartment the listDepartment to set
	 */
	public void setListDepartment(ListDepartment listDepartment) {
		this.listDepartment = listDepartment;
	}
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Project [ProjectCode=" + ProjectCode + ", ProjectName=" + ProjectName + ", TotalBudget=" + TotalBudget
				+ ", ResponsibleDepartment=" + ResponsibleDepartment + ", NumberOfAreasOfExpertise="
				+ NumberOfAreasOfExpertise + ", listArea=" + listArea + ", listDepartment=" + listDepartment + "]";
	}
}
