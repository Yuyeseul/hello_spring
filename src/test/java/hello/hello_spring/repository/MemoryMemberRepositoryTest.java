package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("yeseul");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
        //System.out.println("result = "+(result==member));
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("yeseul1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yeseul2");
        repository.save(member2);

        Member result = repository.findByName("yeseul1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){ //맴버 전체 조회
        Member member1 = new Member();
        member1.setName("yeseul1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("yeseul2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
