package com.example.demo.controller;

import com.example.demo.form.CalcForm;
import com.example.demo.validation.CalcValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {
    //유효성 검사를 하기 위해서 form-backing bean 설정이 필요함
    //<form> 태그 안에 input의 name="id" value="kslee" 바인딩되어서
    //Form 클래스 인스턴스(form-backing bean)라고 부르고, (이전에 전송된 값) 이것을 초기화 한 것이다.
    //@ModelAttribute 어노테이션을 부여해서 사용한다.
    @ModelAttribute //form-backing bean 초기화(들어있던 데이터들을 초기화)
    public CalcForm setUpForm(){
        return new CalcForm();
    }
    @GetMapping("show")
    public String showView(){
        return "entry";
    }
    @PostMapping("calc")
    public String confirmView(@Validated CalcForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "entry";
        }
        Integer result = form.getLeftNum() + form.getRightNum();
        model.addAttribute("result", result);
        return "confirm";
    }
    @Autowired
    CalcValidator calcValidator;

    @InitBinder("calcForm")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(calcValidator);
    }
}
