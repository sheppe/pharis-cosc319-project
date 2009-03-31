package particlesim;
import java.util.List;
import java.util.Arrays;
import java.util.Date;

/**
 * Class for performing calculations on particles charged by an electric field
 *
 * @author Josh W
 */
public class CalculateElecFieldParticle implements ICalculate {

    public IParticle[] CalculateIteration(IParticle[] Particles) {

     Matrix polarizabilityMatrix;
     Matrix mobilityMatrix;
     double secondOrderFieldX_Center = 0;
     double secondOrderFieldY_Center = 0;
     double secondOrderFieldX_XPosOffset = 0;
     double secondOrderFieldY_XPosOffset = 0;
     double secondOrderFieldX_XNegOffset = 0;
     double secondOrderFieldY_XNegOffset = 0;
     double secondOrderFieldX_YPosOffset = 0;
     double secondOrderFieldY_YPosOffset = 0;
     double secondOrderFieldX_YNegOffset = 0;
     double secondOrderFieldY_YNegOffset = 0;
     double secondOrderFieldX_Average = 0;
     double secondOrderFieldY_Average = 0;
     double secondOrderFieldX_Final = 0;
     double secondOrderFieldY_Final = 0;
     double unitVector_Center;
     double unitVector_XPosOffset;
     double unitVector_XNegOffset;
     double unitVector_YPosOffset;
     double unitVector_YNegOffset;
     double secondOrderFieldX_Previous;
     double secondOrderFieldY_Previous;
     double deltaSecondOrderFieldX;
     double deltaSecondOrderFieldY;
     double discreteApprox_DxEx;
     double discreteApprox_DxEy;
     double discreteApprox_DyEx;
     double discreteApprox_DyEy;
     double deltaTime;
     Date oldTime = new Date();

        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(Particles);

        for(IParticle p1 : lParticles) {

        //Defines the rotation matrix used to calculate polarizability
        double[][] rotationArray = {{Math.cos(p1.getCharacteristic()[6].getBehaviourModifier()), Math.sin(p1.getCharacteristic()[6].getBehaviourModifier())}, {(-Math.sin(p1.getCharacteristic()[6].getBehaviourModifier())), Math.cos(p1.getCharacteristic()[6].getBehaviourModifier())}};
        Matrix rotationMatrix = new Matrix(rotationArray);

        //Defines the inverse of the rotation matrix
        double[][] inverseRotationArray = {{Math.cos(p1.getCharacteristic()[6].getBehaviourModifier()), (-Math.sin(p1.getCharacteristic()[6].getBehaviourModifier()))}, {(-Math.sin(p1.getCharacteristic()[6].getBehaviourModifier())), Math.cos(p1.getCharacteristic()[6].getBehaviourModifier())}};
        Matrix inverseRotationMatrix = new Matrix(inverseRotationArray);

        //Defines a matrix made up of the polarizabilities of the particle, called the tensor identity matrix
        double[][] tensorIdentityArray = {{p1.getCharacteristic()[7].getBehaviourModifier(), 0}, {0, p1.getCharacteristic()[8].getBehaviourModifier()}};
        Matrix tensorIdentityMatrix = new Matrix(tensorIdentityArray);

        //Calculates the polarizability matrix by multiplying the above matrices
        Matrix polarizability =  (rotationMatrix.multiply(tensorIdentityMatrix)).multiply(inverseRotationMatrix);
        polarizabilityMatrix = polarizability;

        //Calculates the matrix of electric field forces used to calculate the dipole moments
        double[][] elecFieldArray = {{p1.getCharacteristic()[9].getBehaviourModifier(), p1.getCharacteristic()[10].getBehaviourModifier()}};
        Matrix elecFieldMatrix = new Matrix(elecFieldArray);

        //Calculates the dipole moment of each particle on both axes
        Matrix dipoleMomentMatrix = (polarizabilityMatrix).s_multiply(elecFieldMatrix);

        //Sets the dipole moments of each particle
        p1.getCharacteristic()[0].setBehaviourModifier((float)dipoleMomentMatrix.getValue(0, 0));
        p1.getCharacteristic()[1].setBehaviourModifier((float)dipoleMomentMatrix.getValue(1, 0));

        for(IParticle p2 : lParticles) {

            if(p1.equals(p2))
                continue;

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

            unitVector_Center = (unitVectorNominator_Center / unitVectorDenominator_Center);
            unitVector_XPosOffset = (unitVectorNominator_XPosOffset / unitVectorDenominator_XPosOffset);
            unitVector_XNegOffset = (unitVectorNominator_XNegOffset / unitVectorDenominator_XNegOffset);
            unitVector_YPosOffset = (unitVectorNominator_YPosOffset / unitVectorDenominator_YPosOffset);
            unitVector_YNegOffset = (unitVectorNominator_YNegOffset / unitVectorDenominator_YNegOffset);

            secondOrderFieldX_Center += (float)(((unitVector_Center * 3) * (p1.getCharacteristic()[0].getBehaviourModifier() * unitVector_Center) - p1.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2))), 3));
            secondOrderFieldX_XPosOffset += (float)(((unitVector_XPosOffset * 3) * (p1.getCharacteristic()[0].getBehaviourModifier() * unitVector_XPosOffset) - p1.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((p2.getX() + 1) - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2))), 3));
            secondOrderFieldX_XNegOffset += (float)(((unitVector_XNegOffset * 3) * (p1.getCharacteristic()[0].getBehaviourModifier() * unitVector_XNegOffset) - p1.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((p2.getX() - 1) - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2))), 3));
            secondOrderFieldX_YPosOffset += (float)(((unitVector_YPosOffset * 3) * (p1.getCharacteristic()[0].getBehaviourModifier() * unitVector_YPosOffset) - p1.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow((p2.getY() + 1) - p1.getY(), 2))), 3));
            secondOrderFieldX_YNegOffset += (float)(((unitVector_YNegOffset * 3) * (p1.getCharacteristic()[0].getBehaviourModifier() * unitVector_YNegOffset) - p1.getCharacteristic()[0].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow((p2.getY() - 1) - p1.getY(), 2))), 3));

            secondOrderFieldX_Average = (secondOrderFieldX_Center + secondOrderFieldX_XPosOffset + secondOrderFieldX_XNegOffset + secondOrderFieldX_YNegOffset + secondOrderFieldX_YPosOffset) / 5;

            secondOrderFieldY_Center += (float)(((unitVector_Center * 3) * (p1.getCharacteristic()[1].getBehaviourModifier() * unitVector_Center) - p1.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2))), 3));
            secondOrderFieldY_XPosOffset += (float)(((unitVector_XPosOffset * 3) * (p1.getCharacteristic()[1].getBehaviourModifier() * unitVector_XPosOffset) - p1.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((p2.getX() + 1) - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2))), 3));
            secondOrderFieldY_XNegOffset += (float)(((unitVector_XNegOffset * 3) * (p1.getCharacteristic()[1].getBehaviourModifier() * unitVector_XNegOffset) - p1.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow((p2.getX() - 1) - p1.getX(), 2)) + (Math.pow(p2.getY() - p1.getY(), 2))), 3));
            secondOrderFieldY_YPosOffset += (float)(((unitVector_YPosOffset * 3) * (p1.getCharacteristic()[1].getBehaviourModifier() * unitVector_YPosOffset) - p1.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow((p2.getY() + 1) - p1.getY(), 2))), 3));
            secondOrderFieldY_YNegOffset += (float)(((unitVector_YNegOffset * 3) * (p1.getCharacteristic()[1].getBehaviourModifier() * unitVector_YNegOffset) - p1.getCharacteristic()[1].getBehaviourModifier()) / Math.pow((float)Math.sqrt((Math.pow(p2.getX() - p1.getX(), 2)) + (Math.pow((p2.getY() - 1) - p1.getY(), 2))), 3));

            secondOrderFieldY_Average = (secondOrderFieldY_Center + secondOrderFieldY_XPosOffset + secondOrderFieldY_XNegOffset + secondOrderFieldY_YNegOffset + secondOrderFieldY_YPosOffset) / 5;

            secondOrderFieldX_Previous = secondOrderFieldX_Final;
            secondOrderFieldY_Previous = secondOrderFieldY_Final;

            secondOrderFieldX_Final = p1.getCharacteristic()[9].getBehaviourModifier() + secondOrderFieldX_Average;
            secondOrderFieldY_Final = p1.getCharacteristic()[10].getBehaviourModifier() + secondOrderFieldY_Average;

            deltaSecondOrderFieldX = (secondOrderFieldX_Final - secondOrderFieldX_Previous);
            deltaSecondOrderFieldY = (secondOrderFieldY_Final - secondOrderFieldY_Previous);

            discreteApprox_DxEx = (deltaSecondOrderFieldX * (p1.getX() + 1)) - (deltaSecondOrderFieldX * p1.getX());
            discreteApprox_DyEx = (deltaSecondOrderFieldX * (p1.getY() + 1)) - (deltaSecondOrderFieldX * p1.getY());
            discreteApprox_DxEy = (deltaSecondOrderFieldY * (p1.getX() + 1)) - (deltaSecondOrderFieldY * p1.getX());
            discreteApprox_DyEy = (deltaSecondOrderFieldY * (p1.getY() + 1)) - (deltaSecondOrderFieldY * p1.getY());

            double forceX_X = (p1.getCharacteristic()[0].getBehaviourModifier() * discreteApprox_DxEx);
            double forceY_X = (p1.getCharacteristic()[1].getBehaviourModifier() * discreteApprox_DyEx);
            double forceX_Y = (p1.getCharacteristic()[0].getBehaviourModifier() * discreteApprox_DxEy);
            double forceY_Y = (p1.getCharacteristic()[1].getBehaviourModifier() * discreteApprox_DyEy);

            p1.getCharacteristic()[2].setBehaviourModifier((float)(forceX_X + forceY_X));
            p1.getCharacteristic()[3].setBehaviourModifier((float)(forceX_Y + forceY_Y));
        }



        //Defines a matrix made up of the polarizabilities of the particle, called the tensor identity matrix
        double[][] mobilityTensorIdentityArray = {{p1.getCharacteristic()[11].getBehaviourModifier(), 0}, {0, p1.getCharacteristic()[12].getBehaviourModifier()}};
        Matrix mobilityTensorIdentityMatrix = new Matrix(mobilityTensorIdentityArray);

        //Calculates the polarizability matrix by multiplying the above matrices
        Matrix mobility = (rotationMatrix.multiply(mobilityTensorIdentityMatrix)).multiply(inverseRotationMatrix);
        mobilityMatrix = mobility;

        float velocityX = (float)mobilityMatrix.getValue(0, 0) * p1.getCharacteristic()[2].getBehaviourModifier();
        float velocityY = (float)mobilityMatrix.getValue(1, 0) * p1.getCharacteristic()[3].getBehaviourModifier();

        p1.getCharacteristic()[4].setBehaviourModifier(velocityX);
        p1.getCharacteristic()[5].setBehaviourModifier(velocityY);

        Date newTime = new Date();
        deltaTime = (newTime.getTime() - oldTime.getTime());

        p1.setX((float)(p1.getCharacteristic()[4].getBehaviourModifier() * (deltaTime / 1000)));
        p1.setY((float)(p1.getCharacteristic()[5].getBehaviourModifier() * (deltaTime / 1000)));

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
            p1.setX((p1.getX()));// * movementModifier);
            p1.setY((p1.getY()));// * movementModifier);
        }

        return lParticles.toArray(Particles);
    }



}
