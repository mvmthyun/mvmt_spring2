package com.bansuck.proj.p2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bansuck.proj.p2.dto.MemberDto;
import com.bansuck.proj.p2.service.MemberService;

@RestController
@RequestMapping("/api/member")
@CrossOrigin(origins = "*")
public class MemberApiController {

    private static final Logger logger = LoggerFactory.getLogger(MemberApiController.class);
    
    @Resource(name="memberServiceImpl")
    private MemberService memberService;
    
    @PostMapping("/login")
    public void apiLogin() {
        logger.info("(apiLogin) >>> info: {} ");
        
    }
    
    /**
     * @param memberDto
     * @return
     * @throws Exception 
     */
    @PostMapping("/signup")
    public MemberDto apiSignup(@RequestBody MemberDto memberDto) throws Exception {
        logger.info("(apiSignup) >>> memberDto: {} ", memberDto);
        
        List<MemberDto> roomList = new ArrayList<MemberDto>();
        roomList = (List<MemberDto>) memberService.memberSelectListAll(memberDto);
        logger.info("(apiSignup) >>> MemberDto List: {} ", roomList);
        
        return memberDto; // JSON
    }
    
    /**
     * @param memberDto
     * @return
     * @throws Exception
     */
    @PostMapping("/search")
    public MemberDto apiSearch(@RequestBody MemberDto memberDto) throws Exception {
        
        String email = memberDto.getMemberEmail();
        
        try {
            if(email == null || email.equals("")) {
                logger.error("(apiSearch) >>> error: email is null");
                throw new NullPointerException("Email is Null");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        System.out.println(memberDto.getMemberEmail());
        memberDto = memberService.memberSelectOne(memberDto);
        logger.info("(apiSignup) >>> MemberDto: {} ", memberDto);
        
        return memberDto;
    }
    
    /**
     * @param memberDto
     * @return
     * @throws Exception
     */
    @PostMapping("/update")
    public MemberDto apiUpdate(@RequestBody MemberDto memberDto) throws Exception {
        
        Function<Integer, String> resultLambda = result -> result == 1 ? "성공" : "실패";
        int result = memberService.memberUpdateOne(memberDto);
        logger.info("(apiUpdate) >>> memberUpdateOne: " + resultLambda.apply(result));
        
        return memberDto;
    }
    
    /**
     * @param memberDto
     * @return
     * @throws Exception
     */
    @PostMapping("/del")
    public MemberDto apiDelete(@RequestBody MemberDto memberDto) throws Exception {
        
        Function<Integer, String> resultLambda = result -> result == 1 ? "성공" : "실패";
        int result = memberService.memberDeleteOne(memberDto);
        logger.info("(apiDelete) >>> memberDeleteOne: " + resultLambda.apply(result));
        
        return memberDto;
    }
}
