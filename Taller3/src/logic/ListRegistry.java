/**
 * 
 */
package logic;
import domain.Registry;
import java.util.Arrays;
/**
 * @author ssp013
 *
 */
public class ListRegistry {
	/**
	 * @author ssp013
	 *this class is an Registry container
	 */
	private Registry [] listRegistry;
	private int cant;
	private int max;
	/**
	 * @param max
	 * The only parameter you need to enter is the maximum in the list.
	 */	
	public ListRegistry(int max) {
		// TODO Auto-generated constructor stub
		this.listRegistry = new Registry[max];
		this.cant =0;
		this.max = max;
	}
	/**
	 * @param r ,The application parameter has an registry that is entered in the class method.
	 * @return returns true or false, in case you can enter
	 */
	public boolean enterRegistry(Registry r) {
		if(cant<max) {
			listRegistry[cant]=r;
			cant++;
			return true;
		}else {
			return false;
		}
	}
	/**
	 * @param NameInstallation ,The application parameter has an NameInstallation that is used to search a Registry
	 * @return Search for a registry, in case you find it returns a registry or otherwise, a null.
	 */
	public Registry searchRegistry(String NameInstallation) {
		int k;
		for(k=0;k<cant;k++) {
			if(listRegistry[k].getNameInstallation().equals(NameInstallation)) {
				break;
			}
		}
		if(k==cant) {
			return null;
		}else {
			return listRegistry[k];
		}
	}
	/**
	 * @param i, The application of this parameter has an to search a Registry in the specific location of the list.
	 * @return a registry returns, in the case that there is the position sought
	 */
	public Registry getRegistryI(int i) {
		if(i>=0 && i<cant) {
			return listRegistry[i];
		}else {
			return null;
		}
	}
	/**
	 * @param 
	 * @return returns the registry quantity
	 */
	public int RegistrytQuantity() {
		return cant;
	}
	@Override
	public String toString() {
		return "ListRegistry [listRegistry=" + Arrays.toString(listRegistry) + ", cant=" + cant + ", max=" + max + "]";
	}
	
	
	
	
}
