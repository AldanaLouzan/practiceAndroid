package androidsrus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author aldana
 */
public class Data 
{
    //I will store the data in Arrays 
    String [] modelOld;
    String [] modelNew;    
    String [] brain;
    String [] mobility;
    String [] vision;
    String [] arms;
    String [] mediaCenter;
    String [] powerPlant;
    String [] parts; //I will use to keep track of the donation of the different parts
    

    public Data(){}
    
//    //This method is used to get all the data from a text file, that will support the system
    public void getAllData() throws FileNotFoundException, IOException
    {
        //Open file
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        //Read lines for lines
        String line;
        //Store the data in Arrays 
        while ((line = reader.readLine()) != null) 
        {
            modelOld = line.split(",");
            
            line = reader.readLine();
            modelNew = line.split(",");
 
            line = reader.readLine();
            brain = line.split(",");

            line = reader.readLine();
            mobility = line.split(",");

            line = reader.readLine();
            vision = line.split(",");

            line = reader.readLine();
            arms = line.split(",");

            line = reader.readLine();
            mediaCenter = line.split(",");

            line = reader.readLine();
            powerPlant = line.split(",");
            
            line = reader.readLine();
            parts = line.split(",");
       }
    }
//As this class is only to get data from a file, I dont need setters
    public String[] getModelOld() {
        return modelOld;
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

    public String[] getModelNew() {
        return modelNew;
    }

    public String[] getParts() {
        return parts;
    }

}
