/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
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
	 *
	 */
	public Medium() {
		// Initialize the variables that persist property values.
		gvty = 0;
		name = "";
		vscty = 0;
	}

	/**
     *
     * @return
     */
	public float getGravity() {
		return gvty;
	}

    /**
     * 
     * @return
     */
    public String getName() {
		return name;
	}

    /**
     *
     * @return
     */
	public float getViscosity() {
		return vscty;
	}

    /**
     *
     * @param newValue
     */
	public void setGravity(float newValue) {
        gvty = newValue;
	}

	/**
     *
     * @param newValue
     */
	public void setName(String newValue) {
        name = newValue;
	}

	/**
     *
     * @param newValue
     */
	public void setViscosity(float newValue) {
        vscty = newValue;
    }
}
