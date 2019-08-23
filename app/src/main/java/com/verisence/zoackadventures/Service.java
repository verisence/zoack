package com.verisence.zoackadventures;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Service {

    public static void findDestinations(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.DESTINATIONS_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Destinations> processResults(Response response) {
        ArrayList<Destinations> destinations = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray destinationsJSON = jsonObject.getJSONArray("destinations");
            if (response.isSuccessful()) {
                for (int i = 0; i < destinationsJSON.length(); i++) {
                    JSONObject destinationJSON = destinationsJSON.getJSONObject(i);
                    String name = destinationJSON.getString("name");
                    String description = destinationJSON.getString("description");
                    String photo = destinationJSON.getString("photo");
                    String location = destinationJSON.getString("location");
                    String itinerary = destinationJSON.getString("itinerary");

                    Destinations destination = new Destinations(name, description, photo, location, itinerary);
                    destinations.add(destination);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return destinations;

    }
}