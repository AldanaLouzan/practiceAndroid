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
    String [] brainOld;
    String [] mobilityOld;
    String [] visionOld;
    String [] armsOld;
    String [] mediaCenterOld;
    String [] powerPlantOld;

    public Data(){}
    
//    //This method is used to generate all the data that will support the system
    public void generateAllData() throws FileNotFoundException, IOException
    {
        //open file
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        //Read lines for lines
        String line;
        while ((line = reader.readLine()) != null) 
        {
            modelOld = line.split(",");
 
            line = reader.readLine();
            brainOld = line.split(",");

            line = reader.readLine();
            mobilityOld = line.split(",");

            line = reader.readLine();
            visionOld = line.split(",");

            line = reader.readLine();
            armsOld = line.split(",");

            line = reader.readLine();
            mediaCenterOld = line.split(",");

            line = reader.readLine();
            powerPlantOld = line.split(",");
       }
    }

    public String[] getModelOld() {
        return modelOld;
    }

    public void setModelOld(String[] modelOld) {
        this.modelOld = modelOld;
    }

    public String[] getBrainOld() {
        return brainOld;
    }

    public void setBrainOld(String[] brainOld) {
        this.brainOld = brainOld;
    }

    public String[] getMobilityOld() {
        return mobilityOld;
    }

    public void setMobilityOld(String[] mobilityOld) {
        this.mobilityOld = mobilityOld;
    }

    public String[] getVisionOld() {
        return visionOld;
    }

    public void setVisionOld(String[] visionOld) {
        this.visionOld = visionOld;
    }

    public String[] getArmsOld() {
        return armsOld;
    }

    public void setArmsOld(String[] armsOld) {
        this.armsOld = armsOld;
    }

    public String[] getMediaCenterOld() {
        return mediaCenterOld;
    }

    public void setMediaCenterOld(String[] mediaCenterOld) {
        this.mediaCenterOld = mediaCenterOld;
    }

    public String[] getPowerPlantOld() {
        return powerPlantOld;
    }

    public void setPowerPlantOld(String[] powerPlantOld) {
        this.powerPlantOld = powerPlantOld;
    }
 
}
