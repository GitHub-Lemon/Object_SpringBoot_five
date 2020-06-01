package cn.lemon.controller;

import cn.lemon.utils.CpachaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        model.addObject("name", "猛哥");
        return model;
    }

    /**
     * 登录页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model) {
        model.setViewName("system/login");
        return model;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, String> loginAct() {
        Map<String, String> ret = new HashMap<String, String>();
        return ret;
    }

    /**
     * 本系统所有的验证码均采用此方法
     *
     * @param vcodeLen
     * @param width
     * @param height
     * @param cpachaType：用来区分验证码的类型，传入字符串
     * @param request
     * @param response
     */
    @RequestMapping(value = "/get_cpacha", method = RequestMethod.GET)
    public void generateCpacha(
            @RequestParam(name = "vl", required = false, defaultValue = "4") Integer vcodeLen,
            @RequestParam(name = "w", required = false, defaultValue = "110") Integer width,
            @RequestParam(name = "h", required = false, defaultValue = "30") Integer height,
            @RequestParam(name = "type", required = true, defaultValue = "loginCpacha") String cpachaType,
            HttpServletRequest request,
            HttpServletResponse response) {
        CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);
        String generatorVCode = cpachaUtil.generatorVCode();
        //把验证码写入 Session
        request.getSession().setAttribute(cpachaType, generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
