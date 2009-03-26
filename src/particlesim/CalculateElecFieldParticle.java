package particlesim;
import java.util.List;
import java.util.Arrays;

/**
 * Class for performing calculations on particles charged by an electric field
 *
 * @author Josh W
 */
public class CalculateElecFieldParticle implements ICalculate {

    public IParticle[] CalculateIteration(IParticle[] Particles) {

        // Convert the array to a list to ease parsing it.
        List<ElecFieldParticle> lParticles = Arrays.asList(Particles);

        for(ElecFieldParticle p1 : lParticles) {
            p1.calculatePolarizabilityMatrix();
            p1.calculateDipoleMoments();

            for(ElecFieldParticle p2 : lParticles) {
                if(p1.equals(p2))
                    continue;

                p1.calculateUnitVectors(p1, p2);
                p1.calculateSecondOrderFields(p2);
            }
            
            p1.calculateForce();
            p1.calculateMobilityMatrix();
            p1.calculateVelocity();
        }

        return lParticles.toArray(Particles);
        }

    public IParticle[] InitializeParticles(int NumParticles, int MaxX, int MaxY, int MaxZ) {
        ElecFieldParticle[] efp = new ElecFieldParticle[NumParticles];
        return efp;
    }

        public IParticle[] MoveParticles(IParticle[] Particles) {
        // Used to adjust the rate of particle movement.
        // Should be used for display purposes only!
        //float movementModifier = 1.01f;

        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(Particles);

        // Move each particle on the X and Y axis based on calculated values.
        for(IParticle p1 : lParticles)
        {
            p1.setX((p1.getX() + (p1.getCharacteristic()[4].getBehaviourModifier())));// * movementModifier);
            p1.setY((p1.getY() + (p1.getCharacteristic()[5].getBehaviourModifier())));// * movementModifier);
        }

        return lParticles.toArray(Particles);
    }


}
