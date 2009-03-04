/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

/**
 *
 * @author Yuehan
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Yuehan
 */



public class Matrix {
    private double[][] matrix;
    //private double[] sMatrix;

    public Matrix(double[][] matrix){
        this.matrix = matrix;
    }
    public Matrix(double[] sMatrix){
      //  this.sMatrix = sMatrix;
    }
    public Matrix(){

    }



    public String toString(){
        /*
        String str ="";
        String r0c0 = this.matrix[0][0] + "";
        String r0c1 = this.matrix[0][1] + "";
        String r1c0 = this.matrix[1][0] + "";
        String r1c1 = this.matrix[1][1] + "";

        str = "|" + r0c0 + " " + r0c1 + "|" + "\n" + "|" + r1c0 + " " + r1c1 +"|";
        return str;
        */
        String str = "";
        for(int r = 0; r < this.getMatrixRowSize(); r++){
            str += "|";
            for(int c = 0; c < this.getMatrixColSize(); c++){
                 str += this.matrix[r][c] + " ";
            }
            str += "|" + "\n";
        }
        return str;
    }


    public double getValue(int r, int c){
        return this.matrix[r][c];
    }

    public int getMatrixRowSize(){
       int row = this.matrix.length;
       return row;
    }

    public int getMatrixColSize(){
       int col = this.matrix[0].length;
       return col;
    }

    public Matrix s_multiply(Matrix matrixB){
        double solution1, solution2;
         solution1 = this.matrix[0][0] * matrixB.getValue(0,0)
                            + this.matrix[0][1] * matrixB.getValue(1, 0);

         solution2 = this.matrix[1][0] * matrixB.getValue(0, 0)
                            + this.matrix[1][1] * matrixB.getValue(1, 0);


        double[][] resultD = {{solution1 ,solution2}};
        Matrix result = new Matrix(resultD);
        return result;
    }


    public Matrix multiply(Matrix matrixB){

      // if(matrixB.getValue(r, c))
        double solution1, solution2, solution3, solution4;


       // for(int r = 0; r < 2; r++){
         //   for(int c = 0; c < 2; c++){
                solution1 = this.matrix[0][0] * matrixB.getValue(0,0)
                            + this.matrix[0][1] * matrixB.getValue(1, 0);

                solution2 = this.matrix[0][0] * matrixB.getValue(0, 1)
                            + this.matrix[0][1] * matrixB.getValue(1, 1);

                solution3 = this.matrix[1][0] * matrixB.getValue(0, 0)
                            + this.matrix[1][1] * matrixB.getValue(1, 0);

                solution4 = this.matrix[1][0] * matrixB.getValue(0, 1)
                            + this.matrix[1][1] * matrixB.getValue(1, 1);

       //     }
       // }
        double[][] resultD = {{solution1 ,solution2},{solution3, solution4}};
        Matrix result = new Matrix(resultD);
        return result;
    }

    /*
       public Matrix multiply(double[][] matrixB){

        double solution1, solution2, solution3, solution4;

       // for(int r = 0; r < 2; r++){
         //   for(int c = 0; c < 2; c++){
                solution1 = this.matrix[0][0] * matrixB[0][0]
                            + this.matrix[0][1] * matrixB[1][0];

                solution2 = this.matrix[0][0] * matrixB[0][1]
                            + this.matrix[0][1] * matrixB[1][1];

                solution3 = this.matrix[1][0] * matrixB[0][0]
                            + this.matrix[1][1] * matrixB[1][0];

                solution4 = this.matrix[1][0] * matrixB[0][1]
                            + this.matrix[1][1] * matrixB[1][1];

       //     }
       // }
        double[][] result = {{solution1 ,solution2},{solution3, solution4}};
        Matrix B = new Matrix(result);
        return B;
    }
     * */
}

