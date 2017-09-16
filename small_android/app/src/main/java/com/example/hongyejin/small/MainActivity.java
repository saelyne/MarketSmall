package com.example.hongyejin.small;

import android.content.ContentValues;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView deliverView;
    private TextView userName, address, phoneNum;
    private CheckBox isDelivered;
    private ImageButton goDelivered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deliverView= (RecyclerView)findViewById(R.id.deliver_list);
        userName = (TextView) findViewById(R.id.customer_name);
        address = (TextView) findViewById(R.id.customer_address);
        phoneNum = (TextView) findViewById(R.id.customer_number);
        isDelivered = (CheckBox) findViewById(R.id.deliver_checkBox);
        ArrayList<DeliverData> deliverDatas = new ArrayList<>();
                deliverView.setLayoutManager(new LinearLayoutManager(this));
                deliverView.setAdapter(new DeliverAdapter(this,deliverDatas));
                goDelivered = (ImageButton)findViewById(R.id.goDelivered);
                goDelivered.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,isDeliveredActivity.class);
                intent.putExtra("index",);
                startActivity(intent);
            }
        });
        String url = "http://       .cafe24.com/LoadPat        ";

        // AsyncTask를 통해 HttpURLConnection 수행.
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();

        }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            ReadJson readJson = new ReadJson();
            readJson.readJson(s);
        }
    }
    }

