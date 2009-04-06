
package particlesim;

/**
 * Interface for partical collisionDetection for difference types particle in
 * different mediums
 * @author Yuehan
 */
public interface ICollisionDetector{

    /**
     * check whether particle has collided with other particle in the current medium
     * or not
     * @param IParticle P1, IParticle P2
     * @return whether P1 has collided with P2
     */
    public boolean checkParticleCollision(IParticle P1, IParticle P2);
    
    
    /**
     *  check whether particle has collided with boundery
     * @param IParticle P1
     * @return
     */
    public boolean checkBounderyCollision(IParticle P1);

    
     /**
     * Update the collided particles
     * @param IParticle[] particles
     * @return particle
     */
    public IParticle[] updateParticleColliedParticle(IParticle[] particles);

    public IParticle[] updateBoundaryColliedParticle(IParticle[] particles);

}


