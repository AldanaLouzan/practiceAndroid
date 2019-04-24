package androidsrus;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author aldana
 */
public class AndroidsRus 
{
    public static void main(String[] args) throws IOException 
    {
        SetUp su = new SetUp();
        //This ArrayList has to be a HashMap or TreeMap
        //ArrayList<Android> listAndroidOld = new ArrayList();
        Map <String,Android> oldAndroids = new HashMap<>();
        Map <String,Android> newAndroids = new HashMap<>();
        su.creationOldLine();
        //su.getRandomAndroid();
        su.creationNewLine();
        //su.test();
              
        
    } 
}
