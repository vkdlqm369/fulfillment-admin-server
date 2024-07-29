package com.daou.sabangnetserver.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/sample")
public class SampleController {


    @GetMapping(path = "/index")
    public String index() {
        // url : /sample/index
        // template location : src/main/resources/templates/index.html

        return "index";
    }

    @GetMapping(path = "/test")
    public String test() {
        // url : /sample/test
        // template location : src/main/resources/templates/sample/test.html

        // 이동될 템플릿의 경로를 리턴 (html 확장자 생략)
        return "sample/test";
    }


}
