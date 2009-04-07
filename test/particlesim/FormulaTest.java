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

    }

    /**
     * Test of getPAPParalle method, of class Formula.
     */
    @Test
    public void testGetPAPParalle() {
        System.out.println("getPAPParalle");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getPAPParalle();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPAPVertical method, of class Formula.
     */
    @Test
    public void testGetPAPVertical() {
        System.out.println("getPAPVertical");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getPAPVertical();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFieldNull method, of class Formula.
     */
    @Test
    public void testGetFieldNull() {
        System.out.println("getFieldNull");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getFieldNull();
        assertEquals(expResult, result);

    }

    /**
     * Test of getOmega method, of class Formula.
     */
    @Test
    public void testGetOmega() {
        System.out.println("getOmega");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getOmega();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRotaMobility method, of class Formula.
     */
    @Test
    public void testGetRotaMobility() {
        System.out.println("getRotaMobility");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getRotaMobility();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInitDegree method, of class Formula.
     */
    @Test
    public void testGetInitDegree() {
        System.out.println("getInitDegree");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getInitDegree();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDifferDeg method, of class Formula.
     */
    @Test
    public void testGetDifferDeg() {
        System.out.println("getDifferDeg");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getDifferDeg();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDegByTime method, of class Formula.
     */
    @Test
    public void testGetDegByTime1() {
        System.out.println("getDegByTime");
        Formula instance = null;
        double expResult = 0.0;
        double result = instance.getDegByTime();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRotaMatrix method, of class Formula.
     */
    @Test
    public void testGetRotaMatrix() {
        System.out.println("getRotaMatrix");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.getRotaMatrix();
        assertEquals(expResult, result);

    }

    /**
     * Test of getRotaInversMatrix method, of class Formula.
     */
    @Test
    public void testGetRotaInversMatrix() {
        System.out.println("getRotaInversMatrix");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.getRotaInversMatrix();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTensorMatrix method, of class Formula.
     */
    @Test
    public void testGetTensorMatrix() {
        System.out.println("getTensorMatrix");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.getTensorMatrix();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFieldMatrix method, of class Formula.
     */
    @Test
    public void testGetFieldMatrix() {
        System.out.println("getFieldMatrix");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.getFieldMatrix();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPAPParalle method, of class Formula.
     */
    @Test
    public void testSetPAPParalle() {
        System.out.println("setPAPParalle");
        double PAPParalle = 0.0;
        Formula instance = null;
        instance.setPAPParalle(PAPParalle);

    }

    /**
     * Test of setPAPVertical method, of class Formula.
     */
    @Test
    public void testSetPAPVertical() {
        System.out.println("setPAPVertical");
        double PAPVertical = 0.0;
        Formula instance = null;
        instance.setPAPVertical(PAPVertical);

    }

    /**
     * Test of setFieldNull method, of class Formula.
     */
    @Test
    public void testSetFieldNull() {
        System.out.println("setFieldNull");
        double fieldNull = 0.0;
        Formula instance = null;
        instance.setFieldNull(fieldNull);

    }

    /**
     * Test of setOmega method, of class Formula.
     */
    @Test
    public void testSetOmega() {
        System.out.println("setOmega");
        double omega = 0.0;
        Formula instance = null;
        instance.setOmega(omega);

    }

    /**
     * Test of setRotaMobility method, of class Formula.
     */
    @Test
    public void testSetRotaMobility() {
        System.out.println("setRotaMobility");
        double rotaMobility = 0.0;
        Formula instance = null;
        instance.setRotaMobility(rotaMobility);

    }

    /**
     * Test of setIniDegree method, of class Formula.
     */
    @Test
    public void testSetIniDegree() {
        System.out.println("setIniDegree");
        Formula instance = null;
        instance.setIniDegree();

    }

    /**
     * Test of setDifferDeg method, of class Formula.
     */
    @Test
    public void testSetDifferDeg() {
        System.out.println("setDifferDeg");
        Formula instance = null;
        instance.setDifferDeg();

    }

    /**
     * Test of setDegByTime method, of class Formula.
     */
    @Test
    public void testSetDegByTime() {
        System.out.println("setDegByTime");
        Formula instance = null;
        instance.setDegByTime();

    }

    /**
     * Test of solvDipoleMoment method, of class Formula.
     */
    @Test
    public void testSolvDipoleMoment() {
        System.out.println("solvDipoleMoment");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.solvDipoleMoment();
        assertEquals(expResult, result);

    }

    /**
     * Test of solvTensor method, of class Formula.
     */
    @Test
    public void testSolvTensor() {
        System.out.println("solvTensor");
        Formula instance = null;
        Matrix expResult = null;
        Matrix result = instance.solvTensor();
        assertEquals(expResult, result);

    }

}