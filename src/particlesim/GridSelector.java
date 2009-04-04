package particlesim;

import java.util.*;

/**
 * The purpose of this class is to break a rectangular area into sectors of
 * a given size. It has functions to return random/random-unique sectors from
 * the area supplied.
 * @author Sheppe
 */
public class GridSelector {

    // For persisting values.
    int xA, yA, xP, yP;
    int hSects, vSects;

    // For storing the grid values. These are used for returning unique values.
    ArrayList GridRows = new ArrayList();
    ArrayList GridCols = new ArrayList();

    // For tracking which positions have been taken.
    ArrayList Tracker;

    GridSelector(int widthArea, int heightArea, int widthParticle, int heightParticle)
    {
        this.xA = widthArea;
        this.yA = heightArea;
        this.xP = widthParticle;
        this.yP = heightParticle;

        // Determine the number of sectors available horizontally and vertically.
        this.hSects = this.xA / this.xP;
        this.vSects = this.yA / this.yP;

        // Initialize the Tracker arraylist.
        this.Tracker = new ArrayList(this.hSects * this.vSects);
        for(int i=1; i<=this.hSects; i++)
        {
            for(int j=1; j<=this.vSects; j++)
            {
                this.Tracker.add(String.valueOf(i) + "," + String.valueOf(j));
            }
        }

        // Throw the rows and columns into the arraylists. We convert them
        // to strings so that the overloaded method doesn't think our integer
        // values are refering to a position in the list as opposed to an
        // actual value in the list.
        for(int row = 1; row <= this.hSects; row++)
        {
            this.GridRows.add(String.valueOf(row));
        }

        for(int col = 1; col <= this.vSects; col++)
        {
            this.GridCols.add(String.valueOf(col));
        }
    }

    public java.awt.Point GetRandomSector()
    {
        Random rand = new Random();
        int r = rand.nextInt(this.hSects) + 1;
        int c = rand.nextInt(this.vSects) + 1;
        
        // Assign the value retrieved from (r * particle width) - (particle width / 2).
        r = (int)(r * this.xP) - (this.xP / 2);
        
        // Assign the value retrieved from (c * particle height) - (particle height / 2).
        c = (int)(c * this.yP) - (this.yP / 2);

        java.awt.Point ret = new java.awt.Point(r,c);

        return ret;
    }

    /**
     * Returns a unique point based on the number of available sectors 
     * in the surface passed to this class's constructor. The number
     * of sectors available is determined by particle sizes and available space.
     * @return A unique point on the grid passed to this class's constructor. Returns NULL when there are no sectors left.
     */
    public java.awt.Point GetRandomUniqueSector()
    {
        try
        {
            // Return null when we are out of positions.
            if(this.Tracker.size() == 0)
            {
                return null;
            }

            Random rand = new Random();

            /* This code is simpler, but performs at about half the speed of 
             * the code below.
            int randIndex = rand.nextInt(this.Tracker.size()-1) +1;
            int r=Integer.parseInt(this.Tracker.get(randIndex).toString().split(",")[0]);
            int c=Integer.parseInt(this.Tracker.get(randIndex).toString().split(",")[1]);
            this.Tracker.remove(randIndex);
            
            // Assign the value retrieved from (c * particle height) - (particle height / 2).
            c = (int)(c * this.yP) - (this.yP / 2);

            // Assign the value retrieved from (r * particle width) - (particle width / 2).
            r = (int)(r * this.xP) - (this.xP / 2);

            java.awt.Point ret = new java.awt.Point(r,c);

            return ret;
            */

            // For indicating when we're found a unique position.
            boolean bFound = false;

            int randIndexR=0;
            int r=0;
            int randIndexC=0;
            int c=0;

            while(!bFound)
            {
                // Select a value from a random position in the arraylist.
                randIndexR = rand.nextInt(this.GridRows.size()-1) +1;
                r = Integer.parseInt(String.valueOf(this.GridRows.get(randIndexR)));

                // Select a value from a random position in the arraylist.
                randIndexC = rand.nextInt(this.GridCols.size()-1) +1;
                c = Integer.parseInt(String.valueOf(this.GridCols.get(randIndexC)));

                // If it hasn't been used, store this unique point in our tracker.
                // If it has been used, find a new position.
                if(this.Tracker.contains(String.valueOf(r) + "," + String.valueOf(c)))
                {
                    this.Tracker.remove(String.valueOf(r) + "," + String.valueOf(c));

                    // Assign the value retrieved from (c * particle height) - (particle height / 2).
                    c = (int)(c * this.yP) - (this.yP / 2);

                    // Assign the value retrieved from (r * particle width) - (particle width / 2).
                    r = (int)(r * this.xP) - (this.xP / 2);

                    // Indicate we've found a point to return.
                    bFound = true;

                    // Run through the arrays and determine if entire rows
                    // or columns are used up. If so, remove them from the
                    // grid options.
                    for(int i=0; i<this.GridRows.size(); i++)
                    {
                        // For storing the state of each column for this row.
                        boolean[] ColFull = new boolean[this.GridCols.size()];

                        for(int j=0; j<this.GridCols.size(); j++)
                        {
                            if(this.Tracker.contains(String.valueOf(this.GridRows.get(i) + "," + this.GridCols.get(j))))
                            {
                                // The tracker shows this as being available,
                                // so exit the loop here.
                                ColFull[j] = false;
                                break;
                            }
                            else
                            {
                                ColFull[j] = true;
                            }
                        }

                        // If each column of the row is full (there are no
                        // entries for them in the tracker) at this point,
                        // remove the row from the list of possibilities.
                        boolean AllColsFull = true;
                        for(int x=0; x<ColFull.length; x++)
                        {
                            if(!ColFull[x])
                            {
                                // Not all columns are full so exit and leave it alone.
                                AllColsFull = false;
                                break;
                            }
                        }
                        if(AllColsFull)
                        {
                            this.GridRows.remove(i);
                            // Decrement the row counter to account for the
                            // removed entry.
                            i--;
                        }
                    }
                }
            }
            java.awt.Point ret = new java.awt.Point(r,c);

            return ret;
        }
        catch(Exception ex)
        {
            java.util.logging.Logger.getLogger(GridSelector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    }
}
