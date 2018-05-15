package com.open.capacity.activiti.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-15 19:23]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
public class ResultType implements Serializable {
    /**状态*/
    public int code=0;
    /**状态信息*/
    public String msg="";
    /**数据总数*/
    public long count;

    public List<?> data;

    public ResultType() {
    }

    public ResultType(long count, List<?> data) {
        this.count = count;
        this.data = data;
    }

    /**
     * 动态添加属性 map 用法可以参考 activiti 模块中 com.len.JsonTest 测试类中用法
     * @param count
     * @param data
     * @param map
     * @param node 绑定节点字符串 这样可以更加灵活
     * @return
     */
    public static String jsonStrng(long count, List<?> data, Map<String, Map<String,Object>> map, String node){
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(data));
        JSONObject object=new JSONObject();
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonData = (JSONObject) jsonArray.get(i);
            jsonData.putAll(map.get(jsonData.get(node)));
        }
        object.put("count",count);
        object.put("data",jsonArray);
        object.put("code",0);
        object.put("msg","");
        return object.toJSONString();
    }
}
