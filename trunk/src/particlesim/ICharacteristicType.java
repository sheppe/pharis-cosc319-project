package particlesim;

/**
 * Interface for the CharacteristicType class. A characteristic type describes
 * a particular characteristic.
 * @author Sheppe
 */
public interface ICharacteristicType {
	// Begin Properties
    /**
     * The name of the characteristic type.
     * @return
     */
	String getName();
    /**
     * The name of the characteristic type.
     * @param newValue
     */
	void setName(String newValue);

	/**
     * The description of the characteristic type.
     * @return
     */
    String getDescription();
    /**
     * The description of the characteristic type.
     * @param newValue
     */
	void setDescription(String newValue);
	// End Properties

	// Begin Functions
	// End Functions
}
