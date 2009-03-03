package particlesim;

/**
 * Interface for a single particle characteristic.
 * @author Sheppe
 */
public interface ICharacteristic {
	// Begin Properties
    /**
     * A characteristic type describes the characteristic.
     * @return
     */
	CharacteristicType getCharacteristicType();
    /**
     * A characteristic type describes the characteristic.
     * @param newValue
     */
	void setCharacteristicType(CharacteristicType newValue);

	/**
     * The behaviour modifier of a characteristic is the quantitative value
     * of a particular characteristic.
     * @return
     */
    float getBehaviourModifier();
    /**
     * The behaviour modifier of a characteristic is the quantitative value
     * of a particular characteristic.
     * @param newValue
     */
    void setBehaviourModifier(float newValue);
	// End Properties

	// Begin Functions
	// End Functions
}
