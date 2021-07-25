package com.gerard.gestion_de_contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Activity_Login extends AppCompatActivity {

    EditText userId, id, title, completed;
    Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // userId = (EditText) findViewById(R.id.userId);
        //id = (EditText) findViewById(R.id.id);
        //title = (EditText) findViewById(R.id.title);
        //completed = (EditText) findViewById(R.id.completed);
        //btn_ingresar = (Button) findViewById(R.id.btn_ingresar);

        //btn_ingresar.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
                //LeerWebs();
            //}
        //});
        FragmentManager fManager = getSupportFragmentManager();
        fManager.beginTransaction().replace(R.id.Contenedor_Login, new login_Fragment()).commit();

    }


    /*public void irRegistro(View view){

        Intent intent = new Intent(Activity_Login.this, Registro.class);
        startActivity(intent);
    }*/

    /*private void LeerWebs (){
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        StringRequest postStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    userId.setText(jsonObject.getString("userId"));
                    id.setText(jsonObject.getString("id"));
                    title.setText(jsonObject.getString("title"));
                    completed.setText(jsonObject.getString("completed"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Activity_Login.this, "No se pudo mejor surte para la proxima", Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(this).add(postStringRequest);
    }*/
}