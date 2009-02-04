/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package particlesim;

import java.awt.*;
import java.awt.image.*;

/**
 *
 * @author Sheppe
 */
public class BufferedPanel extends javax.swing.JPanel {

    BufferedImage bi = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
    Graphics2D big;
    boolean firstTime = true;

    public BufferedPanel()
    {
        setBackground(Color.white);
    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w=0; int h=0;
        if (firstTime) {
            Dimension dim = getSize();
            w = dim.width;
            h = dim.height;
            bi = (BufferedImage) createImage(w, h);
            big = bi.createGraphics();
            firstTime=false;
        }
        
        big.setColor(Color.white);
        big.clearRect(0, 0, w, h);
        g2.drawImage(bi, 0, 0, this);
    }

    public void fillOval(int x, int y, int width, int height, Color c)
    {
        big.setPaint(c);
        big.fillOval(x, y, 25, 25);
        repaint();
    }
}
