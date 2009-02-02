/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public class CharacteristicType implements ICharacteristicType {

	/**
	 * Variables for persisting property values.
	 */
	String desc;
	String name;

	/**
	 *
	 */
	public CharacteristicType() {
		// Initialize the variables that persist property values.
		desc = "";
		name = "";
	}

	/**
     *
     * @return
     */
	public String getDescription() {
		return desc;
	}

	/**
     *
     * @return
     */
	public String getName() {
		return name;
	}

	/**
     *
     * @param newValue
     */
	public void setDescription(String newValue) {
		desc = newValue;
	}

	/**
     *
     * @param newValue
     */
	public void setName(String newValue) {
		name = newValue;
	}
}
