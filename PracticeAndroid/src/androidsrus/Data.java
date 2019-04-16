package androidsrus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aldana
 */
public class Data 
{
    private final String[] modelOldLine = new String[4];
    private final String[] brain = new String[2];
    private final String[] mobility = new String[2];
    private final String[] vision = new String[2];
    private final String[] arms = new String[2];
    private final String[] mediaCenter = new String[2];
    private final String[] powerPlant = new String[2];

    public Data(){}
    
    //This method is used to generate all the data that will support the system
    public void generateAllData() throws FileNotFoundException, IOException
    {
        //open file
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        //Read lines for lines
        String line;
        while ((line = reader.readLine()) != null) 
        {
            line = reader.readLine();
            String[] firstLine = line.split(",");
            //firstLine = modelOldLine;

            line = reader.readLine();
            String[] brain = line.split(",");
            //secondLine = brain;

            line = reader.readLine();
            String[] mobility = line.split(",");
            ////thirdLine = mobility;

            line = reader.readLine();
            String[] vision = line.split(",");
            //fourthLine = vision;

            line = reader.readLine();
            String[] arms = line.split(",");
            //fifthLine = arms;

            line = reader.readLine();
            String[] mediaCenter = line.split(",");
            //sixthLine = mediaCenter;

            line = reader.readLine();
            String[] powerPlant = line.split(",");
            //seventhLine = powerPlant;
        }
     
    }

    public void generateOldLineModel() throws IOException
    {
        
    }
    public String[] getModelOldLine() {
        return modelOldLine;
    }

    public String[] getBrain() {
        return brain;
    }

    public String[] getMobility() {
        return mobility;
    }

    public String[] getVision() {
        return vision;
    }

    public String[] getArms() {
        return arms;
    }

    public String[] getMediaCenter() {
        return mediaCenter;
    }

    public String[] getPowerPlant() {
        return powerPlant;
    }
 
}
