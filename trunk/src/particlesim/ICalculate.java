/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public interface ICalculate {
	// Java passes parameter variables by value, so it will be necessary
	// to have a return value on this function so the calling procedure can
	// retrieve the updated values.

    /**
     * Calculates particle behaviour based on particle characteristics.
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
     */
    public IParticle[] InitializeParticles(int NumParticles, int MaxX, int MaxY, int MaxZ);

    /**
     * Call this method AFTER calling CalculateIteration.
     * @param Particles The particles to move based on their characteristic values.
     */
    public IParticle[] MoveParticles(IParticle[] Particles);
}
