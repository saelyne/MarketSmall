package com.example.hongyejin.serverconnection;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView) findViewById(R.id.test);

        /*String url = "http://172.16.0.59:3000/store/getStore";

        // AsyncTask를 통해 HttpURLConnection 수행.
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();*/

        sendRequest();


    }


    private void sendRequest() {
        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        Call<List<StoreData>> call = gitHubService.getStoreDataList();
        call.enqueue(new Callback<List<StoreData>>() {

            @Override
            public void onResponse(Call<List<StoreData>> call, Response<List<StoreData>> response) {
                if (response.isSuccessful()) {
                    List<StoreData> storeDataList = response.body();
                    test.setText(storeDataList.toString());

                } else {
                    Log.e("ERROR", "Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<StoreData>> call, Throwable t) {
                Log.e("ERROR", "onFailure", t);
            }
        });

    }
//
//   private class NetworkCall extends AsyncTask<Call, Void, String> {
//
//
//        @Override
//        protected List<StoreData> doInBackground(Call... params) {
//            try {
//                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
//                Call<List<StoreData>> response = gitHubService.getStoreDataList();
//                return
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            final TextView textView = (TextView) findViewById(R.id.test);
//            textView.setText(result);
//        }
//    }


/*    public class NetworkTask extends AsyncTask<Void, Void, String> {

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
            //ReadJson read = new ReadJson();
            test.setText(s);
            Log.d("abc", s);
        }
    }*/
}



