package particlesim;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingworker.SwingWorker;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import java.util.Calendar;
import java.util.Date;

/**
 * This class handles drawing an array of IParticle onto the GL panel. It
 * extends the SwingWorker class in order to do all of the work in a seperate
 * thread; this prevent the interface from locking up.
 * @author Sheppe
 */
public class DrawParticles extends SwingWorker<Void, Graphics> implements GLEventListener {
    // Publicly accessible variables. Used for passing particle arrays and graphical
    // elements to this class for updating.
    
    /**
     * An array of particles to draw/run calculations on.
     */
    public IParticle[] parts;
    /**
     * A GLCanvas to draw the particles on.
     */
    public javax.media.opengl.GLCanvas GraphicsPanel;
    /**
     * A JLabel for tracking FPS on.
     */
    public javax.swing.JLabel FpsLabel;

    private CalculateCharged cc = new CalculateCharged();
    final Animator animator = new Animator(this.GraphicsPanel);

    DrawParticles(javax.media.opengl.GLCanvas GraphicsPanel, IParticle[] Particles)
    {
        this.GraphicsPanel = GraphicsPanel;
        this.parts = Particles;

        this.GraphicsPanel.addGLEventListener(this);
    }

    /**
     * Draws each particle in the class level parts array.
     * @param gl
     */
    private void drawParticle(GL gl) {
        // Call the functions to calculate particle forces and movements.
        GLUT glut = new GLUT();

        parts = cc.MoveParticles(cc.CalculateIteration(parts));

        float no_mat[] = { 0.0f, 0.0f, 0.0f, 1.0f };
        float mat_ambient[] = { 0.7f, 0.7f, 0.7f, 1.0f };
        float mat_ambient_color[] = { 0.8f, 0.8f, 0.2f, 1.0f };
        float mat_diffuse[] = { 0.1f, 0.5f, 0.8f, 1.0f };
        float mat_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
        float no_shininess[] = { 0.0f };
        float low_shininess[] = { 5.0f };
        float high_shininess[] = { 100.0f };
        float mat_emission[] = { 0.3f, 0.2f, 0.2f, 0.0f };

        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(parts);

        // A simple counter.
        int i = 0;

        for(IParticle p1 : lParticles)
        {
            if(i % 2 == 0)
            {
                gl.glColor3f(1, 0, 0);
            }
            else
            {
                gl.glColor3f(0, 0, 1);
            }

            i++;

            // Draw a sphere to represent the particle.
            gl.glPushMatrix();
            gl.glTranslatef(p1.getX(), p1.getY(), p1.getZ());
            glut.glutSolidSphere(10.0, 20, 20);
            gl.glPopMatrix();
            if(this.isCancelled()) {
                animator.stop();
            }
        }
    }

    /**
     * This function executes the instructions within in a new thread.
     * @return
     * @throws java.lang.Exception
     */
    @Override
    protected Void doInBackground() throws Exception {
        animator.start();
        int iFps = 0;

        // For tracking FPS.
        Date dStart = new Date();
        long iDiff=0;
        
        while(!this.isCancelled())
        {
            // Start the OpenGl panel display routine.
            this.GraphicsPanel.display();

            // Increment FPS counter.
            iFps++;

            // When a second passes, update the FPS label with the FPS counted.
            Date dCount = new Date();
            iDiff = dCount.getTime() - dStart.getTime();
            if(iDiff >= 1000)
            {
                this.FpsLabel.setText("FPS: " + String.valueOf(iFps));
                iFps=0;
                dStart = new Date();
            }

        }
        animator.stop();
        
        return null;
    }

    /**
     * Called after each iteration of doInBackground.
     * @param g
     */
    protected void process(Graphics g)
    {}

    /**
     * Implementation of interface method.
     * @param drawable
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.0f, 0.1f, 0.1f, 0.0f);
    }

    /**
     * Implementation of interface method.
     * @param drawable
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        drawParticle(gl);
        gl.glFlush();
    }

    /**
     * Implementation of interface method.
     * @param drawable
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL gl = drawable.getGL();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, w, h);
        gl.glOrtho(0.0, (float)w, (float)h, 0.0, 0.0, 10000.0);

        /*if (w <= (h * 2)) //
    gl.glOrtho(-6.0, 6.0, -3.0 * ((float) h * 2) / (float) w, //
        3.0 * ((float) h * 2) / (float) w, -10.0, 10.0);
    else gl.glOrtho(-6.0 * (float) w / ((float) h * 2), //
        6.0 * (float) w / ((float) h * 2), -3.0, 3.0, -10.0, 10.0);*/

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();


    }

    /**
     * Implementation of interface method.
     * @param drawable
     * @param modeChanged
     * @param deviceChanged
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

