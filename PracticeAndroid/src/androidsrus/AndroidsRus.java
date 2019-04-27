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
        MenuSetUp mSu = new MenuSetUp();
        Data d = new Data();
        d.getAllData();

        su.creationOldLine(d);
        su.creationNewLine(d);
        
        Menu menu = new Menu(d, mSu,su);     
    } 
}
