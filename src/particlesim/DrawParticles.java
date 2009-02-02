/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Sheppe
 */
public class DrawParticles extends SwingWorker<Void, Graphics> {
    

    public Graphics drawingSurface;
    public IParticle[] parts;
    javax.swing.JPanel GraphicsPanel;

    DrawParticles(javax.swing.JPanel GraphicsPanel, IParticle[] Particles)
    {
        this.GraphicsPanel = GraphicsPanel;
        this.drawingSurface = GraphicsPanel.getGraphics();
        this.parts = Particles;
    }

    @Override
    protected Void doInBackground() throws Exception {
        Graphics ds = drawingSurface.create();

        CalculateCharged cc = new CalculateCharged();

        while(!this.isCancelled())
        {
            // Call the functions to calculate particle forces and movements.
            parts = cc.MoveParticles(cc.CalculateIteration(parts));

            // Convert the array to a list to ease parsing it.
            List<IParticle> lParticles = Arrays.asList(parts);

            // A simple counter.
            int i = 0;

            for(IParticle p1 : lParticles)
            {
                if(i % 2 == 0)
                    ds.setColor(Color.BLUE);
                else
                    ds.setColor(Color.RED);

                i++;
                
                ds.fillOval((int)p1.getX(), (int)p1.getY(), 25, 25);
            }
            publish(ds);
            this.GraphicsPanel.repaint();
        }
        
        return null;
    }

    protected void process(Graphics g)
    {
        drawingSurface = g;
    }
}

