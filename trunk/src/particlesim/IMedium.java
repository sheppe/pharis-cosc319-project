package particlesim;

/**
 * Interface for the Medium class. A medium describes the fluid in which
 * particles are contained.
 * @author Sheppe
 */
public interface IMedium {
	// Begin Properties
    /**
     * The name of the medium.
     * @return
     */
	String getName();
    /**
     * The name of the medium.
     * @param newValue
     */
	void setName(String newValue);

	/**
     * The quantitative value of the medium's viscosity.
     * @return
     */
    float getViscosity();
    /**
     * The quantitative value of the medium's viscosity.
     * @param newValue
     */
	void setViscosity(float newValue);

	/**
     * The quantitative value of gravity within the medium.
     * @return
     */
    float getGravity();
    /**
     * The quantitative value of gravity within the medium.
     * @param newValue
     */
	void setGravity(float newValue);
	// End Properties

	// Begin Functions
	// End Functions
}
