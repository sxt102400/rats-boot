package ${ @tpl_controller.packageName};

<#include "global.ftl">

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ${@tpl_entity.packageName}.${className};
import ${@tpl_service.packageName}.${className}Service;
import ${page};
import ${pageable};
import com.rats.framework.common.base.BaseController;
import com.rats.framework.common.base.ResultBean;
 import com.rats.framework.common.page.PageHelper;


/** ${copyright}
 *
 * ${className}Controller
 * Description: ${table.remark!}
 *
 * @version : v1.0
 * @author : ${author!}
 * @since : ${now!}
 */

@RestController
@RequestMapping
public class ${className}Controller extends BaseController {

    @Autowired
    private ${className}Service ${className?uncap_first}Service;

<#if table.pkCount == 1>
    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/${className?uncap_first}/:<@pkField/>")
    public ResultBean getById(@PathVariable <@pkTypeAndField/>) {
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.selectByPrimaryKey(<@pkField/>);
        return successData(${className?uncap_first});
    }
</#if>

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param ${className?uncap_first}
     * @return
     */
    @GetMapping(value = "/${className?uncap_first}/list")
    public String doList(HttpServletRequest request, HttpServletResponse response, ${className} ${className?uncap_first}) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = ${className?uncap_first}Service.selectPage(${className?uncap_first}, pageable);
            return page.toJSONString();
            }

<#if table.pkCount == 1>
    /**
     * 编辑
     *
     * @param id
     * @param ${className?uncap_first}
     * @return
     */
    @PutMapping(value = "/${className?uncap_first}/:<@pkField/>")
    public ResultBean doEdit(@PathVariable <@pkTypeAndField/>, ${className} ${className?uncap_first}) {
        ${className?uncap_first}Service.updateByPrimaryKeySelective(${className?uncap_first});
            return successData(null);
    }
</#if>

    /**
     * 保存
     *
     * @param ${className?uncap_first}
     * @return
     */
    @PostMapping(value = "/${className?uncap_first}")
    public ResultBean doSave(${className} ${className?uncap_first}) {
        ${className?uncap_first}Service.save(${className?uncap_first});
        return successData(null);
    }


<#if table.pkCount == 1>
    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/${className?uncap_first}/:<@pkField/>")
    @ResponseBody
    public ResultBean update(@PathVariable <@pkTypeAndField/>) {
        ${className?uncap_first}Service.deleteByPrimaryKey(<@pkField/>);
        return successData(null);
    }

</#if>


}
