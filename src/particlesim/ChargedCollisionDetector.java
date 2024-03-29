/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package particlesim;

import java.util.Arrays;
import java.util.List;

/**
 * This class will check collisoin on particle between particle and particle between boundery.
 * If they did, then update their movements.(The particle type should be charged particle)
 * @author Yuehan
 */
public class ChargedCollisionDetector implements ICollisionDetector {

    private int frameWidth;
    private int frameHeight;

    public ChargedCollisionDetector(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    /**
     *
     * @param ChargedParticle P1
     * @param IParticle P2
     * @return boolean result. Collision ocurred if result is true. Otherwie return false.
     */
    public boolean checkParticleCollision(IParticle P1, IParticle P2) {
        boolean isCollided = false;
        int diameter = P1.getParticleSize().getParticleSizeX();

        // get X difference between two particles
        double deltaX = P1.getX() - P2.getX();

        // get Y difference between two particles
        double deltaY = P1.getY() - P2.getY();

        // get the distance between two particles
        double distance = Math.abs(Math.sqrt(deltaX * deltaX + deltaY * deltaY));

        if (distance <= diameter) {
            isCollided = true;
        }

        return isCollided;
    }

    /**
     *
     * @param IParticle P1
     * @return boolean. return true, if the particle collid with boundery
     */
    public boolean checkBounderyCollision(IParticle P1) {
        boolean isCollided = false;

        //get the radias of a charged particle
        int radias = (P1.getParticleSize().getParticleSizeX()) / 2;

        float particleX = P1.getX();
        float particleY = P1.getY();

        int rightBound = frameWidth - radias;
        int leftBound = radias;
        int bottomBound = frameHeight - radias;
        int topBound = radias;
        
        if (particleX <= leftBound || particleX >= rightBound || particleY <= topBound || particleY >= bottomBound) {
            isCollided = true;

        }

        return isCollided;
    }

    /**
     *
     * @param particles
     * @return updated particles
     */
    public IParticle[] updateParticleColliedParticle(IParticle[] particles) {

        //convert to array
        List<IParticle> lParticles = Arrays.asList(particles);

        // For each particle in the collection, calculate its position in
        // relation to every other particle in the collection.
        for (IParticle p1 : lParticles) {
           for (IParticle p2 : lParticles) {
                boolean isCollided = this.checkParticleCollision(p1, p2);

                if (isCollided) {

                    //get forces from x and y axis for particle 1
                    float forceX1 = 10 *(p1.getCharacteristic()[1].getBehaviourModifier());
                    float forceY1 = 10 *(p1.getCharacteristic()[2].getBehaviourModifier());

                    //reverse the direction of force on P1
                    p1.getCharacteristic()[1].setBehaviourModifier(-forceX1);
                    p1.getCharacteristic()[2].setBehaviourModifier(-forceY1);
                   }
            }
        }
        return lParticles.toArray(particles);
    }

    /**
     *
     * @param particles
     * @return updated particles
     */
    public IParticle[] updateBoundaryColliedParticle(IParticle[] particles) {
        //convert to array
        List<IParticle> lParticles = Arrays.asList(particles);

        // For each particle in the collection, calculate its position in
        // relation to every other particle in the collection.
        for (IParticle p1 : lParticles) {
            int radias = (p1.getParticleSize().getParticleSizeX()) / 2;

            float particleX = p1.getX();
            float particleY = p1.getY();

            int rightBound = frameWidth - radias;
            int leftBound = radias;
            int bottomBound = frameHeight - radias;
            int topBound = radias;
            boolean isCollided = this.checkBounderyCollision(p1);

            if (isCollided) {

                // the folowing 4 if conditions is making sure that keeping all particle inside of the boundery.
                if(particleX <= leftBound){
                     p1.setX(leftBound);
                }

                if(particleX > rightBound){
                     p1.setX(rightBound);
                }

                 if(particleY < topBound){
                     p1.setY(topBound);
                }

                 if(particleY > bottomBound){
                     p1.setY(bottomBound);
                }

                //get forces form x and y axis for particle 1
                float forceX1 = 10*(p1.getCharacteristic()[1].getBehaviourModifier());
                float forceY1 = 10*(p1.getCharacteristic()[2].getBehaviourModifier());

                //reverse the direction of force on P1
                p1.getCharacteristic()[1].setBehaviourModifier(-forceX1);
                p1.getCharacteristic()[2].setBehaviourModifier(-forceY1);
            }
        }
        return lParticles.toArray(particles);
    }
}
