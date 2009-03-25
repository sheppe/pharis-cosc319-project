package particlesim;
import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used for persisting simple particle data to disk. At the
 * time of this writing, the only data required to be logged is the time-
 * step, and each particle's location in space (x,y,z).
 * @author Sheppe
 */
public class ParticleLogger
{
    private String logFileName = "";

    /**
     * The default constructor. Creates a unique file name for the log file.
     */
    ParticleLogger()
    {
        // If the file name to use has not been set, create a unique file name.
        if(this.logFileName.equals(""))
        {
            // This application is intended to be run on a single machine, so
            // just create a file using the current time as a seed, and
            // place it in the application's folder.

            // The string to prefix our file name with.
            String fPrefix = "psim";

            // The extension for our file.
            String fExt = ".psl";

            // The unique middle part of the name.
            String fName = String.valueOf(new Date().getTime());

            String curDir = System.getProperty("user.dir");
            File dir = new File(curDir);
            File logFile = new File(dir + "\\" + fPrefix + fName + fExt);

            this.logFileName = logFile.toString();

        }
    }

    /**
     * Allows you to create this class and indicate what file name to use
     * for logging the particle data to.
     * @param FileName The file name to use. Include the full path and file name.
     */
    ParticleLogger(String FileName)
    {
        this.logFileName = FileName;
    }

    /**
     * Logs the data for the given particle array. 
     * @param TimeStep The time-step used to calculate the particle positions.
     * @param Particles The array of particles to log the position data for.
     */
    public void Log(int TimeStep, IParticle[] Particles)
    {
        BufferedWriter out = null;

        try
        {
            // Create/open the file.
            FileWriter fstream = new FileWriter(this.logFileName, true);
            out = new BufferedWriter(fstream);
            
            // Record to time-step and particle information.
            out.append("Time-step:" + String.valueOf(TimeStep));
            out.newLine();
            for(IParticle p : Particles)
            {
                out.append(p.getX() + "," + p.getY() + "," + p.getZ());
            }
            out.newLine();
            
            // Close the output stream.
            out.close();
        }
        catch (Exception e)
        {
            // Catch exception.
                    Logger.getLogger(ParticleLogger.class.getName()).log(Level.SEVERE, null, e);

            // Close the output stream if it's open.
            if(out != null)
            {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ParticleLogger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        finally
        {
        }
    }
}
