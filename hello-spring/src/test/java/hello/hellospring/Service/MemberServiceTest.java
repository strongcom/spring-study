/*
package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

*/
/*
    MemberService memberService = new MemberService();
    // clear 해야하는 memberRepository 필요

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // 여기서 MemoryMemberRepository 객체를 memberService와 memberRepository에서 서로 다른 객체로 사용하기에 조금 애매한 점이 있음
    // 굳이 두 개를 다른 객체를 사용할 필요가 없음 (현재 static으로 공유를 하고 있기 때문에 오류가 발생하지 않지만 원래는 x)

*//*

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        // 같은 메모리리포지토리 사용가능(외부에서 적용) -> 이를 DI(Dependency Injection)->의존관계 주입이 라고 함
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    // test 코드에서는 과감하게 한국어로 바꿔서 사용!! -> 빌드시에 실제 코드에 포함하지 않음(테스트 코드)
    @Test
    void 회원가입() {

        // given -> 무언가 주어짐
        Member member = new Member();
        member.setName("hello");

        // when -> 이걸 실행했을 때
        Long saveId = memberService.join(member);

        // then -> 이렇게 된다(검증 부분)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // assertThrows 문법을 사용하여 람다에 만족하는 로직을 태울때 해당 예외(IllegalStateException)가 터져야함.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        */
/*
        try {
            memberService.join(member2);
            fail(); // 예외 발생하지 않아 실패
        } catch(IllegalStateException e) {  // 예외 발생이 제대로 실행 되었을 경우
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        *//*

        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}*/
