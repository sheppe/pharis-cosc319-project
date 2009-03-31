/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import java.awt.Graphics;
import javax.media.opengl.GLAutoDrawable;
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
public class DrawParticlesTest {

    public DrawParticlesTest() {
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
     * Test of doInBackground method, of class DrawParticles.
     */
    @Test
    public void testDoInBackground() throws Exception {
        System.out.println("doInBackground");
        DrawParticles instance = null;
        Void expResult = null;
        Void result = instance.doInBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of process method, of class DrawParticles.
     */
    @Test
    public void testProcess() {
        System.out.println("process");
        Graphics g = null;
        DrawParticles instance = null;
        instance.process(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class DrawParticles.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        GLAutoDrawable drawable = null;
        DrawParticles instance = null;
        instance.init(drawable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of display method, of class DrawParticles.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        GLAutoDrawable drawable = null;
        DrawParticles instance = null;
        instance.display(drawable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reshape method, of class DrawParticles.
     */
    @Test
    public void testReshape() {
        System.out.println("reshape");
        GLAutoDrawable drawable = null;
        int x = 0;
        int y = 0;
        int w = 0;
        int h = 0;
        DrawParticles instance = null;
        instance.reshape(drawable, x, y, w, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayChanged method, of class DrawParticles.
     */
    @Test
    public void testDisplayChanged() {
        System.out.println("displayChanged");
        GLAutoDrawable drawable = null;
        boolean modeChanged = false;
        boolean deviceChanged = false;
        DrawParticles instance = null;
        instance.displayChanged(drawable, modeChanged, deviceChanged);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doInBackground method, of class DrawParticles.
     */
    @Test
    public void testDoInBackground1() throws Exception {
        System.out.println("doInBackground");
        DrawParticles instance = null;
        Void expResult = null;
        Void result = instance.doInBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of process method, of class DrawParticles.
     */
    @Test
    public void testProcess_Graphics() {
        System.out.println("process");
        Graphics g = null;
        DrawParticles instance = null;
        instance.process(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class DrawParticles.
     */
    @Test
    public void testInit_GLAutoDrawable() {
        System.out.println("init");
        GLAutoDrawable drawable = null;
        DrawParticles instance = null;
        instance.init(drawable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of display method, of class DrawParticles.
     */
    @Test
    public void testDisplay_GLAutoDrawable() {
        System.out.println("display");
        GLAutoDrawable drawable = null;
        DrawParticles instance = null;
        instance.display(drawable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reshape method, of class DrawParticles.
     */
    @Test
    public void testReshape_5args() {
        System.out.println("reshape");
        GLAutoDrawable drawable = null;
        int x = 0;
        int y = 0;
        int w = 0;
        int h = 0;
        DrawParticles instance = null;
        instance.reshape(drawable, x, y, w, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayChanged method, of class DrawParticles.
     */
    @Test
    public void testDisplayChanged_3args() {
        System.out.println("displayChanged");
        GLAutoDrawable drawable = null;
        boolean modeChanged = false;
        boolean deviceChanged = false;
        DrawParticles instance = null;
        instance.displayChanged(drawable, modeChanged, deviceChanged);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}