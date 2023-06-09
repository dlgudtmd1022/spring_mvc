package com.spring.mvc.chap04;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap04.repository.ScoreRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThat;
=======
>>>>>>> d4a29ca79343b4a8c54f0e5b7c69c7a9943c4315

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreRepositoryTest {

    // 테스트 대상인 ScoreRepositoryuImpl 클래스를 상단에 선언해 둡니다.
<<<<<<< HEAD
    ScoreRepository repository;
=======
    ScoreRepository repository = new ScoreRepositoryImpl();
>>>>>>> d4a29ca79343b4a8c54f0e5b7c69c7a9943c4315

    @Test
    public void ScoreRepositoryStaticVarTest(){
        // 접근 제한자가 public으로 풀려있는 돟안만 실행가능 정상적으로 데이터가 들어왔는지 확인
//        System.out.println(ScoreRepositoryImpl.scoreMap);
//        System.out.println(ScoreRepositoryImpl.sequence);
    }
<<<<<<< HEAD
    // TDD 방법
    // 1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해 둔다.
    // 2. 테스트 코드 내부에 원하는 기능대호 작성되었을때 어떤 결과가 나올지 단언해둔다.
    // 3. 테스트가 통과될때까지, 원본 클래스를 수정하면서 계속 테스트 해본다.
    @Test
    public void findAllTest(){
        // GWT 패턴(AAA패턴)
        // GIVEN (테스트를 위해 사전에 설정해야 하는 데티어를 선언하는 구간)
        // findAll은 특별한 조건없이 전체 데이터를 가져오므로 GIVEN이 없습니다.

        // WHEN (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성함)
        List<Score> result = repository.findAll();

        // THEN (테스트 결과가 이렇게 나올것이다 라는 단언을 합니다.)
        // 나는 result 내부에 3개의 score가 있다고 단언한다
        // scoreMap에 사전설정응로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
        // System.out.println(result.size() == 3);
        assertEquals(3,result.size());
    }

    @Test
    @DisplayName("저장소에서 2번 유저를 가져와서 이름과 국어성적 비교")
    public void findByStudentNumberTest(){
        // given (2번 학생의 정보가 실제 정보와 일치하는지 체크할 예정임)
        int studentNumber = 2;
        // when (2번 학생정보를 넣어 findBystydentNumber를 호출하고, 결과는 result에 젖아
        Score result = repository.findByStudentNumber(studentNumber);
        // then(단언부에는 2개 이상의 단언문이 들어가도 상관 없음)
        // 2번 유저를 얻어 왔으므로, getter로 국어성적 조사시 33점 일것이다.
        assertEquals( 33, result.getKorScore());
        // 2번 유저를 얻어왔으므로, getter로 이름 조사시 "이바자"일것이다.
        assertEquals("이부트", result.getName());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어햐함")
    public void notFindByStudentNumberTest(){
        // given
        int studentNumber = 99;
        // when
        Score result = repository.findByStudentNumber(studentNumber);
        // then
        assertNull(result); // 대상 변수가 null이면 통과
    }
    @Test
    @DisplayName("새로운 성적정보를 저장하면 전체 데이터의 개수는 4개가 된다.")
    public void saveTest(){
        //given
        Score score = new Score();
        score.setName("티디디");
        score.setKorScore(100);
        score.setEngScore(70);
        score.setMathScore(80);
        // when
        boolean boolResult = repository.save(score);
        List<Score> result = repository.findAll(); // 저장한 수 전체 데이터 가져오기
        // then
        assertEquals(4, result.size());
        assertTrue(boolResult); // 실행이 잘 되면 true, 뭔가 오류나면 false
    }

    @DisplayName("저장소에서 2번 학생 삭제 후 리스트 전체조회시 개수는 2개, 2번학생 조회는 null")
    @Test
    public void  deleteTest(){
        // given 학생 번호를 저장합니다.
        int studentNumber = 2;
        // when 해당 번호 학생을 삭제합니다. 그리고 finlAll()로 전체 데이터를 가져오고, 2번학생만 가져오기도 다시 합니다.
        repository.deleteByStudentNumber(studentNumber);
        List<Score> scoreList = repository.findAll(); // 2개만 가져와짐
        Score score = repository.findByStudentNumber(studentNumber); // null
        // then 전체 목록의 길이는 2일것이고, score변수에는 null이 담긴다고 단언
        assertThat(2).isEqualTo(scoreList.size());
        assertNull(score);
    }


}
=======
        // TDD 방법
        // 1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해 둔다.
        // 2. 테스트 코드 내부에 원하는 기능대호 작성되었을때 어떤 결과가 나올지 단언해둔다.
        // 3. 테스트가 통과될때까지, 원본 클래스를 수정하면서 계속 테스트 해본다.
        @Test
        public void findAllTest(){
            // GWT 패턴(AAA패턴)
            // GIVEN (테스트를 위해 사전에 설정해야 하는 데티어를 선언하는 구간)
            // findAll은 특별한 조건없이 전체 데이터를 가져오므로 GIVEN이 없습니다.

            // WHEN (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성함)
            List<Score> result = repository.findAll();

            // THEN (테스트 결과가 이렇게 나올것이다 라는 단언을 합니다.)
            // 나는 result 내부에 3개의 score가 있다고 단언한다
            // scoreMap에 사전설정응로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
            // System.out.println(result.size() == 3);
            assertEquals(3,result.size());
    }

        @Test
        @DisplayName("저장소에서 2번 유저를 가져와서 이름과 국어성적 비교")
        public void findByStudentNumberTest(){
            // given (2번 학생의 정보가 실제 정보와 일치하는지 체크할 예정임)
            int studentNumber = 2;
            // when (2번 학생정보를 넣어 findBystydentNumber를 호출하고, 결과는 result에 젖아
            Score result = repository.findByStudentNumber(studentNumber);
            // then(단언부에는 2개 이상의 단언문이 들어가도 상관 없음)
            // 2번 유저를 얻어 왔으므로, getter로 국어성적 조사시 33점 일것이다.
            assertEquals( 33, result.getKorScore());
            // 2번 유저를 얻어왔으므로, getter로 이름 조사시 "이바자"일것이다.
            assertEquals("이부트", result.getName());
        }

        @Test
        @DisplayName("없는 번호로 조회시 null이어햐함")
        public void notFindByStudentNumberTest(){
            // given
            int studentNumber = 99;
            // when
            Score result = repository.findByStudentNumber(studentNumber);
            // then
            assertNull(result); // 대상 변수가 null이면 통과
    }
        @Test
        @DisplayName("새로웆 성적정보를 저장하면 전체 데이터의 개수는 4개가 된다.")
        public void saveTest(){
            //given
            Score score = new Score();
            score.setName("티디디");
            score.setKorScore(100);
            score.setEngScore(70);
            score.setMathScore(80);
            // when
            boolean boolResult = repository.save(score);
            List<Score> result = repository.findAll(); // 저장한 수 전체 데이터 가져오기
            // then
            assertEquals(4, result.size());
            assertTrue(boolResult); // 실행이 잘 되면 true, 뭔가 오류나면 false
        }
}
>>>>>>> d4a29ca79343b4a8c54f0e5b7c69c7a9943c4315
