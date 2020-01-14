/**
 * 
 */
package domain;
/**Class Area to the system
 * @author ssp013
 *
 */
public class Area {
	/**
	 * Class to create Area.
	 * @params NameArea
	 */
	private String NameArea;
	/**
	 * @param NameArea
	 */
	public Area(String NameArea) {
		this.NameArea = NameArea;
	}
	/**
	 * @return the nameArea
	 */
	public String getNameArea() {
		return NameArea;
	}
	/**
	 * @param nameArea the nameArea to set
	 */
	public void setNameArea(String NameArea) {
		this.NameArea = NameArea;
	}
	/**
	 * (non-Javadoc)
	 * @see java.long.Objext#toString()
	 */
	@Override
	public String toString() {
		return "Area [NameArea=" + NameArea + "]";
	}
}
