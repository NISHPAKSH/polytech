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

    String collegename,companyname,companyaddress,weburl,compprofile,eligiblecolleges,eligiblebranches,passyear,gender,tenthpercent;
    String twelthpercent,diploma,backpaper,designation,pay,totalpost,residentialfacility,transportfacility,foodfacility;
    String otherfacility,recruitmentprocess,photocopydocument,originaldocument,resume,passportphoto,campusvenue;
    String campusdate,campustime,contactinfo,otherinfo,reason,regform;
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
        weburl= bundle.getString("weburl");
        compprofile= bundle.getString("compprofile");
        eligiblecolleges= bundle.getString("eligiblecolleges");
        eligiblebranches= bundle.getString("eligiblebranches");
        passyear= bundle.getString("passyear");
        gender= bundle.getString("gender");
        tenthpercent= bundle.getString("tenthpercent");
        twelthpercent= bundle.getString("twelthpercent");
        diploma= bundle.getString("diploma");
        backpaper = bundle.getString("backpaper");
        designation = bundle.getString("designation");
        pay= bundle.getString("pay");
        totalpost= bundle.getString("totalpost");
        residentialfacility= bundle.getString("residentialfacility");
        transportfacility= bundle.getString("transportfacility");
        foodfacility= bundle.getString("foodfacility");
        otherfacility= bundle.getString("otherfacility");
        recruitmentprocess= bundle.getString("recruitmentprocess");
        photocopydocument= bundle.getString("photocopydocument");
        originaldocument= bundle.getString("originaldocument");
        resume= bundle.getString("resume");
        passportphoto= bundle.getString("passportphoto");
        campusvenue= bundle.getString("campusvenue");
        campusdate= bundle.getString("campusdate");
        campustime= bundle.getString("campustime");
        contactinfo= bundle.getString("contactinfo");
        regform= bundle.getString("regform");
        otherinfo= bundle.getString("otherinfo");

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        tvexist = (TextView) findViewById(R.id.pre_exist);
        tvexist.setVisibility(View.GONE);

        TextView tvcollegename = (TextView) findViewById(R.id.pre_collegename);
        TextView tvcompanyname = (TextView) findViewById(R.id.pre_companyname);
        TextView tvcompanyaddress = (TextView) findViewById(R.id.pre_companyaddress);
        TextView  tvweburl= (TextView) findViewById(R.id.pre_url);
        TextView  tvcompprofile= (TextView) findViewById(R.id.pre_profile);
        TextView  tveligiblecolleges= (TextView) findViewById(R.id.pre_elicolleges);
        TextView  tveligiblebranches= (TextView) findViewById(R.id.pre_elibranches);
        TextView  tvpassyear= (TextView) findViewById(R.id.pre_passyear);
        TextView  tvgender= (TextView) findViewById(R.id.pre_gender);
        TextView  tvtenthpercent= (TextView) findViewById(R.id.pre_tenthperc);
        TextView  tvtwelthpercent= (TextView) findViewById(R.id.pre_twelthperc);
        TextView  tvdiploma= (TextView) findViewById(R.id.pre_diplomaperc);
        TextView  tvbackpaper= (TextView) findViewById(R.id.pre_backpaper);
        TextView  tvdesignation= (TextView) findViewById(R.id.pre_designation);
        TextView  tvpay= (TextView) findViewById(R.id.pre_pay);
        TextView  tvtotalpost= (TextView) findViewById(R.id.pre_totalpost);
        TextView  tvresidentialfacility= (TextView) findViewById(R.id.pre_resident);
        TextView  tvtransportfacility= (TextView) findViewById(R.id.pre_transport);
        TextView  tvfoodfacility= (TextView) findViewById(R.id.pre_food);
        TextView  tvotherfacility= (TextView) findViewById(R.id.pre_othfacility);
        TextView  tvrecruitmentprocess= (TextView) findViewById(R.id.pre_recruit_process);
        TextView  tvphotocopydocument= (TextView) findViewById(R.id.pre_photodoc);
        TextView  tvoriginaldocument= (TextView) findViewById(R.id.pre_oridoc);
        TextView  tvresume= (TextView) findViewById(R.id.pre_resume);
        TextView  tvpassportphoto= (TextView) findViewById(R.id.pre_passport_photo);
        TextView  tvcampusvenue= (TextView) findViewById(R.id.pre_campus_venue);
        TextView  tvcampusdate= (TextView) findViewById(R.id.pre_campus_date);
        TextView  tvcampustime= (TextView) findViewById(R.id.pre_campus_time);
        TextView  tvcontactinfo= (TextView) findViewById(R.id.pre_contact_info);
        TextView  tvregform= (TextView) findViewById(R.id.pre_reg_form);
        TextView  tvotherinfo= (TextView) findViewById(R.id.pre_other_info);

        tvcollegename.setText(collegename);
        tvcompanyname.setText("COMPANY NAME : "+companyname);
        tvcompanyaddress.setText("COMPANY ADDRESS : "+companyaddress);
        tvweburl.setText("Web URL : "+weburl);
        tvcompprofile.setText("Company Profile : "+compprofile);
        tveligiblecolleges.setText("Eligible Colleges : "+eligiblecolleges);
        tveligiblebranches.setText("Eligible Branches : "+eligiblebranches);
        tvpassyear.setText("Passing Year : "+passyear);
        tvgender.setText("Gender : "+gender);
        tvtenthpercent.setText("10th % Required : "+tenthpercent);
        tvtwelthpercent.setText("12th % Required : "+twelthpercent);
        tvdiploma.setText("Diploma % Required : "+diploma);
        tvbackpaper.setText("Back Paper Allowed : "+backpaper);
        tvdesignation.setText("Designation : "+designation);
        tvpay.setText("Salary Package : "+pay);
        tvtotalpost.setText("Total Post : "+totalpost);
        tvresidentialfacility.setText("Residential Facility : "+residentialfacility);
        tvtransportfacility.setText("Transport Facility : "+transportfacility);
        tvfoodfacility.setText("Food Facility : "+foodfacility);
        tvotherfacility.setText("Other Facility Given : "+otherfacility);
        tvrecruitmentprocess.setText("Recruitment Process : "+recruitmentprocess);
        tvphotocopydocument.setText("Photocopy of Document Required : "+photocopydocument);
        tvoriginaldocument.setText("Original Document Required : "+originaldocument);
        tvresume.setText("Resume Required : "+resume);
        tvpassportphoto.setText("Passport Photo Required : "+passportphoto);
        tvcampusvenue.setText("Campus Venue : "+campusvenue);
        tvcampusdate.setText("Campus Date : "+campusdate);
        tvcampustime.setText("Campus Time : "+campustime);
        tvcontactinfo.setText("Contact Number for any Query : "+contactinfo);
        tvregform.setText("Registration Form Link : "+otherinfo);
        tvotherinfo.setText("Other Information : "+otherinfo);
        reason = "";


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
        String URL="http://question.undoo.in/admin/User_api/creg";
        //String URL="http://34.238.231.153/admin/User_api/creg";
        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
        requestParams.put("COLLEGE_NAME",collegename);
        requestParams.put("COMPANY_NAME", companyname);
        requestParams.put("COMPANY_ADDRESS", companyaddress);
        requestParams.put("WEB_URL",weburl);
        requestParams.put("COMPANY_PROFILE",compprofile);
        requestParams.put("ELIGIBLE_COLLEGES",eligiblecolleges);
        requestParams.put("ELIGIBLE_BRANCHES",eligiblebranches);
        requestParams.put("PASS_YEAR",passyear);
        requestParams.put("GENDER",gender);
        requestParams.put("TENTH_PERCENTAGE",tenthpercent);
        requestParams.put("TWELFTH_PERCENTAGE",twelthpercent);
        requestParams.put("DIPLOMA_PERCENTAGE",diploma);
        requestParams.put("BACK_PAPER",backpaper);
        requestParams.put("DESIGNATION",designation);
        requestParams.put("PAY_PER_MONTH",pay);
        requestParams.put("TOTAL_POST",totalpost);
        requestParams.put("RESIDENTIAL_FACILITY",residentialfacility);
        requestParams.put("TRANSPORT_FACILITY",transportfacility);
        requestParams.put("FOOD_FACILITY",foodfacility);
        requestParams.put("OTHER_FACILITY",otherfacility);
        requestParams.put("RECRUITMENT_PROCESS",recruitmentprocess);
        requestParams.put("PHOTO_DOCUMENT",photocopydocument);
        requestParams.put("ORIGINAL_DOCUMENT",originaldocument);
        requestParams.put("RESUME",resume);
        requestParams.put("PASSPORT_PHOTO",passportphoto);
        requestParams.put("CAMPUS_VENUE",campusvenue);
        requestParams.put("CAMPUS_DATE",campusdate);
        requestParams.put("CAMPUS_TIME",campustime);
        requestParams.put("CONTACT_INFO",contactinfo);
        requestParams.put("OTHER_INFO",otherinfo);
        requestParams.put("REG_FORM",regform);
        requestParams.put("REASON_DELETE",reason);

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
                                String inserId=jsonObject1.getString("InsertId");
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