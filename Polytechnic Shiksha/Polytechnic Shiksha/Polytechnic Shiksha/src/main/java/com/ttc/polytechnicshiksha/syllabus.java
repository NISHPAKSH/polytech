package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class syllabus extends AppCompatActivity {
    public static String url;
    public static String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Syllabus");

        TextView textView1 =(TextView)findViewById(R.id.semester_scheme);
        textView1.setClickable(true);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());
        //String text1 = "<a href='http://techedu.rajasthan.gov.in/BTER/Diploma_Programmes_SEMESTER.htm'> 1. Semester Scheme Syllabus. Click to visit this link </a>";
        //textView1.setText(Html.fromHtml(text1));
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://techedu.rajasthan.gov.in/BTER/Diploma_Programmes_SEMESTER.htm";

                title = "Semester Scheme";
                Intent web = new Intent(syllabus.this,WebViewActivity.class);
                web.putExtra("url",url);
                web.putExtra("title",title);
                startActivity(web);

            }
        });

        TextView textView2 =(TextView)findViewById(R.id.yearly_scheme);
        textView2.setClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        //String text2 = "<a href='http://www.techedu.rajasthan.gov.in/BTER/Diploma_Programmes.htm'> 2. Yearly Scheme Sylllabus. Click to visit this link </a>";
        //textView2.setText(Html.fromHtml(text2));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://www.techedu.rajasthan.gov.in/BTER/Diploma_Programmes.htm";

                title = "Yearly Scheme";
                Intent web = new Intent(syllabus.this,WebViewActivity.class);
                web.putExtra("url",url);
                web.putExtra("title",title);
                startActivity(web);

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
            startActivity(new Intent(syllabus.this,MainActivity.class));
            return true;
        }
        if (id == R.id.login)
        {
            startActivity(new Intent(syllabus.this,login.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(syllabus.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(syllabus.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(syllabus.this,WebViewActivity.class);
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
            startActivity(new Intent(syllabus.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(syllabus.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}