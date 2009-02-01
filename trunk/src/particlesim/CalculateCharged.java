/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Sheppe
 */
public class CalculateCharged implements ICalculate {
	public IParticle[] CalculateIteration(IParticle[] Particles)
	{
        
		return Particles;
	}

    public IParticle[] InitializeParticles(int NumParticles) {
        // Create our charged particles array, using the number of particles passed in.
        ChargedParticle[] cp;
        cp = new ChargedParticle[NumParticles];
        
        for(int i=0; i<NumParticles; i++)
        {
            // Set the charge of the particle (hard-coded at array index 0).
            cp[i].getCharacteristic()[0].setBehaviourModifier(((i % 2)*2)-1);
            cp[i].x = (float)(100 + Math.random() * 1000);
            cp[i].y = (float)(100 + Math.random() * 1000);
        }

        return cp;
    }
}
