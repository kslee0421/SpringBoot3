package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //리퀘스트 맵핑을 사용하게함
@RequestMapping("hello")  //hello를 치면 아래를 실행해
//@RequestMapping(value = {"hello","hellospring"})
public class HelloViewController {
    @GetMapping("view")
    //@GetMapping(value ={"view","viewspring"})
    public String helloView(){
        return "hello";  //hello html을 실행 :View
    }
    @GetMapping("view2")
    //@GetMapping(value ={"view","viewspring"})
    public String morning(){
        return "morning";  //hello html을 실행 :View
    }
}
