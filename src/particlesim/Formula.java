

package particlesim;


/**
 * @author Yuehan
 */


public class Formula {
    private Matrix tensor_0,  rotation,  rotation_invers,  field, tensor;
/**
 * @param degree---the rotation angle of particle
 * @param PAPParaller---the polarizability alone principle axis parallely
 * @param PAPParaller---the polarizability alone principle axis vertically
 */
    public Formula(double degree, double PAPParalle, double PAPVertical) {

        //create rotation matrix R and its invers
        degree = Math.cos((degree / 180) * Math.PI);
        double[][] rota = {{Math.cos(degree), Math.sin(degree)}, {(-Math.sin(degree)), Math.cos(degree)}};
        Matrix R = new Matrix(rota);
        double[][] rota_invers = {{Math.cos(degree), (-Math.sin(degree))}, {Math.sin(degree), Math.cos(degree)}};
        Matrix R_invers = new Matrix(rota_invers);
        System.out.println(Math.cos(degree));
        System.out.println(Math.sin(degree));

        //create matrix for tensor 0 (alpha 0)
        double[][] a_0 = {{PAPParalle, 0}, {0, PAPVertical}};
        Matrix tensor_0 = new Matrix(a_0);

        //using above 3 matrix to calculate matrix tensor (alpha) (this is formular 2)
        Matrix tensor = R_invers.multiply(tensor_0).multiply(R);

        // create filed matrix E;
        double E_x = 1 * Math.cos(0);
        double E_y = 1 * Math.sin(0);
        double[][] field = {{E_x}, {E_y}};
        Matrix E = new Matrix(field);

        this.rotation = R;
        this.rotation_invers = R_invers;
        this.tensor_0 = tensor_0;
        this.tensor = tensor;
        this.field = E;

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

