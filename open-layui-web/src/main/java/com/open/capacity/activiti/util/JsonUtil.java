package com.open.capacity.activiti.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-15 20:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
public class JsonUtil {

    //默认成功
    private boolean flag=true;
    private String msg;
    private JSONObject josnObj;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getJosnObj() {
        return josnObj;
    }

    public void setJosnObj(JSONObject josnObj) {
        this.josnObj = josnObj;
    }


    public JsonUtil() {
    }

    public JsonUtil(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    /**restful 返回*/
    public static JsonUtil error(String msg){
        return new JsonUtil(false,msg);
    }
    public  static JsonUtil sucess(String msg){
        return new JsonUtil(true,msg);
    }
}