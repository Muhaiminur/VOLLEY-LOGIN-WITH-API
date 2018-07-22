package com.itclanbd.loginwithapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Region extends AppCompatActivity {
    JSONArray relist;
    TextView tk;
    String t;
    String finaltoken;
    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    Button region;
    // Creating Progress dialog.
    ProgressDialog progressDialog;

    private ListView lv;
    // Storing server url into String variable.
    String HttpUrl = "http://sajeeb.anagona.com/api/regions";
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);

        lv = (ListView) findViewById(R.id.list);
        // Receiving value into activity using intent.
        String TempHolder = getIntent().getStringExtra("Token");
        tk=(TextView)findViewById(R.id.ftk);
        t="Bearer "+TempHolder;
        tk.setText(t);
        // Assigning ID's to Button.
        region = (Button) findViewById(R.id.reg);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(Region.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(Region.this);

        // Adding click listener to button.
        region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //regionfind(t);


                //
                jsonArray=getarray(t);
                ArrayList<JSONObject> listItems=getArrayListFromJSONArray(jsonArray);
                ListAdapter adapter=new ListAdapter(Region.this,R.layout.list_item,R.id.yes,listItems);

                lv.setAdapter(adapter);
            }
        });
    }
    public void regionfind(String token) {

        finaltoken=token;
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        //

                        //

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        try {
                            progressDialog.dismiss();
                            JSONObject jsonObject = new JSONObject(ServerResponse);
                            JSONArray relist = jsonObject.getJSONArray("all_regions");
                            ArrayList<String> items = new ArrayList<String>();
                            for(int i=0; i < relist.length() ; i++) {
                                JSONObject json_data = relist.getJSONObject(i);
                                int id=json_data.getInt("id");
                                String name=json_data.getString("name");
                                items.add(name);
                                Log.d(name,"Output");
                            }
                            if(jsonObject.names().get(0).equals("all_regions")){
                                String n=jsonObject.getString("all_regions");
                                Toast.makeText(getApplicationContext(),"SUCCESS "+n,Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getApplicationContext(), "Error" +jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                    }
                }) {

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", finaltoken);
                return params;
            }

            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Region.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }
    //array
    public JSONArray getarray(String token) {


        finaltoken=token;
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        //

                        //

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        try {
                            progressDialog.dismiss();
                            JSONObject jsonObject = new JSONObject(ServerResponse);
                            relist = jsonObject.getJSONArray("all_regions");

                            ArrayList<String> items = new ArrayList<String>();
                            for(int i=0; i < relist.length() ; i++) {
                                JSONObject json_data = relist.getJSONObject(i);
                                int id=json_data.getInt("id");
                                String name=json_data.getString("name");
                                items.add(name);
                                Log.d(name,"Output");
                            }
                            /*
                            if(jsonObject.names().get(0).equals("all_regions")){
                                String n=jsonObject.getString("all_regions");
                                Toast.makeText(getApplicationContext(),"SUCCESS "+n,Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getApplicationContext(), "Error" +jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                    }
                }) {

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", finaltoken);
                return params;
            }

            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Region.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

        return relist;
    }
    //
    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){

        ArrayList<JSONObject> aList=new ArrayList<JSONObject>();

        try {

            if (jsonArray != null) {

                for (int i = 0; i < jsonArray.length(); i++) {

                    aList.add(jsonArray.getJSONObject(i));

                }

            }

        }catch (JSONException je){je.printStackTrace();}

        return  aList;

    }
}
