/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Sheppe
 */
public class CalculateCharged implements ICalculate {
    /**
     *
     * @param Particles
     * @return
     */
	public IParticle[] CalculateIteration(IParticle[] Particles)
	{
        double dDistSq = 0;
        double dRepulsion = 0;
        double dRepulsionX = 0;
        double dRepulsionY = 0;
        double dForceX = 0;
        double dForceY = 0;

        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(Particles);

        // For each particle in the collection, calculate its position in
        // relation to every other particle in the collection.
        for(IParticle p1 : lParticles)
        {
            // The following variables must be re-initialized for each pass
            // through the first for loop. Note that not all of the variables
            // declare at the top of this method are re-initialized here!
            dDistSq = 0;
            dRepulsion = 0;
            dRepulsionX = 0;
            dRepulsionY = 0;

            for(IParticle p2 : lParticles)
            {
                // The particle does not affect its own position, so exit if
                // we're looking at two instances of the same particle.
                if(p1.equals(p2))
                    continue;

                // Calculate forces and repulsions.
                dDistSq = (Math.pow((double) p1.getX() - (double) p2.getX(), 2) + Math.pow((double) p1.getY() - (double) p2.getY(), 2));
                dForceX = dForceX + (p1.getCharacteristic()[0].getBehaviourModifier() * p2.getCharacteristic()[0].getBehaviourModifier()) * ((double) p1.getX() - (double) p2.getX()) / dDistSq;
                dForceY = dForceY + (p1.getCharacteristic()[0].getBehaviourModifier() * p2.getCharacteristic()[0].getBehaviourModifier()) * ((double) p1.getY() - (double) p2.getY()) / dDistSq;
                dRepulsion = 0.0784 - 0.0003733 * Math.sqrt(dDistSq);
                if(dRepulsion < 0) dRepulsion = 0;

                dRepulsionY = Math.abs((double) p1.getY() - (double) p2.getY()) / Math.sqrt(dDistSq) * dRepulsion;
                if(dRepulsionY < 0) dRepulsionY = 0;
                else dRepulsionY = dRepulsionY * Math.sin((double) p1.getY() - (double) p2.getY());

                dRepulsionX = Math.abs((double) p1.getX() - (double) p2.getX()) / Math.sqrt(dDistSq) * dRepulsion;
                if(dRepulsionX < 0) dRepulsionX = 0;
                else dRepulsionX = dRepulsionX * Math.sin((double) p1.getX() - (double) p2.getX());

                // Persist the force values for the particle.
                p2.getCharacteristic()[1].setBehaviourModifier((float)(dForceX + dRepulsionX));
                p2.getCharacteristic()[2].setBehaviourModifier((float)(dForceY + dRepulsionY));
            }
        }

		return lParticles.toArray(Particles);
	}

    /**
     *
     * @param NumParticles
     * @param MaxX
     * @param MaxY
     * @param MaxZ
     * @return
     */
    public IParticle[] InitializeParticles(int NumParticles, int MaxX, int MaxY, int MaxZ) {
        // Create our charged particles array, using the number of particles passed in.
        ChargedParticle[] cp;
        cp = new ChargedParticle[NumParticles];

        // The size of the particles.
        float fPDiameter = 25;
        float fPRadius = fPDiameter / 2;
        int x = 1;
        for(int i=0; i<NumParticles; i++)
        {
            cp[i] = new ChargedParticle();
            
            // Set the charge of the particle (location hard-coded at array index 0).
            cp[i].getCharacteristic()[0].setBehaviourModifier(((x % 2)*2)-1);
            x++;

            // Randomly place the particle in a container.
            cp[i].setX((float)(fPRadius + Math.random() * (MaxX - fPDiameter)));
            cp[i].setY((float)(fPRadius + Math.random() * (MaxY - fPDiameter)));
            cp[i].setZ((float)(fPRadius + Math.random() * (MaxZ - fPDiameter)));
        }

        return cp;
    }

    /**
     * 
     * @param Particles
     */
    public IParticle[] MoveParticles(IParticle[] Particles) {
        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(Particles);

        for(IParticle p1 : lParticles)
        {
            p1.setX(p1.getX() + (p1.getCharacteristic()[1].getBehaviourModifier()));
            p1.setY(p1.getY() + (p1.getCharacteristic()[2].getBehaviourModifier()));
        }

        return lParticles.toArray(Particles);
    }
}
