package com.open.capacity.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dto.BeanField;
import com.open.capacity.security.dto.GenerateDetail;
import com.open.capacity.security.dto.GenerateInput;
import com.open.capacity.security.service.GenerateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 代码生成接口
 * 
 * @author owen 624191343@qq.com
 *
 */
@Api(tags = "代码生成")
@RestController
@RequestMapping("/generate")
public class GenerateController {

	@Autowired
	private GenerateService generateService;

	@ApiOperation("根据表名显示表信息")
	@GetMapping(params = { "tableName" })
	@PreAuthorize("hasAuthority('generate:edit')")
	public GenerateDetail generateByTableName(String tableName) {
		GenerateDetail detail = new GenerateDetail();
		detail.setBeanName(generateService.upperFirstChar(tableName));
		List<BeanField> fields = generateService.listBeanField(tableName);
		detail.setFields(fields);

		return detail;
	}

	@LogAnnotation
	@ApiOperation("生成代码")
	@PostMapping
	@PreAuthorize("hasAuthority('generate:edit')")
	public void save(@RequestBody GenerateInput input) {
		generateService.saveCode(input);
	}

}
