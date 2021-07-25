package com.gerard.gestion_de_contactos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class login_Fragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;

    EditText Et_User,Et_contraseña;

    Button btn_ingresar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       //return inflater.inflate(R.layout.fragment_login_, container, false);

        View view = inflater.inflate(R.layout.fragment_login_, container, false);
        Et_User = (EditText) view.findViewById(R.id.User);
        Et_contraseña = (EditText) view.findViewById(R.id.pwd);
        btn_ingresar = (Button) view.findViewById(R.id.btn_ingresar);

        rq = Volley.newRequestQueue(getContext());

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciarSecion();

            }
        });

        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se ha encontrado el usuario" + error.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        User usuario = new User();
        Toast.makeText(getContext(), "Se ha encontrado el usuario" + Et_User.getText().toString(), Toast.LENGTH_LONG).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObjectsonObj = null;

        try {
            jsonObjectsonObj = jsonArray.getJSONObject(0);

            usuario.setUser(jsonObjectsonObj.optString("user"));
            usuario.setUser(jsonObjectsonObj.optString("pwd"));
            usuario.setUser(jsonObjectsonObj.optString("names"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void iniciarSecion(){

        String url = "http://192.168.1.65/login/sesion.php?user="+Et_User.getText().toString()+"&pwd="+Et_contraseña.getText().toString();
        //String url = "https://casebook-chemical.000webhostapp.com/login/sesion.php?user="+Et_User.getText().toString()+"&pwd="+Et_contraseña.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }
}