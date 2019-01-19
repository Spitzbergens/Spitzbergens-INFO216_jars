package Models;

public class MensClothing {

    private String garment;
    private String fitsCondition;
    private String fitsSeason;
    private String fitsTemp;
    private String shoe;


    /**
     * Constructor for creating a MensClothing object
     *
     * @param garment       a garmetn
     * @param fitsCondition a condition
     * @param fitsSeason    a season
     * @param fitsTemp      a temperature
     * @param shoe          a shoe
     */
    public MensClothing(String garment, String fitsCondition, String fitsSeason, String fitsTemp, String shoe) {
        this.garment = garment;
        this.fitsCondition = fitsCondition;
        this.fitsSeason = fitsSeason;
        this.shoe = shoe;
        this.fitsTemp = fitsTemp;

    }

    public MensClothing() {

    }

    /**
     * Getters and setters for the MensClothing model
     */

    public String getFitsTemp() {
        return fitsTemp;
    }

    public void setFitsTemp(String fitsTemp) {
        this.fitsTemp = fitsTemp;
    }

    public String getGarment() {
        return garment;
    }

    public void setGarment(String garment) {
        this.garment = garment;
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

    public String getShoe() {
        return shoe;
    }

    public void setShoe(String shoe) {
        this.shoe = shoe;
    }
}
