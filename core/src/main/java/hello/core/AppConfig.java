package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {  // 역할들이 드러나는 것이 중요!!

    @Bean
    public MemberService memberService() {  // 멤버 서비스의 역할
        return new MemberServiceImpl(MemberRepository());  // 생성자 주입
    }

    @Bean
    public MemberRepository MemberRepository() {  // 멤버 레포지토리의 역할
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){  // 주문 서비스의 역할
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {  // 주문 정책의 역할
        return new RateDiscountPolicy();
    }
}
