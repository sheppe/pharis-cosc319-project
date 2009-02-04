/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingworker.SwingWorker;

/**
 *
 * @author Sheppe
 */
public class DrawParticles extends SwingWorker<Void, Graphics> {
    

    public IParticle[] parts;
    BufferedPanel GraphicsPanel;

    DrawParticles(BufferedPanel GraphicsPanel, IParticle[] Particles)
    {
        this.GraphicsPanel = GraphicsPanel;
        this.parts = Particles;
    }

    @Override
    protected Void doInBackground() throws Exception {
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
                    GraphicsPanel.fillOval((int)p1.getX(), (int)p1.getY(), 25, 25, Color.BLUE);
                else
                    GraphicsPanel.fillOval((int)p1.getX(), (int)p1.getY(), 25, 25, Color.RED);

                i++;
                
            }
            //publish(ds);
            //ds.clearRect(0, 0, this.GraphicsPanel.getWidth(), this.GraphicsPanel.getHeight());
        }
        
        return null;
    }

    protected void process(Graphics g)
    {
        //this.drawingSurface = g;
    }
}

