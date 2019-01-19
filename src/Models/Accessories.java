package Models;

public class Accessories {
    private String accessory;
    private String fitsCondition;
    private String fitsSeason;

    /**
     * Constructors for creating a model.
     *
     * @param accessory     an accessory
     * @param fitsCondition a weather condition
     * @param fitsSeason    a season
     */

    public Accessories(String accessory, String fitsCondition, String fitsSeason) {
        this.accessory = accessory;
        this.fitsCondition = fitsCondition;
        this.fitsSeason = fitsSeason;
    }

    public Accessories() {
    }

    /**
     * Getters for the accessories model
     * @return a String
     */
    public String getAccessory() {
        return accessory;
    }


    /**
     * Setters for the accessories model.
     * @param accessory string accessoriy
     */
    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getFitsCondition() {
        return fitsCondition;
    }

    public void setFitsCondition(String fitsCondition) {
        this.fitsCondition = fitsCondition;
    }

    public String getFitsSeason() {
        return fitsSeason;
    }

    public void setFitsSeason(String fitsSeason) {
        this.fitsSeason = fitsSeason;
    }
}
