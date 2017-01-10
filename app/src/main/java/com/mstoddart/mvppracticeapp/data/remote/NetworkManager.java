package com.mstoddart.mvppracticeapp.data.remote;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public class NetworkManager {

    //Be sure to add the volley gradle dependancy: compile 'com.android.volley:volley:1.0.0'
    //These methods can be called using NetworkManager.getInstance().exampleGetRequest(.....);

    private static final String TAG = "NetworkManager";
    private static NetworkManager instance = null;

    public RequestQueue requestQueue;

    private NetworkManager(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized NetworkManager getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkManager(context);
        }
        return instance;
    }

    public static synchronized NetworkManager getInstance() {
        if (null == instance) {
            throw new IllegalStateException(NetworkManager.class.getSimpleName() +
                    " is not initialized, call getInstance(...) first");
        }
        return instance;
    }

    //This method can be adapted to be used however needed for example swapping GET for POST, supplying a json object as the body instead of an empty new JsonObject();
    public void exampleGetRequest(String URL, final VolleySingletonListener<JSONObject> listener, final VolleySingletonErrorListener errorListener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onResult(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                errorListener.onErrorResult(error);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
