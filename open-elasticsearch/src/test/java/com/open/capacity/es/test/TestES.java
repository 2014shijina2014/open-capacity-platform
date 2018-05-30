package com.open.capacity.es.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
//import com.open.capacity.es.ESApplication;
import com.open.capacity.es.utils.EsPage;
import com.open.capacity.es.utils.elasticsearchManagerUtils;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ESApplication.class)
public class TestES {

	/**
	 * 测试创建索引
	 */
	@Test
	public void TestcreateIndexTest() {
		elasticsearchManagerUtils.createIndex("open_index");
		elasticsearchManagerUtils.createIndex("capatity_index");
	}

	/**
	 * 测试删除索引
	 */
	@Test
	public void TestdeleteIndexTest() {
		elasticsearchManagerUtils.deleteIndex("capatity_index");
	}

	/**
	 * 测试判断索引是否存在
	 */
	@Test
	public void TestisIndexExistTest() {
		elasticsearchManagerUtils.isIndexExist("capatity_index");
	}

	/**
	 * 测试数据添加
	 */
	@Test
	public void TestaddDataTest() {
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "张三" + i);
			map.put("age", i);
			map.put("processTime", new Date());
			elasticsearchManagerUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map)), "open_index",
					"add_test", "id=" + i);
		}
	}

	
	/**
	 * 测试通过ID删除数据
	 */
	@Test
	public void deleteDataByIdTest() {
		elasticsearchManagerUtils.deleteDataById("open_index", "add_test", "id=1");
	}
	

	/**
	 * 测试通过ID更新数据
	 */
	@Test
	public void updateDataByIdTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "李四");
		map.put("age", 99);
		map.put("processTime", new Date());
		elasticsearchManagerUtils.updateDataById(JSONObject.parseObject(JSONObject.toJSONString(map)), "open_index", "add_test", "id=4");
	}
	
	/**
	 * 测试通过ID获取数据
	 */
	@Test
	public void searchDataByIdTest() {
		Map<String, Object> map = elasticsearchManagerUtils.searchDataById("open_index", "add_test", "id=4", null);
		System.out.println(JSONObject.toJSONString(map));
	}
	
	/**
	 * 测试分词查询
	 */
	@Test
	public void searchListData() {
		List<Map<String, Object>> list = elasticsearchManagerUtils.searchListData("open_index", "add_test", 1509959382607l, 1509959383865l, 0, "", "", false, "", "name=张三");
		for (Map<String, Object> item : list) {
			System.out.println(JSONObject.toJSONString(item));
		}
	}
	
	/**
	 * 测试分词查询,并分页
	 */
	@Test
	public void searchDataPage() {
		EsPage esPage = elasticsearchManagerUtils.searchDataPage("open_index", "add_test", 2, 3, 1509943495299l, 1509943497954l, "", "processTime", false, "about", "name=张三");
		for (Map<String, Object> item : esPage.getRecordList()) {
			System.out.println(JSONObject.toJSONString(item));
		}
	}
}
