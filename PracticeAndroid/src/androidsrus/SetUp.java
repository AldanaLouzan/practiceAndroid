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
public class SetUp {
    
    public static final String ANSI_RED = "\u001B[31m";

    Random rG = new Random();

    Data d = new Data();
    Map<String, Android> oldInitialAndroids = new HashMap<>();  //Map: Key=SerialNum, Value = OldAndroids in their initial stage 
    Map<String, Android> oldFinalAndroids = new HashMap<>();    //Map: Key =SerialNum, Value = OldAndroids in their final stage(parts removed) 
    Map<String, Android> newAndroids = new HashMap<>();         //Map: Key = SerialNum Value = NewAndroids (tracking each part received)
    Map<String, ArrayList<Donation>> parts = new HashMap<>();   //Map: Key = partDonated Value = ArrayList of Donation object (donator, receiver, type of part) 
    //ArrayLists to differenciate the parts donated
    ArrayList<Donation> donationArms = new ArrayList();
    ArrayList<Donation> donationBrain = new ArrayList();
    ArrayList<Donation> donationMobility = new ArrayList();
    ArrayList<Donation> donationMediaCenter = new ArrayList();
    ArrayList<Donation> donationPowerPlant = new ArrayList();
    ArrayList<Donation> donationVision = new ArrayList();

    public SetUp(){};
    
    public void creationOldLine(Data d) throws IOException 
    {
        int numberCurrentLineCreation = 500;

        for (int i = 0; i < numberCurrentLineCreation; i++) 
        {
            Android mk = new Android();
            Android mk2 = new Android();//I need a second Android to duplicate the information of Old Android, in order to keep track of the initial and final stage  

            this.oldLine(mk, d);
            mk2 = this.duplicateOriginalAndroid(mk);

            oldInitialAndroids.put(mk.getSerialNum(), mk2); //Initial stage of the OldAndroids
            oldFinalAndroids.put(mk.getSerialNum(), mk); //Final stage of the OldAndroids
        }
    }
    //Creation of OldLineAndroid setting all its parts Randomly
    public Android oldLine(Android a, Data d) 
    {
        if (a.getModel() == null) 
        {
            a.setModel(d.getModelOld()[rG.nextInt(d.getModelOld().length)]);
        }

        if (a.getSerialNum() == null) 
        {
            int mkSerialNum;
            mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
            boolean temp = oldInitialAndroids.containsKey(mkSerialNum); //Check if the serialNum appears in the Map 

            while (temp == true) 
            {
                mkSerialNum = this.generateRandomSerialNum(1000000, 1999999);
                temp = oldInitialAndroids.containsKey(mkSerialNum);
            }
            if (temp == false) {
                a.setSerialNum(String.valueOf(mkSerialNum));

            }
        }

        if (a.getBrain() == null) {
            a.setBrain(d.getBrain()[rG.nextInt(d.getBrain().length)]);
        }

        if (a.getMobility() == null) {
            a.setMobility(d.getMobility()[rG.nextInt(d.getMobility().length)]);
        }

        if (a.getVision() == null) {
            a.setVision(d.getVision()[rG.nextInt(d.getVision().length)]);
        }

        if (a.getArms() == null) {
            a.setArms(d.getArms()[rG.nextInt(d.getArms().length)]);
        }

        if (a.getMediaCenter() == null) {
            a.setMediaCenter(d.getMediaCenter()[rG.nextInt(d.getMediaCenter().length)]);
        }

        if (a.getPowerPlant() == null) {
            a.setPowerPlant(d.getPowerPlant()[rG.nextInt(d.getPowerPlant().length)]);
        }
        return a;

    }
    
    public int generateRandomSerialNum(int min, int max) 
    {
        Random r = new Random();
        int serialNum = r.nextInt((max - min) + 1) + min;
        return serialNum;
    }

    
    public Android duplicateOriginalAndroid(Android mk) 
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
    
    public void creationNewLine(Data d) throws IOException 
    {
        int numberNewLineCreation = 300;

        for (int i = 0; i < numberNewLineCreation; i++) 
        {
            Android newLine = new Android();
            this.newLine(newLine, d);

            newAndroids.put(newLine.getSerialNum(), newLine);
        }

    }

    public Android newLine(Android a, Data d) 
    {

        Map<String, String> check = new HashMap<>(); //Temporal Map which key and value = serialnum of android used, in order to used just 2parts of each OldAndroid 

        if (a.getModel() == null) {
            a.setModel(d.getModelNew()[rG.nextInt(d.getModelNew().length)]);
        }

        if (a.getSerialNum() == null) {
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

            while (a.getArms() == null || a.getBrain() == null || a.getMediaCenter() == null || a.getMobility() == null || a.getPowerPlant() == null || a.getVision() == null) {

                Android tempAndroid = this.getRandomAndroid(oldFinalAndroids); //generate a temporal Old Android which I get Randomly
                String tempSerialNum = tempAndroid.getSerialNum();//get the serial num from the android i will use
                boolean aux = check.containsKey(tempSerialNum); //I want to check if the Android has donated some parts for this android that i am creating 

                if (aux == false) //It means that it doesnt appear in the temporal Map, so it hasnt donated any part, then I can set two parts from this Android  
                {
                    if (a.getArms() == null && tempAndroid.getArms() !="removed") 
                    {
                        a.setArms(tempAndroid.getArms() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum));//Set the arm
                        donationArms.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getArms())); //add into the ArrayList of Donation objects
                        tempAndroid.setArms("removed");//set the removed part
                        parts.put(d.parts[0], donationArms);//keep track of the donation

                        check.put(tempSerialNum, tempSerialNum);//Add the serial number used to the Temporal Map

                        if (a.getBrain() == null && tempAndroid.getBrain() != "removed") {
                            a.setBrain(tempAndroid.getBrain() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationBrain.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getBrain()));
                            tempAndroid.setBrain("removed");
                            parts.put(d.parts[1], donationBrain);

                        } else if (a.getMediaCenter() == null && tempAndroid.getMediaCenter() != "removed") {
                            a.setMediaCenter(tempAndroid.getMediaCenter() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationMediaCenter.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMediaCenter()));
                            tempAndroid.setMediaCenter("removed");
                            parts.put(d.parts[2], donationMediaCenter);

                        } else if (a.getMobility() == null && tempAndroid.getMobility() != "removed") {
                            a.setMobility(tempAndroid.getMobility() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationMobility.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMobility()));
                            tempAndroid.setMobility("removed");                            
                            parts.put(d.parts[3], donationMobility);
                        } else if (a.getPowerPlant() == null && tempAndroid.getPowerPlant() != "removed") {
                            a.setPowerPlant(tempAndroid.getPowerPlant() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationPowerPlant.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getPowerPlant()));
                            tempAndroid.setPowerPlant("removed");
                            parts.put(d.parts[4], donationPowerPlant);
                        } else if (a.getVision() == null && tempAndroid.getVision() != "removed") {
                            a.setVision(tempAndroid.getVision() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationVision.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getVision()));
                            tempAndroid.setVision("removed");
                            parts.put(d.parts[5], donationVision);
                        }
                    } else if (a.getBrain() == null && tempAndroid.getBrain() != "removed") {
                        a.setBrain(tempAndroid.getBrain() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationBrain.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getBrain()));
                        tempAndroid.setBrain("removed");
                        parts.put(d.parts[1], donationBrain);
                        
                        check.put(tempSerialNum, tempSerialNum);

                        if (a.getMediaCenter() == null && tempAndroid.getMediaCenter() != "removed") {
                            a.setMediaCenter(tempAndroid.getMediaCenter() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationMediaCenter.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMediaCenter()));
                            tempAndroid.setMediaCenter("removed");                            
                            parts.put(d.parts[2], donationMediaCenter);
                        } else if (a.getMobility() == null && tempAndroid.getMobility() != "removed") {
                            a.setMobility(tempAndroid.getMobility() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationMobility.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMobility()));
                            tempAndroid.setMobility("removed");                            
                            parts.put(d.parts[3], donationMobility);
                        } else if (a.getPowerPlant() == null && tempAndroid.getPowerPlant() != "removed") {
                            a.setPowerPlant(tempAndroid.getPowerPlant() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationPowerPlant.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getPowerPlant()));
                            tempAndroid.setPowerPlant("removed");                            
                            parts.put(d.parts[4], donationPowerPlant);
                        } else if (a.getVision() == null && tempAndroid.getVision() != "removed") {
                            a.setVision(tempAndroid.getVision() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationVision.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getVision()));
                            tempAndroid.setVision("removed");                            
                            parts.put(d.parts[5], donationVision);
                        }
                    } else if (a.getMediaCenter() == null && tempAndroid.getMediaCenter() != "removed") {
                        a.setMediaCenter(tempAndroid.getMediaCenter() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationMediaCenter.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMediaCenter()));
                        tempAndroid.setMediaCenter("removed");                        
                        parts.put(d.parts[2], donationMediaCenter);
                        
                        check.put(tempSerialNum, tempSerialNum);

                        if (a.getMobility() == null && tempAndroid.getMobility() != "removed") {
                            a.setMobility(tempAndroid.getMobility() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationMobility.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMobility()));
                            tempAndroid.setMobility("removed");                            
                            parts.put(d.parts[3], donationMobility);
                        } else if (a.getPowerPlant() == null && tempAndroid.getPowerPlant() != "removed") {
                            a.setPowerPlant(tempAndroid.getPowerPlant() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationPowerPlant.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getPowerPlant()));
                            tempAndroid.setPowerPlant("removed");                            
                            parts.put(d.parts[4], donationPowerPlant);
                        } else if (a.getVision() == null && tempAndroid.getVision() != "removed") {
                            a.setVision(tempAndroid.getVision() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationVision.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getVision()));
                            tempAndroid.setVision("removed");                            
                            parts.put(d.parts[5], donationVision);
                        }
                    } else if (a.getMobility() == null && tempAndroid.getMobility() != "removed") {
                        a.setMobility(tempAndroid.getMobility() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationMobility.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMobility()));
                        tempAndroid.setMobility("removed");                        
                        parts.put(d.parts[3], donationMobility);
                        
                        check.put(tempSerialNum, tempSerialNum);

                        if (a.getPowerPlant() == null && tempAndroid.getPowerPlant() != "removed") {
                            a.setPowerPlant(tempAndroid.getPowerPlant() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationPowerPlant.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getPowerPlant()));
                            tempAndroid.setPowerPlant("removed");                            
                            parts.put(d.parts[4], donationPowerPlant);
                        } else if (a.getVision() == null && tempAndroid.getVision() != "removed") {
                            a.setVision(tempAndroid.getVision() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationVision.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getVision()));
                            tempAndroid.setVision("removed");                            
                            parts.put(d.parts[5], donationVision);
                        }
                    } else if (a.getPowerPlant() == null && tempAndroid.getPowerPlant() != "removed") {
                        a.setPowerPlant(tempAndroid.getPowerPlant() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationPowerPlant.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getPowerPlant()));
                        tempAndroid.setPowerPlant("removed");                        
                        parts.put(d.parts[4], donationPowerPlant);
                        check.put(tempSerialNum, tempSerialNum);

                        if (a.getVision() == null && tempAndroid.getVision() != "removed") {
                            a.setVision(tempAndroid.getVision() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                            donationVision.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getVision()));
                            tempAndroid.setVision("removed");                            
                            parts.put(d.parts[5], donationVision);
                        }

                    }
                } else //It means that it appears in the temporal Map, so it has donated one part, then I can set just one part from this Android 
                {
                    if (a.getArms() == null && tempAndroid.getArms() != "removed") {
                        a.setArms(tempAndroid.getArms() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationArms.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getArms()));
                        tempAndroid.setArms("removed");                        
                        parts.put(d.parts[0], donationArms);
                        
                        check.put(tempSerialNum, tempSerialNum);
                    } else if (a.getBrain() == null && tempAndroid.getBrain() != "removed") {
                        a.setBrain(tempAndroid.getBrain() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationBrain.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getBrain()));
                        tempAndroid.setBrain("removed");                        
                        parts.put(d.parts[1], donationBrain);
                        
                        check.put(tempSerialNum, tempSerialNum);
                    } else if (a.getMediaCenter() == null && tempAndroid.getMediaCenter() != "removed") {
                        a.setMediaCenter(tempAndroid.getMediaCenter() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationMediaCenter.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMediaCenter()));
                        tempAndroid.setMediaCenter("removed");                        
                        parts.put(d.parts[2], donationMediaCenter);
                        
                        check.put(tempSerialNum, tempSerialNum);
                    } else if (a.getMobility() == null && tempAndroid.getMobility() != "removed") {
                        a.setMobility(tempAndroid.getMobility() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationMobility.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getMobility()));
                        tempAndroid.setMobility("removed");                        
                        parts.put(d.parts[3], donationMobility);
                        
                        check.put(tempSerialNum, tempSerialNum);
                    } else if (a.getPowerPlant() == null && tempAndroid.getPowerPlant() != "removed") {
                        a.setPowerPlant(tempAndroid.getPowerPlant() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationPowerPlant.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getPowerPlant()));
                        tempAndroid.setPowerPlant("removed");                        
                        parts.put(d.parts[4], donationPowerPlant);
                        
                        check.put(tempSerialNum, tempSerialNum);
                    } else if (a.getVision() == null && tempAndroid.getVision() != "removed") {
                        a.setVision(tempAndroid.getVision() + " (from Android: ".concat(tempAndroid.getModel()) + "| Serial Num: ".concat(tempSerialNum) + ") ");
                        donationVision.add(new Donation(tempSerialNum, a.getSerialNum(), tempAndroid.getVision()));
                        tempAndroid.setVision("removed");                        
                        parts.put(d.parts[5], donationVision);
                        
                        check.put(tempSerialNum, tempSerialNum);
                    }

                }

            }
        }
        check.clear(); //Clean the temporal Map with serial Num for the next creation  
        return a;
    }

    public Android getRandomAndroid(Map<String, Android> androids) 
    {
        Object[] values = androids.values().toArray();
        Android androidRandom = new Android();
        androidRandom = (Android) values[rG.nextInt(values.length)];

        return androidRandom;

    }
}
