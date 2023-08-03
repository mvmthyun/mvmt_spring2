package com.bansuck.proj.p2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bansuck.proj.p2.dao.MemberDao;
import com.bansuck.proj.p2.dao.MemberRoleDao;
import com.bansuck.proj.p2.dto.MemberDto;
import com.bansuck.proj.p2.dto.MemberRoleDto;
import com.bansuck.proj.p2.security.UserEntity;
import com.bansuck.proj.p2.security.UserRoleEntity;
import com.bansuck.proj.p2.security.UserSecurityDao;
import com.bansuck.proj.p2.security.UserSecurityRoleDao;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;
    
    @Autowired
    MemberRoleDao memberRoleDao;
    
    public int memberInsert(MemberDto memberDto) throws Exception {
        return memberDao.memberInsert(memberDto);
    }
    
    public List<?> memberSelectListAll(MemberDto memberDto) throws Exception {
        return memberDao.memberSelectListAll(memberDto);
    }
    
    public MemberDto memberSelectOne(MemberDto memberDto) throws Exception {
        return memberDao.memberSelectOne(memberDto);
    }
    
    public int memberUpdateOne(MemberDto memberDto) throws Exception {
        return memberDao.memberUpdateOne(memberDto);
    }
    
    public int memberDeleteOne(MemberDto memberDto) throws Exception {
        return memberDao.memberDeleteOne(memberDto);
    }
    
    public int memberRoleInsert(MemberRoleDto memberRoleDto) throws Exception {
        return memberRoleDao.memberRoleInsert(memberRoleDto);
    }
    
    private final UserSecurityDao userSecurityDao;
    private final UserSecurityRoleDao userSecurityRoleDao;

    // @Service가 붙은 객체는 스프링이 자동으로 Bean으로 생성하는데
    // 기본생성자가 없고 아래와 같이 인자를 받는 생성자만 있을 경우 자동으로 관련된 타입이 Bean으로 있을 경우 주입해서 사용하게 된다.
    public MemberServiceImpl(UserSecurityDao userSecurityDao, UserSecurityRoleDao userSecurityRoleDao) {
        this.userSecurityDao = userSecurityDao;
        this.userSecurityRoleDao = userSecurityRoleDao;
    }
    
    @Override
    @Transactional
    public UserEntity getUser(String memberId) {
        System.out.println("getUser | userId = " + memberId);
        MemberDto memberDto = userSecurityDao.getUserById(memberId);
        System.out.println("getUser | userDto id = " + memberDto.getMemberId() + " pwd = " + memberDto.getMemberPassword());
        return new UserEntity(memberDto.getMemberId(), memberDto.getMemberPassword());
    }

    @Override
    @Transactional
    public List<UserRoleEntity> getUserRoles(String memberId) {
        System.out.println("getUserRoles | userId = " + memberId);
        List<MemberRoleDto> memberRoleDtos = userSecurityRoleDao.getRoleById(memberId);
        System.out.println("getUserRoles | userRoleDtos = " + memberRoleDtos);
        List<UserRoleEntity> list = new ArrayList<>();

        for(MemberRoleDto memberRoleDto : memberRoleDtos) {
            System.out.println("getUserRoles | userRoleDto = " + memberRoleDto);
            list.add(new UserRoleEntity(memberId, memberRoleDto.getRoleName()));
        }
        return list;
    }
    
}
