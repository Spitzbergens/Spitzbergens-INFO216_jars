package YrData;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.apache.jena.rdf.model.ModelFactory.createDefaultModel;
import static org.apache.jena.rdf.model.ModelFactory.createOntologyModel;

public class YrModel {

    Yr yr = new Yr();
    Model model = createDefaultModel();


    private ArrayList<String> temp = yr.getTemprature();
    private ArrayList<String> windSpeedValue = yr.getWindSpeedValue();
    private ArrayList<String> windSpeedName = yr.getWindSpeedName();
    private ArrayList<String> weatherName = yr.getNametag();
    private ArrayList<String> date = yr.getFromtag();
    private ArrayList<String> observedAt = yr.getObservedTag();
    private ArrayList<String> precipitation = yr.getPrecipitation();
    private ArrayList<String> endTime = yr.getToPeriod();
    private ArrayList<String> dateTimeStart = yr.getTimeAndDateStart();
    private ArrayList<String> dateTimeEnd = yr.getTimeAndDateEnd();

    // Brukes kun for å hente størrelsen på listen
    private ArrayList<Integer> listSize = yr.getListSize();
    int size = listSize.size();


    /**
     * Creates an ontology Model from the model, and writing the model to a file.
     */

    public void writeToFile() {
        OntModel ontmodel = createOntologyModel(OntModelSpec.OWL_MEM, model);

        try {
            ontmodel.write(new FileOutputStream("weatherModel.ttl"), "Turtle");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Parsing and creating the model. Setting up prefixes to be used on the properties and the weather resource.
     * and gathering values from the ArrayLists specified in the field. Then creating the resource and adding properties
     * and literals.
     *
     * @return the model.
     */
    public Model createAndParseModel() {

        String ontoURI = "https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl#";
        model.setNsPrefix("wo", ontoURI);

        String schemaDate = "http://schema.org/Date#";
        model.setNsPrefix("schema", schemaDate);

        Property weatherProperty = model.createProperty(ontoURI + "hasWeatherCondition");
        Property tempProperty = model.createProperty(ontoURI + "hasTemperature");
        Property windSpeedProperty = model.createProperty(ontoURI + "windType");
        Property windSpeedValueProperty = model.createProperty(ontoURI + "hasWind");
        Property observedAtProperty = model.createProperty(ontoURI + "hasStartTime");
        Property dateProperty = model.createProperty(schemaDate + "inDateTime");
        Property precipitationProperty = model.createProperty(ontoURI + "hasPrecipitation");
        Property endsAtProperty = model.createProperty(ontoURI + "hasEndTime");
        Resource weatherResource = model.createResource(ontoURI + "WeatherCondition");


        for (int i = 0; i < size; i++) {

            Integer temperatureItem = Integer.parseInt(temp.get(i));
            String windSpeedNameItem = windSpeedName.get(i);
            Float windSpeedValueItem = Float.parseFloat(windSpeedValue.get(i));
            String weatherConditionItem = weatherName.get(i);
            String dateItem = date.get(i);
            String timeItem = observedAt.get(i);
            Double precipitationItem = Double.parseDouble(precipitation.get(i));
            String endTimeItem = endTime.get(i);
            String dateTimeStartItem = dateTimeStart.get(i);

            Resource weatherData = model.createResource(schemaDate + dateTimeStartItem, weatherResource)
                    .addLiteral(tempProperty, temperatureItem)
                    .addProperty(windSpeedProperty, windSpeedNameItem)
                    .addLiteral(windSpeedValueProperty, windSpeedValueItem)
                    .addProperty(weatherProperty, weatherConditionItem)
                    .addProperty(dateProperty, dateItem)
                    .addProperty(observedAtProperty, timeItem)
                    .addLiteral(precipitationProperty, precipitationItem)
                    .addProperty(endsAtProperty, endTimeItem);

        }
        return model;
    }

}
