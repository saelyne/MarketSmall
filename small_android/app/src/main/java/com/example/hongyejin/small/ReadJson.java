package com.example.hongyejin.small;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public class ReadJson {

    private void readJson() {
        JSONObject jsonObject = new JSONObject(result); //result를 인자로 넣어 jsonObject를 생성한다.

        JSONArray jsonArray = jsonObject.getJSONArray("dataSet"); //"dataSet"의 jsonObject들을 배열로 저장한다.


        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++) { //jsonObject에 담긴 두 개의 jsonObject를 jsonArray를 통해 하나씩 호출한다.
            jsonObject = jsonArray.getJSONObject(i);
            list.add(jsonObject.getInt("학번") + " " + jsonObject.getString("이름") + " " + jsonObject.getString("학과"));
        }
    }
}
