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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class preview_tpo extends AppCompatActivity {

    String collegename;
    String companyname;
    String companyaddress;
    Button btn_submit;
    Button btn_edit;
    String result = null;
    TextView tvexist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_tpo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("PREVIEW FORM");
        Bundle bundle = getIntent().getExtras();
        collegename = bundle.getString("collegename");
        companyname = bundle.getString("companyname");
        companyaddress = bundle.getString("companyaddress");

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_edit = (Button) findViewById(R.id.btn_edit);

        tvexist = (TextView) findViewById(R.id.pre_exist);
        tvexist.setVisibility(View.GONE);
        TextView tvcollegename = (TextView) findViewById(R.id.pre_collegename);
        TextView tvcompanyname = (TextView) findViewById(R.id.pre_companyname);
        TextView tvcompanyaddress = (TextView) findViewById(R.id.pre_companyaddress);

        tvcollegename.setText(collegename);
        tvcompanyname.setText("COMPANY NAME : "+companyname);
        tvcompanyaddress.setText("COMPANY ADDRESS : "+companyaddress);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enviarPost(true);
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void enviarPost(boolean modo) {
        String URL="http://34.238.231.153/admin/User_api/creg";

        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
        requestParams.put("COLLEGE_NAME",collegename);
        requestParams.put("COMPANY_NAME", companyname);
        requestParams.put("COMPANY_ADDRESS", companyaddress);
        requestParams.put("token_key", "AaShTaK@2020@WaterSupplY");


        clientSendPost.post(URL, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) { // I think success means always code 200
                    String res = null;
                    try
                    {
                        res = new String(responseBody, "UTF-8");
                        Log.e("----->",res);
                        JSONObject jsonObject=new JSONObject(res);

                        //JSONArray jsonArray2=jsonObject.getJSONArray("Data");
                        result=jsonObject.getString("Success");




                        if(result.equals("Exist"))
                        {
                            tvexist.setVisibility(View.VISIBLE);
                            tvexist.setText("Data Already Exist");
                            Log.e("result is  = ",result);

                        }
                        else
                        {
                            JSONArray jsonArray=jsonObject.getJSONArray("Data");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                String inserId=jsonObject1.getString("insertId");
                                Log.e("insert id value is  = ",inserId);
                                //tvexist.setVisibility(View.GONE);
                                Intent intent1 = new Intent(preview_tpo.this,Dashboard_College.class);
                                intent1.putExtra("College_Name",collegename);
                                startActivity(intent1);
                            }
                        }

                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getBaseContext(), "success data from server", Toast.LENGTH_SHORT)
                            .show();
                }
                Log.i("app", responseBody.toString());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getBaseContext(), "Error getting data from server", Toast.LENGTH_SHORT)
                        .show();

                Log.e("app", "User could not be created");
            }
        });
    }

}