package hello.hellospring.Controller;

import hello.hellospring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링 컨테이너에 등록 - 그효과는 뒤에서 설명
    // Autowired는 컨테이너에서 멤버 서비스를 가져옴(여기서 @Service와 @Repository를 선언해주어야 실행됨)
    // -> 단순 자바코드는 스프링이 실행을 할 수 없음
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
