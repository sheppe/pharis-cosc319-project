/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import particlesim.resources.ResourcesSuite;

/**
 *
 * @author Sheppe
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({FormulaTest.class, CalculateChargedTest.class, ChargedParticleTest.class, MediumTest.class, MatrixTest.class, CharacteristicTest.class, CharacteristicTypeTest.class, ResourcesSuite.class, ParticleSimViewTest.class, ElecFieldParticleTest.class, ParticleSimAboutBoxTest.class, ParticleSimAppTest.class, DrawParticlesTest.class})
public class ParticlesimSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}