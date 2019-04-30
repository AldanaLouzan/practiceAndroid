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
        Data d = new Data();
        d.getAllData();
        SetUp su = new SetUp();
        su.creationOldLine(d);
        su.creationNewLine(d);
        
        Menu m = new Menu();
        MenuSetUp mSu = new MenuSetUp();
        m.initializeMenu(d, mSu, su);
         
        
    } 
}
