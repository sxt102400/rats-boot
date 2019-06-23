package ${@tpl.service.packageName};

<#include "global.ftl">
import ${basePackage}.BaseService;
import ${@tpl.entity.packageName}.${table.className};

/**
 *
 * @author ${author!}
 * @since 1.0.0
 * @date ${now!}
 */
public interface ${className}Service extends BaseService<${table.className},<@keyType/>> {


}

