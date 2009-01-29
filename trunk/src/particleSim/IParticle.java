/**
 * 
 */
package particleSim;

/**
 * @author Sheppe
 *
 */
public interface IParticle {
	// Begin Properties
	Characteristic[] getCharacteristic();
	void setCharacteristic(Characteristic[] newValue);
	
	Medium getMedium();
	void setMedium(Medium newValue);
	
	float getX();
	void setX(float newValue);

	float getY();
	void setY(float newValue);

	float getZ();
	void setZ(float newValue);
	// End Properties
	
	// Begin Functions
	// End Functions
}
