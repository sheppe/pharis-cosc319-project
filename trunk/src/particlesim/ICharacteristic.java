/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public interface ICharacteristic {
	// Begin Properties
	CharacteristicType getCharacteristicType();
	void setCharacteristicType(CharacteristicType newValue);

	float getBehaviourModifier();
	void setBehaviourModifier(float newValue);
	// End Properties

	// Begin Functions
	// End Functions
}