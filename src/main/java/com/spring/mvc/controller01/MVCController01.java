package com.spring.mvc.controller01;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCController01 {

    // 특정 주소로 접속했을때 처리할 로직을 작성합니다.
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("/hello 접속 감지!!!!!");
        // 어떤 .jsp파일과 연동할지 return구문에 문자열로 파일이름을 적어줌
        // prefix였던 /WEB-INF/viewx와 suffix였던 .jsp를 앞뒤로 붙여서
        // 최종적으로 열리는 파일은 /WEB-INF/views/hello.jsp
        return "hello";
    }

    @RequestMapping("/abc")
    public String bcd(){
        // def.jsp 출력
        return "def";
    }

    @GetMapping("/getreq")
    public String getreq(){
        System.out.println("get방식 요청을 감지했습니다!");
        return "reqview";
    }

    @PostMapping("/postreq")
    public String getPost(){
        System.out.println("post방식 요청을 감지했습니다!");
        return "reqview";
    }
}
