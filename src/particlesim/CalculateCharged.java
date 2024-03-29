package particlesim;
import java.util.List;
import java.util.Arrays;

/**
 * Prototype class for performing calculations on simple charged particles in
 * open space, with no medium.
 * @see ICalculate#()
 * @author Sheppe
 */
public class CalculateCharged implements ICalculate {
    /**
     * @see ICalculate#CalculateIteration(particlesim.IParticle[])
     * @param Particles
     * @return
     */
	public IParticle[] CalculateIteration(IParticle[] Particles)
	{
        if(Particles == null)
        {
            return null;
        }

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
     * Creates an array of charged particles.
     * @see ICalculate#InitializeParticles
     * @param NumParticles The number of particle to create.
     * @param MaxX The X boundary of the particles' container.
     * @param MaxY The Y boundary of the particles' container.
     * @param MaxZ The Z boundary of the particles' container.
     * @param ParticleSize The IParticleSize class implementation for the particle type we are working with.
     * @return An array of particles as modified by the function.
     */
    public IParticle[] InitializeParticles(int NumParticles, int MaxX, int MaxY, int MaxZ, IParticleSize ParticleSize, int[] extraValues) {
        if(ParticleSize == null || extraValues == null)
        {
            return null;
        }

        // Create our charged particles array, using the number of particles passed in.
        ChargedParticle[] cp;
        cp = new ChargedParticle[NumParticles];

        // Load up the GridSelector class to get random, unique, positions
        // is the grid that do no overlap.
        GridSelector gs = new GridSelector(MaxX, MaxY, ParticleSize.getParticleSizeX(), ParticleSize.getParticleSizeY());

        int x = 1;
        for(int i=0; i<NumParticles; i++)
        {

            cp[i] = new ChargedParticle();

            // Don't forget to assign the ParticleSize class to the particle! 
            // This is so it can be retrieved later.
            cp[i].setParticleSize(ParticleSize);
            
            /* No longer used... keeping it around in case it becomes useful again. -Sheppe
            // Derive the diameter from the rectangular (x,y) size coordinates.
            // This is done using the following formula:
            // Diameter = 1.30 * ((x*y)0.625) / (x+y)0.25)
            float fPDiameter = (float)(1.30 * ((ParticleSize.getParticleSizeX() *
                    ParticleSize.getParticleSizeY())*0.625 /
                    ((ParticleSize.getParticleSizeX() +
                    ParticleSize.getParticleSizeY())*0.25)));
            float fPRadius = fPDiameter / 2;
            */
            
            // Set the charge of the particle (location hard-coded at array index 0).
            cp[i].getCharacteristic()[0].setBehaviourModifier(((x % 2)*2)-1);
            x++;

            java.awt.Point p = gs.GetRandomUniqueSector();

            // If p is null, we're out of grid space, so stop here.
            if(p == null)
            {
                return cp;
            }
            
            // Randomly place the particle in a container.
            cp[i].setX((float)(p.getX()));
            cp[i].setY((float)(p.getY()));
            cp[i].setZ((float)(MaxZ));
        }

        return cp;
    }

    /**
     * @see ICalculate#MoveParticles(particlesim.IParticle[]) 
     * @param Particles
     * @return
     */
    public IParticle[] MoveParticles(IParticle[] Particles) {
        if(Particles == null)
        {
            return null;
        }

        // Used to adjust the rate of particle movement.
        // Should be used for display purposes only!
        //float movementModifier = 1.01f;

        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(Particles);

        // Move each particle on the X and Y axis based on calculated values.
        for(IParticle p1 : lParticles)
        {
            p1.setX((p1.getX() + (p1.getCharacteristic()[1].getBehaviourModifier())));// * movementModifier);
            p1.setY((p1.getY() + (p1.getCharacteristic()[2].getBehaviourModifier())));// * movementModifier);
        }

        return lParticles.toArray(Particles);
    }
}
