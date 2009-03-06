
package particlesim;

/**
 * @author Yuehan
 *
 * This class provide the calculator for matrix multiplication, it can calculate
 * 2 by 2 matrix times 2 by 2 matrix or 2 by 2 matrix times 2 by 1 matrix.
 */


public class Matrix {
    private double[][] matrix;
    

    public Matrix(double[][] matrix){
        this.matrix = matrix;
    }

    public Matrix(){

    }


    /* This overwrite method can print out matrix in appropriate way.
     It is nothing to do with calculate, just for testing purpose.*/
    public String toString(){
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

    // This method return the number of rows in the matrix
    public int getMatrixRowSize(){
       int row = this.matrix.length;
       return row;
    }

    // This method return the number of colummes in the matrix
    public int getMatrixColSize(){
       int col = this.matrix[0].length;
       return col;
    }

    // This method calculate 2 by 2 matrix times 2 by 1 matrix.
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

    /* This method calculate 2 by 2 matrix times 2 by 2 matrix.
     * I leave the for loop structure there for later implement purpose.
    */
    public Matrix multiply(Matrix matrixB){
        double solution1, solution2, solution3, solution4;
        
                solution1 = this.matrix[0][0] * matrixB.getValue(0,0)
                            + this.matrix[0][1] * matrixB.getValue(1, 0);

                solution2 = this.matrix[0][0] * matrixB.getValue(0, 1)
                            + this.matrix[0][1] * matrixB.getValue(1, 1);

                solution3 = this.matrix[1][0] * matrixB.getValue(0, 0)
                            + this.matrix[1][1] * matrixB.getValue(1, 0);

                solution4 = this.matrix[1][0] * matrixB.getValue(0, 1)
                            + this.matrix[1][1] * matrixB.getValue(1, 1);

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

            }
        }
        double[][] result = {{solution1 ,solution2},{solution3, solution4}};
        Matrix B = new Matrix(result);
        return B;
    }
     * */
}

