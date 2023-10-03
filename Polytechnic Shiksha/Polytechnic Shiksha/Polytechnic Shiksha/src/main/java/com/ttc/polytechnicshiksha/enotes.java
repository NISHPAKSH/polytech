package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;


public class enotes extends AppCompatActivity {
    public static String url;
    public static String title;

    TextView branchtv;

    List<String> branchlist = new ArrayList<>();
    List<String> semlist = new ArrayList<>();
    List<String> sublist = new ArrayList<>();

    Button btnSearch;


    String item1, course;
    String item2, semester;
    String item3, branch;
    String item4, subject;

    ArrayAdapter<CharSequence> courseAdapter;
    ArrayAdapter<String> branchAdapter ;
    ArrayAdapter<String> semAdapter ;
    ArrayAdapter<String> subjectAdapter ;

    //WebView webview_enote = (WebView) findViewById(R.id.webview_enotes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enotes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("E-Notes");

        btnSearch = (Button) findViewById(R.id.enotesbtngo);
        branchtv = (TextView) findViewById(R.id.textView11);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_enotes_course);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_enotes_semester);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_enotes_branch);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner_enotes_subcode);

        WebView webview_enotes = (WebView) findViewById(R.id.webview_enotes);

        courseAdapter = ArrayAdapter.createFromResource(this,R.array.labmanual_array, R.layout.simple_spinner_item11);
        semAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, semlist);
        branchAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, branchlist);
        subjectAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, sublist);

        spinner2.setEnabled(false);
        spinner3.setEnabled(false);
        spinner4.setEnabled(false);
        btnSearch.setEnabled(false);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                item1 = parent.getItemAtPosition(pos).toString();
                if (item1.matches("Engineering"))
                {
                    spinner2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner2.setEnabled(true);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);

                    semlist.clear();
                    semlist.add("Select Semester");
                    semlist.add("First Semester");
                    semlist.add("Second Semester");
                    semlist.add("Third Semester");
                    semlist.add("Fourth Semester");
                    semlist.add("Fifth Semester");
                    //semlist.add("Sixth Semester");

                    branchlist.clear();
                    branchlist.add("Select Branch");


                    sublist.clear();
                    sublist.add("Select Subject");

                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();


                }
                else
                {
                    semlist.clear();
                    semlist.add("Select Semester");

                    branchlist.clear();
                    branchlist.add("Select Branch");

                    sublist.clear();
                    sublist.add("Select Subject");

                    semAdapter.notifyDataSetChanged();
                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();

                    spinner2.setEnabled(false);
                    spinner2.setPrompt("Select Semester");
                    spinner3.setEnabled(false);
                    spinner3.setPrompt("Select Branch");
                    spinner4.setEnabled(false);
                    spinner4.setPrompt("Select Subject");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        courseAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner1.setAdapter(courseAdapter);


        semlist.add("Select Semester");
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                item2 = parentView.getItemAtPosition(position).toString();

                if ((item1.matches("Engineering")) && (item2.matches("First Semester")))
                {

                    branchtv.setVisibility(View.GONE);
                    spinner3.setVisibility(View.GONE);
                    branchlist.clear();
                    branchlist.add("First Semester");
                    branchAdapter.notifyDataSetChanged();

                    item3 = "First Semester";
                    sublist.clear();
                    sublist.add("Select Subject");

                    subjectAdapter.notifyDataSetChanged();


                    //sublist.add("1001 Mathematics-I");
                    sublist.add("1002 APPLIED PHYSICS-I");
                    sublist.add("1003 APPLIED CHEMISTRY");
                    //sublist.add("1004 Communication Skills in English");
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);

                }
                else if ((item1.matches("Engineering")) && (item2.matches("Second Semester")))
                {
                    branchtv.setVisibility(View.GONE);
                    spinner3.setVisibility(View.GONE);
                    branchlist.clear();
                    branchlist.add("Second Semester");
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner4.setEnabled(false);
                    subjectAdapter.notifyDataSetChanged();
                    item3 = "Second Semester";
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();
                    sublist.clear();
                    sublist.add("Select Subject");
                    //sublist.add("2001 Mathematics-II");
                    sublist.add("2002 APPLIED PHYSICS-II");
                    sublist.add("2003 INTRODUCTION TO IT SYSTEMS");
                    sublist.add("2004 FUNDAMENTALS OF ELECTRICAL & ELECTRONICS ENGINEERING");
                    //sublist.add("2005 Engineering Mechanics");
                }
                else if ((item1.matches("Engineering")) && (item2.matches("Third Semester")))
                {
                    branchtv.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner4.setEnabled(false);

                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();
                    //branchlist.add("BEAUTY CULTURE");
                    branchlist.add("CIVIL ENGINEERING");
                    branchlist.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist.add("ELECTRICAL ENGINEERING");
                    branchlist.add("ELECTRONICS ENGINEERING");
                    branchlist.add("MECHANICAL AUTOMOBILE ENGINEERING");

                }
                else if ((item1.matches("Engineering")) && (item2.matches("Fourth Semester")))
                {
                    branchtv.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner4.setEnabled(false);

                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();
                    //branchlist.add("BEAUTY CULTURE");
                    branchlist.add("MECHANICAL AUTOMOBILE ENGINEERING");

                }
                else if ((item1.matches("Engineering")) && (item2.matches("Fifth Semester")))
                {
                    branchtv.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner4.setEnabled(false);

                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();
                    //branchlist.add("BEAUTY CULTURE");
                    branchlist.add("COMPUTER SCIENCE & ENGINEERING");

                }
                /*
                else if ((item1.matches("Engineering")) && (item2.matches("Fourth Semester")))
                {
                    branchtv.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");

                    spinner4.setEnabled(false);
                    branchAdapter.notifyDataSetChanged();
                    //branchlist.add("ARCHITECTURE ENGINEERING");
                    //branchlist.add("CHEMICAL ENGINEERING");
                    branchlist.add("CIVIL ENGINEERING");
                    //branchlist.add("COMPUTER SCIENCE & ENGINEERING");
                    //branchlist.add("ELECTRONICS ENGINEERING");
                    //branchlist.add("ELECTRONICS FIBER ENGINEERING");
                    //branchlist.add("ELECTRICAL ENGINEERING");
                    //branchlist.add("INSTRUMENTATION ENGINEERING");
                    //branchlist.add("MECHANICAL ENGINEERING");
                    //branchlist.add("MECHANICAL AUTOMOBILE ENGINEERING");
                    //branchlist.add("MECHANICAL PRODUCTION ENGINEERING");
                    //branchlist.add("MECHANICAL RAC ENGINEERING");
                    //branchlist.add("PETROLEUM ENGINEERING");
                }

                 */
                else
                {
                    branchtv.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(false);
                    spinner3.setPrompt("Select Branch");
                    spinner4.setEnabled(false);
                    spinner4.setPrompt("Select Subject");

                    branchlist.clear();
                    branchlist.add("Select Branch");

                    sublist.clear();
                    sublist.add("Select Subject");

                    branchAdapter.notifyDataSetChanged();
                    subjectAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        semAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner2.setAdapter(semAdapter);

        branchlist.add("Select Branch");
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position, long id) {
                item3 = parent3.getItemAtPosition(position).toString();

                if ((item2.matches("Third Semester")) && (item3.matches("CIVIL ENGINEERING")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("CE 3001 CONSTRUCTION MATERIAL");
                    sublist.add("CE 3002 BASIC SURVEYING");
                    sublist.add("CE 3003 MECHANICS OF MATERIALS");
                    sublist.add("CE 3004 BUILDING CONSTRUCTION");
                    sublist.add("CE 3005 CONCRETE TECHNOLOGY");
                    sublist.add("CE 3006 GEOTECHNICAL ENGINEERING");



                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);

                }
                else if ((item2.matches("First Semester")) && (item3.matches("First Semester")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("1002 APPLIED PHYSICS-I");
                    sublist.add("1003 APPLIED CHEMISTRY");


                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                }
                else if ((item2.matches("Second Semester")) && (item3.matches("Second Semester")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("2002 APPLIED PHYSICS-II");
                    sublist.add("2003 INTRODUCTION TO IT SYSTEMS");
                    sublist.add("2004 FUNDAMENTALS OF ELECTRICAL & ELECTRONICS ENGINEERING");

                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                }
                else if ((item2.matches("Third Semester")) && (item3.matches("COMPUTER SCIENCE & ENGINEERING")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("CS 3001 COMPUTER PROGRAMMING");
                    sublist.add("CS 3002 SCRIPTING LANGUAGES : PYTHON");
                    sublist.add("CS 3003 DATA STRUCTURES");
                    sublist.add("CS 3004 COMPUTER SYSTEM ORGANISATION");
                    sublist.add("CS 3005 ALGORITHMS");


                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);

                }
                else if ((item2.matches("Third Semester")) && (item3.matches("ELECTRICAL ENGINEERING")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("EE 3001 INTRODUCTION TO ELECTRIC GENERATION SYSTEMS");
                    sublist.add("EE 3002 ELECTRICAL CIRCUITS");
                    sublist.add("EE 3003 ELECTRICAL AND ELECTRONIC MEASUREMENTS");
                    sublist.add("EE 3004 ELECTRIC MOTORS AND TRANSFORMERS");
                    sublist.add("EE 3005 RENEWABLE ENERGY POWER PLANTS");


                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);

                }
                else if ((item2.matches("Third Semester")) && (item3.matches("ELECTRONICS ENGINEERING")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("EL 3001 PRINCIPLES OF ELECTRONIC COMMUNICATION");
                    sublist.add("EL 3002 ELECTRONIC DEVICES AND CIRCUITS");
                    sublist.add("EL 3003 DIGITAL ELECTRONICS");
                    sublist.add("EL 3004 ELECTRONIC MEASUREMENTS AND INSTRUMENTATION");
                    sublist.add("EL 3005 ELECTRIC CIRCUITS & NETWORK");


                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);

                }
                else if ((item2.matches("Third Semester")) && (item3.matches("MECHANICAL AUTOMOBILE ENGINEERING")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("MA 3005 AUTO THERMODYNAMICS - I");


                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);

                }
                else if ((item2.matches("Fourth Semester")) && (item3.matches("MECHANICAL AUTOMOBILE ENGINEERING"))) {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("MA 40041 BASIC VEHICLE TECHNOLOGY");
                    sublist.add("MA 40052 AUTO ELECTRICAL ENGINEERING");
                    sublist.add("MA 4003 AUTO THERMODYNAMICS - II");


                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);
                }
                else if ((item2.matches("Fifth Semester")) && (item3.matches("COMPUTER SCIENCE & ENGINEERING"))) {

                    sublist.clear();
                    sublist.add("Select Subject");
                    subjectAdapter.notifyDataSetChanged();
                    sublist.add("CS 50041 ADVANCE COMPUTER NETWORKS");
                    spinner3.setEnabled(true);
                    spinner4.setEnabled(true);
                }

                else
                {

                    spinner4.setEnabled(false);
                    spinner4.setPrompt("Select Subject");

                    sublist.clear();
                    sublist.add("Select Subject");

                    subjectAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        branchAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner3.setAdapter(branchAdapter);


        sublist.add("Select Subject");
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent4, View view, int position, long id) {
                item4 = parent4.getItemAtPosition(position).toString();

                if((sublist.contains(""+item4)) && !item4.matches("Select Subject"))
                {
                    btnSearch.setEnabled(true);
                }
                else
                {
                    //spinner5.setEnabled(true);
                    subjectAdapter.notifyDataSetChanged();
                    btnSearch.setEnabled(false);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        subjectAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner4.setAdapter(subjectAdapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                course = item1;
                semester = item2;
                branch = item3;
                subject = item4;
                Toast.makeText(getBaseContext(), "Wait.. We will take you to google drive link", Toast.LENGTH_SHORT)
                        .show();
                //enviarPost(true);
                if (item4.matches("1003 APPLIED CHEMISTRY"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1sI2XvGkP56IWB9ssvv2hQq00NnZmKDIOEpQrN_d4fJW7RM5c0TsJGqEwDR8NSwLFEbdifz4U");

                }
                else if (item4.matches("1002 APPLIED PHYSICS-I"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1zYJOcI6hk9nFxTK5NKvGZ-I2AFHwtxHAtz14Z6pI1gLEbeBjERhunDdrdk_Pb4ljY3bnw-g_");

                }
                else if (item4.matches("2002 APPLIED PHYSICS-II"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1gaBQvk8w8BelYuk1AmIBrgKBTi9dkxcxwdpsw-wq6rEwf9Z5cuRUSUgmwataJ-3Edry6Bebm");

                }
                else if (item4.matches("2003 INTRODUCTION TO IT SYSTEMS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1z2koeSI-7TuLSdtqY5TJhUH0V3U5-Yeo");

                }
                else if (item4.matches("2004 FUNDAMENTALS OF ELECTRICAL & ELECTRONICS ENGINEERING"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1Qna_hVrXSCH9p_6hR1wi3jcIJZKRKTSZ");

                }
                else if (item4.matches("CE 3001 CONSTRUCTION MATERIAL"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1nXhv91NqxXJEKqRcLUI2pxaBH0t5QpLg");

                }
                else if (item4.matches("CE 3002 BASIC SURVEYING"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1jrI2dc4m53tmH9oLiLalDr-6frycFo_Z");

                }
                else if (item4.matches("CE 3003 MECHANICS OF MATERIALS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1HbMaQIa3e79vku4P-lPyV2Dhc1aa-ViG");

                }
                else if (item4.matches("CE 3004 BUILDING CONSTRUCTION"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1HyDL7p7R2cCEs1KqcLB_7YxoKObnZVHy");

                }
                else if (item4.matches("CE 3005 CONCRETE TECHNOLOGY"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1idBEGsFlS8Q_ajjKfymA0jBFnztFKQw-");

                }
                else if (item4.matches("CE 3006 GEOTECHNICAL ENGINEERING"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1wToDAJeXuxUgKWcFfjqBVwu0RV-MD7Us");

                }
                else if (item4.matches("CS 3001 COMPUTER PROGRAMMING"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1TSAX136v7mY_t6Gey5krSZR7x6ieutPd");

                }
                else if (item4.matches("CS 3002 SCRIPTING LANGUAGES : PYTHON"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1bQNcQbww6peRuYAhUXX16lz8-2rPXcMy");

                }
                else if (item4.matches("CS 3003 DATA STRUCTURES"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1w2zHi3tB3mc_wxtEOawITRLY9wZtuqIn");

                }
                else if (item4.matches("CS 3004 COMPUTER SYSTEM ORGANISATION"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1EX3Hdzw1ovxTR74934jix0umbchAP4aE");

                }
                else if (item4.matches("CS 3005 ALGORITHMS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1FQMBWeSi22np_u4wAXPjjabMiGCmt7ah");

                }
                else if (item4.matches("CS 50041 ADVANCE COMPUTER NETWORKS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1XOZngBt8VIsf5V0YIZL2kfSSwV6W6Oor3rGQuXT6AAjn1PKkZDKNeTAsMxLC9TZ8WbU_ec6U");

                }
                else if (item4.matches("EE 3001 INTRODUCTION TO ELECTRIC GENERATION SYSTEMS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1dwZwkPJK1E8koSAzpvAAcBgs1-jLH_mR");

                }
                else if (item4.matches("EE 3002 ELECTRICAL CIRCUITS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1Rvy-aFuex_i3FB4Bnnq_dHBZ9NkB0Tv6");

                }
                else if (item4.matches("EE 3003 ELECTRICAL AND ELECTRONIC MEASUREMENTS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1ZarT8sdBULkAYFOtPpDR-63x-nNBR72C");

                }
                else if (item4.matches("EE 3004 ELECTRIC MOTORS AND TRANSFORMERS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1ICSfHBVVFt7MS4P4Liet_Kx9bcOXE2OP");

                }
                else if (item4.matches("EE 3005 RENEWABLE ENERGY POWER PLANTS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1FCsPp79I2mMNNkwRwFQQ-Qedag4LASYk");

                }
                else if (item4.matches("EL 3001 PRINCIPLES OF ELECTRONIC COMMUNICATION"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1YQJfRAa1_zf4bPXLpL_gg3c8Xi9GQQ1m");

                }
                else if (item4.matches("EL 3002 ELECTRONIC DEVICES AND CIRCUITS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1GBWONe1IObXYA6TxocP9sOu_yOcxxstb");

                }
                else if (item4.matches("EL 3003 DIGITAL ELECTRONICS"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/106TPoUTJZl7XzV3-sqf5smK_y1zTIyGa");

                }
                else if (item4.matches("EL 3004 ELECTRONIC MEASUREMENTS AND INSTRUMENTATION"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1GNk6biTtfJoyf2KHa_rndpe7bYbvClx7");

                }
                else if (item4.matches("EL 3005 ELECTRIC CIRCUITS & NETWORK"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1cEnGj-jXEpDi1msaGFIzVDa-fFoP5Kv2");

                }
                else if (item4.matches("MA 3005 AUTO THERMODYNAMICS - I"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/u/1/folders/1JAB5X2k1b8vzOt3Z5woxiThYETYa1csf");

                }
                else if (item4.matches("MA 40041 BASIC VEHICLE TECHNOLOGY"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1pTLnXRZ2ZI33fzV0wI282S187UDTjrpU");
                }
                else if (item4.matches("MA 40052 AUTO ELECTRICAL ENGINEERING"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1sKpbgfTuzFIPZb5QpaD0wVNy5t54E3sj");
                }
                else if (item4.matches("MA 4003 AUTO THERMODYNAMICS - II"))
                {
                    //webview_Labmanual.setWebViewClient(new WebViewClient());
                    //mlabBtn.setVisibility(View.INVISIBLE);
                    webview_enotes.loadUrl("https://drive.google.com/drive/folders/1iFq2PTV32gtdaMtt96MxlmyLo3Equuy0");
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
        if (id == R.id.login)
        {
            startActivity(new Intent(enotes.this,login.class));
            return true;
        }
        if (id == R.id.home) {
            startActivity(new Intent(enotes.this, MainActivity.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(enotes.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(enotes.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(enotes.this,WebViewActivity.class);
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
            startActivity(new Intent(enotes.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(enotes.this,disclaimer.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}