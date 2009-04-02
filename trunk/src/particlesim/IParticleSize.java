package particlesim;

/**
 *
 * @author Sheppe
 * The ParticleSizeEllipse class is used for defining the x, y, and z extents
 * of the cube that an elliptical particle is created within.
 */
public interface IParticleSize {

    /**
     * The width of the particle.
     * @param SizeX
     */
    public void setParticleSizeX(int SizeX);
    /**
     * The width of the particle.
     * @return
     */
    public int getParticleSizeX();

    /**
     * The height of the particle.
     * @param SizeY
     */
    public void setParticleSizeY(int SizeY);
    /**
     * The height of the particle.
     * @return
     */
    public int getParticleSizeY();

    /**
     * The depth of the particle.
     * @param SizeZ
     */
    public void setParticleSizeZ(int SizeZ);
    /**
     * The depth of the particle.
     * @return
     */
    public int getParticleSizeZ();
}
