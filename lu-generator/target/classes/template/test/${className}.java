package ${@tpl_entity.packageName};
<#include "global.ftl">
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


/** ${copyright}
 *
 * ${table.className}
 * Description: ${table.remark!}
 *
 * @version : v1.0
 * @author : ${author!}
 * @since : ${now!}
 */
@Entity
@Table(name="${table.tableName}")
public class ${className} implements Serializable {
    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

<#-- 生成属性 -->
<@generatePKColumns/>
<@generateNotPKColumns/>
<#-- 构造方法 -->
<@generateConstructor/>
<#-- 生成get,set方法 -->
<@generateJavaSetterGetter/>

}

<#-- entity函数定义=================== -->
<#-- Filed字段 -->
<#macro generatePKColumns>
<#list table.pkColumns as column>
    /**
     *  ${column.field}  Id, ${column.remark!}
     */
    @Id
    @Column("${column.column}")
    private ${column.javaType} ${column.field};

</#list>
</#macro>
<#macro generateColumns>
<#list table.notPkColumns as column>
    /**
     * ${column.field} ${column.remark!}
     */
    @Column("${column.column}")
    private ${column.javaType} ${column.field};

</#list>
</#macro>
<#-- Constructor方法 -->
<#macro generateConstructor>
    public ${table.className}(){}

</#macro>
<#-- getter和setter方法 -->
<#macro generateJavaSetterGetter>
<#list table.columns as column>
    public void set${column.field?cap_first}( ${column.javaType} ${column.field} ) {
        this.${column.field} = ${column.field};
    }

    public ${column.javaType} get${column.field?cap_first}() {
        return this.${column.field};
    }

</#list>
</#macro>