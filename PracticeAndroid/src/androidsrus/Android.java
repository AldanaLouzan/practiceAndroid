
package androidsrus;

/**
 *
 * @author aldana
 */
public class Android 
{
    private String model;
    private String serialNum;
    private String brain;
    private String mobility;
    private String vision;
    private String arms;
    private String mediaCenter;
    private String powerPlant;

    public Android() {}

    public Android(String model, String serialNum, String brain, String mobility, String vision, String arms, String mediaCenter, String powerPlant) 
    {
        this.model = model;
        this.serialNum = serialNum;
        this.brain = brain;
        this.mobility = mobility;
        this.vision = vision;
        this.arms = arms;
        this.mediaCenter = mediaCenter;
        this.powerPlant = powerPlant;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getSerialNum() 
    {
        return serialNum;
    }

    public void setSerialNum(String serialNum) 
    {
        this.serialNum = serialNum;
    }

    public String getBrain() 
    {
        return brain;
    }

    public void setBrain(String brain) 
    {
        this.brain = brain;
    }

    public String getMobility() 
    {
        return mobility;
    }

    public void setMobility(String mobility) 
    {
        this.mobility = mobility;
    }

    public String getVision() 
    {
        return vision;
    }

    public void setVision(String vision) 
    {
        this.vision = vision;
    }

    public String getArms() 
    {
        return arms;
    }

    public void setArms(String arms) 
    {
        this.arms = arms;
    }

    public String getMediaCenter() 
    {
        return mediaCenter;
    }

    public void setMediaCenter(String mediaCenter) 
    {
        this.mediaCenter = mediaCenter;
    }

    public String getPowerPlant() 
    {
        return powerPlant;
    }

    public void setPowerPlant(String powerPlant) 
    {
        this.powerPlant = powerPlant;
    }

    @Override
    public String toString() 
    {
        return "Androids " + "Model: " + model + ", Serial Number: " + serialNum + ", Brain: " + brain + ", Mobility: " + mobility + ", Vision: " + vision + ", Arms: " + arms + ", Media Center: " + mediaCenter + ", Power Plant: " + powerPlant;
    }

}
