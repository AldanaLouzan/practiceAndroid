package androidsrus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author aldana
 */
public class SetUp 
{
    //I use the random object to create to set the model,mobility,vision,arms,mediaCenter
    Random rG = new Random();
    ArrayList IDUsed = new ArrayList();
    Data d = new Data();
            
    public Android fill (Android a, Data d)
    {
        if (a.getModel() == null) 
        {
            a.setModel(d.getModelOld()[rG.nextInt(d.getModelOld().length)]);
        }
        
        if (a.getSerialNum() == null) 
        {
            int mkSerialNum;
            mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
            boolean temp = this.checkID(IDUsed, mkSerialNum);

            while (temp == true) {
                mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
                temp = this.checkID(IDUsed, mkSerialNum);
            }
            if (temp == false) {
                a.setSerialNum(String.valueOf(mkSerialNum));
                IDUsed.add(mkSerialNum);
            }
        }
  
        //To assign the Brain: mk1 has brain 2.5GHZ, mk2 3.5GHZ the rest 4.5GHZ 
        if (a.getBrain() == null) 
        {
            a.setBrain(d.getBrainOld()[rG.nextInt(d.getBrainOld().length)]);
        }
        
        if (a.getMobility()== null) 
        {
            a.setMobility(d.getMobilityOld()[rG.nextInt(d.getMobilityOld().length)]);
        }
        
        if (a.getVision() == null) 
        {
            a.setVision(d.getVisionOld()[rG.nextInt(d.getVisionOld().length)]);
        }
        
        if (a.getArms() == null) 
        {
            a.setArms(d.getArmsOld()[rG.nextInt(d.getArmsOld().length)]);
        }
        
        if (a.getMediaCenter()== null) 
        {
            a.setMediaCenter(d.getMediaCenterOld()[rG.nextInt(d.getMediaCenterOld().length)]);
        }
        
        if (a.getPowerPlant()== null) 
        {
            a.setPowerPlant(d.getPowerPlantOld()[rG.nextInt(d.getPowerPlantOld().length)]);
        }    
        return a;
                
    }
    
    public  ArrayList<Android> androidsCreation() throws IOException
    {
        int numberCurrentLineCreation = 300;
        ArrayList<Android> listCurrentLine = new ArrayList();
        d.generateAllData();
        
        //Creation of 30 androids  
        for (int i = 0; i < numberCurrentLineCreation; i++) 
        {
            Android mk = new Android();
            this.fill(mk,d);
            
            listCurrentLine.add(mk);
            System.out.println(mk.toString());
        }
        return listCurrentLine;
        
    } 
    
    public int generateRandomSerialNum(int min, int max) 
    {
        Random r = new Random();
        int serialNum = r.nextInt((max - min) + 1) + min;
        return serialNum;
    }
    
    public boolean checkID (ArrayList listID, int ID )
    {
        boolean value = false;
        for(int i=0; i<listID.size();i++)
        {
            if (listID.get(i).equals(ID))
                {
                    value = true;
                }
                      
        }    
        return value;
       
                
    }
}
