package com.bansuck.proj.p2.security;

import java.util.List;

import org.springframework.stereotype.Service;

public interface UserDbService {
    
    public UserEntity getUser(String userId);

    public List<UserRoleEntity> getUserRoles(String loginUserId);

}
