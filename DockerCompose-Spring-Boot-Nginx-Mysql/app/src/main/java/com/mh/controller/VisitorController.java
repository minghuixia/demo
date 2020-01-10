package com.mh.controller;

import com.mh.entity.Visitor;
import com.mh.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.controller
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 11:09
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@RestController
public class VisitorController {
    @Autowired
    private VisitorRepository repository;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Visitor visitor = repository.findByIp(ip);
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1);
        } else {
            visitor.setTimes(visitor.getTimes() + 1);
        }
        repository.save(visitor);
        return "I have been seen ip " + visitor.getIp() + " " + visitor.getTimes() + " times.";
    }
}
