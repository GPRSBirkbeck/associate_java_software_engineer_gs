package com.AssocJava.apiclass;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;



public class ApiClass {

    public static JSONArray getDataFromAPI(String myURL){

        StringBuffer content = new StringBuffer();
        JSONArray myExportJo = new JSONArray();

        //below I am using java.net library to make a HTTP request for the data from the API.
        try{

            URL inboundURL = new URL(myURL);

            HttpURLConnection myConnection = (HttpURLConnection) inboundURL.openConnection();


            //here I set the request method to get.
            myConnection.setRequestMethod("GET");

            //i need to set timeout values below:
            //these values both represent ten seconds
            myConnection.setConnectTimeout(10000);
            myConnection.setReadTimeout(10000);

            //the response code for swagger should be 200 if happy:
            int responseStatus = myConnection.getResponseCode();

            Reader streamReader = null;

            //now let's get the response of the request, and place in a string to be printed
            BufferedReader inputStuff = new BufferedReader(
                    new InputStreamReader(myConnection.getInputStream())
            );
            String inputText;
            //below we keep taking input until there's no more input to take in
            while ((inputText = inputStuff.readLine()) != null){
                content.append(inputText);
            }
            inputStuff.close();

            myConnection.disconnect();

            Object holderObject = new JSONParser().parse(String.valueOf(content));
            myExportJo = (JSONArray) holderObject;

            return myExportJo;
        }
        catch (MalformedURLException inbURL){
            System.out.print("error with my URL - bad URL type");
        }
        catch(IOException ioExc){
            System.out.print("IO exception kicked off");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return myExportJo;

    }


}

