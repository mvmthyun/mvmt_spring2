package com.bansuck.proj.p2.controller;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bansuck.proj.p2.dto.MemberDto;
import com.bansuck.proj.p2.dto.MemberRoleDto;
import com.bansuck.proj.p2.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
// @WebAppConfiguration("file:src/main/webapp")
public class MemberApiControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(MemberApiControllerTest.class);

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testApiLogin() {
        fail("Not yet implemented");
    }

    @Test
    @Transactional
    public void testApiSignup() throws Exception {
//         fail("Not yet implemented");
        for(int i=0; i<100; i++) {
//            MemberSignUpDto memberSignUpDto = new MemberSignUpDto();
            MemberDto memberDto = new MemberDto();
            memberDto.setMemberId("qwe" + i);
            String ePwd = passwordEncoder.encode("qwe" + i);
            memberDto.setMemberPassword(ePwd);
            memberDto.setMemberEmail("qwe@" + i + ".com");
            memberDto.setMemberName("qwe" + i);
            memberDto.setMemberNumber("qwe" + i);
            memberDto.setMemberAddr("qwe@" + i);
            MemberRoleDto role = new MemberRoleDto();
            if(i <= 80) {
                role.setMemberEmail("qwe@" + i + ".com");
                role.setRoleName("BASIC");
                System.out.println("BASIC");
            }else if(i <= 90) {
                role.setMemberEmail("qwe@" + i + ".com");
                role.setRoleName("MANAGER");
                System.out.println("MANAGER");
            }else {
                role.setMemberEmail("qwe@" + i + ".com");
                role.setRoleName("ADMIN");
                System.out.println("ADMIN");
            }
//            memberSignUpDto.setMemberDto(memberDto);
//            memberSignUpDto.setMemberRoles(Arrays.asList(role));
//            memberService.memberInsertOne(memberSignUpDto);
            
            logger.info("(testApiSignup) >>> memberRoleDto: {} ", role);
            int result2 = memberService.memberRoleInsert(role);
            logger.info("(testApiSignup) >>> insert2: {} ", result2);
            
            logger.info("(testApiSignup) >>> memberDto: {} ", memberDto);
            int result1 = memberService.memberInsert(memberDto);
            logger.info("(testApiSignup) >>> insert1: {} ", result1);
        }
        
//        Assert.assertTrue(false);
    }

    @Test
    public void testApiSearch() throws Exception {
        MemberDto dto = new MemberDto();
        dto.setMemberEmail("qwer@qwer.com");
        logger.info("(testApiSearch) >>> search: {} ", dto);
        dto = memberService.memberSelectOne(dto);
        logger.info("(testApiSearch) >>> search: {} ", dto);
    }

    @Test
//    @Transactional
    public void testApiUpdate() throws Exception {
//        fail("Not yet implemented");
        
        for(int i=0; i<100; i++) {
          MemberDto memberDto = new MemberDto();
          String ePwd = passwordEncoder.encode("qwe" + i);
          memberDto.setMemberPassword(ePwd);
          memberDto.setMemberEmail("qwe@" + i + ".com");
          memberDto.setMemberName("qwe" + i);
          memberDto.setMemberNumber("qwe" + i);
          memberDto.setMemberAddr("qwe@" + i);
          
          logger.info("(testApiSignup) >>> memberDto: {} ", memberDto);
          int result = memberService.memberUpdateOne(memberDto);
          logger.info("(testApiSignup) >>> update: {} ", result);
      }
        
    }

    @Test
    public void testApiDelete() {
        fail("Not yet implemented");
    }

}
