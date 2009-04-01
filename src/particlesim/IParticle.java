package particlesim;

/**
 * Interface for the Particle class.
 * @author Sheppe
 */
public interface IParticle {
	// Begin Properties
    /**
     * An array of type Characteristic. Represents all of the known
     * characteristics of a particle.
     * @return
     */
	Characteristic[] getCharacteristic();
    /**
     * An array of type Characteristic. Represents all of the known 
     * characteristics of a particle.
     * @param newValue
     */
    void setCharacteristic(Characteristic[] newValue);

    /**
     * The medium in which the particle exists.
     * @return
     */
    Medium getMedium();
    /**
     * The medium in which the particle exists.
     * @param newValue
     */
	void setMedium(Medium newValue);

	/**
     * The X coordinate of the particle.
     * @return
     */
    float getX();
    /**
     * The X coordinate of the particle.
     * @param newValue
     */
	void setX(float newValue);

	/**
     * The Y coordinate of the particle.
     * @return
     */
    float getY();
    /**
     * The Y coordinate of the particle.
     * @param newValue
     */
	void setY(float newValue);

	/**
     * The Z coordinate of the particle.
     * @return
     */
    float getZ();
    /**
     * The Z coordinate of the particle.
     * @param newValue
     */
	void setZ(float newValue);

	/**
     * An object to contain the ParticleSize class being used for this particle type.
     * @return An IParticleSize class implementation.
     */
    IParticleSize getParticleSize();

    /**
     * An object to contain the ParticleSize class being used for this particle type.
     * @param ParticleSize The applicable ParticleSize class being used by this particle type.
     */
    void setParticleSize(IParticleSize ParticleSize);
    // End Properties

	// Begin Functions

    /**
     * Returns the package and class name (ie: particlesim.CalculateCharged) of
     * the ICalculate implementation to use.
     * @return
     */
    String getCalcName();

    /**
     * Returns the package and class name (ie: particlesim.ParticleSizeEllipse) of
     * the IParticleSize implementation to use.
     * @return
     */
    String getParticleSizeName();
    
    // End Functions
}
