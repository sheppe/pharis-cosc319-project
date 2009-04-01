package particlesim;

/**
 * Interface for calculating particle characteristic values, and for calculating
 * particle movements based on these values.
 * @author Sheppe
 */
public interface ICalculate {
	// Java passes parameter variables by value, so it will be necessary
	// to have a return value on this function so the calling procedure can
	// retrieve the updated values.

    /**
     * Calculates instantaneous particle movements based on particle characteristics.
     * @param Particles The collection of particles to perform calculations on.
     * @return
     */
	public IParticle[] CalculateIteration(IParticle[] Particles);

    /**
     * Call this method to initialize your particles. This involves the creation
     * of the number of particles indicated in the NumParticles parameter.
     * @param NumParticles The number of particle to create.
     * @param MaxX The X boundary of the particles' container.
     * @param MaxY The Y boundary of the particles' container.
     * @param MaxZ The Z boundary of the particles' container.
     * @param ParticleSize The IParticleSize class implementation for the particle type we are working with.
     * @return An array of particles as modified by the function.
     */
    public IParticle[] InitializeParticles(int NumParticles, int MaxX, int MaxY, int MaxZ, IParticleSize ParticleSize);

    /**
     * Adjusts the particles' axis values based on existing values.
     * Call this method AFTER calling CalculateIteration.
     * @param Particles The particles to move based on their characteristic values.
     * @return
     */
    public IParticle[] MoveParticles(IParticle[] Particles);
}
