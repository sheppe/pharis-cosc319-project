/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package particlesim;

import java.util.Arrays;
import java.util.List;

/**
 * This class will check collisoin on particle between particle and particle between boundery.
 * If they did, then update their movements.(The particle type should be Electic field particle)
 * @author Yuehan
 */
public class ElecFieldCollisiondetector implements ICollisionDetector {

    public javax.media.opengl.GLCanvas GraphicsPanel;
    private int frameWidth = GraphicsPanel.getWidth();
    private int frameHeight = GraphicsPanel.getWidth();

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

        if (distance < diameter) {
            isCollided = true;
        }

        return isCollided;
    }

    /**
     *
     * @param P1
     * @return boolean. Collision ocurred if result is true. Otherwie return false.
     */
    public boolean checkBounderyCollision(IParticle P1) {
        boolean isCollided = false;

        //get the radias of a charged particle
        int radias = (P1.getParticleSize().getParticleSizeX()) / 2;

        float particleX = P1.getX();
        float particleY = P1.getY();

        int rightBound = frameWidth - radias;
        int leftBound = frameWidth + radias;
        int bottomBound = frameHeight - radias;
        int topBound = frameHeight + radias;

        if (particleX < leftBound || particleX > rightBound || particleY < topBound || particleY > bottomBound) {
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

                    //get velocity from x and y axis for particle 1 and 2
                    float velocityX1 = p1.getCharacteristic()[4].getBehaviourModifier();
                    float velocityY1 = p1.getCharacteristic()[5].getBehaviourModifier();                 

                    //reverse the velocity direction on P1
                    p1.getCharacteristic()[4].setBehaviourModifier(-velocityX1);
                    p1.getCharacteristic()[5].setBehaviourModifier(-velocityY1);
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
                if (particleX <= leftBound) {
                    p1.setX(leftBound);
                }

                if (particleX > rightBound) {
                    p1.setX(rightBound);
                }

                if (particleY < topBound) {
                    p1.setY(topBound);
                }

                if (particleY > bottomBound) {
                    p1.setY(bottomBound);
                }

                //get velocity form x and y axis for particle 1 and 2
                float velocityX = p1.getCharacteristic()[4].getBehaviourModifier();
                float velocityY = p1.getCharacteristic()[5].getBehaviourModifier();

                //reverse the direction of velocity on P1
                p1.getCharacteristic()[4].setBehaviourModifier(-velocityX);
                p1.getCharacteristic()[5].setBehaviourModifier(-velocityY);
            }
        }
        return lParticles.toArray(particles);
    }
}
