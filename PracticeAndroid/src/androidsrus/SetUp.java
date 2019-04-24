package androidsrus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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
    Map <String,Android> oldAndroids = new HashMap<>();
    Map <String,Android> newAndroids = new HashMap<>();
    
            
    public Android oldLine (Android a, Data d)
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
            a.setBrain(d.getBrain()[rG.nextInt(d.getBrain().length)]);
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
    
    public Android newLine (Android a, Data d)            
    {
        //
        Map<String, String> check = new HashMap<>(); //Map which key and value = serialnum of android used 
        //int i = 0;
        
        if (a.getModel() == null) 
        {
            a.setModel(d.getModelNew()[rG.nextInt(d.getModelNew().length)]);
        }
        
        if (a.getSerialNum() == null) 
        {
            int newLineSerialNum;
            newLineSerialNum = this.generateRandomSerialNum(2000000, 2999999);
            boolean temp = this.checkID(IDUsed, newLineSerialNum);

            while (temp == true) {
                newLineSerialNum = this.generateRandomSerialNum(2000000, 2999999);
                temp = this.checkID(IDUsed, newLineSerialNum);
            }
            if (temp == false) {
                a.setSerialNum(String.valueOf(newLineSerialNum));
                IDUsed.add(newLineSerialNum);
            }
            
            while (a.getArms()==null || a.getBrain()==null || a.getMediaCenter()==null || a.getMobility()==null || a.getPowerPlant()==null || a.getVision()==null)
            {
                //Map<String,;
                
                Android tempAndroid = this.getRandomAndroid(); //generate a temporal android which I get Randomly
                String tempSerialNum = tempAndroid.getSerialNum();//get the serial num from the android i will use
                //boolean checkSerialNum = this.checkAndroidUsed(tempSerialNum);
                boolean available = check.containsKey(tempSerialNum); //I want to check if the Android has donated some parts for this android that i am creating 

                if (available == false)
                {
                    if (a.getArms()== null && tempAndroid.getArms()!= "removed")
                        {
                            a.setArms(tempAndroid.getArms().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setArms("removed");
                            oldAndroids.replace(tempSerialNum, tempAndroid);
                            check.put(tempSerialNum, tempSerialNum);
                            
                            
                            if(a.getBrain()== null && tempAndroid.getBrain()!= "removed")
                            {
                                a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setBrain("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getMediaCenter()== null &&tempAndroid.getMediaCenter()!= "removed")
                            {
                                a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMediaCenter("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getMobility()== null &&tempAndroid.getMobility()!= "removed")
                            {
                                a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMobility("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                        } 
                    else if (a.getBrain()== null && tempAndroid.getBrain()!= "removed")
                        {
                            a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setBrain("removed");
                            oldAndroids.replace(tempSerialNum, tempAndroid);
                            check.put(tempSerialNum, tempSerialNum);
                            
                            
                            if(a.getMediaCenter()== null &&tempAndroid.getMediaCenter()!= "removed")
                            {
                                a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMediaCenter("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getMobility()== null &&tempAndroid.getMobility()!= "removed")
                            {
                                a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMobility("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            
                            else if(a.getPowerPlant()== null &&tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                        }
                    
                    else if (a.getMediaCenter()== null &&tempAndroid.getMediaCenter()!= "removed")
                        {
                            a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setMediaCenter("removed");
                            oldAndroids.replace(tempSerialNum, tempAndroid);
                            check.put(tempSerialNum, tempSerialNum);
                           
                            if(a.getMobility()== null &&tempAndroid.getMobility()!= "removed")
                            {
                                a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMobility("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            
                            else if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                        }
                    else if (a.getMobility()== null && tempAndroid.getMobility()!= "removed")
                        {
                            a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setMobility("removed");
                            oldAndroids.replace(tempSerialNum, tempAndroid);
                            check.put(tempSerialNum, tempSerialNum);
                           
                            if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }
                        }
                    else if (a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                    {
                            a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setPowerPlant("removed");
                            oldAndroids.replace(tempSerialNum, tempAndroid);
                            check.put(tempSerialNum, tempSerialNum);
                           
                            if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                
                            }

                }
                }
                
                else
                {
                    if (a.getArms()== null && tempAndroid.getArms()!= "removed")
                           {
                               a.setArms(tempAndroid.getArms().concat(tempAndroid.getModel()).concat(tempSerialNum));
                               tempAndroid.setArms("removed");
                               oldAndroids.replace(tempSerialNum, tempAndroid);
                               check.put(tempSerialNum, tempSerialNum);
                           }
                     else if (a.getBrain()== null && tempAndroid.getBrain()!= "removed")
                           {
                               a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
                               tempAndroid.setBrain("removed");
                               oldAndroids.replace(tempSerialNum, tempAndroid);
                               check.put(tempSerialNum, tempSerialNum);
                           }
                    else if (a.getMediaCenter()== null && tempAndroid.getMediaCenter()!= "removed")
                           {
                               a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                               tempAndroid.setMediaCenter("removed");
                               oldAndroids.replace(tempSerialNum, tempAndroid);
                               check.put(tempSerialNum, tempSerialNum);
                           }
                    else if (a.getMobility()== null && tempAndroid.getMobility()!= "removed")
                           {
                               a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                               tempAndroid.setMobility("removed");
                               oldAndroids.replace(tempSerialNum, tempAndroid);
                               check.put(tempSerialNum, tempSerialNum);
                           }
                    else if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                               {
                                   a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                   tempAndroid.setPowerPlant("removed");
                                   oldAndroids.replace(tempSerialNum, tempAndroid);
                                   check.put(tempSerialNum, tempSerialNum);
                               }
                    else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                oldAndroids.replace(tempSerialNum, tempAndroid);
                                check.put(tempSerialNum, tempSerialNum);
                            }

                }
                
            }
//                if (checkSerialNum == true)
//                {
//                    // (!"removed".equals(tempAndroid.getBrain()))
//                    if (tempAndroid.getBrain().equals("removed"))
//                        {
//                            a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
//                            tempAndroid.setBrain("removed");
//                            oldAndroids.replace(tempSerialNum, tempAndroid);
//                            //tempSerialNum.put
//                            //loop
//
//                            freq.put(tempSerialNum,i+1);        
//
//                            //int count = freq.get(i);
//
//                            Counter count = freq.get(value);
//                            if (count == null) 
//                            {
//                                freq.put(value, new Counter());
//                            }
//                            else 
//                            {
//                                count.increment();
//                            }        
//                        }
//                }
            
//        Android tempAndroid = this.getRandomAndroid(); //generate a temporal android which I get Randomly
//        String tempSerialNum = tempAndroid.getSerialNum();//get the serial num from the android i will use
//        boolean available = check.containsKey(tempSerialNum); //I want to check if the Android has donated some parts for this android that i am creating 
//
//        while (a.getArms()== null)
//            {
//                if (available == false)
//                
//            }
        }
        check.clear();
        return a;
    }
    
    public Android getRandomAndroid ()
    {
        Object[] values = oldAndroids.values().toArray();
        Android androidRandom = new Android();
        androidRandom = (Android)values[rG.nextInt(values.length)];
       
        return androidRandom;
                
    }
    public  void creationOldLine() throws IOException
    {
        int numberCurrentLineCreation = 500;
        //ArrayList<Android> listCurrentLine = new ArrayList();
        d.generateAllData();
        
        //Creation of 30 androids  
        for (int i = 0; i < numberCurrentLineCreation; i++) 
        {
            Android mk = new Android();
            this.oldLine(mk,d);
            
            //listCurrentLine.add(mk);
            oldAndroids.put(mk.getSerialNum(),mk);
            System.out.println(mk.toString());
        }
        //return listCurrentLine;
       
        
    } 
    public  void creationNewLine() throws IOException
    {
        int numberNewLineCreation = 400;
        //ArrayList<Android> listCurrentLine = new ArrayList() ;
        d.generateAllData();
        
        //Creation of 30 androids  
        for (int i = 0; i < numberNewLineCreation; i++) 
        {
            Android newLine = new Android();
            this.newLine(newLine,d);
            
            //listCurrentLine.add(mk);
            newAndroids.put(newLine.getSerialNum(),newLine);
            System.out.println(newLine.toString());
        }
        
        
        //return listCurrentLine;
       
        
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
    
//    public void checkAndroidUsed (String value)
//    {
//        boolean available = false;
//        Map<String, Counter> freq = new HashMap<>();
//        
//        Counter count = freq.get(value);
//        if (count == null) 
//        {
//            freq.put(value, new Counter());
//            
//        }
//        else 
//        {
//            count.increment();
//        }
//        
//        if (count.getCounter()<2)
//            {
//                available = true;
//            }
//           
//    }
    
//    public boolean checkAndroidUsed (String serialNum, HashMap<String,String>)
//    {
//        
//        return false;
//        
//    }
//    
//    
//    public void test() 
//    {
//        //Android a = new
//        Map <String,Android> oldAndroids = new HashMap<String, Android>();
//        oldAndroids.put("11223344", new Android ("mk1","11223344","2.5GHZ","Catapilar","Heat Vision","Claws","Sony","Lithium"));
//        oldAndroids.put("11223355", new Android ("mk1","11223355","2.5GHZ","Catapilar","Heat Vision","Claws","Samsung","Lithium"));
//        
//        for (Entry<String, Android> android : oldAndroids.entrySet())
//        {
//                String clave = android.getKey();
//                Android valor = android.getValue();
//                System.out.println(clave+"  ->  "+valor.toString());
//                //Samsung se puede reemplazar por un Scanner o algo asi
//                if (valor.getMediaCenter()=="Samsung")
//                {
//                        System.out.println("Test muestra Media Center: "+valor.getMediaCenter()); 
//                }
//                
//        }
//    }
}
