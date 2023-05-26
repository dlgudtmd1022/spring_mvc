package com.spring.mvc.controller03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {

    @RequestMapping("/foodform")
    public String foodform(){
        return "/chap03/foodform";
    }

    @PostMapping("/foodorder")
    public ModelAndView foodOrder(String name, int num, String food ){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/chap03/foodresult");
        mv.addObject("name", name);
        mv.addObject("num", num);
        mv.addObject("food", food);
        return mv;
    }

    @RequestMapping("/naver")
    public String naver(){
        // 리다이엑트는 "redirect: 보낼주소", 형식으로 문자를 작성하면 실행됩니다.
        // 마치 a태그를 클릭하는 것처럼 자동으로 페이지를 보낼주소로 이동시킵니다.
        // 이 과정에서 포워딩과는 달리 modle.addAttribute()처럼 자료를 첨부해 이동시킬수는 없슨니다.
        // 하지만  get방식으로 이동하는 만큼 퀴리스트링을 붙여서 보내는 것은 가능합니다.
        return "redirect:https://naver.com";
    }
    @RequestMapping("/goFoodform")
    public String goFoodForm(Model model){
        // 리다이렉션은 model.addAttribute()를 통한 데이터 전송이 불가능합니다.
        model.addAttribute("title", "음식주문 키오스크");// tittle라는 이름으로 "음식주문 키오스크" 문자열 적재
        // http://loaclhost:8080/chap03/foodform 이라는 주소로 이동(리다이텍트이므로 파일지정지 아님)
        return "redirect:/chap03/foodform"; // 목적 파일로 포워딩하지 않고 목적 메서드 주소로 리다이렉트
            // WEB-INF/views/chap03/foodform.jsp 라는 목적 파일로 포워딩
//        return "/chap03/foodform"; // 목적 파일인 foodform.jsp로 적재 데이터도 보내
    }

    // 리다이렉트는 데이터 전달이 불가능한가요?
    // GET방식은 url에 쿼리스트링을 붙여서 데이터를 전송하기때문에
    // 리다이렉트 타겟 URL에 쿼리스트링을 붙여 리다이렉트를 수행하면 전달 가능합니다.
    @GetMapping("searchform")
    public String searchForm(){
        //  /WEB-INF/views/chap03/searchform.jsp
        return "/chap03/searchform";
    }

    // 네비어 쿼리를 받아서 리다이렉션 해주는 메서드 세팅
    @RequestMapping("research")
    public String reSearch(String query){// query라는 변수에 실려서 전송된 데이터 받기

        String resultPage =  "redirect:https://search.naver.com/search.naver?query=" + query;
        return resultPage;
    }
}
