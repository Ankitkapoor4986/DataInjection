package com.bb.injection.Service;

import com.bb.injection.constants.Constants;
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
import java.util.Optional;

/**
 * Created by ankit on 31/5/16.
 */
public class GeoCodeService {

    private static GeoCodeService geoCodeService=new GeoCodeService();
    private static TBBBuddyGroupService tbbBuddyGroupService =TBBBuddyGroupService.getInstance();

    public static GeoCodeService getInstance(){
        return geoCodeService;
    }
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

    private Optional<TBBBuddyGroup> getTbbBuddyGroupFromResponse(String jsonStr, Address address){
        TBBBuddyGroup tbbBuddyGroup=new TBBBuddyGroup();
        JSONObject JsonObject = new JSONObject(jsonStr);
        JSONArray resultJsonArray=  JsonObject.getJSONArray("results");
        if(resultJsonArray.isNull(0)){
            return Optional.empty();
        }
        else{
            JSONObject resultJsonObj= (JSONObject) resultJsonArray.get(0);
            JSONObject locationJsonObj= resultJsonObj.getJSONObject("geometry").getJSONObject("location");
            tbbBuddyGroup.setLat(Double.parseDouble(locationJsonObj.get("lat").toString()));
            tbbBuddyGroup.setLng(Double.parseDouble(locationJsonObj.get("lng").toString()));
        }
        tbbBuddyGroup.setUser(address.getUser());

        return Optional.ofNullable(tbbBuddyGroup);

    }


     public void getTBBGroupFromAddress(List<Address> addressList){

         boolean exceptionOccured=false;
         int exceptionCount=0;
         for (int iterator = 0; (iterator < addressList.size()) && (!exceptionOccured ||
                 (exceptionCount <= Constants.NO_OF_EXCEPTION_ALLOWED)); iterator++) {
             Address address=addressList.get(iterator);
             String apiString=address.getApiStrFromLocation();
             System.out.println("*********API String is **************");
             System.out.println(apiString);
             System.out.print(address);

             try {
                String jsonStr= getResponseFromService(apiString);
                 System.out.println("JSON STR IS");
                 System.out.println(jsonStr);
                Optional<TBBBuddyGroup> tbbGroup= getTbbBuddyGroupFromResponse(jsonStr,address );
                 if (!tbbGroup.equals(Optional.empty())){
                     tbbBuddyGroupService.insert(tbbGroup.get());
                 }

             } catch (IOException e) {
                 exceptionCount++;
                 e.printStackTrace();
                 exceptionOccured=true;

             }
         }





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
