/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package particlesim;

import java.util.Arrays;
import java.util.List;

/**
 *
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
     * @return
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
                    float velocityX2 = p2.getCharacteristic()[4].getBehaviourModifier();
                    float velocityY2 = p2.getCharacteristic()[5].getBehaviourModifier();

                    //reverse the velocity direction on P1
                    p1.getCharacteristic()[4].setBehaviourModifier(-velocityX1);
                    p1.getCharacteristic()[5].setBehaviourModifier(-velocityY1);

                    //reverse the force direction on P2
                    p2.getCharacteristic()[4].setBehaviourModifier(-velocityX2);
                    p2.getCharacteristic()[5].setBehaviourModifier(-velocityY2);
                }
            }
        }
        return lParticles.toArray(particles);
    }

    public IParticle[] updateBoundaryColliedParticle(IParticle[] particles) {
          //convert to array
        List<IParticle> lParticles = Arrays.asList(particles);

        // For each particle in the collection, calculate its position in
        // relation to every other particle in the collection.
        for (IParticle p1 : lParticles) {
                boolean isCollided = this.checkBounderyCollision(p1);

                if (isCollided) {
                    //get forces form x and y axis for particle 1 and 2
                    float velocityX = p1.getCharacteristic()[4].getBehaviourModifier();
                    float velocityY = p1.getCharacteristic()[5].getBehaviourModifier();

                    //reverse the direction of force on P1
                    p1.getCharacteristic()[4].setBehaviourModifier(-velocityX);
                    p1.getCharacteristic()[5].setBehaviourModifier(-velocityY);
            }
        }
        return lParticles.toArray(particles);
    }
}
