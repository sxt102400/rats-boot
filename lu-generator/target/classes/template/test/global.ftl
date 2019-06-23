<#-- 变量定义=================== -->
<#assign copyright="Copyright (C) 2013 rats">
<#assign author="Lu generator">
<#assign example= "com.rats.framework.common.data.persistence.GeneratedExample" >
<#assign pageable= "com.rats.framework.common.data.persistence.Page" >

<#-- 主键类型 -->
<#macro pkType><#list table.pkColumns as column>${column.fullJavaType}<#if column_has_next>,</#if></#list></#macro>
<#-- 主键字段 -->
<#macro pkField><#list table.pkColumns as column>${column.field}<#if column_has_next>,</#if></#list></#macro>
<#-- 主键类型和字段 -->
<#macro pkTypeAndField><#list table.pkColumns as column>${column.javaType} ${column.field}<#if column_has_next>,</#if></#list> </#macro>

<#macro domainType>< ${className} <#if table.pkCount==1 >,</#if>> </#macro>


