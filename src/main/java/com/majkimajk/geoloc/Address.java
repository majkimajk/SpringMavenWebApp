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
	private String finalAddress;
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

	public String getFinalAddress() {

		try {

			finalAddress = getSmallerVersionOfJSONObject().getString("formatted_address");
			

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
		
			e.printStackTrace();
		}

		return finalAddress;
	}

	private JSONObject getSmallerVersionOfJSONObject()
			throws UnsupportedOperationException, ClientProtocolException, JSONException, IOException {

		return createJSONObjectFromResponse().getJSONArray("results").getJSONObject(0);
	}

	private JSONObject createJSONObjectFromResponse()
			throws UnsupportedOperationException, ClientProtocolException, JSONException, IOException {

		return new JSONObject(getHttpResponseInString());
	}

	private String getHttpResponseInString()
			throws UnsupportedOperationException, ClientProtocolException, IOException {
		
		return getResultStringBuffer(createBufferedReader())
				.toString();

	}
	
	private StringBuffer getResultStringBuffer(BufferedReader br) throws IOException{
		String line;
		StringBuffer result = new StringBuffer();
		while ((line = br.readLine()) != null) {
			result.append(line);
		}
		
		return result;
	}

	private BufferedReader createBufferedReader()
			throws UnsupportedOperationException, ClientProtocolException, IOException {

		return new BufferedReader(createInputStreamReader());
	}

	private InputStreamReader createInputStreamReader()
			throws UnsupportedOperationException, ClientProtocolException, IOException {

		return new InputStreamReader(createCloseableHttpResponse().getEntity().getContent());
	}

	private CloseableHttpResponse createCloseableHttpResponse() throws ClientProtocolException, IOException {

		return createCloseableHttpClient().execute(createHttpGet());
	}

	private CloseableHttpClient createCloseableHttpClient() {

		return HttpClientBuilder.create().build();

	}

	private HttpGet createHttpGet() {

		return new HttpGet(createUrlForHttpRequest());

	}

	private String createUrlForHttpRequest() {

		return baseUrl + "latlng=" + lattitude + "," + longitude + "&key=" + apiKey;

	}

}
