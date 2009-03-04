/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Yuehan
 */

public class Formula {

    private Matrix tensor_0,  rotation,  rotation_invers,  field, tensor;

    public Formula(double degree, double aPara, double aVerti) {

        //create rotation matrix R and its invers
        degree = Math.cos((degree / 180) * Math.PI);
        double[][] rota = {{Math.cos(degree), Math.sin(degree)}, {(-Math.sin(degree)), Math.cos(degree)}};
        Matrix R = new Matrix(rota);
        double[][] rota_invers = {{Math.cos(degree), (-Math.sin(degree))}, {Math.sin(degree), Math.cos(degree)}};
        Matrix R_invers = new Matrix(rota_invers);
        System.out.println(Math.cos(degree));
        System.out.println(Math.sin(degree));

        //create matrix for tensor 0 (alpha 0)
        double[][] a_0 = {{aPara, 0}, {0, aVerti}};
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

    // calculate Matrix P (this is formular 3)
    public Matrix solv_P() {
        Matrix P = tensor.multiply(field);
        return P;
    }

    // This is formular 2, calculation part did in the constructor
    public Matrix solv_tensor() {
        return tensor;
    }

    // formular 3
    public Matrix solv_Phard() {
        Matrix P = rotation_invers.multiply(tensor_0).multiply(rotation).multiply(field);
        return P;
    }

}

