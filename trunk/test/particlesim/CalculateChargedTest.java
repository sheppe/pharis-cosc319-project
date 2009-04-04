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
public class CalculateChargedTest {

    public CalculateChargedTest() {
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
     * Test of CalculateIteration method, of class CalculateCharged.
     */
    @Test
    public void testCalculateIteration() {
        System.out.println("CalculateIteration");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.CalculateIteration(Particles);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of InitializeParticles method, of class CalculateCharged.
     */
    @Test
    public void testInitializeParticles() {
        System.out.println("InitializeParticles");
        int NumParticles = 0;
        int MaxX = 0;
        int MaxY = 0;
        int MaxZ = 0;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.InitializeParticles(NumParticles, MaxX, MaxY, MaxZ, null, null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MoveParticles method, of class CalculateCharged.
     */
    @Test
    public void testMoveParticles() {
        System.out.println("MoveParticles");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.MoveParticles(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateIteration method, of class CalculateCharged.
     */
    @Test
    public void testCalculateIteration_IParticleArr() {
        System.out.println("CalculateIteration");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.CalculateIteration(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MoveParticles method, of class CalculateCharged.
     */
    @Test
    public void testMoveParticles_IParticleArr() {
        System.out.println("MoveParticles");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.MoveParticles(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateIteration method, of class CalculateCharged.
     */
    @Test
    public void testCalculateIteration_IParticleArr_1args() {
        System.out.println("CalculateIteration");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.CalculateIteration(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InitializeParticles method, of class CalculateCharged.
     */
    @Test
    public void testInitializeParticles_6args() {
        System.out.println("InitializeParticles");
        int NumParticles = 0;
        int MaxX = 0;
        int MaxY = 0;
        int MaxZ = 0;
        IParticleSize ParticleSize = null;
        int[] extraValues = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.InitializeParticles(NumParticles, MaxX, MaxY, MaxZ, ParticleSize, extraValues);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MoveParticles method, of class CalculateCharged.
     */
    @Test
    public void testMoveParticles_IParticleArr_1args() {
        System.out.println("MoveParticles");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.MoveParticles(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateIteration method, of class CalculateCharged.
     */
    @Test
    public void testCalculateIteration_1args_1() {
        System.out.println("CalculateIteration");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.CalculateIteration(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InitializeParticles method, of class CalculateCharged.
     */
    @Test
    public void testInitializeParticles_6args_1() {
        System.out.println("InitializeParticles");
        int NumParticles = 0;
        int MaxX = 0;
        int MaxY = 0;
        int MaxZ = 0;
        IParticleSize ParticleSize = null;
        int[] extraValues = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.InitializeParticles(NumParticles, MaxX, MaxY, MaxZ, ParticleSize, extraValues);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MoveParticles method, of class CalculateCharged.
     */
    @Test
    public void testMoveParticles_1args_1() {
        System.out.println("MoveParticles");
        IParticle[] Particles = null;
        CalculateCharged instance = new CalculateCharged();
        IParticle[] expResult = null;
        IParticle[] result = instance.MoveParticles(Particles);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}