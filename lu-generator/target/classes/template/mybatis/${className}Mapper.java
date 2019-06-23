package ${@tpl.mapper.packageName};

<#include "global.ftl">
import ${basePackage}.BaseMapper;
import ${@tpl.entity.packageName}.${table.className};


/** ${copyright}
 *
 * ${table.className}Mapper
 *
 * @author ${author!}
 * @since 1.0.0
 * @date ${now!}
 */
public interface ${table.className}Mapper extends BaseMapper<${table.className},<@keyType/>>{

}