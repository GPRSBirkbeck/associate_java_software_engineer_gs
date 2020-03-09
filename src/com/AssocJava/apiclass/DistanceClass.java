package com.AssocJava.apiclass;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DistanceClass {
    /**
     * the method below is used to calculate distance between users from allUser array and a fixed point
     * for this fixed point, I have created a variable, and I compare the distance between that variable and our LatLeng
     */

    public static JSONArray closeToLondon(JSONArray inputJA){

        JSONArray inputJA1 = inputJA;
        JSONArray outputJA = new JSONArray();

        for(int i = 0; i<5;i++){
            JSONObject currentJo = (JSONObject) (inputJA1.get(i));

            double londonLatitude = 51.5074;
            double londonLongitude = 0.1278;

            Double currentLat = Double.valueOf(currentJo.get("latitude").toString());
            Double currentLong = Double.valueOf(currentJo.get("longitude").toString());

            /**
             * to measure the distance between two points using lat/long values, several approaches are possible.
             * I have considered the earth spherical, and have applied the "haversine formula".
             *(more on the haversine formula can be found here: https://en.wikipedia.org/wiki/Haversine_formula)
             *One source provides an easy definition for this:
             * Distance, d = 3963.0 * arccos[(sin(lat1) * sin(lat2)) + cos(lat1) * cos(lat2) * cos(long2 – long1)]
             * we start by converting latlengs to radians:
             * Java has a simple toRadians formula I have used for this.
             */
            //double londonLatRadian = Math.toRadians(londonLatitude);
            //double londonLongRadian = Math.toRadians(londonLongitude);

            //double currentLatRadian = Math.toRadians(currentLat);
            //double currentLongRadian = Math.toRadians(currentLong);

            double londonLatRadian = Math.toRadians(53.31861111111111);
            double londonLongRadian = Math.toRadians(-1.6997222222222223);

            double currentLatRadian = Math.toRadians(53.32055555555556);
            double currentLongRadian = Math.toRadians(-1.7297222222222221);

            //we will need radius of earth for our Haversine formula
            //double earthRadius = 3956;

            double earthRadius = 6371;

            //now we need the difference between our longRadians
            double deltaLong = londonLongRadian-currentLongRadian;
            double deltaLat = londonLatRadian-currentLatRadian;
            //and now to get our result in miles we apply the haversine formula

            //L1 = current L2 = London

            double a = Math.pow(Math.sin(deltaLat / 2), 2)
                    + Math.cos(currentLatRadian) * Math.cos(londonLatRadian)
                    * Math.pow(Math.sin(deltaLong / 2),2);

            double c = 2 * Math.asin(Math.sqrt(a));

            // Radius of earth in kilometers. Use 3956
            // for miles
            //double r = 3956;
            double r = 6371;


            // calculate the result
            double otherMiles = (c * r);


            double yourMiles = earthRadius* Math.acos((Math.sin(currentLatRadian)*Math.sin(londonLatRadian))+Math.cos(currentLatRadian)*Math.cos(londonLatRadian)*Math.cos(deltaLong));
            System.out.println(otherMiles);
            System.out.println(yourMiles);
            if(yourMiles<=50){
                outputJA.add(currentJo);
                //System.out.println(currentJo);
            }
        }

        return outputJA;

    }
}

