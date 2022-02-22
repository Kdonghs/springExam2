package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10프로 할인이 적용되어야 한다.")
    void vip_O(){
        Member member = new Member(1L, "memberVIP", Grade.Vip);
        int discount = discountPolicy.discount(member,13000);
        assertEquals(discount,1300);
    }

    @Test
    @DisplayName("vip가 아니면 10프로 할인이 않된다.")
    void vip_x(){
        Member member = new Member(1L, "memberVIP", Grade.Basic);
        int discount = discountPolicy.discount(member,10000);
        assertEquals(discount,0);
    }
}