package com.AssocJava.apiclass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {


        //using java.net library I can make a HTTP request to get the data from the API.

        //for a lot of this I need try and catch's, as seen by error message:
        try{
            URL inboundURL = new URL("https://bpdts-test-app.herokuapp.com/instructions");

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
            StringBuffer content = new StringBuffer();
            //below we keep taking input until there's no more input to take in
            while ((inputText = inputStuff.readLine()) != null){
                content.append(inputText);
            }
            inputStuff.close();

            myConnection.disconnect();

            System.out.print(content);


        }
        catch (MalformedURLException inbURL){
            System.out.print("error with my URL - bad URL type");
        }
        catch(IOException ioExc){
            System.out.print("IO exception kicked off");
        }



    }

}
