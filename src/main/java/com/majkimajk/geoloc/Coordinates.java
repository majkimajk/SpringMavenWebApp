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

public class Coordinates {
	
	private final String apiKey = "AIzaSyBiBfgpBtHxApijl__mW0SRI0m8aJmhJWg";
    private final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?";
    
    
    private StringBuilder sb = new StringBuilder();
    private String addressUrl = "";
    private String outcome;
    private String street = "";
    private String city = "";
    private String country = "";
    
    
	public String getStreet() {
		return street;
	
		
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressUrl() {
		StringBuilder sb = new StringBuilder();
		if(!street.isEmpty()) {
			String[] str = street.split(" ");
			for(String s : str){
				sb.append(s).append("+");
			}
			sb.deleteCharAt(sb.length()-1).append(",");
		}
		if(!city.isEmpty()) {
			String[] str = city.split(" ");
			for(String s : str){
				sb.append(s).append("+");
			}
			sb.deleteCharAt(sb.length()-1).append(",");
		}
		
		if(!country.isEmpty()) {
			String[] str = country.split(" ");
			for(String s : str){
				sb.append(s).append("+");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		
		addressUrl = sb.toString();
		return addressUrl;
	}
    
	public String getCoordinates(String adressUrl) {
//        System.out.println(adressUrl);
        String url = baseUrl +"address=" + adressUrl + "&key=" + apiKey;

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
            //System.out.println(res.getString("formatted_address"));
            JSONObject loc =
                    res.getJSONObject("geometry").getJSONObject("location");
            outcome = "Lattitude: " + loc.getDouble("lat") +
                    ", Longitude: " + loc.getDouble("lng");
            //System.out.println("lat: " + loc.getDouble("lat") +
                   // ", lng: " + loc.getDouble("lng"));




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
