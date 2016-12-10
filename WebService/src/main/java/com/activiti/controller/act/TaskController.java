package com.activiti.controller.act;

import com.activiti.controller.base.BaseController;
import com.activiti.log.MethodAnnotation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ClassName: ProcessController
 * Description: 流程定义
 * Date: 2016/7/22 10:38
 *
 * @author SAM SHO
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/act/task")
public class TaskController extends BaseController {

    final Logger logger = Logger.getLogger(this.getClass());


    @MethodAnnotation(type = MethodAnnotation.MethodType.READ, desc = "流程定义")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("ProcessDefines", workFlowService.getProcessDefines());
        return "act/task/task";
    }

}
