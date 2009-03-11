package particlesim;

/**
 * @author Yuehan
 */
public class Formula {

    private Matrix tensor_0,  rotation,  rotation_invers,  field,  tensor;
    /* Generate a random number for initial orientation of particle (in lab frame),
     * then convert it as degree.
     */
    private double degree = (Math.random()) / 180 * Math.PI;
    private double differDeg, degByTime ;

    /**
     * @param rotaMobility--- rotational mobility
     * @param PAPParaller---the polarizability alone principle axis parallely
     * @param PAPParaller---the polarizability alone principle axis vertically
     * @param fieldNull
     * @param omege
     */
    public Formula(double rotaMobility, double PAPParalle, double PAPVertical, double fieldNull, double omega) {

        // formula for changing angle by one time step.
        differDeg = (-fieldNull * (PAPParalle - PAPVertical) * Math.sin(2 * (degree - omega)) * 1) / 180 * Math.PI;

        // ccurrent angle after one time step.
        degByTime = degree + differDeg;

        // Create rotation matrix R
        double[][] rota = {{Math.cos(degByTime), Math.sin(degByTime)}, {(-Math.sin(degByTime)), Math.cos(degByTime)}};
        Matrix R = new Matrix(rota);

        // Create matrix which is the invers of rotation matrix.
        double[][] rota_invers = {{Math.cos(degByTime), (-Math.sin(degByTime))}, {Math.sin(degByTime), Math.cos(degByTime)}};
        Matrix R_invers = new Matrix(rota_invers);

        /*
        System.out.println(Math.cos(degree));
        System.out.println(Math.sin(degree));
         */

        //create matrix for tensor 0 (alpha 0)
        double[][] a_0 = {{PAPParalle, 0}, {0, PAPVertical}};
        Matrix tensor_0 = new Matrix(a_0);


        //using above 3 matrix to calculate matrix tensor (alpha) (this is formular 2)
        Matrix tensor = R_invers.multiply(tensor_0).multiply(R);


        // create filed matrix E;
        double E_x = fieldNull * Math.cos(omega);
        double E_y = fieldNull * Math.sin(omega);
        double[][] field = {{E_x}, {E_y}};
        Matrix E = new Matrix(field);


        this.rotation = R;
        this.rotation_invers = R_invers;
        this.tensor_0 = tensor_0;
        this.tensor = tensor;
        this.field = E;
    }


    // Return the rotation angle by one time step
    public double getDegByTime(){
        return degByTime;
    }


    // calculate Matrix P (this is formular 1)
    public Matrix solv_P() {
        Matrix P = tensor.s_multiply(field);
        return P;
    }


    // This is formular 2, calculation part did in the constructor
    public Matrix solv_tensor() {
        return tensor;
    }

    
    // formular 3, this methods does the same thing as method matrix solv_P does.
    public Matrix solv_Phard() {
        Matrix P = rotation_invers.multiply(tensor_0).multiply(rotation).s_multiply(field);
        return P;
    }
}

