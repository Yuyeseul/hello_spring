package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 스프링 데이터 JPA가 스프링 빈으로 자동 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
        Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
