package com.activiti.controller.login;

import com.activiti.bean.base.User;
import com.activiti.entity.ActUser;
import com.activiti.service.UserService;
import com.activiti.utils.SidebarUtil;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * ClassName: LoginController
 * Description:  登录
 * date: 2015年4月30日 上午10:20:17
 *
 * @author sam sho
 * @version V1.0
 * @since JDK 1.7
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final String redirectAttribute = "url";

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLogin(HttpServletRequest request, ModelMap modelMap,
                              @RequestParam(value = redirectAttribute, required = false) String url) {
        if (isLogin(request)) {
            return "redirect:/";
        }

        modelMap.addAttribute(redirectAttribute, url);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(RedirectAttributesModelMap map, HttpServletRequest request,
                        @RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam(value = redirectAttribute, required = false) String url) {
        String error;
        try {
            ActUser actUser = userService.isExist(username, password);
            if (actUser == null) {
                logger.error("请先注册~~~~~");
                return "redirect:/login";
            }

            User user = new User(actUser.getId(), actUser.getJobNumber(), username);
            user.setSidebar(SidebarUtil.getSideBar());
            request.getSession().setAttribute(User.ATTRIBUTE, user);
            if (!Strings.isNullOrEmpty(url)) {
                if (!url.startsWith("/")) {
                    url = "/" + url;
                }
                return "redirect:" + url;
            } else {
                return "redirect:/";
            }
        } catch (Exception e) {
            logger.warn("登录失败", e);
            error = e.getMessage();
        }

        if (!Strings.isNullOrEmpty(url)) {
            map.addAttribute(redirectAttribute, url);
        }
        map.addFlashAttribute("error", error);

        return "redirect:/login";
    }

    @RequestMapping(value = "/logout")
    public String renderLogout(RedirectAttributesModelMap map, HttpServletRequest request) {
        request.getSession().removeAttribute(User.ATTRIBUTE);
        map.addFlashAttribute("error", "您已登出");
        return "redirect:/login";
    }

    private boolean isLogin(HttpServletRequest request) {
        return request.getSession().getAttribute(User.ATTRIBUTE) != null;
    }
}
