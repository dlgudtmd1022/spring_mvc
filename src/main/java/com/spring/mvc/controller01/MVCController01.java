package com.spring.mvc.controller01;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chap01") // 해당 클래스 내부에서는 모두 /chap01 을 구차적으로 붙여야지 진입가능
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
    /*
        요청 파라미터 읽어오기(Query String = Get 방식, RequestBody = POST 방식)
        1. HttpSevletReuest사용하기(원시적인 JSP에서 쓰는 방법)
        /person?name=kim&age=30
     */
    @RequestMapping("/person")
    public  String  person(HttpServletRequest request){
        String name = request.getParameter( name = "name");
        // http 전송 방식세서는 모든 파라미터의 자료형이 문자로 통일됩니다. 그래서 나이도 문자로 받습니다.
        String age = request.getParameter( name = "age");

        System.out.println("name파라미터 전송값 : " + name);
        System.out.println("age파라미터 전송값 : " + age);
        return "";
    }

    /*
        2. @RequestParam 사용하기
        /major?stu=kim&major=computerscience&gpa=3.4
        메서드 선언부에 파라미터와 자료형을 입력하고, 왼쪽에 @RequestParam("가져올변수명") 입력
     */

    @RequestMapping("/major")   // 파라미터 입력안쇨디 기본값 지정도 가능
    public String major(@RequestParam(defaultValue = "null")String stu,@RequestParam(defaultValue = "0.0") double gpa, @RequestParam("major")String 전공){
        System.out.println("stu 파라미터에 저장된 값 : " + stu);
        System.out.println("gpa 파라미터에 저장된 값 : " + gpa);
        System.out.println("gpa가 만점에서 몇 점 모자란지 : " + (4.5 - gpa));
        System.out.println("major라는 명칭으로 전달된 '전공' 변수 : " + 전공);
        return "";
    }

    /*
    3. 커멘드 객체 이용하기
    연관된 자료를 한 번에 처리해야 하는경우 외부에 class를 하나 만들고 그 클래스를 파라미터로 주면
    외부 클래스의 내부 맴버변수명이 전부 매핑되어 주입됨.
     */
    @RequestMapping("notebook") // NotebookDTO의 맴버변수명칭으로 들어오는 파라미터를 자동대입
                    // modelName, price, ram, ssd 명칭으로 들어오는 걸 받아줌.
    public String notebook(NotebookDTO notebook){
        System.out.println("파라미터로 전달받은 NotebookTDO 내부 : " + notebook);
        return "";
    }

    /*
        임의의 객체를 만들어서, 맴버변수명으로 파라미터로 전달받아 콘솔창에 직어주세요.
     */

    @RequestMapping("/human")
    public String human(HumanInfo human){
        System.out.println("파리미터로 전달받은 HumanInfo 내부 : " + human);
        return "";
    }

    /*
        4. URL에 경로로 붙어있는 데이터 읽어오기
        /board/103
        게시판의 103번 글을 읽고 싶음
     */
    @RequestMapping("/baord/{bNo}") // 패턴과 동일한 이름의 변수를 파라미터 선언부에 선언 후
    public String board(@PathVariable int bNo){ // 왼쪽에 @PathVariable을 붙여줍니다.
        System.out.println("경로를 받아온 bNo의 값 : " + bNo);
        return "";
    }

    // /membet/회원이름/회원번호
    // 패턴으로 파라미터를 처리하도록 만들어주세요.
    // 회원이름은 mName, 회원번호는 mNo 명칭을 사용합니다.

    @RequestMapping("/member/{mName}/{mNo}")
    public String memnber(@PathVariable String mName, @PathVariable String mNo){
        System.out.println("회원이름 : " + mName + " / 회원번호 : " + mNo);
        return "";
    }

    // 데이터를 보낼 때는 URL에 직접 파라미터를 붙여서 보내게 하는 대신
    // 당연히 폼이라는 양식을 제공하고, 거기에 대해서 적절한 처리를 하는
    // 처리 메서드를 만들게 됩니다.
    @RequestMapping("/catform")
    public String catForm(){
        System.out.println("고양이를 등록할 수 있는 폼으로 연결해드립니다.");
        // 파일명 앞에 /를 붙이면 폴더지정도 할 수 있음.
        return "/chap01/catform";
    }

    // catform에서 보낸 데이터를 처리해주는 페이지 생성
    @PostMapping("/cat") // hool://localhost:8080/cat 패턴생성
    public String cat(String name, int age, String kind){
        System.out.println("등록할 고양이 이름 : " + name);
        System.out.println("등록할 고양이 나이 : " + age);
        System.out.println("등록할 고양이 품종 : " + kind);
        // chap1 폴더 내부에 catreg,jsp로 연결되도록해주세요.
        return "/chap01/catreg";
    }

    // 아이디, 비밀번호를 각각 id, pw라는 name에 실어서 전달해주는 폼을 생성해주세요.
    // chap01 폴더 내에 loginform.jsp로 지정해주세요.
    @RequestMapping("/loginform")
    public String loginform(){
        return "/chap01/loginform";
    }

    @RequestMapping("/login")
    public String login(String id, String pw){
        System.out.println("로그인성공 ");
        System.out.println(id);
        System.out.println(pw);
        return "/chap01/loginok";
    }
}
