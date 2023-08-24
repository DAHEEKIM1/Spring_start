package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
//메모리 repository와 고정 할인 정책을 구현체로 만들어서 사용하고 있다.
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);//주문 생성이 오면 findbyid를 통해 회원을 먼저 조회하고,
        int discountPrice = discountPolicy.discount(member,itemPrice);//할인 정책에 member를 넘김.


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
