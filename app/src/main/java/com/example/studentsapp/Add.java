package com.example.studentsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Add extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    AppCompatButton b1;
    String apiUrl = https://courseapplogix.onrender.com/addstudents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ed1=(EditText) findViewById(R.id.fname);
        ed1=(EditText) findViewById(R.id.lname);
        ed3=(EditText) findViewById(R.id.clg);
        ed4=(EditText) findViewById(R.id.dob);
        ed5=(EditText) findViewById(R.id.course);
        ed6=(EditText) findViewById(R.id.mob);
        ed7=(EditText) findViewById(R.id.email);
        ed8=(EditText) findViewById(R.id.addrs);
        b1=(AppCompatButton) findViewById(R.id.sub);
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getFname=ed1.getText().toString();
                String getLname=ed2.getText().toString();
                String getClg=ed3.getText().toString();
                String getDob=ed4.getText().toString();
                String getCourse=ed5.getText().toString();
                String getMob=ed6.getText().toString();
                String getEmail=ed7.getText().toString();
                String getAddrs=ed8.getText().toString();

                JSONObject student=new JSONObject();
                try {
                    student.put("firstname",getFname);
                    student.put("lastname",getLname);
                    student.put("college",getClg);
                    student.put("dob",getDob);
                    student.put("course",getCourse);
                    student.put("mobile",getMob);
                    student.put("email",getEmail);
                    student.put("address",getAddrs);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                //
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "added successfully", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
                            }
                        }
                );
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}