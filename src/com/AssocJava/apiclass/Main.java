package com.AssocJava.apiclass;
import netscape.javascript.JSObject;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Main {

    public static void main(String[] args) {
        JSONObject importJo = new JSONObject();
        // putting data to JSONObject
        importJo.put("firstName", "John");
        importJo.put("lastName", "Smith");
        importJo.put("age", 25);
        System.out.println(importJo.toJSONString());

        //this string is the URL for all users in the dataset
        String allUsers = "https://bpdts-test-app.herokuapp.com/users";
        //this StringBuffer stores the data of all users
        StringBuffer outputString = ApiClass.getDataFromAPI(allUsers);
        //this string is the URL for all users that have London listed as their city
        String londonUsers = "https://bpdts-test-app.herokuapp.com/city/London/users";
        //this StringBuffer stores the data of the London based users
        StringBuffer londonOutputString = ApiClass.getDataFromAPI(londonUsers);

        //now that I have the data from the API in a StringBuffer, I need to organise it into an ArrayList to make data manipulation easier.
        ArrayList<Users> theUsersArray = new ArrayList<>();
        String newString = "";
        boolean addToWord = false;

        for(int i = 1; i<londonOutputString.length(); i++){

                if(londonOutputString.charAt(i) == '{'){
                    addToWord = true;
                }
                if(addToWord){
                    newString += londonOutputString.charAt(i);
                }
                if(londonOutputString.charAt(i) == '}'){
                    addToWord = false;
                    //we now have the string that contains one users data,
                    // //we next need to split it into it's sub-elements and add these into our ArrayList of users.
                    for(int j = 1; j<newString.length()-1; j++){
                        Users newUser = new Users();
                        boolean startWord = false;
                        String latitudeAsAString = "";
                        String longitudeAsAString = "";
                        int count = 0;
                        if(newString.charAt(j)==':'){
                            startWord = true;
                        }

                        if(newString.charAt(j)==','){
                            startWord = false;
                            count = count +1;
                        }

                        switch(count) {
                            case 0: newUser.id += newString.charAt(j);
                            case 1: newUser.first_name += newString.charAt(j);
                            case 2: newUser.last_name += newString.charAt(j);
                            case 3: newUser.email += newString.charAt(j);
                            case 4: newUser.ip_address += newString.charAt(j);
                            case 5: latitudeAsAString += newString.charAt(j);
                            case 6: longitudeAsAString += newString.charAt(j);
                        }
                            //System.out.print(newUser.first_name);
                            if (newString.charAt(j) == '}'){
                                System.out.println(latitudeAsAString);
                                //newUser.latitude = Integer.parseInt(latitudeAsAString);
                                //newUser.longitude = Integer.parseInt(longitudeAsAString);
                                theUsersArray.add(newUser);
                                newString = "";
                            }
                        }



                    }

                }

       System.out.println(outputString);
       // System.out.println(theUsersArray);
       System.out.println(newString);
       System.out.print(londonOutputString);

    }
}
