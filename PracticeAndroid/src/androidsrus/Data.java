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
    String [] modelOld;
    String [] modelNew;    
    String [] brain;
    String [] mobility;
    String [] vision;
    String [] arms;
    String [] mediaCenter;
    String [] powerPlant;
    String [] parts;
    

    public Data(){}
    
//    //This method is used to generate all the data that will support the system
    public void getAllData() throws FileNotFoundException, IOException
    {
        //open file
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        //Read lines for lines
        String line;
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

    public String[] getModelOld() {
        return modelOld;
    }

    public void setModelOld(String[] modelOld) {
        this.modelOld = modelOld;
    }

    public String[] getBrain() {
        return brain;
    }

    public void setBrain(String[] brainOld) {
        this.brain = brainOld;
    }

    public String[] getMobility() {
        return mobility;
    }

    public void setMobility(String[] mobility) {
        this.mobility = mobility;
    }

    public String[] getVision() {
        return vision;
    }

    public void setVision(String[] vision) {
        this.vision = vision;
    }

    public String[] getArms() {
        return arms;
    }

    public void setArms(String[] arms) {
        this.arms = arms;
    }

    public String[] getMediaCenter() {
        return mediaCenter;
    }

    public void setMediaCenter(String[] mediaCenter) {
        this.mediaCenter = mediaCenter;
    }

    public String[] getPowerPlant() {
        return powerPlant;
    }

    public void setPowerPlant(String[] powerPlant) {
        this.powerPlant = powerPlant;
    }

    public void setModelNew(String[] modelNew) {
        this.modelNew = modelNew;
    }

    public String[] getModelNew() {
        return modelNew;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }
    
 
}
