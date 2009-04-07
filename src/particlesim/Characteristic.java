package particlesim;

/**
 * Implementation of the ICharacteristic interface.
 * @author Sheppe
 */
public class Characteristic implements ICharacteristic {

	/**
	 * Variables for persisting property values.
	 */
	CharacteristicType ct;
	float bm;

	/**
	 * @see Characteristic#Characteristic()
	 */
	public Characteristic() {
		// Initialize the variables that persist property values.
		ct = new CharacteristicType();
		bm = 0.0F;
	}

    /**
     * @see Characteristic#getCharacteristicType()
     * @return CharacteristicType
     */
    public CharacteristicType getCharacteristicType() {
		return ct;
	}

    /**
     * @see Characteristic#setCharacteristicType(particlesim.CharacteristicType)
     * @param newValue CharacteristicType
     */
	public void setCharacteristicType(CharacteristicType newValue) {
		ct = newValue;
	}

    /**
     * @see Characteristic#getBehaviourModifier()
     * @return A float that represents the quantitative value of a
     * characteristic behaviour.
     */
    public float getBehaviourModifier() {
		return bm;
	}

    /**
     * @see Characteristic#setBehaviourModifier(float)
     * @param newValue float
     */
	public void setBehaviourModifier(float newValue) {
		bm = newValue;
	}
}
