package com.ttc.polytechnicshiksha;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class PlacementListAdaptre extends ArrayAdapter<placement_Hero> {
    List<placement_Hero> heroList1;
    Context context;
    Button delete_btn;
    String Coll_name, Comp_name, Comp_add ;
    String insertid,weburl,compprofile,elicolleges,elibranches,passyear, gender,tenth, twelth, diploma,backpaper, designation;
    String pay, totalpost, residential,transport,food, otherfacility, recruitprocess, photodoc;
    String oridoc, resume, passportphoto, campusvenue, campusdate, campustime, contactinfo, otherinfo,regform,reason;
    LayoutInflater mInflater;
    //the layout resource file for the list items
    int resource;
    ListView listView;
    private CardView cardview6;

    public PlacementListAdaptre(Context context, int resource, List<placement_Hero> heroList1) {
        super(context, resource, heroList1);
        this.context = context;
        this.resource = resource;
        this.heroList1 = heroList1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        delete_btn = (Button)view.findViewById(R.id.delete_btn);
        TextView textViewCollegeName = (TextView)view.findViewById(R.id.tvcollegename);
        TextView textViewCompanyName = (TextView)view.findViewById(R.id.tvcompanyname);
        TextView textViewCompanyAdd = (TextView)view.findViewById(R.id.tvcompanyaddress);
        TextView textViewweburl = (TextView)view.findViewById(R.id.tvweburl);
        TextView  tvcompprofile= (TextView) view.findViewById(R.id.tvcompprofile);
        TextView  tveligiblecolleges= (TextView) view.findViewById(R.id.tveligiblecolleges);
        TextView  tveligiblebranches= (TextView) view.findViewById(R.id.tveligiblebranches);
        TextView  tvpassyear= (TextView) view.findViewById(R.id.tvpassyear);
        TextView  tvgender= (TextView) view.findViewById(R.id.tvgender);
        TextView  tvtenthpercent= (TextView) view.findViewById(R.id.tvtenthpercent);
        TextView  tvtwelthpercent= (TextView) view.findViewById(R.id.tvtwelthpercent);
        TextView  tvdiploma= (TextView) view.findViewById(R.id.tvdiploma);
        TextView  tvbackpaper= (TextView) view.findViewById(R.id.tvbackpaper);
        TextView  tvdesignation= (TextView) view.findViewById(R.id.tvdesignation);
        TextView  tvpay= (TextView) view.findViewById(R.id.tvpay);
        TextView  tvtotalpost= (TextView) view.findViewById(R.id.tvtotalpost);
        TextView  tvresidentialfacility= (TextView) view.findViewById(R.id.tvresidentialfacility);
        TextView  tvtransportfacility= (TextView) view.findViewById(R.id.tvtransportfacility);
        TextView  tvfoodfacility= (TextView) view.findViewById(R.id.tvfoodfacility);
        TextView  tvotherfacility= (TextView) view.findViewById(R.id.tvotherfacility);
        TextView  tvrecruitmentprocess= (TextView) view.findViewById(R.id.tvrecruitmentprocess);
        TextView  tvphotocopydocument= (TextView) view.findViewById(R.id.tvphotocopydocument);
        TextView  tvoriginaldocument= (TextView) view.findViewById(R.id.tvoriginaldocument);
        TextView  tvresume= (TextView) view.findViewById(R.id.tvresume);
        TextView  tvpassportphoto= (TextView) view.findViewById(R.id.tvpassportphoto);
        TextView  tvcampusvenue= (TextView) view.findViewById(R.id.tvcampusvenue);
        TextView  tvcampusdate= (TextView) view.findViewById(R.id.tvcampusdate);
        TextView  tvcampustime= (TextView) view.findViewById(R.id.tvcampustime);
        TextView  tvcontactinfo= (TextView) view.findViewById(R.id.tvcontactinfo);
        TextView  tvregform= (TextView) view.findViewById(R.id.tvregform);
        TextView  tvotherinfo= (TextView) view.findViewById(R.id.tvotherinfo);


        cardview6=(CardView)view.findViewById(R.id.card_view6);
        //getting the hero of the specified position
        final placement_Hero hero = heroList1.get(position);

        //adding values to the list item
        textViewCollegeName.setText(hero.getCollege_name());
        textViewCompanyName.setText("COMPANY NAME: "+hero.getCompany_name());
        textViewCompanyAdd.setText("COMPANY ADDRESS: "+hero.getCompany_address());
        textViewweburl.setText("Web Url: "+hero.getWeb_url());
        tvcompprofile.setText("COMPANY PROFILE: "+hero.getcompany_profile());
        tveligiblecolleges.setText("ELIGIBLE COLLEGES : "+hero.geteligible_colleges());
        tveligiblebranches.setText("ELIGIBLE BRANCHES : "+hero.geteligible_branches());
        tvpassyear.setText("PASS YEAR : "+hero.getpass_year());
        tvgender.setText("GENDER : "+hero.getgender());
        tvtenthpercent.setText("10TH % : "+hero.gettenth());
        tvtwelthpercent.setText("12TH % : "+hero.gettwelth());
        tvdiploma.setText("DIPLOMA % : "+hero.getdiploma());
        tvbackpaper.setText("BACK PAPER : "+hero.getbackpaper());
        tvdesignation.setText("DESIGNATION : "+hero.getdesignation());
        tvpay.setText("PAY PER MONTH : "+hero.getpay());
        tvtotalpost.setText("TOTAL POST : "+hero.gettotalpost());
        tvresidentialfacility.setText("RESIDENTIAL FACILITY : "+hero.getresidential());
        tvtransportfacility.setText("TRANSPORT FACILITY : "+hero.gettransport());
        tvfoodfacility.setText("FOOD FACILITY : "+hero.getfood());
        tvotherfacility.setText("OTHER FACILITY :- "+hero.getotherfacility());
        tvrecruitmentprocess.setText("RECRUITMENT PROCESS INCLUDES : "+hero.getrecruitprocess());
        tvphotocopydocument.setText("PHOTOCOPY OF DOCUMENT REQUIRED : "+hero.getphotodoc());
        tvoriginaldocument.setText("ORIGINAL DOCUMENT REQUIRED : "+hero.getoridoc());
        tvresume.setText("RESUME REQUIRED : "+hero.getresume());
        tvpassportphoto.setText("PASSPORT PHOTO REQUIRED : "+hero.getpassportphoto());
        tvcampusvenue.setText("CAMPUS VENUE : "+hero.getcampusvenue());
        tvcampusdate.setText("CAMPUS DATE : "+hero.getcampusdate());
        tvcampustime.setText("CAMPUS TIME : "+hero.getcampustime());
        tvcontactinfo.setText("CONTACT NUMBER FOR ANY QUERY : "+hero.getcontactinfo());
        tvregform.setText("REGISTRATION FORM : "+hero.getregform());
        tvotherinfo.setText("OTHER INFORMATION : "+hero.getotherinfo());
        insertid = hero.getinsert_id();



        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setPositiveButton("Submit",null)
                        .setNegativeButton("Cancel",null)
                        .create();
                mInflater = LayoutInflater.from(context);
                View dialog_layout = mInflater.inflate(R.layout.custom_dialog_layout, null);
                EditText input = (EditText) dialog_layout.findViewById(R.id.dialog_ed);
                TextView tv_input = (TextView) dialog_layout.findViewById(R.id.tv_dialog);
                tv_input.setVisibility(View.GONE);
                input.setHint("Enter Reason");
                alertDialog.setTitle("Please specify the reason of deleting the Campus Entry.");
                alertDialog.setView(dialog_layout);
                alertDialog.show();
                Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reason  = input.getText().toString();
                        if(TextUtils.isEmpty(input.getText().toString()))
                        {
                            tv_input.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            //Toast.makeText(context, "Reason is :"+reason, Toast.LENGTH_LONG).show();
                            alertDialog.dismiss();
                            insertid = hero.getinsert_id();
                            Coll_name = hero.getCollege_name();
                            Comp_name = hero.getCompany_name();
                            Comp_add = hero.getCompany_address();
                            weburl = hero.getWeb_url();
                            compprofile = hero.getcompany_profile();
                            elicolleges = hero.geteligible_colleges();
                            elibranches = hero.geteligible_branches();
                            passyear = hero.getpass_year();
                            gender = hero.getgender();
                            tenth = hero.gettenth();
                            twelth = hero.gettwelth();
                            diploma = hero.getdiploma();
                            backpaper = hero.getbackpaper();
                            designation = hero.getdesignation();
                            pay = hero.getpay();
                            totalpost = hero.gettotalpost();
                            residential = hero.getresidential();
                            transport = hero.gettransport();
                            food = hero.getfood();
                            otherfacility = hero.getotherfacility();
                            recruitprocess = hero.getrecruitprocess();
                            photodoc = hero.getphotodoc();
                            oridoc = hero.getoridoc();
                            resume = hero.getresume();
                            passportphoto = hero.getpassportphoto();
                            campusvenue = hero.getcampusvenue();
                            campusdate = hero.getcampusdate();
                            campustime = hero.getcampustime();
                            contactinfo = hero.getcontactinfo();
                            regform = hero.getregform();
                            otherinfo = hero.getotherinfo();


                            //Toast.makeText(context, "Button Pressed "+getItemId(position)+"\nCompany Name"+Comp_name, Toast.LENGTH_SHORT).show();
                            enviarPost(true);

                            Intent myIntent = new Intent(context, Dashboard_College.class);
                            myIntent.putExtra("College_Name", Coll_name);
                            context.startActivity(myIntent);

                        }

                    }
                });
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    alertDialog.dismiss();
                    }
                });
            }
        });

        return view;
    }
    private void enviarPost(boolean modo) {
        String URL="http://question.undoo.in/admin/User_api/cdelete";

        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
        requestParams.put("INSERT_ID",insertid);
        requestParams.put("COLLEGE_NAME",Coll_name);
        requestParams.put("COMPANY_NAME",Comp_name);
        requestParams.put("COMPANY_ADDRESS",Comp_add);
        requestParams.put("WEB_URL",weburl);
        requestParams.put("COMPANY_PROFILE",compprofile);
        requestParams.put("ELIGIBLE_COLLEGES",elicolleges);
        requestParams.put("ELIGIBLE_BRANCHES",elibranches);
        requestParams.put("PASS_YEAR",passyear);
        requestParams.put("GENDER",gender);
        requestParams.put("TENTH_PERCENTAGE",tenth);
        requestParams.put("TWELFTH_PERCENTAGE",twelth);
        requestParams.put("DIPLOMA_PERCENTAGE",diploma);
        requestParams.put("BACK_PAPER",backpaper);
        requestParams.put("DESIGNATION",designation);
        requestParams.put("PAY_PER_MONTH",pay);
        requestParams.put("TOTAL_POST",totalpost);
        requestParams.put("RESIDENTIAL_FACILITY",residential);
        requestParams.put("TRANSPORT_FACILITY",transport);
        requestParams.put("FOOD_FACILITY",food);
        requestParams.put("OTHER_FACILITY",otherfacility);
        requestParams.put("RECRUITMENT_PROCESS",recruitprocess);
        requestParams.put("PHOTO_DOCUMENT",photodoc);
        requestParams.put("ORIGINAL_DOCUMENT",oridoc);
        requestParams.put("RESUME",resume);
        requestParams.put("PASSPORT_PHOTO",passportphoto);
        requestParams.put("CAMPUS_VENUE",campusvenue);
        requestParams.put("CAMPUS_DATE",campusdate);
        requestParams.put("CAMPUS_TIME",campustime);
        requestParams.put("CONTACT_INFO",contactinfo);
        requestParams.put("REG_FORM",regform);
        requestParams.put("OTHER_INFO",otherinfo);
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
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.i("app", responseBody.toString());
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(context, "Error getting data from server", Toast.LENGTH_SHORT)
                        .show();

                Log.e("app", "User could not be created");
            }
        });
    }

}
