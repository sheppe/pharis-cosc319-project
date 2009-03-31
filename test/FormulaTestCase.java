
import java.text.DecimalFormat;
import junit.framework.TestCase;
import particlesim.Formula;
import particlesim.Matrix;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yuehan
 */
public class FormulaTestCase extends TestCase {

    private double degree = 30;

    private double[][] rota = {{Math.cos(30), Math.sin(30)}, {(-Math.sin(30)), Math.cos(30)}};
    Matrix rotation = new Matrix(rota);

    private double[][] rota_invers = {{Math.cos(30), (-Math.sin(30))}, {Math.sin(30), Math.cos(30)}};
    Matrix rotation_invers = new Matrix(rota_invers);

    private double[][] a_0 = {{1, 0}, {0, 0.9}};
    Matrix tensor_0 = new Matrix(a_0);

    private double[][] field0 = {{1}, {0}};
    Matrix field = new Matrix(field0);
    
    Formula p = new Formula(1, 0.9, 1, 0, 0.001);

    public void testgetInitDegree(){
        double mini = 360, max = 0;
        for(int i = 0; i < 100000; i++){

            double ran = p.getInitDegree();
            if(ran > 360.0 || ran < 0){
                FormulaTestCase.fail();
            }
            if(ran > max){
                max = ran;
             }else{
                if(ran < mini){
                 mini = ran;
                }
            }
        }
        System.out.println("Max is: " + max);
        System.out.println("Mini is: " + mini);
    }

    
    public void testsetDifferDeg(){
        boolean bool = false;
        double result0 = p.getDifferDeg();
        DecimalFormat df = new DecimalFormat("#,##0.000000");
        double result = Double.parseDouble(df.format(result0));
        double answer0 = -0.0001 * Math.sin(2*p.getInitDegree());
        double answer = Double.parseDouble(df.format(answer0));
        double wrongAns = 0.3333;

        FormulaTestCase.assertEquals(answer0, result0, 0.000000001);
        FormulaTestCase.assertTrue(result == answer);
        FormulaTestCase.assertFalse(result == wrongAns);

        System.out.println("The expected answer is " + result0 + ", and actural result is: " + answer0);
    }
    
    public void testcalDegByTime(){
        double result = p.getDegByTime();
        double iniDegree = p.getInitDegree();
        double difDegree = -0.0001 * Math.sin(2*p.getInitDegree());
        double answer = (iniDegree + difDegree)%360;
       
        FormulaTestCase.assertEquals(answer, result);
        System.out.println("The expected answer is " + result + ", and actural result is: " + answer);
    }

/*
    public void testsolv_P(){
          Matrix result = p.solv_P();

          double[][] answerArr = {{20},{20}};
          Matrix answer = new Matrix(answerArr);

          //test result against the right answer
          FormulaTestCase.assertTrue(result.equals(answer));

          //test result against the wrong answer
          FormulaTestCase.assertFalse(result.equals(answer));
    }
*/
}
