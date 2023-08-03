package com.bansuck.proj.p2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bansuck.proj.p2.dto.MemberDto;
import com.bansuck.proj.p2.dto.MemberRoleDto;

@Repository(value="memberRoleDao")
public class MemberRoleDao {

    @Autowired
    private SqlSession session;
    
    String nameSpace = "com.bansuck.proj.p2.mappers.MEMBER_psql.";

    public int memberRoleInsert(MemberRoleDto memberRoleDto) throws Exception {
        return session.insert(nameSpace + "memberRoleInsert", memberRoleDto);
    }
    
}
