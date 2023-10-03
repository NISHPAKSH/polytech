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

public class imp_link extends AppCompatActivity {
    public static String url;
    public static String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_link);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Important Webpage");
        TextView textView1 =(TextView)findViewById(R.id.hte);
        textView1.setClickable(true);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());
        //String text1 = "<a href='https://hte.rajasthan.gov.in/'> 1. Higher Technical and Medical Education, Government of Rajasthan </a>";
        //textView1.setText(Html.fromHtml(text1));
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://hte.rajasthan.gov.in/";

                title = "HTE, Rajasthan";
                Intent web = new Intent(imp_link.this,WebViewActivity.class);
                web.putExtra("url",url);
                web.putExtra("title",title);
                startActivity(web);

            }
        });



        TextView textView2 =(TextView)findViewById(R.id.dte);
        textView2.setClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        //String text2 = "<a href='http://dte.rajasthan.gov.in/'> 2. Department of Technical Education, Government of Rajasthan </a>";
        //textView2.setText(Html.fromHtml(text2));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://dte.rajasthan.gov.in/";
                title = "DTE Rajasthan";
                Intent web = new Intent(imp_link.this,WebViewActivity.class);
                web.putExtra("url",url);
                web.putExtra("title",title);
                startActivity(web);

            }
        });

        TextView textView3 =(TextView)findViewById(R.id.bter);
        textView3.setClickable(true);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        //String text3 = "<a href='http://techedu.rajasthan.gov.in/'> 3. Board of Technical Education, Government of Rajasthan </a>";
        //textView3.setText(Html.fromHtml(text3));
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://techedu.rajasthan.gov.in/";
                title = "BTER JODHPUR";
                Intent web = new Intent(imp_link.this,WebViewActivity.class);
                web.putExtra("url",url);
                web.putExtra("title",title);
                startActivity(web);

            }
        });

        TextView textView4 =(TextView)findViewById(R.id.ttc);
        textView4.setClickable(true);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        //String text4 = "<a href='https://hte.rajasthan.gov.in/college/ttcjodhpur/lrdc'>4. Teachers Training Center and Learning Resource Development Center, Government of Rajasthan </a>";
        //textView4.setText(Html.fromHtml(text4));
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://hte.rajasthan.gov.in/college/ttcjodhpur";
                title = "TTC & LRDC, Jodhpur";
                Intent web = new Intent(imp_link.this,WebViewActivity.class);
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
            startActivity(new Intent(imp_link.this,MainActivity.class));
            return true;
        }
        if (id == R.id.login)
        {
            startActivity(new Intent(imp_link.this,login.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(imp_link.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(imp_link.this,syllabus.class));
            return true;
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
            startActivity(new Intent(imp_link.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(imp_link.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}