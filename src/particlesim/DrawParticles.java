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
import java.lang.Math;

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

    // Used for logging particle data.
    private ParticleLogger log = new ParticleLogger();
    // Use to indicate whether or not to log the data.
    private boolean doLog = false;

    // GL object that performs rendering.
    private GL gl;

    /**
     * Constructs the worker thread that handles running the calculations and
     * logging the data in a separate thread.
     * @param GraphicsPanel An instance of a GLCanvas to draw the particles on.
     * @param Particles The array of particles to draw and run calculations on.
     * @param DoLog Indicates whether to log the data or not.
     */
    DrawParticles(javax.media.opengl.GLCanvas GraphicsPanel, IParticle[] Particles, boolean DoLog)
    {
        this.GraphicsPanel = GraphicsPanel;
        this.parts = Particles;
        this.doLog = DoLog;

        // Set this class up for drawing to the canvas.
        this.GraphicsPanel.addGLEventListener(this);
    }

    /**
     * Draws each particle in the class level parts array.
     * @param gl
     */
    private void drawParticle() {
        // Call the functions to calculate particle forces and movements.
        GLUT glut = new GLUT();

        /* The following line is what causes the calculations to take place. */
        parts = cc.MoveParticles(cc.CalculateIteration(parts));

        // Log the data for this iteration.
        if(this.doLog)
        {
            // TODO Replace the 0 in the TimeStep parameter with an actual value, once we have one.
            this.log.Log(0, parts);
        }

        // Convert the array to a list to ease parsing it.
        List<IParticle> lParticles = Arrays.asList(parts);

        // A simple counter.
        int i = 0;

        for(IParticle p1 : lParticles)
        {
            if(i % 2 == 0)
            {
                this.gl.glColor3f(1, 0, 0);
            }
            else
            {
                this.gl.glColor3f(0, 0, 1);
            }

            i++;

            // Draw a sphere to represent the particle.
            this.gl.glPushMatrix();

            this.ellipseMidpoint((int)p1.getX(), (int)p1.getY(), (int)p1.getParticleSize().getParticleSizeX(), (int)p1.getParticleSize().getParticleSizeY());
            this.gl.glPopMatrix();
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
        this.gl = drawable.getGL();
        this.gl.glClearColor(0.0f, 0.1f, 0.1f, 0.0f);
    }

    /**
     * Implementation of interface method.
     * @param drawable
     */
    public void display(GLAutoDrawable drawable) {
        this.gl = drawable.getGL();
        this.gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        drawParticle();
        this.gl.glFlush();
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
        final GL gl = drawable.getGL();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, w, h);

        /*if (w <= (h * 2)) //
    gl.glOrtho(-6.0, 6.0, -3.0 * ((float) h * 2) / (float) w, //
        3.0 * ((float) h * 2) / (float) w, -10.0, 10.0);
    else gl.glOrtho(-6.0 * (float) w / ((float) h * 2), //
        6.0 * (float) w / ((float) h * 2), -3.0, 3.0, -10.0, 10.0);*/

        gl.glMatrixMode(GL.GL_PROJECTION);// | GL.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glOrtho(0.0, (float)w, (float)h, 0.0, 0.0, 10000.0);

    }

    /**
     * Implementation of interface method.
     * @param drawable
     * @param modeChanged
     * @param deviceChanged
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        // Do nothing.
    }

    void setPixel (double x, double y)
    {
        gl.glBegin (GL.GL_POINTS);
        gl.glVertex2d (x, y);
        gl.glEnd( );
    }


    void ellipseMidpoint (int xCenter, int yCenter, int Rx, int Ry)
    {
        int Rx2 = Rx * Rx;
        int Ry2 = Ry * Ry;
        int twoRx2 = 2 * Rx2;
        int twoRy2 = 2 * Ry2;
        int p;
        int x = 0;
        int y = Ry;
        int px = 0;     // Initial value of midpoint parameter.
        int py = twoRx2 * y;


        /* Plot the initial point in each Ellipse quadrant. */
        ellipsePlotPoints (xCenter, yCenter, x, y);

        /* Region 1 */
        p = Math.round ((int) (Ry2 - (Rx2 * Ry) + (0.25 * Rx2)));
        while (px < py)
        {
            x = x+1;
            px = px + twoRy2;
            if (p < 0)
            {
                p = p + Ry2 + px;
            }
            else
            {
                y = y-1;
                py = py-twoRx2;
                p = p + Ry2 + px - py;
            }
            ellipsePlotPoints (xCenter, yCenter, x, y);
        }

        /* Region 2 */
        p = Math.round ((int) (Ry2 * (x+0.5) * (x+0.5) + Rx2 * (y-1) * (y-1) - Rx2 * Ry2));
        while (y > 0)
        {
            y = y-1;
            py = py - twoRx2;
            if (p > 0)
            {
                p = p + Rx2 - py;
            }
            else
            {
                x = x + 1;
                px = px + twoRy2;
                p = p + Rx2 - py + px;
            }
            ellipsePlotPoints (xCenter, yCenter, x, y);
        }
    }

    void ellipsePlotPoints (int xCenter, int yCenter, int x, int y)
    {
        setPixel (xCenter + x, yCenter + y);
        setPixel (xCenter - x, yCenter + y);
        setPixel (xCenter + x, yCenter - y);
        setPixel (xCenter - x, yCenter - y);
    }

    /*
    void DrawCircle(float cx, float cy, float r, int num_segments)
    {
        double theta = 2 * 3.1415926 / num_segments;
        double tangetial_factor = java.lang.Math.tan(theta);//calculate the tangential factor

        double radial_factor = java.lang.Math.cos(theta);//calculate the radial factor

        float x = r;//we start at angle = 0

        float y = 0;

        this.gl.glBegin(GL.GL_LINE_LOOP);
        for(int ii = 0; ii < num_segments; ii++)
        {
            this.gl.glVertex2f(x + cx, y + cy);//output vertex

            //calculate the tangential vector
            //remember, the radial vector is (x, y)
            //to get the tangential vector we flip those coordinates and negate one of them

            float tx = -y;
            float ty = x;

            //add the tangential vector

            x += tx * tangetial_factor;
            y += ty * tangetial_factor;

            //correct using the radial factor

            x *= radial_factor;
            y *= radial_factor;
        }
        this.gl.glEnd();
    }

    int GetNumCircleSegments(float r)
    {
        return (int)(2.0f * 3.1415926f / (java.lang.Math.acos(1 - 0.25 / r)));//change the 0.25 to a smaller/bigger number as needed
    }
    */
}