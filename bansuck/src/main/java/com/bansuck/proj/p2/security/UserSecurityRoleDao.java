package com.bansuck.proj.p2.security;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bansuck.proj.p2.dto.MemberRoleDto;

import java.util.List;

@Repository(value = "userSecurityRoleDao")
public class UserSecurityRoleDao {
    
    @Autowired
    SqlSession session;

    String namespace = "com.bansuck.proj.p2.mappers.MEMBER_psql.";
    
    public List<MemberRoleDto> getRoleById(String memberId) {
        System.out.println(" :: UserSecurityRoleDao :: userId = " + memberId);
        return session.selectList(namespace + "memberGetRoleByIdLogin", memberId);
    }

}
