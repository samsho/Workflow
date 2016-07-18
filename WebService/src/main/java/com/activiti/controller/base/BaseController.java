package com.activiti.controller.base;


import com.activiti.service.LogService;

import javax.annotation.Resource;

/**
 * ClassName: BaseController
 * Description:
 * Date: 2016/5/14 13:14
 *
 * @author SAM SHO
 * @version V1.0
 */
public class BaseController {

    @Resource
    protected LogService logService;

}
