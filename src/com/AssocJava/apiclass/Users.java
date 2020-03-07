package com.AssocJava.apiclass;

public class Users {
    int id;
    String first_name;
    String last_name;
    String email;
    String ip_address;
    double latitude;
    double longitude;

    //Users(int id, String first_name, String last_name, String email, String ip_address, double latitude, double longitude){
     //   this.id = id;
      //  this.first_name = first_name;
     //   this.last_name = last_name;
    //    this.email = email;
    //    this.ip_address = ip_address;
    //    this.latitude = latitude;
    //    this.longitude = longitude;
    //}
    Users() {
        this.id = 0;
        this.first_name = "";
        this.last_name = "";
        this.email = "";
        this.ip_address = "";
        this.latitude = 0;
        this.longitude = 0;
    }

}
