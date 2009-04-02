package particlesim;

import java.util.Arrays;
import java.util.List;

/**
 * An implementation of the IParticle interface for a particle affected by electric fields
 *
 * @author Josh W
 */
public class ElecFieldParticle implements IParticle {

    /**
	 * Variables for persisting property values.
	 */
     protected Characteristic[] chrs;
     protected Medium med;
     protected float x;
     protected float y;
     protected float z;
     protected IParticleSize pSize;

     public ElecFieldParticle() {

         //Initialize the variables that persist property values
         this.med = null; //no medium by default

         this.x = 0;
         this.y = 0;
         this.z = 0;
         this.orientation = 0;

         // Particles affected by electric fields contain 7 different properties
         // The orientation of the particle in degrees and X and Y values for dipole moments, force and velocity

        this.chrs = new Characteristic[17];

        // The dipole moment, induced by the impressed electric field on every particle
        this.chrs[0] = new Characteristic();
        this.chrs[0].ct = new CharacteristicType();
        this.chrs[0].ct.setName("Dipole Moment X");
        this.chrs[0].ct.setDescription("The dipole moment induced by the particle due to the electric field along the x axis.");
        // Default to 0
        this.chrs[0].setBehaviourModifier(0);

        this.chrs[1] = new Characteristic();
        this.chrs[1].ct = new CharacteristicType();
        this.chrs[1].ct.setName("Dipole Moment Y");
        this.chrs[1].ct.setDescription("The dipole moment induced by the particle due to the electric field along the y axis.");
        // Default to 0
        this.chrs[1].setBehaviourModifier(0);

        //The force on each particle, created by the second order electric fields created on each particle by dipole moments
        this.chrs[2] = new Characteristic();
        this.chrs[2].ct = new CharacteristicType();
        this.chrs[2].ct.setName("Force X");
        this.chrs[2].ct.setDescription("The force induced on the x axis of the particle by the second order electric fields.");
        // Default to 0
        this.chrs[2].setBehaviourModifier(0);

        this.chrs[3] = new Characteristic();
        this.chrs[3].ct = new CharacteristicType();
        this.chrs[3].ct.setName("Force Y");
        this.chrs[3].ct.setDescription("The force induced on the y axis of the particle by the second order electric fields.");
        // Default to 0
        this.chrs[3].setBehaviourModifier(0);

        //The velocity of the particles, determined by force
        this.chrs[4] = new Characteristic();
        this.chrs[4].ct = new CharacteristicType();
        this.chrs[4].ct.setName("Velocity X");
        this.chrs[4].ct.setDescription("The velocity on the x axis of the particle.");
        // Default to 0
        this.chrs[4].setBehaviourModifier(0);

        this.chrs[5] = new Characteristic();
        this.chrs[5].ct = new CharacteristicType();
        this.chrs[5].ct.setName("Velocity Y");
        this.chrs[5].ct.setDescription("The velocity on the y axis of the particle.");
        // Default to 0
        this.chrs[5].setBehaviourModifier(0);

        // The orientation of a particle respective to the x axis of the lab frame
        this.chrs[6] = new Characteristic();
        this.chrs[6].ct = new CharacteristicType();
        this.chrs[6].ct.setName("Orientation");
        this.chrs[6].ct.setDescription("The orientation of the particle respective to the x axis of the lab frame.");
        // Default to 0
        this.chrs[6].setBehaviourModifier(0);

        // The polarizability of a particle parallel to the major axis
        this.chrs[7] = new Characteristic();
        this.chrs[7].ct = new CharacteristicType();
        this.chrs[7].ct.setName("Parallel Polarizability");
        this.chrs[7].ct.setDescription("The polarizability of a particle parallel to the major axis.");
        // Default to 0
        this.chrs[7].setBehaviourModifier(0);

        // The polarizability of a particle perpendicular to the major axis
        this.chrs[8] = new Characteristic();
        this.chrs[8].ct = new CharacteristicType();
        this.chrs[8].ct.setName("Perpendicular Polarizability");
        this.chrs[8].ct.setDescription("The polarizability of a particle perpendicular to the major axis.");
        // Default to 0
        this.chrs[8].setBehaviourModifier(0);

        // The electric field impressed on the particle's X axis
        this.chrs[9] = new Characteristic();
        this.chrs[9].ct = new CharacteristicType();
        this.chrs[9].ct.setName("Impressed Field X");
        this.chrs[9].ct.setDescription("The electric field impressed on the particle's X axis.");
        // Default to 0
        this.chrs[9].setBehaviourModifier(0);

        // The electric field impressed on the particle's Y axis
        this.chrs[10] = new Characteristic();
        this.chrs[10].ct = new CharacteristicType();
        this.chrs[10].ct.setName("Impressed Field Y");
        this.chrs[10].ct.setDescription("The electric field impressed on the particle's Y axis.");
        // Default to 0
        this.chrs[10].setBehaviourModifier(0);

        // The rotational mobility of a particle parallel to the major axis
        this.chrs[11] = new Characteristic();
        this.chrs[11].ct = new CharacteristicType();
        this.chrs[11].ct.setName("Parallel Rotational Mobility");
        this.chrs[11].ct.setDescription("The rotational mobility of a particle parallel to the major axis.");
        // Default to 0
        this.chrs[11].setBehaviourModifier(0);

        // The rotational mobility of a particle parallel to the major axis
        this.chrs[12] = new Characteristic();
        this.chrs[12].ct = new CharacteristicType();
        this.chrs[12].ct.setName("Perpendicular Rotational Mobility");
        this.chrs[12].ct.setDescription("The rotational mobility of a particle perpendicular to the major axis.");
        // Default to 0
        this.chrs[12].setBehaviourModifier(0);
        
        this.chrs[13] = new Characteristic();
        this.chrs[13].ct = new CharacteristicType();
        this.chrs[13].ct.setName("Final Second Order Electric Field X");
        this.chrs[13].ct.setDescription("The second order electric field on the x axis after all calculations are complete.");
        // Default to 0
        this.chrs[13].setBehaviourModifier(0);
        
        this.chrs[14] = new Characteristic();
        this.chrs[14].ct = new CharacteristicType();
        this.chrs[14].ct.setName("Final Second Order Electric Field Y");
        this.chrs[14].ct.setDescription("The second order electric field on the y axis after all calculations are complete.");
        // Default to 0
        this.chrs[14].setBehaviourModifier(0);

        this.chrs[15] = new Characteristic();
        this.chrs[15].ct = new CharacteristicType();
        this.chrs[15].ct.setName("Previous Second Order Electric Field X");
        this.chrs[15].ct.setDescription("The second order electric field on the x axis from the last iteration.");
        // Default to 0
        this.chrs[15].setBehaviourModifier(0);

        this.chrs[16] = new Characteristic();
        this.chrs[16].ct = new CharacteristicType();
        this.chrs[16].ct.setName("Previous Second Order Electric Field Y");
        this.chrs[16].ct.setDescription("The second order electric field on the y axis from the last iteration.");
        // Default to 0
        this.chrs[16].setBehaviourModifier(0);


     }

     /**
     * @see IParticle#getCharacteristic()
     * @return
     */
       public Characteristic[] getCharacteristic() {
        return this.chrs;
    }

       /**
     * @see IParticle#setCharacteristic(particlesim.Characteristic[])
     * @param newValue
     */
    public void setCharacteristic(Characteristic[] newValue) {
        this.chrs = newValue;
    }

    /**
     * @see IParticle#getMedium()
     * @return
     */
    public Medium getMedium() {
        return this.med;
    }

    /**
     * @see IParticle#setMedium(particlesim.Medium)
     * @param newValue
     */
    public void setMedium(Medium newValue) {
        this.med = newValue;
    }

     /**
     * @see IParticle#getX()
     * @return
     */
    public float getX() {
        return this.x;
    }

    /**
     * @see IParticle#setX(float)
     * @param newValue
     */
    public void setX(float newValue) {
        this.x = newValue;
    }

    /**
     * @see IParticle#getY()
     * @return
     */
    public float getY() {
        return this.y;
    }

    /**
     * @see IParticle#setY(float)
     * @param newValue
     */
    public void setY(float newValue) {
        this.y = newValue;
    }

    /**
     * @see IParticle#getZ()
     * @return
     */
    public float getZ() {
        return this.z;
    }

    /**
     * @see IParticle#setZ(float)
     * @param newValue
     */
    public void setZ(float newValue) {
        this.z = newValue;
    }


    /**
     * @see IParticle#getParticleSize()
     * @return
     */
    public IParticleSize getParticleSize() {
        return this.pSize;
    }

    /**
     * @see IParticle#setParticleSize(java.lang.Object)
     * @param ParticleSize
     */
    public void setParticleSize(IParticleSize ParticleSize) {
        this.pSize = ParticleSize;
    }

    /**
     * @see IParticle#getCalcName()
     * @return
     */
    public String getCalcName() {
        return "particlesim.CalculateElecFieldParticle";
    }

    /**
     * @see IParticle#getParticleSizeName()
     * @return
     */
    public String getParticleSizeName() {
        return "particlesim.ParticleSizeEllipse";
    }

}
