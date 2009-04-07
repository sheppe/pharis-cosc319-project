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
public class CalculateElecFieldParticleTest {

    public CalculateElecFieldParticleTest() {
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
     * Test of CalculateIteration method, of class CalculateElecFieldParticle.
     */
    @Test
    public void testCalculateIteration() {
        System.out.println("CalculateIteration");
        IParticle[] Particles = null;
        CalculateElecFieldParticle instance = new CalculateElecFieldParticle();
        IParticle[] expResult = null;
        IParticle[] result = instance.CalculateIteration(Particles);
        assertEquals(expResult, result);
    }

    /**
     * Test of InitializeParticles method, of class CalculateElecFieldParticle.
     */
    @Test
    public void testInitializeParticles() {
        System.out.println("InitializeParticles");
        int NumParticles = 0;
        int MaxX = 0;
        int MaxY = 0;
        int MaxZ = 0;
        IParticleSize ParticleSize = null;
        int[] extraValues = null;
        CalculateElecFieldParticle instance = new CalculateElecFieldParticle();
        IParticle[] expResult = null;
        IParticle[] result = instance.InitializeParticles(NumParticles, MaxX, MaxY, MaxZ, ParticleSize, extraValues);
        assertEquals(expResult, result);
    }

    /**
     * Test of MoveParticles method, of class CalculateElecFieldParticle.
     */
    @Test
    public void testMoveParticles() {
        System.out.println("MoveParticles");
        IParticle[] Particles = null;
        CalculateElecFieldParticle instance = new CalculateElecFieldParticle();
        IParticle[] expResult = null;
        IParticle[] result = instance.MoveParticles(Particles);
        assertEquals(expResult, result);
    }

}