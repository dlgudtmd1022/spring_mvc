package com.spring.mvc.controller01;

import lombok.Data;

@Data // 자동으로 getter, setter, 생ㅅㅇ자 등을 만들어줍니다.
public class NotebookDTO {

    // 커맨드 객체 패턴으로 컨트롤러의 파라미터로 처리하는 경우
    // 반드시 세터와 기본생성자가 만들어져 있어야 작동하는데
    // 위쪽에 롬복의 @Data 어노테이션을 이용해 생성해둔 상태임
    private String modelNmae;
    private int price;
    private int ssd;
    private int ram;
}

