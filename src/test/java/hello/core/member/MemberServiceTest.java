package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given: 어떤 상황이 주어졌을때
        Member member=new Member(1L,"memberA",Grade.VIP);
        //when

        memberService.join(member);
        Member findMember=memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);//join한거랑 찾은거랑 같은지 비교해줌
    }
}
