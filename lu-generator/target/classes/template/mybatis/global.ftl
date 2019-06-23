<#-- 变量定义=================== -->
<#assign copyright="Copyright (C) 2013 rats">
<#assign author="Lu generator">
<#assign example= "com.rats.framework.common.data.Example" >
<#assign basePackage="com.rats.framework.common.base" >
<#assign page= "com.rats.framework.common.data.page.Page" >
<#assign pageImpl= "com.rats.framework.common.data.page.pageImpl" >
<#assign pageable= "com.rats.framework.common.data.page.Pagable" >

<#-- 主键类型 -->
<#macro keyType>
<#compress>
<#if table.keyCount == 1 >${table.keyColumn.javaType}</#if>
<#if table.keyCount != 1 >${table.compKey.javaType}</#if>
</#compress>
</#macro>


<#-- 主键类型,全名 -->
<#macro keyTypeFull>
<#compress>
<#if table.keyCount == 1 >${table.keyColumn.javaTypeFull}</#if>
<#if table.keyCount != 1 >${@tpl.entity.packageName}.${table.compKey.javaTypeFull}</#if>
</#compress>
</#macro>

<#-- 主键字段 -->
<#macro keyField>
<#compress>
<#if table.keyCount == 1 >${table.keyColumn.field}</#if>
<#if table.keyCount != 1 >${table.compKey.field}</#if>
</#compress>
</#macro>

<#-- 主键类型和字段 -->
<#macro keyTypeAndField>
<#t><#if table.keyCount == 1 >${table.keyColumn.javaType} ${table.keyColumn.field}</#if>
<#t><#if table.keyCount != 1 >${table.compKey.javaType} ${table.compKey.field}</#if>
</#macro>


<#--<#if table.pkCount != 1 >
    <#list table.pkColumns as column>${column.javaType} ${column.field}<#if column_has_next>,</#if></#list>
</#if>-->


