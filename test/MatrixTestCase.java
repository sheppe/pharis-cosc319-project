
import junit.framework.TestCase;
import particlesim.Matrix;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuehan
 */
public class MatrixTestCase extends TestCase{
     private double[][] doubleArr0 = {{5},{5}};
     private Matrix myMat0 = new Matrix(doubleArr0);

     private double[][] doubleArr1 = {{2,2},{2,2}};
     private Matrix myMat1 = new Matrix(doubleArr1);

     private double[][] doubleArr2 = {{3,0},{3,0}};
     private Matrix myMat2 = new Matrix(doubleArr2);

     private double[][] doubleArr3 = {{3,3},{3,3}};
     private Matrix myMat3 = new Matrix(doubleArr3);

    public void testS_multiply(){
          Matrix result = myMat1.s_multiply(myMat0);
          
          double[][] answerArr = {{20},{20}};
          Matrix answer = new Matrix(answerArr);

          //test result against the right answer
          MatrixTestCase.assertTrue(result.equals(answer));

          //test result against the wrong answer
          MatrixTestCase.assertFalse(result.equals(myMat0));
    }

    public void testMultiply(){
          Matrix result = myMat1.multiply(myMat3);

          double[][] answerArr = {{12,12},{12,12}};
          Matrix answer = new Matrix(answerArr);

          //test the result against the right answer
          MatrixTestCase.assertTrue(result.equals(answer));

          //test the result against the wrong answer
          MatrixTestCase.assertFalse(result.equals(myMat3));
    }

    public void testIs2by1Matrix(){
        //when the matrix is 2 by 2 matrix
        MatrixTestCase.assertFalse(myMat3.is2by1Matrix());

        //when the matrix is a 2 by 1 matrix
        MatrixTestCase.assertTrue(myMat0.is2by1Matrix());
    }

    public void testEquals(){
        double[][] answerArr = {{3,0},{3,0}};
        Matrix answer = new Matrix(answerArr);

        double[][] answerArr0 = {{5},{5}};
        Matrix answer0 = new Matrix(answerArr0);

        double[][] answerArr1 = {{6},{6}};
        Matrix answer1 = new Matrix(answerArr1);

        //test when two 2 by 2 matrix is equal
        MatrixTestCase.assertTrue(myMat2.equals(answer));

        //test when two 2 by 2 matrix is not equal
        MatrixTestCase.assertFalse(myMat2.equals(myMat3));

        //test when two 2 by 1 matrix is equal
        MatrixTestCase.assertTrue(myMat0.equals(answer0));

        //test when two 2 by 1 matrix is not equal
        MatrixTestCase.assertFalse(myMat0.equals(answer1));
    }
  
}
