package androidsrus;

import java.io.IOException;
import java.util.ArrayList;



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
        ArrayList<Android> listAndroidOld = new ArrayList();
        listAndroidOld = su.androidsCreation();
              
        
    } 
}
