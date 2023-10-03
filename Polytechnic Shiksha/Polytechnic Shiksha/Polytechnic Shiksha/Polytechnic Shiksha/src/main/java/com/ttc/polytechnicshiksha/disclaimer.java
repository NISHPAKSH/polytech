package com.ttc.polytechnicshiksha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class disclaimer extends AppCompatActivity {
    public static String url;
    public static String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Legal");

        TextView tview1 = (TextView) findViewById(R.id.tv1);
        TextView tview2 = (TextView) findViewById(R.id.tv2);
        TextView tview3 = (TextView) findViewById(R.id.tv3);
        TextView tview4 = (TextView) findViewById(R.id.tv4);
        TextView tview5 = (TextView) findViewById(R.id.tv5);
        TextView tview6 = (TextView) findViewById(R.id.tv6);
        TextView tview7 = (TextView) findViewById(R.id.tv7);
        TextView tview8 = (TextView) findViewById(R.id.tv8);
        TextView tview9 = (TextView) findViewById(R.id.tv9);
        TextView tview10 = (TextView) findViewById(R.id.tv10);
        TextView tview11 = (TextView) findViewById(R.id.tv11);
        TextView tview12 = (TextView) findViewById(R.id.tv12);
        TextView tview13 = (TextView) findViewById(R.id.tv13);
        TextView tview14 = (TextView) findViewById(R.id.tv14);
        TextView tview15 = (TextView) findViewById(R.id.tv15);
        TextView tview16 = (TextView) findViewById(R.id.tv16);
        TextView tview17 = (TextView) findViewById(R.id.tv17);
        TextView tview18 = (TextView) findViewById(R.id.tv18);
        TextView tview19 = (TextView) findViewById(R.id.tv19);
        TextView tview20 = (TextView) findViewById(R.id.tv20);
        TextView tview21 = (TextView) findViewById(R.id.tv21);
        TextView tview22 = (TextView) findViewById(R.id.tv22);
        TextView tview23 = (TextView) findViewById(R.id.tv23);

        //String text = "<font color=#cc0029>First Color</font> <font color=#ffcc00>Second Color</font>";
        String text1 = "POLYTECHNIC SHIKSHA LEGAL:";
        String text2 = "This is in the context of and to govern the access and usage of the Polytechnic Shiksha application an initiative of DTE (Directorate of Technical Education), Government of Rajasthan (India) and TTC & LRDC, Jodhpur.";
        String text3 = "TERMS OF SERVICE AND PRIVACY POLICY:";
        String text4 = "1.\tPlease read our Terms of Service so you understand what’s up with your use of Polytechnic Shiksha application. You agree to our Terms of Service (“Terms”) by installing, accessing, or using our apps, services, features, software, or website (together, “Services”).";
        String text5 = "2.\tPolytechnic Shiksha application (referred to as DTE, TTC & LRDC or We/Us) provides an online learning system to users around the world. Services are suitable for a person studying at Polytechnic Colleges in Rajasthan (India).";
        String text6 = "3.\tThe TTC & LRDC Portal/website and Polytechnic Shiksha application System allows the user to access all content free of charge. We do not ask users to make payments.";
        String text7 = "4.\tThe TTC & LRDC Portal/website and Polytechnic Shiksha application allows the user to use the services without signing up or registration.";
        String text8 = "5.\tYou must provide certain devices, software, and data connections to use our services, which we otherwise do not supply.";
        String text9 = "6.\tYou provide consent to downloading and installing updates to our services.";
        String text10 = "7.\tMaterial featured on this site or through app may be reproduced free of cost in any format or media without requiring specific permission. This is subject to the material being reproduced accurately and not being used in a derogatory manner or in a misleading context. Where the material is being published or issued to others, the source must be prominently acknowledged. However, the permission to reproduce this material does not extend to any other material on this site, which is explicitly identified as being the copyright of a third party. Authorization to reproduce such material must be obtained from the department / copyright holder concerned.";
        String text11 = "8.\tWe honor about your privacy. We do not collect information when we operate and provide our Services, including when you install, access, or use our Services. No cookies are set in user devices.";
        String text12 = "9.\tThe sole purpose of our services is to enhance knowledge of its users. Our services are not for commercial use.";
        String text13 = "INTELLECTUAL PROPERTY RIGHTS:";
        String text14 = "1.\tPolytechnic Shiksha app is designed, developed, maintained by TTC and LRDC, Jodhpur, Rajasthan (India). ";
        String text15 = "2.\tThis app is having all the rights to use content and logo, icon of TTC & LRDC, Jodhpur, Rajasthan (India).";
        String text16 = "3.\tIts content is developed by faculties of Polytechnic Colleges of Rajasthan(India) under Directorate of Technical Education (DTE), Government of Rajasthan (India). These institutions are governed by DTE and part of our organization.";
        String text17 = "4.https://hte.rajasthan.gov.in/college/ttcjodhpur/ Website And email ID ttc.jodhpur@rajasthan.gov.in  and google accounts ttc.jodhpur@gmail.com and app.lrdc@gmail.com belong to us. And the same can be verified.";
        String text18 = "5.\tWe do not infringe copyrights, trade mark knowingly or unknowingly of any other company.";
        String text19 = "DISCLAIMER:";
        String text20 = "1.\tThis Application is the intellectual property of the Department of Technical Education, Government of Rajasthan. All information posted is merely for educational and informational purposes.";
        String text21 = "2.\tTeachers Training Center and Learning Resource Development Center, Department of Technical Education, Government of Rajasthan (TTC & LRDC) hereby excludes any warranty, express or implied, as to the quality, accuracy, timeliness, completeness, performance, fitness for a particular purpose of the Mobile Application or any of its content.";
        String text22 = "3.\tTTC & LRDC will not be liable for any damages arising in contract, tort or otherwise from the use of or inability to use the Mobile Application, or any of its contents, or from any action taken (or refrained from being taken) as a result of using the Mobile Application or any such contents.";
        String text23 = "4.\tTTC & LRDC made best effort to secure this Mobile Application. In spite of that TTC & LRDC makes no warranty that the Mobile Application is free from infection by viruses or anything else which has contaminating or destructive properties.";


        tview1.setText(Html.fromHtml(text1));
        tview2.setText(Html.fromHtml(text2));
        tview3.setText(Html.fromHtml(text3));
        tview4.setText(Html.fromHtml(text4));
        tview5.setText(Html.fromHtml(text5));
        tview6.setText(Html.fromHtml(text6));
        tview7.setText(Html.fromHtml(text7));
        tview8.setText(Html.fromHtml(text8));
        tview9.setText(Html.fromHtml(text9));
        tview10.setText(Html.fromHtml(text10));
        tview11.setText(Html.fromHtml(text11));
        tview12.setText(Html.fromHtml(text12));
        tview13.setText(Html.fromHtml(text13));
        tview14.setText(Html.fromHtml(text14));
        tview15.setText(Html.fromHtml(text15));
        tview16.setText(Html.fromHtml(text16));
        tview17.setText(Html.fromHtml(text17));
        tview18.setText(Html.fromHtml(text18));
        tview19.setText(Html.fromHtml(text19));
        tview20.setText(Html.fromHtml(text20));
        tview21.setText(Html.fromHtml(text21));
        tview22.setText(Html.fromHtml(text22));
        tview23.setText(Html.fromHtml(text23));

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
            startActivity(new Intent(disclaimer.this, MainActivity.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(disclaimer.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(disclaimer.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(disclaimer.this,WebViewActivity.class);
            web.putExtra("url",url);
            web.putExtra("title",title);
            startActivity(web);
        }
        if (id == R.id.exit) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Closing Activity")
                    .setMessage("Are you sure you want to close this activity ?")
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
            startActivity(new Intent(disclaimer.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(disclaimer.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}