
package particlesim;

/**
 * The medium in which a particle exists.
 * @author Sheppe
 */
public class Medium implements IMedium {

	/**
	 * Variables for persisting property values.
	 */
	float gvty;
	String name;
	float vscty;

	/**
	 * @see IMedium#()
	 */
	public Medium() {
		// Initialize the variables that persist property values.
		gvty = 0;
		name = "";
		vscty = 0;
	}

	/**
     * @see IMedium#getGravity()
     * @return
     */
	public float getGravity() {
		return gvty;
	}

    /**
     * @see IMedium#getName()
     * @return
     */
    public String getName() {
		return name;
	}

    /**
     * @see IMedium#getViscosity()
     * @return
     */
	public float getViscosity() {
		return vscty;
	}

    /**
     * @see IMedium#setGravity(float)
     * @param newValue
     */
	public void setGravity(float newValue) {
        gvty = newValue;
	}

	/**
     * @see IMedium#setName(java.lang.String)
     * @param newValue
     */
	public void setName(String newValue) {
        name = newValue;
	}

	/**
     * @see IMedium#setViscosity(float)
     * @param newValue
     */
	public void setViscosity(float newValue) {
        vscty = newValue;
    }
}
