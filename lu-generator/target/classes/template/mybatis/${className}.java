package ${@tpl.entity.packageName};
<#include "global.ftl">
import com.rats.framework.common.base.BaseBean;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

/** ${copyright}
 *
 * ${table.className}: ${table.remark!}
 *
 * @author ${author!}
 * @since 1.0.0
 * @date ${now!}
 */
@Entity
@Table(name="${table.tableName}")
public class ${className} extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

<#-- 生成属性 -->
<@generateKeyColumns/>
<@generateNotKeyColumns/>
<#-- 构造方法 -->
<@generateConstructor/>
<#-- 生成get,set方法 -->
<@generateJavaSetterGetter/>
<#-- 生成联合主键 -->
<@generateCompKey/>
}

<#-- entity函数定义=================== -->
<#-- Filed字段 -->
<#macro generateKeyColumns>
<#if table.keyCount == 1 >
    /**
     *  ID: ${table.keyColumn.field}  ${table.keyColumn.remark!}
     */
    @Id
    @Column(name="${table.keyColumn.column}")
    private ${table.keyColumn.javaType} ${table.keyColumn.field};

</#if>
<#if table.keyCount != 1 >
<@propertyData table.compKey.columns />
</#if>
</#macro>

<#macro generateNotKeyColumns>
<#list table.notKeyColumns as column>
    /**
     * ${column.field} ${column.remark!}
     */
    @Column(name="${column.column}")
    private ${column.javaType} ${column.field};

</#list>
</#macro>
<#-- Constructor方法 -->
<#macro generateConstructor>
    public ${table.className}(){}

</#macro>

<#--============= generateJavaSetterGetter =============-->
<#macro generateJavaSetterGetter>
<@setterGetterData table.columns />
</#macro>
<#-- getter和setter方法 -->
<#macro generateCompKey>
<#if table.keyCount != 1 >
    public static class Key implements Serializable {

            <@propertyData2 table.compKey.columns />
            <@setterGetterData2  table.compKey.columns />
    }

</#if>
</#macro>


<#--============= property columns =============-->
<#macro propertyData columns>
<#list columns as column>
    /**
     *  Id: ${column.field}   ${column.remark!}
     */
    @Id
    @Column(name="${column.column}")
    private ${column.javaType} ${column.field};

</#list>
</#macro>
<#--============= property columns =============-->
<#macro propertyData2 columns>
<#list columns as column>
        private ${column.javaType} ${column.field};

</#list>
</#macro>
<#--============= setterGetter columns =============-->
<#macro setterGetterData columns>
<#list columns as column>
    public void set${column.field?cap_first}( ${column.javaType} ${column.field} ) {
        this.${column.field} = ${column.field};
    }

    public ${column.javaType} get${column.field?cap_first}() {
        return this.${column.field};
    }

</#list>
</#macro>
<#--============= setterGetter columns =============-->
<#macro setterGetterData2 columns>
<#list columns as column>
        public void set${column.field?cap_first}( ${column.javaType} ${column.field} ) {
            this.${column.field} = ${column.field};
        }

        public ${column.javaType} get${column.field?cap_first}() {
            return this.${column.field};
        }

</#list>
</#macro>


