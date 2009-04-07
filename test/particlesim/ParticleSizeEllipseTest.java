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
public class ParticleSizeEllipseTest {

    public ParticleSizeEllipseTest() {
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
     * Test of setParticleSizeX method, of class ParticleSizeEllipse.
     */
    @Test
    public void testSetParticleSizeX() {
        System.out.println("setParticleSizeX");
        int SizeX = 0;
        ParticleSizeEllipse instance = new ParticleSizeEllipse();
        instance.setParticleSizeX(SizeX);

    }

    /**
     * Test of getParticleSizeX method, of class ParticleSizeEllipse.
     */
    @Test
    public void testGetParticleSizeX() {
        System.out.println("getParticleSizeX");
        ParticleSizeEllipse instance = new ParticleSizeEllipse();
        int expResult = 0;
        int result = instance.getParticleSizeX();
        assertEquals(expResult, result);

    }

    /**
     * Test of setParticleSizeY method, of class ParticleSizeEllipse.
     */
    @Test
    public void testSetParticleSizeY() {
        System.out.println("setParticleSizeY");
        int SizeY = 0;
        ParticleSizeEllipse instance = new ParticleSizeEllipse();
        instance.setParticleSizeY(SizeY);

    }

    /**
     * Test of getParticleSizeY method, of class ParticleSizeEllipse.
     */
    @Test
    public void testGetParticleSizeY() {
        System.out.println("getParticleSizeY");
        ParticleSizeEllipse instance = new ParticleSizeEllipse();
        int expResult = 0;
        int result = instance.getParticleSizeY();
        assertEquals(expResult, result);

    }

    /**
     * Test of setParticleSizeZ method, of class ParticleSizeEllipse.
     */
    @Test
    public void testSetParticleSizeZ() {
        System.out.println("setParticleSizeZ");
        int SizeZ = 0;
        ParticleSizeEllipse instance = new ParticleSizeEllipse();
        instance.setParticleSizeZ(SizeZ);

    }

    /**
     * Test of getParticleSizeZ method, of class ParticleSizeEllipse.
     */
    @Test
    public void testGetParticleSizeZ() {
        System.out.println("getParticleSizeZ");
        ParticleSizeEllipse instance = new ParticleSizeEllipse();
        int expResult = 0;
        int result = instance.getParticleSizeZ();
        assertEquals(expResult, result);

    }

}