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

public class mcq extends AppCompatActivity {
    public static String url;
    public static String title;
    String item7;
    String item8;
    String item9;

    List<String> categories3 = new ArrayList<String>();
    List<String> branchlist3 = new ArrayList<>();

    ArrayAdapter<CharSequence> adapter ;
    ArrayAdapter<String> dataAdapter ;
    ArrayAdapter<String> thirdAdapter ;
    WebView webview_mcq;

    private Button mcqBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("MCQs");

        mcqBtn = (Button) findViewById(R.id.mcqbtngo);
        mcqBtn.setEnabled(false);
        webview_mcq = (WebView) findViewById(R.id.webview_mcq);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_mcq_course);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_mcq_year);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_mcq_branch);

        adapter = ArrayAdapter.createFromResource(this, R.array.labmanual_array, R.layout.simple_spinner_item11);
        dataAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, categories3);
        thirdAdapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item11, branchlist3);
        spinner2.setEnabled(false);
        spinner3.setEnabled(false);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                item7 = parent.getItemAtPosition(pos).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + item7, Toast.LENGTH_LONG).show();
                if (item7.matches("Engineering"))
                {
                    categories3.clear();
                    spinner2.setEnabled(true);
                    categories3.add("Select Year");

                    categories3.add("First Year");
                    //categories3.add("Second Semester");
                    categories3.add("Second Year");
                    categories3.add("Third Year");
                }
                else if (item7.matches("Non-Engineering")){
                    //Toast.makeText(this, item, Toast.LENGTH_LONG).show();
                    categories3.clear();
                    // categories.add("Select Type2");

                    categories3.add("Select Year");

                    categories3.add("First Year");
                    //categories3.add("Second Semester");
                    categories3.add("Second Year");
                    categories3.add("Third Year");

                }
                else
                {
                    //categories.clear();
                    categories3.clear();
                    categories3.add("Select Year");
                    branchlist3.clear();
                    branchlist3.add("Select Branch");

                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);

                    dataAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();

                    mcqBtn.setEnabled(false);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner.setAdapter(adapter);


        categories3.add("Select Year");
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                // your code here
                item8 = parentView.getItemAtPosition(position).toString();
                //Toast.makeText(parentView.getContext(), "Selected: " + item8, Toast.LENGTH_LONG).show();
                if (item8.matches("First Year"))
                {
                    spinner3.setVisibility(View.GONE);
                    //branchlist3.clear();
                    //branchlist3.add("Click Go Button");
                    spinner3.setEnabled(false);
                    mcqBtn.setEnabled(true);
                    thirdAdapter.notifyDataSetChanged();
                }

                else if (item8.matches("Second Year"))
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist3.clear();
                    branchlist3.add("Select Branch");
                    mcqBtn.setEnabled(false);
                    thirdAdapter.notifyDataSetChanged();
                    branchlist3.add("CHEMICAL ENGINEERING");
                    branchlist3.add("CIVIL ENGINEERING");
                    branchlist3.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist3.add("ELECTRICAL ENGINEERING");
                    branchlist3.add("ELECTRONICS ENGINEERING");
                    branchlist3.add("INSTRUMENTATION ENGINEERING");
                    branchlist3.add("MECHANICAL AUTOMOBILE ENGINEERING");
                    branchlist3.add("MECHANICAL ENGINEERING");
                    branchlist3.add("MECHANICAL PRODUCTION ENGINEERING");
                    branchlist3.add("MECHANICAL RAC ENGINEERING");
                    branchlist3.add("PLASTIC TECHNOLOGY");
                    branchlist3.add("PRINTING TECHNOLOGY");


                }
                else if (item8.matches("Third Year"))
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(true);
                    branchlist3.clear();
                    branchlist3.add("Select Branch");
                    mcqBtn.setEnabled(false);
                    thirdAdapter.notifyDataSetChanged();
                    branchlist3.add("ARCHITECTURE ENGINEERING");
                    branchlist3.add("CHEMICAL ENGINEERING");
                    branchlist3.add("CIVIL ENGINEERING");
                    branchlist3.add("COMPUTER SCIENCE & ENGINEERING");
                    branchlist3.add("ELECTRICAL ENGINEERING");
                    branchlist3.add("ELECTRONICS ENGINEERING");
                    branchlist3.add("ELECTRONICS FIBER ENGINEERING");
                    branchlist3.add("INSTRUMENTATION ENGINEERING");
                    branchlist3.add("MECHANICAL AUTOMOBILE ENGINEERING");
                    branchlist3.add("MECHANICAL ENGINEERING");
                    branchlist3.add("MECHANICAL PRODUCTION ENGINEERING");
                    branchlist3.add("MECHANICAL RAC ENGINEERING");
                    branchlist3.add("PLASTIC TECHNOLOGY");
                    branchlist3.add("PRINTING TECHNOLOGY");


                }
                else
                {
                    spinner3.setVisibility(View.VISIBLE);
                    spinner3.setEnabled(false);
                    branchlist3.clear();
                    branchlist3.add("Select Branch");
                    dataAdapter.notifyDataSetChanged();
                    thirdAdapter.notifyDataSetChanged();
                    mcqBtn.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner2.setAdapter(dataAdapter);


        branchlist3.add("Select Branch");
        thirdAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent3, View view, int position, long id) {
                item9 = parent3.getItemAtPosition(position).toString();
                //Toast.makeText(view.getContext(),"Selected : " +item9,Toast.LENGTH_LONG);
                if((branchlist3.contains(""+item9)) && !item9.matches("Select Branch"))
                {
                    mcqBtn.setEnabled(true);
                }
                else
                {

                    thirdAdapter.notifyDataSetChanged();
                    mcqBtn.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setAdapter(thirdAdapter);


        mcqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((item7.matches("Engineering")))
                {
                    if (item8.matches("First Year"))
                    {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/12ARtXUEWttwLXyPHSLlhLi5qr1I8Fsco");
                    }
                    else if (item8.matches("Second Year"))
                    {
                        if (item9.matches("ELECTRICAL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1WWF3Bb3NCkOolwhOGln3zQXTo-PCrI9M");
                        }
                        else if (item9.matches("CHEMICAL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1sN3TIN6mF3yzhh6giM6quS1VeOb7h6XD");
                        }
                        else if (item9.matches("CIVIL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/170WRL3-7RP5GMh2srjHSUnOyZXz3F3qv");
                        }
                        else if (item9.matches("COMPUTER SCIENCE & ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1NKS52G6jdMJnjkUVB-Z0rQ0hpGOt0REg");
                        }
                        else if (item9.matches("ELECTRONICS ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1WejLsjhX61oa7GD7QGNvrUD2Sf9cRbFx");
                        }
                        else if (item9.matches("MECHANICAL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1f6xkqLTbbdAJXM3jTsgK6TAZaTlyDWNB");
                        }
                        else if (item9.matches("INSTRUMENTATION ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1D2Ss46Vcjnb4u1Nq6fa_mAIkG2ZKgbrN");
                        }
                        else if (item9.matches("MECHANICAL PRODUCTION ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/19OUY-ojo4zLX4EIs4OTIwqnoLKkza3s8");
                        }
                        else if (item9.matches("MECHANICAL RAC ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1fYP7hQku_st-NNPexik7ealr9McIOAqx");
                        }
                        else if (item9.matches("PLASTIC TECHNOLOGY"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1Q0MvEBLKmqJVThYYYD6ZSpM9BKnbFbBz");
                        }
                        else if (item9.matches("PRINTING TECHNOLOGY"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1M4z-sMzO-aRNzd0wLtucQ5qc4wypYrxL");
                        }
                        else if (item9.matches("MECHANICAL AUTOMOBILE ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1seOUMP5QNr1L7jslVfH38mlWoUXrlpre");
                        }

                    }
                    else if (item8.matches("Third Year"))
                    {
                        if (item9.matches("ELECTRICAL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1-PDgYLqTwrsUBAvXDLmdWiMGsT-E4WDT");
                        }
                        else if (item9.matches("CHEMICAL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1FNvMMzzVByw2Yo-ApQNghD0DDtr2qphm");
                        }
                        else if (item9.matches("CIVIL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1N4k87pr7n7V75BPS-s-h3lwrFMAIUSKv");
                        }
                        else if (item9.matches("COMPUTER SCIENCE & ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1VApQnCY6viw_-9sGypJxZy6orN1ithi7");
                        }
                        else if (item9.matches("ELECTRONICS ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1aioLwjFS0IFVmkm70E5DoXsE_b3Oc_6b");
                        }
                        else if (item9.matches("MECHANICAL ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1C6ZyVJ188yBFwVNoSG1wtQebBAT8CTDY");
                        }
                        else if (item9.matches("INSTRUMENTATION ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1-ATcFuB90jpwCbDxUXG6-8OJUKa7q2_a");
                        }
                        else if (item9.matches("MECHANICAL PRODUCTION ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1CVAGsAlt8S4fAZ8fcnXpkE2X9nVlDv2b");
                        }
                        else if (item9.matches("MECHANICAL RAC ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1MlLng5LyidPfXcHLXgB1k3rAzUrDCAv0");
                        }
                        else if (item9.matches("PLASTIC TECHNOLOGY"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1H4rWmtbEc1GmCXajcyXL1ErrROHFpx6e");
                        }
                        else if (item9.matches("PRINTING TECHNOLOGY"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1ESmSp0LneRQCrj6ubIl9fNcGdguoSI0W");

                        }
                        else if (item9.matches("MECHANICAL AUTOMOBILE ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1YtEc3SGCI09X12FmgYH6-QB2H-YF51N9");
                        }
                        else if (item9.matches("ELECTRONICS FIBER ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1HLKRLbscdF64r6tbZov0_29OPodDCFgK");
                        }
                        else if (item9.matches("ARCHITECTURE ENGINEERING"))
                        {
                            //webview_Labmanual.setWebViewClient(new WebViewClient());
                            //mlabBtn.setVisibility(View.INVISIBLE);
                            webview_mcq.loadUrl("https://drive.google.com/drive/folders/1Oy2w5xDXur28OnZS9eyx_IaEDcWvF4R5");
                        }
                    }
                }
                else
                {
                    startActivity(new Intent(mcq.this, workinprogress.class));
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
            startActivity(new Intent(mcq.this, MainActivity.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(mcq.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(mcq.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(mcq.this,WebViewActivity.class);
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
                        public void onClick(DialogInterface dialog, int which)
                        {
                            finishAffinity();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }
        if (id == R.id.contact_us) {
            startActivity(new Intent(mcq.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(mcq.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}