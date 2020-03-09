package com.AssocJava.apiclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceClassTest {
    @Test
    public void distanceTest(){
        double londonLatRadian = Math.toRadians(53.31861111111111);
        double londonLongRadian = Math.toRadians(-1.6997222222222223);

        double currentLatRadian = Math.toRadians(53.32055555555556);
        double currentLongRadian = Math.toRadians(-1.7297222222222221);

            String a = "Hi", b = " there";
            String c = "Hi there";

            assertEquals(a+b, c);


    }

}