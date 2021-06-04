<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${namespace}">
    <resultMap id="BaseResultMap" type="com.example.center.entity.UPageContent">
        <result property="pageContentId" column="page_content_id" jdbcType="INTEGER"/>
    </resultMap>

    <resultMap id="BaseResultMapAssociation" type="com.example.center.entity.UPageContent">
        <result property="pageContentTop" column="page_content_top" jdbcType="INTEGER"/>
        <association property="pageUser" javaType="com.example.center.entity.UUser">
            <result property="userId" column="user_id" jdbcType="INTEGER"/>
        </association>
    </resultMap>

    <resultMap id="BaseResultMapAssociation" type="com.example.center.entity.UPageContent">
        <result property="pageContentTop" column="page_content_top" jdbcType="INTEGER"/>
        <association property="pageUser" javaType="com.example.center.entity.UUser">
            <result property="userId" column="user_id" jdbcType="INTEGER"/>
        </association>
    </resultMap>


    <#list dataBaseSqls as list>
        <#if list.type?index_of("SELECT") != -1>
            <select id="${list.methodName}" resultMap="${resultType}">
                ${list.sql}
            </select>
        </#if>
        <#if list.type?index_of("UPDATE") != -1>
            <update id="${list.methodName}">
                ${list.sql}
            </update>
        </#if>
        <#if list.type?index_of("INSERT") != -1>
            <insert id="${list.methodName}">
                ${list.sql}
            </insert>
        </#if>
        <#if list.type?index_of("DELETE") != -1>
            <delete id="${list.methodName}">
                ${list.sql}
            </delete>
        </#if>
    </#list>

</mapper>