package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class lab_manuals extends AppCompatActivity {
    public static String url;
    public static String title;
    String item4;
    String item5;
    String item6, item7;

    TextView branchtview;

    List<String> categories2 = new ArrayList<String>();
    List<String> branchlist2 = new ArrayList<>();
    List<String> subjectlist2 = new ArrayList<>();

    ArrayAdapter<String> dataAdapter ;
    ArrayAdapter<String> thirdAdapter ;
    ArrayAdapter<String> fourthAdapter ;
    ArrayAdapter<CharSequence> adapter ;
    private Button mlabBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_manuals);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Lab Manuals");

        adapter = ArrayAdapter.createFromResource(this, R.array.labmanual_array, R.layout.simple_spinner_item11);
        dataAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, categories2);
        thirdAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, branchlist2);
        fourthAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, subjectlist2);


        mlabBtn = (Button) findViewById(R.id.labmbtngo);
        branchtview = (TextView) findViewById(R.id.tv_spinner3);

        WebView webview_Labmanual = (WebView) findViewById(R.id.webview_labm);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_labm_course);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_labm_year);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_labm_branch);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner_labm_subject);

        spinner2.setEnabled(false);
        spinner3.setEnabled(false);

        mlabBtn.setEnabled(false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                item4 = parent.getItemAtPosition(pos).toString();

                //Toast.makeText(parent.getContext(), "Selected: " + item4, Toast.LENGTH_LONG).show();
                if (item4.matches("Engineering"))
                {
                    spinner2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    spinner2.setEnabled(true);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);
                    categories2.clear();
                    spinner2.setEnabled(true);
                    categories2.add("Select Semester");
                    categories2.add("First Semester");
                    categories2.add("Second Semester");
                    categories2.add("Third Semester");
                    categories2.add("Fourth Semester");

                    dataAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    fourthAdapter.notifyDataSetChanged();
                }
                else
                {
                    categories2.clear();
                    categories2.add("Select Semester");

                    branchlist2.clear();
                    branchlist2.add("Select Branch");

                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");

                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                    spinner4.setEnabled(false);

                    dataAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    fourthAdapter.notifyDataSetChanged();

                    mlabBtn.setEnabled(false);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        //spinner.setPrompt("Select E-Lecture for...");
        spinner.setAdapter(adapter);


        categories2.add("Select Semester");
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                // your code here
                item5 = parentView.getItemAtPosition(position).toString();
                //Toast.makeText(parentView.getContext(), "Selected: " + item5, Toast.LENGTH_LONG).show();
                if (item4.matches("Engineering") && item5.matches("First Semester"))
                {
                    branchtview.setVisibility(View.GONE);
                    spinner3.setVisibility(View.GONE);
                    branchlist2.clear();
                    branchlist2.add("First Semester");
                    spinner4.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(false);
                    subjectlist2.add("ENGINEERING GRAPHICS");
                    subjectlist2.add("ENGINEERING WORKSHOP");
                    subjectlist2.add("APPLIED PHYSICS-I");
                    subjectlist2.add("APPLIED CHEMISTRY");
                    subjectlist2.add("ENGLISH");
                    item6 = "First Semester";
                }
                else if (item5.matches("Second Semester")){

                    branchtview.setVisibility(View.GONE);
                    spinner3.setVisibility(View.GONE);
                    branchlist2.clear();
                    branchlist2.add("Second Semester");
                    spinner4.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(false);
                    subjectlist2.add("APPLIED PHYSICS-II");
                    subjectlist2.add("IT SYSTEMS");
                    subjectlist2.add("ELECTRICAL AND ELECTRONICS ENGINEERING");
                    item6 = "Second Semester";

                }
                else if (item5.matches("Third Semester")){

                    branchtview.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    branchlist2.clear();
                    branchlist2.add("Select Branch");
                    spinner3.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    spinner4.setEnabled(false);
                    mlabBtn.setEnabled(false);
                    branchlist2.add("CIVIL ENGINEERING");
                    branchlist2.add("ELECTRICAL ENGINEERING");
                    branchlist2.add("ELECTRONICS ENGINEERING");
                    branchlist2.add("MECHANICAL ENGINEERING");

                }
                else if (item5.matches("Fourth Semester")){

                    branchtview.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                    branchlist2.clear();
                    branchlist2.add("Select Subject");
                    spinner3.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    spinner4.setEnabled(false);
                    mlabBtn.setEnabled(false);
                    branchlist2.add("MECHANICAL ENGINEERING");

                }
                else
                {
                    branchlist2.clear();
                    branchlist2.add("Select Branch");
                    spinner3.setEnabled(false);
                    thirdAdapter.notifyDataSetChanged();

                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    spinner4.setEnabled(false);

                    mlabBtn.setEnabled(false);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner2.setAdapter(dataAdapter);


        branchlist2.add("Select Branch");
        thirdAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position, long id) {
                item6 = parent3.getItemAtPosition(position).toString();
                //Toast.makeText(view.getContext(),"Selected : " +item6,Toast.LENGTH_LONG);
                if (item6.matches("CIVIL ENGINEERING") && item5.matches("Third Semester"))
                {
                    //branchtview.setVisibility(View.GONE);
                    //spinner3.setVisibility(View.GONE);
                    //branchlist2.clear();
                    //branchlist2.add("First Semester");
                    spinner4.setEnabled(true);
                    //thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(true);
                    subjectlist2.add("CE 3009 MECHANICS OF MATERIALS LAB");
                    subjectlist2.add("CE 3010 CONCRETE TECHNOLOGY LAB");
                }
                else if (item6.matches("MECHANICAL ENGINEERING") && item5.matches("Third Semester"))
                {
                    //branchtview.setVisibility(View.GONE);
                    //spinner3.setVisibility(View.GONE);
                    //branchlist2.clear();
                    //branchlist2.add("First Semester");
                    spinner4.setEnabled(true);
                    //thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(true);
                    subjectlist2.add("ME 3006 MANUFACTURING ENGINEERING-I LAB");
                    subjectlist2.add("ME 3007 FLUID MECHANICS & HYDRAULIC MACHINERY LAB");
                    subjectlist2.add("ME 3008 THERMAL ENGINEERING-I LAB");
                    subjectlist2.add("ME 3009 COMPUTER AIDED MACHINE DRAWING PRACTICE");
                }
                else if (item6.matches("ELECTRICAL ENGINEERING") && item5.matches("Third Semester"))
                {
                    //branchtview.setVisibility(View.GONE);
                    //spinner3.setVisibility(View.GONE);
                    //branchlist2.clear();
                    //branchlist2.add("First Semester");
                    spinner4.setEnabled(true);
                    //thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(true);
                    subjectlist2.add("EE 3008 ELECTRICAL AND ELECTRONIC MEASUREMENTS LAB");
                }
                else if (item6.matches("ELECTRONICS ENGINEERING") && item5.matches("Third Semester"))
                {
                    spinner4.setEnabled(true);
                    //thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(true);
                    subjectlist2.add("EL 3007 ELECTRONIC DEVICES AND CIRCUITS LAB");
                }
                else if (item6.matches("MECHANICAL ENGINEERING") && item5.matches("Fourth Semester"))
                {
                    //branchtview.setVisibility(View.GONE);
                    //spinner3.setVisibility(View.GONE);
                    //branchlist2.clear();
                    //branchlist2.add("First Semester");
                    spinner4.setEnabled(true);
                    //thirdAdapter.notifyDataSetChanged();
                    subjectlist2.clear();
                    subjectlist2.add("Select Subject");
                    fourthAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(true);
                    subjectlist2.add("ME 4006 MATERIAL TESTING LAB");
                    subjectlist2.add("ME 4007 MEASUREMENTS & METEOROLOGY LAB");
                    subjectlist2.add("ME 4008 THERMAL ENGINEERING LAB-II");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setAdapter(thirdAdapter);


        subjectlist2.add("Select Subject");
        fourthAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position, long id) {
                item7 = parent3.getItemAtPosition(position).toString();
                //Toast.makeText(view.getContext(),"Selected : " +item6,Toast.LENGTH_LONG);
                if((subjectlist2.contains("" +item7)) && !item7.matches("Select Subject"))
                {
                    mlabBtn.setEnabled(true);
                }
                else
                {
                    fourthAdapter.notifyDataSetChanged();

                    mlabBtn.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setAdapter(fourthAdapter);



        mlabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Wait.. We will take you to google drive link", Toast.LENGTH_SHORT)
                        .show();

                    if (item5.matches("First Semester"))
                    {
                        if (item7.matches("ENGINEERING GRAPHICS"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1_Sj96qluIJBJd2z6Bz9IQhTC_ZRDPpvM");

                        }
                        else if (item7.matches("ENGINEERING WORKSHOP"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1MHMc66wxCJpAKG3a0__9PIGQqDJWWxcj");

                        }
                        else if (item7.matches("APPLIED PHYSICS-I"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1mgsn2bDrxvxBJattGjUy7T-SRlUiaC-o");

                        }
                        else if (item7.matches("APPLIED CHEMISTRY"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1Bxz5ixXHgPwX2JCuoEnbiUM0io2Ezxbx");

                        }
                        else if (item7.matches("ENGLISH"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/18ulYblsgTUumubSdCqT0vR7yQ5c2zSBj");

                        }
                    }
                    else if (item5.matches("Second Semester"))
                    {
                        if (item7.matches("APPLIED PHYSICS-II"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/11cBsRRw2VfsDvb9Dq9t7u57PiCF3AYQU");
                        }
                        else if (item7.matches("IT SYSTEMS"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1dulXNlZUW-WyIjeox39j33s7HlttwChP");
                        }
                        else if (item7.matches("ELECTRICAL AND ELECTRONICS ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1p4yndRU8bFY1_wCiaFWX6LmPvAbS0Q4R");
                        }
                    }
                    else if (item7.matches("CE 3009 MECHANICS OF MATERIALS LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1w-KuGdamt9z1YNNGNitNvtrBK_XTxqEK");
                    }
                    else if (item7.matches("CE 3010 CONCRETE TECHNOLOGY LAB "))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1pPxqX8K_yT14eR8SMnoKVcRDMBWKSE0Y");
                    }
                    else if (item7.matches("EE 3008 ELECTRICAL AND ELECTRONIC MEASUREMENTS LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1Jn_ahRrbPNsPZd02f5N8-SASwQ9NDlGP");
                    }
                    else if (item7.matches("EL 3007 ELECTRONIC DEVICES AND CIRCUITS LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1eYuBpSmojAgOZTWKtb7df83yoWI2eVEc");
                    }
                    else if (item7.matches("ME 3006 MANUFACTURING ENGINEERING-I LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1JyxKv1aFL6xAWOosrsaJ2iM-4jLqkWm6");
                    }
                    else if (item7.matches("ME 3007 FLUID MECHANICS & HYDRAULIC MACHINERY LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1yjUAQc390cwEYSiLzLtrQsFDr6thpf58");
                    }
                    else if (item7.matches("ME 3008 THERMAL ENGINEERING-I LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1c0F1ApKfKGPseWxR9CfL6UNy8pznKaD5");
                    }
                    else if (item7.matches("ME 3009 COMPUTER AIDED MACHINE DRAWING PRACTICE"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/17mPHCwDklWUBXlqFv-WE4xMXZEdMInkJ");
                    }
                    else if (item7.matches("ME 4006 MATERIAL TESTING LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/13_a8o5v18a-jbzK29nYJbdjpPxxB4BgE");
                    }
                    else if (item7.matches("ME 4007 MEASUREMENTS & METEOROLOGY LAB"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1CA_5DdzVSlYaXmDAjkH8aZjWP6Zbjtq1");
                    }
                    else if (item7.matches("ME 4008 THERMAL ENGINEERING LAB-II"))
                    {
                        //webview_Labmanual.setWebViewClient(new WebViewClient());
                        //mlabBtn.setVisibility(View.INVISIBLE);
                        webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1LJN4TQh7Dldcfz4aPJ6ewnh9wmw3k55B");
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
            startActivity(new Intent(lab_manuals.this, MainActivity.class));
            return true;
        }
        if (id == R.id.login)
        {
            startActivity(new Intent(lab_manuals.this,login.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(lab_manuals.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(lab_manuals.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(lab_manuals.this,WebViewActivity.class);
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
            startActivity(new Intent(lab_manuals.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(lab_manuals.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}