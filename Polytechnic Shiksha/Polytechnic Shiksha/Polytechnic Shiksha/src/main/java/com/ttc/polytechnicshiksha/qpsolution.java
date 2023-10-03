package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class qpsolution extends AppCompatActivity {
    public static String url;
    public static String title;
    String item7;
    String item8;
    String item9;
    String item10;

    private Button qpsolbtn ;

    List<String> yearlist = new ArrayList<String>();
    List<String> branchlist = new ArrayList<>();
    List<String> pyearlist = new ArrayList<>();

    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<String> secondAdapter ;
    ArrayAdapter<String> thirdAdapter ;
    ArrayAdapter<String> forthAdapter ;

    WebView webview_qpsol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qpsolution);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Old QP Solution");

        qpsolbtn = (Button) findViewById(R.id.buttonqp);

        webview_qpsol = (WebView) findViewById(R.id.webview_qpsol);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_qpsol_course);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_qpsol_year);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_qpsol_branch);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner_qpsol_pyear);

        adapter = ArrayAdapter.createFromResource(this,R.array.labmanual_array, R.layout.simple_spinner_item11);
        secondAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, yearlist);
        thirdAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, branchlist);
        forthAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, pyearlist);

        spinner2.setEnabled(false);
        spinner3.setEnabled(false);
        spinner4.setEnabled(false);

        qpsolbtn.setEnabled(false);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item7 = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + item7, Toast.LENGTH_LONG).show();
                if (item7.matches("Engineering"))
                {
                    spinner2.setEnabled(true);
                    yearlist.clear();
                    yearlist.add("Select Year");
                    yearlist.add("First Year");
                    yearlist.add("Second Year");
                    yearlist.add("Third Year");
                    qpsolbtn.setEnabled(false);
                }
                else if (item7.matches("Non-Engineering"))
                {
                    spinner2.setEnabled(true);
                    yearlist.clear();
                    yearlist.add("Select Year");
                    yearlist.add("First Year");
                    yearlist.add("Second Year");
                    yearlist.add("Third Year");
                    qpsolbtn.setEnabled(false);
                }
                else
                {
                    yearlist.clear();
                    branchlist.clear();
                    pyearlist.clear();

                    yearlist.add("Select Year");
                    branchlist.add("Select Branch");
                    pyearlist.add("Select QP Solution for year");

                    secondAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();

                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);

                    qpsolbtn.setEnabled(false);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner.setAdapter(adapter);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item8 = parent.getItemAtPosition(position).toString();
                if (item8.matches("First Year"))
                {
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Subject");

                    pyearlist.clear();
                    pyearlist.add("Select QP Solution for year");

                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    spinner4.setEnabled(false);
                    branchlist.add("101 ENGLISH AND COMMUNICATION SKILLS");
                    branchlist.add("102 APPLIED PHYSICS");
                    branchlist.add("103 APPLIED CHEMISTRY");
                    branchlist.add("104 APPLIED MATHEMATICS");
                    branchlist.add("105 COMPUTER AND IT FUNDAMENTALS");
                    branchlist.add("106 APPLIED MECHANICS");
                    qpsolbtn.setEnabled(false);
                }
                else if (item8.matches("Second Year"))
                {
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Subject");

                    pyearlist.clear();
                    pyearlist.add("Select QP Solution for year");

                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    spinner4.setEnabled(false);

                    branchlist.add("CIVIL ENGINEERING");
                    branchlist.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist.add("ELECTRONICS ENGINEERING");
                    branchlist.add("ELECTRICAL ENGINEERING");
                    branchlist.add("MECHANICAL ENGINEERING");
                    qpsolbtn.setEnabled(false);
                }
                else if (item8.matches("Third Year"))
                {
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Subject");

                    pyearlist.clear();
                    pyearlist.add("Select QP Solution for year");

                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    spinner4.setEnabled(false);

                    branchlist.add("CIVIL ENGINEERING");
                    branchlist.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist.add("ELECTRONICS ENGINEERING");
                    branchlist.add("ELECTRICAL ENGINEERING");
                    branchlist.add("MECHANICAL ENGINEERING");
                    qpsolbtn.setEnabled(false);
                }
                else
                {
                    branchlist.clear();
                    pyearlist.clear();

                    branchlist.add("Select Branch");
                    pyearlist.add("Select QP Solution for year");

                    secondAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();

                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);

                    qpsolbtn.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        secondAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner2.setAdapter(secondAdapter);


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                item9 = parent.getItemAtPosition(position).toString();

                if((branchlist.contains("" +item9)) && (!item9.matches("Select Branch")) && (!item9.matches("Select Subject")))
                {
                    spinner4.setEnabled(true);
                    pyearlist.clear();
                    pyearlist.add("Select QP Solution for year");
                    forthAdapter.notifyDataSetChanged();
                    pyearlist.add("2015");
                    pyearlist.add("2016");
                    pyearlist.add("2017");
                    pyearlist.add("2018");
                    pyearlist.add("2019");
                    qpsolbtn.setEnabled(false);
                }
                else
                {
                    pyearlist.clear();

                    pyearlist.add("Select QP Solution for year");

                    secondAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();

                    spinner4.setEnabled(false);

                    qpsolbtn.setEnabled(false);
                }
                }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        thirdAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner3.setAdapter(thirdAdapter);


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item10 = parent.getItemAtPosition(position).toString();
                if((pyearlist.contains(""+item10)) && !item10.matches("Select QP Solution for year"))
                {
                    qpsolbtn.setEnabled(true);
                }
                else
                {
                    secondAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    qpsolbtn.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        forthAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner4.setAdapter(forthAdapter);

        qpsolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(item7.matches("Engineering"))
                {
                    if (item8.matches("First Year"))
                    {
                        if (item9.matches("101 ENGLISH AND COMMUNICATION SKILLS"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1fXtt-YKKOT1zuRW_9E_lK1oBEik1eyVu");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/101uhgOdOgqFJP0lH2p_NO_xitcOTfld1");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1eG3oAKMiL3A7q5qOj7fMqcWBr49lF23z");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/150myhv3GS5Se_ef1SbFe7UFXjeZprDlz");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1AsW7_U78jVoNE8jTH0GENUekZGbad3Dl");
                            }

                        }
                        else if (item9.matches("102 APPLIED PHYSICS"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/140bZf6-n28otzjCyqHzD8HJ31BB58HWu");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1A3XxYjLpzjJ3ZRrTD6pHPsU99xvbLAfo");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1QZspieuTUCB4y4TQhrJgpSE52OXTq-Wu");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1MbTBSvFuYCTmOXQTpyHJWe9Kr7emwCcx");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1OtIMNDEfLaY_y5IvuBxwlRtE6gGFjCfa");
                            }

                        }
                        else if (item9.matches("103 APPLIED CHEMISTRY"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1BScAETO1VWWhegxBgdkNpI3m2zz9EJgu");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1urEKS9WcHc9jGHAOrrmUUxMOlwgXDA94");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1Cw0eCeHu1aVdfKsbL1l6B7yz9DW3mhl0");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1xsexLHKIJV7ycKrcogFX2RGPTPzNZGhw");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1nygjmtGiKbTGMxBLL-E_IPc6xojgKASs");
                            }

                        }
                        else if (item9.matches("104 APPLIED MATHEMATICS"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/12Ue0bqULHiRDbEFvhq1y3qKUJNs06sL5");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1HmsKOPreIJJv7lMsWOfS5TdKeZdE0seM");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/12bRRusWg6QyhlRLEipgwxFUB1kODoxhd");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1CZhKezRPeUD6sAqndxFzmz3C6Gz_vZ15");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1021nrdeIDVOL2JzUYepjObSf4DvkN3GI");
                            }

                        }
                        else if (item9.matches("105 COMPUTER AND IT FUNDAMENTALS"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1gKeT0HNScnaqdNeZjlZ1EXtHXlQBscba");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1IsSNrcKrPjDCHBHGxMb4RN9tQkjrQbD6");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1NdFksLp1-oYtS7522qzVitr-27qhrzo4");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1QuadLUKqqqfQ-Gz6fazpdK5hgr3xzrue");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1g8oqgcHNhxQTyQAm3uVmW5VmBt1jCQ1O");
                            }

                        }
                        else if (item9.matches("106 APPLIED MECHANICS"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1hJgPVP8YwlSyDg5_fiVcfq93Ozg1nfVZ");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1mRPq_ntb1yy9CSiQ5f5r4rwIVmo1SW4g");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1y-FzbzHkN7pKvTKm_jS9we6Vb6Z8PDo1");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/18ej44NTKQkgrmDe5nG0V7FpRLFrdszn4");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/file/d/1EaECO7JsljPN38XDkM7yJjT7iZ0dEXVW");
                            }

                        }
                    }
                    else if(item8.matches("Second Year"))
                    {
                        if (item9.matches("ELECTRICAL ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1tyivy4uxXlNgxruXQsAqhG76f9D41fLq");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1MULxcZVP7Vs-4kw0SKEE_GzkZr71dy-w");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1AzUbKydgvw-EaTK34Q8uvSwdliFCNCFF");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1AzUbKydgvw-EaTK34Q8uvSwdliFCNCFF");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1aBdawbHX9F_FL6KKSJXRrJa1q-V-n0Mj");
                            }

                        }
                        else if (item9.matches("CIVIL ENGINEERING"))
                        {
                        if(item10.matches("2015"))
                        {
                            webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1mzU0NBWQVlVmbJrH8OBPXXrr5wLEMdHo");
                        }
                        else if(item10.matches("2016"))
                        {
                            webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1kO0HTvXmrvVBdAlQsgQDO2X73FQoZ3Y_");
                        }
                        else if(item10.matches("2017"))
                        {
                            webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1U8Mc2R_bIaFyIsVdfbwt966AVif9PmjZ");
                        }
                        else if(item10.matches("2018"))
                        {
                            webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1tCuSDIe0vzGWp5JpVKXA8pZCZGjcOtlM");
                        }
                        else if(item10.matches("2019"))
                        {
                            webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1o-v8sTwL8x-wsgsow1sj8J3ufezf3IIH");
                        }

                    }
                        else if (item9.matches("COMPUTER SCIENCE & ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1e_aWQOB4lKGsLfDz6Q1SAj-zEYWe04tM");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1E9WxN_Uek679wF6jtNHwdfz7maYdu2wA");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1w__VZT_xBLYQ8KUYjhCcjjB-5YUl0-2m");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1EdzcUMJubHSeNh-jK03lGdJsN8WzW1Z4");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1yrrm6LyrxTP4I3G5pjCt1AwWNDcopjev");
                            }

                        }
                        else if (item9.matches("ELECTRONICS ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/13M3rapQXabuH__dWVEMBi8aEalslI7fd");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1ekAG_jQTTFQ4lDQ2vZRvQxDpWmaQvHF2");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1PnmphiZiSehavHE-5CAGDHUNlpV0qKJL");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/14Lu6h1eZCLHKBJd8tp7ETCTJgtphRgrd");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1t2dqFaZYO98J01mYxDeBER4l-RrjPkBe");
                            }

                        }
                        else if (item9.matches("MECHANICAL ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1MWCfY4TF-TvMysnf2SFk9godeezQ43PB");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1y_58QQ8DRokUQmc76vLUGcSkxHA8z2RP");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1y_ykqGhFWhEirS8Qix0bPDJoUvGOxqD0");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1VUGfpEhEtcbAyeQ1ZNBbgkTwXxq7fxjR");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1Zd1RWvBOT2aG6tekNJdS4C5hEaOzD_bO");
                            }

                        }
                    }
                    else if(item8.matches("Third Year"))
                    {
                        if (item9.matches("ELECTRICAL ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/18Qf6sMbvS-LL86eoAwKKeya4Q_dln8qS");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1gSDOqIpvJmxwWQnpLRh098eue92IYnsQ");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1n7XmwGnVfmFw_6LjydYvu7SHuxHTpQ2n");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1HpI-pvusAsbc85yuHfSEpO9mexcSADkM");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1ASubMS6xrC8SrgtcSxCDDuxJ7lanzDqL");
                            }

                        }
                        else if (item9.matches("CIVIL ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1D4wUXBPiBKj7WwwvSdIPH-_WWn0U1dln");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1i6PB8vDAWtvkQJhcUVVXoYjzSDd3DJ_-");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1l9FxbB_is5ZPPGJ80FApYiBdJRrSLZId");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1ZWCrWrTg9dCpon7HrmdhzSZkHgDsoa-6");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1bKCsvl2PW7zC_1uSyriT7iFxAbM_CXkx");
                            }

                        }
                        else if (item9.matches("COMPUTER SCIENCE & ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1v2j9rW-2m3-Si-0DFtAFJn1SOTYGsFh1");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1IKpHE-PEsUernQlsA7PyluokcrgtB0hR");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1tAoG_Cpv_5aR1JlF7JLrpvWSVM0TbVYw");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/17SNe78zg0Ns3V1DlhL0KGVfUrxymJs1z");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1OefaGBPYp2Z6VTfIh76OlOkZ8fSOfYh5");
                            }

                        }
                        else if (item9.matches("ELECTRONICS ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/15NfH4db01xs0G5dRQVqNU7yth7Ep3AVV");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1FwQHbBUCIdOcXsQ5CNF3DOCFh4wNq0Wu");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1rkcOqAGqt_dlXviAXbaABb59qH-zKVu7");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/19UcE8YACtfYBZksPNE2e2_J5gGrSA7k-");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1TkBpGAQPuWwxJLC2P1jPYZy-IrK11YGh");
                            }

                        }
                        else if (item9.matches("MECHANICAL ENGINEERING"))
                        {
                            if(item10.matches("2015"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1NJtl-htpk6yRuyzNYC1rJzXFK9qo_fa9");
                            }
                            else if(item10.matches("2016"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1eCtbulkgUYIjp8GjlpiYAuhZB6jCpDT3");
                            }
                            else if(item10.matches("2017"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1bThBllDO6DftOPhvwzjhIP5jqVMdWoPJ");
                            }
                            else if(item10.matches("2018"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1sA1QS56A8ICdwewJ__HapUrkvYF-lP8O");
                            }
                            else if(item10.matches("2019"))
                            {
                                webview_qpsol.loadUrl("https://drive.google.com/drive/folders/1BtVsEv8qAig0SfUdp4UtavnHA_W1VXg4");
                            }

                        }
                    }
                }
                else
                {

                }

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
            startActivity(new Intent(qpsolution.this, MainActivity.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(qpsolution.this,imp_link.class));
            return true;
        }
        if (id == R.id.login)
        {
            startActivity(new Intent(qpsolution.this,login.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(qpsolution.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(qpsolution.this,WebViewActivity.class);
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
            startActivity(new Intent(qpsolution.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(qpsolution.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

