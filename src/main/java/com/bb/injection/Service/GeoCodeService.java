package com.bb.injection.Service;

import com.bb.injection.model.Address;
import com.bb.injection.model.TBBBuddyGroup;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ankit on 31/5/16.
 */
public class GeoCodeService {

    private  String getResponseFromService(String query)
            throws IOException {

        URL obj = new URL(query);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();

        return response.toString();

    }

    private TBBBuddyGroup getTbbBuddyGroupFromResponse(String jsonStr){
        TBBBuddyGroup tbbBuddyGroup=new TBBBuddyGroup();
        JSONObject JsonObject = new JSONObject(jsonStr);
        JSONArray resultJsonArray=  JsonObject.getJSONArray("results");
        if(resultJsonArray.isNull(0)){
            //TODO throw an exception
        }
        else{
            JSONObject resultJsonObj= (JSONObject) resultJsonArray.get(0);
            JSONObject locationJsonObj= resultJsonObj.getJSONObject("geometry").getJSONObject("location");
            tbbBuddyGroup.setLat(Double.parseDouble(locationJsonObj.get("lat").toString()));
            tbbBuddyGroup.setLng(Double.parseDouble(locationJsonObj.get("lng").toString()));
        }

        return tbbBuddyGroup;

    }


     public List<TBBBuddyGroup> getTBBGroupFromAddress(List<Address> addressList){
                return  addressList.stream().map(Address::getStrFromLocation).map(s -> {
                     try {
                         return getResponseFromService(s);
                     } catch (IOException e) {
                         e.printStackTrace();
                         return null;
                     }
                 }).map(s-> getTbbBuddyGroupFromResponse(s))
                 .collect(toList());
     }










    public static void main(String[] args){
 //       try{
//       String str= getResponseFromService("https://maps.googleapis.com/maps/api/geocode/json?address=Xebia%20India%20Gurgaon%20612%20Park%20Centra+Sector%2030+Gurgaon%20122002+Haryana+India");
//            System.out.println(str);
//            GeoCodeService geoCodeService=new GeoCodeService();
//            geoCodeService.getTbbBuddyGroupFromResponse(str);
//    }catch (IOException e){
//            e.printStackTrace();
//        }



    }

}
