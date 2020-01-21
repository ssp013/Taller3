/**
 * 
 */
package logic;

import java.util.Arrays;

import domain.Project;

/**
 * @author ssp013
 *
 */
public class ListProject {
	private Project[]listProject;
	private int max;
	private int cant;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */
	public ListProject(int max) {
		this.listProject = new Project[max];
		this.cant = 0;
		this.max = max;
	}
	/**
	 * @param P ,The application parameter has an Project that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	
    public boolean enterProject(Project P){
    	if(cant < max) {
    		listProject[cant]=P;
    		cant++;
    		return true;
    	}else {
    		return false;
    	}
    }
    /**
	 * @param P ,The application parameter is a project that wants to be removed.
	 * @return returns true or false, in case you can delete.
	 */
    public boolean deleteProject(Project P) {
    	boolean resp = false;
    	int k;
    	for(k=0;k<cant;k++){
    		if(listProject[k].getProjectName().equals(P.getProjectName())){
    			break;
    		}
    	}
    	if(k==cant){
    		resp = false;
    	}else {
    		for(int j=k;k<cant-1;j++) {
    			listProject[j]=listProject[j+1];
    		}
    		resp = true;
    	}
    	return resp;
    }
    /**
	 * @param ProjectCode ,The application parameter has an ProjectCode that is used to search a Project.
	 * @return Search for a Project, in case you find it returns a Project or otherwise, a null.
	 */
    
    public Project searchProyect(String ProjectCode) {
    	int k;
    	for(k=0;k<cant;k++) {
    		if(listProject[k].getProjectCode().equals(ProjectCode)) {
    			break;
    		}
    	}
    	if(k==cant) {
    		return null;
    	}else {
    		return listProject[k];
    	}
    }
    /**
	 * @param i, The application of this parameter has an to search a Project in the specific location of the list.
	 * @return a Project returns, in the case that there is the position sought
	 */
    public Project getProject(int i) {
    	if(i>=0 && i<cant){
    		return listProject[i];
    	}else {
    		return null;
    	}
    }
    /**
	 * @param 
	 * @return returns the project quantity
	 */
    public int projectQuantity(){
    	return cant;
    	
    }
	@Override
	public String toString() {
		String r="";
		for(int i=0; i<cant;i++) {
			r=r+"CODE "+getProject(i).getProjectCode() +" - Name: "+getProject(i).getProjectName()
					+ "List Department: "+getProject(i).getListDepartment().toString()+
					"List Areas"+getProject(i).getListArea().toString()
					+"\n";
			
		}
		return r;
	}
    
}
