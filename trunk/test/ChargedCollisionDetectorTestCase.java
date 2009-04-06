import junit.framework.TestCase;
import particlesim.Characteristic;
import particlesim.CharacteristicType;
import particlesim.ChargedCollisionDetector;
import particlesim.ChargedParticle;
import particlesim.ParticleSizeEllipse;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuehan
 */
public class ChargedCollisionDetectorTestCase extends TestCase{
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

    public void testcheckParticleCollision(){
        this.init();

        boolean result = ccd.checkParticleCollision(p1, p2);
        ChargedCollisionDetectorTestCase.assertTrue(result);

         boolean result2 = ccd.checkParticleCollision(p1, p3);
        ChargedCollisionDetectorTestCase.assertFalse(result2);
    }

    public void testcheckBounderyCollision(){
        this.init();

        boolean result1 = ccd.checkBounderyCollision(p3);
        ChargedCollisionDetectorTestCase.assertTrue(result1);

        boolean result2 = ccd.checkBounderyCollision(p1);
        ChargedCollisionDetectorTestCase.assertFalse(result2);
    }

    public void testupdateParticleColliedParticle(){
        this.init();
        ChargedParticle[] cpArr = {p1,p2};
        ChargedParticle[] updatedcpArr = (ChargedParticle[]) ccd.updateParticleColliedParticle(cpArr);
        ChargedParticle upp1 = updatedcpArr[0];
        ChargedParticle upp2 = updatedcpArr[1];
        boolean trueResult = false;
        boolean falseResult = false;

        float answerX1 = -0.5f;
        float answerY1 = -0.5f;

        float answerX2 = -0.6f;
        float answerY2 = -0.6f;

        float resultX1 = upp1.getCharacteristic()[1].getBehaviourModifier();
        float resultY1 = upp1.getCharacteristic()[2].getBehaviourModifier();

        float resultX2 = upp2.getCharacteristic()[1].getBehaviourModifier();
        float resultY2 = upp2.getCharacteristic()[2].getBehaviourModifier();

        if(answerX1 == resultX1 && answerX2 == resultX2 && answerY1 == resultY1 && answerY2 == resultY2){
            trueResult = true;
        }
        if(answerX1 == resultX1 && answerX2 == resultX2 && answerY1 == resultY1 && answerY2 == resultY2){
            falseResult = true;
        }

        ChargedCollisionDetectorTestCase.assertTrue(trueResult);
        ChargedCollisionDetectorTestCase.assertTrue(falseResult);
    }

     public void testupdateBoundaryColliedParticle(){
        this.init();
        ChargedParticle[] cpArr = {p1};
        ChargedParticle[] updatedcpArr = (ChargedParticle[]) ccd.updateParticleColliedParticle(cpArr);
        ChargedParticle upp1 = updatedcpArr[0];
        boolean trueResult = false;
        boolean falseResult = false;

        float answerX1 = -0.5f;
        float answerY1 = -0.5f;

        float resultX1 = upp1.getCharacteristic()[1].getBehaviourModifier();
        float resultY1 = upp1.getCharacteristic()[2].getBehaviourModifier();

        if(answerX1 == resultX1 && answerY1 == resultY1){
            trueResult = true;
        }
        if(answerX1 == resultX1 && answerY1 == resultY1){
            falseResult = true;
        }

        ChargedCollisionDetectorTestCase.assertTrue(trueResult);
        ChargedCollisionDetectorTestCase.assertTrue(falseResult);
    }
}
