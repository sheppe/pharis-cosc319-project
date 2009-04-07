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
public class CharacteristicTest {

    public CharacteristicTest() {
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
     * Test of getCharacteristicType method, of class Characteristic.
     */
    @Test
    public void testGetCharacteristicType() {
        System.out.println("getCharacteristicType");
        Characteristic instance = new Characteristic();
        CharacteristicType expResult = new CharacteristicType();
        CharacteristicType result = instance.getCharacteristicType();
        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of setCharacteristicType method, of class Characteristic.
     */
    @Test
    public void testSetCharacteristicType() {
        System.out.println("setCharacteristicType");
        CharacteristicType newValue = null;
        Characteristic instance = new Characteristic();
        instance.setCharacteristicType(newValue);
    }

    /**
     * Test of getBehaviourModifier method, of class Characteristic.
     */
    @Test
    public void testGetBehaviourModifier() {
        System.out.println("getBehaviourModifier");
        Characteristic instance = new Characteristic();
        float expResult = 0.0F;
        float result = instance.getBehaviourModifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBehaviourModifier method, of class Characteristic.
     */
    @Test
    public void testSetBehaviourModifier() {
        System.out.println("setBehaviourModifier");
        float newValue = 0.0F;
        Characteristic instance = new Characteristic();
        instance.setBehaviourModifier(newValue);
    }

    /**
     * Test of getCharacteristicType method, of class Characteristic.
     */
    @Test
    public void testGetCharacteristicType1() {
        System.out.println("getCharacteristicType");
        Characteristic instance = new Characteristic();
        CharacteristicType expResult = new CharacteristicType();
        CharacteristicType result = instance.getCharacteristicType();
        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of setCharacteristicType method, of class Characteristic.
     */
    @Test
    public void testSetCharacteristicType_CharacteristicType() {
        System.out.println("setCharacteristicType");
        CharacteristicType newValue = null;
        Characteristic instance = new Characteristic();
        instance.setCharacteristicType(newValue);
    }

    /**
     * Test of getBehaviourModifier method, of class Characteristic.
     */
    @Test
    public void testGetBehaviourModifier1() {
        System.out.println("getBehaviourModifier");
        Characteristic instance = new Characteristic();
        float expResult = 0.0F;
        float result = instance.getBehaviourModifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBehaviourModifier method, of class Characteristic.
     */
    @Test
    public void testSetBehaviourModifier_float() {
        System.out.println("setBehaviourModifier");
        float newValue = 0.0F;
        Characteristic instance = new Characteristic();
        instance.setBehaviourModifier(newValue);
    }

    /**
     * Test of getCharacteristicType method, of class Characteristic.
     */
    @Test
    public void testGetCharacteristicType2() {
        System.out.println("getCharacteristicType");
        Characteristic instance = new Characteristic();
        CharacteristicType expResult = new CharacteristicType();
        CharacteristicType result = instance.getCharacteristicType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCharacteristicType method, of class Characteristic.
     */
    @Test
    public void testSetCharacteristicType_CharacteristicType_1args() {
        System.out.println("setCharacteristicType");
        CharacteristicType newValue = null;
        Characteristic instance = new Characteristic();
        instance.setCharacteristicType(newValue);
    }

    /**
     * Test of getBehaviourModifier method, of class Characteristic.
     */
    @Test
    public void testGetBehaviourModifier2() {
        System.out.println("getBehaviourModifier");
        Characteristic instance = new Characteristic();
        float expResult = 0.0F;
        float result = instance.getBehaviourModifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBehaviourModifier method, of class Characteristic.
     */
    @Test
    public void testSetBehaviourModifier_float_1args() {
        System.out.println("setBehaviourModifier");
        float newValue = 0.0F;
        Characteristic instance = new Characteristic();
        instance.setBehaviourModifier(newValue);
    }

}