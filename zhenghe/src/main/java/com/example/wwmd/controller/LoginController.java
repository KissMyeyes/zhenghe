package com.example.wwmd.controller;

import com.example.wwmd.common.WwmdProperties;
import com.example.wwmd.domain.ResultView;
import com.example.wwmd.enums.ErrorCodeEnum;
import com.example.wwmd.model.User;
import com.example.wwmd.service.UserService;
import com.example.wwmd.util.MD5Utils;
import com.example.wwmd.util.vcode.Captcha;
import com.example.wwmd.util.vcode.GifCaptcha;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String CODE_KEY = "_code";

    @Autowired
    private WwmdProperties wwmdProperties;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultView login(String username, String password, String code, Boolean rememberMe) {
        if (StringUtils.isEmpty(code)) {
            return ResultView.newFailed(ErrorCodeEnum.PARAM_ERROR);
//            return ResultView.warn("验证码不能为空！");
        }
        Session session = super.getSession();
        String sessionCode = (String) session.getAttribute(CODE_KEY);
//        if (!code.equalsIgnoreCase(sessionCode)) {
//            return ResultView.newFailed(ErrorCodeEnum.PARAM_ERROR);
////            return ResultView.warn("验证码错误！");
//        }
        // 密码 MD5 加密
        password = MD5Utils.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            Subject subject = getSubject();
            if (subject != null)
                subject.logout();
            super.login(token);
//            this.userService.findUserByName(username);
            return ResultView.newSucess(null, null);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
//            return ResultView.error(e.getMessage());
            return ResultView.newFailed(ErrorCodeEnum.PARAM_ERROR);
        } catch (AuthenticationException e) {
//            return ResultView.error("认证失败！");
            return ResultView.newFailed(ErrorCodeEnum.PARAM_ERROR);
        }
    }

    @GetMapping(value = "gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(
                    wwmdProperties.getValidateCode().getWidth(),
                    wwmdProperties.getValidateCode().getHeight(),
                    wwmdProperties.getValidateCode().getLength());
            HttpSession session = request.getSession(true);
            captcha.out(response.getOutputStream());
            session.removeAttribute(CODE_KEY);
            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
        } catch (Exception e) {
            log.error("图形验证码生成失败", e);
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    //    @Log("访问系统")
    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过 Subject 获取登录的用户信息
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }
}
