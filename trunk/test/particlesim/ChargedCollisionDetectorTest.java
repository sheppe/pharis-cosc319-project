package particlesim;

import junit.framework.TestCase;
import particlesim.Characteristic;
import particlesim.CharacteristicType;
import particlesim.ChargedCollisionDetector;
import particlesim.ChargedParticle;
import particlesim.ParticleSizeEllipse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This Testcase also can be used as a testcase for ElecFieldCollisiondetector class,
 * it just needs to be add some more characteristic and do a little bit modifier. Therefore there is no need to
 * implement testcase for ElecFieldCollisiondetector class.
 * @author Yuehan
 */
public class ChargedCollisionDetectorTest extends TestCase{
    ChargedParticle p1;
    ChargedParticle p2;
    ChargedParticle p3;
    ChargedCollisionDetector ccd;
    ParticleSizeEllipse p1size = new ParticleSizeEllipse();
    ParticleSizeEllipse p2size = new ParticleSizeEllipse();
    ParticleSizeEllipse p3size = new ParticleSizeEllipse();

    Characteristic p1c0 = new Characteristic();
    Characteristic p1c1 = new Characteristic();
    Characteristic p1c2 = new Characteristic();

    Characteristic p2c0 = new Characteristic();
    Characteristic p2c1 = new Characteristic();
    Characteristic p2c2 = new Characteristic();

    Characteristic p3c0 = new Characteristic();
    Characteristic p3c1 = new Characteristic();
    Characteristic p3c2 = new Characteristic();

    CharacteristicType ct0 = new CharacteristicType();
    CharacteristicType ct1 = new CharacteristicType();
    CharacteristicType ct2 = new CharacteristicType();

/**
 * create three particles and provide properties and charateristic, so we can use them later.
 */
    public void init() {
        this.ccd = new ChargedCollisionDetector(100,100);
        p1 = new ChargedParticle();
        p2 = new ChargedParticle();
        p3 = new ChargedParticle();

        //fill in particle size
        p1size.setParticleSizeX(10);
        p1size.setParticleSizeY(10);
        p1.setParticleSize(p1size);

        p2size.setParticleSizeX(10);
        p2size.setParticleSizeY(10);
        p2.setParticleSize(p2size);

        p3size.setParticleSizeX(10);
        p3size.setParticleSizeY(10);
        p3.setParticleSize(p3size);

        //fill in particle position for p1 and p2
        p1.setX(30.0f);
        p1.setY(30.0f);

        p2.setX(36.0f);
        p2.setY(36.0f);

        p3.setX(4.9f);
        p3.setY(6.1f);

        //fill in characterstic for p1 and p2
        ct0.setName("Charge");
        ct0.setDescription("force on particle");

        ct1.setName("forceX");
        ct1.setDescription("force on X");

        ct2.setName("forceY");
        ct2.setDescription("forece ono Y");

        p1c0.setCharacteristicType(ct0);
        p1c0.setBehaviourModifier(1.0f);

        p1c1.setCharacteristicType(ct1);
        p1c1.setBehaviourModifier(0.5f);

        p1c2.setCharacteristicType(ct2);
        p1c2.setBehaviourModifier(0.5f);

        p2c0.setCharacteristicType(ct0);
        p2c0.setBehaviourModifier(1.0f);

        p2c1.setCharacteristicType(ct1);
        p2c1.setBehaviourModifier(0.6f);

        p2c2.setCharacteristicType(ct2);
        p2c2.setBehaviourModifier(0.6f);

        p3c0.setCharacteristicType(ct0);
        p3c0.setBehaviourModifier(1.0f);

        p3c1.setCharacteristicType(ct1);
        p3c1.setBehaviourModifier(0.6f);

        p3c2.setCharacteristicType(ct2);
        p3c2.setBehaviourModifier(0.6f);


        Characteristic[] p1Array = {p1c0,p1c1,p1c2};
        Characteristic[] p2Array = {p2c0,p2c1,p2c2};
        Characteristic[] p3Array = {p3c0,p3c1,p3c2};

        p1.setCharacteristic(p1Array);
        p2.setCharacteristic(p2Array);
        p3.setCharacteristic(p3Array);

    }

    /**
     * test checkParticleCollision() method.
     */
    public void testcheckParticleCollision(){
        this.init();

        boolean result = ccd.checkParticleCollision(p1, p2);
        ChargedCollisionDetectorTest.assertTrue(result);

         boolean result2 = ccd.checkParticleCollision(p1, p3);
        ChargedCollisionDetectorTest.assertFalse(result2);
    }

    /**
     * test checkBounderyCollision() method.
     */
    public void testcheckBounderyCollision(){
        this.init();

        boolean result1 = ccd.checkBounderyCollision(p3);
        ChargedCollisionDetectorTest.assertTrue(result1);

        boolean result2 = ccd.checkBounderyCollision(p1);
        ChargedCollisionDetectorTest.assertFalse(result2);
    }

    /**
     * test updateParticleColliedParticle() method.
     */
    public void testupdateParticleColliedParticle(){
        this.init();
        ChargedParticle[] cpArr = {p1,p2};
        
        float resultX1 = cpArr[0].getCharacteristic()[1].getBehaviourModifier();
        float resultY1 = cpArr[0].getCharacteristic()[2].getBehaviourModifier();
        System.out.println("resultX is "+ resultX1 + "resultY is " + resultY1);

        ChargedParticle[] updatedcpArr = (ChargedParticle[]) ccd.updateParticleColliedParticle(cpArr);

        ChargedParticle upp1 = updatedcpArr[0];
        boolean trueResult = false;
        boolean falseResult = false;

        float answerX1 = 100*0.5f;
        float answerY1 = 100*0.5f;

         resultX1 = upp1.getCharacteristic()[1].getBehaviourModifier();
         resultY1 = upp1.getCharacteristic()[2].getBehaviourModifier();

       
        if(answerX1 == resultX1 && answerY1 == resultY1){
            trueResult = true;
        }

        if(answerX1 != resultX1 && answerY1 != resultY1 ){
            falseResult = true;
        }

        System.out.println("resultX is "+ resultX1 + "resultY is " + resultY1);
        System.out.println("expect resultX is "+ answerX1 + "expect resultY is " + answerY1);

        ChargedCollisionDetectorTest.assertTrue(trueResult);
        ChargedCollisionDetectorTest.assertFalse(falseResult);
    }

    /**
     * test updateBoundaryColliedParticle() method.
     */
     public void testupdateBoundaryColliedParticle(){
        this.init();
        ChargedParticle[] cpArr = {p1};
        ChargedParticle[] updatedcpArr = (ChargedParticle[]) ccd.updateParticleColliedParticle(cpArr);
        ChargedParticle upp1 = updatedcpArr[0];
        boolean trueResult = false;
        boolean falseResult = false;

        float answerX1 = 10*-0.5f;
        float answerY1 = 10*-0.5f;

        float resultX1 = upp1.getCharacteristic()[1].getBehaviourModifier();
        float resultY1 = upp1.getCharacteristic()[2].getBehaviourModifier();

        if(answerX1 == resultX1 && answerY1 == resultY1){
            trueResult = true;
        }
        if(answerX1 != resultX1 && answerY1 != resultY1){
            falseResult = true;
        }
        
        ChargedCollisionDetectorTest.assertTrue(trueResult);
        ChargedCollisionDetectorTest.assertFalse(falseResult);

    }
}
