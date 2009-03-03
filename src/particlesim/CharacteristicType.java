package particlesim;

/**
 * Implementation of the CharacteristicType interface.
 * @author Sheppe
 */
public class CharacteristicType implements ICharacteristicType {

	/**
	 * Variables for persisting property values.
	 */
	String desc;
	String name;

	/**
	 * @see CharacteristicType#CharacteristicType()
	 */
	public CharacteristicType() {
		// Initialize the variables that persist property values.
		desc = "";
		name = "";
	}

	/**
     * @see CharacteristicType#getDescription()
     * @return
     */
	public String getDescription() {
		return desc;
	}

	/**
     * @see CharacteristicType#getName()
     * @return
     */
	public String getName() {
		return name;
	}

	/**
     * @see CharacteristicType#setDescription(java.lang.String)
     * @param newValue
     */
	public void setDescription(String newValue) {
		desc = newValue;
	}

	/**
     * @see CharacteristicType#setName(java.lang.String)
     * @param newValue
     */
	public void setName(String newValue) {
		name = newValue;
	}
}
