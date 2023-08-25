# 스프링 핵심원리 - 기본편
## 비즈니스 요구사항과 설계

### 회원
- 회원을 가입하고 조회할 수 있다.
- 회원은 일반과 VIP 두 가지 등급이 있다.
- 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.
### 주문과 할인 정책
- 회원은 상품을 주문할 수 있다.
- 회원 등급에 따라 할인 정책을 적용할 수 있다.
- 할인정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용하라(변경가능)
- 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책은 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다.


# 회원 도메인 설계
## 회원 도메인 요구사항
- 회원을 가입하고 조회할 수 있다.
- 회원은 일반과 VIP 두가지 등급이 있다.
- 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.

  ![image](https://github.com/DAHEEKIM1/Spring_start/assets/66730012/c4c34fd7-4507-4e3d-8a8f-ad3f3e3acafa)

### 그런데 해당 코드는 MemberRepository에서 
'''
private final MemberRepository memberRepository=new MemoryMemberRepository();
'''
부분에서 할당하는 부분이 구현체를 의존하는문제가 있다(DIP)

# 주문과 할인 도메인 설계
## 주문과 할인 정책
- 회원은 상품을 주문할 수 있다.
- 회원 등급에 따라 할인 정책을 적용할 수 있다.
- 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라
- 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 미룬다.


## 관심사의 분리
### AppConfig의 등장
- 애플리케이션의 전체 동작 방식을 구성(config)라기 위해, " 구현 객체를 생성" 하고, " 연결" 하는 책임을 가지는 별도의 클래스를 만들어 준다.
- AppConfig는 애플리케이션의 실제 동작에 필요한 " 구현 객체를 생성" 한다.
- AppConfig는 생성한 객체 인스턴스의 탐조를 " 생성자를 통해서 주입" 해준다.
- MemberServiceImpl-> MemoryMemberRepository
- OrderServiceImple-> MemoryMemberRepository, FixDiscountPolicy
