package org.hdcd.devproject;

import org.hdcd.devproject.constant.Gender;
import org.hdcd.devproject.domain.Member;
import org.hdcd.devproject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testList01() {
        Iterable<Member> memberList = memberRepository.findAll();

        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    public void testList02() {
        List<Long> idList = new ArrayList<Long>();

        Long id1 = 1L;
        Long id2 = 2L;

        idList.add(id1);
        idList.add(id2);

        Iterable<Member> memberList = memberRepository.findAllById(idList);

        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    public void testModify() {
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setUserName("Alexander");

            memberRepository.save(member);
        }
    }

    @Test
    public void testRead() {
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            System.out.println(member);
        }
    }

    @Test
    public void testRegister01() {
        Member member1 = new Member();
        member1.setUserId("jupiter");
        member1.setUserPw("1234");
        member1.setUserName("Alex");

        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setUserId("venus");
        member2.setUserPw("4567");
        member2.setUserName("Olivia");

        memberRepository.save(member2);

        Member member3 = new Member();
        member3.setUserId("mercury");
        member3.setUserPw("9876");
        member3.setUserName("Tyler");

        memberRepository.save(member3);
    }

    @Test
    public void testRemove01() {
        memberRepository.deleteById(2L);
    }

    @Test
    public void testRemove02() {
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();

            memberRepository.delete(member);
        }
    }

    @Test
    public void testRemove03() {
        memberRepository.deleteAll();
    }

    @Test
    public void testRegister02() {
        List<Member> memberList = new ArrayList<Member>();

        Member member1 = new Member();
        member1.setUserId("jupiter");
        member1.setUserPw("1234");
        member1.setUserName("Alex");

        memberList.add(member1);

        Member member2 = new Member();
        member2.setUserId("venus");
        member2.setUserPw("4567");
        member2.setUserName("Olivia");

        memberList.add(member2);

        Member member3 = new Member();
        member3.setUserId("mercury");
        member3.setUserPw("9876");
        member3.setUserName("Tyler");

        memberList.add(member3);

        memberRepository.saveAll(memberList);
    }

}
