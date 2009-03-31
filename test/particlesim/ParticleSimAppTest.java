/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import java.awt.Window;
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
public class ParticleSimAppTest {

    public ParticleSimAppTest() {
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
     * Test of startup method, of class ParticleSimApp.
     */
    @Test
    public void testStartup() {
        System.out.println("startup");
        ParticleSimApp instance = new ParticleSimApp();
        instance.startup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configureWindow method, of class ParticleSimApp.
     */
    @Test
    public void testConfigureWindow() {
        System.out.println("configureWindow");
        Window root = null;
        ParticleSimApp instance = new ParticleSimApp();
        instance.configureWindow(root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplication method, of class ParticleSimApp.
     */
    @Test
    public void testGetApplication() {
        System.out.println("getApplication");
        ParticleSimApp expResult = null;
        ParticleSimApp result = ParticleSimApp.getApplication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ParticleSimApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ParticleSimApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startup method, of class ParticleSimApp.
     */
    @Test
    public void testStartup1() {
        System.out.println("startup");
        ParticleSimApp instance = new ParticleSimApp();
        instance.startup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configureWindow method, of class ParticleSimApp.
     */
    @Test
    public void testConfigureWindow_Window() {
        System.out.println("configureWindow");
        Window root = null;
        ParticleSimApp instance = new ParticleSimApp();
        instance.configureWindow(root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplication method, of class ParticleSimApp.
     */
    @Test
    public void testGetApplication1() {
        System.out.println("getApplication");
        ParticleSimApp expResult = null;
        ParticleSimApp result = ParticleSimApp.getApplication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ParticleSimApp.
     */
    @Test
    public void testMain_StringArr() {
        System.out.println("main");
        String[] args = null;
        ParticleSimApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}