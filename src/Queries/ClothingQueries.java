package Queries;

import Models.Accessories;
import Models.MensClothing;
import Models.WomensClothing;
import RDF.RDFController;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

public class ClothingQueries {

    private RDFController controller;


    /**
     * Constructor for creating a new RDFcontroller
     *
     * @param controller
     */
    public ClothingQueries(RDFController controller) {
        this.controller = controller;
    }

    /**
     * Just a query used for testing and viewing clothing and their matching weather condition.
     * @return Resultset
     */
    public ResultSet queryAll() {
        String query = "SELECT ?s ?o " +
                "WHERE { " +
                "  ?s sc:isSuitableToBeDressedOnWeather ?o " +
                "}";
        return controller.runQuery(query);
    }

    /**
     * Querying all information on a weather phenomenon related to clothing, retrieving a weatherlabel, seasonlabel, conditionlabel and warmth.
     * @param condition, F.eks "Cold", "Hot", "Clear", "Wet", "Dry", "Cloudy"
     * @return a resultset
     */
    public ResultSet queryClothingForWeather(String condition) {
        String query = "SELECT ?label ?seasonlabel ?conditionLabel ?warmth " +
                "WHERE { " +
                "  ?clothing a owl:NamedIndividual; " +
                "    sc:isSuitableToBeDressedInSeason ?season; " +
                "            rdfs:label ?label; " +
                "            sc:isSuitableToBeDressedOnWeather ?condition; " +
                "            sc:hasWarmth ?warmth. " +
                "  ?season rdfs:label ?seasonlabel. " +
                "  ?condition rdfs:label ?conditionLabel. " +
                "   " +
                "  FILTER REGEX (?conditionLabel, \"" + condition + "\" ) " +
                "   " +
                "}";

        return controller.runQuery(query);
    }

    /**
     * Querying the semcloth for clothing items and shoes.  and filtering on three parameters, Condition, tempCondition and season.
     *
     * @param condition     For example: "Cloudy, clear, partly cloudy, dry or wet. "
     * @param tempCondition For example: "Hot, "Cold", "Moderately cold", "Moderately hot"
     * @param season        For example: "Summer", "Autumn", "Summer", "Winter"
     * @return the resultset
     */

    private ResultSet queryMensClothing(String condition, String tempCondition, String season) {
        String query = "SELECT ?mensClothing ?shoeLabel ?conditionLabel ?tempConditionLabel ?seasonLabel " +
                "WHERE { " +
                "  " +
                "  ?garment rdfs:subClassOf dbr:Clothing;         " +
                "     sc:isSuitableToBeDressedInSeason ?season; " +
                "            rdfs:label ?mensClothing; " +
                "            sc:isSuitableToBeDressedOnWeather ?condition; " +
                "            sc:isSuitableToBeDressedOnWeather ?tempCondition; " +
                "            sc:isSuitableToBeDressedByGenre dbr:Male. " +
                "   " +
                "  ?shoes rdfs:subClassOf sc:Shoes; " +
                "         rdfs:label ?shoeLabel; " +
                "         sc:isSuitableToBeDressedByGenre dbr:Male; " +
                "         sc:isSuitableToBeDressedOnWeather ?condition; " +
                "         sc:isSuitableToBeDressedOnWeather ?tempCondition; " +
                "         sc:isSuitableToBeDressedInSeason ?season. " +
                "            " +
                "  ?season rdfs:label ?seasonLabel. " +
                "  ?condition rdfs:label ?conditionLabel. " +
                "  ?tempCondition rdfs:label ?tempConditionLabel. " +
                " " +
                "    FILTER (?conditionLabel = \"" + condition + "\" && ?tempConditionLabel = \"" + tempCondition + "\" && ?seasonLabel = \"" + season + "\") " +
                "} LIMIT 2";

        return controller.runQuery(query);
    }

    /**
     * Querying the semcloth for clothing items and shoes.  and filtering on three parameters, Condition, tempCondition and season.
     *
     * @param condition     For example: "Cloudy, clear, partly cloudy, dry or wet. "
     * @param tempCondition For example: "Hot, "Cold", "Moderately cold", "Moderately hot"
     * @param season        For example: "Summer", "Autumn", "Summer", "Winter"
     * @return the resultset
     */

    private ResultSet queryWomensClothing(String condition, String tempCondition, String season) {
        String query = "SELECT ?womensClothing ?shoeLabel ?conditionLabel ?tempConditionLabel ?seasonLabel " +
                "WHERE { " +
                "  " +
                "  ?garment rdfs:subClassOf dbr:Clothing;         " +
                "     sc:isSuitableToBeDressedInSeason ?season; " +
                "            rdfs:label ?womensClothing; " +
                "            sc:isSuitableToBeDressedOnWeather ?condition; " +
                "            sc:isSuitableToBeDressedOnWeather ?tempCondition; " +
                "            sc:isSuitableToBeDressedByGenre dbr:Female. " +
                "   " +
                "  ?shoes rdfs:subClassOf sc:Shoes; " +
                "         rdfs:label ?shoeLabel; " +
                "         sc:isSuitableToBeDressedByGenre dbr:Female; " +
                "         sc:isSuitableToBeDressedOnWeather ?condition; " +
                "         sc:isSuitableToBeDressedOnWeather ?tempCondition; " +
                "         sc:isSuitableToBeDressedInSeason ?season. " +
                "            " +
                "  ?season rdfs:label ?seasonLabel. " +
                "  ?condition rdfs:label ?conditionLabel. " +
                "  ?tempCondition rdfs:label ?tempConditionLabel. " +
                " " +
                "    FILTER (?conditionLabel = \"" + condition + "\" && ?tempConditionLabel = \"" + tempCondition + "\" && ?seasonLabel = \"" + season + "\") " +
                "}" +
                "LIMIT 2";

        return controller.runQuery(query);

    }

    /**
     * Querying the semcloth for clothing items and shoes.  and filtering on three parameters, Condition, tempCondition and season.
     * @param weatherCondition For example: "Cloudy, clear, partly cloudy, dry or wet. "
     * @param season For example: "Summer", "Autumn", "Summer", "Winter"
     * @return the resultset
     *
     */

    public ResultSet queryAccessories(String weatherCondition, String season) {
        String query = "SELECT ?accessoryLabel ?conditionLabel ?seasonLabel " +
                "WHERE { " +
                "   " +
                "  ?accessory rdfs:subClassOf sc:Accessory; " +
                "             rdfs:label ?accessoryLabel; " +
                "             sc:isSuitableToBeDressedOnWeather ?weather; " +
                "             sc:isSuitableToBeDressedInSeason ?season. " +
                "  ?weather rdfs:label ?conditionLabel. " +
                "  ?season rdfs:label ?seasonLabel. " +
                "   " +
                "  FILTER (?conditionLabel = \"" + weatherCondition + "\" " + " && ?seasonLabel = \"" + season + "\") " +
                "  " +
                "}" +
                "LIMIT 1";
        return controller.runQuery(query);
    }

    /**
     * Returning the query-resultset as an object which will be displayed.
     * Using the parameters weatherCondition, TempCondition and Season.
     *
     * @param weatherCondition For example: "Cloudy, clear, partly cloudy, dry or wet. "
     * @param tempCondition For example: "Hot, "Cold", "Moderately cold", "Moderately hot"
     * @param season For example: "Summer", "Autumn", "Summer", "Winter"
     * @return the mensClothing object.
     */
    public MensClothing mensToObject(String weatherCondition, String tempCondition, String season) {
        MensClothing mensClothing = null;
        ResultSet clothingSet = queryMensClothing(weatherCondition, tempCondition, season);
        QuerySolution qs = null;
        if (clothingSet.hasNext()) {
            try {
                qs = clothingSet.nextSolution();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            mensClothing = new MensClothing();
            mensClothing.setGarment(qs.getLiteral("mensClothing").toString());
            mensClothing.setShoe(qs.getLiteral("shoeLabel").toString());
            mensClothing.setFitsCondition(qs.getLiteral("conditionLabel").toString());
            mensClothing.setFitsSeason(qs.getLiteral("seasonLabel").toString());
        }
        return mensClothing;
    }

    /**
     * Returning the query-resultset as an object which will be displayed.
     * Using the parameters weatherCondition, TempCondition and Season.
     *
     * @param weatherCondition For example: "Cloudy, clear, partly cloudy, dry or wet. "
     * @param tempCondition For example: "Hot, "Cold", "Moderately cold", "Moderately hot"
     * @param season For example: "Summer", "Autumn", "Summer", "Winter"
     * @return
     */
    public WomensClothing womensToObject(String weatherCondition, String tempCondition, String season) {
        WomensClothing womensClothing = null;
        ResultSet clothingSet = queryWomensClothing(weatherCondition, tempCondition, season);
        QuerySolution qs = null;
        if (clothingSet.hasNext()) {
            try {
                qs = clothingSet.nextSolution();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            // ?womensClothing ?shoeLabel ?conditionLabel ?seasonLabel
            womensClothing = new WomensClothing();
            womensClothing.setGarment(qs.getLiteral("womensClothing").toString());
            womensClothing.setShoe(qs.getLiteral("shoeLabel").toString());
            womensClothing.setFitsCondition(qs.getLiteral("conditionLabel").toString());
            womensClothing.setFitsSeason(qs.getLiteral("seasonLabel").toString());
        }
        return womensClothing;
    }

    /**
     * Returning the query-resultset as an object which will be displayed.
     * Using the parameters weatherCondition, TempCondition and Season.
     *
     * @param weatherCondition For example: "Cloudy, clear, partly cloudy, dry or wet. "
     * @param season For example: "Summer", "Autumn", "Summer", "Winter"
     * @return
     */

    public Accessories accessoriesToObject(String weatherCondition, String season) {
        Accessories accessories = null;
        ResultSet accessorySet = queryAccessories(weatherCondition, season);
        QuerySolution qs = null;
        if (accessorySet.hasNext()) {
            try {
                qs = accessorySet.nextSolution();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            accessories = new Accessories();
            accessories.setAccessory(qs.getLiteral("accessoryLabel").toString());
            accessories.setFitsCondition(qs.getLiteral("conditionLabel").toString());
            accessories.setFitsSeason(qs.getLiteral("seasonLabel").toString());
        }
        return accessories;
    }

}
