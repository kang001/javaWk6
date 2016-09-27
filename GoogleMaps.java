package com.Kara;

import com.google.maps.ElevationApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.ElevationResult;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

//What is the elevation of MCTC?
public class GoogleMaps {
    
    
    public static void main(String[] args) {

        String key = null;
        try(BufferedReader reader = new BufferedReader(new FileReader("key.txt"))){
            key = reader.readLine();
            System.out.println(key);
        } catch (Exception ioe){
            System.out.println("No key file found");
            System.exit(-1);
        }
        //todo create scanner to accept user input
        //todo call geocoding api to turn this api into a place

        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Please enter the address of a location");
        String nameOfLocation = stringScanner.nextLine();



        //elevation
        GeoApiContext context = new GeoApiContext().setApiKey(key);


        GeocodingResult[] locationLatLng;
        try {
             locationLatLng = GeocodingApi.geocode(context, nameOfLocation).await();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //todo get lat and lng into
        LatLng userLatLng = new LatLng(0,0);

        ElevationResult[] elevationResults = new ElevationResult[0];
        GeocodingResult[] codingResults = new GeocodingResult[0];

        

        try {
            elevationResults = ElevationApi.getByPoints(context, userLatLng).await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (elevationResults.length >= 1){
            ElevationResult locationElevation = elevationResults[0];
            System.out.println("The elevation of " + nameOfLocation +" above sea level is " + locationElevation.elevation + " meters");
            System.out.println(String.format("The elevation of MCTC above sea level is %.2f meters",locationElevation.elevation));
        }
        if (codingResults.length >= 1){
            GeocodingResult locationGeoCode = codingResults[1];
            System.out.println("The location Latitude and Longitude is " + locationGeoCode.geometry);
        }


    }
}
