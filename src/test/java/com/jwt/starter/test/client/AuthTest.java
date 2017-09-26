package com.jwt.starter.test.client;

import com.alibaba.fastjson.JSONObject;
import com.jwt.starter.test.utils.HttpUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthTest {

    private static final String ipaddress = "http://127.0.0.1:8080/";

    HttpUtils.ParamMap paramMap = new HttpUtils.ParamMap();

    @Test
    public void test() throws IOException {
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("content-type", "application/json"));
        paramMap.putParam("username", "zzqfsy");
        paramMap.putParam("password", "123456");
        String result=HttpUtils.post(ipaddress+"auth", headers, JSONObject.toJSONString(paramMap));
        System.out.println(result);
    }
}
