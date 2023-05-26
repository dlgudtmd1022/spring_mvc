package com.spring.mvc.chap04.controller;

/*
    학생의 성적정보를 조회하고 등록하고, 삭제할 수 있는 시스템을 만들어보겠습니ㅏㄷ.

    요청 URL 종류

    1. 학생 성적정보 등록화면을 보여주고, 성적정보 목록조회 처리
    /score/list : GET방식(DB변경 없음)
    2. 성적정보 등록 처리 요청
    /score/register : POST방식(DB 변경 생김)
    3. 성적정보 삭제 요청
    /score/remove : POST방식(DB 변경 생김)
    4. 성적정보 상세 요청
    /score/detail : GET방식(DB변경 없음)
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("score")
public class ScoreController {

    // 1. 성적등록화면 띄우기 + 정보목록조회
    @GetMapping("/list")
    public String list(){
        System.out.println("/score/list : GET방식");
        return "";
    }

    // 2. 성적 정보 등록 처리 요청
    @PostMapping("/register")
    public String register(){
        System.out.println("/score/register : POST방식");
        return "";
    }
    // 3. 성적 정보 삭제 요청
    @PostMapping("/remove")
    public String remove(){
        System.out.println("/score/remove : POST방식");
        return "";
    }

    // 2. 성적정보 상세 요청
    @GetMapping("/detail")
    public String detail(){
        System.out.println("/score/detail : GET방식");
        return "";
    }
}
