package com.AssocJava.apiclass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Main {

    public static void main(String[] args) {
        //JSONObject importJo = new JSONObject();
        // putting data to JSONObject
        //importJo.put("firstName", "John");
        //importJo.put("lastName", "Smith");
        //importJo.put("age", 25);
        //System.out.println(importJo.toJSONString());

        //this string is the URL for all users in the dataset
        String allUsers = "https://bpdts-test-app.herokuapp.com/users";
        //this StringBuffer stores the data of all users
        JSONArray allUserJA = ApiClass.getDataFromAPI(allUsers);
        //this string is the URL for all users that have London listed as their city
        String londonUsers = "https://bpdts-test-app.herokuapp.com/city/London/users";
        //this JSONArray stores the data of the London based users
        JSONArray londonUserJA = ApiClass.getDataFromAPI(londonUsers);
        System.out.println(londonUserJA.size());

        /**
         * upon testing several of the results, not only can users say they live in London and live elsewhere
         *
         * they can also live in other Londons, for example Tiffi Colberston (id = 688).
         * therefore I want to add users from our general allUser array to my LondonUsers Array
         */
        JSONArray additionJA = DistanceClass.closeToLondon(allUserJA);
        JSONArray postRemovalArray = DuplicatesClass.removeDuplicates(londonUserJA, additionJA);
        JSONArray finalArray = DuplicatesClass.addUsersPostDuplication(londonUserJA, postRemovalArray);

        //System.out.println(finalArray);
        System.out.println(finalArray.size());


    }
}
