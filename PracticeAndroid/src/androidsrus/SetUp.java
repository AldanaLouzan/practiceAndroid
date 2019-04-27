package androidsrus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 *
 * @author aldana
 */
public class SetUp 
{
    
    Random rG = new Random();
    
    Data d = new Data();
    Map <String,Android> oldInitialAndroids = new HashMap<>();
    Map <String,Android> oldFinalAndroids = new HashMap<>();
    Map <String,Android> newAndroids = new HashMap<>();
        
    Map <String, ArrayList<Donation>> parts = new HashMap<>();
    ArrayList <Donation> donationArms = new ArrayList();
    ArrayList <Donation> donationBrain = new ArrayList();
    ArrayList <Donation> donationMobility = new ArrayList();
    ArrayList <Donation> donationMediaCenter = new ArrayList();
    ArrayList <Donation> donationPowerPlant = new ArrayList();
    ArrayList <Donation> donationVision = new ArrayList();        
        
    
            
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
            boolean temp = oldInitialAndroids.containsKey(mkSerialNum);


            while (temp == true) {
                mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
                temp = oldInitialAndroids.containsKey(mkSerialNum);
            }
            if (temp == false) {
                a.setSerialNum(String.valueOf(mkSerialNum));

            }
        }

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

        Map<String, String> check = new HashMap<>(); //Map which key and value = serialnum of android used 
        
        if (a.getModel() == null) 
        {
            a.setModel(d.getModelNew()[rG.nextInt(d.getModelNew().length)]);
        }
        
        if (a.getSerialNum() == null) 
        {
            int newLineSerialNum;
            newLineSerialNum = this.generateRandomSerialNum(2000000, 2999999);
            boolean temp = newAndroids.containsKey(newLineSerialNum);

            while (temp == true) {
                newLineSerialNum = this.generateRandomSerialNum(2000000, 2999999);
                temp = newAndroids.containsKey(newLineSerialNum);
            }
            if (temp == false) {
                a.setSerialNum(String.valueOf(newLineSerialNum));
            }
            
            while (a.getArms()==null || a.getBrain()==null || a.getMediaCenter()==null || a.getMobility()==null || a.getPowerPlant()==null || a.getVision()==null)
            {
              
                Android tempAndroid = this.getRandomAndroid(oldFinalAndroids); //generate a temporal android which I get Randomly
                String tempSerialNum = tempAndroid.getSerialNum();//get the serial num from the android i will use
                boolean available = check.containsKey(tempSerialNum); //I want to check if the Android has donated some parts for this android that i am creating 

                if (available == false)
                {
                    if (a.getArms()== null && tempAndroid.getArms()!= "removed")
                        {
                            
                            a.setArms(tempAndroid.getArms().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            donationArms.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getArms()));
                            tempAndroid.setArms("removed");
                            parts.put(d.parts[0], donationArms);
                            
                            check.put(tempSerialNum, tempSerialNum);
                            
                            
                            if(a.getBrain()== null && tempAndroid.getBrain()!= "removed")
                            {
                                a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                donationBrain.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getBrain()));
                                tempAndroid.setBrain("removed");
                                parts.put(d.parts[1], donationBrain);
                                
                            }
                            else if(a.getMediaCenter()== null &&tempAndroid.getMediaCenter()!= "removed")
                            {
                                a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                donationMediaCenter.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMediaCenter()));
                                tempAndroid.setMediaCenter("removed");
                                parts.put(d.parts[2], donationMediaCenter);
                                
                            }
                            else if(a.getMobility()== null &&tempAndroid.getMobility()!= "removed")
                            {
                                a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMobility("removed");
                                donationMobility.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMobility()));
                                parts.put(d.parts[3], donationMobility);
                            }
                            else if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationPowerPlant.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getPowerPlant()));
                                parts.put(d.parts[4], donationPowerPlant);
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationVision.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getVision()));
                                parts.put(d.parts[5], donationVision);
                            }
                        } 
                    else if (a.getBrain()== null && tempAndroid.getBrain()!= "removed")
                        {
                            a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setBrain("removed");
                            donationBrain.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getBrain()));
                            check.put(tempSerialNum, tempSerialNum);
                            parts.put(d.parts[1], donationBrain);
                            
                            if(a.getMediaCenter()== null &&tempAndroid.getMediaCenter()!= "removed")
                            {
                                a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMediaCenter("removed");
                                donationMediaCenter.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMediaCenter()));
                                parts.put(d.parts[2], donationMediaCenter);
                            }
                            else if(a.getMobility()== null &&tempAndroid.getMobility()!= "removed")
                            {
                                a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMobility("removed");
                                donationMobility.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMobility()));
                                parts.put(d.parts[3], donationMobility);
                            }
                            
                            else if(a.getPowerPlant()== null &&tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationPowerPlant.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getPowerPlant()));
                                parts.put(d.parts[4], donationPowerPlant);
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationVision.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getVision()));
                                parts.put(d.parts[5], donationVision);
                            }
                        }
                    
                    else if (a.getMediaCenter()== null &&tempAndroid.getMediaCenter()!= "removed")
                        {
                            a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setMediaCenter("removed");
                            donationMediaCenter.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMediaCenter()));
                            parts.put(d.parts[2], donationMediaCenter);
                            check.put(tempSerialNum, tempSerialNum);
                           
                            if(a.getMobility()== null &&tempAndroid.getMobility()!= "removed")
                            {
                                a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setMobility("removed");
                                donationMobility.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMobility()));
                                parts.put(d.parts[3], donationMobility);
                            }
                            
                            else if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationPowerPlant.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getPowerPlant()));
                                parts.put(d.parts[4], donationPowerPlant);
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationVision.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getVision()));
                                parts.put(d.parts[5], donationVision);
                            }
                        }
                    else if (a.getMobility()== null && tempAndroid.getMobility()!= "removed")
                        {
                            a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setMobility("removed");
                            donationMobility.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMobility()));
                            parts.put(d.parts[3], donationMobility);
                            check.put(tempSerialNum, tempSerialNum);
                           
                            if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                            {
                                a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationPowerPlant.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getPowerPlant()));
                                parts.put(d.parts[4], donationPowerPlant);
                            }
                            else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationVision.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getVision()));
                                parts.put(d.parts[5], donationVision);
                            }
                        }
                    else if (a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                    {
                            a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                            tempAndroid.setPowerPlant("removed");
                            donationPowerPlant.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getPowerPlant()));
                            parts.put(d.parts[4], donationPowerPlant);
                            check.put(tempSerialNum, tempSerialNum);
                           
                            if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationVision.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getVision()));
                                parts.put(d.parts[5], donationVision);
                            }

                }
                }
                
                else
                {
                    if (a.getArms()== null && tempAndroid.getArms()!= "removed")
                           {
                                a.setArms(tempAndroid.getArms().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setArms("removed");
                                donationArms.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getArms()));
                                parts.put(d.parts[0], donationArms);
                                check.put(tempSerialNum, tempSerialNum);
                           }
                     else if (a.getBrain()== null && tempAndroid.getBrain()!= "removed")
                           {
                                a.setBrain(tempAndroid.getBrain().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setBrain("removed");
                                donationBrain.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getBrain()));
                                parts.put(d.parts[1], donationBrain);
                                check.put(tempSerialNum, tempSerialNum);
                           }
                    else if (a.getMediaCenter()== null && tempAndroid.getMediaCenter()!= "removed")
                           {
                               a.setMediaCenter(tempAndroid.getMediaCenter().concat(tempAndroid.getModel()).concat(tempSerialNum));
                               tempAndroid.setMediaCenter("removed");
                                donationMediaCenter.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMediaCenter()));
                               parts.put(d.parts[2], donationMediaCenter);
                               check.put(tempSerialNum, tempSerialNum);
                           }
                    else if (a.getMobility()== null && tempAndroid.getMobility()!= "removed")
                           {
                               a.setMobility(tempAndroid.getMobility().concat(tempAndroid.getModel()).concat(tempSerialNum));
                               tempAndroid.setMobility("removed");
                                donationMobility.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getMobility()));
                               parts.put(d.parts[3], donationMobility);
                               check.put(tempSerialNum, tempSerialNum);
                           }
                    else if(a.getPowerPlant()== null && tempAndroid.getPowerPlant()!= "removed")
                               {
                                   a.setPowerPlant(tempAndroid.getPowerPlant().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                   tempAndroid.setPowerPlant("removed");
                                    donationPowerPlant.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getPowerPlant()));
                                   parts.put(d.parts[4], donationPowerPlant);
                                   check.put(tempSerialNum, tempSerialNum);
                               }
                    else if(a.getVision()== null && tempAndroid.getVision()!= "removed")
                            {
                                a.setVision(tempAndroid.getVision().concat(tempAndroid.getModel()).concat(tempSerialNum));
                                tempAndroid.setPowerPlant("removed");
                                donationVision.add(new Donation(tempSerialNum,a.getSerialNum(),tempAndroid.getVision()));
                                parts.put(d.parts[5], donationVision);
                                check.put(tempSerialNum, tempSerialNum);
                            }

                }
                
            }
        }
        check.clear();
        return a;
    }
    
    public Android getRandomAndroid (Map <String,Android> androids)
    {
        Object[] values = androids.values().toArray();
        Android androidRandom = new Android();
        androidRandom = (Android)values[rG.nextInt(values.length)];
       
        return androidRandom;
                
    }

    public  void creationOldLine(Data d) throws IOException
    {
        int numberCurrentLineCreation = 10;
        
        //Creation of 30 androids  
        for (int i = 0; i < numberCurrentLineCreation; i++) 
        {
            Android mk = new Android();
            Android mk2 = new Android();

            this.oldLine(mk,d);
            mk2 = this.duplicateOriginalAndroid(mk);
            
            oldInitialAndroids.put(mk.getSerialNum(),mk2);
            oldFinalAndroids.put(mk.getSerialNum(),mk); 
            System.out.println(mk.toString());
        }
        } 
    
    public Android duplicateOriginalAndroid (Android mk) 
    {
        Android mk2 = new Android();

        String auxiliar;
        
        auxiliar = mk.getModel();
        mk2.setModel(auxiliar);
        
        auxiliar = mk.getSerialNum();
        mk2.setSerialNum(auxiliar);
        
        auxiliar = mk.getModel();
        mk2.setModel(auxiliar);
        
        auxiliar = mk.getSerialNum();
        mk2.setSerialNum(auxiliar);
        
        auxiliar = mk.getArms();
        mk2.setArms(auxiliar);
        
        auxiliar = mk.getBrain();
        mk2.setBrain(auxiliar);
        
        auxiliar = mk.getMobility();
        mk2.setMobility(auxiliar);
        
        auxiliar = mk.getMediaCenter();
        mk2.setMediaCenter(auxiliar);
        
        auxiliar = mk.getPowerPlant();
        mk2.setPowerPlant(auxiliar);
        
        auxiliar = mk.getVision();
        mk2.setVision(auxiliar);
         
        return mk2;
                
    }
        
    
    public  void creationNewLine(Data d) throws IOException
    {
        int numberNewLineCreation = 5;
  
        //Creation of 30 androids  
        for (int i = 0; i < numberNewLineCreation; i++) 
        {
            Android newLine = new Android();
            Donation don = new Donation();
            this.newLine(newLine,d);

            newAndroids.put(newLine.getSerialNum(),newLine);
            System.out.println(newLine.toString());
        }

    } 
    public int generateRandomSerialNum(int min, int max) 
    {
        Random r = new Random();
        int serialNum = r.nextInt((max - min) + 1) + min;
        return serialNum;
    }
    
//    public boolean checkID (ArrayList listID, int ID )
//    {
//        boolean value = false;
//        for(int i=0; i<listID.size();i++)
//        {
//            if (listID.get(i).equals(ID))
//                {
//                    value = true;
//                }
//                      
//        }    
//        return value;
//       
//    }
    
}
