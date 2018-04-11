package com.open.capacity.security.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.utils.ExcelUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "excel下载")
@RestController
@RequestMapping("/excels")
public class ExcelController {
	
	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@ApiOperation("校验sql，并返回sql返回的数量")
	@PostMapping("/sql-count")
	public Integer checkSql(String sql) {
		log.info(sql);
		sql = getAndCheckSql(sql);

		Integer count = 0;
		try {
			count = jdbcTemplate.queryForObject("select count(1) from (" + sql + ") t", Integer.class);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return count;
	}

	private String getAndCheckSql(String sql) {
		sql = sql.trim().toLowerCase();
		if (sql.endsWith(";") || sql.endsWith("；")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		if (!sql.startsWith("select")) {
			throw new IllegalArgumentException("仅支持select语句");
		}
		return sql;
	}

	@LogAnnotation
	@ApiOperation("根据sql导出excel")
	@PostMapping
	@PreAuthorize("hasAuthority('excel:down')")
	public void downloadExcel(String sql, String fileName, HttpServletResponse response) {
		sql = getAndCheckSql(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		if (!CollectionUtils.isEmpty(list)) {
			Map<String, Object> map = list.get(0);

			String[] headers = new String[map.size()];
			int i = 0;
			for (String key : map.keySet()) {
				headers[i++] = key;
			}

			List<Object[]> datas = new ArrayList<>(list.size());
			for (Map<String, Object> m : list) {
				Object[] objects = new Object[headers.length];
				for (int j = 0; j < headers.length; j++) {
					objects[j] = m.get(headers[j]);
				}

				datas.add(objects);
			}

			ExcelUtil.excelExport(
					fileName == null || fileName.trim().length() <= 0 ? DigestUtils.md5Hex(sql) : fileName, headers,
					datas, response);
		}
	}

	@LogAnnotation
	@ApiOperation("根据sql在页面显示结果")
	@PostMapping("/show-datas")
	@PreAuthorize("hasAuthority('excel:show:datas')")
	public List<Object[]> showData(String sql) {
		sql = getAndCheckSql(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		if (!CollectionUtils.isEmpty(list)) {
			Map<String, Object> map = list.get(0);

			String[] headers = new String[map.size()];
			int i = 0;
			for (String key : map.keySet()) {
				headers[i++] = key;
			}

			List<Object[]> datas = new ArrayList<>(list.size());
			datas.add(headers);
			for (Map<String, Object> m : list) {
				Object[] objects = new Object[headers.length];
				for (int j = 0; j < headers.length; j++) {
					objects[j] = m.get(headers[j]);
				}

				datas.add(objects);
			}

			return datas;
		}

		return Collections.emptyList();
	}

}
