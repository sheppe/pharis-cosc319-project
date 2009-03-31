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
public class FormulaTest {

    public FormulaTest() {
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
     * Test of getDegByTime method, of class Formula.
     */
    @Test
    public void testGetDegByTime() {
        System.out.println("getDegByTime");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getDegByTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solv_P method, of class Formula.
     */
    @Test
    public void testSolv_P() {
        System.out.println("solv_P");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.solv_P();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solv_tensor method, of class Formula.
     */
    @Test
    public void testSolv_tensor() {
        System.out.println("solv_tensor");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.solv_tensor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solv_Phard method, of class Formula.
     */
    @Test
    public void testSolv_Phard() {
        System.out.println("solv_Phard");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.solv_Phard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}