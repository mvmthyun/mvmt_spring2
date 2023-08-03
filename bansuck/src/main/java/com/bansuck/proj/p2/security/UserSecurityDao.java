package com.bansuck.proj.p2.security;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bansuck.proj.p2.dto.MemberDto;

@Repository(value = "userSecurityDao")
public class UserSecurityDao {
    
    @Autowired
    SqlSession session;

    String namespace = "com.bansuck.proj.p2.mappers.MEMBER_psql.";

    public MemberDto getUserById(String memberId) {
        System.out.println(" :: UserSecurityDao :: memberId = " + memberId);
        return session.selectOne(namespace + "memberGetUserById", memberId);
    }

}
