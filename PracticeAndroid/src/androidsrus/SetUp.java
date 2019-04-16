package androidsrus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//import java.util.UUID;


/**
 *
 * @author aldana
 */
public class SetUp 
{
    //I use the random object to create to set the model,mobility,vision,arms,mediaCenter
    Random rG = new Random();
    ArrayList IDUsed = new ArrayList();
    
    
//    String [] model = {"Android mk1","Android mk2","Android mk3","Android mk4","Android mk5"};
//    String [] brain = {"2.5GHZ","3.5GHZ","4.5GHZ"};
//    String [] mobility = {"catapilar tracks","wheels","legs"};
//    String [] vision = {"heat vision","full colour","night vision"};
//    String [] arms = {"claws","grippers","articulated fingers"};
//    String [] mediaCenter  = {"sony","jvc","meridian"};
//    String [] powerPlant = {"lithium","hydrogen","plasma"};
        
    public Androids fill (Androids a, Data d)
    {
        if (a.getModelOldLine() == null) 
        {
            a.setModel(d.getModelOldLine()[rG.nextInt(d.getModelOldLine().length)]);
        }
        
        if (a.getSerialNum() == null) 
        {
//            int serialNum = UUID.randomUUID().hashCode();
//            a.setSerialNum(String.valueOf(serialNum));
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

            
//            if (a.getModelOldLine().equals(d.getModelOldLine()[0])) 
//            {
//                int mkSerialNum;
//                mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
//                boolean temp = this.checkID(IDUsed, mkSerialNum);
//
//                while (temp == true) {
//                    mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
//                    temp = this.checkID(IDUsed, mkSerialNum);
//                }
//                if (temp == false) {
//                    a.setSerialNum(String.valueOf(mkSerialNum));
//                    IDUsed.add(mkSerialNum);
//                }
//
//            }
//            if (a.getModelOldLine().equals(d.getModelOldLine()[1])) 
//            {
//                int mk2SerialNum;
//                mk2SerialNum = this.generateRandomSerialNum(2000000, 2999999);
//                boolean temp = this.checkID(IDUsed, mk2SerialNum);
//
//                while (temp == true) {
//                    mk2SerialNum = this.generateRandomSerialNum(2000000, 2999999);
//                    temp = this.checkID(IDUsed, mk2SerialNum);
//
//                }
//                if (temp == false) {
//                    a.setSerialNum(String.valueOf(mk2SerialNum));
//                    IDUsed.add(mk2SerialNum);
//                }
//
//            }
////            {
////                int mk3SerialNum;
////                mk3SerialNum = this.generateRandomSerialNum(2000,2999); 
////                
////                a.setSerialNum(String.valueOf(mk3SerialNum));
////            } 
//            if (a.getModelOldLine().equals(d.getModelOldLine()[2])) 
//            {
//                int mk3SerialNum;
//                mk3SerialNum = this.generateRandomSerialNum(3000000, 3999999);
//                boolean temp = this.checkID(IDUsed, mk3SerialNum);
//
//                while (temp == true) {
//                    mk3SerialNum = this.generateRandomSerialNum(3000000, 3999999);
//                    temp = this.checkID(IDUsed, mk3SerialNum);
//
//                }
//                if (temp == false) {
//                    a.setSerialNum(String.valueOf(mk3SerialNum));
//                    IDUsed.add(mk3SerialNum);
//                }
//
//            }
//                
////            {
////                int mk3SerialNum;
////                mk3SerialNum = this.generateRandomSerialNum(3000,3999); 
////                
////                a.setSerialNum(String.valueOf(mk3SerialNum));
////            }
//            if (a.getModelOldLine().equals(d.getModelOldLine()[3])) 
//            {
//                int mk4SerialNum;
//                mk4SerialNum = this.generateRandomSerialNum(4000000, 4999999);
//                boolean temp = this.checkID(IDUsed, mk4SerialNum);
//
//                while (temp == true) {
//                    mk4SerialNum = this.generateRandomSerialNum(4000000, 4999999);
//                    temp = this.checkID(IDUsed, mk4SerialNum);
//                }
//                if (temp == false) {
//                    a.setSerialNum(String.valueOf(mk4SerialNum));
//                    IDUsed.add(mk4SerialNum);
//                }
//
//            }
////            {
////                int mk4SerialNum;
////                mk4SerialNum = this.generateRandomSerialNum(4000,4999); 
////                
////                a.setSerialNum(String.valueOf(mk4SerialNum));
////            }
//            if(a.getModelOldLine().equals(d.getModelOldLine()[4]))
//                {
//                int mk5SerialNum;
//                mk5SerialNum = this.generateRandomSerialNum(5000000, 5999999);
//                boolean temp = this.checkID(IDUsed, mk5SerialNum);
//
//                while (temp == true) {
//                    mk5SerialNum = this.generateRandomSerialNum(5000000, 5999999);
//                    temp = this.checkID(IDUsed, mk5SerialNum);
//
//                }
//                if (temp == false) {
//                    a.setSerialNum(String.valueOf(mk5SerialNum));
//                    IDUsed.add(mk5SerialNum);
//                }
//
//            }
        }
//            {
//                int mk5SerialNum;
//                mk5SerialNum = this.generateRandomSerialNum(5000,5999); 
//                
//                a.setSerialNum(String.valueOf(mk5SerialNum));
//            } 
//        }    
        //To assign the Brain: mk1 has brain 2.5GHZ, mk2 3.5GHZ the rest 4.5GHZ 
        if (a.getBrain() == null) 
        {
            a.setBrain(d.getBrain()[rG.nextInt(d.getBrain().length)]);
//            if (a.getModelOldLine().equals(model[0]))
//            {
//                a.setBrain(brain[0]);
//            }
//            else if (a.getModelOldLine().equals(model[1]))
//            {
//                a.setBrain(brain[1]);
//            }
//            else
//            {
//                a.setBrain(brain[2]);
//            }    
        }
        
        if (a.getMobility()== null) 
        {
            a.setMobility(d.getMobility()[rG.nextInt(d.getMobility().length)]);
        }
        
        if (a.getVision() == null) 
        {
            a.setVision(d.getVision()[rG.nextInt(d.getVision().length)]);
        }
        
        if (a.getArms() == null) 
        {
            a.setArms(d.getArms()[rG.nextInt(d.getArms().length)]);
        }
        
        if (a.getMediaCenter()== null) 
        {
            a.setMediaCenter(d.getMediaCenter()[rG.nextInt(d.getMediaCenter().length)]);
        }
        
        if (a.getPowerPlant()== null) 
        {
            a.setPowerPlant(d.getPowerPlant()[rG.nextInt(d.getPowerPlant().length)]);
        }    
        return a;
                
    }
    
    public  ArrayList<Androids> androidsCreation(Data d)
    {
        int numberCurrentLineCreation = 300;
        ArrayList<Androids> listCurrentLine = new ArrayList();
        
        //Creation of 30 androids  
        for (int i = 0; i < numberCurrentLineCreation; i++) 
        {
            Androids mk = new Androids();
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
        //ArrayList IDUsed = new ArrayList();
        //IDUsed2 = listID;
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
