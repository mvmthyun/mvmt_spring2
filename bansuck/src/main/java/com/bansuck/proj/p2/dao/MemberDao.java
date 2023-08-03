package com.bansuck.proj.p2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bansuck.proj.p2.dto.MemberDto;

@Repository(value="memberDao")
public class MemberDao {

    @Autowired
    private SqlSession session;
    
    String nameSpace = "com.bansuck.proj.p2.mappers.MEMBER_psql.";

    public int memberInsert(MemberDto memberDto) throws Exception {
        return session.insert(nameSpace + "memberInsert", memberDto);
    }
    
    public List<?> memberSelectListAll(MemberDto memberDto) throws Exception {
        return session.selectList(nameSpace + "memberSelectListAll", memberDto);
    }
    
    public MemberDto memberSelectOne(MemberDto memberDto) throws Exception {
        return session.selectOne(nameSpace + "memberSelectOne", memberDto);
    }
    
    public int memberUpdateOne(MemberDto memberDto) throws Exception {
        return session.update(nameSpace + "memberUpdateOne", memberDto);
    }
    
    public int memberDeleteOne(MemberDto memberDto) throws Exception {
        return session.update(nameSpace + "memberDeleteOne", memberDto);
    }
}
