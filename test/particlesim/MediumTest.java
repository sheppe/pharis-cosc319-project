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
public class MediumTest {

    public MediumTest() {
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
     * Test of getGravity method, of class Medium.
     */
    @Test
    public void testGetGravity() {
        System.out.println("getGravity");
        Medium instance = new Medium();
        float expResult = 0.0F;
        float result = instance.getGravity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Medium.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Medium instance = new Medium();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getViscosity method, of class Medium.
     */
    @Test
    public void testGetViscosity() {
        System.out.println("getViscosity");
        Medium instance = new Medium();
        float expResult = 0.0F;
        float result = instance.getViscosity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGravity method, of class Medium.
     */
    @Test
    public void testSetGravity() {
        System.out.println("setGravity");
        float newValue = 0.0F;
        Medium instance = new Medium();
        instance.setGravity(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Medium.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newValue = "";
        Medium instance = new Medium();
        instance.setName(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setViscosity method, of class Medium.
     */
    @Test
    public void testSetViscosity() {
        System.out.println("setViscosity");
        float newValue = 0.0F;
        Medium instance = new Medium();
        instance.setViscosity(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGravity method, of class Medium.
     */
    @Test
    public void testGetGravity1() {
        System.out.println("getGravity");
        Medium instance = new Medium();
        float expResult = 0.0F;
        float result = instance.getGravity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Medium.
     */
    @Test
    public void testGetName1() {
        System.out.println("getName");
        Medium instance = new Medium();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getViscosity method, of class Medium.
     */
    @Test
    public void testGetViscosity1() {
        System.out.println("getViscosity");
        Medium instance = new Medium();
        float expResult = 0.0F;
        float result = instance.getViscosity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGravity method, of class Medium.
     */
    @Test
    public void testSetGravity_float() {
        System.out.println("setGravity");
        float newValue = 0.0F;
        Medium instance = new Medium();
        instance.setGravity(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Medium.
     */
    @Test
    public void testSetName_String() {
        System.out.println("setName");
        String newValue = "";
        Medium instance = new Medium();
        instance.setName(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setViscosity method, of class Medium.
     */
    @Test
    public void testSetViscosity_float() {
        System.out.println("setViscosity");
        float newValue = 0.0F;
        Medium instance = new Medium();
        instance.setViscosity(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}