package com.ttc.polytechnicshiksha;

import android.content.Intent;
import android.os.Bundle;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Dashboard_College extends AppCompatActivity {
    ListView list;
    TextView form;
    String College_Name;
    TextView tvcollege_name;
    String data1 = null;
    String data2 = null;
    List<placement_Hero> heroList1 = new ArrayList<>();
    ArrayAdapter<String> arr;
    PlacementListAdaptre customListAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard__college);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");

        list = (ListView) findViewById(R.id.placement_list);
        form = (TextView) findViewById(R.id.placement_form);
        tvcollege_name = (TextView)findViewById(R.id.College_Name);
        Bundle bundle = getIntent().getExtras();
        College_Name = bundle.getString("College_Name");
        tvcollege_name.setText(College_Name);

        customListAdapter1 = new PlacementListAdaptre(this, R.layout.placement_list_college,heroList1);
        list.setAdapter(customListAdapter1);
        customListAdapter1.notifyDataSetChanged();

        enviarPost(true);

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Dashboard_College.this,TPO_college.class);
                intent1.putExtra("College_Name",College_Name);
                startActivity(intent1);
            }
        });

    }



    private void enviarPost(boolean modo) {
        String URL="http://34.238.231.153/admin/User_api/cplalist";

        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
        requestParams.put("COLLEGE_NAME",College_Name);
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
                        JSONArray jsonArray=jsonObject.getJSONArray("Data");
                        System.out.println("length");
                        System.out.println(jsonArray.length());
                        for(int i=0;i<jsonArray.length();i++){
                            ArrayList<String> jsonCompanyName=new ArrayList<>();
                            ArrayList<String> jsonCompanyAddress=new ArrayList<>();
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            data1 = jsonObject1.getString("Company_Name");
                            data2 = jsonObject1.getString("Company_Address");
                            System.out.println("Hey");
                            System.out.println(data1);
                            System.out.println(data2);
                            heroList1.add(new placement_Hero(College_Name,data1,data2));
                            /*
                            if(!data1.isEmpty() && !data2.isEmpty()){
                                heroList1.add(new placement_Hero(College_Name,data1,data2));
                            }
                            */
                        }
                        list.setAdapter(customListAdapter1);
                        //ProgressBar p1=findViewById(R.id.p1);
                        //p1.setVisibility(View.INVISIBLE);
                        customListAdapter1.notifyDataSetChanged();
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