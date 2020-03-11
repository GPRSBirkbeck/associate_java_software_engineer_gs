package com.AssocJava.apiclass;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DuplicatesClass {
    public static JSONArray removeDuplicates(JSONArray londonArray, JSONArray additionArray){

        System.out.println(additionArray.size());
        JSONArray removalJA = new JSONArray();


        for(int i = 0; i<additionArray.size(); i++){
            JSONObject additionJo = (JSONObject) (additionArray.get(i));
            int addJoId = Integer.parseInt(additionJo.get("id").toString());
            for(int j = 0; j<londonArray.size(); j++){
                JSONObject londonJo = (JSONObject) (londonArray.get(j));
                int lonJoId = Integer.parseInt(londonJo.get("id").toString());
                if(addJoId == lonJoId){
                    removalJA.add(additionJo);
                }
            }
        }
        additionArray.remove(removalJA);
        System.out.println(removalJA.size());

        return additionArray;
    }

    public static JSONArray addUsersPostDuplication(JSONArray londonArray, JSONArray postRemovalArray){
        for(int i = 0; i<postRemovalArray.size(); i++){
            JSONObject additionJo = (JSONObject) (postRemovalArray.get(i));
            londonArray.add(additionJo);
        }
        return londonArray;

    }

}
