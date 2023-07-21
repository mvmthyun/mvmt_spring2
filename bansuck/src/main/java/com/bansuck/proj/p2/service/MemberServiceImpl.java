package com.bansuck.proj.p2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bansuck.proj.p2.dao.MemberDao;
import com.bansuck.proj.p2.dto.MemberDto;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Resource(name="memberDao")
    private MemberDao memberDao;
    
    public List<?> memberSelectListAll(MemberDto memberDto) throws Exception {
        return memberDao.memberSelectListAll(memberDto);
    }
    
    public MemberDto memberSelectOne(MemberDto memberDto) throws Exception {
        return memberDao.memberSelectOne(memberDto);
    }
    
}
