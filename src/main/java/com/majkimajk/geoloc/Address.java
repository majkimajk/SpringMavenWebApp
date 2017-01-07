package com.majkimajk.geoloc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class Address {
	
	private final String apiKey = "AIzaSyBiBfgpBtHxApijl__mW0SRI0m8aJmhJWg";
    private final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?";
    
    
    
    private String lattitude;
    private String longitude;
    private String addressUrl = "";
    private String outcome;
    
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getAdressUrl() {
		
		addressUrl = lattitude + "," + longitude;
		return addressUrl;
	}
	
	public String getFinalAddress(String finalAddressUrl) {
		
		String url = baseUrl +"latlng=" + finalAddressUrl + "&key=" + apiKey;
   
        HttpGet get = new HttpGet(url);

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse response = httpClient.execute(get);
//            System.out.println(response.getStatusLine().getStatusCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            String resultString = result.toString();
            //System.out.println(result);
            JSONObject obj = new JSONObject(resultString);


            JSONObject res = obj.getJSONArray("results").getJSONObject(0);
            outcome = res.getString("formatted_address");
           // System.out.println(res.getString("formatted_address"));



        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return outcome;
	}
	
	
    
    
    

}
