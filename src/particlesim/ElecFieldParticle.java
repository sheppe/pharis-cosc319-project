package particlesim;

import java.util.Arrays;
import java.util.List;

/**
 * An implementation of the IParticle interface for a particle affected by electric fields
 *
 * @author Josh W
 */
public class ElecFieldParticle implements IParticle {

    /**
	 * Variables for persisting property values.
	 */
     protected Characteristic[] chrs;
     protected Medium med;
     protected float x;
     protected float y;
     protected float z;
     protected float orientation;
     protected float polarizabilityParallel;
     protected float polarizabilityPerpendicular;
     protected Matrix polarizabilityMatrix;
     protected float mobilityParallel;
     protected float mobilityPerpendicular;
     protected Matrix mobilityMatrix;
     protected float impressedFieldX;
     protected float impressedFieldY;
     protected float secondOrderFieldX_Center;
     protected float secondOrderFieldY_Center;
     protected float secondOrderFieldX_XPosOffset;
     protected float secondOrderFieldY_XPosOffset;
     protected float secondOrderFieldX_XNegOffset;
     protected float secondOrderFieldY_XNegOffset;
     protected float secondOrderFieldX_YPosOffset;
     protected float secondOrderFieldY_YPosOffset;
     protected float secondOrderFieldX_YNegOffset;
     protected float secondOrderFieldY_YNegOffset;
     protected float secondOrderFieldX_Average;
     protected float secondOrderFieldY_Average;
     protected float secondOrderFieldX_Final;
     protected float secondOrderFieldY_Final;
     protected float unitVector_Center;
     protected float unitVector_XPosOffset;
     protected float unitVector_XNegOffset;
     protected float unitVector_YPosOffset;
     protected float unitVector_YNegOffset;
     protected float secondOrderFieldX_Previous;
     protected float secondOrderFieldY_Previous;
     protected float deltaSecondOrderFieldX;
     protected float deltaSecondOrderFieldY;

     public ElecFieldParticle() {

         //Initialize the variables that persist property values
         this.med = null; //no medium by default

         this.x = 0;
         this.y = 0;
         this.z = 0;
         this.orientation = 0;

         // Particles affected by electric fields contain 7 different properties
         // The orientation of the particle in degrees and X and Y values for dipole moments, force and velocity

        this.chrs = new Characteristic[6];

       /* // The orientation of a particle respective to the x axis of the lab frame
        this.chrs[0] = new Characteristic();
        this.chrs[0].ct = new CharacteristicType();
        this.chrs[0].ct.setName("Orientation");
        this.chrs[0].ct.setDescription("The orientation of the particle respective to the x axis of the lab frame.");
        // Default to 0
        this.chrs[0].setBehaviourModifier(0);*/

        // The dipole moment, induced by the impressed electric field on every particle
        this.chrs[0] = new Characteristic();
        this.chrs[0].ct = new CharacteristicType();
        this.chrs[0].ct.setName("Dipole Moment X");
        this.chrs[0].ct.setDescription("The dipole moment induced by the particle due to the electric field along the x axis.");
        // Default to 0
        this.chrs[0].setBehaviourModifier(0);

        this.chrs[1] = new Characteristic();
        this.chrs[1].ct = new CharacteristicType();
        this.chrs[1].ct.setName("Dipole Moment Y");
        this.chrs[1].ct.setDescription("The dipole moment induced by the particle due to the electric field along the y axis.");
        // Default to 0
        this.chrs[1].setBehaviourModifier(0);

        //The force on each particle, created by the second order electric fields created on each particle by dipole moments
        this.chrs[2] = new Characteristic();
        this.chrs[2].ct = new CharacteristicType();
        this.chrs[2].ct.setName("Force X");
        this.chrs[2].ct.setDescription("The force induced on the x axis of the particle by the second order electric fields.");
        // Default to 0
        this.chrs[2].setBehaviourModifier(0);

        this.chrs[3] = new Characteristic();
        this.chrs[3].ct = new CharacteristicType();
        this.chrs[3].ct.setName("Force Y");
        this.chrs[3].ct.setDescription("The force induced on the y axis of the particle by the second order electric fields.");
        // Default to 0
        this.chrs[3].setBehaviourModifier(0);

        //The velocity of the particles, determined by force
        this.chrs[4] = new Characteristic();
        this.chrs[4].ct = new CharacteristicType();
        this.chrs[4].ct.setName("Velocity X");
        this.chrs[4].ct.setDescription("The velocity on the x axis of the particle.");
        // Default to 0
        this.chrs[4].setBehaviourModifier(0);

        this.chrs[5] = new Characteristic();
        this.chrs[5].ct = new CharacteristicType();
        this.chrs[5].ct.setName("Velocity Y");
        this.chrs[5].ct.setDescription("The velocity on the y axis of the particle.");
        // Default to 0
        this.chrs[5].setBehaviourModifier(0);

     }

     /**
     * @see IParticle#getCharacteristic()
     * @return
     */
       public Characteristic[] getCharacteristic() {
        return this.chrs;
    }

       /**
     * @see IParticle#setCharacteristic(particlesim.Characteristic[])
     * @param newValue
     */
    public void setCharacteristic(Characteristic[] newValue) {
        this.chrs = newValue;
    }

    /**
     * @see IParticle#getMedium()
     * @return
     */
    public Medium getMedium() {
        return this.med;
    }

    /**
     * @see IParticle#setMedium(particlesim.Medium)
     * @param newValue
     */
    public void setMedium(Medium newValue) {
        this.med = newValue;
    }

     /**
     * @see IParticle#getX()
     * @return
     */
    public float getX() {
        return this.x;
    }

    /**
     * @see IParticle#setX(float)
     * @param newValue
     */
    public void setX(float newValue) {
        this.x = newValue;
    }

    /**
     * @see IParticle#getY()
     * @return
     */
    public float getY() {
        return this.y;
    }

    /**
     * @see IParticle#setY(float)
     * @param newValue
     */
    public void setY(float newValue) {
        this.y = newValue;
    }

    /**
     * @see IParticle#getZ()
     * @return
     */
    public float getZ() {
        return this.z;
    }

    /**
     * @see IParticle#setZ(float)
     * @param newValue
     */
    public void setZ(float newValue) {
        this.z = newValue;
    }

    //Gets the orientation of the particle
    public float getOrientation() {
        return this.orientation;
    }

    //Sets the orientation of the particle to newValue
    public void setOrientation(float newValue) {
        this.orientation = newValue;
    }

    //Gets the parallel polarizability of the particle
    public float getPolarizabilityParallel() {
        return this.polarizabilityParallel;
    }

    //Sets the parallel polarizability of the particle to newValue
    public void setPolarizabilityParallel(float newValue) {
        this.polarizabilityParallel = newValue;
    }

    //Gets the perpendicular polarizability of the particle
    public float getPolarizabilityPerpendicular() {
        return this.polarizabilityPerpendicular;
    }

    //Sets the perpendicular polarizability of the particle to newValue
    public void setPolarizabilityPerpendicular(float newValue) {
        this.polarizabilityPerpendicular = newValue;
    }

    //Gets the polarizabilty matrix of the particle
    public Matrix getPolarizabiltyMatrix() {
        return this.polarizabilityMatrix;
    }

    //Gets the parallel polarizability of the particle
    public float getMobilityParallel() {
        return this.polarizabilityParallel;
    }

    //Sets the parallel polarizability of the particle to newValue
    public void setMobilityParallel(float newValue) {
        this.polarizabilityParallel = newValue;
    }

    //Gets the perpendicular polarizability of the particle
    public float getMobilityPerpendicular() {
        return this.polarizabilityPerpendicular;
    }

    //Sets the perpendicular polarizability of the particle to newValue
    public void setMobilityPerpendicular(float newValue) {
        this.polarizabilityPerpendicular = newValue;
    }

    //Gets the polarizabilty matrix of the particle
    public Matrix getMobiltyMatrix() {
        return this.polarizabilityMatrix;
    }

    public float getUnitVector_Center() {
        return this.unitVector_Center;
    }

    public void setUnitVector_Center(float newValue) {
        this.unitVector_Center = newValue;
    }

    public float getUnitVector_XPosOffset() {
        return this.unitVector_XPosOffset;
    }

    public void setUnitVector_XPosOffset(float newValue) {
        this.unitVector_XPosOffset = newValue;
    }

    public float getUnitVector_XNegOffset() {
        return this.unitVector_XNegOffset;
    }

    public void setUnitVector_XNegOffset(float newValue) {
        this.unitVector_XNegOffset = newValue;
    }

    public float getUnitVector_YPosOffset() {
        return this.unitVector_YPosOffset;
    }

    public void setUnitVector_YPosOffset(float newValue) {
        this.unitVector_YPosOffset = newValue;
    }

    public float getUnitVector_YNegOffset() {
        return this.unitVector_YNegOffset;
    }

    public void setUnitVector_YNegOffset(float newValue) {
        this.unitVector_YNegOffset = newValue;
    }

   //Method calculates the polarizability matrix for a specific particle, used for calculating dipole moments
    public void calculatePolarizabilityMatrix() {

        //The current orientation of the particle
        float degree = this.getOrientation();

        //Defines the rotation matrix used to calculate polarizability
        double[][] rotationArray = {{Math.cos(degree), Math.sin(degree)}, {(-Math.sin(degree)), Math.cos(degree)}};
        Matrix rotationMatrix = new Matrix(rotationArray);

        //Defines the inverse of the rotation matrix
        double[][] inverseRotationArray = {{Math.cos(degree), (-Math.sin(degree))}, {(-Math.sin(degree)), Math.cos(degree)}};
        Matrix inverseRotationMatrix = new Matrix(inverseRotationArray);

        //Defines a matrix made up of the polarizabilities of the particle, called the tensor identity matrix
        double[][] tensorIdentityArray = {{this.getPolarizabilityParallel(), 0}, {0, this.getPolarizabilityPerpendicular()}};
        Matrix tensorIdentityMatrix = new Matrix(tensorIdentityArray);

        //Calculates the polarizability matrix by multiplying the above matrices
        Matrix polarizability =  (rotationMatrix.multiply(tensorIdentityMatrix)).multiply(inverseRotationMatrix);
        this.polarizabilityMatrix = polarizability;
        }
    
    //This method calculates the dipole moment for all particles
    public void calculateDipoleMoments(){

            double[][] elecFieldArray = {{this.impressedFieldX, this.impressedFieldY}};
            Matrix elecFieldMatrix = new Matrix(elecFieldArray);
            
            Matrix dipoleMomentMatrix = (this.polarizabilityMatrix).s_multiply(elecFieldMatrix);
            
            this.getCharacteristic()[0].setBehaviourModifier((float)dipoleMomentMatrix.getValue(0, 0));
            this.getCharacteristic()[1].setBehaviourModifier((float)dipoleMomentMatrix.getValue(1, 0));
        }

    public void calculateUnitVectors(ElecFieldParticle p1, ElecFieldParticle p2){
        float unitVectorNominator_Center = ((p1.getX()) - (p2.getX())) + (p1.getY() - p2.getY());
        float unitVectorDenominator_Center = (float)Math.sqrt((Math.pow(p1.getX() - p2.getX(), 2)) + (Math.pow(p1.getY() - p2.getY(), 2)));
        float unitVectorNominator_XPosOffset = ((p1.getX() + 1) - (p2.getX())) + (p1.getY() - p2.getY());
        float unitVectorDenominator_XPosOffset = (float)Math.sqrt((Math.pow((p1.getX() + 1) - p2.getX(), 2)) + (Math.pow(p1.getY() - p2.getY(), 2)));
        float unitVectorNominator_XNegOffset = ((p1.getX() - 1) - (p2.getX())) + (p1.getY() - p2.getY());
        float unitVectorDenominator_XNegOffset = (float)Math.sqrt((Math.pow((p1.getX() - 1) - p2.getX(), 2)) + (Math.pow(p1.getY() - p2.getY(), 2)));
        float unitVectorNominator_YPosOffset = (p1.getX() - (p2.getX())) + ((p1.getY() + 1) - p2.getY());
        float unitVectorDenominator_YPosOffset = (float)Math.sqrt((Math.pow(p1.getX() - p2.getX(), 2)) + (Math.pow((p1.getY() + 1) - p2.getY(), 2)));
        float unitVectorNominator_YNegOffset = (p1.getX() - (p2.getX())) + ((p1.getY() - 1) - p2.getY());
        float unitVectorDenominator_YNegOffset = (float)Math.sqrt((Math.pow(p1.getX() - p2.getX(), 2)) + (Math.pow((p1.getY() - 1) - p2.getY(), 2)));
        this.setUnitVector_Center(unitVectorNominator_Center / unitVectorDenominator_Center);
        this.setUnitVector_XPosOffset(unitVectorNominator_XPosOffset / unitVectorDenominator_XPosOffset);
        this.setUnitVector_XNegOffset(unitVectorNominator_XNegOffset / unitVectorDenominator_XNegOffset);
        this.setUnitVector_YPosOffset(unitVectorNominator_YPosOffset / unitVectorDenominator_YPosOffset);
        this.setUnitVector_YNegOffset(unitVectorNominator_YNegOffset / unitVectorDenominator_YNegOffset);
    }

public void calculateSecondOrderFields(ElecFieldParticle Particle) {

                    this.secondOrderFieldX_Center += (float)(((this.getUnitVector_Center() * 3) * (this.getCharacteristic()[0].getBehaviourModifier() * this.getUnitVector_Center()) - this.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(Particle.getX() - this.getX(), 2)) + (Math.pow(Particle.getY() - this.getY(), 2))), 3));
                    this.secondOrderFieldX_XPosOffset += (float)(((this.getUnitVector_XPosOffset() * 3) * (this.getCharacteristic()[0].getBehaviourModifier() * this.getUnitVector_XPosOffset()) - this.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((Particle.getX() + 1) - this.getX(), 2)) + (Math.pow(Particle.getY() - this.getY(), 2))), 3));
                    this.secondOrderFieldX_XNegOffset += (float)(((this.getUnitVector_XNegOffset() * 3) * (this.getCharacteristic()[0].getBehaviourModifier() * this.getUnitVector_XNegOffset()) - this.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((Particle.getX() - 1) - this.getX(), 2)) + (Math.pow(Particle.getY() - this.getY(), 2))), 3));
                    this.secondOrderFieldX_YPosOffset += (float)(((this.getUnitVector_YPosOffset() * 3) * (this.getCharacteristic()[0].getBehaviourModifier() * this.getUnitVector_YPosOffset()) - this.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(Particle.getX() - this.getX(), 2)) + (Math.pow((Particle.getY() + 1) - this.getY(), 2))), 3));
                    this.secondOrderFieldX_YNegOffset += (float)(((this.getUnitVector_YNegOffset() * 3) * (this.getCharacteristic()[0].getBehaviourModifier() * this.getUnitVector_YNegOffset()) - this.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(Particle.getX() - this.getX(), 2)) + (Math.pow((Particle.getY() - 1) - this.getY(), 2))), 3));

                    this.secondOrderFieldX_Average = (this.secondOrderFieldX_Center + this.secondOrderFieldX_XPosOffset + this.secondOrderFieldX_XNegOffset + this.secondOrderFieldX_YNegOffset + this.secondOrderFieldX_YPosOffset) / 5;

                    this.secondOrderFieldY_Center += (float)(((this.getUnitVector_Center() * 3) * (this.getCharacteristic()[1].getBehaviourModifier() * this.getUnitVector_Center()) - this.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(Particle.getX() - this.getX(), 2)) + (Math.pow(Particle.getY() - this.getY(), 2))), 3));
                    this.secondOrderFieldY_XPosOffset += (float)(((this.getUnitVector_XPosOffset() * 3) * (this.getCharacteristic()[1].getBehaviourModifier() * this.getUnitVector_XPosOffset()) - this.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((Particle.getX() + 1) - this.getX(), 2)) + (Math.pow(Particle.getY() - this.getY(), 2))), 3));
                    this.secondOrderFieldY_XNegOffset += (float)(((this.getUnitVector_XNegOffset() * 3) * (this.getCharacteristic()[1].getBehaviourModifier() * this.getUnitVector_XNegOffset()) - this.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((Particle.getX() - 1) - this.getX(), 2)) + (Math.pow(Particle.getY() - this.getY(), 2))), 3));
                    this.secondOrderFieldY_YPosOffset += (float)(((this.getUnitVector_YPosOffset() * 3) * (this.getCharacteristic()[1].getBehaviourModifier() * this.getUnitVector_YPosOffset()) - this.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(Particle.getX() - this.getX(), 2)) + (Math.pow((Particle.getY() + 1) - this.getY(), 2))), 3));
                    this.secondOrderFieldY_YNegOffset += (float)(((this.getUnitVector_YNegOffset() * 3) * (this.getCharacteristic()[1].getBehaviourModifier() * this.getUnitVector_YNegOffset()) - this.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(Particle.getX() - this.getX(), 2)) + (Math.pow((Particle.getY() - 1) - this.getY(), 2))), 3));

                    this.secondOrderFieldY_Average = (this.secondOrderFieldY_Center + this.secondOrderFieldY_XPosOffset + this.secondOrderFieldY_XNegOffset + this.secondOrderFieldY_YNegOffset + this.secondOrderFieldY_YPosOffset) / 5;

                    this.secondOrderFieldX_Previous = this.secondOrderFieldX_Final;
                    this.secondOrderFieldY_Previous = this.secondOrderFieldY_Final;

                    this.secondOrderFieldX_Final = this.impressedFieldX + this.secondOrderFieldX_Average;
                    this.secondOrderFieldY_Final = this.impressedFieldY + this.secondOrderFieldY_Average;

                    this.deltaSecondOrderFieldX = (this.deltaSecondOrderFieldX - this.secondOrderFieldX_Previous);
                    this.deltaSecondOrderFieldY = (this.deltaSecondOrderFieldY - this.secondOrderFieldY_Previous);
                
            }
        

public float calculateDiscreteApprox_DxEx() {
    float value;
    value = (this.deltaSecondOrderFieldX * (this.getX() + 1)) - (this.deltaSecondOrderFieldX * this.getX());
    return value;
}

public float calculateDiscreteApprox_DyEx() {
    float value;
    value = (this.deltaSecondOrderFieldX * (this.getY() + 1)) - (this.deltaSecondOrderFieldX * this.getY());
    return value;
}

public float calculateDiscreteApprox_DxEy() {
    float value;
    value = (this.deltaSecondOrderFieldY * (this.getX() + 1)) - (this.deltaSecondOrderFieldY * this.getX());
    return value;
}

public float calculateDiscreteApprox_DyEy() {
    float value;
    value = (this.deltaSecondOrderFieldY * (this.getY() + 1)) - (this.deltaSecondOrderFieldY * this.getY());
    return value;
}

public void calculateForce() {
    float forceX_X = (this.getCharacteristic()[0].getBehaviourModifier() * this.calculateDiscreteApprox_DxEx());
    float forceY_X = (this.getCharacteristic()[1].getBehaviourModifier() * this.calculateDiscreteApprox_DyEx());
    float forceX_Y = (this.getCharacteristic()[0].getBehaviourModifier() * this.calculateDiscreteApprox_DxEy());
    float forceY_Y = (this.getCharacteristic()[1].getBehaviourModifier() * this.calculateDiscreteApprox_DyEy());

    this.getCharacteristic()[2].setBehaviourModifier(forceX_X + forceY_X);
    this.getCharacteristic()[3].setBehaviourModifier(forceX_Y + forceY_Y);
}

   //Method calculates the mobility matrix for a specific particle, used for calculating velocity
    public void calculateMobilityMatrix() {

        //The current orientation of the particle
        float degree = this.getOrientation();

        //Defines the rotation matrix used to calculate polarizability
        double[][] rotationArray = {{Math.cos(degree), Math.sin(degree)}, {(-Math.sin(degree)), Math.cos(degree)}};
        Matrix rotationMatrix = new Matrix(rotationArray);

        //Defines the inverse of the rotation matrix
        double[][] inverseRotationArray = {{Math.cos(degree), (-Math.sin(degree))}, {(-Math.sin(degree)), Math.cos(degree)}};
        Matrix inverseRotationMatrix = new Matrix(inverseRotationArray);

        //Defines a matrix made up of the polarizabilities of the particle, called the tensor identity matrix
        double[][] tensorIdentityArray = {{this.getMobilityParallel(), 0}, {0, this.getMobilityPerpendicular()}};
        Matrix tensorIdentityMatrix = new Matrix(tensorIdentityArray);

        //Calculates the polarizability matrix by multiplying the above matrices
        Matrix mobility =  (rotationMatrix.multiply(tensorIdentityMatrix)).multiply(inverseRotationMatrix);
        this.mobilityMatrix = mobility;
     }

    public void calculateVelocity() {
        float velocityX = (float)this.getMobiltyMatrix().getValue(0, 0) * this.getCharacteristic()[2].getBehaviourModifier();
        float velocityY = (float)this.getMobiltyMatrix().getValue(1, 0) * this.getCharacteristic()[3].getBehaviourModifier();

        this.getCharacteristic()[4].setBehaviourModifier(velocityX);
        this.getCharacteristic()[5].setBehaviourModifier(velocityY);
    }





    /**
     * @see IParticle#getCalcName()
     * @return
     */
    public String getCalcName() {
        return "particlesim.CalculateElecFieldParticle";
    }


}
