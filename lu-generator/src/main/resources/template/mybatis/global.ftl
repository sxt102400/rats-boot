<#-- 变量定义=================== -->
<#assign copyright="Copyright (C) 2013 rats">
<#assign author="Lu generator">
<#assign example= "com.rats.framework.common.persistence.GeneratedExample" >
<#assign page= "com.rats.framework.common.page.Page" >
<#assign pageable= "com.rats.framework.common.page.Pageable" >
<#assign pageImpl= "com.rats.framework.common.page.PageImpl" >

<#-- 主键类型 -->
<#macro pkType><#list table.pkColumns as column>${column.fullJavaType}<#if column_has_next>,</#if></#list></#macro>
<#-- 主键字段 -->
<#macro pkField><#list table.pkColumns as column>${column.fieldName}<#if column_has_next>,</#if></#list></#macro>
<#-- 主键类型和字段 -->
<#macro pkTypeAndField><#list table.pkColumns as column>${column.javaType} ${column.fieldName}<#if column_has_next>,</#if></#list> </#macro>


