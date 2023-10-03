package com.ttc.polytechnicshiksha;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TPO_college extends AppCompatActivity {

    Button Button_TPO;
    EditText Company_Name, Company_Address;
    TextView College_name_view;
    String College_name;
    String COMPANY_NAME;
    String COMPANY_ADDRESS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_college);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Placement Form");

        College_name_view = (TextView)findViewById(R.id.TPO_College_Name);
        Bundle bundle = getIntent().getExtras();
        College_name = bundle.getString("College_Name");
        College_name_view.setText(College_name);

        Button_TPO = (Button) findViewById(R.id.button_tpo);
        Company_Name = (EditText) findViewById(R.id.company_name);
        Company_Address = (EditText) findViewById(R.id.company_addresss);

        Button_TPO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                COMPANY_NAME = Company_Name.getText().toString();
                COMPANY_ADDRESS = Company_Address.getText().toString();
                //Toast.makeText(getBaseContext(), "Username:\t"+username + "\nPassword:\t"+password, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(), preview_tpo.class);
                intent.putExtra("collegename",College_name);
                intent.putExtra("companyname",COMPANY_NAME);
                intent.putExtra("companyaddress",COMPANY_ADDRESS);
                v.getContext().startActivity(intent);
            }
        });
    }


}