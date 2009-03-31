/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sheppe
 */
public class MatrixTest {

    public MatrixTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Matrix.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Matrix instance = new Matrix();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Matrix.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int r = 0;
        int c = 0;
        Matrix instance = new Matrix();
        double expResult = 0.0;
        double result = instance.getValue(r, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrixRowSize method, of class Matrix.
     */
    @Test
    public void testGetMatrixRowSize() {
        System.out.println("getMatrixRowSize");
        Matrix instance = new Matrix();
        int expResult = 0;
        int result = instance.getMatrixRowSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrixColSize method, of class Matrix.
     */
    @Test
    public void testGetMatrixColSize() {
        System.out.println("getMatrixColSize");
        Matrix instance = new Matrix();
        int expResult = 0;
        int result = instance.getMatrixColSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of s_multiply method, of class Matrix.
     */
    @Test
    public void testS_multiply() {
        System.out.println("s_multiply");
        Matrix matrixB = null;
        Matrix instance = new Matrix();
        Matrix expResult = null;
        Matrix result = instance.s_multiply(matrixB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Matrix.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Matrix matrixB = null;
        Matrix instance = new Matrix();
        Matrix expResult = null;
        Matrix result = instance.multiply(matrixB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}