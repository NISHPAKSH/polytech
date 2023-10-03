package com.ttc.polytechnicshiksha;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity2 extends AppCompatActivity {
    String item;
    List<Hero> heroList;
    List<String> categories = new ArrayList<String>();
    List<String> branchlist = new ArrayList<>();
    EditText etSearch;
    Button btnSearch;
    ListView lvVideo;
    ArrayList<VideoDetails> videoDetailsArrayList;
    MyListAdapter customListAdapter;

    String searchName;
    String course ;
    String year ;
    String branch ;
    String subcode ;
    String unit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main2);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            lvVideo=(ListView)findViewById(R.id.videoList);
            heroList = new ArrayList<>();
            Bundle bundle = getIntent().getExtras();
            course = bundle.getString("course");
            year = bundle.getString("year");
            branch = bundle.getString("branch");
            subcode = bundle.getString("subcode");
            unit = bundle.getString("unit");
            Log.e("----->",unit);

            customListAdapter = new MyListAdapter(this, R.layout.my_custom_list, heroList);

            //attaching firstAdapter to the listview
            lvVideo.setAdapter(customListAdapter);
            customListAdapter.notifyDataSetChanged();
            enviarPost(true);
    }


    private void enviarPost(boolean modo) {
        String URL="http://question.undoo.in/admin/User_api/tcc";

        AsyncHttpClient clientSendPost = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        String mode = !modo ? "GET" : "POST";
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("a");
        itemsList.add("b");
        requestParams.put("branch", branch);
        requestParams.put("subcode", subcode);
        requestParams.put("token_key", "AaShTaK@2020@WaterSupplY");
        requestParams.put("unit", unit);

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
                        JSONArray jsonArray=jsonObject.getJSONArray("Data");
                        for(int i=0;i<jsonArray.length();i++){
                            ArrayList<String> jsonVideoId=new ArrayList<>();
                            ArrayList<String> jsonTeacherName=new ArrayList<>();
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                               for(int j=0;j<30;j++)
                               {
                                   jsonVideoId.add(jsonObject1.getString("ItemId"+j));
                               }


                                String Topic=jsonObject1.getString("Topic");
                                String Unit=jsonObject1.getString("Unit");

                                for(int p=0;p<30;p++)
                                {
                                    jsonTeacherName.add(jsonObject1.getString("TeacherName"+p));
                                }



                               for(int k=0;k<30;k++) {
                                   if(!jsonVideoId.get(k).isEmpty()) {
                                       heroList.add(new Hero(Topic, jsonVideoId.get(k), Unit,jsonTeacherName.get(k)));
                                   }
                               }


                        }


                        lvVideo.setAdapter(customListAdapter);
                        ProgressBar p1=findViewById(R.id.p1);
                        p1.setVisibility(View.INVISIBLE);
                        customListAdapter.notifyDataSetChanged();
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
            /*
                    Toast.makeText(getBaseContext(), "success data from server", Toast.LENGTH_SHORT)
                            .show();

            */
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