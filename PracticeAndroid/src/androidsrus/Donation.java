package androidsrus;

/**
 *
 * @author aldana
 */
public class Donation 
{
    public String donator;
    public String reciever;
    public String part;

    public Donation(){} //This object will be use to keep track of the donation of parts

    public Donation(String donator, String reciever, String part) 
    {
        this.donator = donator;
        this.reciever = reciever;
        this.part = part;
    }
 
    public Donation(String donator, String reciever) 
    {
        this.donator = donator;
        this.reciever = reciever;
    }

    public String getDonator() {
        return donator;
    }

    public void setDonator(String donator) {
        this.donator = donator;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
    

    @Override
    public String toString() {
        return "Donation{" + "donator=" + donator + ", reciever=" + reciever + '}';
    }
    
       
}
