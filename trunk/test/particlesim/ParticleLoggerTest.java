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
public class ParticleLoggerTest {

    public ParticleLoggerTest() {
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
     * Test of Log method, of class ParticleLogger.
     */
    @Test
    public void testLog() {
        System.out.println("Log");
        int TimeStep = 0;
        IParticle[] Particles = null;
        ParticleLogger instance = new ParticleLogger();
        instance.Log(TimeStep, Particles);

    }

}