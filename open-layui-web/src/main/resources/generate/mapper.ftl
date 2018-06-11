<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="{daoPackageName}.{daoName}">

	<sql id="where">
		<where>
{where}		
		</where>
	</sql>

	<select id="count" resultType="int">
		select count(1) from {table_name} t
		<include refid="where" />
	</select>

	<select id="list" resultType="{beanName}">
		select * from {table_name} t
		<include refid="where" />
		${params.orderBy}
		limit #{offset}, #{limit}
	</select>

	<update id="update">
		update {table_name} t
		<set>
{update_sets}
		</set>

		where t.id = #{id}
	</update>

</mapper>