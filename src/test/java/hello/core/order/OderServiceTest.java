package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"aaa", Grade.Vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "bbb", 10000);
        Assertions.assertEquals(1000,order.getDiscountPrice());
    }
}
