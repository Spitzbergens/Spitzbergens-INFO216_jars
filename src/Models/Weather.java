package Models;

public class Weather {

    private Integer temperature;
    private Float windSpeed;
    private String wind;
    private String weatherType;
    private String dateTimeStart;
    private String dateTimeEnd;
    private String date;
    private Double precipitation;

    /**
     * Constructor creating for a weather condition object
     *
     * @param temperature   a temperature
     * @param windSpeed     a windspeed
     * @param wind          a type of wind
     * @param weatherType   a weather condition
     * @param dateTimeStart the start time of a weather conidtion
     * @param dateTimeEnd   a end time of a weather condition
     * @param date          a date in which a weather condition occcurs.
     * @param precipitation the amount of precipitation
     */

    public Weather(Integer temperature, Float windSpeed, String wind, String weatherType, String dateTimeStart, String dateTimeEnd, String date, Double
            precipitation) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.wind = wind;
        this.weatherType = weatherType;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.date = date;
        this.precipitation = precipitation;


    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Weather() {

    }

    /**
     * Getters and setters for the Weather model
     */

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTime) {
        this.dateTimeStart = dateTime;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }


}
