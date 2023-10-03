package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class electure extends AppCompatActivity {
    public static String url;
    public static String title;

    List<Hero> heroList;
    List<String> categories = new ArrayList<>();
    List<String> branchlist = new ArrayList<>();
    List<String> sublist = new ArrayList<>();
    List<String> unitlist = new ArrayList<>();

    Button btnSearch;
    ListView lvVideo;

    ArrayList<VideoDetails> videoDetailsArrayList;
    MyListAdapter customListAdapter;

    String item1;
    String item2;
    String item3;
    String item4;
    String item5;

    ArrayAdapter<CharSequence> firstAdapter;
    ArrayAdapter<String> secondAdapter ;
    ArrayAdapter<String> thirdAdapter ;
    ArrayAdapter<String> forthAdapter ;
    ArrayAdapter<String> fifthAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electure);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("E-Lectures");
        btnSearch = (Button) findViewById(R.id.electbtngo);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_elect_course);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_elect_year);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_elect_branch);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner_elect_subcode);
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner_elect_unit);

        firstAdapter = ArrayAdapter.createFromResource(this,R.array.electure_array, R.layout.simple_spinner_item11);
        secondAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, categories);
        thirdAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, branchlist);
        forthAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, sublist);
        fifthAdapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, unitlist);

        spinner2.setEnabled(false);
        spinner3.setEnabled(false);
        spinner4.setEnabled(false);
        spinner5.setEnabled(false);
        btnSearch.setEnabled(false);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                item1 = parent.getItemAtPosition(pos).toString();
                if (item1.matches("Engineering"))
                {
                    spinner2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner5.setVisibility(View.VISIBLE);
                    spinner2.setEnabled(true);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);

                    categories.clear();
                    categories.add("Select Year/Semester");

                    branchlist.clear();
                    branchlist.add("Select Branch");

                    sublist.clear();
                    sublist.add("Select Subject");

                    unitlist.clear();
                    unitlist.add("Select Unit");

                    secondAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();

                    categories.add("First Semester");
                    categories.add("Second Semester");
                    categories.add("Second Year");
                    categories.add("Third Year");
                }
                else if (item1.matches("Non-Engineering"))
                {
                    spinner2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner5.setVisibility(View.VISIBLE);

                    spinner2.setEnabled(true);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);

                    categories.clear();
                    categories.add("Select Year");

                    branchlist.clear();
                    branchlist.add("Select Branch");

                    sublist.clear();
                    sublist.add("Select Subject");

                    unitlist.clear();
                    unitlist.add("Select Unit");

                    secondAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();

                    categories.add("Second Year");
                    categories.add("Third Year");
                }
                else if (item1.matches("PERSONAL GROOMING and SOFT SKILLS"))
                {
                    spinner2.setVisibility(View.GONE);
                    spinner3.setVisibility(View.GONE);
                    spinner5.setVisibility(View.GONE);

                    categories.clear();
                    categories.add("PERSONAL GROOMING");
                    branchlist.clear();
                    branchlist.add("PERSONAL GROOMING");
                    secondAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();

                    item2 = "PERSONAL GROOMING";
                    item3 = "PERSONAL GROOMING";
                    sublist.clear();
                    sublist.add("Select Subject");

                    forthAdapter.notifyDataSetChanged();

                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                    spinner5.setEnabled(false);


                    sublist.clear();
                    sublist.add("Select Subject");
                    sublist.add("Resume and Interview skills");
                    sublist.add("Yoga and Physical Exercises");
                    sublist.add("Personality Development");
                    sublist.add("Miscellaneous");

                }
                else
                {
                    categories.clear();
                    categories.add("Select Year/Semester");

                    branchlist.clear();
                    branchlist.add("Select Branch");

                    sublist.clear();
                    sublist.add("Select Subject");

                    unitlist.clear();
                    unitlist.add("Select Unit");

                    secondAdapter.notifyDataSetChanged();

                    spinner2.setEnabled(false);
                    spinner2.setPrompt("Select Year/Semester");
                    spinner3.setEnabled(false);
                    spinner3.setPrompt("Select Branch");
                    spinner4.setEnabled(false);
                    spinner4.setPrompt("Select Subject");
                    spinner5.setEnabled(false);
                    spinner5.setPrompt("Select Unit");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        firstAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner1.setAdapter(firstAdapter);


        categories.add("Select Year/Semester");
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                
                item2 = parentView.getItemAtPosition(position).toString();

                if ((item1.matches("Engineering")) && (item2.matches("First Semester")))
                {


                    spinner3.setVisibility(View.GONE);
                    branchlist.clear();
                    branchlist.add("First Semester");
                    thirdAdapter.notifyDataSetChanged();

                    item3 = "First Semester";
                    sublist.clear();
                    sublist.add("Select Subject");

                    forthAdapter.notifyDataSetChanged();


                    sublist.add("1001 Mathematics-I");
                    sublist.add("1002 Applied Physics-I");
                    sublist.add("1003 Applied Chemistry");
                    sublist.add("1004 Communication Skills in English");
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                    spinner5.setEnabled(false);

                }
                else if ((item1.matches("Engineering")) && (item2.matches("Second Semester")))
                {
                    spinner3.setVisibility(View.GONE);
                    branchlist.clear();
                    branchlist.add("Second Semester");
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner4.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    item3 = "Second Semester";
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                    spinner5.setEnabled(false);
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    fifthAdapter.notifyDataSetChanged();
                    sublist.clear();
                    sublist.add("Select Subject");
                    sublist.add("2001 Mathematics-II");
                    sublist.add("2002 Applied Physics");
                    sublist.add("2003 Introduction to IT Systems");
                    sublist.add("2004 Fundamentals of Electrical & Electronics Engineering");
                    sublist.add("2005 Engineering Mechanics");
                }
                else if ((item1.matches("Engineering")) && (item2.matches("Second Year")))
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);

                    thirdAdapter.notifyDataSetChanged();
                    branchlist.add("ARCHITECTURE ENGINEERING");
                    branchlist.add("CHEMICAL ENGINEERING");
                    branchlist.add("CIVIL ENGINEERING");
                    branchlist.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist.add("ELECTRONICS ENGINEERING");
                    branchlist.add("ELECTRONICS FIBER ENGINEERING");
                    branchlist.add("ELECTRICAL ENGINEERING");
                    branchlist.add("INSTRUMENTATION ENGINEERING");
                    branchlist.add("MECHANICAL ENGINEERING");
                    branchlist.add("MECHANICAL AUTOMOBILE ENGINEERING");
                    branchlist.add("MECHANICAL PRODUCTION ENGINEERING");
                    branchlist.add("MECHANICAL RAC ENGINEERING");

                }
                else if ((item1.matches("Engineering")) && (item2.matches("Third Year")))
                {

                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);
                    thirdAdapter.notifyDataSetChanged();
                    branchlist.add("ARCHITECTURE ENGINEERING");
                    branchlist.add("CHEMICAL ENGINEERING");
                    branchlist.add("CIVIL ENGINEERING");
                    branchlist.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist.add("ELECTRONICS ENGINEERING");
                    branchlist.add("ELECTRONICS FIBER ENGINEERING");
                    branchlist.add("ELECTRICAL ENGINEERING");
                    branchlist.add("INSTRUMENTATION ENGINEERING");
                    branchlist.add("MECHANICAL ENGINEERING");
                    branchlist.add("MECHANICAL AUTOMOBILE ENGINEERING");
                    branchlist.add("MECHANICAL PRODUCTION ENGINEERING");
                    branchlist.add("MECHANICAL RAC ENGINEERING");
                }
                else if ((item1.matches("Non-Engineering")) && (item2.matches("Second Year")))
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);

                    thirdAdapter.notifyDataSetChanged();
                    branchlist.add("BEAUTY CULTURE");
                    branchlist.add("COMMERCIAL ART");
                    branchlist.add("INTERIOR DECORATION");
                    branchlist.add("TEXTILE DESIGN");
                    branchlist.add("MODERN OFFICE MANAGEMENT");
                }
                else if ((item1.matches("Non-Engineering")) && (item2.matches("Third Year")))
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist.clear();
                    branchlist.add("Select Branch");
                    sublist.clear();
                    sublist.add("Select Subject");
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    spinner4.setEnabled(false);
                    spinner5.setEnabled(false);

                    thirdAdapter.notifyDataSetChanged();
                    //branchlist.add("BEAUTY CULTURE");
                    branchlist.add("COMMERCIAL ART");
                    branchlist.add("INTERIOR DECORATION");
                    branchlist.add("TEXTILE DESIGN");
                    branchlist.add("MODERN OFFICE MANAGEMENT");
                }
                else
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(false);
                    spinner3.setPrompt("Select Branch");
                    spinner4.setEnabled(false);
                    spinner4.setPrompt("Select Subject");
                    spinner5.setEnabled(false);
                    spinner5.setPrompt("Select Unit");
                    branchlist.clear();
                    branchlist.add("Select Branch");

                    sublist.clear();
                    sublist.add("Select Subject");

                    unitlist.clear();
                    unitlist.add("Select Unit");
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    fifthAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        secondAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner2.setAdapter(secondAdapter);


        branchlist.add("Select Branch");
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position, long id) {
                item3 = parent3.getItemAtPosition(position).toString();
                if ((item3.matches("ELECTRONICS ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("EL 201 ELECTRONIC COMPONENTS AND SHOP PRACTICE");
                    sublist.add("EL 202 CIRCUIT ANALYSIS");
                    sublist.add("EL 203 ELECTRONIC MEASUREMENT AND INSTRUMENTATION");
                    sublist.add("EL 204 ELECTRONIC DEVICES AND CIRCUITS");
                    sublist.add("EL 205 DIGITAL ELECTRONICS");
                    sublist.add("EL 206 WAVE PROPAGATION AND COMMUNICATION ENGINEERING");
                    sublist.add("EL 207 MICROPROCESSOR");
                    sublist.add("EL 208 AUDIO AND VIDEO SYSTEM");
                    sublist.add("EL 209 ELECTRONIC INSTRUMENT");
                    sublist.add("EL 210 C PROGRAMMING");

                }
                else if ((item3.matches("ELECTRONICS FIBER ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("EF 201 ELECTRONIC COMPONENT AND SHOP PRACTICE");
                    sublist.add("EF 202 CIRCUIT ANALYSIS");
                    sublist.add("EF 203 ELECTRONIC MEASUREMENT AND INSTRUMENTATION");
                    sublist.add("EF 204 ELECTRONIC DEVICES AND CIRCUITS");
                    sublist.add("EF 205 DIGITAL ELECTRONICS");
                    sublist.add("EF 206 WAVE PROPOGATION AND COMMUNICATION ENGG.");
                    sublist.add("EF 207 MICROPROCESSOR");
                    sublist.add("EF 208 AUDIO AND VIDEO SYSTEM");
                    sublist.add("EF 209 ELECTRONIC INSTRUMENT");
                    sublist.add("EF 210 C PROGRAMMING");

                }
                else if ((item3.matches("First Semester")) && (item2.matches("First Semester")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");

                    forthAdapter.notifyDataSetChanged();

                    sublist.add("1001 Mathematics-I");
                    sublist.add("1002 Applied Physics-I");
                    sublist.add("1003 Applied Chemistry");
                    sublist.add("1004 Communication Skills in English");

                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                    spinner5.setEnabled(false);
                }
                else if ((item3.matches("Second Semester")) && (item2.matches("Second Semester")))
                {

                    sublist.clear();
                    sublist.add("Select Subject");

                    forthAdapter.notifyDataSetChanged();

                    sublist.add("2001 Mathematics-II");
                    sublist.add("2002 Applied Physics");
                    sublist.add("2003 Introduction to IT Systems");
                    sublist.add("2004 Fundamentals of Electrical & Electronics Engineering");
                    sublist.add("2005 Engineering Mechanics");

                    spinner3.setEnabled(false);
                    spinner4.setEnabled(true);
                    spinner5.setEnabled(false);
                }
                else if ((item3.matches("ELECTRONICS ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("EL 301 ELECTRONIC CIRCUITS");
                    sublist.add("EL 302 ADVANCE MICROPROCESSOR AND MICROCONTROLLER");
                    sublist.add("EL 303 ADVANCE COMMUNICATION SYSTEM");
                    sublist.add("EL 304 MICROWAVE AND OPTICAL FBER ENGINEERING");
                    sublist.add("EL 305 POWER AND INDUSTRIAL ELECTRONICS");
                    sublist.add("EL 306 BIO-MEDICAL INSTRUMENTATION");
                    sublist.add("EL 307 LINEAR INTEGRATED CIRCUITS AND DESIGN");
                    sublist.add("EL 308 TELECOMMUNICATION AND SWITCHING NETWORKS");
                    sublist.add("EL 309 COMPUTER COMMUNICATION");
                    sublist.add("EL 310 MANAGEMENT AND ENTERPRENEURSHIP");
                }
                else if ((item3.matches("ELECTRONICS FIBER ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("EF 301 ELECTRONIC CIRCUITS");
                    sublist.add("EF 302 ADVANCED MICROPROCESSOR AND MICROCONTROLLER");
                    sublist.add("EF 303 FIBER OPTICS ENGINEERING");
                    sublist.add("EF 304 FIBER OPTIC DEVICES AND INSTRUMENTATION");
                    sublist.add("EF 305 POWER AND INDUSTRIAL ELECTRONICS");
                    sublist.add("EF 306  OPTICAL FIBER COMMUNICATION");
                    sublist.add("EF 307 LINEAR INTEGRATED CIRCUIT AND DESIGN");
                    sublist.add("EF 308 OPTO ELECTRONICS, DIGITAL AND MICROWAVE ENGGINEERING");
                    sublist.add("EF 309 COMPUTER COMMUNICATION");
                    sublist.add("EF 310 MANAGEMENT AND ENTERPRENEURSHIP");

                }
                else if ((item3.matches("CIVIL ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CE 201 STRENGTH OF MATERIALS");
                    sublist.add("CE 202 FLUID MECHANICS");
                    sublist.add("CE 203 BUILDING TECHNOLOGY");
                    sublist.add("CE 204 SURVEYING I");
                    sublist.add("CE 205 TRANSPORTATION ENGINEERING");
                    sublist.add("CE 206 SOIL AND FOUNDATION ENGINEERING");
                    sublist.add("CE 207 CONCRETE TECHNOLOGY");
                    sublist.add("CE 208 BUILDING DRAWING");
                    sublist.add("CE 209 CONSTRUCTION MATERIALS AND EQUIPMENTS");
                    sublist.add("CE 210 COMPUTER AIDED DRAWING");

                }
                else if ((item3.matches("CIVIL ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CE 301 THEORY OF STRUCTURE");
                    sublist.add("CE 302 DESIGN OF STEEL STRUCTURE");
                    sublist.add("CE 303 DESIGN OF R.C.C. STRUCTURE");
                    sublist.add("CE 304 SURVEYING II");
                    sublist.add("CE 305 WATER SUPPLY AND SANITARY ENGINEERING");
                    sublist.add("CE 306 IRRIGATION ENGINEERING");
                    sublist.add("CE 307 CIVIL ENGINEERING ESTIMATING AND COSTING");
                    sublist.add("CE 308 ENVIRONMENTALENGINEERING");
                    sublist.add("CE 309 CONSTRUCTION MANAGEMENT AND ACCOUNTS");
                    sublist.add("CE 310 EARTHQUAKE RESISTANT STRUCTURE");
                }
                else if ((item3.matches("ELECTRICAL ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("EE 201 BASIC ELECTRONICS");
                    sublist.add("EE 202 Basic Mechanical Engineering");
                    sublist.add("EE 203 Basic Electrical Engineering");
                    sublist.add("EE 204 Electrical Measurement & Instrumentation");
                    sublist.add("EE 205 Electrical Circuit Theory");
                    sublist.add("EE 206 Electrical Machines - 1");
                    sublist.add("EE 207 Power System - 1");
                    sublist.add("EE 208 Microprocessor & C-Programming");
                    sublist.add("EE 209 Electrical Workshop");
                    sublist.add("EE 210 Management");
                }
                else if ((item3.matches("ELECTRICAL ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("EE 301 Power Electronics & Drives");
                    sublist.add("EE 302 Utilization of Electrical Power & Traction");
                    sublist.add("EE 303 Estimating, Costing & Design of Electrical Installations");
                    sublist.add("EE 304 Electrical Design & Drawing");
                    sublist.add("EE 305 Fundamentals of Control System");
                    sublist.add("EE 306 Electrical Machines - 2");
                    sublist.add("EE 307 Power System - 2");
                    sublist.add("EE 308 Power System - 3");
                    sublist.add("EE 309 Switchgear & Protection");
                    sublist.add("EE 310 Energy Management");
                }
                else if ((item3.matches("COMPUTER SCIENCE & ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CS 201 PROGRAMMING AND PROBLEM SOLVING THROUGH C");
                    sublist.add("CS 202 COMPUTER SYSTEM ARCHITECTURE");
                    sublist.add("CS 203 OPERATING SYSTEM PRINCIPLE");
                    sublist.add("CS 204 BASICS OF ELECTRONIC DEVICES AND CIRCUITS");
                    sublist.add("CS 205 BASICS OF DIGITAL ELECTRONICS");
                    sublist.add("CS 206 DATA COMMUNICATION");
                    sublist.add("CS 207 DATA BASE MANAGEMENT SYSTEM");
                    sublist.add("CS 208 MICROPROCESSOR AND INTERFACING");
                    sublist.add("CS 209 INTERNET AND WEB TECHNOLOGIES");
                    sublist.add("CS 210 PC MAINTENANCE AND TROUBLE SHOOTING");
                }
                else if ((item3.matches("COMPUTER SCIENCE & ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CS 301 DATA STRUCTURE & ALGORITHM");
                    sublist.add("CS 302 OBJECT ORIENTED PROGRAMMING THROUGH CPP");
                    sublist.add("CS 303 UNIX, SHELL PROGRAMMING AND ADMINISTRATION");
                    sublist.add("CS 304 SOFTWARE ENGINEERING");
                    sublist.add("CS 305 DOT NET TECHNOLOGY ");
                    sublist.add("CS 306 COMPUTER NETWORK");
                    sublist.add("CS 307 DATA WAREHOUSE AND MINING");
                    sublist.add("CS 308 INTRODUCTION TO NETWORK SECURITY AND CRYPTOGRAPHY");
                    sublist.add("CS 309 JAVA TOOLS");
                    sublist.add("CS 310 PHP & MYSQL");
                }
                else if ((item3.matches("MECHANICAL ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("ME 201 STRENGTH OF MATERIALS");
                    sublist.add("ME 202 FLUID MECHANICS & MACHINES");
                    sublist.add("ME 203 ENGINEERING MATERIALS AND PROCESSES");
                    sublist.add("ME 204 THEORY OF MACHINES");
                    sublist.add("ME 205 MACHINE DRAWING AND COMPUTER AIDED DRAFTING");
                    sublist.add("ME 206 BASIC AUTOMOBILE ENGINEERING");
                    sublist.add("ME 207 ELECTRICAL & ELECTRONICS ENGINEERING");
                    sublist.add("ME 208 THERMODYNAMICS & I.C. ENGINES");
                    sublist.add("ME 209 WORKSHOP TECHNOLOGY & METROLOGY");
                    sublist.add("ME 210 C PROGRAMMING");
                }
                else if ((item3.matches("MECHANICAL ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("ME 301 REFRIGERATION AND AIR CONDITIONING");
                    sublist.add("ME 302 PROCESSES IN MANUFACTURING");
                    sublist.add("ME 303 THERMAL ENGINEERING & HEAT TRANSFER");
                    sublist.add("ME 304 CNC MACHINES & AUTOMATION");
                    sublist.add("ME 305 POWER GENERATION");
                    sublist.add("ME 306 ADVANCE WORKSHOP TECHNIQUES");
                    sublist.add("ME 307 INDUSTRIAL ENGINEERING");
                    sublist.add("ME 308 MACHINE DESIGN");
                    sublist.add("ME 309 MECHANICAL ESTIMATING & COSTING");
                    sublist.add("ME 310 MANAGEMENT &ENTREPRENEURSHIP");
                }
                else if ((item3.matches("CHEMICAL ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CH 201 Concepts of Heat Transfer");
                    sublist.add("CH 202 Mass Transfer");
                    sublist.add("CH 203 Chemical Process Calculations");
                    sublist.add("CH 204 Transport Phenomena");
                    sublist.add("CH 205 Organic Chemistry");
                    sublist.add("CH 206 Chemical Reaction Engg");
                    sublist.add("CH 208 Mechanical Operations");
                    sublist.add("CH 209 General chemical Technology");
                    sublist.add("CH 210 C PROGRAMMING");
                }
                else if ((item3.matches("CHEMICAL ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CH 301 Operations of Heat Transfer");
                    sublist.add("CH 302 Operations of Mass Transfer");
                    sublist.add("CH 303 Chemical Engineering Thermodynamics");
                    sublist.add("CH 304 Petroleum Technology");
                    sublist.add("CH 305 Industrial Safety And Environmental Engineering");
                    sublist.add("CH 306 Cement And Fertiliser Technology");
                    sublist.add("CH 307 Process Equipment Design And Plant Utilities");
                    sublist.add("CH 308 Instrumentation And Process control");
                    sublist.add("CH 309 Process Testing And Material Science");
                    sublist.add("CH 310 MANAGEMENT &ENTREPRENEURSHIP");
                }
                else if ((item3.matches("ARCHITECTURE ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("AR 202 MECHANICS OF STRUCTURES");
                    sublist.add("AR 203 GRAPHICAL PRESENTATION-1");
                    sublist.add("AR 206 BUILDING MATERIAL");
                    sublist.add("AR 207 THEORY OF DESIGN");
                    sublist.add("AR 209 BUILDING CONSTRUCTION-1");

                }
                else if ((item3.matches("ARCHITECTURE ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("AR 301 HISTORY OF ARCHITECTURE-2");
                    sublist.add("AR 302 BUILDING SERVICES IN ARCHITECTURE");
                    sublist.add("AR 303 GRAPHICAL PRESENTATION-2");
                    sublist.add("AR 304 ARCHITECTURE DESIGN-2");
                    sublist.add("AR 305 BUILDING BYE LAWS & MUNICIPAL DRAWING");
                    sublist.add("AR 306 ESTIMATING AND SPECIFICATIONS");
                    sublist.add("AR 308 STRUCTURAL DESIGN AND DRAWING");
                    sublist.add("AR 310 MANAGEMENT & ENTREPRENEURSHIP");
                }
                else if ((item3.matches("INSTRUMENTATION ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("IE 201 INSTRUMENTATION");
                    sublist.add("IE 202 ELECTRICAL ENGINEERING AND MEASUREMENTS");
                    sublist.add("IE 203 NETWORK ANALYSIS");
                    sublist.add("IE 204 CONCEPTS OF DIGITAL ELECTRONICS");
                    sublist.add("IE 205 CONCEPTS OF ELECTRONIC DEVICES AND CIRCUITS");
                    sublist.add("IE 206 INDUSTRIAL INSTRUMENTATION");
                    sublist.add("IE 207 TRANSDUCERS & TELEMETRY");
                    sublist.add("IE 208 CONTROL SYSTEM COMPONENTS");
                    sublist.add("IE 209 ANALYTICAL & ENVIRONMENTAL INSTRUMENTATION");
                    sublist.add("IE 210 C PROGRAMMING");

                }
                else if ((item3.matches("INSTRUMENTATION ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("IE 301 PROCESS CONTROLLER");
                    sublist.add("IE 302 OPTICAL INSTRUMENTS & DEVICES");
                    sublist.add("IE 303 CONTROL THEORY");
                    sublist.add("IE 304 MICROCONTROLLERS");
                    sublist.add("IE 305 POWER & INDUSTRIAL ELECTRONICS");
                    sublist.add("IE 306 BIOMEDICAL INSTRUMENTATION");
                    sublist.add("IE 307 APPLIED INSTRUMENTATION");
                    sublist.add("IE 308 SIGNAL CONDITIONING");
                    sublist.add("IE 309 INSTRUMENTATION WORKSHOP");
                    sublist.add("IE 310 MANAGEMENT &ENTREPRENEURSHIP");
                }
                else if ((item3.matches("MECHANICAL AUTOMOBILE ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MA 201 STRENGTH OF MATERIALS");
                    sublist.add("MA 202 FLUID MECHANICS & MACHINES ");
                    sublist.add("MA 203  ENGINEERING MATERIALS AND PROCESSES ");
                    sublist.add("MA 204 THEORY OF MACHINES");
                    sublist.add("ME 205  MACHINE DRAWING AND COMPUTER AIDED DRAFTING");
                    sublist.add("ME 206 BASIC AUTOMOBILE ENGINEERING");
                    sublist.add("ME 207 ELECTRICAL AND ELECTRONICS ENGINEERING");
                    sublist.add("MA 208 THERMODYNAMICS AND I C ENGINES");
                    sublist.add("MA 209 WORKSHOP TECHNOLOGY AND METROLOGY ENGINES");
                    sublist.add("ME 210 C PROGRAMMING");
                }
                else if ((item3.matches("MECHANICAL AUTOMOBILE ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MA 301 AUTO SHOP AND GARAGE PRACTICE ");
                    sublist.add("MA 302 PROCESSES IN MANUFACTURING");
                    sublist.add("MA 303  AUTO THERMODYNAMICS");
                    sublist.add("MA 304  CNC MACHINES & AUTOMATION");
                    sublist.add("MA 305 POWER GENERATION ");
                    sublist.add("MA 306 ADVANCE WORKSHOP TECHNIQUES");
                    sublist.add("MA 307 AUTO ELECTRICAL EQUIPMENTS ");
                    sublist.add("MA 308  VEHICLE TECHNOLOGY");
                    sublist.add("MA 309 COMPONENT DESIGN & ESTIMATION");
                    sublist.add("MA 310 INDUSTRIAL ENGG. AND TRANSPORT MANAGEMENT ");
                }
                else if ((item3.matches("MECHANICAL PRODUCTION ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MP 201 STRENGTH OF MATERIALS");
                    sublist.add("MP 202 PRODUCTION TECHNOLOGY-1");
                    sublist.add("MP 203 MANUFACTURING PROCESS");
                    sublist.add("MP 204  THERMAL ENGINEERING");
                    sublist.add("MP 206  HEAT TREATMENT AND MATERIAL SCIENCES");
                    sublist.add("MP 208  INDUSTRIAL ELECTRICAL AND ELECTRONICS");
                    sublist.add("MP 209  INDUSTRIAL HYDRAULICS");
                    sublist.add("MP 210 C PROGRAMMING");
                }
                else if ((item3.matches("MECHANICAL PRODUCTION ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MP 301 QUALITY AND ENVIRONMENTAL ENGINEERING");
                    sublist.add("MP 303 TOOL ENGINEERING");
                    sublist.add("MP 306  PRODUCTION SYSTEM MANAGEMENT");
                    sublist.add("MP 307 INDUSTRIAL ENGINEERING");
                    sublist.add("MP 308 METAL FORMING PROCESSES");
                    sublist.add("MP 309 MEASURMENT SYSTEM ANALYSIS");
                    sublist.add("MP 310 MANAGEMENT & ENTREPRENEURSHIP");
                }
                else if ((item3.matches("MECHANICAL RAC ENGINEERING")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MR 201 BASIC REFRIGERATION");
                    sublist.add("MR 202 BASIC AIR CONDITIONING");
                    sublist.add("MR 203 HEAT TRANSFER");
                    sublist.add("MR 204 THERMAL ENGINEERING");
                    sublist.add("MR 206 ELECTRICAL ENGINEERING");
                    sublist.add("MR 207 FLUID ENGINEERING");
                    sublist.add("MR 208 MAINTENANCE AND SAFETY ENGINEERING");
                    sublist.add("MR 209 ENTREPRENEURSHIP DEVELOPMENT");
                    sublist.add("MR 210 C PROGRAMMING");
                }
                else if ((item3.matches("MECHANICAL RAC ENGINEERING")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MR 301 ADVANCE REFRIGERATION");
                    sublist.add("MR 302 ADVANCE AIR CONDITIONING");
                    sublist.add("MR 303 SYSTEM CONTROL & INSTRUMENTATION");
                    sublist.add("MR 307 A/C DESIGN & DRAWING");
                    sublist.add("MR 309 FIRE PREVENTION & PROTECTION");
                    sublist.add("MR 310 INDUSTRIAL MANAGEMENT");
                }
                else if ((item3.matches("BEAUTY CULTURE")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("BC 201 COMPUTER APPLICATION - II");
                    sublist.add("BC 202 ENVIRONMENTAL STUDIES");
                    sublist.add("BC 203 ENTREPRENEURSHIP & PARLOUR MANAGEMENT");
                    sublist.add("BC 204 COSMETIC SCIENCE");
                    sublist.add("BC 205 BEAUTY CULTURE - II");
                    sublist.add("BC 206 HAIR DRESSING - II");
                    sublist.add("BC 207 COMMON DISORDERS OF SKIN HAIR & SCALP");
                    sublist.add("BC 208 BODY PERFECTION AND YOGA - II");
                }
                else if ((item3.matches("COMMERCIAL ART")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CA 201 COMPUTER APPLICATION-2");
                    sublist.add("CA 203 PROFESSIONAL STUDIES-1");
                    sublist.add("CA 204 PHOTOGRAPHY");
                    sublist.add("CA 205 DRAWING & ILLUSTRATION-2");
                    sublist.add("CA 206 ADVERTISING DESIGN-1");
                    sublist.add("CA 208 GRAPHIC DESIGN-2");
                }
                else if ((item3.matches("COMMERCIAL ART")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("CA 301 PROFESSIONAL MANAGEMENT AND ENTREPRENEURSHIP");
                    sublist.add("CA 302 COPY WRITING");
                    sublist.add("CA 303 PROFESSIONAL STUDIES-2");
                    sublist.add("CA 304 ADVERTISING PHOTOGRAPHY");
                    sublist.add("CA 306 ADVERTISING DESIGN-2");
                    sublist.add("CA 307 DIGITAL DESIGNING");
                }
                else if ((item3.matches("INTERIOR DECORATION")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("ID 201 COMPUTER APPLICATION-2");
                    sublist.add("ID 202 ENVIRONMENTAL STUDIES");
                    sublist.add("ID 203 THEORY OF DESIGN");
                    sublist.add("ID 204 HISTORY OF INTERIOR DESIGN-2");
                    sublist.add("ID 205 BASIC DESIGN-2");
                    sublist.add("ID 206 INTERIOR MATERIAL AND CONSTRUCTION-2");
                    sublist.add("ID 207 INTERIOR DESIGN & FURNITURE DESIGN-1");
                    sublist.add("ID 208 WORKSHOP");
                }
                else if ((item3.matches("INTERIOR DECORATION")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("ID 301 PROFESSIONAL MANAGEMENT AND ENTREPRENEURSHIP");
                    sublist.add("ID 302 COMPUTER AIDED DESIGN");
                    sublist.add("ID 303 INTERIOR SPECIFICATION & QUANTITY ESTIMATION");
                    sublist.add("ID 304 BUILDING SERVICES");
                    sublist.add("ID 305 NATURAL INTERIOR SCAPING");
                    sublist.add("ID 306 INTERIOR MATERIAL & CONSTRUCTION-3");
                    sublist.add("ID 307 INTERIOR DESIGN & FURNITURE DESIGN-2");
                    sublist.add("ID 308 APPLIED DESIGN & DRAWING");
                }
                else if ((item3.matches("TEXTILE DESIGN")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("TD 201 COMPUTER APPLICATION-2");
                    sublist.add("TD 202 ENVIRONMENTAL STUDIES");
                    sublist.add("TD 203 DYEING AND PRINTING-1");
                    sublist.add("TD 204 STRUCTURAL FABRIC DESIGN-2");
                    sublist.add("TD 205 INDIAN TRADITIONAL TEXTILE");
                    sublist.add("TD 206 INTRODUCTION TO TEXTILE ART AND CRAFT-2");
                    sublist.add("TD 207 DRAWING AND RENDERING");
                    sublist.add("TD 208 CREATIVE TEXTILE DESIGN-1");
                }
                else if ((item3.matches("TEXTILE DESIGN")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("TD 301 PROFESSIONAL MANAGEMENT AND ENTERPRENEURSHIP");
                    sublist.add("TD 302 COMPUTER AIDED TEXTILE DESIGN");
                    sublist.add("TD 303 DYEING AND PRINTING-2");
                    sublist.add("TD 304 STRUCTURL FABRIC DESIGN");
                    sublist.add("TD 305 BASIC TEXTILE KNITTING");
                    sublist.add("TD 306 FASHION DESIGN AND ILLUSTRATION");
                    sublist.add("TD 307 FREE HAND DRAWING AND PAINTING");
                    sublist.add("TD 308 CREATIVE TEXTILE DESIGN-2");
                }
                else if ((item3.matches("MODERN OFFICE MANAGEMENT")) && (item2.matches("Second Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MO 201 ENVIRONMENT & MARKETING MANAGEMENT");
                    sublist.add("MO 203 COMMUNICATION SKILL - II");
                    sublist.add("MO 204 SHORTHAND & TYPE IN HINDI - II");
                    sublist.add("MO 205 SHORTHAND & TYPE IN ENGLISH - II");
                    sublist.add("MO 206 Business Corespondance-I");
                    sublist.add("MO 207 HUMAN RELATION & ORGANISATION BEHAVIOUR");
                }
                else if ((item3.matches("MODERN OFFICE MANAGEMENT")) && (item2.matches("Third Year")))
                {
                    spinner4.setEnabled(true);
                    //branchlist.clear();
                    sublist.clear();
                    sublist.add("Select Subject");
                    spinner5.setEnabled(false);
                    forthAdapter.notifyDataSetChanged();
                    sublist.add("MO 301 ENTERPRENEURSHIP DEVELOPMENT");
                    sublist.add("MO 302 COMPUTER APPLICATION-III");
                    sublist.add("MO 303 COMMUNICATION SKILL-III");
                    sublist.add("MO 304 SHORTHAND & TYPE IN HINDI ");
                    sublist.add("MO 305 SHORTHAND & TYPE IN ENGLISH-III");
                    sublist.add("MO 306 BUSINESS CORRESPONDENCE-II");
                    sublist.add("MO 307 BUSINESS LAW AND ENVIRONMENT");
                    sublist.add("MO 308 HUMAN RESOURCE MANAGEMENT");
                }
                else
                {
                    spinner4.setEnabled(false);
                    //spinner4.setPrompt("Select Subject");
                    spinner5.setEnabled(false);
                    //spinner5.setPrompt("Select Unit");
                    sublist.clear();
                    sublist.add("Select Subject");
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    thirdAdapter.notifyDataSetChanged();
                    forthAdapter.notifyDataSetChanged();
                    fifthAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        thirdAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner3.setAdapter(thirdAdapter);


        sublist.add("Select Subject");
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent4, View view, int position, long id) {
                item4 = parent4.getItemAtPosition(position).toString();

                if (item4.matches("EL 201 ELECTRONIC COMPONENTS AND SHOP PRACTICE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Resistor");
                    unitlist.add("Unit 2: Capacitor");
                    unitlist.add("Unit 3: Inductors and Coil");
                    unitlist.add("Unit 4: Soldering and De-Soldering Techniques");
                    unitlist.add("Unit 5: Printed Circuit Board Fabrication");
                    unitlist.add("Unit 6: Transformer");
                    unitlist.add("Unit 7: Brief idea of surface mounted devices(SMD)");
                }
                else if (item4.matches("EL 202 CIRCUIT ANALYSIS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: General Network Concept");
                    unitlist.add("Unit 2: Mesh and Nodal Analysis");
                    unitlist.add("Unit 3: Network Theorems");
                    unitlist.add("Unit 4: Laplace Transformation");
                    unitlist.add("Unit 5: Two Port Networks");
                    unitlist.add("Unit 6: Resonance");
                    unitlist.add("Unit 7: Line Filters");
                }
                else if (item4.matches("EL 203 ELECTRONIC MEASUREMENT AND INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Basic Concept of Measurement");
                    unitlist.add("Unit 2: Transducers");
                    unitlist.add("Unit 3: Measuring Instruments");
                    unitlist.add("Unit 4: Range Extension and Calibration");
                    unitlist.add("Unit 5: Signal Conditioning");
                    unitlist.add("Unit 6: Control System");
                    unitlist.add("Unit 7: Control System Components");
                }
                else if (item4.matches("EL 204 ELECTRONIC DEVICES AND CIRCUITS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Semiconductor and PN Junction");
                    unitlist.add("Unit 2: Bipolar Junction Transistor (BJT)");
                    unitlist.add("Unit 3: Transistor Biasing and Bias Stability");
                    unitlist.add("Unit 4: Field Effect Transistor");
                    unitlist.add("Unit 5: Rectifiers and Power Supplies");
                    unitlist.add("Unit 6: Filter Circuits");
                    unitlist.add("Unit 7: Clipper and Clamping Circuit");
                }
                else if (item4.matches("EL 205 DIGITAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction");
                    unitlist.add("Unit 2: Boolean Algebra");
                    unitlist.add("Unit 3: Logic Gates");
                    unitlist.add("Unit 4: Minimization Techniques ( K-Mapping)");
                    unitlist.add("Unit 5: Combinational Logic Design");
                    unitlist.add("Unit 6: Sequential Systems");
                }
                else if (item4.matches("EL 206 WAVE PROPAGATION AND COMMUNICATION ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction");
                    unitlist.add("Unit 2: EM Wave Propagation");
                    unitlist.add("Unit 3: Antennas");
                    unitlist.add("Unit 4: Noise and Cross Talk");
                    unitlist.add("Unit 5: Amplitude Modulation");
                    unitlist.add("Unit 6: Frequency Modulation");
                    unitlist.add("Unit 7: Radio Receivers");
                }
                else if (item4.matches("EL 207 MICROPROCESSOR"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Number System");
                    unitlist.add("Unit 2: Introduction of Microprocessor");
                    unitlist.add("Unit 3: The 8085 Architecture");
                    unitlist.add("Unit 4: 8085 Instructions and Programming");
                    unitlist.add("Unit 5: Memory and I/O System");
                    unitlist.add("Unit 6: Instruction Execution and Timings");
                    unitlist.add("Unit 7: Limitation of 8 bit Microprocessor");
                }
                else if (item4.matches("EL 208 AUDIO AND VIDEO SYSTEM"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Basic Components of Audio and Video");
                    unitlist.add("Unit 2: HI-FI and Stereophony");
                    unitlist.add("Unit 3: Scanning and Composite Video Signal");
                    unitlist.add("Unit 4: T.V. Signal Transmission");
                    unitlist.add("Unit 5: T.V. Receiver");
                    unitlist.add("Unit 6: Colour T.V.");
                    unitlist.add("Unit 7: Basic Concept of New Trends");
                }
                else if (item4.matches("EL 209 ELECTRONIC INSTRUMENT"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Multimeter");
                    unitlist.add("Unit 2: Electronic Voltmeter");
                    unitlist.add("Unit 3: Cathode Ray Oscilloscope (C.R.O)");
                    unitlist.add("Unit 4: Working Principle and Application of");
                    unitlist.add("Unit 5: Digital Displays");
                    unitlist.add("Unit 6: Guarding Technique");
                }
                else if (item4.matches("EL 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction");
                    unitlist.add("Unit 2: Elements of C");
                    unitlist.add("Unit 3: Console Input-Output");
                    unitlist.add("Unit 4: Control Flow");
                    unitlist.add("Unit 5: Arrays");
                    unitlist.add("Unit 6: Functions");
                    unitlist.add("Unit 7: Pointers");
                    unitlist.add("Unit 8: Structure and Enumerated Data Types");
                }
                else if (item4.matches("EF 201 ELECTRONIC COMPONENT AND SHOP PRACTICE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Resistors ");
                    unitlist.add("Unit 2. Capacitors ");
                    unitlist.add("Unit 3. Inductors and Coil ");
                    unitlist.add("Unit 4. Soldering and De-Soldering Techniques ");
                    unitlist.add("Unit 5. Printed Circuit Board Fabrication ");
                    unitlist.add("Unit 6. Transformer");
                    unitlist.add("Unit 7. Brief idea of surface mounted devices. (SMD)");
                }
                else if (item4.matches("EF 202 CIRCUIT ANALYSIS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. General Network Concept ");
                    unitlist.add("Unit 2. Mesh and Nodal Analysis ");
                    unitlist.add("Unit 3. Network Theorems ");
                    unitlist.add("Unit 4. Laplace Transformation ");
                    unitlist.add("Unit 5. Two Port Networks");
                    unitlist.add("Unit 6. Resonance ");
                    unitlist.add("Unit 7. Line Filters");
                }
                else if (item4.matches("EF 203 ELECTRONIC MEASUREMENT AND INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic Concept of Measurement ");
                    unitlist.add("Unit 2. Transducers ");
                    unitlist.add("Unit 3. Measuring Instruments ");
                    unitlist.add("Unit 4. Range Extension and Calibration ");
                    unitlist.add("Unit 5. Signal Conditioning ");
                    unitlist.add("Unit 6. Control System ");
                    unitlist.add("Unit 7. Control System Components ");
                }
                else if (item4.matches("EF 204 ELECTRONIC DEVICES AND CIRCUITS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Semiconductor and PN Junction ");
                    unitlist.add("Unit 2. Bipolar Junction Transistor (BJT) ");
                    unitlist.add("Unit 3. Transistor Biasing and Bias Stability ");
                    unitlist.add("Unit 4. Field Effect Transistor ");
                    unitlist.add("Unit 5. Rectifiers and Power Supplies ");
                    unitlist.add("Unit 6. Filter Circuits ");
                    unitlist.add("Unit 7. Clipper and Clamping Circuit ");
                }
                else if (item4.matches("EF 205 DIGITAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction ");
                    unitlist.add("Unit 2. Boolean Algebra ");
                    unitlist.add("Unit 3. Logic Gates ");
                    unitlist.add("Unit 4. Minimization Techniques ( K-Mapping) ");
                    unitlist.add("Unit 5. Combinational Logic Design ");
                    unitlist.add("Unit 6. Sequential Systems ");
                }
                else if (item4.matches("EF 206 WAVE PROPOGATION AND COMMUNICATION ENGG."))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction ");
                    unitlist.add("Unit 2. EM Wave Propagation ");
                    unitlist.add("Unit 3. Antennas ");
                    unitlist.add("Unit 4. Noise and Cross Talk ");
                    unitlist.add("Unit 5. Amplitude Modulation ");
                    unitlist.add("Unit 6. Frequency Modulation ");
                    unitlist.add("Unit 7. Radio Receivers ");
                }
                else if (item4.matches("EF 207 MICROPROCESSOR"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Number System ");
                    unitlist.add("Unit 2. Introduction of Microprocessor ");
                    unitlist.add("Unit 3. The 8085 Architecture ");
                    unitlist.add("Unit 4. 8085 Instructions and Programming ");
                    unitlist.add("Unit 5. Memory and I/O System ");
                    unitlist.add("Unit 6. Instruction Execution and Timings ");
                    unitlist.add("Unit 7. Limitation of 8 bit Microprocessor.");
                }
                else if (item4.matches("EF 208 AUDIO AND VIDEO SYSTEM"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic Components of Audio and Video ");
                    unitlist.add("Unit 2. HI-FI and Stereophony ");
                    unitlist.add("Unit 3. Scanning and Composite Video Signal ");
                    unitlist.add("Unit 4. T.V. Signal Transmission ");
                    unitlist.add("Unit 5. T.V. Receiver ");
                    unitlist.add("Unit 6. Colour T.V. ");
                    unitlist.add("Unit 7. Basic Concept of New Trends ");
                }
                else if (item4.matches("EF 209 ELECTRONIC INSTRUMENT"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Multimeter ");
                    unitlist.add("Unit 2. Electronic Voltmeter ");
                    unitlist.add("Unit 3. Cathode Ray Oscilloscope (C.R.O) ");
                    unitlist.add("Unit 4. Working Principle and Application of ");
                    unitlist.add("Unit 5. Digital Displays ");
                    unitlist.add("Unit 6. Guarding Techniques");
                }
                else if (item4.matches("EF 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction ");
                    unitlist.add("Unit 2. Elements of C");
                    unitlist.add("Unit 3. Console Input-Output ");
                    unitlist.add("Unit 4. Control Flow ");
                    unitlist.add("Unit  5. Arrays  ");
                    unitlist.add("Unit 6. Functions ");
                    unitlist.add("Unit 7. Pointers ");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types ");
                }
                else if (item4.matches("EL 301 ELECTRONIC CIRCUITS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: JFET  and  MOSFET Amplifiers");
                    unitlist.add("Unit 2: Multistage Amplifier");
                    unitlist.add("Unit 3: Power Amplifier");
                    unitlist.add("Unit 4: Feedback Amplifier");
                    unitlist.add("Unit 5: Oscillators");
                    unitlist.add("Unit 6: Transistor at High Frequency and Special Circuit");
                    unitlist.add("Unit 7: Multivibrator");
                    unitlist.add("Unit 8: Blocking Oscillator and Time Base Generators");
                }
                else if (item4.matches("EL 302 ADVANCE MICROPROCESSOR AND MICROCONTROLLER"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: 8086 Microprocessor");
                    unitlist.add("Unit 2: 8086 Instructions and Programming");
                    unitlist.add("Unit 3: I/O Data Transfer Schemes");
                    unitlist.add("Unit 4: Peripheral Devices and their Interfacing with 8085");
                    unitlist.add("Unit 5: Bus Standards");
                    unitlist.add("Unit 6: Introduction to 8051 Microcontroller");
                }
                else if (item4.matches("EL 303 ADVANCE COMMUNICATION SYSTEM"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Pulse Modulation");
                    unitlist.add("Unit 2: Digital Communication");
                    unitlist.add("Unit 3: Information Theory");
                    unitlist.add("Unit 4: Facsimile System");
                    unitlist.add("Unit 5: Satellite Communication");
                    unitlist.add("Unit 6: Mobile Communication");
                }
                else if (item4.matches("EL 304 MICROWAVE AND OPTICAL FBER ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Microwave");
                    unitlist.add("Unit 2: Microwave Vacuum Tube Devices");
                    unitlist.add("Unit 3: Microwave Solid State Devices");
                    unitlist.add("Unit 4: Microwave Components");
                    unitlist.add("Unit 5: Microwave Measurement");
                    unitlist.add("Unit 6: Optical Fibre Communication");
                }
                else if (item4.matches("EL 305 POWER AND INDUSTRIAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction");
                    unitlist.add("Unit 2: Power Control and Rectifiers");
                    unitlist.add("Unit 3: Inverters, Choppers and Cyclo-converters");
                    unitlist.add("Unit 4: AC Stabilizer and Power Supply");
                    unitlist.add("Unit 6: Heating, Welding and their Application");
                }
                else if (item4.matches("EL 306 BIO-MEDICAL INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction to Physiology");
                    unitlist.add("Unit 2: Medical Electrodes");
                    unitlist.add("Unit 3: Bio Medical Recording System");
                    unitlist.add("Unit 4: Electro Cardiograph (E.C.G.)");
                    unitlist.add("Unit 5: Pace Makers");
                    unitlist.add("Unit 6: Blood Pressure Monitoring");
                    unitlist.add("Unit 7: Defibrillator");
                    unitlist.add("Unit 8: Biomedical Instruments");
                    unitlist.add("Unit 9: Bed Patient Monitoring System");
                    unitlist.add("Unit 10: Introduction to Bioinformatics");
                    unitlist.add("Unit 11: Use of Nanotechnology in biomedical (Brief idea)");
                }
                else if (item4.matches("EL 307 LINEAR INTEGRATED CIRCUITS AND DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: IC Fabrication");
                    unitlist.add("Unit 2: Operational Amplifier");
                    unitlist.add("Unit 3: Timer Chip 555");
                    unitlist.add("Unit 4: Voltage Regulation");
                    unitlist.add("Unit 5: Phase Locked Loop");
                    unitlist.add("Unit 6: Design of Digital Circuits");
                }
                else if (item4.matches("EL 308 TELECOMMUNICATION AND SWITCHING NETWORKS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction");
                    unitlist.add("Unit 2: Electronic Space Switching");
                    unitlist.add("Unit 3: Time Division Switching");
                    unitlist.add("Unit 4: Traffic Analysis");
                    unitlist.add("Unit 5: Brief Idea of");
                }
                else if (item4.matches("EL 309 COMPUTER COMMUNICATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Introduction");
                    unitlist.add("Unit 2: Network Fundamental");
                    unitlist.add("Unit 3: Data Link and Medium Access");
                    unitlist.add("Unit 4: Backbone Networks");
                    unitlist.add("Unit 5: Network Protocols");
                }
                else if (item4.matches("EL 310 MANAGEMENT AND ENTERPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: Principles of Management");
                    unitlist.add("Unit 2: Human Resources Development");
                    unitlist.add("Unit 3: Wages and Incentives");
                    unitlist.add("Unit 4: Material Management");
                    unitlist.add("Unit 5: Financial Management");
                    unitlist.add("Unit 6: Marketing Management");
                    unitlist.add("Unit 7: Entrepreneurship");
                    unitlist.add("Unit 8: Entrepreneurial Development");
                    unitlist.add("Unit 9: Entrepreneurship Support System");
                    unitlist.add("Unit 10: Setting up SSI");
                    unitlist.add("Unit 11: Tax System and Insurance");
                    unitlist.add("Unit 12: Financial Sources for SSI");
                    unitlist.add("Unit 13: Labour Legislation and Pollution Control Acts");
                    unitlist.add("Unit 14: Project Report");
                    unitlist.add("Unit 15: ISO  9000 Series of Quality System");
                }
                else if (item4.matches("EF 301 ELECTRONIC CIRCUITS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. JFET  and  MOSFET Amplifiers ");
                    unitlist.add("Unit 2. Multistage Amplifier ");
                    unitlist.add("Unit 3. Power Amplifier ");
                    unitlist.add("Unit 4. Feedback Amplifier ");
                    unitlist.add("Unit 5. Oscillators ");
                    unitlist.add("Unit 6. Transistor at High Frequency and Special Circuit ");
                    unitlist.add("Unit 7. Multivibrator ");
                    unitlist.add("Unit 8. Blocking Oscillator and Time Base Generators");
                }
                else if (item4.matches("EF 302 ADVANCED MICROPROCESSOR AND MICROCONTROLLER"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. 8086 Microprocessor ");
                    unitlist.add("Unit 2. 8086 Instructions and Programming ");
                    unitlist.add("Unit 3. I/O Data Transfer Schemes ");
                    unitlist.add("Unit 4. Peripheral Devices and their Interfacing with 8085 ");
                    unitlist.add("Unit 5. Bus Standards ");
                    unitlist.add("Unit 6. Introduction to 8051 Microcontroller ");
                }
                else if (item4.matches("EF 303 FIBER OPTICS ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Nature of Light ");
                    unitlist.add("Unit 2. Introduction to Optical Fibers ");
                    unitlist.add("Unit 3. Fiber Characteristics ");
                    unitlist.add("Unit 4. Fiber Materials ");
                    unitlist.add("Unit 5. Fiber Fabrication ");
                    unitlist.add("Unit 6. Fiber Losses ");
                }
                else if (item4.matches("EF 304 FIBER OPTIC DEVICES AND INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Optical Sources ");
                    unitlist.add("Unit 2. Detectors ");
                    unitlist.add("Unit 3. Connectors ");
                    unitlist.add("Unit 4. Splicers ");
                    unitlist.add("Unit 5. Couplers and Splitters ");
                    unitlist.add("Unit 6. Cables ");
                    unitlist.add("Unit 7. Fiber Measurement ");
                    unitlist.add("Unit 8. Project Formulation, Implementation and System Maintenance ");
                }
                else if (item4.matches("EF 305 POWER AND INDUSTRIAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction ");
                    unitlist.add("Unit 2. Power Control and Rectifiers ");
                    unitlist.add("Unit 3. Inverters, Choppers and Cyclo-converters ");
                    unitlist.add("Unit 4. AC Stabilizer and Power Supply ");
                    unitlist.add("Unit 5. A.C., D.C. Motors & control");
                    unitlist.add("Unit 6. Heating, Welding and their Application ");
                }
                else if (item4.matches("EF 306  OPTICAL FIBER COMMUNICATION"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic LW Engineering System ");
                    unitlist.add("Unit 2. Transmitter Circuits ");
                    unitlist.add("Unit 3. Modulation techniques");
                    unitlist.add("Unit 4. Receiver Circuits ");
                    unitlist.add("Unit 5. Budgeting and System Design ");
                    unitlist.add("Unit 6. Wave Length Division Multiplexing ");
                }
                else if (item4.matches("EF 307 LINEAR INTEGRATED CIRCUIT AND DESIGN"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. IC Fabrication ");
                    unitlist.add("Unit 2. Operational Amplifier ");
                    unitlist.add("Unit 3. Timer Chip 555 ");
                    unitlist.add("Unit 4. Voltage Regulation ");
                    unitlist.add("Unit 5. Phase Locked Loop ");
                    unitlist.add("Unit 6. Design of Digital Circuits ");
                }
                else if (item4.matches("EF 308 OPTO ELECTRONICS, DIGITAL AND MICROWAVE ENGGINEERING"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to opto-electronics ");
                    unitlist.add("Unit 2. Integrated Optics ");
                    unitlist.add("Unit 3. Pulse Modulation System ");
                    unitlist.add("Unit 4. Digital Communication System ");
                    unitlist.add("Unit 5. Microwave ");
                    unitlist.add("Unit 6. Microwave Vacuum Tube Devices ");
                    unitlist.add("Unit 7. Microwave Measurements ");
                }
                else if (item4.matches("EF 309 COMPUTER COMMUNICATION"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction ");
                    unitlist.add("Unit 2. Network Fundamental ");
                    unitlist.add("Unit 3. Data Link and Medium Access ");
                    unitlist.add("Unit 4. Backbone Networks ");
                    unitlist.add("Unit 5. Network Protocols ");
                }
                else if (item4.matches("EF 310 MANAGEMENT AND ENTERPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management ");
                    unitlist.add("Unit 2. Human Resources Development ");
                    unitlist.add("Unit 3. Wages and Incentives ");
                    unitlist.add("Unit 4. Material Management ");
                    unitlist.add("Unit 5. Financial Management ");
                    unitlist.add("Unit 6. Marketing Management ");
                    unitlist.add("Unit 7. Entrepreneurship ");
                    unitlist.add("Unit 8. Entrepreneurial Development ");
                    unitlist.add("Unit 9. Entrepreneurship Support System");
                    unitlist.add("Unit 10. Setting up SSI ");
                    unitlist.add("Unit 11. Tax System and Insurance ");
                    unitlist.add("Unit 12. Financial Sources for SSI ");
                    unitlist.add("Unit 13. Labour Legislation and Pollution Control Acts ");
                    unitlist.add("Unit 14. Project Report ");
                    unitlist.add("Unit 15. ISO  9000 Series of Quality System ");
                }
                else if (item4.matches("1001 Mathematics-I"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. TRIGONOMETRY");
                    unitlist.add("Unit 2. DIFFERENTIAL CALCULUS");
                    unitlist.add("Unit 3. COMPLEX NUMBERS");
                    unitlist.add("Unit 4. PARTIAL FRACTIONS");
                    unitlist.add("Unit 5. PERMUTATIONS, COMBINATIONS AND BINOMIAL THEOREM");
                }
                else if (item4.matches("1002 Applied Physics-I"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. PHYSICAL WORLD, UNITS AND MEASUREMENTS");
                    unitlist.add("Unit 2. FORCE WORK AND ENERGY");
                    unitlist.add("Unit 3. ROTATIONAL MOTION");
                    unitlist.add("Unit 4. PROPERTIES OF MATTER");
                    unitlist.add("Unit 5. HEAT AND THERMOMETRY");
                }
                else if (item4.matches("1003 Applied Chemistry"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Atomic Structure, Chemical Bonding and Solutions:");
                    unitlist.add("Unit 2. WATER");
                    unitlist.add("Unit 3. ENGINEERING MATERIALS");
                    unitlist.add("Unit 4. CHEMISTRY OF FUELS AND LUBRICANTS");
                    unitlist.add("Unit 5. ELECTRO CHEMISTRY");
                }
                else if (item4.matches("1004 Communication Skills in English"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. COMMUNICATION THEORY AND PRACTICE");
                    unitlist.add("Unit 2. SOFT SKILLS FOR PROFESSIONAL EXCELLENCE");
                    unitlist.add("Unit 3. READING COMPREHENSION");
                    unitlist.add("Unit 4. PROFESSIONAL WRITING");
                    unitlist.add("Unit 5. VOCABULARY AND GRAMMAR");
                }
                else if (item4.matches("CE 201 STRENGTH OF MATERIALS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Simple Stress and Strain");
                    unitlist.add("Unit 2. Compound Stress");
                    unitlist.add("Unit 3. Strain Energy:");
                    unitlist.add("Unit 4. Bending Moments and Shear Force:");
                    unitlist.add("Unit 5. Moment of Inertia:");
                    unitlist.add("Unit 6. Bending Stresses in Beams:");
                    unitlist.add("Unit 7. Shear Stress in Beams:");
                    unitlist.add("Unit 8. Deflection:");
                    unitlist.add("Unit 9. Columns and Struts:");
                    unitlist.add("Unit 10. Torsion of Shaft:");
                    unitlist.add("Unit 11. Springs:");
                    unitlist.add("Unit 12. Thin Cylindrical Shells:");
                    unitlist.add("Unit 13. Combined Direct and Bending Stress:");

                }
                else if (item4.matches("CE 202 FLUID MECHANICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Fluid Pressure and its Measurement:");
                    unitlist.add("Unit 3. Hydrostatics:");
                    unitlist.add("Unit 4. Hydrokinematics :");
                    unitlist.add("Unit 5. Hydrodynamics and Measurement of Flow:");
                    unitlist.add("Unit 6. Orifices and Notches:");
                    unitlist.add("Unit 7. Flow Through Pipes:");
                    unitlist.add("Unit 8. Flow through Channels:");
                    unitlist.add("Unit 9. Turbines :");
                    unitlist.add("Unit 10. Pumps :");

                }
                else if (item4.matches("CE 203 BUILDING TECHNOLOGY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Foundation :");
                    unitlist.add("Unit 3. Walls :");
                    unitlist.add("Unit 4. Brick Masonry :");
                    unitlist.add("Unit 5. Stone Masonry :");
                    unitlist.add("Unit 6. Scaffolding, Shoring and Underpinning :");
                    unitlist.add("Unit 7. Dampness and its Prevention:");
                    unitlist.add("Unit 8. Arches and Lintels :");
                    unitlist.add("Unit 9. Doors :");
                    unitlist.add("Unit 10. Windows :");
                    unitlist.add("Unit 11. Stairs and Stair Cases :");
                    unitlist.add("Unit 12. Roofs :");
                    unitlist.add("Unit 13. Floors :");
                    unitlist.add("Unit 14. Finishing of buildings :");
                    unitlist.add("Unit 15. Building Bye Laws :");
                    unitlist.add("Unit 16. Basic Principles of Building Planning:");
                    unitlist.add("Unit 17. Orientation :");
                    unitlist.add("Unit 18. Site Selection :");
                    unitlist.add("Unit 19. Design of Buildings :");

                }
                else if (item4.matches("CE 204 SURVEYING I"))
                {
                    spinner5.setEnabled(true);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Chain Surveying :");
                    unitlist.add("Unit 3. Compass Surveying :");
                    unitlist.add("Unit 4. Levelling :");
                    unitlist.add("Unit 5. Contouring :");
                    unitlist.add("Unit 6. Plane Table Surveying :");
                    unitlist.add("Unit 7. Minor Instrument :");
                }
                else if (item4.matches("CE 205 TRANSPORTATION ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Highway Development and Planning :");
                    unitlist.add("Unit 3. Highway Geometric Design :");
                    unitlist.add("Unit 4. Traffic Engineering :");
                    unitlist.add("Unit 5. Highway Materials :");
                    unitlist.add("Unit 6. Construction of Roads :");
                    unitlist.add("Unit 7. Highway Maintenance :");
                    unitlist.add("Unit 8. Road Drainage and Road Arboriculture :");
                    unitlist.add("Unit 9. Bridges :");
                    unitlist.add("Unit 10. Railways :");
                    unitlist.add("Unit 11. Rails :");
                    unitlist.add("Unit 12. Sleepers :");
                    unitlist.add("Unit 13. Ballast :");
                    unitlist.add("Unit 14. Fixture and Fastenings :");
                    unitlist.add("Unit 15. Railway Geometries :");
                    unitlist.add("Unit 16. Points and Crossing :");
                    unitlist.add("Unit 17. Tracks Laying :");
                    unitlist.add("Unit 18. Maintenance :");
                    unitlist.add("Unit 19. Stations and Yards :");
                    unitlist.add("Unit 20. Signallings :");
                    unitlist.add("Unit 21. Tunnelling :");

                }
                else if (item4.matches("CE 206 SOIL AND FOUNDATION ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Fundamental Definitions and Relationships :");
                    unitlist.add("Unit 3. Classification of Soils :");
                    unitlist.add("Unit 4. Permeability of Soils:");
                    unitlist.add("Unit 5. Compaction :");
                    unitlist.add("Unit 6. Consolidation :");
                    unitlist.add("Unit 7. Shear strength :");
                    unitlist.add("Unit 8. Bearing Capacity :");
                    unitlist.add("Unit 9. Earth Pressures :");
                    unitlist.add("Unit 10. Soil Exploration :");
                    unitlist.add("Unit 11. Foundation :");
                    unitlist.add("Unit 12. Pile Foundation :");
                    unitlist.add("Unit 13. Soil Stablisation :");
                }
                else if (item4.matches("CE 207 CONCRETE TECHNOLOGY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Cement :");
                    unitlist.add("Unit 2. Aggregates :");
                    unitlist.add("Unit 3. Water :");
                    unitlist.add("Unit 4. Admixtures and Construction Chemical :");
                    unitlist.add("Unit 5. Fresh Concrete :");
                    unitlist.add("Unit 6. Concrete Operation :");
                    unitlist.add("Unit 7. Strength of Concrete :");
                    unitlist.add("Unit 8. Special Concrete :");
                    unitlist.add("Unit 9. Formwork :");
                    unitlist.add("Unit 10. Quality Control at Site :");
                    unitlist.add("Unit 11. Concrete Mix Design :");
                    unitlist.add("Unit 12. Deterioration and Restoration of Concrete :");
                }
                else if (item4.matches("CE 208 BUILDING DRAWING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Detailed working plan, elevation and section of the following.");
                    unitlist.add("Unit 2. Drawing of a small residential building from measurements");
                    unitlist.add("Unit 3. Detailed working plan, elevation and section through stair-case drawing of a two storied building.");
                }
                else if (item4.matches("CE 209 CONSTRUCTION MATERIALS AND EQUIPMENTS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Stones :");
                    unitlist.add("Unit 2. Bricks :");
                    unitlist.add("Unit 3. Tiles :");
                    unitlist.add("Unit 4. Lime :");
                    unitlist.add("Unit 5. Lime Mortar :");
                    unitlist.add("Unit 6. Cement and Cement Mortar :");
                    unitlist.add("Unit 7. Timber :");
                    unitlist.add("Unit 8. Ferrous Material :");
                    unitlist.add("Unit 9. Non Ferrous Metals :");
                    unitlist.add("Unit 10. Glass :");
                    unitlist.add("Unit 11. Paints and Varnishes :");
                    unitlist.add("Unit 12. Equipment for Earth Work and Compaction :");
                    unitlist.add("Unit 13. Bitumen or Asphalt Mixing Plant :");
                    unitlist.add("Unit 14. Hauling Equipment");
                    unitlist.add("Unit 15. Equipment for Concreting :");

                }
                else if (item4.matches("CE 210 COMPUTER AIDED DRAWING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Getting Started – I");
                    unitlist.add("Unit 2. Getting Started – II");
                    unitlist.add("Unit 3. Draw Commands");
                    unitlist.add("Unit 4. Editing Commands");
                    unitlist.add("Unit 5. Drawing Aids");
                    unitlist.add("Unit 6. Creating Text");
                    unitlist.add("Unit 7. Basic Dimensioning");
                    unitlist.add("Unit 8. Inquiry Commands");
                    unitlist.add("Unit 9. Editing Dimensions");
                    unitlist.add("Unit 10. Hatching");
                    unitlist.add("Unit 11. Blocks");
                    unitlist.add("Unit 12. Plotting Drawings in AutoCAD");
                    unitlist.add("Unit 13. Draw working plan, elevation of the following.");
                }
                else if (item4.matches("CE 301 THEORY OF STRUCTURE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Frames :");
                    unitlist.add("Unit 2. Slope and Deflection :");
                    unitlist.add("Unit 3. Propped Cantilever Beam :");
                    unitlist.add("Unit 4. Fixed Beams :");
                    unitlist.add("Unit 5. Continuous Beams :");
                    unitlist.add("Unit 6. Rolling Loads :");
                    unitlist.add("Unit 7. Influence Line Diagram for the following in Simply Supported Beams :");
                    unitlist.add("Unit 8. Three Hinged Arch :");
                    unitlist.add("Unit 9. Retaining Walls :");
                    unitlist.add("Unit 10. Indeterminate Structures :");

                }
                else if (item4.matches("CE 302 DESIGN OF STEEL STRUCTURE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Bolted Connections :");
                    unitlist.add("Unit 3. Welded Connections :");
                    unitlist.add("Unit 4. Design of Tension Members:");
                    unitlist.add("Unit 5. Compression Members:");
                    unitlist.add("Unit 6. Column Bases:");
                    unitlist.add("Unit 7. Design of Beams:");
                    unitlist.add("Unit 8. Roof Trusses:");
                    unitlist.add("Unit 9. Plate Girder:");
                }
                else if (item4.matches("CE 303 DESIGN OF R.C.C. STRUCTURE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Flexural Members :");
                    unitlist.add("Unit 3. Analysis and Design of Beams :");
                    unitlist.add("Unit 4. Slabs :");
                    unitlist.add("Unit 5. Compression Members (axially loaded columns) :");
                    unitlist.add("Unit 6. Design of Footing :");
                    unitlist.add("Unit 7. Retaining Wall :");
                    unitlist.add("Unit 8. Prestressed Concrete :");
                }
                else if (item4.matches("CE 304 SURVEYING II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Theodolite :");
                    unitlist.add("Unit 2. Traverse :");
                    unitlist.add("Unit 3. Tacheometry :");
                    unitlist.add("Unit 4. Trigonometrical Levelling :");
                    unitlist.add("Unit 5. Curves :");
                    unitlist.add("Unit 6. Mine Surveying :");
                    unitlist.add("Unit 7. Modern Instruments - Brief Description :");
                }
                else if (item4.matches("CE 305 WATER SUPPLY AND SANITARY ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Water Demand and Quantity :");
                    unitlist.add("Unit 2. Quality of Water :");
                    unitlist.add("Unit 3. Treatment of Water :");
                    unitlist.add("Unit 4. Regulatory Valves :");
                    unitlist.add("Unit 5. Distribution of Water :");
                    unitlist.add("Unit 6. Rural Water Supply :");
                    unitlist.add("Unit 7. System of Sanitation :");
                    unitlist.add("Unit 8. Quantity of Sewage :");
                    unitlist.add("Unit 9. Characteristics and Composition of Sewage :");
                    unitlist.add("Unit 10. Building Drainage :");
                    unitlist.add("Unit 11. Sewerage Systems :");
                    unitlist.add("Unit 12. Appurtenances :");
                    unitlist.add("Unit 13. Laying of Sewers :");
                    unitlist.add("Unit 14. Maintenance :");
                    unitlist.add("Unit 15. Sewage Disposal :");
                    unitlist.add("Unit 16. Treatment and Disposal :");
                    unitlist.add("Unit 17. Rural Sanitation :");

                }
                else if (item4.matches("CE 306 IRRIGATION ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Water Requirements of Crops :");
                    unitlist.add("Unit 3. Hydrology:");
                    unitlist.add("Unit 4. Dams :");
                    unitlist.add("Unit 5. Earthen and Rock fill Dams :");
                    unitlist.add("Unit 6. Spillways :");
                    unitlist.add("Unit 7. River Training Works :");
                    unitlist.add("Unit 8. Canals :");
                    unitlist.add("Unit 9. Water Logging :");
                    unitlist.add("Unit 10. Diversion Head Works :");
                    unitlist.add("Unit 11. Cross Drainage Works :");
                    unitlist.add("Unit 12. Distributory Works :");
                    unitlist.add("Unit 13. Well Irrigation :");
                }
                else if (item4.matches("CE 307 CIVIL ENGINEERING ESTIMATING AND COSTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Rate-Analysis :");
                    unitlist.add("Unit 3. Specifications :");
                    unitlist.add("Unit 4. Detailed Estimates for Buildings :");
                    unitlist.add("Unit 5. Earth Work Calculations for Road & Rail Formation :");
                    unitlist.add("Unit 6. Preparing Detailed Estimates for the Various Items of Work from the given Drawing for");
                    unitlist.add("Unit 7. Valuation of Property and Rent Fixation :");
                    unitlist.add("Unit 8. Procedure of Works :");
                    unitlist.add("Unit 9. Stores, Tools and Plants :");
                }
                else if (item4.matches("CE 308 ENVIRONMENTALENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Environment and Ecology :");
                    unitlist.add("Unit 2. Factors Affecting Environmental Pollution :");
                    unitlist.add("Unit 3. Water Pollution :");
                    unitlist.add("Unit 4. Air Pollution :");
                    unitlist.add("Unit 5. Noise Pollution :");
                    unitlist.add("Unit 6. Land Pollution :");
                    unitlist.add("Unit 7. Environmental Impact Assessment (EIA) :");
                    unitlist.add("Unit 8. Global Environmental Issues :");
                    unitlist.add("Unit 9. Non Conventional Sources of Energy in Environmental Protection.");
                    unitlist.add("Unit 10. Pollution Control Acts :");
                    unitlist.add("Unit 11. Environment Laws :");

                }
                else if (item4.matches("CE 309 CONSTRUCTION MANAGEMENT AND ACCOUNTS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Construction Planning :");
                    unitlist.add("Unit 3. Organisation :");
                    unitlist.add("Unit 4. Construction Contracts :");
                    unitlist.add("Unit 5. Construction Labour :");
                    unitlist.add("Unit 6. Inspection and Quality Control :");
                    unitlist.add("Unit 7. Construction Safety :");
                    unitlist.add("Unit 8. Public Works Accounts :");
                }
                else if (item4.matches("CE 310 EARTHQUAKE RESISTANT STRUCTURE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Engineering Seismology :");
                    unitlist.add("Unit 2. Structural Dynamics :");
                    unitlist.add("Unit 3. Behaviour of Buildings During Earthquakes :");
                    unitlist.add("Unit 4. Provisions for Seismic Strengthening of Masonry Constructions :");
                    unitlist.add("Unit 5. Seismic Performance of Reinforced Concrete Buildings :");
                    unitlist.add("Unit 6. Ductile Detailing of Reinforced Concrete Buildings :");
                    unitlist.add("Unit 7. Disaster Management :");
                }
                else if (item4.matches("EE 201 BASIC ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Semi Conductor Diode");
                    unitlist.add("Unit 2. Bi-Polar Junction Transistor");
                    unitlist.add("Unit 3. R-C Coupled and Power Amplifier");
                    unitlist.add("Unit 4. Special Devices");
                    unitlist.add("Unit 5. Feed Back and Oscillators");
                    unitlist.add("Unit 6. Classification of Electrical Signals");
                    unitlist.add("Unit 7. Logic Gates");
                    unitlist.add("Unit 8. Boolean Algebra");
                    unitlist.add("Unit 9. Combinational Circuits");
                    unitlist.add("Unit 10. Sequential Circuits");

                }
                else if (item4.matches("EE 202 Basic Mechanical Engineering"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Mechanical Properties of Metals");
                    unitlist.add("Unit 2. Basic Concept of Thermal Engineering");
                    unitlist.add("Unit 3. Hydraulics");
                    unitlist.add("Unit 4. Pressure Measuring Devices");
                    unitlist.add("Unit 5. Bernaulli's Theorem");
                    unitlist.add("Unit 6. Pumps");
                    unitlist.add("Unit 7. Turbine");
                    unitlist.add("Unit 8. Properties of Steam");
                    unitlist.add("Unit 9.  Boilers");
                    unitlist.add("Unit 10. Steam Turbines");
                    unitlist.add("Unit 11. I.C. Engines");
                    unitlist.add("Unit 12. Transmission");
                    unitlist.add("Unit 13. Lubrication");

                }
                else if (item4.matches("EE 203 Basic Electrical Engineering"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. D.C. Circuits");
                    unitlist.add("Unit 2. Capacitance");
                    unitlist.add("Unit 3. Magnetic Circuits");
                    unitlist.add("Unit 4. Phasor Algebra");
                    unitlist.add("Unit 5. A.C. Circuits");
                    unitlist.add("Unit 6. Polyphase System");
                    unitlist.add("Unit 7. Battery");
                    unitlist.add("Unit 8. Classification of Electrical Engineering Materials :");
                    unitlist.add("Unit 9. Conducting Materials");
                    unitlist.add("Unit 10. Insulating Materials");
                    unitlist.add("Unit 11. Magnetic Materials");
                    unitlist.add("Unit 12. Special Purpose Materials");

                }
                else if (item4.matches("EE 204 Electrical Measurement & Instrumentation"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Measuring Instruments");
                    unitlist.add("Unit 2. Different Measuring Instruments");
                    unitlist.add("Unit 3. Measurement of Resistance");
                    unitlist.add("Unit 4. Potentiometers");
                    unitlist.add("Unit 5. A.C. Bridge");
                    unitlist.add("Unit 6. Brief study of");
                    unitlist.add("Unit 7. Instrumentation System");
                    unitlist.add("Unit 8. Transducers");
                    unitlist.add("Unit 9. Measurement of Following Physical Parameter using Suitable Transducers");
                    unitlist.add("Unit 10. Instrument Transformers");
                }
                else if (item4.matches("EE 205 Electrical Circuit Theory"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Network Parameters");
                    unitlist.add("Unit 2. Network Theorems");
                    unitlist.add("Unit 3. Resonance");
                    unitlist.add("Unit 4. Circuit Transients");
                    unitlist.add("Unit 5. Two Port Network");
                    unitlist.add("Unit 6. Complex Frequency and Pole-Zero Diagram");
                }
                else if (item4.matches("EE 206 Electrical Machines - 1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. D.C. Generator");
                    unitlist.add("Unit 2. D.C. Motor");
                    unitlist.add("Unit 3. Transformer");
                }
                else if (item4.matches("EE 207 Power System - 1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Thermal Power Station");
                    unitlist.add("Unit 3. Hydro Electric Power Plants");
                    unitlist.add("Unit 4. Nuclear Power Station");
                    unitlist.add("Unit 5. Diesel Power Plants");
                    unitlist.add("Unit 6. Solar Energy");
                    unitlist.add("Unit 7. Wind Energy");
                    unitlist.add("Unit 8. Bio-Gas Energy");
                    unitlist.add("Unit 9. Ocean Energy");
                }
                else if (item4.matches("EE 208 Microprocessor & C-Programming"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Microprocessors Architecture (Intel 8085 )");
                    unitlist.add("Unit 3. Programming and Application of Microprocessor");
                    unitlist.add("Unit 4. Introduction of ‘C’ Language");
                    unitlist.add("Unit 5. Elements of ‘C’");
                    unitlist.add("Unit 6. Console Input-Output");
                    unitlist.add("Unit 7. Control Flow");
                    unitlist.add("Unit 8. Arrays");
                    unitlist.add("Unit 9. Functions");
                    unitlist.add("Unit 10. Pointers");
                    unitlist.add("Unit 11. Structure and Enumerated Data Types");
                }
                else if (item4.matches("EE 209 Electrical Workshop"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Wire Joints");
                    unitlist.add("Unit 2. Wiring");
                    unitlist.add("Unit 3. Fault Investigation and Testing");
                    unitlist.add("Unit 4. Automobile Electrical System");
                    unitlist.add("Unit 5. Domestic Appliances");
                    unitlist.add("Unit 6. Introduction of Electrical Maintenance");
                    unitlist.add("Unit 7. Maintenance and Repair of Storage Batteries");
                    unitlist.add("Unit 8. Maintenance and Repair of Transformers");
                    unitlist.add("Unit 9. Maintenance and Repair of D.C. Motors");
                    unitlist.add("Unit 10. Maintenance and Repair of A.C Motors");
                    unitlist.add("Unit 11. Maintenance and Repairs of Circuit Breakers");
                    unitlist.add("Unit 12. Safety Measures");

                }
                else if (item4.matches("EE 210 Management"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Entrepreneurship");
                    unitlist.add("Unit 2. Entrepreneurship Support System");
                    unitlist.add("Unit 3. Setting up SSI");
                    unitlist.add("Unit 4. Raw Material Management");
                    unitlist.add("Unit 5. Marketing Facilities");
                    //unitlist.add("Unit 6. Financial Sources for SSI");
                    unitlist.add("Unit 7. Contracts and Tenders");
                    unitlist.add("Unit 8. Project Report");
                    unitlist.add("Unit 9. ISO  9000 Series of Quality System");
                    unitlist.add("Unit 10. Principles of Management");
                    unitlist.add("Unit 11. Human Resources Development");
                    unitlist.add("Unit 12. Wages and Incentives");
                    unitlist.add("Unit 13. Marketing Management");
                    unitlist.add("Unit 14. Tax System and Insurance");
                    unitlist.add("Unit 15. Labour Legislation and Pollution Control Acts");

                }
                else if (item4.matches("EE 301 Power Electronics & Drives"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Power Control Rectification");
                    unitlist.add("Unit 3. Inverter");
                    unitlist.add("Unit 4. Chopper");
                    unitlist.add("Unit 5. Cycloconvertor");
                    unitlist.add("Unit 6. SMPS");
                    unitlist.add("Unit 7. AC Stabilizer");
                    unitlist.add("Unit 8. Speed Control of Motors");
                    unitlist.add("Unit 9. Time");
                }
                else if (item4.matches("EE 302 Utilization of Electrical Power & Traction"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Industrial Utilization");
                    unitlist.add("Unit 2. Electric Heating");
                    unitlist.add("Unit 3. Electric Welding");
                    unitlist.add("Unit 4. Illumination");
                    unitlist.add("Unit 5 Traction Systems");
                    unitlist.add("Unit 6 Train Movement and Energy Consumption");
                    unitlist.add("Unit 7. Electric Traction Motors");
                    unitlist.add("Unit 8 Power Supply");
                }
                else if (item4.matches("EE 303 Estimating, Costing & Design of Electrical Installations"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Wiring Materials and Accessories");
                    unitlist.add("Unit 2. General Principle of Estimating and Costing");
                    unitlist.add("Unit 3. Earthing");
                    unitlist.add("Unit 4. Service Connection");
                    unitlist.add("Unit 5. Plan Estimation of 1-phase and 3-phase Electrical load");
                    unitlist.add("Unit 6. Design of Distribution Lines");
                    unitlist.add("Unit 7. Sub Station");
                    unitlist.add("Unit 8. Description and Layout of Grid Substation 33/11 and 220/132 KV");
                    //unitlist.add("Unit 9. Design of a Distribution Scheme for a Small Colony");
                }
                else if (item4.matches("EE 304 Electrical Design & Drawing"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Transformer Design");
                    unitlist.add("Unit 2. Design of Winding");
                    unitlist.add("Unit 3. D.C. Machine Design");
                    unitlist.add("Unit 4. 3-Phase Induction Motor Design");
                    unitlist.add("Unit 5. Simple Alarm and Signal Circuits");
                    unitlist.add("Unit 6. Contactor Control Circuits");
                    unitlist.add("Unit 7. Panel Wiring Diagram   Panel wiring   diagram   for  the  following with usual protective devices and showing the various equipment with suitable ranges");
                }
                else if (item4.matches("EE 305 Fundamentals of Control System"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Control System");
                    unitlist.add("Unit 2. Control System Components");
                    unitlist.add("Unit 3. Time Domain Analysis");
                    unitlist.add("Unit 4. Frequency Response");
                    unitlist.add("Unit 5. Root Locus");
                }
                else if (item4.matches("EE 306 Electrical Machines - 2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Induction Motor");
                    unitlist.add("Unit 2. Single Phase Induction Motor");
                    unitlist.add("Unit 3. Alternators");
                    unitlist.add("Unit 4. Synchronous Motors");
                    unitlist.add("Unit 5. Stability Analysis of Synchronous Machines");
                    unitlist.add("Unit 6. Special Machines");
                }
                else if (item4.matches("EE 307 Power System - 2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Transmission and Distribution");
                    unitlist.add("Unit 2. Materials used in Overhead Lines");
                    unitlist.add("Unit 3. Mechanical Design");
                    unitlist.add("Unit 4. Electrical Design");
                    unitlist.add("Unit 5. D.C. Distribution Systems");
                    unitlist.add("Unit 6. A. C. Distribution Systems");
                    unitlist.add("Unit 7. Construction of Underground Distribution Lines");
                    unitlist.add("Unit 8. Construction of Overhead Distribution Lines");
                }
                else if (item4.matches("EE 308 Power System - 3"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Load and Load Curves");
                    unitlist.add("Unit 2. Economic Aspects of Generation");
                    unitlist.add("Unit 3. Tariffs");
                    unitlist.add("Unit 4. Power Factor Improvement");
                    unitlist.add("Unit 5. Combined Operation of Power Stations");
                    unitlist.add("Unit 6. Control of Voltage and Reactive Power");
                    unitlist.add("Unit 7. Extra High Voltages Transmission");
                    unitlist.add("Unit 8. HVDC Transmission");
                    unitlist.add("Unit 9. Corona");
                }
                else if (item4.matches("EE 309 Switchgear & Protection"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Faults in Power System");
                    unitlist.add("Unit 2. Symmetrical Components");
                    unitlist.add("Unit 3. Fuses");
                    unitlist.add("Unit 4. Circuit Breakers");
                    unitlist.add("Unit 5. Protection");
                    unitlist.add("Unit 6. Protection of Alternator");
                    unitlist.add("Unit 7. Transformer Protection");
                    unitlist.add("Unit 8. Line Protection");
                    unitlist.add("Unit 9. Over Voltage Protection");
                }
                else if (item4.matches("EE 310 Energy Management"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Energy Management and Energy Planning");
                    unitlist.add("Unit 2. Energy and Power Management");
                    unitlist.add("Unit 3. Energy Audit");
                    unitlist.add("Unit 4. Energy Conversation");
                    unitlist.add("Unit 5. Environmental Aspects of Energy and Pollution Control");
                    unitlist.add("Unit 6. Energy and Sustainable Development");
                }
                else if (item4.matches("2001 Mathematics-II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: DETERMINANTS AND MATRICES");
                    unitlist.add("Unit 2: INTEGRAL CALCULUS AND DIFFERENTIAL EQUATIONS");
                    unitlist.add("Unit 3: TWO-DIMENSIONALCO-ORDINATE GEOMETRY");
                    unitlist.add("Unit 4: CIRCLE AND CONICS");
                    unitlist.add("Unit 5: VECTOR ALGEBRA");
                }
                else if (item4.matches("2002 Applied Physics"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: WAVE MOTION AND ITS APPLICATIONS");
                    //unitlist.add("Unit 2: OPTICS");
                    unitlist.add("Unit 3: ELECTROSTATICS AND CURRENT ELECTRICITY");
                    unitlist.add("Unit 4: ELECTROMAGNETISM");
                    unitlist.add("Unit 5: SEMICONDUCTOR AND MODERN PHYSICS");
                }
                else if (item4.matches("2003 Introduction to IT Systems"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: BASIC COMPUTER & INTERNET SKILLS");
                    unitlist.add("Unit 2: OPERATING SYSTEMS");
                    unitlist.add("Unit 3: BASICS OF WEB DEVELOPMENT");
                    unitlist.add("Unit 4: OFFICE TOOLS");
                    unitlist.add("Unit 5: INFORMATION SECURITY BEST PRACTICES");
                }
                else if (item4.matches("2004 Fundamentals of Electrical & Electronics Engineering"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: OVERVIEW OF ELECTRONIC COMPONENTS & SIGNALS");
                    unitlist.add("Unit 2: OVERVIEW OF BASIC (ANALOG) & DIGITAL ELECTRONICS");
                    //unitlist.add("Unit 3: ELECTRIC AND MAGNETIC CIRCUITS");
                    //unitlist.add("Unit 4: A.C. CIRCUITS");
                    //unitlist.add("Unit 5: TRANSFORMERS");
                }
                else if (item4.matches("2005 Engineering Mechanics"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1: BASICS OF MECHANICS AND FORCE SYSTEM");
                    unitlist.add("Unit 2: EQUILIBRIUM");
                    unitlist.add("Unit 3: FRICTION");
                    unitlist.add("Unit 4: CENTROID AND CENTRE OF GRAVITY");
                    unitlist.add("Unit 5: SIMPLE LIFTING MACHINE");
                }
                else if (item4.matches("ME 201 STRENGTH OF MATERIALS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Simple Stress & Strain");
                    unitlist.add("Unit 2. Compound Stress");
                    unitlist.add("Unit 3. Strain Energy:");
                    unitlist.add("Unit 4. Bending Moments and Shear Force:");
                    unitlist.add("Unit 5. Moment of Inertia:");
                    unitlist.add("Unit 6. Bending Stresses in Beams:");
                    unitlist.add("Unit 7. Shear Stress in Beams:");
                    unitlist.add("Unit 8. Deflection:");
                    unitlist.add("Unit 9. Columns and Struts:");
                    unitlist.add("Unit 10. Torsion of Shaft:");
                    unitlist.add("Unit 11. Springs:");
                    unitlist.add("Unit 12. Thin Cylindrical Shells:");
                    unitlist.add("Unit 13. Combined Direct and Bending Stress:");
                }
                else if (item4.matches("ME 202 FLUID MECHANICS & MACHINES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 11. Reciprocating Pump :");
                }
                else if (item4.matches("ME 203 ENGINEERING MATERIALS AND PROCESSES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Classification and Properties of Materials :");
                    unitlist.add("Unit 2. Structure of Metals and Their Deformation :");
                    unitlist.add("Unit 3. Ferrous Metals :");
                    unitlist.add("Unit 4. Non Ferrous Metals:");
                    unitlist.add("Unit 5. Engineering Plastics and Fibers :");
                    unitlist.add("Unit 6. Insulating Materials :");
                    unitlist.add("Unit 7. Testing of Metals and Alloys :");
                    unitlist.add("Unit 8. Fundamentals of Heat Treatment :");
                    unitlist.add("Unit 9. Welding Process :");
                    unitlist.add("Unit 10. Gas Welding :");
                    unitlist.add("Unit 11. Electric Arc Welding :");
                    unitlist.add("Unit 12. Other Welding Processes :");
                    unitlist.add("Unit 13. Modern Welding Methods :");
                    unitlist.add("Unit 14. Foundry :");
                }
                else if (item4.matches("ME 204 THEORY OF MACHINES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Simple Mechanism:");
                    unitlist.add("Unit 2. Velocity and Acceleration in Mechanism:");
                    unitlist.add("Unit 3. Dynamics of Reciprocating Parts:");
                    unitlist.add("Unit 4. Friction:");
                    unitlist.add("Unit 5. Transmission of Power:");
                    unitlist.add("Unit 6. Balancing:");
                    unitlist.add("Unit 7. Vibration:");
                    unitlist.add("Unit 8. Governors ( No derivation & numerical) :");
                    unitlist.add("Unit 9. Brakes and Dynamometer:");
                    unitlist.add("Unit 10. Gyroscope ? Introduction and principle, Gyroscopic couple");
                }
                else if (item4.matches("ME 205 MACHINE DRAWING AND COMPUTER AIDED DRAFTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Machining Symbols and Tolerances :");
                    unitlist.add("Unit 2. Working Drawing :");
                    unitlist.add("Unit 3. Assembly Drawing:");
                    unitlist.add("Unit 4.  Gear tooth profile");
                    unitlist.add("Unit 5. Cam profile");
                    unitlist.add("Unit 6. Computer Graphics");
                }
                else if (item4.matches("ME 206 BASIC AUTOMOBILE ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Suspension System:");
                    unitlist.add("Unit 3. Braking Systems :");
                    unitlist.add("Unit 4. Wheels and Tyres :");
                    unitlist.add("Unit 5. Front axle and Steering System:");
                    unitlist.add("Unit 6. Power Transmission System :");
                    unitlist.add("Unit 7. Frame and Body:");
                }
                else if (item4.matches("ME 207 ELECTRICAL & ELECTRONICS ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. D.C. Machines:");
                    unitlist.add("Unit 2. Transformer:");
                    unitlist.add("Unit 3. Induction Motor:");
                    unitlist.add("Unit 4. Industrial Drives:");
                    unitlist.add("Unit 5. Electric Heating:");
                    unitlist.add("Unit 6. Illumination:");
                    unitlist.add("Unit 7. Instrumentation and Measurement:");
                    unitlist.add("Unit 8. Semiconductor and P-_x0005_ Junction Diode:");
                    unitlist.add("Unit 9. Bipolar Junction Transistor:");
                    unitlist.add("Unit 10. Digital Electronics:");
                    unitlist.add("Unit 11. Power Electronics:");
                    unitlist.add("Unit 12. Relays Contactors and Timers:");
                    unitlist.add("Unit 13. Photo Electric Devices:");
                }
                else if (item4.matches("ME 208 THERMODYNAMICS & I.C. ENGINES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic Concept and Gas Laws :");
                    unitlist.add("Unit 2. Laws of Thermodynamics:");
                    unitlist.add("Unit 3. Availability :");
                    unitlist.add("Unit 4. Formation of Steam and its Properties :");
                    unitlist.add("Unit 5. Steam Generators:");
                    unitlist.add("Unit 6. Boiler Performance:");
                    unitlist.add("Unit 7. Gas Power Cycles:");
                    unitlist.add("Unit 8. Principles of Internal Combustion Engines :");
                    unitlist.add("Unit 9. Petrol Engines :");
                    unitlist.add("Unit 10. Diesel Engines:");
                    unitlist.add("Unit 11. Cooling, Lubrication and Governing :");
                    unitlist.add("Unit 12. I.C. Engines Performance:");
                    unitlist.add("Unit 13. Gas Turbines (No numerical problem):");
                    unitlist.add("Unit 14. Air Compressors (No numerical problem):");
                }
                else if (item4.matches("ME 209 WORKSHOP TECHNOLOGY & METROLOGY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Cutting Tools and Materials:");
                    unitlist.add("Unit 2. Lathe Machine:");
                    unitlist.add("Unit 3. Drilling Machines :");
                    unitlist.add("Unit 4. Shaping, Planning and Slotting Machines:");
                    unitlist.add("Unit 5. Cutting Fluids and Cooling Process:");
                    unitlist.add("Unit 6. Introduction to Metrology:");
                    unitlist.add("Unit 7. Linear and Angular Measurement:");
                    unitlist.add("Unit 8. Measurement of Surface Finish :");
                    unitlist.add("Unit 9. Comparators:");
                    unitlist.add("Unit 10. Light Wave Interference:");
                    unitlist.add("Unit 11. Gear and Screw Measurement:");
                    unitlist.add("Unit 12. Limits, Fits and Tolerance:");
                    unitlist.add("Unit 13. Machine Tool Metrology:");
                }
                else if (item4.matches("ME 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of 'C' :");
                    unitlist.add("Unit 3. Console Input-Output :");
                    unitlist.add("Unit 4. Control Flow :");
                    unitlist.add("Unit  5. Arrays :");
                    unitlist.add("Unit 6. Functions :");
                    unitlist.add("Unit 7. Pointers :");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types :");
                }
                else if (item4.matches("ME 301 REFRIGERATION AND AIR CONDITIONING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Refrigeration :");
                    unitlist.add("Unit 2. Refrigeration System :");
                    unitlist.add("Unit 3.  Refrigerants:");
                    unitlist.add("Unit 4.  Refrigeration System, Components and Controls :");
                    unitlist.add("Unit 5.  Refrigeration Applications :");
                    unitlist.add("Unit 6. Production of Low Temperature :");
                    unitlist.add("Unit 7. Pshychrometry :");
                    unitlist.add("Unit 8. Air-conditioning :");
                }
                else if (item4.matches("ME 302 PROCESSES IN MANUFACTURING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Metal Forming Process :");
                    unitlist.add("Unit 2. Conventional Metal Cutting Processes :");
                    unitlist.add("Unit 3. Newer Machining Processes :");
                    unitlist.add("Unit 4. Metallic Coating Processes :");
                    unitlist.add("Unit 5. Plastic Process - Working principle, Advantages and limitation of following process :");
                    unitlist.add("Unit 6. Jigs and Fixtures :");
                }
                else if (item4.matches("ME 303 THERMAL ENGINEERING & HEAT TRANSFER"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Steam Nozzles :");
                    unitlist.add("Unit 2. Steam Turbines :");
                    unitlist.add("Unit 3. Steam Condenser :");
                    unitlist.add("Unit 4. Air Pumps and Cooling Tower :");
                    unitlist.add("Unit 5. Heat Transfer :");
                    unitlist.add("Unit 6. Conduction :");
                    unitlist.add("Unit 7. Convection :");
                    unitlist.add("Unit 8. Radiation :");
                }
                else if (item4.matches("ME 304 CNC MACHINES & AUTOMATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Component of NC Machines :");
                    unitlist.add("Unit 3. Classification of Numerical Control Machines :");
                    unitlist.add("Unit 4. Constructional Details of CNC Machines :");
                    unitlist.add("Unit 5. Tooling for CNC Machines :");
                    unitlist.add("Unit 6. Fundamentals of Part Programming :");
                    unitlist.add("Unit 7. Advanced Part Programming :");
                    unitlist.add("Unit 8. Computer Aided Part Programming :");
                    unitlist.add("Unit 9. Robotics :");
                    unitlist.add("Unit 10. Automation in Manufacturing :");
                }
                else if (item4.matches("ME 305 POWER GENERATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Thermal Power Plants :");
                    unitlist.add("Unit 3. Hydro-Electric Power Plant :");
                    unitlist.add("Unit 4. Nuclear Power Plant :");
                    unitlist.add("Unit 5. Diesel Power Plants :");
                    unitlist.add("Unit 6. Gas Turbine Plants :");
                    unitlist.add("Unit 7. Power Plant Economics :");
                    unitlist.add("Unit 8. Renwal Energy Sources :");
                    unitlist.add("Unit 9. Solar Energy :");
                    unitlist.add("Unit 10. Wind Energy :");
                }
                else if (item4.matches("ME 306 ADVANCE WORKSHOP TECHNIQUES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Metal Cutting Saws :");
                    unitlist.add("Unit 2. Boring :");
                    unitlist.add("Unit 3. Milling Machine :");
                    unitlist.add("Unit 4. Grinding and Grinding Machines :");
                    unitlist.add("Unit 5. Capstan and Turret Lathes :");
                    unitlist.add("Unit 6. Automatic Machines :");
                    unitlist.add("Unit 7. Metal Finishing Processes :");
                    unitlist.add("Unit 8. Maintenance of Machine Tools :");
                    unitlist.add("Unit 9. Installation and Testing of Machine Tools :");
                }
                else if (item4.matches("ME 307 INDUSTRIAL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Production, Planning and Control :");
                    unitlist.add("Unit 2. Inventory Control :");
                    unitlist.add("Unit 3. Inspection and Quality Control :");
                    unitlist.add("Unit 4. Work Study :");
                    unitlist.add("Unit 5. Plant Location and Layout :");
                    unitlist.add("Unit 6. Material Handling :");
                    unitlist.add("Unit 7. Linear Programming :");
                    unitlist.add("Unit 8. Depreciation :");
                }
                else if (item4.matches("ME 308 MACHINE DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Design of Welding Joints :");
                    unitlist.add("Unit 3. Design of Screw and Bolts :");
                    unitlist.add("Unit 4. Design of Joints :");
                    unitlist.add("Unit 5. Design of Keys and Couplings :");
                    unitlist.add("Unit 6. Design of Shaft :");
                    unitlist.add("Unit 7. Design of Components :");
                    unitlist.add("Unit 8. Bearings (no numerical problems) :");
                    unitlist.add("Unit 9. Lever :");
                }
                else if (item4.matches("ME 309 MECHANICAL ESTIMATING & COSTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of Costs :");
                    unitlist.add("Unit 3. Break Even Analysis and Equipment Replacement Analysis :");
                    unitlist.add("Unit 4. Estimation of Material Cost :");
                    unitlist.add("Unit 5. Labour Costing :");
                    unitlist.add("Unit 6. Estimation in Machining :");
                    unitlist.add("Unit 7. Estimation in Welding Shop :");
                    unitlist.add("Unit 8. Estimation in Forging Shop :");
                    unitlist.add("Unit 9. Estimation in Pattern Making and Foundry Shop :");
                    unitlist.add("Unit 10. Estimation in Sheet Metal Shop :");
                }
                else if (item4.matches("ME 310 MANAGEMENT &ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management :");
                    unitlist.add("Unit 2. Human Resources Development :");
                    unitlist.add("Unit 3. Wages and Incentives :");
                    unitlist.add("Unit 4. Material Management :");
                    unitlist.add("Unit 5. Financial Management :");
                    unitlist.add("Unit 6. Marketing Management :");
                    unitlist.add("Unit 7. Entrepreneurship :");
                    unitlist.add("Unit 8. Entrepreneurial Development :");
                    unitlist.add("Unit 9. Entrepreneurship Support System:");
                    unitlist.add("Unit 10. Setting up SSI :");
                    unitlist.add("Unit 11. Tax System and Insurance :");
                    //unitlist.add("Unit 12. Financial Sources for SSI :");
                    unitlist.add("Unit 13. Labour Legislation and Pollution Control Acts :");
                    unitlist.add("Unit 14. Project Report :");
                    unitlist.add("Unit 15. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("CS 201 PROGRAMMING AND PROBLEM SOLVING THROUGH C"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Elements of C");
                    unitlist.add("Unit 3. Console Input-Output");
                    unitlist.add("Unit 4. Control Flow");
                    unitlist.add("Unit 5. Arrays");
                    unitlist.add("Unit 6. Functions");
                    unitlist.add("Unit 7. Pointers");
                    unitlist.add("Unit 8. Structure, Union and Enumerated Data Types");
                    unitlist.add("Unit 9. File Handling");
                    unitlist.add("Unit 10. Numerical Methods");
                }
                else if (item4.matches("CS 202 COMPUTER SYSTEM ARCHITECTURE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Overview of Computer Organization");
                    unitlist.add("Unit 2. Register and Micro -Operations");
                    unitlist.add("Unit 3. Basic Computer Organization");
                    unitlist.add("Unit 4. Central Processor Organization");
                    unitlist.add("Unit 5. Arithmetic Processor Organization");
                    unitlist.add("Unit 6. Input / Output Organization");
                    unitlist.add("Unit 7. Memory Organization");
                    unitlist.add("Unit 8. Introduction to Parallel Processing");
                }
                else if (item4.matches("CS 203 OPERATING SYSTEM PRINCIPLE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit  1. Introduction");
                    unitlist.add("Unit 2. Process Management and CPU Scheduling");
                    unitlist.add("Unit 3. Deadlocks");
                    unitlist.add("Unit 4. Memory Management");
                    unitlist.add("Unit 5. Virtual Memory");
                    unitlist.add("Unit 6. File System");
                    unitlist.add("Unit 7. Distributed Operating System (DOS)");
                }
                else if (item4.matches("CS 204 BASICS OF ELECTRONIC DEVICES AND CIRCUITS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Semiconductor and PN Junction");
                    unitlist.add("Unit 2. Bipolar Junction Transistor (BJT)");
                    unitlist.add("Unit 3. Transistor Biasing and Bias Stability");
                    unitlist.add("Unit 4. Field Effect Transistor");
                    unitlist.add("Unit 5. Rectifiers");
                    unitlist.add("Unit 6. Power Supplies & Sensors");
                }
                else if (item4.matches("CS 205 BASICS OF DIGITAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Number System");
                    unitlist.add("Unit 3. Logic Gates & Families");
                    unitlist.add("Unit 4. Boolean Algebra");
                    unitlist.add("Unit 5. Minimization Techniques ( K-Mapping)");
                    unitlist.add("Unit 6. Combinational Logic Design");
                    unitlist.add("Unit 7. Sequential Systems");
                }
                else if (item4.matches("CS 206 DATA COMMUNICATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Signals and Transmission");
                    unitlist.add("Unit 3. Multiplexing and Communication Hardware");
                    unitlist.add("Unit 4. Data Link Layer");
                    unitlist.add("Unit 5. Switching and Frame Relay");
                }
                else if (item4.matches("CS 207 DATA BASE MANAGEMENT SYSTEM"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Indroduction");
                    unitlist.add("Unit 2. Data Modeling Using the E-R Model");
                    unitlist.add("Unit 3. Relational Data Model and Language");
                    unitlist.add("Unit 4. Normalization");
                    unitlist.add("Unit 5. Transaction Processing Concepts");
                    unitlist.add("Unit 6. Deadlock Handling");
                    unitlist.add("Unit 7. Concurrency Control Techniques");
                }
                else if (item4.matches("CS 208 MICROPROCESSOR AND INTERFACING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. The 8085 Architecture");
                    unitlist.add("Unit 3. 8085 Instructions and Programming");
                    unitlist.add("Unit 4. Memory and I/O System");
                    unitlist.add("Unit 5. Instruction Execution and Timings");
                    unitlist.add("Unit 6. Interfacing With 8085");
                    unitlist.add("Unit 7. Introduction to x 86 Family (8086)");
                }
                else if (item4.matches("CS 209 INTERNET AND WEB TECHNOLOGIES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Internet Basics");
                    unitlist.add("Unit 2. HTML");
                    unitlist.add("Unit 3. Java Script");
                    unitlist.add("Unit 4. DHTML");
                    unitlist.add("Unit 5. CGI");
                    unitlist.add("Unit 6. Perl");
                }
                else if (item4.matches("CS 210 PC MAINTENANCE AND TROUBLE SHOOTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Computer Installation");
                    unitlist.add("Unit 2. Safety and Security Measures");
                    unitlist.add("Unit 3. Working Principles of peripheral devices");
                    unitlist.add("Unit 4. Display Technologies-Thin Displays");
                    unitlist.add("Unit 5. Optical Storage Devices");
                    unitlist.add("Unit 6. I/O Ports");
                    unitlist.add("Unit 7. Hard Disk Drive (HDD)");
                    unitlist.add("Unit 8. Windows Components and Tools");
                    unitlist.add("Unit 9. Memory");
                }
                else if (item4.matches("CS 301 DATA STRUCTURE & ALGORITHM"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1 Introduction to Data Structures and Algorithms :");
                    unitlist.add("Unit 2 Algorithm on Linked List :");
                    unitlist.add("Unit 3 Algorithms on Stack :");
                    unitlist.add("Unit 4. Algorithms on Queue :");
                    unitlist.add("Unit 5 Non-Linear Data Structure: Tree");
                    unitlist.add("Unit 6 Non-Linear Data Structure: Graph :");
                    unitlist.add("Unit 7 Sorting and Searching Algorithms and their Analysis");
                }
                else if (item4.matches("CS 302 OBJECT ORIENTED PROGRAMMING THROUGH CPP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. An Overview of Object Oriented Programming :");
                    unitlist.add("Unit 2. Object Oriented Programming Using C plus plus :");
                    unitlist.add("Unit 3. Objects and Classes :");
                    unitlist.add("Unit 4. Overloading of Functions and Operators :");
                    unitlist.add("Unit 5. Inheritance and Polymorphism :");
                    unitlist.add("Unit 6. Templates and Exception Handling :");
                    unitlist.add("Unit 7. Managing Console I/O and File I/O :");
                }
                else if (item4.matches("CS 303 UNIX, SHELL PROGRAMMING AND ADMINISTRATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. UNIX An Introduction :");
                    unitlist.add("Unit 2. File System :");
                    unitlist.add("Unit 3. UNIX Commands :");
                    unitlist.add("Unit 4. vi Editor :");
                    unitlist.add("Unit 5. UNIX Shell :");
                    unitlist.add("Unit 6. Shell Programming :");
                    unitlist.add("Unit 7. Essential System Administration :");
                }
                else if (item4.matches("CS 304 SOFTWARE ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Software Life Cycle Models :");
                    unitlist.add("Unit 3. Requirement Analysis and Specification");
                    unitlist.add("Unit 4. Software Design :");
                    unitlist.add("Unit 5. Function Oriented Design");
                    unitlist.add("Unit 6. Software Testing :");
                    unitlist.add("Unit 7. Software Reliability and Quality Management :");
                }
                else if (item4.matches("CS 305 DOT NET TECHNOLOGY "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to NET Framework and Development Environment :");
                    unitlist.add("Unit 2. Visual Basic.NET :");
                    unitlist.add("Unit 3. Programming Concepts of VB.NET :");
                    unitlist.add("Unit 4. Object Oriented Features of VB.NET :");
                    unitlist.add("Unit 5. Windows FORMS and Controls");
                    unitlist.add("Unit 6. Database Connectivity using ADO.NET :");
                    unitlist.add("Unit 7. ASP.NET :");
                }
                else if (item4.matches("CS 306 COMPUTER NETWORK"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Data Link Layer and Local Area Networks :");
                    unitlist.add("Unit 2 Network Layer and Routing :");
                    unitlist.add("Unit 3. Transport Layer :");
                    unitlist.add("Unit 4. Application Layer :");
                    unitlist.add("Unit 5. Wireless Networking :");
                }
                else if (item4.matches("CS 307 DATA WAREHOUSE AND MINING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1 Data Mining :");
                    unitlist.add("Unit 2. Data Pre-Processing :");
                    unitlist.add("Unit 3. Data Mining Techniques :");
                    unitlist.add("Unit 4. Data Warehouse :");
                    unitlist.add("Unit 5. Data Warehouse Architecture :");
                    unitlist.add("Unit 6. Components of Data Warehouse :");
                    unitlist.add("Unit 7. On-Line Analytical Processing :");
                }
                else if (item4.matches("CS 308 INTRODUCTION TO NETWORK SECURITY AND CRYPTOGRAPHY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Computer Security :");
                    unitlist.add("Unit 2. Attacks on Computer :");
                    unitlist.add("Unit 3. Cryptographic : Concepts and Techniques");
                    unitlist.add("Unit 4. Symmetric and Asymmetric Key Cryptography");
                    unitlist.add("Unit 5. Internet Security Protocols");
                    unitlist.add("Unit 6. E-mail Security:");
                    unitlist.add("Unit 7.Firewall");
                }
                else if (item4.matches("CS 309 JAVA TOOLS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Java Fundamentals :");
                    unitlist.add("Unit 2. Applet :");
                    unitlist.add("Unit 3. Graphics :");
                    unitlist.add("Unit 4. AWT and Event Handling:");
                    unitlist.add("Unit 5. Swing :");
                    unitlist.add("Unit 6. JDBC :");
                    unitlist.add("Unit 7. Servlet :");
                }
                else if (item4.matches("CS 310 PHP & MYSQL"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Overview of PHP :");
                    unitlist.add("Unit 2. Basic Scripting, Loop and Conditional Constructs");
                    unitlist.add("Unit 3. Arrays in PHP :");
                    unitlist.add("Unit 4. Working with Databases and Forms");
                    unitlist.add("Unit 5. Using Cookies with PHP :");
                    unitlist.add("Unit 6. MySQL :");
                }
                else if (item4.matches("CH 201 Concepts of Heat Transfer"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Conduction:");
                    unitlist.add("Unit 3. Dimensional Analysis:");
                    unitlist.add("Unit 5. Convection:");
                    unitlist.add("Unit 6. Double Pipe Heat Exchanger:");
                    unitlist.add("Unit 7. Shell and Tube Heat Exchanger:");
                    unitlist.add("Unit 8. Plate Type Heat Exchanger:");
                }
                else if (item4.matches("CH 202 Mass Transfer"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. vapour liquid equilibrium");
                    unitlist.add("Unit 3. Distillation");
                    unitlist.add("Unit 4. Distillation equipments");
                    unitlist.add("Unit 5. Batch Distillation:");
                    unitlist.add("Unit 6. Humidification:");
                    unitlist.add("Unit 7. Adsorption:");
                }
                else if (item4.matches("CH 203 Chemical Process Calculations"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introdution:");
                    unitlist.add("Unit 3. Material Balances without Chemical Reactions:");
                    unitlist.add("Unit 4. Material Balances without Chemical Reactions:");
                    unitlist.add("Unit 5. Energy Balance :");
                }
                else if (item4.matches("CH 204 Transport Phenomena"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Transport in Laminar Flow :");
                    unitlist.add("Unit 3. Mechanism of Mass Transfer :");
                    unitlist.add("Unit 4. Mechanism of Heat Transfer :");
                    unitlist.add("Unit 5. Mechanism of Momentum Transport :");
                    unitlist.add("Unit 6. Transport Phenomena Anaogies :");
                }
                else if (item4.matches("CH 205 Organic Chemistry"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Structure of Organic Molecules:");
                    unitlist.add("Unit 3. Introduction of Polymerisation :");
                    unitlist.add("Unit 4. Polymers :");
                    unitlist.add("Unit 6. Colour and Dyes :");
                    unitlist.add("Unit 8. Terpenes :");
                    unitlist.add("Unit 9. Colloids :");
                }
                else if (item4.matches("CH 206 Chemical Reaction Engg"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Types of Reaction :");
                    unitlist.add("Unit 3. Constant Volume Batch Reactor :");
                    unitlist.add("Unit 4. Reactor Design :");
                    unitlist.add("Unit 5. Comparison of Reactors :");
                }
                else if (item4.matches("CH 208 Mechanical Operations"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Particle Technology :");
                    unitlist.add("Unit 2. Comminution :");
                    unitlist.add("Unit 3. Screening :");
                    unitlist.add("Unit 4. Filtration :");
                    unitlist.add("Unit 5. Gas Cleaning :");
                    unitlist.add("Unit 6. Storage and Transportation of Solids :");
                }
                else if (item4.matches("CH 209 General chemical Technology"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Sulfur and Sulfuric Acid:");
                    unitlist.add("Unit 2. Fertilizers Industries :");
                    unitlist.add("Unit 3. Chloralkali Industries :");
                    unitlist.add("Unit 4. Soap and Detergent:");
                    unitlist.add("Unit 5. Carbohydrates and Fermentation Industries :");
                    unitlist.add("Unit 7. Man Made Fibres :");
                }
                else if (item4.matches("CH 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of C :");
                    unitlist.add("Unit 3. Console Input-Output :");
                    unitlist.add("Unit 4. Control Flow :");
                    unitlist.add("Unit 5. Arrays :");
                    unitlist.add("Unit 6. Functions :");
                    unitlist.add("Unit 7. Pointers :");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types :");
                }
                else if (item4.matches("CH 301 Operations of Heat Transfer"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Radiation:");
                    unitlist.add("Unit 3. Condensation:");
                    unitlist.add("Unit 4. Condensers:");
                    unitlist.add("Unit 5. Evaporation and evaporators:");
                }
                else if (item4.matches("CH 302 Operations of Mass Transfer"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Diffusion :");
                    unitlist.add("Unit 2. Absorption :");
                    unitlist.add("Unit 3. Extraction :");
                    unitlist.add("Unit 4. Drying :");
                }
                else if (item4.matches("CH 303 Chemical Engineering Thermodynamics"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 3. Ideal Gas:");
                    unitlist.add("Unit 4. P.V.T. Relations:");
                    unitlist.add("Unit 5. Heat Effects:");
                }
                else if (item4.matches("CH 304 Petroleum Technology"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 5. Treatment Processes :");
                    unitlist.add("Unit 7. Properties of Petroleum Product :");
                }
                else if (item4.matches("CH 305 Industrial Safety And Environmental Engineering"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 3. Water Pollution :");
                    unitlist.add("Unit 5. Radio Active Pollution :");
                    unitlist.add("Unit 6. Solid Waste Management :");
                }
                else if (item4.matches("CH 306 Cement And Fertiliser Technology"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Nitrogenous Fertilizers :");
                    unitlist.add("Unit 3. Phosphatic Fertilizers :");
                    unitlist.add("Unit 4. Potassic Fertilizers :");
                    unitlist.add("Unit 5. Mixed Fertilizers :");
                    unitlist.add("Unit 6. Introduction of cement :");
                    unitlist.add("Unit 7. Production of Cement :");
                    unitlist.add("Unit 8. Kiln Design :");
                }
                else if (item4.matches("CH 307 Process Equipment Design And Plant Utilities"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Drawing of the following:");
                    unitlist.add("Unit 3. Process Design Development:");
                    unitlist.add("Unit 5. Water :");
                }
                else if (item4.matches("CH 308 Instrumentation And Process control"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Temperature :");
                    unitlist.add("Unit 5. Level Measurement :");
                    unitlist.add("Unit 6. Chemical Composition Measurement:");
                    unitlist.add("Unit 7. Indicating and Recording Instrument in General:");
                    unitlist.add("Unit 9. Process Control:");
                }
                else if (item4.matches("CH 309 Process Testing And Material Science"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Definition and Significance:");
                    unitlist.add("Unit 2. Principles, Construction and Methods of Measurement:");
                    unitlist.add("Unit 3. Analysis of Fuel :");
                    unitlist.add("Unit 4. Water Treatment :");
                    unitlist.add("Unit 5. Engineering Materials:");
                    unitlist.add("Unit 6. Properties of Engineering Materials:");
                }
                else if (item4.matches("CH 310 MANAGEMENT &ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management :");
                    unitlist.add("Unit 2. Human Resources Development :");
                    unitlist.add("Unit 3. Wages and Incentives :");
                    unitlist.add("Unit 4. Material Management :");
                    unitlist.add("Unit 5. Financial Management :");
                    unitlist.add("Unit 6. Marketing Management :");
                    unitlist.add("Unit 7. Entrepreneurship :");
                    unitlist.add("Unit 8. Entrepreneurial Development :");
                    unitlist.add("Unit 9. Entrepreneurship Support System:");
                    unitlist.add("Unit 10. Setting up SSI :");
                    unitlist.add("Unit 11. Tax System and Insurance :");
                    //unitlist.add("Unit 12. Financial Sources for SSI :");
                    unitlist.add("Unit 13. Labour Legislation and Pollution Control Acts :");
                    unitlist.add("Unit 14. Project Report :");
                    unitlist.add("Unit 15. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("AR 202 MECHANICS OF STRUCTURES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Bending Moments and Shear Force :");
                }
                else if (item4.matches("AR 203 GRAPHICAL PRESENTATION-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to drawing equipments and drafting standards used for graphical presentation.");
                    unitlist.add("Unit 3. Methods of subdivision of lines");
                }
                else if (item4.matches("AR 206 BUILDING MATERIAL"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 4. Cement : ");
                }
                else if (item4.matches("AR 207 THEORY OF DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Design Elements :");
                }
                else if (item4.matches("AR 209 BUILDING CONSTRUCTION-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 6.Wooden Doors and Windows :");
                }
                else if (item4.matches("AR 301 HISTORY OF ARCHITECTURE-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Islamic Archietcture in India");
                    unitlist.add("Unit 2. study of greek & Roman Ar:");
                    unitlist.add("Unit 3. works of outstanding architects");
                }
                else if (item4.matches("AR 302 BUILDING SERVICES IN ARCHITECTURE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 4. Plumbing and Internal Fixture :");
                }
                else if (item4.matches("AR 303 GRAPHICAL PRESENTATION-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.  Perspective :");
                }
                else if (item4.matches("AR 304 ARCHITECTURE DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Practical 1. Study Report :");
                }
                else if (item4.matches("AR 305 BUILDING BYE LAWS & MUNICIPAL DRAWING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Method of Calculation of Plot of Different Shapes. ");
                    unitlist.add("Unit 2. Method of Calculation of Area");
                }
                else if (item4.matches("AR 306 ESTIMATING AND SPECIFICATIONS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 3. Specifications :");
                }
                else if (item4.matches("AR 308 STRUCTURAL DESIGN AND DRAWING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.Concrete Technology :");
                }
                else if (item4.matches("AR 310 MANAGEMENT &ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management :");
                    unitlist.add("Unit 2. Human Resources Development :");
                    unitlist.add("Unit 3. Wages and Incentives :");
                    unitlist.add("Unit 4. Material Management :");
                    unitlist.add("Unit 5. Financial Management :");
                    unitlist.add("Unit 6. Marketing Management :");
                    unitlist.add("Unit 7. Entrepreneurship :");
                    unitlist.add("Unit 8. Entrepreneurial Development :");
                    unitlist.add("Unit 9. Entrepreneurship Support System:");
                    unitlist.add("Unit 10. Setting up SSI :");
                    unitlist.add("Unit 11. Tax System and Insurance :");
                    //unitlist.add("Unit 12. Financial Sources for SSI :");
                    unitlist.add("Unit 13. Labour Legislation and Pollution Control Acts :");
                    unitlist.add("Unit 14. Project Report :");
                    unitlist.add("Unit 15. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("IE 201 INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Multimeter :");
                    unitlist.add("Unit 2. Electronic Voltmeter :");
                    unitlist.add("Unit 3. Cathode Ray Oscilloscope :");
                    unitlist.add("Unit 4. Working Principle and Application of :");
                    unitlist.add("Unit 5. Signal Generation :");
                    unitlist.add("Unit 7. Frequency :");
                }
                else if (item4.matches("IE 202 ELECTRICAL ENGINEERING AND MEASUREMENTS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. D.C. Machine :");
                    unitlist.add("Unit 4. A.C. Bridges :");
                    unitlist.add("Unit 5. Measuring Instruments :");
                    unitlist.add("Unit 6. Range Extension and Calibration :");
                }
                else if (item4.matches("IE 203 NETWORK ANALYSIS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. General Network Concept :");
                    unitlist.add("Unit 2. Mesh and Nodal Analysis :");
                    unitlist.add("Unit 3. Laplace Transformation :");
                    unitlist.add("Unit 4. Network Theorems :");
                    unitlist.add("Unit 6. Resonance :");
                }
                else if (item4.matches("IE 204 CONCEPTS OF DIGITAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Number System :");
                    unitlist.add("Unit 3. Logic Gates :");
                    unitlist.add("Unit 4. Boolean Algebra :");
                    unitlist.add("Unit 5. Minimization Techniques ( K-Mapping) :");
                    unitlist.add("Unit 7. Sequential Systems :");
                }
                else if (item4.matches("IE 205 CONCEPTS OF ELECTRONIC DEVICES AND CIRCUITS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Semiconductor and PN Junction :");
                    unitlist.add("Unit 5. Small Signal Transistor Amplifier :");
                    unitlist.add("Unit 7. Rectifiers and Power Supplies :");
                }
                else if (item4.matches("IE 206 INDUSTRIAL INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic of Instrumentation :");
                    unitlist.add("Unit 2. Flow :");
                    unitlist.add("Unit 4. Density :");
                    unitlist.add("Unit 6. Viscosity :");
                    unitlist.add("Unit 7. Pressure :");
                    unitlist.add("Unit 8. Temperature :");
                    unitlist.add("Unit 9. Vibration :");
                    unitlist.add("Unit 10. Speed Measurements :");
                }
                else if (item4.matches("IE 207 TRANSDUCERS & TELEMETRY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Transducers :");
                    unitlist.add("Unit 2. Variable Resistive Transducers :");
                    unitlist.add("Unit 3. Variable Reluctance Transducers :");
                    unitlist.add("Unit 4. Variable Capacitance Transducers :");
                    unitlist.add("Unit 5. Voltage and Current Generating Transducers :");
                    unitlist.add("Unit 6. Frequency Generating and Digital Transducers :");
                    unitlist.add("Unit 8. Telemetry System :");
                    unitlist.add("Unit 9. Transmitters :");
                    unitlist.add("Unit 10. Transmission Channels and Media :");
                    unitlist.add("Unit 11. Process Lags :");
                }
                else if (item4.matches("IE 208 CONTROL SYSTEM COMPONENTS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Error Sensing Devices :");
                    unitlist.add("Unit 3. Servo Motors :");
                    unitlist.add("Unit 5. Techogenerators :");
                    unitlist.add("Unit 6. Final Control Elements :");
                    unitlist.add("Unit 7. Contactor Control Elements and Circuits :");
                    unitlist.add("Unit 8. Switches :");
                }
                else if (item4.matches("IE 209 ANALYTICAL & ENVIRONMENTAL INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Spectroscopic Analysis :");
                    unitlist.add("Unit 2. Gas Analysis :");
                    unitlist.add("Unit 4. Liquid Analysis :");
                    unitlist.add("Unit 6. Optical Analysis Instruments :");
                }
                else if (item4.matches("IE 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of C :");
                    unitlist.add("Unit 3. Console Input-Output :");
                    unitlist.add("Unit 4. Control Flow :");
                    unitlist.add("Unit 5. Arrays :");
                    unitlist.add("Unit 6. Functions:");
                    unitlist.add("Unit 7. Pointers :");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types :");
                }
                else if (item4.matches("IE 301 PROCESS CONTROLLER"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Automatic Control:");
                    unitlist.add("Unit 2. Control Actions:");
                    unitlist.add("Unit 5. Electronic Controllers:");
                    unitlist.add("Unit 6. Special Control Schemes:");
                }
                else if (item4.matches("IE 302 OPTICAL INSTRUMENTS & DEVICES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Optical Sources");
                    unitlist.add("Unit 5. Use of Lasers:");
                }
                else if (item4.matches("IE 303 CONTROL THEORY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Process Control:");
                    unitlist.add("Unit 2. Time Domain Analysis:");
                    unitlist.add("Unit 4. Introduction of Advance Control Techniques:");
                }
                else if (item4.matches("IE 304 MICROCONTROLLERS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. The 8085 Architecture:");
                    unitlist.add("Unit 5. THE 8051 MICROCONTROLLER:");
                    unitlist.add("Unit 6. 8051 ASSEMBLY LANGUAGE PROGRAMMING:");
                }
                else if (item4.matches("IE 305 POWER & INDUSTRIAL ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Power Control and Rectifiers :");
                    unitlist.add("Unit 3. Inverters, Choppers and Cyclo-converters :");
                    unitlist.add("Unit 4. AC Stabilizer and Power Supply :");
                    unitlist.add("Unit 5. A.C., D.C. Motors & control:");
                    unitlist.add("Unit 6. Heating, Welding and their Application :");
                }
                else if (item4.matches("IE 306 BIOMEDICAL INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Physiology :");
                    unitlist.add("Unit 2. Medical Electrodes :");
                    unitlist.add("Unit 3. Bio Medical Recording System :");
                    unitlist.add("Unit 4. Electro Cardiograph (E.C.G.) :");
                    unitlist.add("Unit 5. Pace Makers :");
                    unitlist.add("Unit 6. Blood Pressure Monitoring :");
                    unitlist.add("Unit 7. Defibrillator :");
                    unitlist.add("Unit 8. Biomedical Instruments :");
                    unitlist.add("Unit 9. Bed Patient Monitoring System :");
                    unitlist.add("Unit 10. Introduction to Bioinformatics :");
                    unitlist.add("Unit 11. Use of Nanotechnology in biomedical (Brief idea)");
                }
                else if (item4.matches("IE 307 APPLIED INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Processes and Control Schemes of the Following in Industries :");
                    unitlist.add("Unit 2. Instrumentation and Control Scheme in Chemical Reactors:");
                    unitlist.add("Unit 5. Instrumentation and Control Scheme in Evaporators:");
                }
                else if (item4.matches("IE 308 SIGNAL CONDITIONING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Analog Signal Conditioning:");
                    unitlist.add("Unit 3. Digital Signal Conditioning :");
                }
                else if (item4.matches("IE 309 INSTRUMENTATION WORKSHOP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Calibration of Following:");
                    unitlist.add("Unit 2. Connection of a Pneumatic Primary Instrument to a Secondary Instrument with the help of Ferual Fittings.");
                    unitlist.add("Unit 3. Making of Simple Contactor Control Circuit Using the Following:");
                    unitlist.add("Unit 4. Study of Calibration Tools and Instruments:");
                    unitlist.add("Unit 6. Design of Various Control Loops for Different Parameters and their Material and cost estimation:");
                    unitlist.add("Unit 7. Design of Instruments Air System for four individual users and for Control Room Air Supply using :");
                }
                else if (item4.matches("IE 310 MANAGEMENT &ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management :");
                    unitlist.add("Unit 2. Human Resources Development :");
                    unitlist.add("Unit 3. Wages and Incentives :");
                    unitlist.add("Unit 4. Material Management :");
                    unitlist.add("Unit 5. Financial Management :");
                    unitlist.add("Unit 6. Marketing Management :");
                    unitlist.add("Unit 7. Entrepreneurship :");
                    unitlist.add("Unit 8. Entrepreneurial Development :");
                    unitlist.add("Unit 9. Entrepreneurship Support System:");
                    unitlist.add("Unit 10. Setting up SSI :");
                    unitlist.add("Unit 11. Tax System and Insurance :");
                    unitlist.add("Unit 13. Labour Legislation and Pollution Control Acts :");
                    unitlist.add("Unit 14. Project Report :");
                    unitlist.add("Unit 15. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("MA 201 STRENGTH OF MATERIALS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. SIMPLE STRESS & STRAIN");
                    unitlist.add("Unit 2. Compound Stress");
                    unitlist.add("Unit 3. Strain Energy:");
                    unitlist.add("Unit 4. Bending Moments and Shear Force:");
                    unitlist.add("Unit 5. Moment of Inertia:");
                    unitlist.add("Unit 6. Bending Stresses in Beams:");
                    unitlist.add("Unit 7. Shear Stress in Beams:");
                    unitlist.add("Unit 8. Deflection:");
                    unitlist.add("Unit 9. Columns and Struts:");
                    unitlist.add("Unit 10. Torsion of Shaft:");
                    unitlist.add("Unit 11. Springs:");
                    unitlist.add("Unit 12. Thin Cylindrical Shells:");
                    unitlist.add("Unit 13. Combined Direct and Bending Stress:");
                }
                else if (item4.matches("MA 202 FLUID MECHANICS & MACHINES "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Fluid Pressure and its Measurement:");
                    unitlist.add("Unit 3. Hydrostatics :");
                    unitlist.add("Unit 4. Hydrokinematics :");
                    unitlist.add("Unit 5. Hydrodynamics and Measurement of Flow:");
                    unitlist.add("Unit 6. Orifices:");
                    unitlist.add("Unit 7. Flow Through Pipes:");
                    unitlist.add("Unit 8. Impact of Free Jet:");
                    unitlist.add("Unit 9. Hydraulic Turbines:");
                    unitlist.add("Unit 10. Centrifugal Pump:");
                    unitlist.add("Unit 11. Reciprocating Pump :");
                    unitlist.add("Unit 12. Miscellaneous Hydraulic Machines :");
                }
                else if (item4.matches("MA 203  ENGINEERING MATERIALS AND PROCESSES "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Classification and Properties of Materials :");
                    unitlist.add("Unit 2. Structure of Metals and Their Deformation :");
                    unitlist.add("Unit 3. Ferrous Metals :");
                    unitlist.add("Unit 4. Non Ferrous Metals:");
                    unitlist.add("Unit 5. Engineering Plastics and Fibers :");
                    unitlist.add("Unit 6. Insulating Materials :");
                    unitlist.add("Unit 7. Testing of Metals and Alloys :");
                    unitlist.add("Unit 8. Fundamentals of Heat Treatment :");
                    unitlist.add("Unit 9. Welding Process :");
                    unitlist.add("Unit 10. Gas Welding :");
                    unitlist.add("Unit 11. Electric Arc Welding :");
                    unitlist.add("Unit 12. Other Welding Processes :");
                    unitlist.add("Unit 13. Modern Welding Methods :");
                    unitlist.add("Unit 14. Foundry :");
                }
                else if (item4.matches("MA 204 THEORY OF MACHINES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Simple Mechanism:");
                    unitlist.add("Unit 2. Velocity and Acceleration in Mechanism:");
                    unitlist.add("Unit 3. Dynamics of Reciprocating Parts:");
                    unitlist.add("Unit 4. Friction:");
                    unitlist.add("Unit 5. Transmission of Power:");
                    unitlist.add("Unit 6. Balancing:");
                    unitlist.add("Unit 7. Vibration:");
                    unitlist.add("Unit 8. Governors (No derivation & numerical) :");
                    unitlist.add("Unit 9. Brakes and Dynamometer:");
                    unitlist.add("Unit 10. Gyroscope ");
                }
                else if (item4.matches("ME 205  MACHINE DRAWING AND COMPUTER AIDED DRAFTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Machining Symbols and Tolerances :");
                    unitlist.add("Unit 3. Assembly Drawing:");
                    unitlist.add("Unit 4. Gear tooth profile");
                    unitlist.add("Unit 5. Cam profile");
                    unitlist.add("Unit 6. Computer Graphics");
                }
                else if (item4.matches("ME 206 BASIC AUTOMOBILE ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Suspension System:");
                    unitlist.add("Unit 3. Braking Systems :");
                    unitlist.add("Unit 4. Wheels and Tyres :");
                    unitlist.add("Unit 5. Front axle and Steering System:");
                    unitlist.add("Unit 6. Power Transmission System :");
                    unitlist.add("Unit 7. Frame and Body:");
                }
                else if (item4.matches("ME 207 ELECTRICAL AND ELECTRONICS ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. D.C. Machines:");
                    unitlist.add("Unit 2. Transformer:");
                    unitlist.add("Unit 3. Induction Motor:");
                    unitlist.add("Unit 4. Industrial Drives:");
                    unitlist.add("Unit 5. Electric Heating:");
                    unitlist.add("Unit 6. Illumination:");
                    unitlist.add("Unit 7. Instrumentation and Measurement:");
                    unitlist.add("Unit 8. Semiconductor and P-N Junction Diode:");
                    unitlist.add("Unit 9. Bipolar Junction Transistor:");
                    unitlist.add("Unit 10. Digital Electronics:");
                    unitlist.add("Unit 11. Power Electronics:");
                    unitlist.add("Unit 13. Photo Electric Devices:");
                }
                else if (item4.matches("MA 208 THERMODYNAMICS AND I C ENGINES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic Concept and Gas Laws :");
                    unitlist.add("Unit 2. Laws of Thermodynamics:");
                    unitlist.add("Unit 3. Availability :");
                    unitlist.add("Unit 4. Formation of Steam and its Properties :");
                    unitlist.add("Unit 5. Steam Generators:");
                    unitlist.add("Unit 6. Boiler Performance:");
                    unitlist.add("Unit 7. Gas Power Cycles:");
                    unitlist.add("Unit 8. Principles of Internal Combustion Engines :");
                    unitlist.add("Unit 9. Petrol Engines :");
                    unitlist.add("Unit 10. Diesel Engines:");
                    unitlist.add("Unit 11. Cooling, Lubrication and Governing :");
                    unitlist.add("Unit 12. I.C. Engines Performance:");
                    unitlist.add("Unit 13. Gas Turbines (No numerical problem):");
                    unitlist.add("Unit 14. Air Compressors (No numerical problem):");
                }
                else if (item4.matches("MA 209 WORKSHOP TECHNOLOGY AND METROLOGY ENGINES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Cutting Tools and Materials:");
                    unitlist.add("Unit 2. Lathe Machine:");
                    unitlist.add("Unit 3. Drilling Machines :");
                    unitlist.add("Unit 4. Shaping, Planning and Slotting Machines:");
                    unitlist.add("Unit 5. Cutting Fluids and Cooling Process:");
                    unitlist.add("Unit 6. Introduction to Metrology:");
                    unitlist.add("Unit 7. Linear and Angular Measurement:");
                    unitlist.add("Unit 8. Measurement of Surface Finish :");
                    unitlist.add("Unit 9. Comparators:");
                    unitlist.add("Unit 10. Light Wave Interference:");
                    unitlist.add("Unit 11. Gear and Screw Measurement:");
                    unitlist.add("Unit 12. Limits, Fits and Tolerance:");
                    unitlist.add("Unit 13. Machine Tool Metrology:");
                }
                else if (item4.matches("ME 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of C :");
                    unitlist.add("Unit 3. Console Input-Output :");
                    unitlist.add("Unit 4. Control Flow :");
                    unitlist.add("Unit 5. Arrays : ");
                    unitlist.add("Unit 6. Functions :");
                    unitlist.add("Unit 7. Pointers :");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types :");
                }
                else if (item4.matches("MA 301 AUTO SHOP AND GARAGE PRACTICE "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Practical 15 Complete overhaul of clutch system (Two wheeler. L.T.V. & H.T.V).");
                    unitlist.add("Practical 17 Complete overhaul of Propeller shaft ");
                    unitlist.add("Practical 18 Complete overhaul of Differential ( L.T.V. & H.T.V).");
                    unitlist.add("Practical 19 Complete overhaul of steering system (L.T.V. & H.T.V).");
                    unitlist.add("Practical 21 Driving practice of two wheeler, L.T. V & H.T. V.");
                    unitlist.add("Practical 22 Repairing. Servicing and testing of Radiator.");
                }
                else if (item4.matches("MA 302 PROCESSES IN MANUFACTURING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Metal Forming Process :");
                    unitlist.add("Unit 2. Conventional Metal Cutting Processes :");
                    unitlist.add("Unit 3. Newer Machining Processes :");
                    unitlist.add("Unit 4. Metallic Coating Processes :");
                    unitlist.add("Unit 5. Plastic Process - Working principle, Advantages and limitation of following process :");
                    unitlist.add("Unit 6. Jigs and Fixtures :");
                }
                else if (item4.matches("MA 303  AUTO THERMODYNAMICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Combustion in S.I. Engine :");
                    unitlist.add("Unit 4. C.I. Engine Combustion Chambers :");
                    unitlist.add("Unit 7. Refrigeration and Refrigerants :");
                    unitlist.add("Unit 9. Psychrometry :");
                    unitlist.add("Unit 11. Heat Transfer:");
                    unitlist.add("Unit 12. Conduction :");
                    unitlist.add("Unit 14. Radiation :");
                }
                else if (item4.matches("MA 304  CNC MACHINES & AUTOMATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Component of NC Machines :");
                    unitlist.add("Unit 3. Classification of Numerical Control Machines :");
                    unitlist.add("Unit 4. Constructional Details of CNC Machines :");
                    unitlist.add("Unit 5. Tooling for CNC Machines :");
                    unitlist.add("Unit 6. Fundamentals of Part Programming :");
                    unitlist.add("Unit 7. Advanced Part Programming :");
                    unitlist.add("Unit 8. Computer Aided Part Programming :");
                    unitlist.add("Unit 9. Robotics :");
                    unitlist.add("Unit 10. Automation in Manufacturing :");
                }
                else if (item4.matches("MA 305 POWER GENERATION "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Thermal Power Plants :");
                    unitlist.add("Unit 3. Hydro-Electric Power Plant :");
                    unitlist.add("Unit 4. Nuclear Power Plant :");
                    unitlist.add("Unit 5. Diesel Power Plants :");
                    unitlist.add("Unit 6. Gas Turbine Plants :");
                    unitlist.add("Unit 7. Power Plant Economics :");
                    unitlist.add("Unit 8. Renwal Energy Sources :");
                    unitlist.add("Unit 9. Solar Energy :");
                    unitlist.add("Unit 10. Wind Energy :");
                }
                else if (item4.matches("MA 306 ADVANCE WORKSHOP TECHNIQUES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Metal Cutting Saws :");
                    unitlist.add("Unit 2. Boring :");
                    unitlist.add("Unit 3. Milling Machine :");
                    unitlist.add("Unit 4. Grinding and Grinding Machines :");
                    unitlist.add("Unit 5. Capstan and Turret Lathes :");
                    unitlist.add("Unit 6. Automatic Machines :");
                    unitlist.add("Unit 7. Metal Finishing Processes :");
                    unitlist.add("Unit 8. Maintenance of Machine Tools :");
                    unitlist.add("Unit 9. Installation and Testing of Machine Tools :");
                }
                else if (item4.matches("MA 307 AUTO ELECTRICAL EQUIPMENTS "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Battery :");
                    unitlist.add("Unit 4. Starting Motor :");
                    unitlist.add("Unit 6. Spark Plug :");
                    unitlist.add("Unit 9. Horn :");
                }
                else if (item4.matches("MA 308  VEHICLE TECHNOLOGY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Chassis Layout :");
                    unitlist.add("Unit 2. Suspension System:");
                    unitlist.add("Unit 3. Braking System :");
                    unitlist.add("Unit 4. Wheels and Tyres :");
                    unitlist.add("Unit 5. Clutch :");
                    unitlist.add("Unit 6. Transmission :");
                    unitlist.add("Unit 7. Final Drive :");
                    unitlist.add("Unit 9. Upholstery :");
                    unitlist.add("Unit 10. Engine components : Types, functions, constructional details, materials and defects in following engine components");
                }
                else if (item4.matches("MA 309 COMPONENT DESIGN & ESTIMATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Design of Welding Joints :");
                    unitlist.add("Unit 4. Design of joints & components :");
                    unitlist.add("Unit 5. Design of Keys and Couplings:");
                    unitlist.add("Unit 6. Design of Shaft :");
                    unitlist.add("Unit 9. Costing :");
                    unitlist.add("Unit 10. Elements of Costs :");
                    unitlist.add("Unit 11. Break Even Analysis :");
                }
                else if (item4.matches("MA 310 INDUSTRIAL ENGG. AND TRANSPORT MANAGEMENT "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Plant Location and Layout :");
                    unitlist.add("Unit 2. Production Planning and Control :");
                    unitlist.add("Unit 3. Inspection and Quality Control :");
                    unitlist.add("Unit 4. Work Study :");
                    unitlist.add("Unit 5. Inventory Control :");
                    unitlist.add("Unit 7. Structure of a Fleet Organisation :");
                    unitlist.add("Unit 9. Principles of Management : (Elementary Idea)");
                    unitlist.add("Unit 10. Wages and Incentives :");
                    unitlist.add("Unit 11. Entrepreneurship :");
                    unitlist.add("Unit 12. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("MP 201 STRENGTH OF MATERIALS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. SIMPLE STRESS & STRAIN");
                    unitlist.add("Unit 2. Compound Stress");
                    unitlist.add("Unit 3. Strain Energy:");
                    unitlist.add("Unit 4. Bending Moments and Shear Force:");
                    unitlist.add("Unit 5. Moment of Inertia:");
                    unitlist.add("Unit 6. Bending Stresses in Beams:");
                    unitlist.add("Unit 7. Shear Stress in Beams:");
                    unitlist.add("Unit 8. Deflection:");
                    unitlist.add("Unit 9. Columns and Struts:");
                    unitlist.add("Unit 10. Torsion of Shaft:");
                    unitlist.add("Unit 11. Springs:");
                    unitlist.add("Unit 12. Thin Cylindrical Shells:");
                    unitlist.add("Unit 13. Combined Direct and Bending Stress:");
                }
                else if (item4.matches("MP 202 PRODUCTION TECHNOLOGY-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Cutting Tools Material :");
                    unitlist.add("Unit 2. Lathe Machines :");
                }
                else if (item4.matches("MP 203 MANUFACTURING PROCESS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 6. Types of Pattern :");
                    unitlist.add("Unit 7. Moulding Sand Ingredients :");
                    unitlist.add("Unit 8. Core and Core Making :");
                    unitlist.add("Unit 10. Mould Making :");
                    unitlist.add("Unit 11. Special Casting Techniques :");
                    unitlist.add("Unit 12. Melting Furnaces :");
                }
                else if (item4.matches("MP 204  THERMAL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Gas Laws :");
                }
                else if (item4.matches("MP 206  HEAT TREATMENT AND MATERIAL SCIENCES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction and Properties of Materials :");
                    unitlist.add("Unit 6. Ferrous Materials :");
                }
                else if (item4.matches("MP 208  INDUSTRIAL ELECTRICAL AND ELECTRONICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Transformers:");
                    unitlist.add("Unit 2. D.C. Motors:");
                    unitlist.add("Unit 3. Induction Motors:");
                    unitlist.add("Unit 5. Measuring Instruments:");
                    unitlist.add("Unit 6. Instrumentation:");
                }
                else if (item4.matches("MP 209  INDUSTRIAL HYDRAULICS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Hydraulics :");
                    unitlist.add("Unit 7. Hydraulic Circuits for Various Industrial Applications:");
                }
                else if (item4.matches("MP 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of 'C' :");
                    unitlist.add("Unit 3. Console Input-Output :");
                    unitlist.add("Unit 4. Control Flow :");
                    unitlist.add("Unit 5. Arrays :");
                    unitlist.add("Unit 6. Functions :");
                    unitlist.add("Unit 7. Pointers :");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types :");
                }
                else if (item4.matches("MP 301 QUALITY AND ENVIRONMENTAL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Quality");
                    unitlist.add("Unit 5. Introduction to Environment :");
                    unitlist.add("Unit 8. Environment Management Systems :");
                }
                else if (item4.matches("MP 303 TOOL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Mechanics of Cutting :");
                    unitlist.add("Unit 6. Jigs and Fixtures :");
                }
                else if (item4.matches("MP 306  PRODUCTION SYSTEM MANAGEMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. New Product Design");
                    unitlist.add("Unit 3. Demand Forecasting :");
                    unitlist.add("Unit 4. Production Planning and Control:");
                    unitlist.add("Unit 11. Group Technology :");
                    unitlist.add("Unit 12. Just in Time Manufacturing :");
                }
                else if (item4.matches("MP 307 INDUSTRIAL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Production, Planning and Control :");
                    unitlist.add("Unit 2. Inventory Control :");
                    unitlist.add("Unit 3. Inspection and Quality Control :");
                    unitlist.add("Unit 4. Work Study :");
                    unitlist.add("Unit 5. Plant Location and Layout :");
                    unitlist.add("Unit 6. Material Handling :");
                    unitlist.add("Unit 7. Linear Programming :");
                    unitlist.add("Unit 8. Depreciation :");
                }
                else if (item4.matches("MP 308 METAL FORMING PROCESSES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 3. Various Metal Forming Operations :");
                    unitlist.add("Unit 6. Extrusion:");
                    unitlist.add("Unit 8. Spinning:");
                }
                else if (item4.matches("MP 309 MEASURMENT SYSTEM ANALYSIS"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Measurement System Analysis:");
                    unitlist.add("Unit 3. Calibration:");
                    unitlist.add("Unit 4. Gauge R & R :");
                    unitlist.add("Unit 5. Measurement Uncertainty :");
                }
                else if (item4.matches("MP 310 MANAGEMENT & ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management :");
                    unitlist.add("Unit 2. Human Resources Development :");
                    unitlist.add("Unit 3. Wages and Incentives :");
                    unitlist.add("Unit 4. Material Management :");
                    unitlist.add("Unit 5. Financial Management :");
                    unitlist.add("Unit 6. Marketing Management :");
                    unitlist.add("Unit 7. Entrepreneurship :");
                    unitlist.add("Unit 8. Entrepreneurial Development :");
                    unitlist.add("Unit 9. Entrepreneurship Support System:");
                    unitlist.add("Unit 10. Setting up SSI :");
                    unitlist.add("Unit 11. Tax System and Insurance :");
                    //unitlist.add("Unit 12. Financial Sources for SSI :");
                    unitlist.add("Unit 13. Labour Legislation and Pollution Control Acts :");
                    unitlist.add("Unit 14. Project Report :");
                    unitlist.add("Unit 15. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("MR 201 BASIC REFRIGERATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Refrigeration :");
                    unitlist.add("Unit 3. Simple Vapour Compression System");
                    unitlist.add("Unit 6. Vapour Absorption Systems");
                }
                else if (item4.matches("MR 202 BASIC AIR CONDITIONING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction to Air Conditioning");
                    unitlist.add("Unit 2. Human Comfort");
                    unitlist.add("Unit 4. Air Conditioning Systems");
                }
                else if (item4.matches("MR 203 HEAT TRANSFER"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 6.  Fins");
                }
                else if (item4.matches("MR 204 THERMAL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction");
                    unitlist.add("Unit 2. Gas Laws");
                    unitlist.add("Unit 3. Laws of Thermodynamics");
                    unitlist.add("Unit 9. Air Compressors");
                }
                else if (item4.matches("MR 206 ELECTRICAL ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 6.  Illumination :");
                    unitlist.add("Unit 8. Electrical panels and control equipments");
                }
                else if (item4.matches("MR 207 FLUID ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Properties of Fluid :");
                    unitlist.add("Unit 2.  Fluid Pressure and its Measurement :");
                    unitlist.add("Unit 7. Centrifugal Pump :");
                    unitlist.add("Unit 8.  Water Turbines");
                }
                else if (item4.matches("MR 208 MAINTENANCE AND SAFETY ENGINEERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Maintenance:");
                    unitlist.add("Unit 5. Safety Engineering:");
                }
                else if (item4.matches("MR 209 ENTREPRENEURSHIP DEVELOPMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.  Entrepreneurship :");
                    unitlist.add("Unit 2. Industrial Policy :");
                    unitlist.add("Unit 3.  Entrepreneurial Development :");
                    unitlist.add("Unit 4. Entrepreneurship Support System :");
                    unitlist.add("Unit 5. Setting up SSI :");
                    unitlist.add("Unit 6. Raw Material Management :");
                    unitlist.add("Unit 7. Marketing Facilities :");
                    unitlist.add("Unit 8. Financial Sources for SSI :");
                    unitlist.add("Unit 9. Contracts and Tenders :");
                    unitlist.add("Unit 11. ISO : 9000 Series of Quality System :");
                }
                else if (item4.matches("MR 210 C PROGRAMMING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction :");
                    unitlist.add("Unit 2. Elements of C :");
                    unitlist.add("Unit 3. Console Input-Output :");
                    unitlist.add("Unit 4. Control Flow :");
                    unitlist.add("Unit 5. Arrays :");
                    unitlist.add("Unit 6. Functions :");
                    unitlist.add("Unit 7. Pointers :");
                    unitlist.add("Unit 8. Structure and Enumerated Data Types :");
                }
                else if (item4.matches("MR 301 ADVANCE REFRIGERATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.  Compressors:");
                    unitlist.add("Unit 2. Condensers :");
                    unitlist.add("Unit 3. Cooling Towers :");
                }
                else if (item4.matches("MR 302 ADVANCE AIR CONDITIONING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Ventilation:");
                }
                else if (item4.matches("MR 303 SYSTEM CONTROL & INSTRUMENTATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 7. Measuring Instruments:");
                }
                else if (item4.matches("MR 307 A/C DESIGN & DRAWING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Air Conditioning Load Estimating :");
                    unitlist.add("Unit 3. Duct Design :");
                }
                else if (item4.matches("MR 309 FIRE PREVENTION & PROTECTION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction:");
                    unitlist.add("Unit 2. Methods of Fire Extinguishment & Extinguishing Media:");
                    unitlist.add("Unit 5.  Life Hazards & Means of Escape:");
                    unitlist.add("Unit 6. Fire Safety Management for Various Classes of Occupancies:");
                    unitlist.add("Unit 7. Building Codes & Regulations:");
                }
                else if (item4.matches("MR 310 INDUSTRIAL MANAGEMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Principles of Management :");
                    unitlist.add("Unit 10. Inventory Control and Management:");
                    unitlist.add("Unit 11. PERT AND CPM:");
                }
                else if (item4.matches("BC 201 COMPUTER APPLICATION - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Computer Networking");
                    unitlist.add("Unit 4. Electronic Mail (E-mail)");
                }
                else if (item4.matches("BC 202 ENVIRONMENTAL STUDIES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. General");
                    unitlist.add("Unit 2. Water Pollution");
                    unitlist.add("Unit 3. Air Pollution");
                    unitlist.add("Unit 4. Solid Waste Management");
                    unitlist.add("Unit 5. Land Pollution");
                    unitlist.add("Unit 6. Ecology");
                    unitlist.add("Unit 8. Water Harvesting and Rural Sanitation");
                    unitlist.add("Unit 9. Miscellaneous");
                }
                else if (item4.matches("BC 203 ENTREPRENEURSHIP & PARLOUR MANAGEMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Entrepreneurship");
                    unitlist.add("Unit 2. Entrepreneurship Support System");
                    unitlist.add("Unit 3. Enterpreneural Development");
                    unitlist.add("Unit 4. Setting Up SSI");
                    unitlist.add("Unit 5. Financial Sources for SSI");
                    unitlist.add("Unit 6. Tax System and Insurance");
                    unitlist.add("Unit 7. Essentials of a Good Business Organisation");
                    unitlist.add("Unit 8. Parlour Planning");
                    unitlist.add("Unit 9. Day-to-day Management of Parlour");
                    unitlist.add("Unit 10. Safety Pecautions");
                }
                else if (item4.matches("BC 204 COSMETIC SCIENCE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Cosmetics");
                    unitlist.add("Unit 2. Creams and Lotions");
                    unitlist.add("Unit 3. Nail Enamels");
                    unitlist.add("Unit 4. Skin Toning Agents and Facial Masks");
                    unitlist.add("Unit 5. Coloured Cosmetics for the Facial Makes");
                    unitlist.add("Unit 6. Cosmetics Used for Hair and Scalp");
                    unitlist.add("Unit 7. Water");
                    unitlist.add("Unit 8. Hazards");
                    unitlist.add("Practical 4. Preparation of Astringent Skin Freshener.");
                    unitlist.add("Practical 5. Preparation of Hair Conditioner.");
                    unitlist.add("Practical 6. Preparation of Shampoos.");
                    unitlist.add("Practical 10. Preparation of Home made and Cosmetic Face Packs.");
                }
                else if (item4.matches("BC 205 BEAUTY CULTURE - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Facial");
                    unitlist.add("Unit 2. Make-Up");
                    unitlist.add("Unit 3. Body Massage");
                    unitlist.add("Unit 4. Treatment Planning");
                    unitlist.add("Unit 5. Aromatherapy");
                    unitlist.add("Practical 3.1 Treatment Planning High Frequency Unit");
                    unitlist.add("Practical 3.3 Treatment Planning Oil Heaters");
                    unitlist.add("Practical 3.4 Treatment Planning Steamers");
                    unitlist.add("Practical 3.5 Treatment Planning Galvanic Unit");
                    unitlist.add("Practical 3.6 Treatment Planning Ox illation Unit");
                    unitlist.add("Practical 3.7 Treatment Planning Ozone Unit");
                    unitlist.add("Practical 3.8 Treatment Planning Ultrasonic Unit");
                    unitlist.add("Practical 3.9 Treatment Planning Vacuum Suction Unit");
                    unitlist.add("Practical 3.10 Treatment Planning Micro Bio Face Lifting Unit");
                    unitlist.add("Practical 5. Aromatherapy Practice in giving Aromatherapy Treatments.");
                    unitlist.add("Practical 6. Mehandi Preparation and Application for Fashion effects through Mehandi.");
                }
                else if (item4.matches("BC 206 HAIR DRESSING - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 5. Chemical or Permanent Waving and Straightening");
                    unitlist.add("Practical 7. Practicing Advance hair Cutting and Styling.");
                    unitlist.add("Practical 8. Practicing different kinds of Decoration on Hair Styles.");
                    unitlist.add("Practical 9. Practicing Corrective Hair and Scalp Treatments for Oily Hair, Dry Hair, Falling Hair and Split ends.");

                }
                else if (item4.matches("BC 207 COMMON DISORDERS OF SKIN HAIR & SCALP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Common skin disorders - recognization, causes,prevention and remedies");
                    unitlist.add("Unit 3. Pathogenic organism affecting skin - types, classification multiplication effect on skin and control.");
                    unitlist.add("Unit 6. Disorders of Scalp");
                }
                else if (item4.matches("BC 208 BODY PERFECTION AND YOGA - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.");
                    unitlist.add("Unit 2.");
                    unitlist.add("Unit 4. Yogic Asana");
                    unitlist.add("Practical 1. Treatment through yoga");
                    unitlist.add("Practical 2. Meditation in different asanas.");
                }
                else if (item4.matches("CA 201 COMPUTER APPLICATION-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Computer Networking");
                    unitlist.add("Unit 3. Internet Basic");
                    unitlist.add("Unit 4. Electronic Mail (E-mail)");
                    unitlist.add("Unit 5. World Wide Web (WWW)");
                    unitlist.add("Unit 6. Spreadsheet Package");
                }
                else if (item4.matches("CA 203 PROFESSIONAL STUDIES-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Communication");
                    unitlist.add("Unit 2. Advertising");
                    unitlist.add("Unit 3. Consumer Behaviour & its Advertising in Brief");
                    unitlist.add("Unit 4. Planning and Print Production");
                }
                else if (item4.matches("CA 204 PHOTOGRAPHY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Light");
                    unitlist.add("Unit 2. Composition");
                    unitlist.add("Unit 3. Types of Cameras");
                    unitlist.add("Unit 4. Exposure");
                    unitlist.add("Unit 5. Film");
                    unitlist.add("Unit 6. Bromides");
                    unitlist.add("Unit 7. Lenses");
                    unitlist.add("Unit 8. Dark Room");
                    unitlist.add("Unit 9. Brief Introduction to Digital Camera");
                }
                else if (item4.matches("CA 205 DRAWING & ILLUSTRATION-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Still life");
                }
                else if (item4.matches("CA 206 ADVERTISING DESIGN-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Prepare Full Colour Advertisement");
                }
                else if (item4.matches("CA 208 GRAPHIC DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Danglers");
                    unitlist.add("Unit 2. 2D and 3D Designs like Display Tray, Inflates,30 Mascots, Logo");
                    unitlist.add("Unit 3. Direct Mail Package (at least 5 to be Designed for a Package)");
                }
                else if (item4.matches("CA 301 PROFESSIONAL MANAGEMENT AND ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Types of Business Organisation");
                    unitlist.add("Unit 3. Management Techniques");
                    unitlist.add("Unit 10. Need and Scope of Entrepreneurship");
                }
                else if (item4.matches("CA 302 COPY WRITING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Copy Definition");
                }
                else if (item4.matches("CA 303 PROFESSIONAL STUDIES-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Advertising Campaign");
                    unitlist.add("Unit 2. Direct Advertising");
                    unitlist.add("Unit 3. Media Planning");
                    unitlist.add("Unit 4. Co- ordination of Advertising with other Promotional Marketing Methods");
                    unitlist.add("Unit 5. The Advertising Schedule");
                    unitlist.add("Unit 6. The Advertising Budget");
                }
                else if (item4.matches("CA 304 ADVERTISING PHOTOGRAPHY"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Product Advertisement");
                }
                else if (item4.matches("CA 306 ADVERTISING DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.Advertisement for Magazine");
                }
                else if (item4.matches("CA 307 DIGITAL DESIGNING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Corel Draw Applications");
                }
                else if (item4.matches("ID 201 COMPUTER APPLICATION-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Computer Networking");
                    unitlist.add("Unit 4. Electronic Mail (E-mail)");
                }
                else if (item4.matches("ID 202 ENVIRONMENTAL STUDIES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. General");
                    unitlist.add("Unit 2. Water Pollution");
                    unitlist.add("Unit 3. Air Pollution");
                    unitlist.add("Unit 4. Solid Waste Management");
                    unitlist.add("Unit 5. Land Pollution");
                    unitlist.add("Unit 6. Ecology");
                    unitlist.add("Unit 8. Water Harvesting and Rural Sanitation");
                    unitlist.add("Unit 9. Miscellaneous");
                }
                else if (item4.matches("ID 203 THEORY OF DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Design :");
                    unitlist.add("Unit 2. Colour :");
                }
                else if (item4.matches("ID 204 HISTORY OF INTERIOR DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Modern Architecture :");
                    unitlist.add("Unit 2. Period Furniture :");
                }
                else if (item4.matches("ID 205 BASIC DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Colour");
                    unitlist.add("Unit 3. Three Dimensional Design :");
                }
                else if (item4.matches("ID 206 INTERIOR MATERIAL AND CONSTRUCTION-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Timber :");
                    unitlist.add("Unit 3. Paints,Varnishes, Polishes, Distempers, Snowcem etc. :");
                    unitlist.add("Unit 5. Stairs :");
                }
                else if (item4.matches("ID 207 INTERIOR DESIGN & FURNITURE DESIGN-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Practical 2. Practical Exercises on Furniture Design in the form of Working Drawing of the following :");
                }
                else if (item4.matches("ID 208 WORKSHOP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Practical 2. Exercise in Painting, Polishing Including Preparation of Various Surfaces Like Wood, Wall & Metal Surface.");
                    unitlist.add("Practical 4 Preparing Models of :");
                }
                else if (item4.matches("ID 301 PROFESSIONAL MANAGEMENT AND ENTREPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Types of Business Organisation");
                    unitlist.add("Unit 3. Management Techniques");
                    unitlist.add("Unit 10. Need and Scope of Entrepreneurship");
                }
                else if (item4.matches("ID 302 COMPUTER AIDED DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Drawing Environment :");
                    unitlist.add("Unit 3. Elements of Drawing :");
                }
                else if (item4.matches("ID 303 INTERIOR SPECIFICATION & QUANTITY ESTIMATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Quantities :");
                    unitlist.add("Unit 2. Specifications :");
                }
                else if (item4.matches("ID 304 BUILDING SERVICES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 3. Ventilation :");
                }
                else if (item4.matches("ID 305 NATURAL INTERIOR SCAPING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Natural Landscape of Elements :");
                    unitlist.add("Unit 4. Interior Scapes :");
                }
                else if (item4.matches("ID 306 INTERIOR MATERIAL & CONSTRUCTION-3"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Building Protection :");
                }
                else if (item4.matches("ID 307 INTERIOR DESIGN & FURNITURE DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Preparing Interior Layout Plans and Perspectives of the Following Parts of 3 to 5 Start Hotel :");
                    unitlist.add("Unit 2. Working Project :");
                    unitlist.add("Unit 3. Furniture Design :");
                }
                else if (item4.matches("ID 308 APPLIED DESIGN & DRAWING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Designing Commercial Space :");
                }
                else if (item4.matches("TD 201 COMPUTER APPLICATION-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    //unitlist.add("Unit 1. Branch Related Applications and Softwares ");
                    //unitlist.add("Unit 2. Computer Networking ");
                    //unitlist.add("Unit 3. Internet Basic ");
                    unitlist.add("Unit 4. Electronic Mail (E-mail) ");
                    //unitlist.add("Unit 5. World Wide Web (WWW) ");
                    //unitlist.add("Unit 6. Spreadsheet Package ");
                }
                else if (item4.matches("TD 202 ENVIRONMENTAL STUDIES"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. General ");
                    //unitlist.add("Unit 2. Water Pollution ");
                    //unitlist.add("Unit 3. Air Pollution ");
                    //unitlist.add("Unit 4. Solid Waste Management ");
                    //unitlist.add("Unit 5. Land Pollution ");
                    unitlist.add("Unit 6. Ecology ");
                    //unitlist.add("Unit 7. Social Issues and the Environment ");
                    //unitlist.add("Unit 8. Water Harvesting and Rural Sanitation ");
                    //unitlist.add("Unit 9. Miscellaneous ");

                }
                else if (item4.matches("TD 203 DYEING AND PRINTING-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. History of Dyeing and Printing in India.");
                    //unitlist.add("Unit 2. Classification of Dyes");
                    //unitlist.add("Unit 3. Pretreatments for different Fabrics before Dyeing and Printing.");
                    //unitlist.add("Unit 4. Dyeing and Printing Auxiliaries");
                    unitlist.add("Unit 5. Detailed Study of all Type of Natural & Synthetic Dyes and difference between Dye and Pigment");
                    //unitlist.add("Unit 6. Detailed study of Block Printing methods.");
                    //unitlist.add("Unit 7. Preparation of Printing Paste for different Fabrics with different Dyes.");
                    unitlist.add("Unit 8. After Treatments for Fabrics Dyed and Printed with different Dyes.");
                    //unitlist.add("Unit 9. Elementary knowledge of related m/c used in pretreatment, after Treatment and Dyeing.");
                    unitlist.add("Practical 1. Students shall prepare a file containing the following exercises ");
                    //unitlist.add("Practical 2. Preparation of shade – cards for various dyes.");
                    unitlist.add("Practical 3. Printing of the following articles :");
                }
                else if (item4.matches("TD 204 STRUCTURAL FABRIC DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Brief Study of Semi-Automatic & Automatic Shuttleless Loom.");
                    unitlist.add("Unit 2. Fancy Twills ");
                    unitlist.add("Unit 3. Diamond and Diaper Designs.");
                    unitlist.add("Unit 4. Special Rib and Cord Structures.");
                    unitlist.add("Unit 5. Miscellaneous Structures ");
                    //unitlist.add("Unit 6. Stripe and Check Weave Combinations.");
                    unitlist.add("Unit 7. Fabric Analysis ");
                    unitlist.add("Unit 8. Calculations in Context to ");
                    //unitlist.add("Practical 1. Students shall prepare a file containing the following exercises ");
                    //unitlist.add("Practical 2. Preparation of File as per the Market According to the Following -");
                    //unitlist.add("Practical 3. Estimation of Data for Cloth Reproduction.");
                    //unitlist.add("Practical 4. Construction on loom ");
                }
                else if (item4.matches("TD 205 INDIAN TRADITIONAL TEXTILE"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Study of Indian Traditional Textiles with reference to ");
                    //unitlist.add("Unit 2. State-Wise Names of Different Traditional Textiles of India.");
                    //unitlist.add("Practical 1. Students shall prepare a sample file by collecting 5 motifs of each topic mentioned in theory.");
                    unitlist.add("Practical 2. Suggested Exercises ");
                }
                else if (item4.matches("TD 206 INTRODUCTION TO TEXTILE ART AND CRAFT-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    //unitlist.add("Unit 1. Tie and Dye  Detailed Study in Reference to");
                    //unitlist.add("Unit 2. Applique and Patch work  Detailed Study in Reference to");
                    //unitlist.add("Unit 3. Drafting and Pattern Making Detailed Description with Drafts of following");
                    unitlist.add("Unit 4. Folk Art ");
                    unitlist.add("Practical 1. Students shall prepare a Sample File with Salient Features of the following ");
                    unitlist.add("Practical 2. Articles ");
                    //unitlist.add("Practical 3. Pattern Making & Designing for the Following Articles ");
                    //unitlist.add("Practical 4. Madhubani and Phar Painting on Fabric.");
                    //unitlist.add("Practical 5. Illustration of Two Ladies Garment as per Current Fashion Trend.");
                }
                else if (item4.matches("TD 207 DRAWING AND RENDERING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    //unitlist.add("Unit 1. Meaning of Drawing and Rendering");
                    //unitlist.add("Unit 2. How to Draw and Render Study of Related Features");
                    unitlist.add("Practical 1. Study of the Following with Pencil, Pen & Ink and Water Colours-");
                    //unitlist.add("Practical 2. Study of Different Body Part for Expression.");
                    //unitlist.add("Practical 3. Cross - Sectional Study of the Following with Water Colours ");
                    //unitlist.add("Practical 4. Conversion of already drawn forms in to Geometrical and Abstract forms with Pencil, Pen and Ink and Water Colours.");
                    //unitlist.add("Practical 5. Compositions  All Different Themes should be Explained in Context of -");
                }
                else if (item4.matches("TD 208 CREATIVE TEXTILE DESIGN-1"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. All Different Themes should be Explained in Context of :- Different Placements");
                    unitlist.add("Unit 2. All Different Themes should be Explained in Context of :- Different Methods.");
                    //unitlist.add("Practical 1. Children's Wear ");
                    unitlist.add("Practical 2. Teen Age Wear ");
                }
                else if (item4.matches("TD 301 PROFESSIONAL MANAGEMENT AND ENTERPRENEURSHIP"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Meaning and Scope of Business ");
                    unitlist.add("Unit 2. Types of Business Organisation ");
                    //unitlist.add("Unit 3. Management Techniques ");
                    //unitlist.add("Unit 4. Quality Control");
                    //unitlist.add("Unit 5. Financial Management ");
                    //unitlist.add("Unit 6. Marketing ");
                    unitlist.add("Unit 7. Material Management ");
                    //unitlist.add("Unit 8. Human Relations ");
                    //unitlist.add("Unit 9. Foreign Trade ");
                    //unitlist.add("Unit 10. Need and Scope of Entrepreneurship ");
                    //unitlist.add("Unit 11. Project Formulation Process ");
                }
                else if (item4.matches("TD 302 COMPUTER AIDED TEXTILE DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Explanation of Different Textile Design Software.");
                    //unitlist.add("Unit 2. Explanation of Colour Separation Procedure on Computers.");
                    //unitlist.add("Unit 3. Explanation of Scanning and Printing Techniques through Computers.");
                    unitlist.add("Practical 1. Practice on Standard packages of Textile Design for the Following ");
                }
                else if (item4.matches("TD 303 DYEING AND PRINTING-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Detailed Study of dyeing of blends.");
                    unitlist.add("Unit 2. Screen Printing");
                    unitlist.add("Unit 3. Roller printing.");
                    unitlist.add("Unit 4. Transfer printing.");
                    unitlist.add("Unit 5. Colour Fastness test.");
                    unitlist.add("Practical 1. Each student will prepare a file with samples of 40 following");
                    //unitlist.add("Practical 2. Single colour screen printing on silken scarf with acid dyes.");
                    //unitlist.add("Practical 3. Double colour screen printing on cotswool fabric with pigments.");
                    //unitlist.add("Practical 4. Triple colour screen printing on salwar suit with rapid and indigosol dyes.");
                }
                else if (item4.matches("TD 304 STRUCTURL FABRIC DESIGN"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Basic Working Principles of Dobby & Jacquard.(Introductory)");
                    unitlist.add("Unit 2. Detailed Study of Figuring with Extra Threads.");
                    unitlist.add("Unit 3. Detailed Study of Following pile Structure");
                    unitlist.add("Practical 1. Students will Prepare a file with the following Figurative Designs ");
                    //unitlist.add("Practical 2. At least two Designs of each shall be created with draft, peg plan and dent plan on graph paper.");
                    unitlist.add("Practical 3. Construction of Fabric on loom with any one weave mentioned in Theory.");
                }
                else if (item4.matches("TD 305 BASIC TEXTILE KNITTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. History of Knitting.");
                    unitlist.add("Unit 2. Definition & General Terminology");
                    unitlist.add("Unit 3. Types of Knitting ");
                    unitlist.add("Unit 4. Primary Knitted Structures ");
                    //unitlist.add("Unit 5. Comparison of Gersy, Rib and Pearl Fabric.");
                    //unitlist.add("Unit 6. Jacquard Knitting.");
                    unitlist.add("Unit 7. Uses of Knit Fabrics.");
                    unitlist.add("Unit 8. Different Types of Defects in Knitted Fabrics.");
                    //unitlist.add("Practical 1. All Possible Stitches and structures to be constructed on available M/c's and equipments for fabric construction (Minimum 5 exercises to be conducted)");
                    //unitlist.add("Practical 2. Preparation of a file of Knitted Fabric samples collected. (Minimum 20 samples to be collected)");
                    //unitlist.add("Practical 3. It is suggested to have at least a field visit of Knitted fabric construction Industry to impart Practical Knowledge to the students. The students will have to submit with practical applicablity.");
                }
                else if (item4.matches("TD 306 FASHION DESIGN AND ILLUSTRATION"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    //unitlist.add("Unit 1. Fashion and Style");
                    //unitlist.add("Unit 2. Brief Knowledge of the Following ");
                    //unitlist.add("Practical 1. Line sketches in pencil and Ink ");
                    //unitlist.add("Practical 2. Sketches of Boys/Girls/Children/Ladies in pencil /wax/crayons/water and poster colours");
                    unitlist.add("Practical 3. Illustration of different types of Fabrics Plain, Printed, Checks, Dots, Striped and Textured in suitable medium.");
                    unitlist.add("Practical 4. Design and Paint Dresses on Fashion Figures according to Textile swatches.");
                }
                else if (item4.matches("TD 307 FREE HAND DRAWING AND PAINTING"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Study of anatomy for figure drawing, essential for perfect changing of a figure.");
                    //unitlist.add("Practical 1. Figure Study ");
                    //unitlist.add("Practical 2. Compositions ");
                    unitlist.add("Practical 3. The Students will have to prepare to following artucles with dyes/ poster colours/ water colours/ fabric paints/ oil paints ");
                }
                else if (item4.matches("TD 308 CREATIVE TEXTILE DESIGN-2"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. The themes, styles bases and placements should be discussed by teacher for each exercise.");
                    unitlist.add("Unit 2. To understand the different themes and placements students may be sent to market for collection of fabric samples and a record file of these samples may be prepared by students for proper understanding of different designs.");
                    unitlist.add("Practical 1. Practices ");
                    //unitlist.add("Practical 2. Instructions ");
                    //unitlist.add("Practical 3. Practice Exercises ");
                }
                else if (item4.matches("MO 201 ENVIRONMENT & MARKETING MANAGEMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Environment & Ecology ");
                    unitlist.add("Unit 4.Marketing ");
                }
                else if (item4.matches("MO 203 COMMUNICATION SKILL - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1.Grammar ");
                    unitlist.add("Unit 3.Letter Witting ");
                    unitlist.add("Unit 4.Precise Writing");
                }
                else if (item4.matches("MO 204 SHORTHAND & TYPE IN HINDI - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. सारणीयन विधि");
                    unitlist.add("Unit 5. पाण्डुलिपि या संशोधित सामग्री टाइप करना");
                    unitlist.add("Unit 6. कार्बनीकरण एवं डुप्लीकेटिंग/ फोटोकॉपी");
                }
                else if (item4.matches("MO 205 SHORTHAND & TYPE IN ENGLISH - II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Typing Practice of Personal & Business Correspondence ");
                    unitlist.add("Unit 2. Prefixes-");
                    unitlist.add("Unit 3. Suffixes-");
                    unitlist.add("Unit 4. Intersections-");
                    unitlist.add("Unit 5 Special Contractions");
                    unitlist.add("Unit 6. Tabular Statements & Display Typing.");
                    unitlist.add("Unit 7. Typing Corrected Proofs and Manuscripts.");
                }
                else if (item4.matches("MO 206 Business Corespondance-I"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Correspondence ");
                    unitlist.add("Unit 2. Essentials of a Good Business Letter ");
                    unitlist.add("Unit 3. Enquiry Letters ");
                    unitlist.add("Unit 5. Sales Letter ");
                    unitlist.add("Unit 6. Circulars ");
                    unitlist.add("Unit 7. Claims, Complaints and Adjustments ");
                    unitlist.add("Unit 8. Collection Letters ");
                }
                else if (item4.matches("MO 207 HUMAN RELATION & ORGANISATION BEHAVIOUR"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 3. Group Behaviour ");
                    unitlist.add("Unit 4. Transactional Analysis ");
                    unitlist.add("Unit 8. Stress Management ");
                    unitlist.add("Unit 9. Time Management ");
                }
                else if (item4.matches("MO 301 ENTERPRENEURSHIP DEVELOPMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 3. Understanding Human Behaviour ");
                    unitlist.add("Unit 4. Industrial Sectors & Demand Identification ");
                }
                else if (item4.matches("MO 302 COMPUTER APPLICATION-III"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Web Publishing ");
                    unitlist.add("Unit 2. Creating & Maintaining Web Sites ");
                    unitlist.add("Unit 3. HTML Fundamentals ");
                    unitlist.add("Unit 4. HTML ");
                    unitlist.add("Unit 5. Web Editors ");
                }
                else if (item4.matches("MO 303 COMMUNICATION SKILL-III"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Ways of Effective Communication ");
                    unitlist.add("Unit 2. Grammar");
                }
                else if (item4.matches("MO 304 SHORTHAND & TYPE IN HINDI "))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. अतिरिक्त सरल शब्द चिन्ह");
                    unitlist.add("Unit 3. विभागीय शब्द");
                }
                else if (item4.matches("MO 305 SHORTHAND & TYPE IN ENGLISH-III"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 3. Dictation in various field ");
                    unitlist.add("Unit 3. Tabulation (Type Writing)");
                }
                else if (item4.matches("MO 306 BUSINESS CORRESPONDENCE-II"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 2. Government Correspondence ");
                    unitlist.add("Unit 3. Bank Correspondence ");
                    unitlist.add("Unit 5 Notice, Agenda, And Minutes of Routine Meetings ");
                    unitlist.add("Unit 6. Credit Letters ");
                }
                else if (item4.matches("MO 307 BUSINESS LAW AND ENVIRONMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 4. Business and Business Environment ");
                }
                else if (item4.matches("MO 308 HUMAN RESOURCE MANAGEMENT"))
                {
                    spinner5.setEnabled(true);
                    //branchlist.clear();
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                    unitlist.add("Unit 1. Introduction ");
                    unitlist.add("Unit 2. Recruitment ");
                    unitlist.add("Unit 5. Employee Compensation ");
                }
                else if(item4.matches("Resume and Interview skills"))
                {
                    item5 = item4;
                    btnSearch.setEnabled(true);
                }
                else if(item4.matches("Yoga and Physical Exercises"))
                {
                    item5 = item4;
                    btnSearch.setEnabled(true);
                }
                else if(item4.matches("Personality Development"))
                {
                    item5 = item4;
                    btnSearch.setEnabled(true);
                }
                else if(item4.matches("Miscellaneous"))
                {
                    item5 = item4;
                    btnSearch.setEnabled(true);
                }
                else
                {
                    btnSearch.setEnabled(false);
                    spinner5.setEnabled(false);
                    unitlist.clear();
                    unitlist.add("Select Unit");
                    fifthAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        forthAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner4.setAdapter(forthAdapter);


        unitlist.add("Select Unit");
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent5, View view, int position, long id) {
                                                   item5 = parent5.getItemAtPosition(position).toString();
                                                   if((unitlist.contains(""+item5)) && !item5.matches("Select Unit"))
                                                   {
                                                       btnSearch.setEnabled(true);
                                                   }
                                                   else
                                                   {
                                                       //spinner5.setEnabled(true);
                                                       fifthAdapter.notifyDataSetChanged();
                                                       btnSearch.setEnabled(false);
                                                   }
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           });
        fifthAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner5.setAdapter(fifthAdapter);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("course",item1);
                intent.putExtra("year",item2);
                intent.putExtra("branch",item3);
                intent.putExtra("subcode",item4);
                intent.putExtra("unit",item5);
                view.getContext().startActivity(intent);
            }
        });
    }

    private void showVideo() {
       String URL="http://192.168.43.23/admin/User_api/tcc?token_key=AaShTaK@2020@WaterSupplY&subcode=EL201/EF%20201&pointno=1.1";

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("Data");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String jsonVideoId=jsonObject1.getString("ItemId");
                        String jsonTeacherName = jsonObject1.getString("TeacherName");
                       // Log.e(TAG,"video ID"+jsonVideoId);
                        //  String videoid=jsonVideoId.getString("kind");
                        //  JSONObject jsonsnippet= jsonObject1.getJSONObject("snippet");
                        //JSONObject jsonObjectdefault = jsonsnippet.getJSONObject("thumbnails").getJSONObject("default");
                        String Topic=jsonObject1.getString("Topic");
                        String Unit=jsonObject1.getString("Unit");


                        VideoDetails videoDetails=new VideoDetails();

                        // String videoid=jsonVideoId.getString("kind");
                        //Log.e(TAG," New Video Id" +videoid);
/*
                        videoDetails.setURL("url");
                        videoDetails.setVideoName(Topic);
                        videoDetails.setVideoDesc(Unit);

                        videoDetails.setVideoId(jsonVideoId);

                        videoDetailsArrayList.add(videoDetails);

 */
                        heroList.add(new Hero(Topic,jsonVideoId , Unit, jsonTeacherName));


//                         videoDetailsArrayList.clear();


                    }
                    lvVideo.setAdapter(customListAdapter);

                    customListAdapter.notifyDataSetChanged();
                    // lvVideo.setAdapter(null);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);

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
            startActivity(new Intent(electure.this, MainActivity.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(electure.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(electure.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(electure.this,WebViewActivity.class);
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
            startActivity(new Intent(electure.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(electure.this,disclaimer.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}