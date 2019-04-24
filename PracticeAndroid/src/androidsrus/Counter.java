/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androidsrus;

/**
 *
 * @author aldana
 */
public class Counter 
{
    int value = 1; // note that we start at 1 since we're counting
    public void increment () 
    { 
        ++value;      
    }
    public int  getCounter ()       
    { 
        return value; 
    }

    
}
