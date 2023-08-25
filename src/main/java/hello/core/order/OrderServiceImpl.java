package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
//메모리 repository와 고정 할인 정책을 구현체로 만들어서 사용하고 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
   // private final DiscountPolicy discountPolicy1=new RateDiscountPolicy();
    //여기에서 할인 정책을 바꾸기 위해서는 OCP원칙이 위배된당

    private DiscountPolicy discountPolicy;// 이렇게 작성하면 구체화에 의존하지 않고 추상화에 의존하기 때문에 DIP정책을 위반하지 않는다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);//주문 생성이 오면 findbyid를 통해 회원을 먼저 조회하고,
        int discountPrice = discountPolicy.discount(member,itemPrice);//할인 정책에 member를 넘김.


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
