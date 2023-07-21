package com.bansuck.proj.p2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bansuck.proj.p2.dto.MemberDto;

@Service
public interface MemberService {

    /**
     * 사용자 정보 전체 조회
     * @param memberDto
     * @return
     * @throws Exception
     */
    public List<?> memberSelectListAll(MemberDto memberDto) throws Exception;
    
    /**
     * 사용자 단일 정보 조회
     * @param memberDto.getMemberEmail
     * @return
     * @throws Exception
     */
    public MemberDto memberSelectOne(MemberDto memberDto) throws Exception;
    
}
