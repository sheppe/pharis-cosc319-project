/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public interface IMedium {
	// Begin Properties
	String getName();
	void setName(String newValue);

	float getViscosity();
	void setViscosity(float newValue);

	float getGravity();
	void setGravity(float newValue);
	// End Properties

	// Begin Functions
	// End Functions
}
