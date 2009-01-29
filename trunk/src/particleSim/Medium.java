/**
 * 
 */
package particleSim;

/**
 * @author Sheppe
 *
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

	/* (non-Javadoc)
	 * @see particleSim.IMedium#getGravity()
	 */
	public float getGravity() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see particleSim.IMedium#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see particleSim.IMedium#getViscosity()
	 */
	public float getViscosity() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see particleSim.IMedium#setGravity(float)
	 */
	public void setGravity(float newValue) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see particleSim.IMedium#setName(java.lang.String)
	 */
	public void setName(String newValue) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see particleSim.IMedium#setViscosity(float)
	 */
	public void setViscosity(float newValue) {
		// TODO Auto-generated method stub

	}

}
