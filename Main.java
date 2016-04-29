package com.Amber;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.*;

/**
 * Created by Amber on 4/28/2016.
 */

class Forecast
{
    private String name;
    private List<Double> forecast;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Double> getForecast() {
//        return forecast;
//    }
//
//    public void setForecast(List<Double> forecast) {
//        this.forecast = forecast;
//    }

    @Override
    public String toString()
    {
        List<String> forecastStrings = new ArrayList<>();
        for(Double temp: forecast)
        {
            forecastStrings.add(temp.toString());
        }
        String forecastString = String.join(", ", forecastStrings);
        return String.format("The forecast for %s: is %s", name, forecastString);
    }
}

class ForecastCollection extends ArrayList<Forecast>
{

}
public class Main {
    public static void main (String[] args)
    {
        String jsonData = "[{\"name\": \"columbus\", \"forecast\": [40, 50, 65, 60, 70]},"
                + "{\"name\": \"cleveland\", \"forecast\": [35, 55, 60, 45, 65]},"
                + "{\"name\": \"cincinnati\", \"forecast\": [35, 60, 65, 45, 65]}]";

//        JsonParser parser = new JsonParser();
//        Forecast forecast = new Forecast();
//
//        JsonObject jsonObject = parser.parse(jsonData).getAsJsonObject();
//
//        for(Map.Entry<String, JsonElement> entry:jsonObject.entrySet())
//        {
//            if(entry.getValue().isJsonArray())
//            {
//                JsonArray jsonArray = entry.getValue().getAsJsonArray();
//                List<Double> temps = new ArrayList<>();
//
//                for(JsonElement element: jsonArray)
//                {
//                    temps.add(element.getAsDouble());
//                }
//                forecast.setForecast(temps);
//            }
//            else
//            {
//                forecast.setName(entry.getValue().getAsString());
//            }
//
//        }
//        System.out.println(forecast);

        Gson gson = new Gson();
        ForecastCollection forecasts = gson.fromJson(jsonData, ForecastCollection.class);
        for(Forecast forecast: forecasts)
        {
            System.out.println(forecast);
        }
        String reserialized = gson.toJson(forecasts);
        System.out.println(reserialized);
    }
}
