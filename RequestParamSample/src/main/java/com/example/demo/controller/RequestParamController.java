package com.example.demo.controller;

import com.example.demo.form.Form;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RequestParamController {
    @GetMapping("show")
//    주소창에서 실행 가능
    public String showView(){
        return "entry";
    }
    @PostMapping("confirm")
//    주소창에서 실행불가
    public String confirmView(Form f ){
        return "confirm2";
    }

}
