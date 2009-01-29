/**
 * 
 */
package particleSim;

/**
 * @author Sheppe
 *
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

	/* (non-Javadoc)
	 * @see particleSim.ICharacteristic#getCharacteristicType()
	 */
	public CharacteristicType getCharacteristicType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see particleSim.ICharacteristic#setCharacteristicType(particleSim.CharacteristicType)
	 */
	public void setCharacteristicType(CharacteristicType newValue) {
		// TODO Auto-generated method stub

	}

	public float getBehaviourModifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setBehaviourModifier(float newValue) {
		// TODO Auto-generated method stub
		
	}

}
