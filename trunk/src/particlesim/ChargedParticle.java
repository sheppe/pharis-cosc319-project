/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public class ChargedParticle implements IParticle {

	/**
	 * Variables for persisting property values.
	 */
     protected Characteristic[] chrs;
     protected Medium med;
     protected float x;
     protected float y;
     protected float z;

    public ChargedParticle()
    {
    	// Initialize the variables that persist property values.
        this.med = null; // Default to no medium.

        this.x = 0;
        this.y = 0;
        this.z = 0;

        // 2D charged particles have three properties that we will begin with.
        // Their charge, the force on their x axis, and the force on their y axis.
        this.chrs = new Characteristic[3];

        this.chrs[0] = new Characteristic();
        this.chrs[0].ct = new CharacteristicType();
        this.chrs[0].ct.setName("Charge");
        this.chrs[0].ct.setDescription("The positive or negative charge value of the particle.");
        // Default to nagative. This can be modified when the array of particles is initialized.
        this.chrs[0].setBehaviourModifier(0);

        this.chrs[1] = new Characteristic();
        this.chrs[1].ct = new CharacteristicType();
        this.chrs[1].ct.setName("ForceX");
        this.chrs[1].ct.setDescription("The force applied to the x axis.");
        // Default to 0. This can be modified when the array of particles is initialized.
        this.chrs[1].setBehaviourModifier(0);

        this.chrs[2] = new Characteristic();
        this.chrs[2].ct = new CharacteristicType();
        this.chrs[2].ct.setName("ForceY");
        this.chrs[2].ct.setDescription("The force applied to the y axis.");
        // Default to 0. This can be modified when the array of particles is initialized.
        this.chrs[2].setBehaviourModifier(0);
    }
     /**
     *
     * @return
     */
    public Characteristic[] getCharacteristic() {
        return this.chrs;
    }

    /**
     *
     * @param newValue
     */
    public void setCharacteristic(Characteristic[] newValue) {
        this.chrs = newValue;
    }

    /**
     *
     * @return
     */
    public Medium getMedium() {
        return this.med;
    }

    /**
     *
     * @param newValue
     */
    public void setMedium(Medium newValue) {
        this.med = newValue;
    }

    /**
     *
     * @return
     */
    public float getX() {
        return this.x;
    }

    /**
     *
     * @param newValue
     */
    public void setX(float newValue) {
        this.x = newValue;
    }

    /**
     *
     * @return
     */
    public float getY() {
        return this.y;
    }

    /**
     *
     * @param newValue
     */
    public void setY(float newValue) {
        this.y = newValue;
    }

    /**
     *
     * @return
     */
    public float getZ() {
        return this.z;
    }

    /**
     *
     * @param newValue
     */
    public void setZ(float newValue) {
        this.z = newValue;
    }

}
