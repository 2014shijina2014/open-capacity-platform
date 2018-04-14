package com.open.capacity.security.utils;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.open.capacity.security.dto.GenerateInput;

public class TemplateUtil {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	public static String getTemplete(String fileName) {
		return FileUtil.getText(TemplateUtil.class.getClassLoader().getResourceAsStream("generate/" + fileName));
	}

	public static void saveJava(GenerateInput input) {
		String path = input.getPath();
		String beanPackageName = input.getBeanPackageName();
		String beanName = input.getBeanName();
		List<String> beanFieldName = input.getBeanFieldName();
		List<String> beanFieldType = input.getBeanFieldType();
		List<String> beanFieldValue = input.getBeanFieldValue();

		String text = getTemplete("java.txt");
		text = text.replace("{beanPackageName}", beanPackageName).replace("{beanName}", beanName);

		String imports = "";
		if (beanFieldType.contains(BigDecimal.class.getSimpleName())) {
			imports += "import " + BigDecimal.class.getName() + ";\n";
		}
		if (beanFieldType.contains(Date.class.getSimpleName())) {
			imports += "import " + Date.class.getName() + ";";
		}

		text = text.replace("{import}", imports);
		String filelds = getFields(beanFieldName, beanFieldType, beanFieldValue);
		text = text.replace("{filelds}", filelds);
		text = text.replace("{getset}", getset(beanFieldName, beanFieldType));

		FileUtil.saveTextFile(text, path + File.separator + getPackagePath(beanPackageName) + beanName + ".java");
		log.debug("生成java model：{}模板", beanName);
	}

	private static String getFields(List<String> beanFieldName, List<String> beanFieldType,
			List<String> beanFieldValue) {
		StringBuffer buffer = new StringBuffer();
		int size = beanFieldName.size();
		for (int i = 0; i < size; i++) {
			String name = beanFieldName.get(i);
			if ("id".equals(name) || "createTime".equals(name) || "updateTime".equals(name)) {
				continue;
			}
			String type = beanFieldType.get(i);
			buffer.append("\tprivate ").append(type).append(" ").append(name);
			// 默认值
//			String value = beanFieldValue.get(i);
//			if (!StringUtils.isEmpty(value)) {
//				buffer.append(" = ");
//				if (type.equals(String.class.getSimpleName())) {
//					value = "\"" + value + "\"";
//				} else if (type.equals(Double.class.getSimpleName())) {
//					value = value + "D";
//				} else if (type.equals(Float.class.getSimpleName())) {
//					value = value + "F";
//				} else if (type.equals(BigDecimal.class.getSimpleName())) {
//					value = "new BigDecimal(" + value + ")";
//				}
//
//				buffer.append(value);
//			}
			buffer.append(";\n");
		}

		return buffer.toString();
	}

	private static String getset(List<String> beanFieldName, List<String> beanFieldType) {
		StringBuffer buffer = new StringBuffer();
		int size = beanFieldName.size();
		for (int i = 0; i < size; i++) {
			String name = beanFieldName.get(i);
			if ("id".equals(name) || "createTime".equals(name) || "updateTime".equals(name)) {
				continue;
			}

			String type = beanFieldType.get(i);
			buffer.append("\tpublic ").append(type).append(" get")
					.append(StringUtils.substring(name, 0, 1).toUpperCase() + name.substring(1, name.length()))
					.append("() {\n");
			buffer.append("\t\treturn ").append(name).append(";\n");
			buffer.append("\t}\n");
			buffer.append("\tpublic ").append(type).append(" set")
					.append(StringUtils.substring(name, 0, 1).toUpperCase() + name.substring(1, name.length()))
					.append("() {\n");
			buffer.append("\t\treturn ").append(name).append(";\n");
			buffer.append("\t}\n");
		}

		return buffer.toString();
	}

	public static void saveJavaDao(GenerateInput input) {
		String path = input.getPath();
		String tableName = input.getTableName();
		String beanPackageName = input.getBeanPackageName();
		String beanName = input.getBeanName();
		String daoPackageName = input.getDaoPackageName();
		String daoName = input.getDaoName();

		String text = getTemplete("dao.txt");
		text = text.replace("{daoPackageName}", daoPackageName);
		text = text.replace("{beanPackageName}", beanPackageName);
		text = text.replace("{daoName}", daoName);
		text = text.replace("{table_name}", tableName);
		text = text.replace("{beanName}", beanName);
		text = text.replace("{beanParamName}", lowerFirstChar(beanName));

		String insertColumns = getInsertColumns(input.getColumnNames());
		text = text.replace("{insert_columns}", insertColumns);
		String insertValues = getInsertValues(input.getColumnNames(), input.getBeanFieldName());
		text = text.replace("{insert_values}", insertValues);
		FileUtil.saveTextFile(text, path + File.separator + getPackagePath(daoPackageName) + daoName + ".java");
		log.debug("生成java dao：{}模板", beanName);

		text = getTemplete("mapper.xml");
		text = text.replace("{daoPackageName}", daoPackageName);
		text = text.replace("{daoName}", daoName);
		text = text.replace("{table_name}", tableName);
		text = text.replace("{beanName}", beanName);
		String sets = getUpdateSets(input.getColumnNames(), input.getBeanFieldName());
		text = text.replace("{update_sets}", sets);
		String where = getWhere(input.getColumnNames(), input.getBeanFieldName());
		text = text.replace("{where}", where);
		FileUtil.saveTextFile(text, path + File.separator + beanName + "Mapper.xml");
	}

	private static String getInsertValues(List<String> columnNames, List<String> beanFieldName) {
		StringBuffer buffer = new StringBuffer();
		int size = columnNames.size();
		for (int i = 0; i < size; i++) {
			String column = columnNames.get(i);
			if (!"id".equals(column)) {
				buffer.append("#{").append(beanFieldName.get(i)).append("}, ");
			}
		}

		String sets = StringUtils.substringBeforeLast(buffer.toString(), ",");
		return sets;
	}

	private static String getInsertColumns(List<String> columnNames) {
		StringBuffer buffer = new StringBuffer();
		int size = columnNames.size();
		for (int i = 0; i < size; i++) {
			String column = columnNames.get(i);
			if (!"id".equals(column)) {
				buffer.append(column).append(", ");
			}
		}

		String insertColumns = StringUtils.substringBeforeLast(buffer.toString(), ",");
		return insertColumns;
	}

	private static String getUpdateSets(List<String> columnNames, List<String> beanFieldName) {
		StringBuffer buffer = new StringBuffer();
		int size = columnNames.size();
		for (int i = 0; i < size; i++) {
			String column = columnNames.get(i);
			if (!"id".equals(column)) {
				buffer.append("\t\t\t<if test=\"" + column + " != null\">\n");
				buffer.append("\t\t\t\t" + column).append(" = ").append("#{").append(beanFieldName.get(i))
						.append("}, \n");
				buffer.append("\t\t\t</if>\n");
			}
		}

		return buffer.toString();
	}

	private static String getWhere(List<String> columnNames, List<String> beanFieldName) {
		StringBuffer buffer = new StringBuffer();
		int size = columnNames.size();
		for (int i = 0; i < size; i++) {
			String column = columnNames.get(i);
			buffer.append("\t\t\t<if test=\"params." + column + " != null and params." + column + " != ''\">\n");
			buffer.append("\t\t\t\tand " + column).append(" = ").append("#{params.").append(beanFieldName.get(i))
					.append("} \n");
			buffer.append("\t\t\t</if>\n");
		}

		return buffer.toString();
	}

	/**
	 * 变量名
	 * 
	 * @param beanName
	 * @return
	 */
	public static String lowerFirstChar(String beanName) {
		String name = StrUtil.str2hump(beanName);
		String firstChar = name.substring(0, 1);
		name = name.replaceFirst(firstChar, firstChar.toLowerCase());

		return name;
	}

	private static String getPackagePath(String packageName) {
		String packagePath = packageName.replace(".", "/");
		if (!packagePath.endsWith("/")) {
			packagePath = packagePath + "/";
		}

		return packagePath;
	}

	public static void saveController(GenerateInput input) {
		String path = input.getPath();
		String beanPackageName = input.getBeanPackageName();
		String beanName = input.getBeanName();
		String daoPackageName = input.getDaoPackageName();
		String daoName = input.getDaoName();

		String text = getTemplete("controller.txt");
		text = text.replace("{daoPackageName}", daoPackageName);
		text = text.replace("{beanPackageName}", beanPackageName);
		text = text.replace("{daoName}", daoName);
		text = text.replace("{daoParamName}", lowerFirstChar(daoName));
		text = text.replace("{beanName}", beanName);
		text = text.replace("{beanParamName}", lowerFirstChar(beanName));
		text = text.replace("{controllerPkgName}", input.getControllerPkgName());
		text = text.replace("{controllerName}", input.getControllerName());

		FileUtil.saveTextFile(text, path + File.separator + getPackagePath(input.getControllerPkgName())
				+ input.getControllerName() + ".java");
		log.debug("生成controller：{}模板", beanName);
	}

	public static void saveHtmlList(GenerateInput input) {
		String path = input.getPath();
		String beanName = input.getBeanName();
		String beanParamName = lowerFirstChar(beanName);

		String text = getTemplete("htmlList.txt");
		text = text.replace("{beanParamName}", beanParamName);
		text = text.replace("{beanName}", beanName);
		List<String> beanFieldNames = input.getBeanFieldName();
		text = text.replace("{columnsDatas}", getHtmlColumnsDatas(beanFieldNames));
		text = text.replace("{ths}", getHtmlThs(beanFieldNames));

		FileUtil.saveTextFile(text, path + File.separator + beanParamName + "List.html");
		log.debug("生成查询页面：{}模板", beanName);

		text = getTemplete("htmlAdd.txt");
		text = text.replace("{beanParamName}", beanParamName);
		text = text.replace("{addDivs}", getAddDivs(beanFieldNames));
		FileUtil.saveTextFile(text, path + File.separator + "add" + beanName + ".html");
		log.debug("生成添加页面：{}模板", beanName);

		text = getTemplete("htmlUpdate.txt");
		text = text.replace("{beanParamName}", beanParamName);
		text = text.replace("{addDivs}", getAddDivs(beanFieldNames));
		text = text.replace("{initData}", getInitData(beanFieldNames));
		FileUtil.saveTextFile(text, path + File.separator + "update" + beanName + ".html");
		log.debug("生成修改页面：{}模板", beanName);
	}

	private static CharSequence getInitData(List<String> beanFieldNames) {
		StringBuilder builder = new StringBuilder();
		beanFieldNames.forEach(b -> {
			builder.append("\t\t\t\t\t\t$('#" + b + "').val(data." + b + ");\n");
		});

		return builder.toString();
	}

	private static String getAddDivs(List<String> beanFieldNames) {
		StringBuilder builder = new StringBuilder();
		beanFieldNames.forEach(b -> {
			if (!"id".equals(b) && !"createTime".equals(b) && !"updateTime".equals(b)) {
				builder.append("\t\t\t<div class='form-group'>\n");
				builder.append("\t\t\t\t<label class='col-md-2 control-label'>" + b + "</label>\n");
				builder.append("\t\t\t\t<div class='col-md-10'>\n");
				builder.append("\t\t\t\t\t<input class='form-control' placeholder='" + b + "' type='text' name='" + b
						+ "' id='" + b + "' data-bv-notempty='true' data-bv-notempty-message='" + b + " 不能为空'>\n");
				builder.append("\t\t\t\t</div>\n");
				builder.append("\t\t\t</div>\n");
			}
		});
		return builder.toString();
	}

	private static String getHtmlThs(List<String> beanFieldNames) {
		StringBuilder builder = new StringBuilder();
		beanFieldNames.forEach(b -> {
			builder.append("\t\t\t\t\t\t\t\t\t<th>{beanFieldName}</th>\n".replace("{beanFieldName}", b));
		});
		return builder.toString();
	}

	private static String getHtmlColumnsDatas(List<String> beanFieldNames) {
		StringBuilder builder = new StringBuilder();
		beanFieldNames.forEach(b -> {
			builder.append("\t\t\t\t{\"data\" : \"{beanFieldName}\", \"defaultContent\" : \"\"},\n"
					.replace("{beanFieldName}", b));
		});

		builder.append("");
		return builder.toString();
	}
	
}
