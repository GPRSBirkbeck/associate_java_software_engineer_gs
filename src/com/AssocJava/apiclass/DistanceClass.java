package com.AssocJava.apiclass;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DistanceClass {


    public static double haversineDistance(JSONObject inputUser, double distanceUnit, double londonLatitude, double londonLongitude){
        JSONObject currentJo = inputUser;
        double earthRadiusKilometers = distanceUnit;


        double ldnlatitude = londonLatitude;
        double ldnLongitude = londonLongitude;
        double currentLat = Double.parseDouble(currentJo.get("latitude").toString());
        double currentLong = Double.parseDouble(currentJo.get("longitude").toString());

        /**
         * to measure the distance between two points using lat/long values, several approaches are possible.
         * I have considered the earth spherical, and have applied the "haversine formula".
         *(more on the haversine formula can be found here: https://en.wikipedia.org/wiki/Haversine_formula)
         *One source provides an easy definition for this:
         * Distance, d = 3963.0 * arccos[(sin(lat1) * sin(lat2)) + cos(lat1) * cos(lat2) * cos(long2 – long1)]
         * we start by converting latlengs to radians:
         * Java has a simple toRadians formula I have used for this.
         */

        double londonLatRadian = Math.toRadians(ldnlatitude);
        double londonLongRadian = Math.toRadians(ldnLongitude);

        double currentLatRadian = Math.toRadians(currentLat);
        double currentLongRadian = Math.toRadians(currentLong);

        double deltaLong = (londonLongRadian-currentLongRadian);

        double distanceToLondon = earthRadiusKilometers* Math.acos((Math.sin(currentLatRadian)*Math.sin(londonLatRadian))+Math.cos(currentLatRadian)*Math.cos(londonLatRadian)*Math.cos(deltaLong));

        return distanceToLondon;
    }

    /**
     * the method below is used to calculate distance between users from allUser array and a fixed point
     * for this fixed point, I have created a variable, and I compare the distance between that variable and our LatLeng
     */
    public static JSONArray closeToLondon(JSONArray inputJA){

        double earthRadiusKilometres = 6371;
        double earthRadiusMiles = 3963;
        double londonLatitude = 51.5074;
        double londonLongitude = 0.1278;

        JSONArray inputJA1 = inputJA;
        JSONArray outputJA = new JSONArray();

        for(int i = 0; i<inputJA1.size();i++){
            JSONObject currentJo = (JSONObject) (inputJA1.get(i));
            double yourMiles = DistanceClass.haversineDistance(currentJo, earthRadiusMiles, londonLatitude, londonLongitude);

            if(yourMiles<=3963){
                outputJA.add(currentJo);
            }
        }
        return outputJA;
    }
}

