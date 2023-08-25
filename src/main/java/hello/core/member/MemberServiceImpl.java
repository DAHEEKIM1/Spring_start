package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;//할당하는 부분이 구현체를 의존하는 것. (DIP를 위반하는 것)

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        //생성자를 통해서 이 memberRepository 구현체에 뭐가 들어갈지를
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
