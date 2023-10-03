package com.ttc.polytechnicshiksha;

import static android.view.View.GONE;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class CampusListAdapter extends ArrayAdapter<placement_Hero> {
    List<placement_Hero> heroList1;
    Context context;
    String Coll_name, Comp_name, Comp_add ;
    String title;


    //the layout resource file for the list items
    int resource;
    private CardView cardview6;

    public CampusListAdapter(Context context, int resource, List<placement_Hero> heroList1) {
        super(context, resource, heroList1);
        this.context = context;
        this.resource = resource;
        this.heroList1 = heroList1;
    }

    public CampusListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
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

        TextView textViewCollegeName = (TextView)view.findViewById(R.id.tvcollegename);
        TextView textViewCompanyName = (TextView)view.findViewById(R.id.tvcompanyname);
        TextView textViewCompanyAdd = (TextView)view.findViewById(R.id.tvcompanyaddress);
        TextView  tvweburl= (TextView) view.findViewById(R.id.tvweburl);
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

        LinearLayout layout_rec_proces = (LinearLayout) view.findViewById(R.id.layout_recruitment_process);

        cardview6=(CardView)view.findViewById(R.id.card_view6);
        //getting the hero of the specified position
        final placement_Hero hero = heroList1.get(position);

        //adding values to the list item
        textViewCollegeName.setText(hero.getCollege_name());
        textViewCompanyName.setText(Html.fromHtml("<font color= #AE0321>COMPANY NAME : </font>"+hero.getCompany_name()));
        textViewCompanyAdd.setText(Html.fromHtml("<font color= #AE0321>COMPANY ADDRESS : </font>"+hero.getCompany_address()));
        tvweburl.setText(Html.fromHtml("<font color= #AE0321>Web Url: </font>"+hero.getWeb_url()));
        tvcompprofile.setText(Html.fromHtml("<font color= #AE0321>COMPANY PROFILE: </font>"+hero.getcompany_profile()));
        tveligiblecolleges.setText(Html.fromHtml("<font color= #AE0321>ELIGIBLE COLLEGES : </font>"+hero.geteligible_colleges()));
        tveligiblebranches.setText(Html.fromHtml("<font color= #AE0321>ELIGIBLE BRANCHES : </font>"+hero.geteligible_branches()));
        tvpassyear.setText(Html.fromHtml("<font color= #AE0321>PASSING YEAR : </font>"+hero.getpass_year()));
        tvgender.setText(Html.fromHtml("<font color= #AE0321>GENDER : </font>"+hero.getgender()));
        tvtenthpercent.setText(Html.fromHtml("<font color= #AE0321>10TH % : </font>"+hero.gettenth()));
        tvtwelthpercent.setText(Html.fromHtml("<font color= #AE0321>12TH % : </font>"+hero.gettwelth()));
        tvdiploma.setText(Html.fromHtml("<font color= #AE0321>DIPLOMA % : </font>"+hero.getdiploma()));
        tvbackpaper.setText(Html.fromHtml("<font color= #AE0321>BACK PAPER : </font>"+hero.getbackpaper()));
        tvdesignation.setText(Html.fromHtml("<font color= #AE0321>DESIGNATION : </font>"+hero.getdesignation()));
        tvpay.setText(Html.fromHtml("<font color= #AE0321>SALARY : </font>"+hero.getpay()));
        tvtotalpost.setText(Html.fromHtml("<font color= #AE0321>TOTAL POST : </font>"+hero.gettotalpost()));
        tvresidentialfacility.setText(Html.fromHtml("<font color= #AE0321>RESIDENTIAL FACILITY : </font>"+hero.getresidential()));
        tvtransportfacility.setText(Html.fromHtml("<font color= #AE0321>TRANSPORT FACILITY : </font>"+hero.gettransport()));
        tvfoodfacility.setText(Html.fromHtml("<font color= #AE0321>FOOD FACILITY : </font>"+hero.getfood()));
        tvotherfacility.setText(Html.fromHtml("<font color= #AE0321>OTHER FACILITY : </font>"+hero.getotherfacility()));
        tvrecruitmentprocess.setText(Html.fromHtml("<font color= #AE0321>RECRUITMENT PROCESS INCLUDES : </font>"+hero.getrecruitprocess()));
        tvphotocopydocument.setText(Html.fromHtml("<font color= #AE0321>DOCUMENT REQUIRED : </font>"+hero.getphotodoc()));
        tvoriginaldocument.setText(Html.fromHtml("<font color= #AE0321>ORIGINAL DOCUMENT REQUIRED : </font>"+hero.getoridoc()));
        tvresume.setText(Html.fromHtml("<font color= #AE0321>RESUME REQUIRED : </font>"+hero.getresume()));
        tvpassportphoto.setText(Html.fromHtml("<font color= #AE0321>PASSPORT PHOTO REQUIRED : </font>"+hero.getpassportphoto()));
        tvcampusvenue.setText(Html.fromHtml("<font color= #AE0321>VENUE : </font>"+hero.getcampusvenue()));
        tvcampusdate.setText(Html.fromHtml("<font color= #AE0321>REPORTING DATE : </font>"+hero.getcampusdate()));
        tvcampustime.setText(Html.fromHtml("<font color= #AE0321>REPORTING TIME : </font>"+hero.getcampustime()));
        tvcontactinfo.setText(Html.fromHtml("<font color= #AE0321>CONTACT NUMBER FOR ANY QUERY : </font>"+hero.getcontactinfo()));
        tvregform.setText(Html.fromHtml("<font color= #AE0321>REGISTRATION FORM : </font>"+hero.getregform()));
        tvotherinfo.setText(Html.fromHtml("<font color= #AE0321>OTHER INFORMATION : </font>"+hero.getotherinfo()));

        if(hero.getCompany_address().isEmpty())
        {
            textViewCompanyAdd.setVisibility(view.GONE);
        }
        if(hero.getWeb_url().isEmpty())
        {
            tvweburl.setVisibility(GONE);
        }
        if(hero.geteligible_colleges().isEmpty())
        {
            tveligiblecolleges.setVisibility(GONE);
        }
        if(hero.gettenth().isEmpty())
        {
            tvtenthpercent.setVisibility(GONE);
        }
        if(hero.gettwelth().isEmpty())
        {
            tvtwelthpercent.setVisibility(GONE);
        }
        if(hero.getdiploma().isEmpty())
        {
            tvdiploma.setVisibility(GONE);
        }
        if(hero.getbackpaper().isEmpty())
        {
            tvbackpaper.setVisibility(GONE);
        }
        if(hero.getresidential().isEmpty())
        {
            tvresidentialfacility.setVisibility(GONE);
        }
        if(hero.gettransport().isEmpty())
        {
            tvtransportfacility.setVisibility(GONE);
        }
        if(hero.getfood().isEmpty())
        {
            tvfoodfacility.setVisibility(GONE);
        }
        if(hero.getotherfacility().isEmpty())
        {
            tvotherfacility.setVisibility(GONE);
        }
        if(hero.getrecruitprocess().isEmpty())
        {
            tvrecruitmentprocess.setVisibility(GONE);
        }
        if(hero.getphotodoc().isEmpty())
        {
            tvphotocopydocument.setVisibility(GONE);
        }
        if(hero.getoridoc().isEmpty())
        {
            tvoriginaldocument.setVisibility(GONE);
        }
        if(hero.getresume().isEmpty())
        {
            tvresume.setVisibility(GONE);
        }
        if(hero.getpassportphoto().isEmpty())
        {
            tvpassportphoto.setVisibility(GONE);
        }
        if(hero.getrecruitprocess().isEmpty() && hero.getphotodoc().isEmpty() && hero.getphotodoc().isEmpty() && hero.getoridoc().isEmpty() && hero.getresume().isEmpty() && hero.getpassportphoto().isEmpty())
        {
            layout_rec_proces.setVisibility(GONE);
        }

        if(hero.getcontactinfo().isEmpty())
        {
            tvcontactinfo.setVisibility(GONE);
        }
        if(hero.getotherinfo().isEmpty())
        {
            tvotherinfo.setVisibility(GONE);
        }
        if(hero.getregform().isEmpty())
        {
            tvregform.setVisibility(GONE);
        }

        return view;

    }


}
