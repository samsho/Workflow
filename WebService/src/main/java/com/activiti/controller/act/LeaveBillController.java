package com.activiti.controller.act;

import com.activiti.controller.base.BaseController;
import com.activiti.entity.ActLeaveBill;
import com.activiti.log.MethodAnnotation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**
 * ClassName: LeaveBillController
 * Description: 请假单
 * Date: 2016/7/21 16:55
 *
 * @author SAM SHO
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/act/leaveBill")
public class LeaveBillController extends BaseController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @MethodAnnotation(type = MethodAnnotation.MethodType.READ, desc = "请假单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap map) {
        map.addAttribute("leaveBills", leaveBillService.getList(-1, -1, null, null));
        return "act/leaveBill/leaveBill";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "/act/leaveBill/billAdd";
    }

    @MethodAnnotation(type = MethodAnnotation.MethodType.CREATE, desc = "请假单")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBill(ActLeaveBill leaveBill) {
        leaveBill.setUser(this.getUser());
        leaveBillService.save(leaveBill);
        return "redirect:/act/leaveBill/list";
    }


    @MethodAnnotation(type = MethodAnnotation.MethodType.OPERATE, desc = "请假单")
    @RequestMapping(value = "/startBill", method = RequestMethod.GET)
    public String startBill(String billId) {
        leaveBillService.startBill(billId, this.getUser().getUsername());
        return "redirect:/act/process/list";
    }

}
