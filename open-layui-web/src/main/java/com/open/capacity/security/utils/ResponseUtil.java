package com.open.capacity.security.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 返回值工具类
 */
public class ResponseUtil {

    public static void responseJson(HttpServletResponse response, int status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(status);

            response.getWriter().write(JSONObject.toJSONString(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
