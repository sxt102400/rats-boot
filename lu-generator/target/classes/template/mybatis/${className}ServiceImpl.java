package ${@tpl.serviceImpl.packageName};

<#include "global.ftl">
import org.springframework.stereotype.Service;

import ${basePackage}.BaseServiceImpl;
import ${@tpl.entity.packageName}.${className};
import ${@tpl.service.packageName}.${className}Service;


/** ${copyright}
 *
 * ${className}ServiceImpl
 * Description: ${table.remark!}
 *
 * @version : v1.0
 * @author : ${author!}
 * @since : ${now!}
 */
@Service("${className?uncap_first}Service")
public class ${className}ServiceImpl extends BaseServiceImpl<${table.className},<@keyType/>> implements ${className}Service {


}



