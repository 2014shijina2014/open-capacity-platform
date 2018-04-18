package com.open.capacity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.open.capacity.srenewSer.dao.AcceptTempDao;

@SpringBootApplication
public class ServiceyApp {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ServiceyApp.class, args);

		AcceptTempDao accept = (AcceptTempDao) context.getBean(AcceptTempDao.class);

		Map<String, Object> param = new HashMap<>();

		param.put("eparchy_code", "750");
		param.put("service_id", "079107929644");
		param.put("service_kind", "11");
		Map info = accept.getBulkInfo(param);

		Date date = (Date) info.get("END_DATE");

		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalDate localDate= localDateTime.toLocalDate();
		
		System.out.println(date);
		System.out.println(localDate);
		
		LocalDate af = localDate.plusMonths(Long.valueOf(String.valueOf(info.get("EFFECT_VALUES")))) ;

		System.out.println("1111111111111111111111=" + af);

		context.close();
	}
}
