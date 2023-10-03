package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    String insertid,weburl,cprofile,elicolleges,elibranches,passyear,gender,tenth,twelth,diploma,backpaper,designation,pay,totalpost;
    String residential,transport,food,otherfacility,recruitprocess,photodoc,oridoc,resume,passportphoto,campusvenue;
    String campusdate,campustime,contactinfo,otherinfo,regform,reason;
    TextView tvcollege_name;
    Button new_button, old_button;
    String data1 = null;
    String data2 = null;
    List<placement_Hero> heroList1 = new ArrayList<>();
    ArrayAdapter<String> arr;
    PlacementListAdaptre customListAdapter1;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard__college);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");

        list = (ListView) findViewById(R.id.placement_list);
        //form = (TextView) findViewById(R.id.placement_form);
        tvcollege_name = (TextView)findViewById(R.id.College_Name);
        new_button = (Button) findViewById(R.id.new_form_button);
        old_button = (Button) findViewById(R.id.old_form_button);
        Bundle bundle = getIntent().getExtras();
        College_Name = bundle.getString("College_Name");
        tvcollege_name.setText(College_Name);

        customListAdapter1 = new PlacementListAdaptre(this, R.layout.placement_list_college,heroList1);
        list.setAdapter(customListAdapter1);
        customListAdapter1.notifyDataSetChanged();

        tvcollege_name.setVisibility(View.VISIBLE);
        new_button.setVisibility(View.VISIBLE);
        old_button.setVisibility(View.VISIBLE);



        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Dashboard_College.this,TPO_college.class);
                intent1.putExtra("College_Name",College_Name);
                startActivity(intent1);
            }
        });
        old_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                enviarPost(true);
                tvcollege_name.setVisibility(View.GONE);
                new_button.setVisibility(View.GONE);
                old_button.setVisibility(View.GONE);

            }
        });


    }

    @Override
    public void onBackPressed()
    {
        if(i==1)
        {
            Intent intent1 = new Intent(Dashboard_College.this,Dashboard_College.class);
            intent1.putExtra("College_Name",College_Name);
            startActivity(intent1);
        }
        else if (i==0) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Logout")
                    .setMessage("Do you want to Log Out?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent1 = new Intent(Dashboard_College.this, login.class);
                            startActivity(intent1);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
        return;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard_college, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.logout) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Logout")
                    .setMessage("Are you sure you want to Log Out?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Intent intent1 = new Intent(Dashboard_College.this,login.class);
                            intent1.putExtra("College_Name",College_Name);
                            startActivity(intent1);
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void enviarPost(boolean modo) {
        String URL="http://question.undoo.in/admin/User_api/cplalist";
        //String URL="http://34.238.231.153/admin/User_api/cplalist";

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
                        for(int i=jsonArray.length()-1;i>=0;i--){
                            ArrayList<String> jsonCompanyName=new ArrayList<>();
                            ArrayList<String> jsonCompanyAddress=new ArrayList<>();
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            insertid = jsonObject1.getString("Insert_Id");
                            data1 = jsonObject1.getString("Company_Name");
                            data2 = jsonObject1.getString("Company_Address");
                            weburl = jsonObject1.getString("WEB_URL");
                            cprofile= jsonObject1.getString("COMPANY_PROFILE");
                            elicolleges= jsonObject1.getString("ELIGIBLE_COLLEGES");
                            elibranches= jsonObject1.getString("ELIGIBLE_BRANCHES");
                            passyear= jsonObject1.getString("PASS_YEAR");
                            gender= jsonObject1.getString("GENDER");
                            tenth= jsonObject1.getString("TENTH_PERCENTAGE");
                            twelth= jsonObject1.getString("TWELFTH_PERCENTAGE");
                            diploma= jsonObject1.getString("DIPLOMA_PERCENTAGE");
                            backpaper= jsonObject1.getString("BACK_PAPER");
                            designation= jsonObject1.getString("DESIGNATION");
                            pay= jsonObject1.getString("PAY_PER_MONTH");
                            totalpost= jsonObject1.getString("TOTAL_POST");
                            residential= jsonObject1.getString("RESIDENTIAL_FACILITY");
                            transport= jsonObject1.getString("TRANSPORT_FACILITY");
                            food= jsonObject1.getString("FOOD_FACILITY");
                            otherfacility= jsonObject1.getString("OTHER_FACILITY");
                            recruitprocess= jsonObject1.getString("RECRUITMENT_PROCESS");
                            photodoc= jsonObject1.getString("PHOTO_DOCUMENT");
                            oridoc= jsonObject1.getString("ORIGINAL_DOCUMENT");
                            resume= jsonObject1.getString("RESUME");
                            passportphoto= jsonObject1.getString("PASSPORT_PHOTO");
                            campusvenue= jsonObject1.getString("CAMPUS_VENUE");
                            campusdate= jsonObject1.getString("CAMPUS_DATE");
                            campustime= jsonObject1.getString("CAMPUS_TIME");
                            contactinfo= jsonObject1.getString("CONTACT_INFO");
                            regform= jsonObject1.getString("REG_FORM");
                            otherinfo= jsonObject1.getString("OTHER_INFO");
                            reason= jsonObject1.getString("REASON_DELETE");
                            System.out.println("Hey");
                            System.out.println(data1);
                            System.out.println(regform);
                            heroList1.add(new placement_Hero(insertid,College_Name,data1,data2,weburl,cprofile,elicolleges,elibranches,passyear,gender,tenth, twelth, diploma,backpaper, designation, pay, totalpost, residential, transport,food, otherfacility, recruitprocess, photodoc, oridoc, resume, passportphoto, campusvenue, campusdate, campustime, contactinfo, regform, otherinfo,reason));
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
                    /*
                    Toast.makeText(getBaseContext(), "success data from server", Toast.LENGTH_SHORT)
                            .show();
                     */
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