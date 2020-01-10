package com.mh.selenium.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.selenium.controllers
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 10:56
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Controller
public class IndexController {
    @GetMapping("index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("handle")
    public ModelAndView handle(ModelAndView mav){
        mav.setViewName("success");
        return mav;
    }
}
