package particlesim;

import java.util.Random;

/**
 * @author Yuehan
 */
public class Formula {

   private Matrix tensor_0, rotation, rotation_invers, field;

   // Generate a random number for initial orientation of particle
   //(in lab frame), then convert it as degree.
   // range
   private double degree;

   //it holds the vlaue of polarizability along
   //principle axis parallely
   private double PAPParalle;

   //it holds the vlaue of polarizability along
   //principle axis vertically
   private double PAPVertical;

   //field Null
   private double fieldNull;

   //omega initial to 0 at this moment
   private double omega = 0;

   //holds the value of rotational mobility
   private double rotaMobility;

   //the degree by time is a variable needed to constructed
   //a matrix, the differenct degree calculats the degByTime
   private double differDeg, degByTime;

   private final int deltaT = 1;

   public Formula(double PAPParalle, double PAPVertical, double fieldNull, double omega, double rotaMobility) {

       this.setPAPParalle(PAPParalle);
       this.setPAPVertical(PAPVertical);
       this.setFieldNull(fieldNull);
       this.setOmega(omega);
       this.setRotaMobility(rotaMobility);
       this.setIniDegree();
       this.setDifferDeg();
       this.setDegByTime();
       
        // Create rotation matrix R
        double[][] rota = {{Math.cos(this.degByTime), Math.sin(this.degByTime)}, {(-Math.sin(this.degByTime)), Math.cos(this.degByTime)}};
        Matrix R = new Matrix(rota);

        // Create matrix which is the invers of rotation matrix.
        double[][] rota_invers = {{Math.cos(this.degByTime), (-Math.sin(this.degByTime))}, {Math.sin(this.degByTime), Math.cos(this.degByTime)}};
        Matrix R_invers = new Matrix(rota_invers);

        /*
        System.out.println(Math.cos(degree));
        System.out.println(Math.sin(degree));
         */

        //create matrix for tensor 0 (alpha 0)
        double[][] a_0 = {{this.PAPParalle, 0}, {0, this.PAPVertical}};
        Matrix tensor_0 = new Matrix(a_0);


       // create filed matrix E;
        double E_x = this.fieldNull * Math.cos(this.omega);
        double E_y = this.fieldNull * Math.sin(this.omega);
        double[][] field = {{E_x}, {E_y}};
        Matrix E = new Matrix(field);


        this.rotation = R;
        this.rotation_invers = R_invers;
        this.tensor_0 = tensor_0;
        this.field = E;
    }

   public double getPAPParalle(){
       return this.PAPParalle;
   }

   public double getPAPVertical(){
       return this.PAPVertical;
   }

   public double getFieldNull(){
       return this.fieldNull;
   }

   public double getOmega(){
       return this.omega;
   }

   public double getRotaMobility(){
       return this.rotaMobility;
   }

   public double getInitDegree(){
       return this.degree;
   }

   public double getDifferDeg(){
       return this.differDeg;
   }

   public double getDegByTime(){
       return this.degByTime;
   }

   public Matrix getRotaMatrix(){
       return this.rotation;
   }

   public Matrix getRotaInversMatrix(){
       return this.rotation_invers;
   }

   public Matrix getTensorMatrix(){
       return this.tensor_0;
   }

   public Matrix getFieldMatrix(){
       return this.field;
   }



   public void setPAPParalle(double PAPParalle){
      this.PAPParalle = PAPParalle;
   }

   public void setPAPVertical(double PAPVertical){
      this.PAPVertical = PAPVertical;
   }

   public void setFieldNull(double fieldNull){
      this.fieldNull = fieldNull;
   }

   public void setOmega(double omega){
      this.omega = omega;
   }

   public void setRotaMobility(double rotaMobility){
      this.rotaMobility = rotaMobility;
   }

    /**
    * Generates a random initial degree for the particle
    * range from 0 to 360
    */
   public void setIniDegree(){
       Random ran = new Random();
       double ranNumber = ran.nextDouble() * 360;
       this.degree = ranNumber;
   }

   /**
    * calculates the Difference degree by 1 second
    */
   public void setDifferDeg(){
      // formula for changing angle by one time step
      double oneTimeStepDeg = -this.rotaMobility * this.fieldNull * (this.PAPParalle - this.PAPVertical) * Math.sin(2 * (this.degree - this.omega)) * this.deltaT;

      this.differDeg = oneTimeStepDeg;
   }

   /**
    * calculates the current rotation degree of the partical
    */
   public void setDegByTime(){
        // ccurrent angle after one time step.
       double currentDegree = (this.degree + this.differDeg) % 360;

        this.degByTime = currentDegree;
   }
   

    /**
     * solve the dipole moment P on partical
     * @return a matrix of dipolmoment.
     */
    public Matrix solvDipoleMoment() {
        Matrix P =  rotation_invers.multiply(tensor_0).multiply(rotation).s_multiply(field);
        return P;
    }

    /**
     * sovle the tensor
     * @return a matrix of tensor.
     */
    public Matrix solvTensor() {
        Matrix tensor = rotation_invers.multiply(tensor_0).multiply(rotation);
        return tensor;
    }
}
