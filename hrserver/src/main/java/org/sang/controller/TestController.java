package org.sang.controller;

import org.sang.bean.MongoItem;
import org.sang.bean.req.TestReq;
import org.sang.service.MongoDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 测试用Controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    MongoDaoService mongoDaoService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
        webDataBinder.registerCustomEditor(Date.class, "time", editor);
    }

    @RequestMapping(value = "/t1", method = RequestMethod.POST)
    public String getTest1(@RequestParam(name = "req") TestReq req) {
        System.out.println("thx-Test");
        req.getCodeList().forEach(System.out::println);
        return "1";
    }

    @RequestMapping(value = "/t2", method = RequestMethod.GET)
    public void getTest2(String[] name) {
        Arrays.stream(name).forEach(System.out::println);
    }

    @RequestMapping(value = "/insert-mongo/{name}", method = RequestMethod.GET)
    public boolean insertMongo(@PathVariable String name) {
        return mongoDaoService.insert(name);
    }

    @RequestMapping(value = "/find-mongo/{findName}", method = RequestMethod.POST)
    public MongoItem getMongo(@PathVariable String findName) {
        return mongoDaoService.find(findName);
    }
}
