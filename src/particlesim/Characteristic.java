/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public class Characteristic implements ICharacteristic {

	/**
	 * Variables for persisting property values.
	 */
	CharacteristicType ct;
	float bm;

	/**
	 *
	 */
	public Characteristic() {
		// Initialize the variables that persist property values.
		ct = new CharacteristicType();
		bm = 0;
	}

    /**
     * 
     * @return
     */
    public CharacteristicType getCharacteristicType() {
		return ct;
	}

    /**
     *
     * @param newValue
     */
	public void setCharacteristicType(CharacteristicType newValue) {
		ct = newValue;
	}

    /**
     * 
     * @return
     */
    public float getBehaviourModifier() {
		return bm;
	}

    /**
     *
     * @param newValue
     */
	public void setBehaviourModifier(float newValue) {
		bm = newValue;
	}
}
