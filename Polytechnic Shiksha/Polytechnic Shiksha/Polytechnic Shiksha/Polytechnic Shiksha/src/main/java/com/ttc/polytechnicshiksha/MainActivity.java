package com.ttc.polytechnicshiksha;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import static android.graphics.Color.GREEN;


public class MainActivity extends AppCompatActivity {
    public static String url;
    public static String title;
    private Button mElectBtn;
    private Button mLabBtn;
    private Button mMcqBtn;
    private Button mSolBtn;
    private Button mEnotesBtn;
    private Button loginButton;
    private TextView text_login;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mElectBtn = (Button) findViewById(R.id.electBtn);
        mLabBtn = (Button) findViewById(R.id.labBtn);
        mMcqBtn = (Button) findViewById(R.id.mcqBtn);
        mSolBtn = (Button) findViewById(R.id.solBtn);
        mEnotesBtn = (Button) findViewById(R.id.enoteBtn);
        loginButton = (Button) findViewById(R.id.login_button);
        text_login = (TextView) findViewById(R.id.clickable_login);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Polytechnic Shiksha");
        checkDownloadPermission();

        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,login.class));
            }
        });

        mLabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, lab_manuals.class));
            }
        });

        mElectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, electure.class));
            }
        });

        mMcqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, mcq.class));
            }
        });

        mEnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, workinprogress.class));
            }
        });

        mSolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, qpsolution.class));
            }
        });
    }


    private void checkDownloadPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(MainActivity.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
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
            //startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        }
        if (id == R.id.important_link) {
            startActivity(new Intent(MainActivity.this,imp_link.class));
            return true;
        }
        if (id == R.id.Syllabus) {
            startActivity(new Intent(MainActivity.this,syllabus.class));
            return true;
        }
        if (id == R.id.feedback_Suggestion) {
            url = "https://docs.google.com/forms/d/e/1FAIpQLSdH0e-9UScRXX7-VbkF4G-ZMOGSVOZdknnvDmw3256VsEQwTg/viewform?usp=sf_link";
            title = "Feedback & Suggestions";
            Intent web = new Intent(MainActivity.this,WebViewActivity.class);
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
            startActivity(new Intent(MainActivity.this,contact_us.class));
            return true;
        }
        if (id == R.id.legal) {
            startActivity(new Intent(MainActivity.this,disclaimer.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}