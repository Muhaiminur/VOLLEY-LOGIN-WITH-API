package com.itclanbd.loginwithapi;

/**
 * Created by User on 3/6/2018.
 */

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<JSONObject>{

    int vg;

    ArrayList<JSONObject> list;

    Context context;
    RadioButton r;

    public ListAdapter(Context context, int vg, int id, ArrayList<JSONObject> list){

        super(context,vg, id,list);

        this.context=context;

        this.vg=vg;

        this.list=list;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(vg, parent, false);

        //TextView txtId=(TextView)itemView.findViewById(R.id.idc);

        //TextView txtName=(TextView)itemView.findViewById(R.id.name);
        RadioButton r=(RadioButton)itemView.findViewById(R.id.yes);

        try {

//            txtId.setText(list.get(position).getString("id"));

            r.setText(list.get(position).getString("name"));



        } catch (JSONException e) {

            e.printStackTrace();

        }

        /*// perform setOnCheckedChangeListener event on yes button
        r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
// set Yes values in ArrayList if RadioButton is checked
                if (isChecked){
                    Log.d("PAISI","lol");

                }

            }
        });*/

        /*r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selected != null) {
                    selected.setChecked(false);
                }
                selected = holder.radioButton;
            }
        });
*/

        return itemView;

    }

}