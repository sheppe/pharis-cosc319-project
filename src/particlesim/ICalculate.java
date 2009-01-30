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
	public IParticle[] CalculateIteration(IParticle[] Particles);
}
