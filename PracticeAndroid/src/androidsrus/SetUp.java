package androidsrus;

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
    
    
    String [] model = {"Android mk1","Android mk2","Android mk3","Android mk4","Android mk5"};
    String [] brain = {"2.5GHZ","3.5GHZ","4.5GHZ"};
    String [] mobility = {"catapilar tracks","wheels","legs"};
    String [] vision = {"heat vision","full colour","night vision"};
    String [] arms = {"claws","grippers","articulated fingers"};
    String [] mediaCenter  = {"sony","jvc","meridian"};
    String [] powerPlant = {"lithium","hydrogen","plasma"};
        
    public Androids fill (Androids a)
    {
        if (a.getModel() == null) 
        {
            a.setModel(model[rG.nextInt(model.length)]);
        }
        
        if (a.getSerialNum()== null)
        {
            
            if(a.getModel().equals(model[0]))
            {
                int mk1SerialNum;
                mk1SerialNum = this.generateRandomSerialNum(1000,1999); 
                
                a.setSerialNum(String.valueOf(mk1SerialNum));
            }
            if(a.getModel().equals(model[1]))
            {
                int mk2SerialNum;
                mk2SerialNum = this.generateRandomSerialNum(2000,2999); 
                
                a.setSerialNum(String.valueOf(mk2SerialNum));
            } 
            if(a.getModel().equals(model[2]))
            {
                int mk3SerialNum;
                mk3SerialNum = this.generateRandomSerialNum(3000,3999); 
                
                a.setSerialNum(String.valueOf(mk3SerialNum));
            }
            if(a.getModel().equals(model[3]))
            {
                int mk4SerialNum;
                mk4SerialNum = this.generateRandomSerialNum(4000,4999); 
                
                a.setSerialNum(String.valueOf(mk4SerialNum));
            }
            if(a.getModel().equals(model[4]))
            {
                int mk5SerialNum;
                mk5SerialNum = this.generateRandomSerialNum(5000,5999); 
                
                a.setSerialNum(String.valueOf(mk5SerialNum));
            } 
        }    
        //To assign the Brain: mk1 has brain 2.5GHZ, mk2 3.5GHZ the rest 4.5GHZ 
        if (a.getBrain() == null) 
        {
            if (a.getModel().equals(model[0]))
            {
                a.setBrain(brain[0]);
            }
            else if (a.getModel().equals(model[1]))
            {
                a.setBrain(brain[1]);
            }
            else
            {
                a.setBrain(brain[2]);
            }    
        }
        
        if (a.getMobility()== null) 
        {
            a.setMobility(mobility[rG.nextInt(mobility.length)]);
        }
        
        if (a.getVision() == null) 
        {
            a.setVision(vision[rG.nextInt(vision.length)]);
        }
        
        if (a.getArms() == null) 
        {
            a.setArms(arms[rG.nextInt(arms.length)]);
        }
        
        if (a.getMediaCenter()== null) 
        {
            a.setMediaCenter(mediaCenter[rG.nextInt(mediaCenter.length)]);
        }
        
        if (a.getPowerPlant()== null) 
        {
            if (a.getModel().equals(model[3]))
            {
                a.setPowerPlant(powerPlant[1]);
            }
            if (a.getModel().equals(model[4]))
            {
                a.setPowerPlant(powerPlant[2]);
            }
            else
            {
                a.setPowerPlant(powerPlant[0]);
            }
        }    
        return a;
                
    }
    
    public  ArrayList<Androids> androidsCreation()
    {
        int numberCurrentLineCreation = 30;
        ArrayList<Androids> listCurrentLine = new ArrayList();
        
        //Creation of 30 androids  
        for (int i = 0; i < numberCurrentLineCreation; i++) 
        {
            Androids mk = new Androids();
            this.fill(mk);
            
            listCurrentLine.add(mk);
            System.out.println(mk.toString());
        }
        return listCurrentLine;
        
    } 
    
    public static int generateRandomSerialNum(int min, int max) 
    {
        Random r = new Random();
        int serialNum = r.nextInt((max - min) + 1) + min;
        return serialNum;
    }    
}
