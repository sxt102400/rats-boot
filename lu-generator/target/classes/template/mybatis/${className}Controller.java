package ${ @tpl.controller.packageName};

<#include "global.ftl">
import com.rats.framework.common.data.Example;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.PageHelper;
import com.rats.framework.common.response.ResponseBean;
import com.rats.framework.common.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${@tpl.entity.packageName}.${className};
import ${@tpl.service.packageName}.${className}Service;
import ${basePackage}.BaseController;

/** ${copyright}
 *
 * ${className}Controller  ${table.remark!}
 *
 * @author ${author!}
 * @since 1.0.0
 * @date ${now!}
 */

@RestController
public class ${className}Controller extends BaseController {

    @Autowired
    private ${className}Service ${className?uncap_first}Service;

    /**
     * 查询一条数据
     *
     * @param <@keyField/>
     * @return
     */
    @GetMapping("/${className?uncap_first}/:<@keyField/>")
    public ResponseBean get(@PathVariable <@keyTypeAndField/>) {
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.findOneById(<@keyField/>).get();
        return ResponseFactory.getSuccessResponse(${className?uncap_first});
    }

    /**
     * ajax分页查询，request中传递条件参数page,pageSize
     *
     * @param ${className?uncap_first}
     * @return
     */
    @GetMapping( "/${className?uncap_first}/page")
    public ResponseBean page(${className} ${className?uncap_first}) {
        Page page = ${className?uncap_first}Service.findAll(Example.of(${className?uncap_first}),  PageHelper.getPage());
        return ResponseFactory.getSuccessResponse(page);
    }

    /**
     * 保存
     *
     * @param ${className?uncap_first}
     * @return
     */
    @PostMapping("/${className?uncap_first}")
    public ResponseBean add(${className} ${className?uncap_first}) {
        ${className?uncap_first}Service.save(${className?uncap_first});
        return ResponseFactory.getDefaultSuccessResponse();
    }

    /**
     * 编辑
     *
     * @param <@keyField/>
     * @param ${className?uncap_first}
     * @return
     */
    @PutMapping("/${className?uncap_first}/:id")
    public ResponseBean edit(@PathVariable <@keyTypeAndField/>, ${className} ${className?uncap_first}) {
        ${className?uncap_first}Service.update(${className?uncap_first});
        return ResponseFactory.getDefaultSuccessResponse();
    }

    /**
     * 删除
     *
     * @param <@keyField/>
     * @return
     */
    @DeleteMapping(value = "/${className?uncap_first}/:id")
    public ResponseBean remove(@PathVariable <@keyTypeAndField/>) {
        ${className?uncap_first}Service.deleteById(<@keyField/>);
        return ResponseFactory.getDefaultSuccessResponse();
    }

 }














