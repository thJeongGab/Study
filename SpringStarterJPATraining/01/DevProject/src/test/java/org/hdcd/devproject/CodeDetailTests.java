package org.hdcd.devproject;

import org.hdcd.devproject.domain.CodeDetail;
import org.hdcd.devproject.domain.CodeGroup;
import org.hdcd.devproject.repository.CodeDetailRepository;
import org.hdcd.devproject.repository.CodeGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CodeDetailTests {

    @Autowired
    CodeDetailRepository codeDetailRepository;

    @Autowired
    CodeGroupRepository codeGroupRepository;

    @Test
    public void testList() {
        Iterable<CodeDetail> codeDetailList = codeDetailRepository.findAll();

        for (CodeDetail codeDetail : codeDetailList) {
            System.out.println(codeDetail);
        }
    }

    @Test
    public void testListWithCodeGroup() {
        Iterable<CodeDetail> codeDetailList = codeDetailRepository.findAll();

        for (CodeDetail codeDetail : codeDetailList) {
            System.out.println(codeDetail);

            CodeGroup codeGroup = codeDetail.getCodeGroup();
            if (codeGroup != null) {
                System.out.println(codeGroup);
            }
        }
    }

    @Test
    public void testModify() {
        Optional<CodeDetail> codeDetailOptional = codeDetailRepository.findById(1L);

        if (codeDetailOptional.isPresent()) {
            CodeDetail codeDetail = codeDetailOptional.get();

            System.out.println(codeDetail);

            codeDetail.setCodeName("Architect");

            codeDetailRepository.save(codeDetail);
        }
    }

    @Test
    public void testRead() {
        Optional<CodeDetail> codeDetailOptional = codeDetailRepository.findById(1L);

        if (codeDetailOptional.isPresent()) {
            CodeDetail codeDetail = codeDetailOptional.get();

            System.out.println(codeDetail);
        }
    }

    @Test
    public void testRegister_X() {
        CodeGroup codeGroup = new CodeGroup();
        codeGroup.setGroupCode("A01");
        codeGroup.setGroupName("job");

        CodeDetail codeDetail1 = new CodeDetail();
        codeDetail1.setCodeValue("00");
        codeDetail1.setCodeName("Developer");
        codeDetail1.setCodeGroup(codeGroup);

        codeDetailRepository.save(codeDetail1);

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCodeValue("01");
        codeDetail2.setCodeName("Designer");
        codeDetail2.setCodeGroup(codeGroup);

        codeDetailRepository.save(codeDetail2);
    }

    @Test
    public void testRegisterWithCodeGroup() {
        CodeGroup codeGroup = new CodeGroup();
        codeGroup.setGroupCode("A01");
        codeGroup.setGroupName("job");

        codeGroupRepository.save(codeGroup);

        CodeDetail codeDetail1 = new CodeDetail();
        codeDetail1.setCodeValue("00");
        codeDetail1.setCodeName("Developer");
        codeDetail1.setCodeGroup(codeGroup);

        codeDetailRepository.save(codeDetail1);

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCodeValue("01");
        codeDetail2.setCodeName("Designer");
        codeDetail2.setCodeGroup(codeGroup);

        codeDetailRepository.save(codeDetail2);
    }

    @Test
    public void testRemove() {
        codeDetailRepository.deleteById(1L);
    }

    @Test
    public void testRemoveAll() {
        codeDetailRepository.deleteAll();
    }

}
