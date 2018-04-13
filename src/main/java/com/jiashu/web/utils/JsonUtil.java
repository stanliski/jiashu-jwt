package com.jiashu.web.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    public static Map<String, Object> strJson2Map(String json) throws IOException {
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }

//    private static List<Map<String, Object>> json2List(Object json) {
//        JSONArray jsonArr = (JSONArray) json;
//        List<Map<String, Object>> arrList = new ArrayList<>();
//        for (int i = 0; i < jsonArr.size(); ++i) {
//            arrList.add(strJson2Map(jsonArr.getString(i)));
//        }
//        return arrList;
//    }
}
