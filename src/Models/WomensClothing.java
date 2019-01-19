package Models;

public class WomensClothing {
    private String garment;
    private String fitsCondition;
    private String fitsSeason;
    private String shoe;

    public WomensClothing(String garment, String fitsCondition, String fitsSeason, String shoe) {
        this.garment = garment;
        this.fitsCondition = fitsCondition;
        this.fitsSeason = fitsSeason;
        this.shoe = shoe;
    }

    public WomensClothing() {

    }

    public String getGarment() {
        return garment;
    }

    /**
     * Getters and setters for the womensClothing model
     */
    public void setGarment(String garment) {
        this.garment = garment;
    }

    public String getFitsCondition() {
        return fitsCondition;
    }

    public void setFitsCondition(String fitsCondition) {
        this.fitsCondition = fitsCondition;
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
