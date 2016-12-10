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
@RequestMapping(value = "/act/process")
public class ProcessController extends BaseController {

    final Logger logger = Logger.getLogger(this.getClass());


    @MethodAnnotation(type = MethodAnnotation.MethodType.READ, desc = "流程定义")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("ProcessDefines", workFlowService.getProcessDefines());
        return "act/process/process";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "act/process/processAdd";
    }

    @MethodAnnotation(type = MethodAnnotation.MethodType.CREATE, desc = "流程定义")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProcess(RedirectAttributesModelMap map, String processName, MultipartFile file) {

        try {
            workFlowService.deployed(processName, file);
            map.addFlashAttribute("success", "部署流程成功!!");
        } catch (IOException e) {
            map.addFlashAttribute("error", "部署流程失败!!");
            logger.error("部署流程失败", e);
        }
        return "redirect:/act/process/list";
    }


    /**
     * 查看流程定义的图
     * @param deploymentId
     * @param resourceName
     * @param response
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public void view(String deploymentId, String resourceName, HttpServletResponse response) {
        InputStream in = workFlowService.view(deploymentId, resourceName);
        int len = 0;
        byte[] buffer = new byte[1024];
        try {
            OutputStream out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            logger.error("查看流程定义的图失败", e);
        }
    }

}
