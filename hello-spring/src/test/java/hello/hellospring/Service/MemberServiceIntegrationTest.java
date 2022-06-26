package hello.hellospring.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 컨테이너와 테스트 실행
@Transactional  // 테스트 케이스에 이 애노케이션 존재시, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후 항상 롤백 -> DB에 데이터가 남지 않으므로 다음 테스트에 영향x
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

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

    }
}
