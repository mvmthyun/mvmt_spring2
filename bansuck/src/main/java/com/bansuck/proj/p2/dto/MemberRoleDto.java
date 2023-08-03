package com.bansuck.proj.p2.dto;

public class MemberRoleDto {

    private String memberEmail;
    private String roleName;
    
    public MemberRoleDto() {}
    
    public String getMemberEmail() {
        return memberEmail;
    }
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "MemberRoleDto [MemberEmail=" + memberEmail + ", RoleName="
                + roleName + "]";
    }
    
}
