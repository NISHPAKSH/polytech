package com.ttc.polytechnicshiksha;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class login extends AppCompatActivity {


    String username ;
    String College_Name;
    String password ;
    String status1 = null;
    Button LoginBtn;
    EditText edit_UserName,edit_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LoginBtn = (Button) findViewById(R.id.login_button);
        edit_UserName = (EditText) findViewById(R.id.username);
        edit_Password = (EditText) findViewById(R.id.password);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = edit_UserName.getText().toString();
                password = edit_Password.getText().toString();
                //Toast.makeText(getBaseContext(), "Username:\t"+username + "\nPassword:\t"+password, Toast.LENGTH_SHORT).show();
                enviarPost(true);
            }
        });

    }

    private void enviarPost(boolean modo) {
        String URL="http://34.238.231.153/admin/User_api/checkusr";

        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
        requestParams.put("username", username);
        requestParams.put("password", password);
        requestParams.put("token_key", "AaShTaK@2020@WaterSupplY");

        clientSendPost.post(URL, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) { // I think success means always code 200
                    String res = null;
                    try
                    {
                        res = new String(responseBody, "UTF-8");
                        Log.e("----->",res);
                        JSONObject jsonObject=new JSONObject(res);
                       // JSONArray jsonArray=jsonObject.getJSONArray("Data");
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();
                    String response = null;
                    response = new String(res);
                    String v1="result\":\"";
                    String v2 ="Name\":\"";
                    String[] arrOfStr=response.split(v1,2);
                    String[] arrOfStr1=response.split(v2,2);
                    String[] result = arrOfStr[1].split("\"");
                    status1 = result[0];

                    if(status1.equals("True"))
                    {
                        String[] result1 = arrOfStr1[1].split("\"");
                        College_Name = result1[0];
                        Intent intent1 = new Intent(login.this,Dashboard_College.class);
                        intent1.putExtra("College_Name",College_Name);
                        startActivity(intent1);
                    }
                    else if(status1.equals("False"))
                    {
                        Toast.makeText(getBaseContext(), "Wrong Credential", Toast.LENGTH_SHORT)
                                .show();
                    }

                }
                Log.i("app", responseBody.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getBaseContext(), "Error getting data from server", Toast.LENGTH_SHORT)
                        .show();

                Log.e("app", "User could not be created");
            }
        });
    }
}