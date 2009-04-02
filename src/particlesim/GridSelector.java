package particlesim;

/**
 * The purpose of this class is to break a rectangular area into sectors of
 * a given size. It has functions to return random/random-unique sectors from
 * the area supplied.
 * @author Sheppe
 */
public class GridSelector {

    // For persisting values.
    int xA, yA, xS, yS;
    int hSects, vSects;

    // For storing the grid.
    int[][] Grid;

    GridSelector(int widthArea, int heightArea, int widthSector, int heightSector)
    {
        this.xA = widthArea;
        this.yA = heightArea;
        this.xS = widthSector;
        this.yS = heightSector;

        // Determine the number of sectors available horizontally and vertically.
        this.hSects = this.xA / this.xS;
        this.vSects = this.yA / this.yS;

        
    }
}
