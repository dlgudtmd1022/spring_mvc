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

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("score")
//@AllArgsConstructor // 모든 필드를 초기화해주는 롬복 생성
@RequiredArgsConstructor // final 필드에 대해서 초기화하는 생성자
public class ScoreController {

    // repositoy 기능을 이용해 데이터를 가져와야 화면에 요청 데이터를 양식에 맞춰서 전달할 수 있습
    // @Autowired
    private final ScoreRepository repository;
    // 스프링 4.0 이후로 생성자가 하나인 경우에는 어노테이션 없이 자동주입


    // 1. 성적등록화면 띄우기 + 정보목록조회
    @GetMapping("/list")
    public String list(Model model){
        System.out.println("/score/list : GET방식");

        // repository 객체 내부의 전체글 조회기능을 이용해 자료를 받아서 scoreList변수에 저장해주세요.
        List<Score> scoreList = repository.findAll();
        System.out.println(scoreList);
        // 해당 성적 전체를 실어서 화면단으로 보낼 수 있게 적제하기
        model.addAttribute("scoreList", scoreList);
        // /WEB-INF/views/chap04/score-list.jsp
        return "chap04/score-list";
    }

    // 2. 성적 정보 등록 처리 요청
    @PostMapping("/register")
    public String register(Score score){
        System.out.println("/score/register : POST방식");
        System.out.println(score);
        // 추가해주는 로직을 작성해주세요.
        repository.save(score);
        // 추가 성공했으면 다시 목록페이지로 이동시키기
        return "redirect:/score/list";
    }
    // 3. 성적 정보 삭제 요청
    @PostMapping("/remove")
    public String remove(int studentNumber){
        System.out.println("/score/remove : POST방식");
        System.out.println("전달받은 학번 : " + studentNumber);
        // 글 삭제 후 list페이지로 넘어가도록 아래 코드를 작성하고 수정해주세요,
        repository.deleteByStudentNumber(studentNumber);
        return "redirect:/score/list";
    }

    // 2. 성적정보 상세 요청
    @GetMapping("/detail")
    public String detail(int studentNumber, Model model){
        System.out.println("/score/detail : GET방식");
        System.out.println("전달받은 studentNumber : " + studentNumber);
        // 래포지토리에서 Score객체를 받아서 저장하고.jsp파일로 보낼수 있게 적재
        Score score = repository.findByStudentNumber(studentNumber);
        System.out.println("위 번호로 가져온 학생 정보 :" + score);
        model.addAttribute("score", score);
        // /WEB-INF/views/chap04/detail
        return "chap04/detail";
    }
}
