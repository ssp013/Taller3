/**
 * 
 */
package domain;

/**
 * @author sebastiansanchez
 * Class to create Any Movement.
 * @params MovementName,data_of_the_movement
 */
public class AnyMovements {
	private String MovementName;
	private String data_of_the_movement;
	/**
	 * @param MovementName
	 * @param data_of_the_movement
	 */
	public AnyMovements(String MovementName,String data_of_the_movement) {
		this.MovementName = MovementName;
		this.data_of_the_movement = data_of_the_movement;
	}
	/**
	 * @return the movementName
	 */
	public String getMovementName() {
		return MovementName;
	}
	/**
	 * @param movementName the movementName to set
	 */
	public void setMovementName(String movementName) {
		MovementName = movementName;
	}
	/**
	 * @return the data_of_the_movement
	 */
	public String getData_of_the_movement() {
		return data_of_the_movement;
	}
	/**
	 * @param data_of_the_movement the data_of_the_movement to set
	 */
	public void setData_of_the_movement(String data_of_the_movement) {
		this.data_of_the_movement = data_of_the_movement;
	}
	@Override
	public String toString() {
		return "AnyMovements [MovementName=" + MovementName + ", data_of_the_movement=" + data_of_the_movement + "]";
	}
	
	
}
