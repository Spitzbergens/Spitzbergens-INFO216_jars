package Queries;

import Models.Weather;
import RDF.RDFController;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeatherQueries {

    public RDFController controller;
    public ArrayList<Weather> weatherList = new ArrayList<>();


    /**
     * Consturctor for creating a new RDFController
     *
     * @param controller the RDFController
     */
    public WeatherQueries(RDFController controller) {
        this.controller = controller;
    }

    /**
     * Querying weather by day, and filtering on date.
     * @return A resultset.
     */

    public ResultSet getWeatherByDay(String date) {
        String query = "SELECT DISTINCT ?startTime ?endTime ?temperature ?condition ?windSpeed ?windType ?precipitation ?dateTime\n" +
                "WHERE {\n" +
                "      ?conditions a we:WeatherCondition;\n" +
                "                  we:hasStartTime ?startTime;\n" +
                "                  we:hasEndTime ?endTime;\n" +
                "                  we:hasTemperature ?temperature;\n" +
                "                  we:hasWeatherCondition ?condition;\n" +
                "                  we:hasWind ?windSpeed;\n" +
                "                  we:windType ?windType;\n" +
                "                  schema:inDateTime ?dateTime.\n" +
                "  OPTIONAL {?conditions we:hasPrecipitation ?precipitation}\n" +
                "  FILTER (?dateTime = \"" + date + "\")" +
                "\n" +
                "            \n" +
                "} ORDER BY ?startTime";

        return controller.runQuery(query);
    }

    /**
     * Querying for dates and grouping them.
     * @return the resultset.
     */

    public ResultSet getWeatherDates() {
        String query = "SELECT DISTINCT ?datetime " +
                "WHERE { " +
                "?date a we:WeatherCondition; " +
                "schema:inDateTime ?datetime." +
                "} ORDER BY ?datetime";
        return controller.runQuery(query);
    }

    /**
     * Querying for weatherdates, and iterating through the ResultSet, getting the newest
     * dates and adding them to a list as an own weather-object.
     * @return The list of weatherObject
     */
    public List<Weather> getWeatherListWeek() {

        List<Weather> list = new LinkedList<>();
        ResultSet weekDates = getWeatherDates();
        while (weekDates.hasNext()) {
            QuerySolution qs = weekDates.nextSolution();
            Weather weather = queryToObject(qs.getLiteral("datetime").toString());
            list.add(weather);
        }
        return list;
    }

    /**
     * Quering for weather by day, and iterating through the resultset, and finally creating an object
     * from each query solution.
     * @param date Date for a day
     * @return
     */

    public Weather queryToObject(String date) {

        Weather weather = null;
        ResultSet weatherSet = getWeatherByDay(date);
        QuerySolution qs = null;
        if (weatherSet.hasNext()) {
            try {
                qs = weatherSet.nextSolution();

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            weather = new Weather();
            weather.setDateTimeStart(qs.getLiteral("startTime").toString());
            weather.setDateTimeEnd(qs.getLiteral("endTime").toString());
            weather.setTemperature(qs.getLiteral("temperature").getInt());
            weather.setWeatherType(qs.getLiteral("condition").toString());
            weather.setWindSpeed(qs.getLiteral("windSpeed").getFloat());
            weather.setWind(qs.getLiteral("windType").toString());
            weather.setDate(qs.getLiteral("dateTime").toString());
            if (qs.getLiteral("precipitation") != null) {
                weather.setPrecipitation(qs.getLiteral("precipitation").getDouble());
            } else {
                weather.setPrecipitation(0.0);
            }
        }
        return weather;
    }

}

