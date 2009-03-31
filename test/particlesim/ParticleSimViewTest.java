/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ParticleSimViewTest {

    public ParticleSimViewTest() {
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
     * Test of showAboutBox method, of class ParticleSimView.
     */
    @Test
    public void testShowAboutBox() {
        System.out.println("showAboutBox");
        ParticleSimView instance = null;
        instance.showAboutBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ParticleTypeSelected method, of class ParticleSimView.
     */
    @Test
    public void testParticleTypeSelected() {
        System.out.println("ParticleTypeSelected");
        ParticleSimView instance = null;
        try {
            instance.ParticleTypeSelected();
        } catch (InstantiationException ex) {
            Logger.getLogger(ParticleSimViewTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ParticleSimViewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAboutBox method, of class ParticleSimView.
     */
    @Test
    public void testShowAboutBox1() {
        System.out.println("showAboutBox");
        ParticleSimView instance = null;
        instance.showAboutBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ParticleTypeSelected method, of class ParticleSimView.
     */
    @Test
    public void testParticleTypeSelected1() throws Exception {
        System.out.println("ParticleTypeSelected");
        ParticleSimView instance = null;
        instance.ParticleTypeSelected();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}