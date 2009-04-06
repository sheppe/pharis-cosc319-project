package particlesim;

/**
 *
 * @author Sheppe
 * The ParticleSizeEllipse class is used for defining the x, y, and z extents
 * of the cube that an elliptical particle is created within.
 */
public class ParticleSizeEllipse implements IParticleSize {

    // Used for storing size dimensions locally.
    private int x, y, z;

    /**
     * Construct the class using the size boundaries outlined by the parameters.
     * @param SizeX The maximum width of the particle.
     * @param SizeY The maximum height of the particle.
     * @param SizeZ The maximum depth of the particle.
     */
    public ParticleSizeEllipse()
    {}

    /**
     * @see particlesim.IParticleSize#setParticleSizeX() 
     * @param SizeX
     */
    public void setParticleSizeX(int SizeX) {
        this.x = SizeX;
    }

    /**
     * @see particlesim.IParticleSize#getParticleSizeX()
     * @return
     */
    public int getParticleSizeX() {
        return this.x;
    }

    /**
     * @see particlesim.IParticleSize#setParticleSizeY(int)
     * @param SizeY
     */
    public void setParticleSizeY(int SizeY) {
        this.y = SizeY;
    }

    /**
     * @see particlesim.IParticleSize#getParticleSizeY()
     * @return
     */
    public int getParticleSizeY() {
        return this.y;
    }

    /**
     * @see particlesim.IParticleSize#setParticleSizeZ(int)
     * @param SizeZ
     */
    public void setParticleSizeZ(int SizeZ) {
        this.z = SizeZ;
    }

    /**
     * @see particlesim.IParticleSize#getParticleSizeZ()
     * @return
     */
    public int getParticleSizeZ() {
        return this.z;
    }
}
