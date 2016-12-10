package com.activiti.controller.base;


import com.activiti.bean.base.User;
import com.activiti.entity.ActUser;
import com.activiti.service.LeaveBillService;
import com.activiti.service.LogService;
import com.activiti.service.WorkFlowService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Resource
    protected LeaveBillService leaveBillService;

    @Resource
    protected WorkFlowService workFlowService;


    protected ActUser getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(User.ATTRIBUTE);
        return new ActUser().bilud(user);
    }

}
