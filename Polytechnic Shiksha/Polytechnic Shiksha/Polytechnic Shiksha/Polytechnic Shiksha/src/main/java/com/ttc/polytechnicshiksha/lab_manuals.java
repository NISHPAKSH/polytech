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
    String item6;

    List<String> categories2 = new ArrayList<String>();
    List<String> branchlist2 = new ArrayList<>();

    ArrayAdapter<String> dataAdapter ;
    ArrayAdapter<String> thirdAdapter ;
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

        mlabBtn = (Button) findViewById(R.id.labmbtngo);

        WebView webview_Labmanual = (WebView) findViewById(R.id.webview_labm);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_labm_course);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_labm_year);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_labm_branch);

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
                    categories2.clear();
                    spinner2.setEnabled(true);
                    categories2.add("Select Semester");
                    categories2.add("First Semester");
                    categories2.add("Second Semester");
                    //categories2.add("Second Year");
                    //categories2.add("Third Year");
                }
                else
                {
                    categories2.clear();
                    categories2.add("Select Semester");

                    branchlist2.clear();
                    branchlist2.add("Select Subject");

                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);

                    dataAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();

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
                if (item5.matches("First Semester"))
                {
                    branchlist2.clear();
                    branchlist2.add("Select Subject");
                    spinner3.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(false);
                    branchlist2.add("ENGINEERING GRAPHICS");
                    branchlist2.add("ENGINEERING WORKSHOP");
                    branchlist2.add("APPLIED PHYSICS-I");
                    branchlist2.add("APPLIED CHEMISTRY");
                    branchlist2.add("ENGLISH");
                }
                else if (item5.matches("Second Semester")){

                    branchlist2.clear();
                    branchlist2.add("Select Subject");
                    spinner3.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                    mlabBtn.setEnabled(false);
                    branchlist2.add("APPLIED PHYSICS-II");
                    branchlist2.add("IT SYSTEMS");
                    branchlist2.add("ELECTRICAL AND ELECTRONICS ENGINEERING");

                }
                else
                {
                    branchlist2.clear();
                    branchlist2.add("Select Subject");

                    spinner3.setEnabled(false);

                    thirdAdapter.notifyDataSetChanged();

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


        branchlist2.add("Select Subject");
        thirdAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position, long id) {
                item6 = parent3.getItemAtPosition(position).toString();
                //Toast.makeText(view.getContext(),"Selected : " +item6,Toast.LENGTH_LONG);
                if((branchlist2.contains("" +item6)) && !item6.matches("Select Subject"))
                {
                    mlabBtn.setEnabled(true);
                }
                else
                {
                    thirdAdapter.notifyDataSetChanged();

                    mlabBtn.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setAdapter(thirdAdapter);



        mlabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((item4.matches("Engineering")))
                {
                    if (item5.matches("First Semester"))
                    {
                        if (item6.matches("ENGINEERING GRAPHICS"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1_Sj96qluIJBJd2z6Bz9IQhTC_ZRDPpvM");

                        }
                        else if (item6.matches("ENGINEERING WORKSHOP"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1MHMc66wxCJpAKG3a0__9PIGQqDJWWxcj");

                        }
                        else if (item6.matches("APPLIED PHYSICS-I"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1mgsn2bDrxvxBJattGjUy7T-SRlUiaC-o");

                        }
                        else if (item6.matches("APPLIED CHEMISTRY"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1Bxz5ixXHgPwX2JCuoEnbiUM0io2Ezxbx");

                        }
                        else if (item6.matches("ENGLISH"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/18ulYblsgTUumubSdCqT0vR7yQ5c2zSBj");

                        }
                    }
                    else if (item5.matches("Second Semester"))
                    {
                        if (item6.matches("APPLIED PHYSICS-II"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/11cBsRRw2VfsDvb9Dq9t7u57PiCF3AYQU");
                        }
                        else if (item6.matches("IT SYSTEMS"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1dulXNlZUW-WyIjeox39j33s7HlttwChP");
                        }
                        else if (item6.matches("ELECTRICAL AND ELECTRONICS ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_Labmanual.loadUrl("https://drive.google.com/drive/folders/1p4yndRU8bFY1_wCiaFWX6LmPvAbS0Q4R");
                        }
                    }
                }
                else
                {
                    startActivity(new Intent(lab_manuals.this, workinprogress.class));
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