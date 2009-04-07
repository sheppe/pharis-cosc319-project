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
public class ChargedParticleTest {

    public ChargedParticleTest() {
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
     * Test of getCharacteristic method, of class ChargedParticle.
     */
    @Test
    public void testGetCharacteristic() {
        System.out.println("getCharacteristic");
        ChargedParticle instance = new ChargedParticle();
        Characteristic[] expResult = new Characteristic[3];
        Characteristic[] result = instance.getCharacteristic();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCharacteristic method, of class ChargedParticle.
     */
    @Test
    public void testSetCharacteristic() {
        System.out.println("setCharacteristic");
        Characteristic[] newValue = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setCharacteristic(newValue);

    }

    /**
     * Test of getMedium method, of class ChargedParticle.
     */
    @Test
    public void testGetMedium() {
        System.out.println("getMedium");
        ChargedParticle instance = new ChargedParticle();
        Medium expResult = null;
        Medium result = instance.getMedium();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMedium method, of class ChargedParticle.
     */
    @Test
    public void testSetMedium() {
        System.out.println("setMedium");
        Medium newValue = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setMedium(newValue);

    }

    /**
     * Test of getX method, of class ChargedParticle.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getX();
        assertEquals(expResult, result);

    }

    /**
     * Test of setX method, of class ChargedParticle.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setX(newValue);

    }

    /**
     * Test of getY method, of class ChargedParticle.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getY();
        assertEquals(expResult, result);

    }

    /**
     * Test of setY method, of class ChargedParticle.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setY(newValue);

    }

    /**
     * Test of getZ method, of class ChargedParticle.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getZ();
        assertEquals(expResult, result);

    }

    /**
     * Test of setZ method, of class ChargedParticle.
     */
    @Test
    public void testSetZ() {
        System.out.println("setZ");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setZ(newValue);

    }

    /**
     * Test of getCharacteristic method, of class ChargedParticle.
     */
    @Test
    public void testGetCharacteristic1() {
        System.out.println("getCharacteristic");
        ChargedParticle instance = new ChargedParticle();
        Characteristic[] expResult = new Characteristic[3];
        Characteristic[] result = instance.getCharacteristic();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCharacteristic method, of class ChargedParticle.
     */
    @Test
    public void testSetCharacteristic_CharacteristicArr() {
        System.out.println("setCharacteristic");
        Characteristic[] newValue = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setCharacteristic(newValue);

    }

    /**
     * Test of getMedium method, of class ChargedParticle.
     */
    @Test
    public void testGetMedium1() {
        System.out.println("getMedium");
        ChargedParticle instance = new ChargedParticle();
        Medium expResult = null;
        Medium result = instance.getMedium();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMedium method, of class ChargedParticle.
     */
    @Test
    public void testSetMedium_Medium() {
        System.out.println("setMedium");
        Medium newValue = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setMedium(newValue);

    }

    /**
     * Test of getX method, of class ChargedParticle.
     */
    @Test
    public void testGetX1() {
        System.out.println("getX");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getX();
        assertEquals(expResult, result);

    }

    /**
     * Test of setX method, of class ChargedParticle.
     */
    @Test
    public void testSetX_float() {
        System.out.println("setX");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setX(newValue);

    }

    /**
     * Test of getY method, of class ChargedParticle.
     */
    @Test
    public void testGetY1() {
        System.out.println("getY");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getY();
        assertEquals(expResult, result);

    }

    /**
     * Test of setY method, of class ChargedParticle.
     */
    @Test
    public void testSetY_float() {
        System.out.println("setY");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setY(newValue);

    }

    /**
     * Test of getZ method, of class ChargedParticle.
     */
    @Test
    public void testGetZ1() {
        System.out.println("getZ");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getZ();
        assertEquals(expResult, result);

    }

    /**
     * Test of setZ method, of class ChargedParticle.
     */
    @Test
    public void testSetZ_float() {
        System.out.println("setZ");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setZ(newValue);

    }

    /**
     * Test of getCalcName method, of class ChargedParticle.
     */
    @Test
    public void testGetCalcName() {
        System.out.println("getCalcName");
        ChargedParticle instance = new ChargedParticle();
        String expResult = "particlesim.CalculateCharged";
        String result = instance.getCalcName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCharacteristic method, of class ChargedParticle.
     */
    @Test
    public void testGetCharacteristic2() {
        System.out.println("getCharacteristic");
        ChargedParticle instance = new ChargedParticle();
        Characteristic[] expResult = new Characteristic[3];
        Characteristic[] result = instance.getCharacteristic();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCharacteristic method, of class ChargedParticle.
     */
    @Test
    public void testSetCharacteristic_CharacteristicArr_1args() {
        System.out.println("setCharacteristic");
        Characteristic[] newValue = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setCharacteristic(newValue);

    }

    /**
     * Test of getMedium method, of class ChargedParticle.
     */
    @Test
    public void testGetMedium2() {
        System.out.println("getMedium");
        ChargedParticle instance = new ChargedParticle();
        Medium expResult = null;
        Medium result = instance.getMedium();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMedium method, of class ChargedParticle.
     */
    @Test
    public void testSetMedium_Medium_1args() {
        System.out.println("setMedium");
        Medium newValue = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setMedium(newValue);

    }

    /**
     * Test of getX method, of class ChargedParticle.
     */
    @Test
    public void testGetX2() {
        System.out.println("getX");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getX();
        assertEquals(expResult, result);

    }

    /**
     * Test of setX method, of class ChargedParticle.
     */
    @Test
    public void testSetX_float_1args() {
        System.out.println("setX");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setX(newValue);

    }

    /**
     * Test of getY method, of class ChargedParticle.
     */
    @Test
    public void testGetY2() {
        System.out.println("getY");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getY();
        assertEquals(expResult, result);

    }

    /**
     * Test of setY method, of class ChargedParticle.
     */
    @Test
    public void testSetY_float_1args() {
        System.out.println("setY");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setY(newValue);

    }

    /**
     * Test of getZ method, of class ChargedParticle.
     */
    @Test
    public void testGetZ2() {
        System.out.println("getZ");
        ChargedParticle instance = new ChargedParticle();
        float expResult = 0.0F;
        float result = instance.getZ();
        assertEquals(expResult, result);

    }

    /**
     * Test of setZ method, of class ChargedParticle.
     */
    @Test
    public void testSetZ_float_1args() {
        System.out.println("setZ");
        float newValue = 0.0F;
        ChargedParticle instance = new ChargedParticle();
        instance.setZ(newValue);

    }

    /**
     * Test of getParticleSize method, of class ChargedParticle.
     */
    @Test
    public void testGetParticleSize() {
        System.out.println("getParticleSize");
        ChargedParticle instance = new ChargedParticle();
        IParticleSize expResult = null;
        IParticleSize result = instance.getParticleSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of setParticleSize method, of class ChargedParticle.
     */
    @Test
    public void testSetParticleSize() {
        System.out.println("setParticleSize");
        IParticleSize ParticleSize = null;
        ChargedParticle instance = new ChargedParticle();
        instance.setParticleSize(ParticleSize);

    }

    /**
     * Test of getCalcName method, of class ChargedParticle.
     */
    @Test
    public void testGetCalcName1() {
        System.out.println("getCalcName");
        ChargedParticle instance = new ChargedParticle();
        String expResult = "particlesim.CalculateCharged";
        String result = instance.getCalcName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParticleSizeName method, of class ChargedParticle.
     */
    @Test
    public void testGetParticleSizeName() {
        System.out.println("getParticleSizeName");
        ChargedParticle instance = new ChargedParticle();
        String expResult = "particlesim.ParticleSizeEllipse";
        String result = instance.getParticleSizeName();
        assertEquals(expResult, result);

    }

}