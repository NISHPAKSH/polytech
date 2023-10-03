package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.ttc.polytechnicshiksha.databinding.ActivityCampusPlacementBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class campus_placement extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCampusPlacementBinding binding;
    ListView campus_list;
    TextView Tv_Message;
    String url, title;
    String data1 = null;
    String data2 = null;
    String data3 = null;
    String insertid,weburl,cprofile,elicolleges,elibranches,passyear,gender,tenth,twelth,diploma,backpaper,designation,pay,totalpost;
    String residential,transport,food,otherfacility,recruitprocess,photodoc,oridoc,resume,passportphoto,campusvenue;
    String campusdate,campustime,contactinfo,regform,otherinfo,reason;
    List<placement_Hero> heroList1 = new ArrayList<>();
    CampusListAdapter customListAdapter2;
    ProgressBar p3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCampusPlacementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        setTitle("Campus Detail");

        Tv_Message = (TextView) findViewById(R.id.tv_message);

        p3=findViewById(R.id.progressBar);
        p3.setVisibility(View.VISIBLE);
        Tv_Message.setVisibility(View.GONE);
        campus_list = (ListView) findViewById(R.id.campus_list);
        customListAdapter2 = new CampusListAdapter(this, R.layout.campus_list_student,heroList1);
        campus_list.setAdapter(customListAdapter2);
        customListAdapter2.notifyDataSetChanged();

        enviarPost(true);





    }
    private void enviarPost(boolean modo) {
        String URL="http://question.undoo.in/admin/User_api/campuslist";

        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
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
                        String message = jsonObject.getString("Message");;
                        System.out.println("Message received is : "+message);

                        if(message.equals("Data Not Found"))
                        {
                            Tv_Message.setVisibility(View.VISIBLE);
                        }
                        else if(message.equals("Data Found"))
                        {
                            JSONArray jsonArray=jsonObject.getJSONArray("Data");
                            Tv_Message.setVisibility(View.GONE);
                            for(int i=jsonArray.length()-1;i>=0;i--){
                                ArrayList<String> jsonCompanyName=new ArrayList<>();
                                ArrayList<String> jsonCompanyAddress=new ArrayList<>();
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                insertid = jsonObject1.getString("Insert_Id");
                                data1 = jsonObject1.getString("College_Name");
                                data2 = jsonObject1.getString("Company_Name");
                                data3 = jsonObject1.getString("Company_Address");
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
                                heroList1.add(new placement_Hero(insertid,data1,data2,data3,weburl,cprofile,elicolleges,elibranches,passyear,gender,tenth, twelth, diploma,backpaper, designation, pay, totalpost, residential, transport,food, otherfacility, recruitprocess, photodoc, oridoc, resume, passportphoto, campusvenue, campusdate, campustime,contactinfo,regform,otherinfo,reason));
                            }

                                campus_list.setAdapter(customListAdapter2);
                                customListAdapter2.notifyDataSetChanged();


                        }
                        p3.setVisibility(View.GONE);
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getBaseContext(), "success data from server", Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            startActivity(new Intent(campus_placement.this, MainActivity.class));
            return true;
        }
        if (id == R.id.login)
        {
            startActivity(new Intent(campus_placement.this,login.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(campus_placement.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(campus_placement.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(campus_placement.this,WebViewActivity.class);
            web.putExtra("url",url);
            web.putExtra("title",title);
            startActivity(web);
        }
        if (id == R.id.exit) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Closing Activity")
                    .setMessage("Are you sure you want to close this activity?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }
        if (id == R.id.contact_us) {
            startActivity(new Intent(campus_placement.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(campus_placement.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}